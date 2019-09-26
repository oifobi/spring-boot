package guru.springframework.converters;

import guru.springframework.commands.PackagingForm;
import guru.springframework.domain.Packaging;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;


@Component
public class PackagingFormToPackaging implements Converter<PackagingForm, Packaging> {

    @Override
    public Packaging convert(PackagingForm packagingForm) {
        Packaging packaging = new Packaging();
        if (packagingForm.getPackagingTypeId() != null  && !StringUtils.isEmpty(packagingForm.getPackagingTypes())) {
            packaging.setPackagingTypeId(new Long(packagingForm.getPackagingTypeId()));
        }
        packaging.setPackagingTypes(packagingForm.getPackagingTypes());
        return packaging;
    }
}
