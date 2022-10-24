package com.example.controller;

import com.example.dto.Songdto;
import com.example.model.Song;
import com.example.service.ISongService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/songs")
public class SongController {
   @Autowired
    ISongService iSongService;

    @GetMapping("")
    public ModelAndView showList() {
        ModelAndView modelAndView = new ModelAndView("song/list");
        List<Song> songs = iSongService.findAll();
        modelAndView.addObject("songs", songs);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreateSong() {
        ModelAndView modelAndView = new ModelAndView("song/create");
        modelAndView.addObject("songDto", new Songdto());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView creatForm(@ModelAttribute @Validated Songdto songdto, BindingResult bindingResult) {
        new Songdto().validate(songdto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            ModelAndView modelAndView = new ModelAndView("song/create");
            return modelAndView;
        } else {
            Song song = new Song();
            BeanUtils.copyProperties(songdto, song);
            iSongService.save(song);
            ModelAndView modelAndView = new ModelAndView("song/create");
            modelAndView.addObject("songDto", songdto);
            modelAndView.addObject("message", "Song created successfully");
            return modelAndView;
        }
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showUpdateForm(@PathVariable int id) {
        Song song = iSongService.findById(id);
        Songdto songdto = new Songdto();
        BeanUtils.copyProperties(song, songdto);
        ModelAndView modelAndView = new ModelAndView("song/edit");
        modelAndView.addObject("songDto", songdto);
        return modelAndView;
    }

    @PostMapping("/edit")
    public ModelAndView editForm(@ModelAttribute @Validated Songdto songDto, BindingResult bindingResult) {
        new Songdto().validate(songDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            ModelAndView modelAndView = new ModelAndView("song/edit");
            return modelAndView;
        } else {
            Song song = new Song();
            BeanUtils.copyProperties(songDto, song);
            iSongService.save(song);
            ModelAndView modelAndView = new ModelAndView("song/edit");
            modelAndView.addObject("songDto", songDto);
            modelAndView.addObject("message", "Song edited successfully");
            return modelAndView;
        }
    }
}
