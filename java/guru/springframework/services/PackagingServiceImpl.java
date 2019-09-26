package guru.springframework.services;

import guru.springframework.commands.PackagingForm;
import guru.springframework.converters.PackagingFormToPackaging;
import guru.springframework.domain.Packaging;
import guru.springframework.repositories.PackagingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PackagingServiceImpl implements PackagingService {

    private PackagingRepository packagingRepository;
    private PackagingFormToPackaging packagingFormToPackaging;

    @Autowired
    public PackagingServiceImpl(PackagingRepository packagingRepository, PackagingFormToPackaging packagingFormToPackaging) {
        this.packagingRepository = packagingRepository;
        this.packagingFormToPackaging = packagingFormToPackaging;
    }

    @Override
    public List<Packaging> listAll() {
        List<Packaging> packagings = new ArrayList<>();
        packagingRepository.findAll().forEach(packagings::add); //fun with Java 8
        return packagings;
    }

    @Override
    public Packaging getById(Long id) {
        return packagingRepository.findById(id).orElse(null);
    }

    @Override
    public Packaging saveOrUpdate(Packaging packaging) {
        packagingRepository.save(packaging);
        return packaging;
    }

    @Override
    public void deletePackaging(Long id) {
        packagingRepository.deleteById(id);

    }

    @Override
    public Packaging saveOrUpdatePackagingForm(PackagingForm packagingForm) {
        Packaging savedPackaging= saveOrUpdate(packagingFormToPackaging.convert(packagingForm));

        System.out.println("Saved Product Id: " + savedPackaging.getPackagingTypeId());
        return savedPackaging;
    }

    @Override
    public String numOfElems() {
        String str = "";
        List<String> res = (List<String>) packagingRepository.findNumOfElems();
        str = res.toString();
        str = str.replaceAll("\\[", "").replaceAll("\\]", "");
        return str;
    }
}
