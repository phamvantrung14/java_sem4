package com.example.springbootonetomanybidirectionalrestmysql.jpa.dto;

import com.example.springbootonetomanybidirectionalrestmysql.jpa.Library;

public class BookDto {
    private int id;
    private String name;
    private Library library;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }
}
