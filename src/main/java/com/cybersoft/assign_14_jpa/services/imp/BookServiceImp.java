package com.cybersoft.assign_14_jpa.services.imp;

import com.cybersoft.assign_14_jpa.repository.BookRepository;
import com.cybersoft.assign_14_jpa.request.SearchBookRequestDTO;
import com.cybersoft.assign_14_jpa.response.BookResponseDTO;
import com.cybersoft.assign_14_jpa.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImp implements BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookServiceImp(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<BookResponseDTO> searchBooks(SearchBookRequestDTO request) {
        return bookRepository.searchBook(request.getAuthor(), request.getMinPrice(), request.getMaxPrice())
                .stream()
                .map(BookResponseDTO::mapToDTO)
                .toList();
    }
}
