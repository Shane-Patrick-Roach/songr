package com.shaneroach.songr.controller;

import com.shaneroach.songr.model.Album;
import com.shaneroach.songr.repository.AlbumsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class AlbumController {

    @Autowired
    AlbumsRepository albumsRepository;

    @GetMapping("/")
    public String getRootPage(Model m){

        List<Album> albumsDataBase = albumsRepository.findAll();

        m.addAttribute("albums", albumsDataBase);
        m.addAttribute("testString", "Testing");

        return "albums.html";
    }

    @PostMapping("/addAlbum")
    public RedirectView addAlbum(String title, String artist, int songCount, int length, String imageUrl) {
        Album album = new Album(title, artist, songCount, length, imageUrl);
        albumsRepository.save(album);
        return new RedirectView("/");
    }

    @GetMapping("/view-album/{title}")
    public String viewAlbumWindow(@PathVariable String title, Model m){
        Album albumToView = albumsRepository.findByTitle(title);
        m.addAttribute("album", albumToView);
        m.addAttribute("songs", albumToView.getSongsOfThisAlbum());
        return "view-album.html";
    }

    @PutMapping("/edit-album")
    public RedirectView viewAlbum(long id, String title, String artist, int songCount, int length, String imageUrl){
        Album albumToEdit = albumsRepository.getById(id);
        albumToEdit.setTitle(title);
        albumToEdit.setArtist(artist);
        albumToEdit.setLength(length);
        albumToEdit.setSongCount(songCount);
        albumToEdit.setImageUrl(imageUrl);

        return new RedirectView("/");
    }

    @DeleteMapping("/delete-album")
    public RedirectView deleteStore(long id)
    {
        albumsRepository.deleteById(id);
        return new RedirectView("/");
    }


}
