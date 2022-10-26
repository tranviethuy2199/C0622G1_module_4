package com.example.controller;

import com.example.dto.SongDto;
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
        ModelAndView modelAndView = new ModelAndView("/list");
        List<Song> songs = iSongService.findAll();
        modelAndView.addObject("songs", songs);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreateSong() {
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("songDto", new SongDto());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView creatForm(@Validated @ModelAttribute SongDto songDto, BindingResult bindingResult) {
        new SongDto().validate(songDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            ModelAndView modelAndView = new ModelAndView("/create");
            return modelAndView;
        } else {
            Song song = new Song();
            BeanUtils.copyProperties(songDto, song);
            iSongService.save(song);
            ModelAndView modelAndView = new ModelAndView("/create");
            modelAndView.addObject("songDto", songDto);
            modelAndView.addObject("message", "Song created successfully");
            return modelAndView;
        }
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showUpdateForm(@PathVariable int id) {
        Song song = iSongService.findById(id);
        SongDto songdto = new SongDto();
        BeanUtils.copyProperties(song, songdto);
        ModelAndView modelAndView = new ModelAndView("/edit");
        modelAndView.addObject("songDto", songdto);
        return modelAndView;
    }

    @PostMapping("/edit")
    public ModelAndView editForm(@ModelAttribute @Validated SongDto songDto, BindingResult bindingResult) {
        new SongDto().validate(songDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            ModelAndView modelAndView = new ModelAndView("/edit");
            return modelAndView;
        } else {
            Song song = new Song();
            BeanUtils.copyProperties(songDto, song);
            iSongService.save(song);
            ModelAndView modelAndView = new ModelAndView("/edit");
            modelAndView.addObject("songDto", songDto);
            modelAndView.addObject("message", "Song edited successfully");
            return modelAndView;
        }
    }
}
