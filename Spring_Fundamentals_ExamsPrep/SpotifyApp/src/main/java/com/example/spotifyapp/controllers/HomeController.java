package com.example.spotifyapp.controllers;

import com.example.spotifyapp.models.dtos.SongDTO;
import com.example.spotifyapp.models.enums.StyleName;
import com.example.spotifyapp.repositories.SongRepository;
import com.example.spotifyapp.services.SongService;
import com.example.spotifyapp.session.LoggedUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {
    private final LoggedUser loggedUser;

    private final SongRepository songRepository;

    private final SongService songService;

    @Autowired
    public HomeController(LoggedUser loggedUser, SongRepository songRepository, SongService songService) {
        this.loggedUser = loggedUser;
        this.songRepository = songRepository;
        this.songService = songService;
    }

    @GetMapping("/")
    public String getIndexPage() {
        return "index";
    }

    @GetMapping("/home")
    public String getHomePage(Model model) {
        if (!loggedUser.isUserLoggedIn()) {
            return "redirect:/";
        }
        List<SongDTO> popSongs = this.songService.getAllSongs(StyleName.POP);
        model.addAttribute("popSongs", popSongs);
        List<SongDTO> rockSongs = this.songService.getAllSongs(StyleName.ROCK);
        model.addAttribute("rockSongs", rockSongs);
        List<SongDTO> jazzSongs = this.songService.getAllSongs(StyleName.JAZZ);
        model.addAttribute("jazzSongs", jazzSongs);
        List<SongDTO> userSongs = this.songService.getUserPlaylist(loggedUser);
        model.addAttribute("userPlaylist", userSongs);

        int totalSum = this.songService.getUserPlaylist(loggedUser).stream().mapToInt(SongDTO::getDurationOnlyInSeconds).sum();
        Integer minutesOfPlaylist = totalSum / 60;
        Integer secondsOfPlaylist = totalSum % 60;
        String minutesToString = String.format("%d", minutesOfPlaylist);
        String secondsToString = String.format("%02d", secondsOfPlaylist);

        model.addAttribute("minutesToString", minutesToString);
        model.addAttribute("secondsToString", secondsToString);
        return "home";
    }




}
