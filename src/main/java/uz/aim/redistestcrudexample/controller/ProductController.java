package uz.aim.redistestcrudexample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.aim.redistestcrudexample.dao.ProductDAO;
import uz.aim.redistestcrudexample.domains.Product;

/**
 * @author : Abbosbek Murodov
 * @since : 11/04/23 / 13:27
 * Project : redis-test-CRUD-Example / IntelliJ IDEA
 */

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductDAO dao;

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody Product product) {
        return ResponseEntity.ok(dao.save(product));
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(dao.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findProductById(@PathVariable Long id) {
        return ResponseEntity.ok(dao.findProductById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return ResponseEntity.ok(dao.deleteProductById(id));
    }
}
