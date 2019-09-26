package guru.springframework.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlRootElement(name = "beerTypes")
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
public class BeerType {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long beerTypeId;

    @XmlElement(name = "nameBeerType")
    @JsonProperty("nameBeerType")
    private String beerTypeName;


    @XmlElement(name = "beerType")
    private ArrayList<BeerType> beerTypesList;


    public Long getBeerTypeId() {
        return beerTypeId;
    }

    public void setBeerTypeId(Long beerTypeId) {
        this.beerTypeId = beerTypeId;
    }

    public String getBeerTypeName() {
        return beerTypeName;
    }

    public void setBeerTypeName(String beerTypeName) {
        this.beerTypeName = beerTypeName;
    }

    public BeerType(String beerTypeName){
        this.beerTypeName = beerTypeName;
    }

    public BeerType() { }

    public ArrayList<BeerType> getBeerTypesList() {
        return beerTypesList;
    }

    public void setBeerTypesList(ArrayList<BeerType> beerTypesList) {
        this.beerTypesList = beerTypesList;
    }
}
