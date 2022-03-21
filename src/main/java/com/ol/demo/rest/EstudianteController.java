package com.ol.demo.rest;

import com.ol.demo.entity.Estudiantes;
import com.ol.demo.services.EstudiantesJpaController;
//import com.ol.demo.services.EstudiantesJpaServices;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author user
 */
@RestController
@RequestMapping("/api")
public class EstudianteController {
    
    private EstudiantesJpaController estudiantesJpaController;

    @Autowired
    public EstudianteController(EstudiantesJpaController estudiantesJpaController) {
        this.estudiantesJpaController = estudiantesJpaController;
    }  
    
    @GetMapping("/estudiante/{id}")
    public Estudiantes estudiante(@PathVariable("id")int id){       
       return estudiantesJpaController.findEstudiantes(id);
    }
    
    @GetMapping("/estudiantes")
    public List<Estudiantes> estudiantes(){       
        List<Estudiantes> estudiantes = estudiantesJpaController.findEstudiantesEntities() ;
        return estudiantes;
    }
    
    @PutMapping("/estudiante")
    public Estudiantes actualizarEstudiante(@RequestBody Estudiantes estudiante){
        
        try {
            estudiantesJpaController.edit(estudiante);
            return estudiante;
        } catch (Exception e) {
            System.err.println("El Estudiante no ha podido ser actualizado");
            return null;
        }   
    }
    
    @PostMapping("/estudiante")
    public Estudiantes grabarEstudiante(@RequestBody Estudiantes estudiante){
        try {
            estudiantesJpaController.edit(estudiante);
            return estudiante;
        } catch (Exception e) {
            System.out.println("El estudiante no ha podido ser actualizado");
            return null;
        }
    }
    
    @DeleteMapping("/estudiante/{id}")
    public String borrarEstudiante(@PathVariable("id") int id){
        try {
             estudiantesJpaController.destroy(id);
             return "{\"message\":\"El estudiante ha sido borrado con exito\"}";
        } catch (Exception e) {
             return "{\"message\":\"El estudiante no pudo ser borrado\"}";   
        }
    }
    /*
    @PostMapping("/estudiante")
     public Estudiantes grabarEstudiante(@RequestBody Estudiantes estudiante){
         estudiante.setId(0);
         ejs.guardarEstudiante(estudiante);
         return estudiante;
     }
    
     @PutMapping("/estudiante")
     public Estudiantes estudiante(@RequestBody Estudiantes estudiante){
         ejs.actualizarEstudiante(estudiante);
         return estudiante;
     }
     
     @DeleteMapping("/estudiante/{id}")
     public String borrarEstudiante(@PathVariable("id")int id){
         ejs.borrarEstudiantes(id);
         return "borrado";
     }
    */
}
