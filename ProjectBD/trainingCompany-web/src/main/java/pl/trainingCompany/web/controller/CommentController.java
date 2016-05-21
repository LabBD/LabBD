package pl.trainingCompany.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.trainingCompany.model.dbo.Account;
import pl.trainingCompany.model.dbo.Comment;
import pl.trainingCompany.model.dbo.Offer;
import pl.trainingCompany.model.dto.DtoComment;
import pl.trainingCompany.repo.AccountRepo;
import pl.trainingCompany.repo.OfferRepo;
import pl.trainingCompany.service.CommentService;

import java.util.Date;

/**
 * Created by Pawel on 20-May-16.
 */
@RestController
@RequestMapping("/comment")
public class CommentController extends AbstractController<Comment, DtoComment, CommentService>{

    @Autowired
    OfferRepo offerRepo;

    @Autowired
    AccountRepo accountRepo;

    @RequestMapping(value = "/offer/{offerId}", method = RequestMethod.GET)
    public Iterable<DtoComment> getCommentsByOfferId(@PathVariable("offerId") Long offerId){
        return service.getCommentsByOfferId(offerId);
    }
}
