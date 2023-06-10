package smartio.api.crud.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import smartio.api.crud.models.ScoreModel;

@Repository
public interface IScoreRepository extends JpaRepository<ScoreModel, Long> {

}
