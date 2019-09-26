package guru.springframework.domain;


import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlRootElement(name = "beerTypeDescriptions")
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
public class BeerTypeDescr {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("beerTypeIdDesc")
    @XmlElement(name = "beerTypeIdDesc")
    private Long beerTypeId;

    @XmlElement(name = "description")
    @Column(length = 100000)
    private String description;

    @XmlElement(name = "beerTypeDescription")
    private ArrayList<BeerTypeDescr> beerTypeDescriptions;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBeerTypeId() {
        return beerTypeId;
    }

    public void setBeerTypeId(Long beerTypeId) {
        this.beerTypeId = beerTypeId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<BeerTypeDescr> getBeerTypeDescriptions() {
        return beerTypeDescriptions;
    }

    public void setBeerTypeDescriptions(ArrayList<BeerTypeDescr> beerTypeDescriptions) {
        this.beerTypeDescriptions = beerTypeDescriptions;
    }

    public BeerTypeDescr(Long beerTypeId, String description) {
        this.beerTypeId = beerTypeId;
        this.description = description;
    }

    public BeerTypeDescr() {
    }

}
