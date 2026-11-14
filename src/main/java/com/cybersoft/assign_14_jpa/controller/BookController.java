package com.cybersoft.assign_14_jpa.controller;

import com.cybersoft.assign_14_jpa.request.SearchBookRequestDTO;
import com.cybersoft.assign_14_jpa.response.BaseResponse;
import com.cybersoft.assign_14_jpa.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/search")
    public ResponseEntity<BaseResponse> searchBooks(SearchBookRequestDTO request) {
        BaseResponse res = BaseResponse.success(bookService.searchBooks(request), null, null);
        return ResponseEntity.ok(res);
    }
}
