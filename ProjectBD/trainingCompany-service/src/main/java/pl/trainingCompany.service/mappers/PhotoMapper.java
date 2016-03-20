package pl.trainingCompany.service.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.trainingCompany.model.dbo.Offer;
import pl.trainingCompany.model.dbo.Photo;
import pl.trainingCompany.model.dto.DtoPhoto;
import pl.trainingCompany.repo.OfferRepo;
import pl.trainingCompany.repo.PhotoRepo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kamil S on 2016-03-20.
 */
@Component
public class PhotoMapper implements MapperInterface<Photo, DtoPhoto> {

    @Autowired
    OfferRepo offerRepo;

    @Override
    public Photo convertToDBO(DtoPhoto dtoPhoto) {
        Photo photo = new Photo();
        photo.setId(dtoPhoto.getId());
        photo.setName(dtoPhoto.getName());
        Offer offer = offerRepo.getOfferByName(dtoPhoto.getOfferName());
        if (offer != null) {
            photo.setOffer(offer);
        } else {
            //To Do
        }
        return photo;
    }

    @Override
    public DtoPhoto convertToDTO(Photo photo) {
        DtoPhoto dtoPhoto = new DtoPhoto();
        dtoPhoto.setId(photo.getId());
        dtoPhoto.setName(photo.getName());
        if(photo.getOffer()!=null)
        dtoPhoto.setOfferName(photo.getOffer().getName());
        return dtoPhoto;
    }

    @Override
    public Iterable<Photo> convertToDBO(Iterable<DtoPhoto> dto) {
        List<Photo> photos = new ArrayList<Photo>();
        for (DtoPhoto dtoPhoto: dto) {
            photos.add(convertToDBO(dtoPhoto));
        }
        return photos;
    }

    @Override
    public Iterable<DtoPhoto> convertToDTO(Iterable<Photo> dbo) {
        List<DtoPhoto> dtoPhotos = new ArrayList<DtoPhoto>();
        for (Photo photo: dbo) {
            dtoPhotos.add(convertToDTO(photo));
        }
        return dtoPhotos;
    }
}
