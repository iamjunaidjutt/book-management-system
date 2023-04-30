package com.iamjunaidjutt.bookmanagement.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.iamjunaidjutt.bookmanagement.entity.Book;
import com.iamjunaidjutt.bookmanagement.entity.myBooks;
import com.iamjunaidjutt.bookmanagement.service.BookService;
import com.iamjunaidjutt.bookmanagement.service.myBooksService;

@Controller
public class BookController {
    @Autowired
    private BookService bookService;

    @Autowired
    private myBooksService myBooksService;
    
    @GetMapping("/")
    public String home() {
        return "home";
    }
    @GetMapping("/book_register")
    public String bookRegister() {
        return "bookRegister";
    }
    @PostMapping("/save")
    public String addBook(@ModelAttribute Book b) {
        bookService.bookSave(b);
        System.out.println(b);
        return "redirect:/available_books";
    }
    @GetMapping("/available_books")
    public ModelAndView availableBook() {
        List<Book> list = bookService.getBooks();
        return new ModelAndView("availableBooks", "book", list);
    }

    @GetMapping("/my_books")
    public ModelAndView myBooks() {
        List<myBooks> list = myBooksService.myBookFindAll();
        return new ModelAndView("myBooks", "book", list);
    }

    @RequestMapping("/my_books/{id}")
    public String myBooks(@PathVariable Long id) {
        Book b = bookService.getBook(id);
        myBooks book = new myBooks(b.getId(),b.getTitle(), b.getAuthor(), b.getPrice());
        myBooksService.myBookSave(book);
        return "redirect:/my_books";
    }

    @RequestMapping("/delete_mybook/{id}")
    public String deleteMyBook(@PathVariable Long id) {
        myBooksService.myBookDeleteById(id);
        return "redirect:/my_books";
    }
    @RequestMapping("/delete_book/{id}")
    public String deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return "redirect:/available_books";
    }
}
