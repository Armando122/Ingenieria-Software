package com.example.proyecto.repositorio;

import com.example.proyecto.dto.NotaDto;
import com.example.proyecto.modelo.Nota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NotaRepositorio extends JpaRepository<Nota, Long> {

    List<Nota> findAllById(Integer idNota);

    @Query("select n from Nota n where n.idNota = ?1")
    Optional<Nota> findNotaById(Integer idNota);
}
