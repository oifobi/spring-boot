package guru.springframework.domain;

import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlRootElement(name = "packaging")
@XmlAccessorType(XmlAccessType.FIELD)@Entity
public class Packaging {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long packagingTypeId;

    @XmlElement(name = "packagingTypes")
    private String packagingTypes;

    @XmlElement(name = "packagings")
    private ArrayList<Packaging> packagings;



    public Long getPackagingTypeId() {
        return packagingTypeId;
    }

    public void setPackagingTypeId(Long packagingTypeId) {
        this.packagingTypeId = packagingTypeId;
    }


    public String getPackagingTypes() {
        return packagingTypes;
    }

    public void setPackagingTypes(String packagingTypes) {
        this.packagingTypes = packagingTypes;
    }

    public Packaging(String packagingTypes){
        this.packagingTypes = packagingTypes;
    }
    public  Packaging() { }

    public ArrayList<Packaging> getPackagings() {
        return packagings;
    }

    public void setPackagings(ArrayList<Packaging> packagings) {
        this.packagings = packagings;
    }
}
