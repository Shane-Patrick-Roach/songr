package com.shaneroach.songr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
public class AlbumController {

    @GetMapping("/albums")
    public String bffMethod(Model m){
        m.addAttribute("name", "Shane");
        ArrayList <Album> albumList = new ArrayList<>();

        Album ten = new Album("Ten", "Pearl Jam", 11, 3600, "https://upload.wikimedia.org/wikipedia/en/2/2d/PearlJam-Ten2.jpg");
        Album vs = new Album("Vs.", "Pearl Jam", 12, 3000, "https://upload.wikimedia.org/wikipedia/en/thumb/f/f9/PearlJam-Vs.jpg/220px-PearlJam-Vs.jpg");
        Album vitalogy = new Album("Vitalogy", "Pearl Jam", 14, 4000, "https://upload.wikimedia.org/wikipedia/en/thumb/3/30/PearlJamVitalogy.jpg/220px-PearlJamVitalogy.jpg");

        albumList.add(ten);
        albumList.add(vs);
        albumList.add(vitalogy);

        m.addAttribute("albums", albumList);

        return "albums.html";
    }
}
