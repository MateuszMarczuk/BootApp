package com.marczuk.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

/**
 * Created by Mateusz Marczuk
 * Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 08.03.2018.
 */
@Data
@Entity
public class Task {

    @Id
    @GeneratedValue
    private Long id;

    @NotEmpty
    private String date;

    @NotEmpty
    private String startTime;

    private String stopTime;

    @NotEmpty
    private String description;

    @ManyToOne
    @JoinColumn(name = "USER_EMIAL")
    private User user;

    public Task(@NotEmpty String date, @NotEmpty String startTime, String stopTime, @NotEmpty String description) {
        this.date = date;
        this.startTime = startTime;
        this.stopTime = stopTime;
        this.description = description;
    }

    public Task() {
    }
}
