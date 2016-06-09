package com.NoteOrganizer;

import javax.persistence.*;

/**
 * Created by Justins PC on 5/22/2016.
 */
@Entity
@Table(name="notes")
public class Note {

    @ManyToOne
    User user;

    @Id
    @GeneratedValue
    int id;

    @Column(nullable = false)
    String noteName;

    @Column(nullable = false)
    String noteSubject;

    @Column (nullable = false)
    String noteTag;

    @Column (nullable = false)
    String noteCode;

    public Note() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNoteName() {
        return noteName;
    }

    public void setNoteName(String noteName) {
        this.noteName = noteName;
    }

    public String getNoteSubject() {
        return noteSubject;
    }

    public void setNoteSubject(String noteSubject) {
        this.noteSubject = noteSubject;
    }

    public String getNoteTag() {
        return noteTag;
    }

    public void setNoteTag(String noteTag) {
        this.noteTag = noteTag;
    }

    public String getNoteCode() {
        return noteCode;
    }

    public void setNoteCode(String noteCode) {
        this.noteCode = noteCode;
    }

    public Note(String noteName, String noteSubject, String noteTag, String noteCode,User user) {
        this.noteCode = noteCode;
        this.noteName = noteName;
        this.noteSubject = noteSubject;
        this.noteTag = noteTag;
        this.user = user;

    }

}

