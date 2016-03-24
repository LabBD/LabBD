package pl.trainingCompany.model.dto;

/**
 * Created by Mateusz on 2016-03-24.
 */
public class DtoOfferCategory {
    private long id;

    private String name;
    private String description;
    private long idFk;              // przy tym daliśmy pytajnik więc pole do przemyślenia :)

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getIdFk() {
        return idFk;
    }

    public void setIdFk(long idFk) {
        this.idFk = idFk;
    }
}
