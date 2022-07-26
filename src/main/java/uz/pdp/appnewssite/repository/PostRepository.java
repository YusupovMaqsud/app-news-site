package uz.pdp.appnewssite.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.appnewssite.entity.Lavozim;
import uz.pdp.appnewssite.entity.Post;

import java.util.Optional;

public interface PostRepository extends JpaRepository<Post,Long> {
    boolean existsByTitle(String title);
}
