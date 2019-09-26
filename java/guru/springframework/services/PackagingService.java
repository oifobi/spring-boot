package guru.springframework.services;

import guru.springframework.commands.PackagingForm;
import guru.springframework.domain.Packaging;

import java.util.List;

public interface PackagingService {
    List<Packaging> listAll();

    Packaging getById(Long id);

    Packaging saveOrUpdate(Packaging packaging);

    void deletePackaging(Long id);

    Packaging saveOrUpdatePackagingForm(PackagingForm packagingForm);

    String numOfElems();

}
