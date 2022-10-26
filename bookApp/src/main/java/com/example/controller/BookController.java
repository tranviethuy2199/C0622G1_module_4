package com.example.controller;

import com.example.model.Book;
import com.example.model.OderBook;
import com.example.service.IBookService;
import com.example.service.IOderService;
import com.sun.org.apache.bcel.internal.generic.PUSH;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Date;
import java.text.DateFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
public class BookController {
    @Autowired
    IBookService iBookService;

    @Autowired
    IOderService iOderService;

    @GetMapping("/index")
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView("/index");
        modelAndView.addObject("list",iBookService.findAll());
        return modelAndView;
    }

    @GetMapping("/view/{id}")
    public ModelAndView view(@PathVariable int id) {
        Book books = iBookService.findById(id);
        if (books != null) {
            ModelAndView modelAndView = new ModelAndView("/view");
            modelAndView.addObject("book", books);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @GetMapping("/oder/{id}")
    public ModelAndView oder(@PathVariable int id) throws Exception {
        OderBook oderBook = new OderBook();
        Book book = iBookService.findById(id);
        int code =(int)(Math.random()*(999-100)+100);
        oderBook.setBook(book);
        oderBook.setCode(code);
        oderBook.setDate(Date.valueOf(LocalDate.now()));
        book.setCount(book.getCount()-1);
        iOderService.save(oderBook);
        if (book.getCount() == -1){
            throw new Exception();
        }
        ModelAndView modelAndView = new ModelAndView("/view");
        modelAndView.addObject("book",book);
        modelAndView.addObject("code","mã code của bạn là: " + code);
        return modelAndView;
    }

    @GetMapping("/return/{id}")
    public ModelAndView returnBook(@PathVariable int id)  {
        Book book = iBookService.findById(id);
        book.setCount(book.getCount()+1);
        iBookService.save(book);
        ModelAndView modelAndView = new ModelAndView("/return");
        modelAndView.addObject("book",book);
        return modelAndView;
    }
}
