package com.garden.little.modal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;

@Entity(name = "blog")
public class Blog {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  Integer blogId;

  String author;
  String content;
  String title;
  Date date;

  @Override
  public String toString() {
    return "Blog{"
        + "blogId="
        + blogId
        + ", author='"
        + author
        + '\''
        + ", content='"
        + content
        + '\''
        + ", title='"
        + title
        + '\''
        + ", date="
        + date
        + '}';
  }

  public Blog() {}

  public Blog(Integer blogId, String author, String content, String title, Date date) {
    this.blogId = blogId;
    this.author = author;
    this.content = content;
    this.title = title;
    this.date = date;
  }

  public Integer getBlogId() {
    return blogId;
  }

  public void setBlogId(Integer blogId) {
    this.blogId = blogId;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }
}
