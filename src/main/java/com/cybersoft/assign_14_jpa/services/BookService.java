package com.cybersoft.assign_14_jpa.services;

import com.cybersoft.assign_14_jpa.request.SearchBookRequestDTO;
import com.cybersoft.assign_14_jpa.response.BookResponseDTO;

import java.util.List;

public interface BookService {
    List<BookResponseDTO> searchBooks(SearchBookRequestDTO request);
}
