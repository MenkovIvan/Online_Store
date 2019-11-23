package store.services;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import store.repository.ProductRepository;

@Service
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;

    private Gson gson = new Gson();

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public String addProduct(String inputJson){

        return "123";
    }
}
