package com.example.demo.services;

import com.example.demo.entities.PasirenkamasKursas;
import com.example.demo.mybatis.mappers.PasirenkamasKursasMapper;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;

@ApplicationScoped
public class PasirenkamasKursasServiceMyBatis implements Serializable {

    @Inject
    private PasirenkamasKursasMapper kursasMapper;

    public List<PasirenkamasKursas> getAllKursai() {
        return kursasMapper.findAll();
    }

    public void addKursas(PasirenkamasKursas kursas) {
        kursasMapper.insert(kursas);
    }

    public PasirenkamasKursas findById(Long id) {
        return kursasMapper.findById(id);
    }
}
