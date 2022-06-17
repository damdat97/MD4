package service;

import model.Post;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import repository.IPostRepository;

import java.util.Optional;

@Service
public class PostService implements IPostService{
    @Autowired
    private IPostRepository postRepository;

    @Override
    public Iterable<Post> findAll() {
        return postRepository.findAll();
    }

    @Override
    public Optional<Post> findById(Long id) {
        return postRepository.findById(id);
    }

    @Override
    public void save(Post post) {
        postRepository.save(post);
    }

    @Override
    public void remove(Long id) {
        postRepository.deleteById(id);
    }

    public Iterable<Post> findByTitle(String title) {
        return postRepository.findAllByTitleContains(title);
    }

    public Iterable<Post> showListPostAsc() {
        return postRepository.findAllByLikesAsc();
    }

    public Iterable<Post> showTop4New() {
        return postRepository.findTop4New();
    }
}
