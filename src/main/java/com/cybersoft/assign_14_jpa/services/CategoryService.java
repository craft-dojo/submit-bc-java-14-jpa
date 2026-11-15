package com.cybersoft.assign_14_jpa.services;

import com.cybersoft.assign_14_jpa.request.InsertCategoryRequestDTO;
import com.cybersoft.assign_14_jpa.request.InsertProductRequestDTO;
import com.cybersoft.assign_14_jpa.response.CategoryResponseDTO;
import com.cybersoft.assign_14_jpa.response.ProductResponseDTO;

import java.util.List;

public interface CategoryService {

    List<ProductResponseDTO> getProductsByCategoryId(int categoryId);

    CategoryResponseDTO insertCategory(InsertCategoryRequestDTO request);

    ProductResponseDTO insertProductByCategoryId(int categoryId, InsertProductRequestDTO request);
}
