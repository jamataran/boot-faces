package com.arrobaautowired.cejodejota.view;

import com.arrobaautowired.cejodejota.domain.Book;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 * Created by Alex on 07/03/2015.
 */

@ManagedBean(name = "book", eager = true)
@RequestScoped
public class BookView extends Book {

    public BookView() {
    }
}
