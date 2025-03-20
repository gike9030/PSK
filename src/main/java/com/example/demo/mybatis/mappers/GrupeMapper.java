package com.example.demo.mybatis.mappers;

import com.example.demo.entities.Grupe;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface GrupeMapper {

    @Select("SELECT * FROM grupe")
    List<Grupe> findAll();

    @Select("SELECT * FROM grupe WHERE id = #{id}")
    Grupe findById(@Param("id") Long id);

    @Insert("INSERT INTO grupe (kursas, specialybe) VALUES (#{kursas}, #{specialybe})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(Grupe grupe);

    @Update("UPDATE grupe SET kursas = #{kursas}, specialybe = #{specialybe} WHERE id = #{id}")
    void update(Grupe grupe);

    @Delete("DELETE FROM grupe WHERE id = #{id}")
    void delete(@Param("id") Long id);
}
