package com.cybersoft.assign_14_jpa.services.imp;

import com.cybersoft.assign_14_jpa.entity.ProductEntity;
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

    @Autowired
    public ProductServiceImp(ProductRepository productRepository) {
        this.productRepository = productRepository;
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
        ProductEntity productExisting = productRepository.findById(id).orElse(null);
        if (productExisting != null) {
            productRepository.delete(productExisting);
        }
    }

    @Override
    public ProductResponseDTO insertProduct(InsertProductRequestDTO request) {
        if (productRepository.existsByName(request.getName())) {
            throw new EntityExistsException("Product with name " + request.getName() + " already exists");
        }

        ProductEntity newProduct = ProductEntity.builder()
                .name(request.getName())
                .price(request.getPrice())
                .description(request.getDescription())
                .build();

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

        ProductEntity updateProduct = ProductEntity.builder()
                .id(productExisting.getId())
                .name(request.getName())
                .price(request.getPrice())
                .description(request.getDescription())
                .build();

        ProductEntity updatedProduct = productRepository.save(updateProduct);
        return ProductResponseDTO.mapToDTO(updatedProduct);
    }
}
