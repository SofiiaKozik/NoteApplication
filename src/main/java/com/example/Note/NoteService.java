package com.example.Note;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class NoteService {
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
