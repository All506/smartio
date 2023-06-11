package smartio.api.crud.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import smartio.api.crud.models.UserModel;
import smartio.api.crud.models.UserScoreProjection;

import java.util.List;
import java.util.Map;

@Repository
public interface IUserRepository extends JpaRepository<UserModel, Long> {
    UserModel findByEmail(String email);

    @Query("SELECT u.id as userId, u.name as userName,s.intelligence_code as intelligence , s.score as scores " +
            "FROM UserModel u , ScoreModel s" +
            " WHERE s.user.id = u.id")
    List<UserScoreProjection> findUserScoresById();
}
