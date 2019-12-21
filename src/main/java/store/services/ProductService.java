package store.services;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import store.helper.RequestStatus;
import store.model.products.Product;
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

        Product productFromClient = gson.fromJson(inputJson, Product.class);
        Product productInDb = productRepository.findByFullName(productFromClient.getFullName());

        String message;
        Integer status;

        if (productInDb == null){
            log.info("not exist product with this fulName, add to DB");
            message = "OK";
            status = RequestStatus.OK_STATUS.getStatus();
        }
        else{
            log.info("exist product with this fulName");
            message = "exist product with this fulName";
            status = RequestStatus.BAD_STATUS.getStatus();
        }
        return getJsonString(message,status);
    }

    public String getInfoProduct(String inputJson){

        Product productFromClient = gson.fromJson(inputJson, Product.class);
        Product productInDb = productRepository.findByFullName(productFromClient.getFullName());

        String message;
        Integer status;

        if (productInDb != null){
            log.info("get this Product");
            message = "OK";
            status = RequestStatus.OK_STATUS.getStatus();
        }
        else{
            log.info("exist product with this fulName");
            message = "exist product with this fulName";
            status = RequestStatus.BAD_STATUS.getStatus();
        }
        return getJsonString(message,status);
    }

    private String getJsonString(String message, Integer status) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("status",status);
        jsonObject.addProperty("message",message);
        String jsonToClient = jsonObject.toString();

        log.info("return to client={}", jsonToClient);
        return jsonToClient;
    }
}
