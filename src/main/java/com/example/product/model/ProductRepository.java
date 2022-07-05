package com.example.product.model;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {

    private List<Product> list = new ArrayList<Product>();

    public List<Product> getAllProducts() {
        return this.getList();
    }

    public Product getProductById(Integer id) {
        for(int i=0; i < this.getList().size(); i++){
            if(list.get(i).getId().equals(id.longValue())){
                return list.get(i);
            }
        }

        return null;
    }

    public Product addProduct(Product s) {
        this.getList().add(s);
        return s;
    }

    public Product updateProduct(Product s) {
        if(this.getProductById(s.getId().intValue()) != null){
            this.getProductById(s.getId().intValue()).setCode(s.getCode());
            this.getProductById(s.getId().intValue()).setName(s.getName());
            this.getProductById(s.getId().intValue()).setDescription(s.getDescription());
            this.getProductById(s.getId().intValue()).setPrice(s.getPrice());
            this.getProductById(s.getId().intValue()).setCreatedOne(s.getCreatedOne());
        }
        return s;
    }

    public void removeProduct(Product s) {
        this.getList().remove(s);
    }

    public void addList(List<Product> listOfProducts) {
        this.getList().addAll(listOfProducts);
    }

    private List<Product> getList() {
        return list;
    }

}
