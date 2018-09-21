package com.dmxiaoshen.controller;

import com.dmxiaoshen.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hzhsg on 2018/9/20.
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/buy")
    public String buy(){
        productService.buy();
        return "success";
    }
}
