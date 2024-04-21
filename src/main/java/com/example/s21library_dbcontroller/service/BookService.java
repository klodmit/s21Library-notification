package com.example.s21library_dbcontroller.service;

import com.example.s21library_dbcontroller.entities.Book;
import com.example.s21library_dbcontroller.entities.BookDto;
import com.example.s21library_dbcontroller.entities.Reserve;
import com.example.s21library_dbcontroller.entities.Visitor;
import com.example.s21library_dbcontroller.repo.BookRepository;
import com.example.s21library_dbcontroller.repo.ReserveRepository;
import com.example.s21library_dbcontroller.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

@Service
@RequiredArgsConstructor
@Slf4j
public class BookService {
    private final BookRepository bookRepository;
    private final ReserveRepository reserveRepository;
    private final UserRepository userRepository;

    public List<Book> showBooks() {
        return bookRepository.findAll();
    }

    public String editBook(BookDto book) {
        Book entityBook = bookRepository.findById(book.getId()).orElse(null);
        if(entityBook == null) {
            return "Не нашло";
        }
        Book editedBook =  bookMapper(book, entityBook);
        log.info(editedBook.toString());
        bookRepository.save(editedBook);
        return "Success";
    }
    public String makeReserve(BookDto bookDto) {
        Book entityBook = null;
        if (bookDto.getTitle() != null && bookDto.getAuthor() != null) {
             entityBook = bookRepository.findAllByTitleAndAuthor(bookDto.getTitle(), bookDto.getAuthor());
        }
        else if(bookDto.getId() != 0) {
            entityBook = bookRepository.findById(bookDto.getId()).orElse(null);
        }
        Visitor visitor = userRepository.findByChatId(bookDto.getChatId()).orElse(null);
        if(entityBook == null) {
            return "Не нашло";
        }
        Reserve reserve = new Reserve();
        //првоерить что копий хватает
        reserve.setBookId(entityBook.getId());
        assert visitor != null;
        reserve.setVisitorId(visitor.getId());
        reserve.setDateTook(LocalDateTime.now());
        reserve.setDateReturned(LocalDateTime.now().plusDays(14));
        reserve.setActiveInd((short)1);
        log.info(reserve.toString());
        reserveRepository.save(reserve);
        return "Success";
    }

    public String returnBook(BookDto bookDto) {
        Book entityBook = null;
        if (bookDto.getTitle() != null && bookDto.getAuthor() != null) {
            entityBook = bookRepository.findAllByTitleAndAuthor(bookDto.getTitle(), bookDto.getAuthor());
        }
        else if(bookDto.getId() != 0) {
            entityBook = bookRepository.findById(bookDto.getId()).orElse(null);
        }
        Visitor visitor = userRepository.findByChatId(bookDto.getChatId()).orElse(null);
        if(entityBook == null) {
            return "Не нашло";
        }
        assert visitor != null;
        Reserve reserve = reserveRepository.findByBookIdAndVisitorId(entityBook.getId(), visitor.getId());
        reserve.setDateReturned(LocalDateTime.now());
        reserve.setActiveInd((short)0);
        log.info(reserve.toString());
        reserveRepository.save(reserve);
        return "Success";
    }
    public String addBook(BookDto bookDto) {
        Book book = new Book();
        book.setCopies(bookDto.getCopies());
        book.setAuthor(bookDto.getAuthor());
        book.setRating(bookDto.getRating());
        book.setTitle(bookDto.getTitle());
        book.setGenre(bookDto.getGenre());
        bookRepository.save(book);
        return "Success";
    }
    public String deleteBook(BookDto bookDto) {
        Book book = bookRepository.findById(bookDto.getId()).orElse(null);
        if(book == null) {
            return "bad";
        }
        bookRepository.delete(book);
        return "Success";
    }

    private Book bookMapper(BookDto book, Book entity) {
        entity.setTitle(book.getChangeTitle());
        entity.setRating(Optional.ofNullable(book.getRating()).orElse(entity.getRating()));
        entity.setGenre(Optional.ofNullable(book.getGenre()).orElse(entity.getGenre()));
        entity.setCopies(Optional.ofNullable(book.getCopies()).orElse(entity.getCopies()));
        entity.setAuthor(book.getChangeAuthor());
        return entity;
    }





}
