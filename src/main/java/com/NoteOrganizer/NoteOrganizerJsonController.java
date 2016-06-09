package com.NoteOrganizer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 * Created by Justins PC on 5/23/2016.
 */
@RestController
public class NoteOrganizerJsonController {
    @Autowired
    NoteRepository notes;

    @Autowired
    UserRepository users;

    @RequestMapping(path = "/notes.json", method = RequestMethod.GET)
    public ArrayList<Note> jsonHome() {
        ArrayList<Note> noteList = new ArrayList<Note>();
        Iterable<Note> allNotes = notes.findAll();
        for (Note note : allNotes) {
            noteList.add(note);
        }

        return noteList;
    }

    ArrayList<Note> getAllNotes() {
        ArrayList<Note> noteList = new ArrayList<Note>();
        Iterable<Note> allNotes = notes.findAll();
        for (Note note : allNotes) {
            noteList.add(note);
        }

        return noteList;
    }

    @RequestMapping(path = "/toggleNote.json", method = RequestMethod.GET)
    public ArrayList<Note> toggleNote(int noteID) {
        System.out.println("toggling note with ID " + noteID);
        Note note = notes.findOne(noteID);
        note.noteName = "**" + note.noteName;
        notes.save(note);

        return getAllNotes();
    }

    @RequestMapping(path = "/deleteNote.json", method = RequestMethod.GET)
    public  ArrayList<Note> deleteNote(int noteID) throws Exception {
        System.out.println("Delete note with ID " + noteID);
//        Note note = notes.findOne(noteID);
        notes.delete(noteID);

        return getAllNotes();
    }

    @RequestMapping(path = "/addNote.json", method = RequestMethod.POST)
    public ArrayList<Note> addNote(HttpSession session,@RequestBody Note note) throws Exception {

        notes.save(note);

        return getAllNotes();
    }

    @RequestMapping(path = "/getUser.json", method = RequestMethod.POST)
    public User getUser(HttpSession session, Model model) throws Exception {
        User user = (User)session.getAttribute("user");
        System.out.println(user);
        return user;
    }


}
