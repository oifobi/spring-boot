package guru.springframework.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlRootElement(name = "beer")
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
public class Beer {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;


    @XmlElement(name = "name")
    private String name;

    @XmlElement(name = "description")
    @Column( length = 100000 )
    private String description;

    @XmlElement(name = "country")
    private String country;

    @XmlElement(name = "alc")
    private double alc;

    @XmlElement(name = "beerTypeId")
    private Long beerTypeId;

    @XmlElement(name = "manufacturerId")
    private Long manufacturerId;

    @XmlElement(name = "packageTypeId")
    @JsonProperty("packageTypeId")
    private Long packagingTypeId;

    @JsonIgnore
    @XmlElement(name = "beers")
    private ArrayList<Beer> beers;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public double getAlc() {
        return alc;
    }

    public void setAlc(double alc) {
        this.alc = alc;
    }

    public Long getBeerTypeId() {
        return beerTypeId;
    }

    public void setBeerTypeId(Long beerTypeId) {
        this.beerTypeId = beerTypeId;
    }

    public Long getManufacturerId() {
        return manufacturerId;
    }

    public void setManufacturerId(Long manufacturerId) {
        this.manufacturerId = manufacturerId;
    }

    public Long getPackagingTypeId() {
        return packagingTypeId;
    }

    public void setPackagingTypeId(Long packagingTypeId) {
        this.packagingTypeId = packagingTypeId;
    }

    public Beer(){  }

    public Beer(String name, String description, String country, double alc, Long beerTypeId, Long manufacturerId, Long packagingTypeId){
        this.name = name;
        this.description = description;
        this.country = country;
        this.alc = alc;
        this.beerTypeId = beerTypeId;
        this.manufacturerId = manufacturerId;
        this.packagingTypeId = packagingTypeId;
    }

    public ArrayList<Beer> getBeers() {
        return beers;
    }

    public void setBeers(ArrayList<Beer> beers) {
        this.beers = beers;
    }
}
