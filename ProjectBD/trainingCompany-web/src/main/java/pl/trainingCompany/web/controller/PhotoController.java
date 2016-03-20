package pl.trainingCompany.web.controller;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.trainingCompany.model.dbo.Photo;
import pl.trainingCompany.model.dto.DtoPhoto;
import pl.trainingCompany.service.PhotoService;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Kamil S on 2016-03-20.
 */
@RestController
@RequestMapping("/photo")
public class PhotoController extends AbstractController<Photo, DtoPhoto, PhotoService> {

    @RequestMapping(method = RequestMethod.POST, value = "/upload")
    public ModelAndView handleFileUpload(@RequestParam("name") String name,
                                         @RequestParam("file") MultipartFile file,
                                         RedirectAttributes redirectAttributes) {
        if (name.contains("/")) {
            redirectAttributes.addFlashAttribute("message", "Folder separators not allowed");
            return new ModelAndView("redirect:http://localhost:8080/#/photoDemo");
        }
        if (name.contains("/")) {
            redirectAttributes.addFlashAttribute("message", "Relative pathnames not allowed");
            return new ModelAndView("redirect:http://localhost:8080/#/photoDemo");
        }

        if (!file.isEmpty()) {
            try {

                BufferedOutputStream stream = new BufferedOutputStream(
                        new FileOutputStream(new File(name)));
                FileCopyUtils.copy(file.getInputStream(), stream);
                stream.close();
                DtoPhoto dtoPhoto = new DtoPhoto();
                dtoPhoto.setName(name);
                service.save(dtoPhoto);
                redirectAttributes.addFlashAttribute("message",
                        "You successfully uploaded " + name + "!");
            } catch (Exception e) {
                redirectAttributes.addFlashAttribute("message",
                        "You failed to upload " + name + " => " + e.getMessage());
            }
        } else {
            redirectAttributes.addFlashAttribute("message",
                    "You failed to upload " + name + " because the file was empty");
        }

        return new ModelAndView("redirect:http://localhost:8080/#/photoDemo");
    }


    @RequestMapping(value = "/files/{file_name}", method = RequestMethod.GET)
    public void getFile(
            @PathVariable("file_name") String fileName,
            HttpServletResponse response) {
        if (!(fileName.contains("{") || fileName.contains("}"))) {
            try {
                // get your file as InputStream
                BufferedInputStream is = new BufferedInputStream(new FileInputStream(new File(fileName)));
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
}
