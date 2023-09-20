package edu.codeup.codeupspringblog.controllers;

import edu.codeup.codeupspringblog.models.BlogPost;
import edu.codeup.codeupspringblog.models.User;
import edu.codeup.codeupspringblog.repositories.BlogPostRepository;
import edu.codeup.codeupspringblog.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/posts")
public class BlogPostController {

    private BlogPostRepository blogPostDao;
    private UserRepository userDao;

    public BlogPostController(BlogPostRepository blogPostDao, UserRepository userDao) {
        this.blogPostDao = blogPostDao;
        this.userDao = userDao;
    }

//    private List<BlogPost> blogPostsList =  new ArrayList<>(Arrays.asList(
//        new BlogPost("A Day in the Life", "Yadda yadda yadda yaa..."),
//        new BlogPost("Another Day in the Life", "Adda yadda yadda yadda yaa..."),
//        new BlogPost("Yet Another Day in the Life", "Wadda adda yadda yadda yadda yaa...")
//    ));

    @GetMapping
    public String indexPage(Model vModel) {
        vModel.addAttribute("blogposts", blogPostDao.findAll());
        return "blogposts/index";
    }

    @GetMapping("/{id}")
    public String viewIndividualPost(@PathVariable long id, Model vModel) {
        if(blogPostDao.existsById(id)) {
            BlogPost post = blogPostDao.findById(id).get();
            vModel.addAttribute("blogpost", post);
            return "blogposts/show";
        }
        return "redirect:/posts";
    }

    @GetMapping("/create")
    public String showCreatePostView() {
        return "blogposts/create";
    }

    @PostMapping("/create")
    public String createPost(
            @RequestParam("title") String title,
            @RequestParam("body") String body
    ) {
        // Hard Coded user SaintSteve
        User hardCodedUser = userDao.findById(2L).get();
        BlogPost newPost = new BlogPost(title, body, hardCodedUser);
        blogPostDao.save(newPost);
        return "redirect:/posts";
    }

}