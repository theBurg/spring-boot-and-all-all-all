package repository.Post;

import domain.Contact;
import domain.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostDAO extends CrudRepository<Post, Long>, PostDaoExt {
    List<Post> findByContact(Contact contact);
}
