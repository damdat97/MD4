package controller;

import model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import service.PostService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Controller
public class PostController {
    @Autowired
    private PostService postService;

    @GetMapping("/create-post")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("post" , new Post());
        return modelAndView;
    }

    @PostMapping("/create-post")
    public ModelAndView savePost(@ModelAttribute("post") Post post) {
        LocalDateTime time = LocalDateTime.now();
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String timePost = time.format(fmt);
        post.setCreateAt(timePost);
        postService.save(post);
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("post", new Post());
        modelAndView.addObject("message", "Create successfully");
        return modelAndView;
    }

    @GetMapping("/posts")
    public ModelAndView listPosts(@RequestParam(value = "textSearch", defaultValue = "") String textSearch) {
        Iterable<Post> posts = postService.findAllPosts2(textSearch);
//        Iterable<Post> posts = postService.findAll();
        ModelAndView modelAndView = new ModelAndView("/list");
        modelAndView.addObject("posts", posts);
        return modelAndView;
    }

    @GetMapping("/edit-post/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Optional<Post> post = postService.findById(id);
        if (post.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/edit");
            modelAndView.addObject("post", post.get());
            return modelAndView;

        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-post")
    public ModelAndView updateProvince(@ModelAttribute("post") Post post) {
        postService.save(post);
        ModelAndView modelAndView = new ModelAndView("/edit");
        modelAndView.addObject("post", post);
        modelAndView.addObject("message", "Post updated successfully");
        return modelAndView;
    }

    @PostMapping("/find")
    public ModelAndView findTitle(@RequestParam(value = "textSearch", defaultValue = "") String textSearch) {
        Iterable<Post> posts = postService.findAllPosts2(textSearch);
        ModelAndView modelAndView = new ModelAndView("/findByTitle");
        modelAndView.addObject("posts", posts);
        return modelAndView;
    }

    @PostMapping("/post-asc")
    public ModelAndView newPost() {
        Iterable<Post> posts = postService.showListPostAsc();
        ModelAndView modelAndView = new ModelAndView("/postListAsc");
        modelAndView.addObject("posts", posts);
        return modelAndView;
    }

    @PostMapping("/post-top4-new")
    public ModelAndView newPostTop4() {
        Iterable<Post> posts = postService.showTop4New();
        ModelAndView modelAndView = new ModelAndView("/postTop4New");
        modelAndView.addObject("posts", posts);
        return modelAndView;
    }

    @PostMapping("/find-title-timecreate")
    public ModelAndView findByTitleAndTimeCreate(@RequestParam(value = "textSearch", defaultValue = "") String textSearch,
                                                 @RequestParam(value = "timeStart") String timeStart,
                                                 @RequestParam(value = "timeEnd") String timeEnd) {
        Iterable<Post> posts = postService.findByTitleAndTimeCreated(textSearch, timeStart, timeEnd);
        ModelAndView modelAndView = new ModelAndView("/list");
        modelAndView.addObject("posts", posts);
        return modelAndView;
    }
}
