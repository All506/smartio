package smartio.api.crud.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import smartio.api.crud.models.UserIntelligenceModel;
import java.util.List;

@Repository
public interface IUserIntelligenceRepository extends JpaRepository<UserIntelligenceModel, Long> {
}
