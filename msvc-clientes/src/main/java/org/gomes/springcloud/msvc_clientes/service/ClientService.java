package org.gomes.springcloud.msvc_clientes.service;

import org.gomes.springcloud.msvc_clientes.entity.Client;
import org.gomes.springcloud.msvc_clientes.exception.ClientNotFoundException;
import org.gomes.springcloud.msvc_clientes.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;

    public Client crear(Client client) {
        return repository.save(client);
    }

    public List<Client> buscar() {
        return (List<Client>) repository.findAll();
    }

    public Client buscarPorId(Long id) {
        if(repository.existsById(id)){
            return repository.findById(id).get();
        }else {
            throw new ClientNotFoundException("El cliente no se encuentra");
        }

    }

    public Client actualizar(Long id, Client clientActualizado) {
        if (repository.existsById(id)) {
            Client clienteExistente = repository.findById(id).get();
            clienteExistente.setName(clientActualizado.getName());
            return repository.save(clienteExistente);
        } else {
            throw new ClientNotFoundException("Cliente no encontrado");
        }
    }

    public void eliminar(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new ClientNotFoundException("Cliente no encontrado");
        }
    }
}
