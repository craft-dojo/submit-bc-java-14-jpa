package com.cybersoft.assign_14_jpa.controller;

import com.cybersoft.assign_14_jpa.request.InsertCategoryRequestDTO;
import com.cybersoft.assign_14_jpa.request.InsertProductRequestDTO;
import com.cybersoft.assign_14_jpa.response.BaseResponse;
import com.cybersoft.assign_14_jpa.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/{id}/products")
    public ResponseEntity<BaseResponse> getProductsByCategoryId(@PathVariable int id) {
        BaseResponse res = BaseResponse.success(categoryService.getProductsByCategoryId(id), null, null);
        return ResponseEntity.ok().body(res);
    }

    @PostMapping
    public ResponseEntity<BaseResponse> insertCategory(@RequestBody InsertCategoryRequestDTO request) {
        BaseResponse res = BaseResponse.success(categoryService.insertCategory(request), null, null);
        return ResponseEntity.ok().body(res);
    }

    @PostMapping("/{id}/products")
    public ResponseEntity<BaseResponse> insertProductByCategoryId(@PathVariable int id,
                                                                  @RequestBody InsertProductRequestDTO request) {
        BaseResponse res = BaseResponse.success(categoryService.insertProductByCategoryId(id, request), null, null);
        return ResponseEntity.ok().body(res);
    }


}
