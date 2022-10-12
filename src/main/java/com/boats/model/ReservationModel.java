package com.boats.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "reservation")
public class ReservationModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;
    private Date startDate;
    private Date devolutionDate;

    public ReservationModel() {
    }

    public ReservationModel(Date startDate, Date devolutionDate) {
        this.startDate = startDate;
        this.devolutionDate = devolutionDate;
    }

    public ReservationModel(Integer id, Date startDate, Date devolutionDate) {
        this.id = id;
        this.startDate = startDate;
        this.devolutionDate = devolutionDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getDevolutionDate() {
        return devolutionDate;
    }

    public void setDevolutionDate(Date devolutionDate) {
        this.devolutionDate = devolutionDate;
    }

    @Override
    public String toString() {
        return "ReservationModel{" +
                "id=" + id +
                ", startDate=" + startDate +
                ", devolutionDate=" + devolutionDate +
                '}';
    }
}
