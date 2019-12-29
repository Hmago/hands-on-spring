package com.hmago.learn.spring.auditing.controller;

import com.hmago.learn.spring.auditing.model.Product;
import com.hmago.learn.spring.auditing.pojo.ProductRequest;
import com.hmago.learn.spring.auditing.repo.ProductRepo;
import jdk.nashorn.internal.objects.annotations.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductRepo repo;

    /*
     * Just to check this from browser making this as GET request
     */
    @GetMapping("/create/{name}/{category}")
    public String create(@PathVariable String name, @PathVariable String category){
        repo.save(Product.builder().name(name).category(category).build());
        return "success";
    }

    @GetMapping("/searchall")
    public List<Product> search(){
        return repo.findAll();
    }

}
