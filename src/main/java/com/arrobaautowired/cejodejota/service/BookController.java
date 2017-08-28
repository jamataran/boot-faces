package com.arrobaautowired.cejodejota.service;

import com.arrobaautowired.cejodejota.domain.Book;
import com.arrobaautowired.cejodejota.persistence.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Alex on 18/03/2015.
 */

@RestController
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @RequestMapping("/service/books")
    public @ResponseBody
    Iterable<Book> getAllBooks() {
        return this.bookRepository.findAll();
    }

    @RequestMapping(value = "/service/book/{id}", method = RequestMethod.GET)
    public @ResponseBody
    Book getBookById(@PathVariable Long id) {
        return this.bookRepository.findOne(id);
    }
}
