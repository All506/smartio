package smartio.api.crud.models;


import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="intelligence")
public class IntelligenceModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String code;

    @Column
    private String name;

    @OneToMany(mappedBy="intelligence")
    List<UserIntelligenceModel> intelligenceList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<UserIntelligenceModel> getIntelligenceList() {
        return intelligenceList;
    }

    public void setIntelligenceList(List<UserIntelligenceModel> intelligenceList) {
        this.intelligenceList = intelligenceList;
    }
}
