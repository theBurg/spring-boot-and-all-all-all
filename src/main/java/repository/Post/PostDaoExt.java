package repository.Post;

import domain.Contact;
import domain.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostDaoExt {
    List<Post> findAndFilterSpecificPostList();
    Post getLastMessageByUserId(Long id);
    List<Post> getLastMessagesByUserId(Long id);
}
