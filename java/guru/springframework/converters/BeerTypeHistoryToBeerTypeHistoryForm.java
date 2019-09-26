package guru.springframework.converters;

import guru.springframework.commands.BeerTypeHistoryForm;
import guru.springframework.domain.BeerTypeHistory;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;


@Component
public class BeerTypeHistoryToBeerTypeHistoryForm implements Converter<BeerTypeHistory, BeerTypeHistoryForm> {
    @Override
    public BeerTypeHistoryForm convert(BeerTypeHistory beerTypeHistory) {
        BeerTypeHistoryForm beerTypeHistoryForm = new BeerTypeHistoryForm();
        beerTypeHistoryForm.setId(beerTypeHistory.getId());
        beerTypeHistoryForm.setBeerTypeId(beerTypeHistory.getBeerTypeId());
        beerTypeHistoryForm.setHistory(beerTypeHistory.getHistory());
        return beerTypeHistoryForm;
    }
}
