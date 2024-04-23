package edu.matc.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.Objects;

/**
 * The class to represent a  Review
 */
@Entity
@Table (name="reviews")
public class Review {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    private int id;

    @Column(name = "park")
    private String park;

    @Column(name = "campground")
    private String campground;

    @Column(name = "campsite")
    private String campsite;

    @Column(name = "shade")
    private String shade;

    @Column(name = "size")
    private String size;

    @Column(name = "bathroom_access")
    private String bathroomAccess;

    @Column(name = "kid_friendliness")
    private String kidFriendliness;

    @Column(name = "dog_friendliness")
    private String dogFriendliness;

    @Column(name = "review_text")
    private String reviewText;

    @ManyToOne
    private User user;


    /**
     * Instantiates a new Review.
     */
    public Review() {
    }

    /**
     * Instantiates a new Review.
     *
     * @param park            the park
     * @param campground      the campground
     * @param campsite        the campsite
     * @param shade           the shade
     * @param size            the size
     * @param bathroomAccess  the bathroom access
     * @param kidFriendliness the kid friendliness
     * @param dogFriendliness the dog friendliness
     * @param reviewText      the review text
     * @param user            the user
     */
    public Review(String park, String campground, String campsite, String shade, String size, String bathroomAccess, String kidFriendliness, String dogFriendliness, String reviewText, User user) {
        this.park = park;
        this.campground = campground;
        this.campsite = campsite;
        this.shade = shade;
        this.size = size;
        this.bathroomAccess = bathroomAccess;
        this.kidFriendliness = kidFriendliness;
        this.dogFriendliness = dogFriendliness;
        this.reviewText = reviewText;
        this.user = user;
    }


    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets park.
     *
     * @return the park
     */
    public String getPark() {
        return park;
    }

    /**
     * Sets park.
     *
     * @param park the park
     */
    public void setPark(String park) {
        this.park = park;
    }

    /**
     * Gets campground.
     *
     * @return the campground
     */
    public String getCampground() {
        return campground;
    }

    /**
     * Sets campground.
     *
     * @param campground the campground
     */
    public void setCampground(String campground) {
        this.campground = campground;
    }

    /**
     * Gets campsite.
     *
     * @return the campsite
     */
    public String getCampsite() {
        return campsite;
    }

    /**
     * Sets campsite.
     *
     * @param campsite the campsite
     */
    public void setCampsite(String campsite) {
        this.campsite = campsite;
    }

    /**
     * Gets shade.
     *
     * @return the shade
     */
    public String getShade() {
        return shade;
    }

    /**
     * Sets shade.
     *
     * @param shade the shade
     */
    public void setShade(String shade) {
        this.shade = shade;
    }

    /**
     * Gets size.
     *
     * @return the size
     */
    public String getSize() {
        return size;
    }

    /**
     * Sets size.
     *
     * @param size the size
     */
    public void setSize(String size) {
        this.size = size;
    }

    /**
     * Gets bathroom access.
     *
     * @return the bathroom access
     */
    public String getBathroomAccess() {
        return bathroomAccess;
    }

    /**
     * Sets bathroom access.
     *
     * @param bathroomAccess the bathroom access
     */
    public void setBathroomAccess(String bathroomAccess) {
        this.bathroomAccess = bathroomAccess;
    }

    /**
     * Gets kid friendliness.
     *
     * @return the kid friendliness
     */
    public String getKidFriendliness() {
        return kidFriendliness;
    }

    /**
     * Sets kid friendliness.
     *
     * @param kidFriendliness the kid friendliness
     */
    public void setKidFriendliness(String kidFriendliness) {
        this.kidFriendliness = kidFriendliness;
    }

    /**
     * Gets dog friendliness.
     *
     * @return the dog friendliness
     */
    public String getDogFriendliness() {
        return dogFriendliness;
    }

    /**
     * Sets dog friendliness.
     *
     * @param dogFriendliness the dog friendliness
     */
    public void setDogFriendliness(String dogFriendliness) {
        this.dogFriendliness = dogFriendliness;
    }

    /**
     * Gets review text.
     *
     * @return the review text
     */
    public String getReviewText() {
        return reviewText;
    }

    /**
     * Sets review text.
     *
     * @param reviewText the review text
     */
    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }

    /**
     * Gets user.
     *
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets user.
     *
     * @param user the user
     */
    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", park='" + park + '\'' +
                ", campground='" + campground + '\'' +
                ", campsite='" + campsite + '\'' +
                ", shade='" + shade + '\'' +
                ", size='" + size + '\'' +
                ", bathroomAccess='" + bathroomAccess + '\'' +
                ", kidFriendliness='" + kidFriendliness + '\'' +
                ", dogFriendliness='" + dogFriendliness + '\'' +
                ", reviewText='" + reviewText + '\'' +
                ", user=" + user +
                '}';
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Review review = (Review) o;
        return id == review.id &&
                Objects.equals(park, review.park) &&
                Objects.equals (campground, review.campground)  &&
                Objects.equals(shade, review.shade) &&
                Objects.equals(size, review.size) &&
                Objects.equals(bathroomAccess, review.bathroomAccess) &&
                Objects.equals(kidFriendliness, review.kidFriendliness) &&
                Objects.equals(dogFriendliness, review.dogFriendliness) &&
                Objects.equals(reviewText, review.reviewText);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, park, campground, shade, size, bathroomAccess,
                kidFriendliness, dogFriendliness);
    }
}


