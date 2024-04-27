package edu.matc.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.Objects;


/**
 * The type State park.
 */
@Entity
@Table(name="state_park")
public class StatePark {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    private int id;

    @Column(name="park_name")
    private String parkName;

    @Column(name="zip_code")
    private int zipcode;

    /**
     * Instantiates a new State park.
     */
    public StatePark() {
    }

    /**
     * Instantiates a new State park.
     *
     * @param parkName the park name
     * @param zipcode  the zipcode
     */
    public StatePark(String parkName, int zipcode) {
        this.parkName = parkName;
        this.zipcode = zipcode;
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
     * Gets park name.
     *
     * @return the park name
     */
    public String getParkName() {
        return parkName;
    }

    /**
     * Sets park name.
     *
     * @param parkName the park name
     */
    public void setParkName(String parkName) {
        this.parkName = parkName;
    }

    /**
     * Gets zipcode.
     *
     * @return the zipcode
     */
    public int getZipcode() {
        return zipcode;
    }

    /**
     * Sets zipcode.
     *
     * @param zipcode the zipcode
     */
    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }

    @Override
    public String toString() {
        return "StatePark{" +
                "id=" + id +
                ", parkName='" + parkName + '\'' +
                ", zipcode=" + zipcode +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StatePark statePark = (StatePark) o;
        return id == statePark.id && zipcode == statePark.zipcode && Objects.equals(parkName, statePark.parkName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, parkName, zipcode);
    }
}
