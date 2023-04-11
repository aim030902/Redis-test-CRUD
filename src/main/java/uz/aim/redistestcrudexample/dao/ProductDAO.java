package uz.aim.redistestcrudexample.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import uz.aim.redistestcrudexample.domains.Product;

import java.util.List;

/**
 * @author : Abbosbek Murodov
 * @since : 11/04/23 / 13:26
 * Project : redis-test-CRUD-Example / IntelliJ IDEA
 */

@Repository
public class ProductDAO {
    @Autowired
//    @Qualifier(value = "template")
    private RedisTemplate template;

    private static final String HASH_KEY = "Product";

    public Product save(Product product) {
        template.opsForHash().put(HASH_KEY, product.getId(), product);
        return product;
    }

    public List<Product> findAll() {
        return template.opsForHash().values(HASH_KEY);
    }

    public Product findProductById(Long id) {
        return (Product) template.opsForHash().get(HASH_KEY, id);
    }

    public String deleteProductById(Long id) {
        Long productId = template.opsForHash().delete(HASH_KEY, id);
        return "Deleted product by id -> " + id;
    }

}
