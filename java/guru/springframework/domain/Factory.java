package guru.springframework.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;
import java.util.ArrayList;

@Entity
public class Factory {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private Long manufacturerId;

    private String location;

    /*@JsonIgnore
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    @JsonDeserialize(using= LocalDateDeserializer.class)
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDate yearOfFoundation;*/


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Long getManufacturerId() {
        return manufacturerId;
    }

    public void setManufacturerId(Long manufacturerId) {
        this.manufacturerId = manufacturerId;
    }

    public Factory(Long manufacturerId, String location){
        this.manufacturerId = manufacturerId;
        this.location = location;
    }

    public Factory(){ }

    /*public LocalDate getYearOfFoundation() {
        return yearOfFoundation;
    }

    public void setYearOfFoundation(LocalDate yearOfFoundation) {
        this.yearOfFoundation = yearOfFoundation;
    }*/

}
