package guru.springframework.Queries;

import guru.springframework.domain.Beer;
import guru.springframework.domain.BeerTypeHistory;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name="beerTypeHistories")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso({BeerTypeHistory.class})
public class BeerTypeHistories {
    @XmlElement(name = "beerTypeHistory")
    private List<Beer> beerTypeHistories = null;

    public List<Beer> getBeerTypeHistories() {
        return beerTypeHistories;
    }

    public void setBeerTypeHistories(List<?> beerTypeHistories) {
        this.beerTypeHistories = (List<Beer>) beerTypeHistories;
    }
}