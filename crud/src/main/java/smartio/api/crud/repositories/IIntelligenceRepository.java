package smartio.api.crud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import smartio.api.crud.models.IntelligenceModel;
import java.util.Optional;

@Repository
public interface IIntelligenceRepository extends JpaRepository<IntelligenceModel, Long>{
    //
}
