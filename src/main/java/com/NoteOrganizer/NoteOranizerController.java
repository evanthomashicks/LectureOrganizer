package com.NoteOrganizer;

import org.hibernate.annotations.Cache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Justins PC on 5/22/2016.
 */
@Controller
public class NoteOranizerController {
    @Autowired
    NoteRepository notes;
    @Autowired
    UserRepository users;

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String login(HttpSession session, String userEmail,String userPassword) throws Exception {
        User user = users.findByEmail(userEmail);
        if (user == null) {
            user = new User(userEmail,userPassword);
            users.save(user);
        } else if(!userPassword.equals(user.getPassword())) {
            throw new Exception("Incorrect password");
        }
        session.setAttribute("user",user);
        return "redirect:/notes";
    }

    @RequestMapping(path = "/logout", method = RequestMethod.POST)
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home(Model model,HttpSession session) {
        if (session.getAttribute("user") != null) {
            model.addAttribute("user",session.getAttribute("user"));
        }
        Iterable<Note> allNotes = notes.findAll();
        List<Note> noteList = new ArrayList<>();
        for (Note note : allNotes){
            noteList.add(note);
        }
        model.addAttribute("notes", noteList);
        return "home";
    }
    @RequestMapping(path = "/add-note", method = RequestMethod.POST)
    public String addNote(HttpSession session,String noteName,String noteSubject,String noteCode,String noteTag) {
        User user = (User) session.getAttribute("user");
        Note note = new Note(noteName,noteSubject,noteCode,noteTag,user);
        notes.save(note);
        return "redirect:/";
    }

    @RequestMapping(path = "/notes", method = RequestMethod.GET)
    public String games(Model model, HttpSession session) {
        return "notes";
    }

//    @RequestMapping(path = "/login", method = RequestMethod.GET)
//    public  String login(M)




//    @RequestMapping(path = "/searchBySubject", method = RequestMethod.GET)
//    public String queryNotesBySubject(Model model, String search) {
//        System.out.println("Searchning by... " + search);
//        List<Note> noteList = notes.findBySubject(search);
//        model.addAttribute("notes",noteList);
//        return "home";
//    }
}
