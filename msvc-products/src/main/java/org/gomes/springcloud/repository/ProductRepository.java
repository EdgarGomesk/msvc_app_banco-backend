package org.gomes.springcloud.repository;

import org.gomes.springcloud.entity.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
