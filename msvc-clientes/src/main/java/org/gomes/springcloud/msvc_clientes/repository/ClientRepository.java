package org.gomes.springcloud.msvc_clientes.repository;

import org.gomes.springcloud.msvc_clientes.entity.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<Client, Long> {
}
