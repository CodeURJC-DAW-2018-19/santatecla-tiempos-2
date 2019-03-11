package com.example.demo.entities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletResponse;

import com.example.demo.entities.Event;
import com.example.demo.photos.Decoder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

//@Controller
@Service
public class PhotoService implements WebMvcConfigurer {
    /* RUTA A STATIC/IMG */
    private static final Path FILES_FOLDER = Paths.get(System.getProperty("user.dir"), "src/main/resources/static/img");

    private AtomicInteger imageId = new AtomicInteger();
    // private Map<Integer, Image> images = new ConcurrentHashMap<>();

    @Bean
    public MultipartResolver resolver(){
        return new StandardServletMultipartResolver();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/images/**")
                .addResourceLocations("file:C:/Windows/temp/images");
    }

    @PostConstruct
    public void init() throws IOException {

        if (!Files.exists(FILES_FOLDER)) {
            Files.createDirectories(FILES_FOLDER);
        }
    }

    //  @RequestMapping("/select")
  /*  public String index(Model model) {
        model.addAttribute("images", images.values());
        return "selectimage";
    }*/

    //@RequestMapping(value = "/image/upload", method = RequestMethod.POST)
    public String handleFileUpload(Event event,
                                   MultipartFile file, RedirectAttributes redirectAttributes ) {


        long id = event.getId()+62;

        String fileName = "image-"+id +".jpg";

        if (!file.isEmpty()) {
            try {
                /* RUTA A STATIC/IMG */
                File uploadedFile = new File(FILES_FOLDER.toFile(), fileName);
                file.transferTo(uploadedFile);
                System.out.println(uploadedFile.getPath());
                byte[]bytesPhoto=file.getBytes();
                redirectAttributes.addFlashAttribute("info","upload Image" + file.getOriginalFilename());
                event.setPhoto(Decoder.Encode(bytesPhoto));
                //images.put(id, new Image(id, fileName));

                return fileName;

            } catch (Exception e) {

                //model.addAttribute("error", e.getClass().getName() + ":" + e.getMessage());
                e.printStackTrace();
                return fileName;
            }
        } else {

            // model.addAttribute("error", "The file is empty");

            return fileName;
        }
    }

    // NOTE: The url format "/image/{fileName:.+}" avoid Spring MVC remove file
    // extension.

    //@RequestMapping("/image/{id}")
    public void handleFileDownload( String id, HttpServletResponse res)
            throws FileNotFoundException, IOException {

        String fileName = "image-" + id + ".jpg";
        Path image = FILES_FOLDER.resolve(fileName);

        if (Files.exists(image)) {
            res.setContentType("image/jpeg");
            res.setContentLength((int) image.toFile().length());
            FileCopyUtils.copy(Files.newInputStream(image), res.getOutputStream());

        } else {
            res.sendError(404, "File" + fileName + "(" + image.toAbsolutePath() + ") does not exist");
        }
    }
}