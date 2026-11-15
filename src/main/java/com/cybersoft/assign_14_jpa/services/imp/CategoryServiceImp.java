package com.cybersoft.assign_14_jpa.services.imp;

import com.cybersoft.assign_14_jpa.entity.CategoryEntity;
import com.cybersoft.assign_14_jpa.entity.ProductEntity;
import com.cybersoft.assign_14_jpa.repository.CategoryRepository;
import com.cybersoft.assign_14_jpa.repository.ProductRepository;
import com.cybersoft.assign_14_jpa.request.InsertCategoryRequestDTO;
import com.cybersoft.assign_14_jpa.request.InsertProductRequestDTO;
import com.cybersoft.assign_14_jpa.response.CategoryResponseDTO;
import com.cybersoft.assign_14_jpa.response.ProductResponseDTO;
import com.cybersoft.assign_14_jpa.services.CategoryService;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImp implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    @Autowired
    public CategoryServiceImp(CategoryRepository categoryRepository, ProductRepository productRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductResponseDTO> getProductsByCategoryId(int categoryId) {
        CategoryEntity categoryExist = categoryRepository.findById(categoryId).orElse(null);
        if (categoryExist == null) {
            return List.of();
        }

        return categoryExist.getProducts()
                .stream()
                .map(ProductResponseDTO::mapToDTO)
                .toList();
    }

    @Override
    public CategoryResponseDTO insertCategory(InsertCategoryRequestDTO request) {
        if (categoryRepository.existsByName(request.getName())) {
            throw new EntityExistsException("Category with name " + request.getName() + " already exists");
        }

        CategoryEntity newCategory = CategoryEntity.builder()
                .name(request.getName())
                .build();

        CategoryEntity createdCategory = categoryRepository.save(newCategory);
        return CategoryResponseDTO.mapToDTO(createdCategory);
    }

    @Override
    public ProductResponseDTO insertProductByCategoryId(int categoryId, InsertProductRequestDTO request) {
        CategoryEntity categoryExisting = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new EntityNotFoundException("Category with id " + categoryId + " not found"));

        if (productRepository.existsByName(request.getName())) {
            throw new EntityExistsException("Product with name " + request.getName() + " already exists");
        }

        ProductEntity newProduct = ProductEntity.builder()
                .name(request.getName())
                .price(request.getPrice())
                .description(request.getDescription())
                .category(categoryExisting)
                .build();

        ProductEntity createdProduct = productRepository.save(newProduct);
        return ProductResponseDTO.mapToDTO(createdProduct);
    }
}
