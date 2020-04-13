package org.example.entity;


import javax.persistence.*;
import java.util.Objects;
@NamedQuery(name="findByArtist",query="SELECT a FROM Artists a WHERE a= :artist")

@Entity
public class Artists {
    private int id;
    private String name;
    private String country;

    public Artists(){}
    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "country")
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Artists artists = (Artists) o;
        return id == artists.id &&
                Objects.equals(name, artists.name) &&
                Objects.equals(country, artists.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, country);
    }
}
