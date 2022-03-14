package com.odk.connect.service;

import com.odk.connect.model.Media;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


@Service

public interface MediaService {

    public Media ajoutMedia(Media media, MultipartFile photo) throws IOException;
    public byte[] getmedia(Long Id) throws IOException;
    public Void supprimerMedia(Long id);
    List<Media> afficherListemedia();
}
