package com.company;

import javax.persistence.*;

/**
 * Created by Troy on 10/23/16.
 */
@Entity
@Table(name = "microblog")
public class Message {
    @Id
    @GeneratedValue
    int id;

    @Column(nullable = false)
    String text;

    @Column(nullable = false)
    String author;

    public Message(String text, String author) {
        this.text = text;
        this.author = author;
    }

    public Message(int id, String text, String author) {
        this.id = id;
        this.text = text;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public String getAuthor() {
        return author;
    }

    public Message() {
    }
}
