package smartio.api.crud.models;



import javax.persistence.*;

@Entity
@Table(name="score")
public class ScoreModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private int intelligence_code;

    @Column
    private int score;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="user_id")
    private UserModel user;

    public ScoreModel() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getIntelligence_code() {
        return intelligence_code;
    }

    public void setIntelligence_code(int intelligence_code) {
        this.intelligence_code = intelligence_code;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }
}
