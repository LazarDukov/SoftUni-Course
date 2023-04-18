package com.example.spotifyapp.controllers;

import com.example.spotifyapp.models.dtos.AddSongDTO;
import com.example.spotifyapp.services.SongService;
import com.example.spotifyapp.session.LoggedUser;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SongController {

    private final LoggedUser loggedUser;

    private final SongService songService;

    public SongController(LoggedUser loggedUser, SongService songService) {
        this.loggedUser = loggedUser;
        this.songService = songService;
    }

    @ModelAttribute("addSongDTO")
    private AddSongDTO addSongDTO() {
        return new AddSongDTO();
    }

    @GetMapping("/song/add")
    public String getAddSongPage() {
        if (!this.loggedUser.isUserLoggedIn()) {
            return "redirect:/";
        }
        return "song-add";
    }

    @PostMapping("/song/add")
    public String addSong(@Valid AddSongDTO addSongDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("addSongDTO", addSongDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.addSongDTO", bindingResult);
            return "redirect:/song/add";
        }

        this.songService.addSong(addSongDTO);
        return "redirect:/home";

    }
}
