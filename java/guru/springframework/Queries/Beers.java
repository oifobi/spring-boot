package guru.springframework.Queries;

import guru.springframework.domain.Beer;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name="beers")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso({Beer.class})
public class Beers {
    @XmlElement(name = "beer")
    private List<Beer> beers = null;

    public List<Beer> getBeers() {
        return beers;
    }

    public void setBeers(List<?> beers) {
        this.beers = (List<Beer>) beers;
    }
}
