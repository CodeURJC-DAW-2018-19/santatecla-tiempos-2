package com.example.demo.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Controller
public class WebControllerPhoto {
    private static final Path FILES_FOLDER= Paths.get(System.getProperty("user.der"),"img");
    private AtomicInteger imageId=new AtomicInteger();
    private Map<Long, Image> image=new ConcurrentHashMap<>();

    @PostConstruct
    public void init() throws IOException{
        if(!Files.exists(FILES_FOLDER)){
            Files.createDirectories(FILES_FOLDER);
        }
    }

    @PostMapping("/image/upload")
    public String handleFileUpload(Model model, @RequestParam("imageTitle")String imageTitle, @RequestParam("file")MultipartFile file){
        int id=imageId.getAndIncrement();
        String fileName="image-"+id+".jpg";
        if(!file.isEmpty()){
            try{
                File uploadFile=new File(FILES_FOLDER.toFile(),fileName);
                file.transferTo(uploadFile);
                image.put((long) id,new Image() {
                    @Override
                    public int getWidth(ImageObserver observer) {
                        return 0;
                    }

                    @Override
                    public int getHeight(ImageObserver observer) {
                        return 0;
                    }

                    @Override
                    public ImageProducer getSource() {
                        return null;
                    }

                    @Override
                    public Graphics getGraphics() {
                        return null;
                    }

                    @Override
                    public Object getProperty(String name, ImageObserver observer) {
                        return null;
                    }
                });
                return "practicaDAW";
            }catch (Exception exception){
                model.addAttribute("error",exception.getClass().getName()+":"+exception.getMessage());
                return "practicaDAW";
            }
        }else{
            model.addAttribute("File is empty");
            return "practicaDAW";
        }
    }

    @RequestMapping("/image/{id}")
    public void handleFileDownload(@PathVariable String id, HttpServletResponse res)throws FileNotFoundException,IOException{
        String fileName="image-"+imageId+"jpg";
        Path image=FILES_FOLDER.resolve(fileName);

        if(Files.exists(image)){
            res.setContentType("image/jpg");
            res.setContentLength((int)image.toFile().length());
            FileCopyUtils.copy(Files.newInputStream(image),res.getOutputStream());
        }else{
            res.sendError(404);
        }
    }

}
