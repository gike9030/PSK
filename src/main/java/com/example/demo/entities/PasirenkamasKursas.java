package com.example.demo.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pasirenkamas_kursas")
public class PasirenkamasKursas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String pavadinimas;

    @ManyToMany(mappedBy = "pasirenkamiKursai")
    private List<Studentas> studentai = new ArrayList<>();

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPavadinimas() {
        return pavadinimas;
    }

    public void setPavadinimas(String pavadinimas) {
        this.pavadinimas = pavadinimas;
    }

    public List<Studentas> getStudentai() {
        return studentai;
    }

    public void setStudentai(List<Studentas> studentai) {
        this.studentai = studentai;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PasirenkamasKursas kursas = (PasirenkamasKursas) o;
        return id != null ? id.equals(kursas.id) : kursas.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

}
