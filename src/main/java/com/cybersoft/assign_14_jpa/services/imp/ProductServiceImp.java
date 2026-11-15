package com.cybersoft.assign_14_jpa.services.imp;

import com.cybersoft.assign_14_jpa.entity.CategoryEntity;
import com.cybersoft.assign_14_jpa.entity.ProductEntity;
import com.cybersoft.assign_14_jpa.repository.CategoryRepository;
import com.cybersoft.assign_14_jpa.repository.ProductRepository;
import com.cybersoft.assign_14_jpa.request.InsertProductRequestDTO;
import com.cybersoft.assign_14_jpa.request.UpdateProductRequestDTO;
import com.cybersoft.assign_14_jpa.response.ProductResponseDTO;
import com.cybersoft.assign_14_jpa.services.ProductService;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImp implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    @Autowired
    public ProductServiceImp(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<ProductResponseDTO> getAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(ProductResponseDTO::mapToDTO)
                .toList();
    }

    @Override
    public ProductResponseDTO getProductById(int id) {
        ProductEntity productExisting = productRepository.findById(id).orElse(null);

        return productExisting != null ? ProductResponseDTO.mapToDTO(productExisting) : null;
    }

    @Override
    public void deleteProductById(int id) {
        productRepository.findById(id).ifPresent(productRepository::delete);
    }

    @Override
    public ProductResponseDTO insertProduct(InsertProductRequestDTO request) {
        if (productRepository.existsByName(request.getName())) {
            throw new EntityExistsException("Product with name " + request.getName() + " already exists");
        }

        CategoryEntity categoryExist = categoryRepository.findById(request.getCategoryId())
                .orElseThrow(() -> new EntityExistsException("Category with id " + request.getCategoryId() + " does " +
                        "not exist"));

        ProductEntity newProduct = ProductEntity.builder()
                .name(request.getName())
                .price(request.getPrice())
                .description(request.getDescription())
                .category(categoryExist)
                .build();

        categoryExist.getProducts().add(newProduct);
        ProductEntity createdProduct = productRepository.save(newProduct);
        return ProductResponseDTO.mapToDTO(createdProduct);
    }

    @Override
    public ProductResponseDTO updateProduct(int id, UpdateProductRequestDTO request) {
        ProductEntity productExisting = productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Product with id " + id + " not found"));

        if (!productExisting.getName().equals(request.getName())
                && productRepository.existsByName(request.getName())) {
            throw new EntityExistsException("Product with name " + request.getName() + " already exists");
        }

        CategoryEntity categoryExist = categoryRepository.findById(request.getCategoryId())
                .orElseThrow(() -> new EntityExistsException("Category with id " + request.getCategoryId() + " does " +
                        "not exist"));

        productExisting.setName(request.getName());
        productExisting.setPrice(request.getPrice());
        productExisting.setDescription(request.getDescription());
        productExisting.setCategory(categoryExist);

        ProductEntity updatedProduct = productRepository.save(productExisting);
        return ProductResponseDTO.mapToDTO(updatedProduct);
    }
}
