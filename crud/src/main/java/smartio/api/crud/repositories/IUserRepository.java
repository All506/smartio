package smartio.api.crud.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import smartio.api.crud.models.UserModel;

import java.util.List;
import java.util.Map;

@Repository
public interface IUserRepository extends JpaRepository<UserModel, Long> {
    UserModel findByEmail(String email);

    @Query("SELECT s.user.id AS userId, " +
            "NEW map(s.intelligence_code AS intelligenceCode, s.score AS score) AS score " +
            "FROM ScoreModel s " +
            "WHERE s.user.id = :userId")
    List<Object> findUserScores(Long userId);
}
