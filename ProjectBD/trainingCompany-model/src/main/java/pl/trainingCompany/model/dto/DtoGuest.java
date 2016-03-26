package pl.trainingCompany.model.dto;

import java.util.Date;

/**
 * Created by Sebastian on 2016-03-25.
 */
public class DtoGuest {

    private long Id;

    private Long offerId;

    private String sessionId;

    private Date date;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Long getOfferId() {
        return offerId;
    }

    public void setOfferId(Long offerId) {
        this.offerId = offerId;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
