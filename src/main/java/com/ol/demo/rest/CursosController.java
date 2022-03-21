package com.ol.demo.rest;

import com.ol.demo.entity.Cursos;
import com.ol.demo.services.CursosJpaController;
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
public class CursosController {
    
    private CursosJpaController cjs;

    @Autowired
    public CursosController(CursosJpaController cjs) {
        this.cjs = cjs;
    }  
    
    
    @GetMapping("/curso/{id}")
    public Cursos curso(@PathVariable("id")int id){       
       return cjs.findCursos(id);      
    }
    
    @GetMapping("/cursos")
    public List<Cursos> cursos(){
        return cjs.findCursosEntities();
    }
 
    @PostMapping("/curso")
    public Cursos createCurso(@RequestBody Cursos curso){
        cjs.create(curso);
        return curso;
    }
    
    @PutMapping("/curso")
    public Cursos actualizarCurso(@RequestBody Cursos curso){
        
        try{
            cjs.edit(curso);
            return curso;
        }catch(Exception ex){
            System.out.println("Error: "+ex);
            return null;
        }
    }
    
    @DeleteMapping("/curso/{id}")
    public String borrarCurso(@PathVariable("id")int id){
        try {
            cjs.destroy(id);
            return "{\"message\":\"El objeto ha sido borrado satisfactoriamente\"}";
        } catch (Exception e) {
            return "{\"message\":\"El objeto no ha sido borrado\"}";
        }
        
        
    }
    
    /*  
         
     @DeleteMapping("/curso/{nombre}")
     public String borrarCurso(@PathVariable("nombre")String nombre){
         cjs.borrarCurso(nombre);
         return "borrado";
     }
    */
     
}
