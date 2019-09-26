package guru.springframework.converters;

import guru.springframework.commands.ManForm;
import guru.springframework.domain.Man;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class ManFormToMan implements Converter<ManForm, Man> {
    @Override
    public Man convert(ManForm factoryForm) {
        Man factory = new Man();
        if (factoryForm.getId() != null && !StringUtils.isEmpty(factoryForm.getName())) {
            factory.setId(new Long(factoryForm.getId()));
        }
        factory.setName(factoryForm.getName());
        return factory;
    }
}
