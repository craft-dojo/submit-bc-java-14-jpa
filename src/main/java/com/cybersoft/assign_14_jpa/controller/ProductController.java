package com.cybersoft.assign_14_jpa.controller;

import com.cybersoft.assign_14_jpa.request.InsertProductRequestDTO;
import com.cybersoft.assign_14_jpa.request.UpdateProductRequestDTO;
import com.cybersoft.assign_14_jpa.response.BaseResponse;
import com.cybersoft.assign_14_jpa.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<BaseResponse> getProducts() {
        BaseResponse res = BaseResponse.success(productService.getAllProducts(), null, null);
        return ResponseEntity.ok(res);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BaseResponse> getProductById(@PathVariable int id) {
        BaseResponse res = BaseResponse.success(productService.getProductById(id), null, null);
        return ResponseEntity.ok(res);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BaseResponse> deleteProductById(@PathVariable int id) {
        productService.deleteProductById(id);
        BaseResponse res = BaseResponse.success(null, "Deleted successful", null);
        return ResponseEntity.ok(res);
    }

    @PostMapping
    public ResponseEntity<BaseResponse> insertProduct(@RequestBody InsertProductRequestDTO request) {
        BaseResponse res = BaseResponse.success(productService.insertProduct(request), "Created successful", null);
        return ResponseEntity.ok(res);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BaseResponse> updateProduct(@PathVariable int id,
                                                      @RequestBody UpdateProductRequestDTO dto) {
        BaseResponse res = BaseResponse.success(productService.updateProduct(id, dto), "Updated successful", null);
        return ResponseEntity.ok(res);
    }
}
