package pl.trainingCompany.model.dbo;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Pawel on 20-May-16.
 */
@Entity
public class Comment {

    @Id
    @GeneratedValue
    private Long id;

    @Column(columnDefinition="varchar(500)")
    private String text;

    private Date date;

    private int rate;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account author;

    @ManyToOne
    @JoinColumn(name = "offer_id")
    private Offer offer;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Account getAuthor() {
        return author;
    }

    public void setAuthor(Account author) {
        this.author = author;
    }

    public Offer getOffer() {
        return offer;
    }

    public void setOffer(Offer offer) {
        this.offer = offer;
    }

    public Date getDate() {
        return date;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
