package com.iamjunaidjutt.bookmanagement.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.iamjunaidjutt.bookmanagement.entity.myBooks;
import com.iamjunaidjutt.bookmanagement.repository.myBooksRepository;

@Service
public class myBooksService {

    @Autowired
    private myBooksRepository myBookRepo;
    
    public myBooksService() {
    }
    public myBooksService(myBooksRepository myBookRepo) {
        this.myBookRepo = myBookRepo;
    }
    public void myBookSave(myBooks b) {
        myBookRepo.save(b);
    }
    public void myBookDeleteById(Long id) {
        // myBookRepo.myDeleteById(id);
        myBookRepo.deleteById(id);
    }
    public void myBookUpdate(myBooks book) {
        myBookRepo.save(book);
    }
    public List<myBooks> myBookFindAll() {
        return myBookRepo.findAll();
    }
}
