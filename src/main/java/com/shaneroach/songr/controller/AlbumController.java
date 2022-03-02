package com.shaneroach.songr.controller;

import com.shaneroach.songr.model.Album;
import com.shaneroach.songr.repository.SongrRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AlbumController {

    @Autowired
    SongrRepository songrRepository;

    @GetMapping("/")
    public String getRootPage(Model m){

        List<Album> albumsDataBase = songrRepository.findAll();

        m.addAttribute("albums", albumsDataBase);
        m.addAttribute("testString", "Testing");

        return "albums.html";
    }

    @PostMapping("/addAlbum")
    public RedirectView addAlbum(String title, String artist, int songCount, int length, String imageUrl) {
        Album album = new Album(title, artist, songCount, length, imageUrl);
        songrRepository.save(album);
        return new RedirectView("/");

    }
}
