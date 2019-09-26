package guru.springframework.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlRootElement(name = "beerTypeHistory")
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
public class BeerTypeHistory {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @XmlElement(name = "beerTypeIdHist")
    @JsonProperty("beerTypeIdHist")
    private int beerTypeId;

    @XmlElement(name = "history")
    @Column( length = 100000 )
    private String history;

    @JsonIgnore
    @XmlElement(name = "beerTypeHistories")
    private ArrayList<BeerTypeHistory> beerTypeHistories;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public int getBeerTypeId() {
        return beerTypeId;
    }

    public void setBeerTypeId(int beerTypeId) {
        this.beerTypeId = beerTypeId;
    }

    public BeerTypeHistory(int beerTypeId, String history){
        this.beerTypeId = beerTypeId;
        this.history = history;
    }

    public  BeerTypeHistory() { }

    public ArrayList<BeerTypeHistory> getBeerTypeHistories() {
        return beerTypeHistories;
    }

    public void setBeerTypeHistories(ArrayList<BeerTypeHistory> beerTypeHistories) {
        this.beerTypeHistories = beerTypeHistories;
    }
}
