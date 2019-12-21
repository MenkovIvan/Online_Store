package store.services;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import store.helper.RequestStatus;
import store.model.products.Product;
import store.model.products.categories.Telephone;
import store.model.products.categories.Televisor;
import store.repository.ProductRepository;
import store.repository.TelephoneRepository;
import store.repository.TelevisorRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;
    private final TelephoneRepository telephoneRepository;
    private final TelevisorRepository televisorRepository;

    private Gson gson = new Gson();

    @Autowired
    public ProductService(ProductRepository productRepository, TelephoneRepository telephoneRepository, TelevisorRepository televisorRepository) {
        this.productRepository = productRepository;
        this.telephoneRepository = telephoneRepository;
        this.televisorRepository = televisorRepository;
    }

    public String addProduct(String inputJson){

        Product productFromClient = gson.fromJson(inputJson, Product.class);

        String message = "add product";
        Integer status;

        status = RequestStatus.OK_STATUS.getStatus();
        /*if (productFromClient.getTelephone() != null){
            Telephone telephoneFromClient = productFromClient.getTelephone();
            telephoneRepository.save(telephoneFromClient);

            log.info("add product - telephone");
            message = "add product - telephone";

        } else if (productFromClient.getTelevisor() != null){
            Televisor televisorFromClient = productFromClient.getTelevisor();
            televisorRepository.save(televisorFromClient);

            log.info("add product - televisor");
            message = "add product - televisor";
        }*/
        productRepository.save(productFromClient);


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

    public String getListProducts(){
        List<Product> productList = new ArrayList<>();
        Iterable<Product> iterable = productRepository.findAll();
        iterable.forEach(productList::add);
        return gson.toJson(productList);
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
