package pl.trainingCompany.model;

import pl.trainingCompany.model.dto.DtoOfferCategory;

import java.util.List;

/**
 * Created by Kamil S on 2016-04-15.
 */
public class GetOfferPageRequestBody {
    private String query;
    private List<DtoOfferCategory> selectedOfferCategory;

    public GetOfferPageRequestBody() {
    }

    public GetOfferPageRequestBody(String query, List<DtoOfferCategory> selectedOfferCategory) {
        this.query = query;
        this.selectedOfferCategory = selectedOfferCategory;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public List<DtoOfferCategory> getSelectedOfferCategory() {
        return selectedOfferCategory;
    }

    public void setSelectedOfferCategory(List<DtoOfferCategory> selectedOfferCategory) {
        this.selectedOfferCategory = selectedOfferCategory;
    }
}
