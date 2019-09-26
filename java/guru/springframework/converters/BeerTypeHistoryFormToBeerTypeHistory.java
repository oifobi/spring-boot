package guru.springframework.converters;

import guru.springframework.commands.BeerTypeHistoryForm;
import guru.springframework.domain.BeerTypeHistory;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class BeerTypeHistoryFormToBeerTypeHistory implements Converter<BeerTypeHistoryForm, BeerTypeHistory> {

    @Override
    public BeerTypeHistory convert(BeerTypeHistoryForm beerTypeHistoryForm) {
        BeerTypeHistory beerTypeHistory = new BeerTypeHistory();
        if (beerTypeHistoryForm.getId() != null  && !StringUtils.isEmpty(beerTypeHistoryForm.getHistory())) {
            beerTypeHistory.setId(new Long(beerTypeHistoryForm.getId()));
        }
        beerTypeHistory.setBeerTypeId(beerTypeHistoryForm.getBeerTypeId());
        beerTypeHistory.setHistory(beerTypeHistoryForm.getHistory());
        return beerTypeHistory;
    }
}
