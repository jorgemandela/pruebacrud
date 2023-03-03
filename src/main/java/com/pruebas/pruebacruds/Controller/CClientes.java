package com.pruebas.pruebacruds.Controller;


import com.pruebas.pruebacruds.Entity.Clientes;
import com.pruebas.pruebacruds.Service.iService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class CClientes {

    @Autowired
    private iService service;


    @PostMapping("/nuevo")
    public ResponseEntity<Clientes> crearCliente(@RequestBody Clientes clientes){
        Clientes nuevoCliente = service.saveClientes(clientes);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoCliente);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Clientes> obtenerPorId(@PathVariable Long id){
        Clientes cliente = service.getClienteById(id);
        if (cliente != null){
            return ResponseEntity.ok(cliente);
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    @GetMapping("/todos")
    public ResponseEntity<List<Clientes>> list(){
        List<Clientes> list = service.getClientes();
        return new ResponseEntity<List<Clientes>>(list, HttpStatus.OK);
    }

//    @GetMapping("/nombres/{nombre}")
//    public ResponseEntity<Clientes> getClientePorNombre(@PathVariable("nombre") String nombre) {
//        Clientes cliente = service.getClienteByNombre(nombre);
//        return new ResponseEntity<>(cliente, HttpStatus.OK);
//    }

@GetMapping("/buscar/{nombre}")
public ResponseEntity<Clientes> buscarPorNombre(@PathVariable String nombre) {
    Clientes cliente = service.getClienteByNombre(nombre);
    if (cliente != null){
        return ResponseEntity.ok(cliente);
    } else {
        return ResponseEntity.notFound().build();
    }
}














}
