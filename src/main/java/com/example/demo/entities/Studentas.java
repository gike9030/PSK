package com.example.demo.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Studentas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String pavarde;
    private String vardas;

    @ManyToOne
    private Grupe grupe;

    @ManyToMany
    @JoinTable(name = "studentas_kursas",
            joinColumns = @JoinColumn(name = "studentas_id"),
            inverseJoinColumns = @JoinColumn(name = "kursas_id"))
    private List<PasirenkamasKursas> pasirenkamiKursai = new ArrayList<>();

    // Constructors
    public Studentas() {}

    public Studentas(String pavarde, String vardas) {
        this.pavarde = pavarde;
        this.vardas = vardas;
    }

    public List<PasirenkamasKursas> getPasirenkamiKursai() {
        return pasirenkamiKursai;
    }

    public void setPasirenkamiKursai(List<PasirenkamasKursas> pasirenkamiKursai) {
        this.pasirenkamiKursai = pasirenkamiKursai;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPavarde() {
        return pavarde;
    }

    public void setPavarde(String pavadinimas) {
        this.pavarde = pavadinimas;
    }

    public String getVardas() {
        return vardas;
    }

    public void setVardas(String vardas) {
        this.vardas = vardas;
    }

    public Grupe getGrupe() {
        return grupe;
    }

    public void setGrupe(Grupe grupe) {
        this.grupe = grupe;
    }

    @Override
    public String toString() {
        return "Studentas{" +
                "id=" + id +
                ", pavadinimas='" + pavarde + '\'' +
                ", vardas='" + vardas + '\'' +
                ", grupe=" + (grupe != null ? grupe.getId() : "null") +
                '}';
    }
}
