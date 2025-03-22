package com.example.demo.mybatis.mappers;

import com.example.demo.entities.Studentas;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StudentasMapper {

    @Select("SELECT s.id, s.pavarde, s.vardas, s.grupe_id, g.kursas, g.specialybe " +
            "FROM studentas s LEFT JOIN grupe g ON s.grupe_id = g.id")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "pavarde", column = "pavarde"),
            @Result(property = "vardas", column = "vardas"),
            @Result(property = "grupe.id", column = "grupe_id"),
            @Result(property = "grupe.kursas", column = "kursas"),
            @Result(property = "grupe.specialybe", column = "specialybe"),
            @Result(property = "pasirenkamiKursai", column = "id",
                    many = @Many(select = "com.example.demo.mybatis.mappers.PasirenkamasKursasMapper.findByStudentId"))
    })
    List<Studentas> findAll();

    @Insert("INSERT INTO studentas (pavarde, vardas, grupe_id) " +
            "VALUES (#{pavarde}, #{vardas}, #{grupe.id})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(Studentas studentas);

    @Insert("INSERT INTO studentas_kursas (studentas_id, kursas_id) VALUES (#{studentId}, #{kursasId})")
    void insertStudentoKursas(@Param("studentId") Long studentId, @Param("kursasId") Long kursasId);
}

