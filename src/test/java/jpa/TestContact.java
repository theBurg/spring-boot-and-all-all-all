package jpa;


import app.Application;
import domain.Contact;
import domain.Post;
import mock.InitDB;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import repository.ContactDAO;
import repository.Post.PostDAO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Iterator;
import java.util.List;

@RunWith(SpringRunner.class)
//@ContextConfiguration(classes=MyApp.class, loader=SpringApplicationContextLoader.class)
@SpringBootTest(classes = Application.class)
@AutoConfigureTestDatabase()
//@DataJpaTest()
public class TestContact {

    boolean isInit = false;

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    ContactDAO contactDAO;
    @Autowired
    PostDAO postDAO;

    //@BeforeClass
    //@AfterClass
    //@Before
    public void initDB(){
        if(isInit){
            return;
        }
        List<Contact> cl = InitDB.AddContacts(contactDAO);
        InitDB.AddPosts(postDAO, cl);
    }
    //@After


    // Всё
    @Test
    public void www(){
        initDB();
        Iterator<Contact> iC = contactDAO.findAll().iterator();
        while (iC.hasNext()){
            Contact c = iC.next();
            postDAO
                .findByContact(c)
                .forEach(post ->
                    System.out.println(post.getMessage()));
        }
    }

    // Крайний мессадж
    @Test
    public void lastMsg(){
        initDB();
        List<Post> lp = postDAO.getLastMessagesByUserId(1L);
        lp.forEach(post -> System.out.println(post.getMessage()));
    }

//    @Test
//    public void ww(){
//        contactDAO
//                .findAll()
//                .forEach((c) ->  System.out.println(c.getId()) );
//        System.out.println("dfasde");
//    }
}
