package pl.trainingCompany.model.dbo;

import pl.trainingCompany.model.AttachmentType;

import javax.persistence.*;

/**
 * Created by Kamil S on 2016-03-20.
 */
@Entity
public class Attachment {

    @Id
    @GeneratedValue
    private long id;

    private String name;

    private AttachmentType attachmentType;

    @ManyToOne
    @JoinColumn(name = "offer_id")
    private Offer offer;

    @ManyToOne
    @JoinColumn(name = "post_in_topic_id")
    private PostInTopic postInTopic;

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

    public Offer getOffer() {
        return offer;
    }

    public void setOffer(Offer offer) {
        this.offer = offer;
    }

    public AttachmentType getAttachmentType() {
        return attachmentType;
    }

    public void setAttachmentType(AttachmentType attachmentType) {
        this.attachmentType = attachmentType;
    }

    public PostInTopic getPostInTopic() {
        return postInTopic;
    }

    public void setPostInTopic(PostInTopic postInTopic) {
        this.postInTopic = postInTopic;
    }
}
