package mock;

import domain.Contact;
import domain.Post;
import lombok.experimental.Accessors;
import repository.ContactDAO;
import repository.Post.PostDAO;

import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Accessors(chain = true)
public class InitDB {

    ;

    public static void init(){
        return ;
    }
    public static /*Expression*/ List<Contact> AddContacts(ContactDAO contactDAO){
        ArrayList<Contact> cl = new ArrayList<>(Arrays.asList(
            new Contact()
                .setFirstName("fn")
                .setMiddleName("mn")
                .setLastName("ln")
                .setPhoneNumber("+100500")
                .setImg("boris.png"),
            new Contact( null,"Боря", "Михайлович", "Моисеев", "111-222", "boris.png", new HashSet<>()),
            new Contact( null,"БорисКО", "Михайлович", "Моисеев", "222-333", "boris.png", new HashSet<>()),
            new Contact( null,"Борис", "Михайлович", "Моисеев", "322-233", "boris.png", new HashSet<>())
        ));
        //Save
        contactDAO.saveAll(cl);
        //return cPosts::AddPosts;
        return cl;
    }
//    private static class cPosts{
//        public static Expression AddPosts(ContactDAO contactDAO) {
//            ArrayList<Contact> cl = new ArrayList<>(Arrays.asList(
//                    new Contact()
//                            .setFirstName("fn")
//                            .setMiddleName("mn")
//                            .setLastName("ln")
//                            .setPhoneNumber("+100500")
//                            .setImg("boris.png"),
//                    new Contact(null, "Боря", "Михайлович", "Моисеев", "111-222", "boris.png", new HashSet<>()),
//                    new Contact(null, "БорисКО", "Михайлович", "Моисеев", "222-333", "boris.png", new HashSet<>()),
//                    new Contact(null, "Борис", "Михайлович", "Моисеев", "322-233", "boris.png", new HashSet<>())
//            ));
//            //Save
//            contactDAO.saveAll(cl);
//        }
//
//    }

    public static void AddPosts(PostDAO postDAO, List<Contact> lc){
        String format = "msg_%d_%d";
        AtomicInteger c = new AtomicInteger(0);
        LocalDate date = LocalDate.now();
        ArrayList<Post> apl = new ArrayList();
        lc.forEach((contact -> {
            ArrayList<Post> pl = new ArrayList<>(Arrays.asList(
                    new Post()
                            .setContact(contact)
                            .setMessage( String.format(format, contact.getId(), c.getAndIncrement()) )
                            .setSendTimeLocalDate( date.minusDays(1).minusMonths(contact.getId()) ),
                    new Post()
                            .setContact(contact)
                            .setMessage( String.format(format, contact.getId(), c.getAndIncrement()) )
                            .setSendTimeLocalDate( date.minusDays(2).minusMonths(contact.getId()) ),
                    new Post()
                            .setContact(contact)
                            .setMessage( String.format(format, contact.getId(), c.getAndIncrement()) )
                            .setSendTime( new Date())
            ));
            apl.addAll(pl);
        }));
        //Save
        postDAO.saveAll(apl);
        //return cPosts::AddPosts;
    }

}
