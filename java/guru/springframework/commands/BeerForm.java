package guru.springframework.commands;

public class BeerForm {
    private Long id;

    private String name;

    private String description;

    private String country;

    private double alc;

    private Long beerTypeId;

    private Long manufacturerId;

    private Long packagingTypeId;

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
}
