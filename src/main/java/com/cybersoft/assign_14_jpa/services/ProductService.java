package com.cybersoft.assign_14_jpa.services;

import com.cybersoft.assign_14_jpa.request.InsertProductRequestDTO;
import com.cybersoft.assign_14_jpa.request.UpdateProductRequestDTO;
import com.cybersoft.assign_14_jpa.response.ProductResponseDTO;

import java.util.List;

public interface ProductService {
    List<ProductResponseDTO> getAllProducts();

    ProductResponseDTO getProductById(int id);

    void deleteProductById(int id);

    ProductResponseDTO insertProduct(InsertProductRequestDTO request);

    ProductResponseDTO updateProduct(int id, UpdateProductRequestDTO request);
}
