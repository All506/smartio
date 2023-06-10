package smartio.api.crud.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import smartio.api.crud.models.ScoreModel;
import smartio.api.crud.models.UserModel;

import java.util.List;

@Repository
public interface IScoreRepository extends JpaRepository<ScoreModel, Long> {

}
