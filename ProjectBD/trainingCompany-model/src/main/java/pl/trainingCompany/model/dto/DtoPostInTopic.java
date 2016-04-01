package pl.trainingCompany.model.dto;

/**
 * Created by PM on 28.03.2016.
 */
public class DtoPostInTopic {

    private long id;

    private long topicId;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getTopicId() {
        return topicId;
    }

    public void setTopicId(long topicId) {
        this.topicId = topicId;
    }
}
