package pl.trainingCompany.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.trainingCompany.model.dbo.Comment;
import pl.trainingCompany.model.dto.DtoComment;
import pl.trainingCompany.repo.OfferRepo;
import pl.trainingCompany.service.AccountService;
import pl.trainingCompany.service.CommentService;

import java.util.Date;


/**
 * Created by Pawel on 20-May-16.
 */
@RestController
@RequestMapping("/comment")
public class CommentController extends AbstractController<Comment, DtoComment, CommentService> {

    @Autowired
    OfferRepo offerRepo;

    @Autowired
    AccountService accountService;

    @RequestMapping(value = "/offer/{offerId}", method = RequestMethod.GET)
    public Iterable<DtoComment> getCommentsByOfferId(@PathVariable("offerId") Long offerId) {
        return service.getCommentsByOfferId(offerId);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, consumes = "application/json;charset=UTF-8")
    public void addComment(@RequestBody DtoComment comment) {
        comment.setDate(new Date());
        String authorName = accountService.getLoggedAccountName();

        comment.setAuthorName(authorName);
        service.save(comment);
    }
}
