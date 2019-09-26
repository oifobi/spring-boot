package guru.springframework.converters;

import guru.springframework.commands.ManForm;
import guru.springframework.domain.Man;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ManToManForm implements Converter<Man, ManForm> {
    @Override
    public ManForm convert(Man factory) {
        ManForm factoryForm = new ManForm();
        factoryForm.setId(factory.getId());
        factoryForm.setName(factory.getName());
        return factoryForm;
    }
}
