package com.example.product.controller;

import com.example.product.model.Product;
import com.example.product.model.ProductRepository;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    ProductRepository productRepository;

    @GetMapping("/welcome")
    @ApiOperation(value = "Responsável por retornar uma mensagem de boas vindas.")
    public String welcome(){
        return "BEM VINDO À PRODUCT REST API.";
    }

    @GetMapping("/allProducts")
    @ApiOperation(value = "Responsável por retornar uma lista de produtos.")
    @ApiResponse(code = 11, message = "Warning - the process returned more than 1000 products.")
    public List<Product> allProducts(){
        return productRepository.getAllProducts();
    }

    @GetMapping("/findProductById/{id}")
    @ApiOperation(value = "Responsável por retornar um produto pelo id.")
    @ApiResponse(code = 12, message = "The field id not informed. This information is required.")
    public Product findProductById(@PathVariable("id") Integer id){
        return productRepository.getProductById(id);
    }

    @PostMapping("/addProduct")
    @ApiOperation(value = "Responsável por adicionar um produto.")
    @ApiResponse(code = 10, message = "Required fields not informed.")
    public Product addProduct(@RequestBody Product product){
        return productRepository.addProduct(product);
    }

    @PutMapping("/updateProduct")
    @ApiOperation(value = "Responsável por atualizar um produto.")
    @ApiResponse(code = 14, message = "No information has been updated. The new information is the same as recorded in the database.")
    public Product updateProduct(@RequestBody Product product){
        return productRepository.updateProduct(product);
    }

    @DeleteMapping("/removeProduct")
    @ApiOperation(value = "Responsável por remover um produto.")
    @ApiResponse(code = 13, message = "User not allowed to remove a product from this category.")
    public void removeProduct(@RequestBody Product product){
        productRepository.removeProduct(product);
    }
}
