package com.example.Note.services;

import com.example.Note.Note;
import org.springframework.stereotype.Service;

import java.util.List;


public interface NoteService {
    public List<Note> listAll();

    public Note add(Note note);

    public void deleteById(long id);

    public void update(Note note);

    public Note getById(long id);

}
