package com.odk.connect.controller;



import com.odk.connect.model.Media;
import com.odk.connect.service.MediaService;
import com.odk.connect.service.impl.MediaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.*;
import java.util.List;


@CrossOrigin
@RestController
@RequestMapping("odkConnect/file/")
public class MediaController  {

    @Autowired
    MediaService mediaService;

    @PostMapping("ajouter")
    public Media ajouterMedia(Media media, @RequestParam("photo") MultipartFile photo) throws  IOException{
        return mediaService.ajoutMedia(media, photo);
    }
    @GetMapping(value = "affichermedia/{id}",produces = {MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_PNG_VALUE})
    byte[] affichermedia(@PathVariable("id") Long id) throws IOException{
        return mediaService.getmedia(id);
    }

    @DeleteMapping("supprimer/{id}")
    Void supprimer(@PathVariable("id") Long id){
        return mediaService.supprimerMedia(id);
    }

    @GetMapping("listemedia")
    List<Media> afficher(){
        return mediaService.afficherListemedia();
    }





}
