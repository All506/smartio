package smartio.api.crud.models;


import javax.persistence.*;

@Entity
@Table(name="score")
public class ScoreModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private int intelligence_code;

    @Column
    private int score;

    @Column
    private int userId;


}
