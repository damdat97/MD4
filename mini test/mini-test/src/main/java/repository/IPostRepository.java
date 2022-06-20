package repository;

import model.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;

public interface IPostRepository extends JpaRepository<Post, Long> {

    @Query(value = "select p from Post p where lower(p.title) like(concat('%', lower(:textSearch), '%'))")
    Iterable<Post> findAllPosts(@Param("textSearch") String textSearch);

    @Query(value = "select p from Post p where lower(p.title) like(concat('%', lower(:textSearch), '%'))")
    Page<Post> findAllPostsWithPagination(@Param("textSearch") String textSearch, Pageable pageable);

    Iterable<Post> findAllByTitleContains(String title);

    @Query(value = "select * from post order by likes asc", nativeQuery = true)
    Iterable<Post> findAllByLikesAsc();

    @Query(value = "select * from post order by createAt desc limit 4", nativeQuery = true)
    Iterable<Post> findTop4New();

    @Query(value = "select * from Post p where lower(p.title) like(concat('%', lower(:textSearch), '%')) and (p.createAt between :timeStart and :timeEnd);", nativeQuery = true)
    Iterable<Post> findByTitleAndCreatedTime(@Param("textSearch") String textSearch, @Param("timeStart") String timeStart, @Param("timeEnd") String timeEnd);
}
