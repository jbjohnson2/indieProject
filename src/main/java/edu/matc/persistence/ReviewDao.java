
package edu.matc.persistence;



import edu.matc.entity.Review;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Expression;
import jakarta.persistence.criteria.Root;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;

import java.util.List;

/**
 * The type Review dao.
 */
public class ReviewDao {

    private final Logger logger = LogManager.getLogger(this.getClass());
    /**
     * The Session factory.
     */
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    /**
     * Get review by id
     *
     * @param id the id
     * @return the by id
     */
    public Review getById(int id) {
        Session session = sessionFactory.openSession();
        Review review = session.get(Review.class, id);
        session.close();
        return review;
    }

    /**
     * update review
     *
     * @param review Review to be updated
     */
    public void update(Review review) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.merge(review);
        transaction.commit();
        session.close();
    }

    /**
     * insert a new review
     *
     * @param review Review to be inserted
     * @return the int
     */
    public int insert(Review review) {
        int id = 0;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(review);
        transaction.commit();
        id = review.getId();
        session.close();
        return id;
    }

    /**
     * Delete a review
     *
     * @param review Review to be deleted
     */
    public void delete(Review review) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(review);
        transaction.commit();
        session.close();
    }


    /**
     * Return a list of all reviews
     *
     * @return All reviews
     */
    public List<Review> getAll() {

        Session session = sessionFactory.openSession();

        HibernateCriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Review> query = builder.createQuery(Review.class);
        Root<Review> root = query.from(Review.class);
        List<Review> reviews = session.createSelectionQuery( query ).getResultList();

        //logger.debug("The list of reviews " + reviews);
        session.close();

        return reviews;
    }

    /**
     * Get review by property (exact match)
     * sample usage: getByPropertyEqual("lastname", "Curry")
     *
     * @param propertyName the property name
     * @param value        the value
     * @return the by property equal
     */
    public List<Review> getByPropertyEqual(String propertyName, String value) {
        Session session = sessionFactory.openSession();

        //logger.debug("Searching for review with " + propertyName + " = " + value);

        HibernateCriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Review> query = builder.createQuery(Review.class);
        Root<Review> root = query.from(Review.class);
        query.select(root).where(builder.equal(root.get(propertyName), value));
        List<Review> reviews = session.createSelectionQuery( query ).getResultList();

        session.close();
        return reviews;
    }

    /**
     * Get review by property (like)
     * sample usage: getByPropertyLike("lastname", "C")
     *
     * @param propertyName the property name
     * @param value        the value
     * @return the by property like
     */
    public List<Review> getByPropertyLike(String propertyName, String value) {
        Session session = sessionFactory.openSession();

//        logger.debug("Searching for review with {} = {}",  propertyName, value);

        HibernateCriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Review> query = builder.createQuery(Review.class);
        Root<Review> root = query.from(Review.class);
        Expression<String> propertyPath = root.get(propertyName);

        query.where(builder.like(propertyPath, "%" + value + "%"));

        List<Review> reviews = session.createQuery( query ).getResultList();
        session.close();
        return reviews;
    }

}