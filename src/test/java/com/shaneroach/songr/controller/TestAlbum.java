package com.shaneroach.songr.controller;

import com.shaneroach.songr.model.Album;
import org.junit.jupiter.api.Test;

public class TestAlbum {


    @Test
    void testMakeAlbum() {
        Album sut = new Album("Name", "Artist", 300, 4000, "this.jpg");
        assert(sut.getArtist().equals("Artist"));
    }


    @Test
    void testGetAlbum() {
        Album sut = new Album("Name", "Artist", 300, 4000, "this.jpg");
        assert(sut.getArtist().equals("Artist"));
    }


    @Test
    void testSetAlbum() {
        Album sut = new Album("Name", "Artist", 300, 4000, "this.jpg");
        sut.setArtist("Ben Howard");
        assert(sut.getArtist().equals("Ben Howard"));
    }
}
