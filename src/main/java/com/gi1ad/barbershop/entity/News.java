package com.gi1ad.barbershop.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table (name = "news")
public class News {

    @Id
    @GeneratedValue (generator = "increment")
    @GenericGenerator(name = "increment",strategy = "increment")
    private long id;

    @Column(name = "header", nullable = false, length = 30)
    private String header;

    @Column(name = "date", nullable = false)
    private Date date;

    @Column(name = "text", nullable = false,length = 80)
    private String text;

    public News(){

    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
