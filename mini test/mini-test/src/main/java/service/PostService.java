package service;

import model.Post;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.cglib.core.Local;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import repository.IPostRepository;

import java.time.LocalDateTime;
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

    public Page<Post> findAllPosts(String textSearch, String sortOrder, String sortProperty, int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize, Sort.by(Sort.Direction.fromString(sortOrder), sortProperty));
        return postRepository.findAllPostsWithPagination(textSearch, pageable);
    }

    public Iterable<Post> findAllPosts2(String textSearch) {
        return postRepository.findAllPosts(textSearch);
    }

    public Iterable<Post> findByTitleAndTimeCreated(String textSearch, String timeStart, String timeEnd) {
        return postRepository.findByTitleAndCreatedTime(textSearch, timeStart, timeEnd);
    }
}
