package com.news.grm.pojo;

import java.util.Date;

public class GrmNews {

    private Integer id;
    private GrmCategory grmCategory;
    private String author;
    private String title;
    private String content;
    private Date createdDate;


    @Override
    public String toString() {
        return "GrmNews{" +
                "id=" + id +
                ", grmCategory=" + grmCategory +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", createdDate=" + createdDate +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public GrmCategory getGrmCategory() {
        return grmCategory;
    }

    public void setGrmCategory(GrmCategory grmCategory) {
        this.grmCategory = grmCategory;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
