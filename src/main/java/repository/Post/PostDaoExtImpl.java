package repository.Post;

import domain.Contact_;
import domain.Post;
import domain.Post_;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Subquery;
import java.util.List;

@Repository
public class PostDaoExtImpl implements PostDaoExt{
    @PersistenceUnit
    private EntityManagerFactory emf;
    @PersistenceContext
    private EntityManager em;


    @Override
    public List<Post> findAndFilterSpecificPostList(){

        return null;
    }

    @Override
    public List<Post> getLastMessagesByUserId(Long id){
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery query = cb.createQuery(Post.class);
        Root root = query.from(Post.class);


        //Sub
        Subquery subQuery = query.subquery(Long.class);
        //CriteriaQuery subQuery = cb.createQuery(Long.class);
        Root subRoot = subQuery.from(Post.class);
        subQuery.select(cb.max(subRoot.get(Post_.id)));
        subQuery.where(cb.equal(subRoot.get(Post_.contact).get(Contact_.id), String.valueOf(id)));

        //Sub2
        CriteriaQuery subQuery2 = cb.createQuery(Long.class);
        Root subRoot2 = subQuery.from(Post.class);
        subQuery2.select(cb.max(subRoot.get(Post_.id)));
        subQuery2.where(cb.equal(subRoot.get(Post_.contact).get(Contact_.id), String.valueOf(id)));

        query.select(root)
            .where(
                cb.and(
                    cb.in(root.get(Post_.id)).value(subQuery),
                    cb.equal(subQuery, String.valueOf(7L))
                )
        );

        TypedQuery<Post> tq = em.createQuery(query);
        List<Post> pl = tq.getResultList();
        return pl;
    }

    @Override
    public Post getLastMessageByUserId(Long id){
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery query = cb.createQuery(Post.class);
        Root root = query.from(Post.class);
        query.select(root);

        TypedQuery<Post> tq = em.createQuery(query);
        Post post = tq.getSingleResult();
        return post;
    }

}
