package com.garden.little.modal;

import javax.persistence.Entity;

@Entity(name = "contact_info")
public class ContactInfo {
  Integer contactId;
  String email;
  String name;
  String subject;
  String message;

  public ContactInfo() {}

  @Override
  public String toString() {
    return "ContactInfo{"
        + "email='"
        + email
        + '\''
        + ", name='"
        + name
        + '\''
        + ", subject='"
        + subject
        + '\''
        + ", message='"
        + message
        + '\''
        + '}';
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSubject() {
    return subject;
  }

  public void setSubject(String subject) {
    this.subject = subject;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public ContactInfo(String email, String name, String subject, String message) {
    this.email = email;
    this.name = name;
    this.subject = subject;
    this.message = message;
  }
}
