package pl.trainingCompany.model.dbo;

import javax.persistence.*;

/**
 * Created by Pawel on 24-Mar-16.
 */
@Entity
public class Topic {
    @Id
    @GeneratedValue
    private long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "section_id") //powinno byc IMO section_id
    private Section section;

    @ManyToOne
    private User author;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }
}
