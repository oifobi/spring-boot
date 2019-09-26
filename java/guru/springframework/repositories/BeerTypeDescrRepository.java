package guru.springframework.repositories;

import guru.springframework.domain.BeerTypeDescr;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BeerTypeDescrRepository extends CrudRepository<BeerTypeDescr, Long> {
    @Query("select count(b) from BeerTypeDescr b")
    List<?> findNumOfElems();
}
