package smartio.api.crud.models;


import javax.persistence.*;

@Entity
@Table(name="user_intelligence")
public class UserIntelligenceModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private int score1;

    @Column
    private int score2;

    @Column
    private int score3;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idUser")
    private UserModel user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idIntelligence")
    private IntelligenceModel intelligence;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getScore1() {
        return score1;
    }

    public void setScore1(int score1) {
        this.score1 = score1;
    }

    public int getScore2() {
        return score2;
    }

    public void setScore2(int score2) {
        this.score2 = score2;
    }

    public int getScore3() {
        return score3;
    }

    public void setScore3(int score3) {
        this.score3 = score3;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    public IntelligenceModel getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(IntelligenceModel intelligence) {
        this.intelligence = intelligence;
    }
}
