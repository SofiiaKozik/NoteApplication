package com.example.Note;

import jdk.jfr.DataAmount;
import lombok.Data;

@Data
public class Note {
    private Long ID;
    private String title;
    private String content;
}
