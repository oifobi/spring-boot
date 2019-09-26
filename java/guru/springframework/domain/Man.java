package guru.springframework.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlRootElement(name = "root")
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
public class Man {
    @Id
    @GeneratedValue
    private Long id;

    @XmlElement(name = "manufacturerName")
    @JsonProperty("manufacturerName")
    private String name;

    @XmlElement(name = "element")
    private ArrayList<Man> manufacturers;

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

    public ArrayList<Man> getManufacturers() {
        return manufacturers;
    }

    public void setManufacturers(ArrayList<Man> manufacturers) {
        this.manufacturers = manufacturers;
    }

    public Man(String name) {
        this.name = name;
    }

    public Man() { }
}
