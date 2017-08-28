package com.arrobaautowired.cejodejota.persistence;

import com.arrobaautowired.cejodejota.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Alex on 07/03/2015.
 */

public interface BookRepository extends JpaRepository<Book, Long> {
}
