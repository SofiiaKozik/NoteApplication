package com.example.Note;

import com.example.Note.services.NoteService;
import com.example.Note.services.impl.NoteServiceImpl;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NoteApplication implements CommandLineRunner {

	@Autowired
	private NoteService noteService;

	public static void main(String[] args) {
		SpringApplication.run(NoteApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(noteService.listAll());

		Note note1 = new Note();
		note1.setTitle("Six of crows");
		note1.setContent("Kaz, Inej, Jasper");
		System.out.println(noteService.add(note1));
		Note note2 = new Note();
		note2.setTitle("A Court of Thorns and Roses");
		note2.setContent("Ryz, Casian, Azriel");
		System.out.println(noteService.add(note2));
		System.out.println(noteService.listAll());
		//noteService.deleteById(1);
		//System.out.println(noteService.listAll());
		Note note1_1 = new Note();
		note1_1.setID(0l);
		note1_1.setTitle("From blood and ash");
		note1_1.setContent("Poppy, Castel, Kieran, Delano");
		noteService.update(note1_1);
		System.out.println(noteService.listAll());
		System.out.println(noteService.getById(0));
	}
}