package com.example.demo.mybatis.mappers;

import com.example.demo.entities.PasirenkamasKursas;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PasirenkamasKursasMapper {

    @Select("SELECT * FROM pasirenkamas_kursas")
    List<PasirenkamasKursas> findAll();

    @Insert("INSERT INTO pasirenkamas_kursas (pavadinimas) VALUES (#{pavadinimas})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(PasirenkamasKursas kursas);

    @Select("SELECT * FROM pasirenkamas_kursas WHERE id = #{id}")
    PasirenkamasKursas findById(@Param("id") Long id);
}
