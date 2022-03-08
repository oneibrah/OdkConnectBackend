package com.odk.connect.service.impl;


import com.odk.connect.model.FileUploadUtil;
import com.odk.connect.model.Media;
import com.odk.connect.repository.MediaRepository;
import com.odk.connect.service.MediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
public class MediaServiceImpl implements MediaService{
    @Autowired
    MediaRepository mediaRepository;


    @Override
    public Media ajoutMedia(Media media, @RequestParam("photo") MultipartFile multipartFilePhoto) throws IOException {
        System.out.println("je suis icciii");
        String fileNamePhoto = StringUtils.cleanPath(multipartFilePhoto.getOriginalFilename());
        media.setNom(fileNamePhoto);
        Media m = mediaRepository.save(media);
        String uploadDirPhoto = "src/main/resources/Galerie/photo/" + m.getId();
        FileUploadUtil.saveFile(uploadDirPhoto, fileNamePhoto, multipartFilePhoto);
        return m;
    }
    @Override
    public byte[] getmedia(Long Id) throws IOException {
        Media media = mediaRepository.findById(Id).get();
        String iconPhoto = media.getNom();
        File file = new File("src/main/resources/Galerie/photo/"+ media.getId() +"/" +iconPhoto);
        Path path = Paths.get(file.toURI());
        return Files.readAllBytes(path);
    }
    @Override
    public List<Media> afficherListemedia() {
        return mediaRepository.findAll();
    }


    @Override
    public Void supprimerMedia(Long id) {
        return null;
    }
}
