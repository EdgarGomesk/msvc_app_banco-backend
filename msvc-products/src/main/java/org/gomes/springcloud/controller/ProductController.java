package org.gomes.springcloud.controller;

import org.gomes.springcloud.entity.Product;
import org.gomes.springcloud.exception.ProductNotFoundException;
import org.gomes.springcloud.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<Product> crear(@RequestBody Product product) {
        Product productoCreado = productService.crear(product);
        return new ResponseEntity<>(productoCreado, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Product>> buscar() {
        List<Product> productos = productService.buscar();
        return new ResponseEntity<>(productos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> buscarPorId(@PathVariable Long id) {
            Product producto = productService.buscarPorId(id);
            return new ResponseEntity<>(producto, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> actualizar(@PathVariable Long id, @RequestBody Product productActualizado) {
            Product productoActualizado = productService.actualizar(id, productActualizado);
            return new ResponseEntity<>(productoActualizado, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
            productService.eliminar(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
