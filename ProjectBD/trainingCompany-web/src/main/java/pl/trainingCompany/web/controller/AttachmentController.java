package pl.trainingCompany.web.controller;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.trainingCompany.model.dbo.Attachment;
import pl.trainingCompany.model.dto.DtoAttachment;
import pl.trainingCompany.service.AttachmentService;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * Created by Kamil S on 2016-03-20.
 */
@RestController
@RequestMapping("/attachment")
public class AttachmentController extends AbstractController<Attachment, DtoAttachment, AttachmentService> {

    public boolean handleFileUpload(String name,
                                         String attachmentType,
                                         Long offerID,
                                         MultipartFile file,
                                         RedirectAttributes redirectAttributes) {
        if (name.contains("/")) {
            redirectAttributes.addFlashAttribute("message", "Folder separators not allowed");
            return false;
        }
        if (name.contains("/")) {
            redirectAttributes.addFlashAttribute("message", "Relative pathnames not allowed");
            return false;
        }

        if (!file.isEmpty()) {
            try {
                service.save(name, attachmentType, offerID);
                File dbFile = new File("trainingCompany-web/src/main/resources/image/"+offerID);
                if(!dbFile.exists())
                    dbFile.mkdirs();
                dbFile = new File("trainingCompany-web/src/main/resources/image/"+offerID+"/"+name);
                BufferedOutputStream stream = new BufferedOutputStream(
                        new FileOutputStream(dbFile));

                FileCopyUtils.copy(file.getInputStream(), stream);
                stream.close();

                redirectAttributes.addFlashAttribute("message",
                        "You successfully uploaded " + name + "!");
            } catch (Exception e) {
                redirectAttributes.addFlashAttribute("message",
                        "You failed to upload " + name + " => " + e.getMessage());
                return false;
            }
        } else {
            redirectAttributes.addFlashAttribute("message",
                    "You failed to upload " + name + " because the file was empty");
            return false;
        }

        return true;
    }


    @RequestMapping(value = "/files/{offerId}/{file_name}", method = RequestMethod.GET)
    public void getFile(
            @PathVariable("file_name") String fileName,
            @PathVariable("offerId") String offerId,
            HttpServletResponse response) {
        if (!(fileName.contains("{") || fileName.contains("}"))) {
            try {
                // get your file as InputStream
                BufferedInputStream is = new BufferedInputStream(new FileInputStream(new File("trainingCompany-web/src/main/resources/image/"+offerId+"/"+fileName)));
                // copy it to response's OutputStream
                try {
                    IOUtils.copy(is, response.getOutputStream());
                } catch (IOException e) {
                    e.printStackTrace();
                }

                response.flushBuffer();
                is.close();
            } catch (IOException ex) {
                ex.printStackTrace(System.out);
            }

        }
    }

    @RequestMapping(value = "/offer/{offerId}", method = RequestMethod.GET)
    public Iterable<DtoAttachment> getAttachementByOfferId(@PathVariable("offerId") Long offerId){
        return service.getAttachementByOfferId(offerId);
    }
}

