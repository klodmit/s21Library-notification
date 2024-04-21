package com.example.s21library_dbcontroller.controllers;

import com.example.s21library_dbcontroller.entities.Book;
import com.example.s21library_dbcontroller.entities.BookDto;
import com.example.s21library_dbcontroller.service.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class BookController {

    private final BookService bookService;

    @GetMapping("/showBooks")
    public List<Book> showBooks() {
        return bookService.showBooks();
    }

    @PostMapping("/edit-book")
    public String editBook(@RequestBody BookDto bookDto) {
        log.info(bookDto.toString());
        bookService.editBook(bookDto);
        return "Success";
    }

    @DeleteMapping("/deleteBook")
    public String deleteBook(@RequestBody BookDto bookDto) {
        return bookService.deleteBook(bookDto);
    }

    @PostMapping("/make-reserve")
    public String makeReserve(@RequestBody BookDto bookDto) {
        return bookService.makeReserve(bookDto);
    }

    @PostMapping("/return-book")
    public String returnBook(@RequestBody BookDto bookDto) {
        return bookService.returnBook(bookDto);
    }
    @PostMapping("/add-book")
    public String addBook(@RequestBody BookDto bookDto) {
        return bookService.addBook(bookDto);
    }


}
