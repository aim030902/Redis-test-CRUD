package uz.aim.redistestcrudexample.domains;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import javax.annotation.processing.Generated;
import java.io.Serializable;

/**
 * @author : Abbosbek Murodov
 * @since : 11/04/23 / 13:26
 * Project : redis-test-CRUD-Example / IntelliJ IDEA
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@RedisHash("Product")

public class Product implements Serializable {
    @Id
    private Long id;
    private String name;
    private int quantity;
    private double price;
}
