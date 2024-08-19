package edu.example.shopping.repository;

import edu.example.shopping.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@RequiredArgsConstructor
public class JdbcProductRepository implements ProductRepository {
    private final JdbcTemplate jdbcTemplate;



    @Override
    public Product selectById(String id) {
        return jdbcTemplate.queryForObject(
                "select * from Product where id = ? ",
                new DataClassRowMapper<>(Product.class),
                id
        );
    }

    @Override
    public List<Product> selectAll() {
        return jdbcTemplate.query(
                "Select * from product Order BY id",
                new DataClassRowMapper<>(Product.class)

        );
    }

    @Override
    public boolean update(Product product) {
        int result = jdbcTemplate.update("""
                        UPDATE product set name = ?, price = ?, stock = ? 
                        where id = ?""",
                product.getName(),
                product.getPrice(),
                product.getStock(),
                product.getId()  );
        return result ==1;
    }
}
