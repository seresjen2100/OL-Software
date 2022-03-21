package com.ol.demo.rest;

import com.ol.demo.entity.Prueba;
import com.ol.demo.services.PruebaJpaController;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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
public class ControladorRest {
    
    private PruebaJpaController pjs;
    
    @Autowired
    public ControladorRest(PruebaJpaController pjs) {
        this.pjs = pjs;
    }
    
    @GetMapping("/")
    public String saludo(){
        return "hola";
    }
    
    /*
    //Leer prueba mediante si ID
    @GetMapping("/prueba/{id}")
    public Prueba pruebas(@PathVariable("id")int id){       
        Prueba prueba = pjs.prueba(id);
        return prueba;
    }
    
    //Leer Pruebas
    @GetMapping("/pruebas")
    public List<Prueba> pruebas(){
        return pjs.pruebas();
    }
    
    //Actualizar pruebas
    @PutMapping("/prueba")
    public Prueba actualizarPrueba(@RequestBody Prueba prueba){
        pjs.actualizarPrueba(prueba);
        return prueba;
    }
    
    //Crear prueba
    @PostMapping("/prueba")
    public Prueba guardarPrueba(@RequestBody Prueba prueba){
      
        prueba.setId(0);
        pjs.guardarPrueba(prueba);
        return prueba;
    }
    
    //Borrar prueba
    @DeleteMapping(value="/prueba/{id}")
    public String borrarPrueba(@PathVariable("id")int id){
        pjs.borrarPrueba(id);
        return "borrado";
    }
    */
}
