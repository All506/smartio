package smartio.api.crud.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import smartio.api.crud.models.ScoreModel;
import smartio.api.crud.models.UserModel;

@Repository
public interface IScoreRepository extends JpaRepository<ScoreModel, Long> {
    @Modifying
    @Query("INSERT INTO Score (codigoInteligencia, score, user) VALUES (:codigoInteligencia, :score, :user)")
    void insertScore(@Param("codigoInteligencia") int codigoInteligencia, @Param("score") int score, @Param("user") UserModel user);
}
