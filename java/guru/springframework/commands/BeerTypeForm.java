package guru.springframework.commands;

public class BeerTypeForm {
    private Long beerTypeId;

    private String beerTypeName;

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
}
