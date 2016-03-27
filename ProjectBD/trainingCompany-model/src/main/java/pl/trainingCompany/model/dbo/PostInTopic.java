package pl.trainingCompany.model.dbo;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by PM on 27.03.2016.
 * Trzeba zmienic basket!!
 */
@Entity
public class PostInTopic {

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    @JoinColumn(name = "topic_id")
    private Topic topic;

    private Date date;
    private String content;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }
}
