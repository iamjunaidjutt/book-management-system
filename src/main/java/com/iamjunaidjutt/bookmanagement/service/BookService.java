package com.iamjunaidjutt.bookmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iamjunaidjutt.bookmanagement.entity.Book;
import com.iamjunaidjutt.bookmanagement.repository.BookRepository;

@Service
public class BookService {
    @Autowired
    private BookRepository bRepo;
    public BookService() {
    }
    public BookService(BookRepository bRepo) {
        this.bRepo = bRepo;
    }
    public void bookSave(Book b) {
        bRepo.save(b);
    }
    public List<Book> getBooks() {
        return bRepo.findAll();
    }
    public Book getBook(Long id) {
        return bRepo.findById(id).get();
    }
    public void deleteBook(Long id) {
        bRepo.deleteById(id);
    }
}
