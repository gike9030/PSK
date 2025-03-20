package com.example.demo.beans;

import com.example.demo.entities.Studentas;
import com.example.demo.dao.GrupeDAO;
import com.example.demo.entities.Grupe;
import com.example.demo.services.StudentasService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class StudentasBean {

    @Inject
    private StudentasService studentasService;

    private Studentas naujasStudentas;
    private GrupeDAO grupeDAO;

    public StudentasBean() {
        // ✅ Initialize naujasStudentas and ensure it has a Grupe instance
        naujasStudentas = new Studentas();
        Grupe existingGrupe = grupeDAO.findById(naujasStudentas.getGrupe().getId());
        naujasStudentas.setGrupe(existingGrupe);
    }

    public List<Studentas> getStudentai() {
        return studentasService.getAllStudentsJpa();
    }

    public Studentas getNaujasStudentas() {
        return naujasStudentas;
    }

    public void setNaujasStudentas(Studentas naujasStudentas) {
        this.naujasStudentas = naujasStudentas;
    }

    public void pridetiStudenta() {
        // ✅ Ensure a new student has a group before adding
        if (naujasStudentas.getGrupe() == null) {
            naujasStudentas.setGrupe(new Grupe());
        }
        studentasService.addStudentJpa(naujasStudentas);
        // ✅ Reset form after adding
        naujasStudentas = new Studentas();
        naujasStudentas.setGrupe(new Grupe());
    }
}
