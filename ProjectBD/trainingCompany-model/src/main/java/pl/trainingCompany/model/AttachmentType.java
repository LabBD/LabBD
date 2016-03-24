package pl.trainingCompany.model;

/**
 * Created by Kamil S on 2016-03-24.
 */
public enum AttachmentType {
    PHOTO, MOVIE, DOCUMENT ;

    public String attachmentType;

    private  AttachmentType() {

    }

    private  AttachmentType(String attachmentType) {
        this.attachmentType = attachmentType;
    }
}
