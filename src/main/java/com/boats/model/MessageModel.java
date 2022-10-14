package com.boats.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="message")
@NoArgsConstructor
@Getter
@Setter

public class MessageModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMessage;
    private String messageText;

    @ManyToOne
    @JoinColumn(name = "idBoat")
    @JsonIgnoreProperties({"messages", "clients", "reservations"})
    private BoatModel boat;

    @ManyToOne
    @JoinColumn(name = "clientId")
    @JsonIgnoreProperties({"messages", "clients", "reservations"})
    private ClientModel client;

}
