package com.example.proyecto.controlador;

import com.example.proyecto.repositorio.NotaRepositorio;
import com.example.proyecto.servicio.NotaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@Controller
@RequestMapping("/notas")
public class NotasControlador {

    /*Atributos*/
    private final NotaServicio notaServicio;

    @Autowired
    NotaControlador(NotaServicio notaServicio){
        this.notaServicio = notaServicio;
    }

    @GetMapping("/agregar")
    public String agregarNota(){
        return "nueva_nota";
    }

    @PostMapping("/agregar")
    public String registra(HttpServletRequest request, Model model){
        Competidor nuevoCompetidor = new Competidor(
                request.getParameter("nombre"),
                request.getParameter("disciplina")
        );
        competidorServicio.agregaCompetidor(nuevoCompetidor);
        model.addAttribute("competidores", competidorServicio.getCompetidores());
        return "competidor/consultar";
    }

    @GetMapping("/eliminar")
    public String eliminarCompetidor(Model model){
        model.addAttribute("competidores",competidorServicio.getCompetidores());
        return "competidor/eliminar";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarCompetidor(@PathVariable("id") Long id, Model model){
        model.addAttribute("competidor", competidorServicio.getCompetidor(id));
        return "competidor/eliminarcompetidor";
    }

    @PostMapping("/eliminar")
    public String borra(HttpServletRequest request, Model model){
        competidorServicio.eliminaCompetidor(Long.parseLong(request.getParameter("id")));
        model.addAttribute("competidores",competidorServicio.getCompetidores());
        return "competidor/eliminar";
    }

    @GetMapping("/consultar")
    public String consultaCompetidor(Model model){
        model.addAttribute("competidores",competidorServicio.getCompetidores());
        return "competidor/consultar";
    }

    @GetMapping("/actualizar")
    public String actualizaCompetidor(Model model){
        model.addAttribute("competidores",competidorServicio.getCompetidores());
        return "competidor/actualizar";
    }

    @GetMapping("/actualizar/{id}")
    public String actualizaCompetidor(@PathVariable("id") Long id, Model model){
        model.addAttribute("competidor",competidorServicio.getCompetidor(id));
        return "competidor/actualizarcompetidor";
    }

    @PostMapping("/actualizar")
    public String actualiza(HttpServletRequest request, Model model){
        competidorServicio.actualizaCompetidor(Long.parseLong(request.getParameter("id")),
                request.getParameter("nombre"),
                request.getParameter("disciplina"));
        model.addAttribute("competidores", competidorServicio.getCompetidores());
        return "competidor/actualizar";
    }

}
