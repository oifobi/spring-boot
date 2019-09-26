package guru.springframework.commands;

public class BeerTypeDescrForm {
    private Long id;

    private Long beerTypeId;

    private String description;


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
}
