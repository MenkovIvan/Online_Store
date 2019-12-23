package store.services;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import store.helper.RequestStatus;
import store.model.products.Product;
import store.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;

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

        Product productFromClient = gson.fromJson(inputJson, Product.class);

        String message = "add product";
        Integer status;

        status = RequestStatus.OK_STATUS.getStatus();

        productRepository.save(productFromClient);


        return getJsonString(message,status);
    }

    public String getInfoProduct(String inputJson){

        Product productFromClient = gson.fromJson(inputJson, Product.class);
        Product productInDb = productRepository.findProductById(productFromClient.getId());

        String message;
        Integer status;

        if (productInDb != null){
            log.info("get this Product");
            message = "OK";
            status = RequestStatus.OK_STATUS.getStatus();
            getJsonStringWithUser(productInDb,message,status);
        }
        else{
            log.info("exist product with this fulName");
            message = "exist product with this fulName";
            status = RequestStatus.BAD_STATUS.getStatus();
        }
        return getJsonString(message,status);
    }

    public String getListProducts(){
        List<Product> productList = new ArrayList<>();
        Iterable<Product> iterable = productRepository.findAll();
        iterable.forEach(productList::add);
        return getJsonList(productList);
    }

    public String getListProductsCategory(String inputJson){
        Product productFromClient = gson.fromJson(inputJson, Product.class);

        List<Product> productList = productRepository.findProductsByCategory(productFromClient.getCategory());

        return getJsonList(productList);
    }

    public String getListProductsEmail(String inputJson){
        Product productFromClient = gson.fromJson(inputJson, Product.class);

        List<Product> productList = productRepository.findProductsByEmail(productFromClient.getEmail());

        return getJsonList(productList);
    }

    private String getJsonString(String message, Integer status) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("status",status);
        jsonObject.addProperty("message",message);
        String jsonToClient = jsonObject.toString();

        log.info("return to client={}", jsonToClient);
        return jsonToClient;
    }

    private String getJsonStringWithUser(Product product, String message, Integer status) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("status",status);
        jsonObject.addProperty("message",message);

        jsonObject.add("product",gson.toJsonTree(product));
        String jsonToClient = jsonObject.toString();
        log.info("return to client={}", jsonToClient);

        return jsonToClient;
    }

    private String getJsonList(List<Product> productList){
        String jsonToClient = gson.toJson(productList);

        log.info("return to client={}", jsonToClient);
        return jsonToClient;
    }
}
