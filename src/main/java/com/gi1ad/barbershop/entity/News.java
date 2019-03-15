package com.gi1ad.barbershop.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.CreationTimestamp;
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

    @Column(name = "header", nullable = false, length = 80 )
    private String header;

    @CreationTimestamp
    @Column(name = "news_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date newsDate;

    @Column(name = "text", nullable = false,length = 200)
    private String text;


    @Column (name = "news_image", nullable = false)
    private byte[] newsImage;

    public byte[] getNewsImage() {
        return newsImage;
    }

    public void setNewsImage(byte[] newsImage) {
        this.newsImage = newsImage;
    }

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

    public Date getNewsDate() {
        return newsDate;
    }

    public void setNewsDate(Date newsDate) {
        this.newsDate = newsDate;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
