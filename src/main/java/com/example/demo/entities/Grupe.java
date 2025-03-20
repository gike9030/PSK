package com.example.demo.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Grupe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int kursas;
    private String specialybe;

    @OneToMany(mappedBy = "grupe", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Studentas> studentai = new ArrayList<>(); // ✅ Initialize to avoid NullPointerException

    // Constructors
    public Grupe() {}

    public Grupe(int kursas, String specialybe) {
        this.kursas = kursas;
        this.specialybe = specialybe;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getKursas() {
        return kursas;
    }

    public void setKursas(int kursas) {
        this.kursas = kursas;
    }

    public String getSpecialybe() {
        return specialybe;
    }

    public void setSpecialybe(String specialybe) {
        this.specialybe = specialybe;
    }

    public List<Studentas> getStudentai() {
        return studentai;
    }

    public void setStudentai(List<Studentas> studentai) {
        this.studentai = studentai;
    }

    @Override
    public String toString() {
        return "Grupe{" +
                "id=" + id +
                ", kursas=" + kursas +
                ", specialybe='" + specialybe + '\'' +
                ", studentai=" + studentai +
                '}';
    }
}
