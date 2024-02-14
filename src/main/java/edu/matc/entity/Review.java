package edu.matc.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table (name="reviews")
public class Review {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    private int id;

    @Column
    private String park;

    @Column
    private String campground;

    @Column
    private String campsite;

    @Column
    private String shade;

    @Column
    private String size;

    @Column
    private String bathroomAccess;

    @Column
    private String kidFriendliness;

    @Column
    private String dogFriendliness;

    @Column
    private String reviewText;

    @ManyToOne
    private User user;





}
