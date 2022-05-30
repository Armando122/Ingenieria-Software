package com.example.proyecto.servicio;

import com.example.proyecto.modelo.Nota;
import com.example.proyecto.repositorio.NotaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class NotaServicio {

    private final NotaRepositorio notaRepositorio;

    @Autowired
    public NotaServicio(NotaRepositorio notaRepositorio){
        this.notaRepositorio = notaRepositorio;
    }

    public List<Nota> getNotas(){
        return notaRepositorio.findAll();
    }

    public Nota getNota(Long notaId){
        return notaRepositorio.findById(notaId)
                .orElseThrow(() -> new IllegalStateException("No existe"));
    }

    public void agregaNota(Nota nota){
        String titulo = nota.getTitulo();
        notaRepositorio.save(nota);
    }

    public void eliminaNota(Long notaId){
        boolean exists = notaRepositorio.existsById(notaId);
        if (!exists){
            String advertencia = "Nota con Id: " + notaId + "no existe.";
            throw new IllegalStateException(advertencia);
        }
        notaRepositorio.deleteById(notaId);
    }
}
