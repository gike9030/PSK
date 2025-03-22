package com.example.demo;

import com.example.demo.entities.Grupe;
import com.example.demo.mybatis.mappers.GrupeMapper;

import javax.enterprise.inject.spi.CDI;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("grupeConverter")
public class GrupeConverter implements Converter {

    private GrupeMapper grupeMapper;

    public GrupeConverter() {
        grupeMapper = CDI.current().select(GrupeMapper.class).get();
    }

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
        if (value == null || value.isEmpty()) {
            return null;
        }
        Long id = Long.valueOf(value);
        return grupeMapper.findById(id); // must guarantee this returns correct group
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
        if (value == null || !(value instanceof Grupe)) {
            return "";
        }
        return ((Grupe) value).getId().toString();
    }
}
