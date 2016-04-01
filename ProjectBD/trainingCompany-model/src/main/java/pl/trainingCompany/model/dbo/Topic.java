package pl.trainingCompany.model.dbo;

import javax.persistence.*;
import java.util.List;

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
    @JoinColumn(name = "section_id")
    private Section section;

    @OneToMany(mappedBy = "topic")
    private List<PostInTopic> posts;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account author;

    public List<PostInTopic> getPosts() {
        return posts;
    }

    public void setPosts(List<PostInTopic> posts) {
        this.posts = posts;
    }

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

    public Account getAuthor() {
        return author;
    }

    public void setAuthor(Account author) {
        this.author = author;
    }
}
