package guru.springframework.repositories;

import guru.springframework.domain.BeerTypeHistory;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BeerTypeHistoryRepository extends CrudRepository<BeerTypeHistory, Long> {
    @Query("select count(b) from BeerTypeHistory b")
    List<?> findNumOfElems();
}
