package repository;

import domain.Contact;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactDAO extends CrudRepository<Contact, Long> {
    List<Contact> findByPhoneNumber(String phone);
    boolean existsByPhoneNumber(String phone);
}
