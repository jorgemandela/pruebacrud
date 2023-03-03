package com.pruebas.pruebacruds.Repository;

import com.pruebas.pruebacruds.Entity.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RClientes extends JpaRepository<Clientes, Long> {
    List<Clientes> findAll();
   // List<Clientes> findByNombre(String nombre);
   Optional<Clientes> findByNombre(String nombre);



}
