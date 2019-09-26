package guru.springframework.repositories;

import guru.springframework.domain.BeerType;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BeerTypeRepository extends CrudRepository<BeerType, Long> {
    @Query("select count(b) from BeerType b")
    List<?> findNumOfElems();
}
