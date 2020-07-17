package com.aizek.ImageLibrary.controllers;

import com.aizek.ImageLibrary.models.Comment;
import com.aizek.ImageLibrary.repo.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ImageController {

    @Autowired
    private CommentRepository commentRepository;

    @GetMapping("/")
    public String GalleryMain(Model model){
        Iterable<Comment> comments = commentRepository.findAll();
        model.addAttribute("comments", comments);
        return "gallery-main";
    }


}
