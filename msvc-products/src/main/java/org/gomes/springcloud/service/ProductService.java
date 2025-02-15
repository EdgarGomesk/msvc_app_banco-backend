package org.gomes.springcloud.service;

import org.gomes.springcloud.entity.Product;
import org.gomes.springcloud.exception.ProductNotFoundException;
import org.gomes.springcloud.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public Product crear(Product product) {
        return repository.save(product);
    }

    public List<Product> buscar() {
        return (List<Product>) repository.findAll();
    }

    public Product buscarPorId(Long id) {
        if (repository.existsById(id)) {
            return repository.findById(id).get();
        } else {
            throw new ProductNotFoundException("El producto no se encuentra");
        }
    }

    public Product actualizar(Long id, Product productActualizado) {
        if (repository.existsById(id)) {
            Product productExistente = repository.findById(id).get();
            productExistente.setCode(productActualizado.getCode());
            productExistente.setName(productActualizado.getName());
            return repository.save(productExistente);
        } else {
            throw new ProductNotFoundException("Producto no encontrado");
        }
    }

    public void eliminar(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new ProductNotFoundException("Producto no encontrado");
        }
    }
}
