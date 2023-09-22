package com.example.Note.services.impl;

import com.example.Note.Note;
import com.example.Note.services.NoteService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class NoteServiceImpl implements NoteService {
    Map<Long, Note> noteMap = new HashMap<>();
    Long id = 0L;
    public List<Note> listAll() {
        List <Note> noteList = new ArrayList<>(noteMap.values());
        return noteList;
    }

    public Note add(Note note) {
        note.setID(id++);
        noteMap.put(note.getID(), note);
        return note;
    }

    public void deleteById(long id) {
        idChecker(id);
        noteMap.remove(id);
    }

    public void update(Note note) {
        long id = note.getID();
        idChecker(id);
        noteMap.put(id, note);
    }

    public Note getById(long id) {
        idChecker(id);
        return noteMap.get(id);
    }

    private void idChecker(long id){
        if (!noteMap.containsKey(id)) {
            throw new IllegalArgumentException("Note with id " + id + " not found");
        }
    }
}
