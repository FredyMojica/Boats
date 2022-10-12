package com.boats.model;

import javax.persistence.*;

@Entity
@Table(name="message")

public class MessageModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String messageText;

    public MessageModel() {
    }

    public MessageModel(String messageText) {
        this.messageText = messageText;
    }

    public MessageModel(Integer id, String messageText) {
        this.id = id;
        this.messageText = messageText;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    @Override
    public String toString() {
        return "MessageModel{" +
                "id=" + id +
                ", messageText='" + messageText + '\'' +
                '}';
    }
}
