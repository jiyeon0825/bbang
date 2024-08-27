package com.bread.bbangpang.board.controller;

import com.bread.bbangpang.board.dto.CategoryDTO;
import com.bread.bbangpang.board.service.CategoryService;
import com.bread.bbangpang.post.dto.PostDTO;
import com.bread.bbangpang.post.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/sidebar")
public class SidebarController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private PostService postService;

    @GetMapping
    public String getSidebar(Model model) {
        List<CategoryDTO> categories = categoryService.getAllCategories();


        model.addAttribute("categories", categories);


        return "client/sidebar";
    }
}
