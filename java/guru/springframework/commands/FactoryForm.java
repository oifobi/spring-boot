package guru.springframework.commands;

import java.time.LocalDate;

public class FactoryForm {
    private Long id;

    private Long manufacturerId;

    private String location;

    //private LocalDate yearOfFoundation;


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



    public FactoryForm(){ }

    /*public LocalDate getYearOfFoundation() {
        return yearOfFoundation;
    }

    public void setYearOfFoundation(LocalDate yearOfFoundation) {
        this.yearOfFoundation = yearOfFoundation;
    }*/
}
