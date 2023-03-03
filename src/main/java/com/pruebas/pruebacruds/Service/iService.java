package com.pruebas.pruebacruds.Service;

import com.pruebas.pruebacruds.Entity.Clientes;

import java.util.List;

public interface iService {
    public Clientes saveClientes(Clientes clientes);
    public List<Clientes> getClientes();
    public Clientes getClienteById(Long id);
    public Clientes getClienteByNombre(String nombre);
}
