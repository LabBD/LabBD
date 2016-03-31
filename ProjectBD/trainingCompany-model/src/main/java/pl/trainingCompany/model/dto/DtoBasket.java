package pl.trainingCompany.model.dto;

/**
 * Created by Sebastian on 2016-03-25.
 */
public class DtoBasket {

    private long id;

    private Long accountId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }
}
