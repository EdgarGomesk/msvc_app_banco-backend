package org.gomes.springcloud.msvc_clientes.controller;

import org.gomes.springcloud.msvc_clientes.entity.Client;
import org.gomes.springcloud.msvc_clientes.exception.ClientNotFoundException;
import org.gomes.springcloud.msvc_clientes.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/client")
public class ClientController {

    @Autowired
    private ClientService service;

    @PostMapping("/crear")
    public ResponseEntity<Client> crear(@RequestBody Client client) {
        Client nuevoCliente = service.crear(client);
        return new ResponseEntity<>(nuevoCliente, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<Client>> buscar() {
        List<Client> clientes = service.buscar();
        return new ResponseEntity<>(clientes, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Client> buscarPorId(@PathVariable Long id) {
            Client cliente = service.buscarPorId(id);
            return new ResponseEntity<>(cliente, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Client> actualizar(@PathVariable Long id, @RequestBody Client clientActualizado) {
            Client clienteActualizado = service.actualizar(id, clientActualizado);
            return new ResponseEntity<>(clienteActualizado, HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
            service.eliminar(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
