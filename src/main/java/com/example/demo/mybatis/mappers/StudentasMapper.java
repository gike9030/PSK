package com.example.demo.mybatis.mappers;

import com.example.demo.entities.Studentas;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StudentasMapper {

    @Select("SELECT s.id, s.pavadinimas, s.vardas, s.grupe_id, g.kursas, g.specialybe " +
            "FROM studentas s LEFT JOIN grupe g ON s.grupe_id = g.id")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "pavadinimas", column = "pavadinimas"),
            @Result(property = "vardas", column = "vardas"),
            @Result(property = "grupe.id", column = "grupe_id"),
            @Result(property = "grupe.kursas", column = "kursas"),
            @Result(property = "grupe.specialybe", column = "specialybe")
    })
    List<Studentas> findAll();

    @Insert("INSERT INTO studentas (pavadinimas, vardas, grupe_id) " +
            "VALUES (#{pavadinimas}, #{vardas}, #{grupe.id})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(Studentas studentas);
}

