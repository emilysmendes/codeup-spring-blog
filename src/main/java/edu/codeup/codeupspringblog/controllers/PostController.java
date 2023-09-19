package edu.codeup.codeupspringblog.controllers;

import edu.codeup.codeupspringblog.models.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/posts")
public class PostController {

    private PostRepository postDao;

    public PostController(PostRepository postDao) {
        this.postDao = postDao;
    }

    @GetMapping("")
    @ResponseBody
    public String indexPage() {
        return "posts index page";
    }

    @GetMapping("/{id}")
    @ResponseBody
    public String viewIndividualPost(@PathVariable long id) {
        return "view an individual post";
    }

    @GetMapping("/create")
    @ResponseBody
    public String showCreatePostView() {
        return "view the form for creating a post";
    }

    @PostMapping("/create")
    @ResponseBody
    public String createPost() {
        return "create a new post";
    }

}
