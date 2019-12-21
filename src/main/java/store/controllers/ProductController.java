package store.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
        return productService.getInfoProduct(inputJson);
    }

    @RequestMapping("/product/list/all")
    public String getListProduct(){
        // TODO: вернуть лист из товаров любой категории
        return productService.getListProducts();
    }

    @RequestMapping("/product/list/category")
    public String getListProductCategory(){
        // TODO: вернуть лист из товаров заданной категории
        return "";
    }

    @RequestMapping("/product/delete")
    public String deleteProduct(@RequestBody String inputJson){
        // TODO: удаление из бд данный товар
        return " ";
    }
}
