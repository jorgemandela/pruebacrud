package com.pruebas.pruebacruds.Service;

import com.pruebas.pruebacruds.Entity.Clientes;
import com.pruebas.pruebacruds.Repository.RClientes;
import com.pruebas.pruebacruds.exception.exceptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class iServiceImpl implements iService {

    @Autowired
    private RClientes rClientes;

    @Override
    public Clientes saveClientes(Clientes clientes) {
        return rClientes.save(clientes);
    }

    @Override
    public List<Clientes> getClientes() {
        return rClientes.findAll();
    }

    @Override
    public Clientes getClienteById(Long id) {
        Optional<Clientes> opt = rClientes.findById(id);
        if (opt.isPresent()){
            return opt.get();
        } else {
            throw new exceptions("Clientes con id: " + id + " no encontrado");
        }

    }

    @Override
    public Clientes getClienteByNombre(String nombre) {
        Optional<Clientes> opts = rClientes.findByNombre(nombre);
        if (opts.isPresent()){
            return opts.get();
        } else {
            throw new exceptions("Clientes con nombre: " + nombre + " no encontrado");

        }
    }


}
