package guru.springframework.services;

import guru.springframework.commands.ManForm;
import guru.springframework.domain.Man;

import java.util.List;

public interface ManService {
    List<Man> listAll();

    Man getById(Long id);

    Man saveOrUpdate(Man man);

    void deleteMan(Long id);

    Man saveOrUpdateManForm(ManForm manForm);

    String numOfElems();

}
