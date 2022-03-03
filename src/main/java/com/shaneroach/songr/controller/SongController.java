package com.shaneroach.songr.controller;


import com.shaneroach.songr.model.Album;
import com.shaneroach.songr.model.Song;
import com.shaneroach.songr.repository.AlbumsRepository;
import com.shaneroach.songr.repository.SongsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class SongController {
    @Autowired
    AlbumsRepository albumsRepository;
    @Autowired
    SongsRepository songsRepository;

    @PostMapping("/add-song")
    public RedirectView addSong(long albumId, String title, int length, int trackNumber ) {
        Album songsOfAlbum = albumsRepository.getById(albumId);
        Song songToAdd = new Song(title,length,trackNumber);
        songToAdd.setSongsOfAlbum(songsOfAlbum);
        songsRepository.save(songToAdd);

        return new RedirectView("/");
    }
//
//    @GetMapping("/view-album/{albumId}")
//    public String viewSongs(@PathVariable long albumId, Model m){
//        Album album = albumsRepository.getById(albumId);
//        m.addAttribute("songs", album.getSongsOfThisAlbum());
//        return "/view-album.html";
//    }
}
