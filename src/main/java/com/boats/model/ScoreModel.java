package com.boats.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "score")
public class ScoreModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String messageText;
    private Integer stars;

    public ScoreModel() {
    }

    public ScoreModel(String messageText, Integer stars) {
        this.messageText = messageText;
        this.stars = stars;
    }

    public ScoreModel(Integer id, String messageText, Integer stars) {
        this.id = id;
        this.messageText = messageText;
        this.stars = stars;
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

    public Integer getStars() {
        return stars;
    }

    public void setStars(Integer stars) {
        this.stars = stars;
    }

    @Override
    public String toString() {
        return "ScoreModel{" +
                "id=" + id +
                ", messageText='" + messageText + '\'' +
                ", stars=" + stars +
                '}';
    }
}
