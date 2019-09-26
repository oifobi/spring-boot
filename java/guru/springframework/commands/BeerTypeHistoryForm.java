package guru.springframework.commands;

public class BeerTypeHistoryForm {
    private Long id;

    private int beerTypeId;
    private String history;

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
}
