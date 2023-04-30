package com.iamjunaidjutt.bookmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.iamjunaidjutt.bookmanagement.entity.myBooks;

@Repository
public interface myBooksRepository extends JpaRepository<myBooks, Long> {
    // @Query(value = "Delete FROM my_Books WHERE id = :id", nativeQuery = true)
    // void myDeleteById(@Param("id") Long id);
}
