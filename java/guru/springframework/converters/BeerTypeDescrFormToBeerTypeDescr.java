package guru.springframework.converters;

import guru.springframework.commands.BeerTypeDescrForm;
import guru.springframework.domain.BeerTypeDescr;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class BeerTypeDescrFormToBeerTypeDescr implements Converter<BeerTypeDescrForm, BeerTypeDescr> {
    @Override
    public BeerTypeDescr convert(BeerTypeDescrForm factoryForm) {
        BeerTypeDescr factory = new BeerTypeDescr();
        if (factoryForm.getId() != null && !StringUtils.isEmpty(factoryForm.getDescription())) {
            factory.setId(new Long(factoryForm.getId()));
        }
        factory.setBeerTypeId(factoryForm.getBeerTypeId());
        factory.setDescription(factoryForm.getDescription());
        return factory;
    }

}
