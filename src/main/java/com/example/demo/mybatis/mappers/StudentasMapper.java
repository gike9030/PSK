package com.example.demo.mybatis.mappers;

import com.example.demo.entities.Studentas;
import org.apache.ibatis.annotations.*;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;
@ApplicationScoped
@Mapper
public interface StudentasMapper {

    @Select("SELECT * FROM studentas WHERE id = #{id}")
    Studentas findById(@Param("id") Long id);

    @Select("SELECT * FROM studentas")
    List<Studentas> findAll();

    @Insert("INSERT INTO studentas (pavadinimas, vardas, grupe_id) VALUES (#{pavadinimas}, #{vardas}, #{grupe.id})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(Studentas studentas);

    @Update("UPDATE studentas SET vardas = #{vardas}, pavadinimas = #{pavadinimas} WHERE id = #{id}")
    void update(Studentas studentas);

    @Delete("DELETE FROM studentas WHERE id = #{id}")
    void delete(@Param("id") Long id);
}
