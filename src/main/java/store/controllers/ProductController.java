package store.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import store.model.Product;
import store.services.ProductService;

@RestController
@Slf4j
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping("/product/add")
    public String addProduct(@RequestBody String inputJson){
        log.info("Request to add Product, body = {" + inputJson + "}");
        // TODO: добавление товара
        return productService.addProduct(inputJson);
    }

    @RequestMapping("/product/info")
    public String getInfoProduct(@RequestBody String inputJson){
        // TODO: вернуть всю информацию об определенном товаре
        return " ";
    }

    @RequestMapping("/product/list")
    public String getListProduct(@RequestBody String inputJson){
        // TODO: вернуть лист из товаров, соответствующих запросу
        return " ";
    }

    @RequestMapping("/product/delete")
    public String deleteProduct(@RequestBody String inputJson){
        // TODO: удаление из бд данный товар
        return " ";
    }
}
