package edu.codeup.codeupspringblog.models;

import jakarta.persistence.*;
import org.springframework.web.bind.annotation.*;

@Entity
@Table(name="blog_posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false, columnDefinition = "TEXT")
    private String body;

    public Post(long id, String title, String body) {
        this.id = id;
        this.title = title;
        this.body = body;
    }

    @GetMapping("/create")
    @ResponseBody
    public String showCreatePostView() {
        return "view the form for creating a post";
    }

    @PostMapping("/create")
    public String createPost(
            @RequestParam("title") String title,
            @RequestParam("body") String body
    ) {
        Post newPost = Post(title, body);
        postDao.save(newPost)
    }


    @GetMapping("/")
    public String viewIndividual(@PathVariable long id, Model vmodel) {
        vmodel.addAttribute("blogpost", blogPostList.get((Int) id -1));
        return "blogposts/show";
    }

}
