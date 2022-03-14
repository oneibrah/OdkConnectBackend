package com.odk.connect.service.impl;

import com.odk.connect.exception.model.ForumException;
import com.odk.connect.exception.model.NotAnImageFileException;
import com.odk.connect.model.FileUploadUtil;
import com.odk.connect.model.Media;
import com.odk.connect.model.Question;
import com.odk.connect.model.User;
import com.odk.connect.repository.MediaRepository;
import com.odk.connect.repository.UserRepository;
import com.odk.connect.service.MediaService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import static com.odk.connect.constants.fileConstant.*;
import static org.springframework.http.MediaType.IMAGE_GIF_VALUE;
import static org.springframework.http.MediaType.IMAGE_JPEG_VALUE;
import static org.springframework.http.MediaType.IMAGE_PNG_VALUE;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MediaServiceImpl implements MediaService {
	private Logger LOGGER = LoggerFactory.getLogger(getClass());
	private final MediaRepository mediaRepository;
	private final UserRepository userRepository;

	@Override
	public Media addMedia(String titre,Long idUser, MultipartFile mediaImage)
			throws ForumException, IOException, NotAnImageFileException {
		Optional<User> user = userRepository.findById(idUser);
		if (user.isEmpty()) {
			LOGGER.error("Aucun utilisateur n'a été trouvé avec l'id" + idUser);
			throw new ForumException("Aucun utilisateur n'a été trouvé avec l'id" + idUser);
		}
		Media media = new Media();
		media.setTitre(titre);
		media.setUser(user.get());		
		saveMediaImage(media, mediaImage);
		return media;
	}

	@Override
	public List<Media> findAllMediaByUserId(Long id) throws ForumException {
		List<Media> mediaUser = mediaRepository.findAllByUserId(id);
		if (mediaUser.isEmpty()) {
			LOGGER.error("Aucun media n'a été trouvé avec l'ID " + id);
			throw new ForumException("cet utilisateur n'a pas encore ajouter de media");
		}
		return mediaUser;
	}

	@Override
	public List<Media> findAllByAdminAndFormateur() {
		return mediaRepository.findAllByAdminAndFormateur();
	}

	@Override
	public List<Media> findAllByAlum() {
		return mediaRepository.findAllByAlum();
	}

	private void saveMediaImage(Media media, MultipartFile mediaImage)
			throws IOException, NotAnImageFileException, ForumException {
		if (mediaImage != null) {
			if (!Arrays.asList(IMAGE_JPEG_VALUE, IMAGE_PNG_VALUE, IMAGE_GIF_VALUE)
					.contains(mediaImage.getContentType())) {
				throw new NotAnImageFileException(mediaImage.getOriginalFilename() + NOT_AN_IMAGE_FILE);
			}
			Path userFolder = Paths.get(MEDIA_FOLDER + media.getUser().getLogin()).toAbsolutePath().normalize();
			if (!Files.exists(userFolder)) {
				Files.createDirectories(userFolder);
				LOGGER.info(DIRECTORY_CREATED + userFolder);
			}
			String fileNameWithOutExt = FilenameUtils.removeExtension(mediaImage.getOriginalFilename());
			Optional<Media> mediaOpt = mediaRepository.findByFileName(fileNameWithOutExt);
			if (!mediaOpt.isEmpty()) {
				throw new ForumException("vous avez deja ajouter cet image dans la galerie");
			}
			Files.copy(mediaImage.getInputStream(), userFolder.resolve(fileNameWithOutExt + DOT + JPG_EXTENSION));
			media.setPhotoUrl(ServletUriComponentsBuilder.fromCurrentContextPath().path(MEDIA_IMAGE_PATH
					+ media.getUser().getLogin() + FORWARD_SLASH + fileNameWithOutExt + DOT + JPG_EXTENSION)
					.toUriString());
			media.setFileName(fileNameWithOutExt);
			mediaRepository.save(media);
			LOGGER.info(FILE_SAVED_IN_FILE_SYSTEM + mediaImage.getOriginalFilename());
		}

	}

//    @Override
//    public Media ajoutMedia(Media media, @RequestParam("photo") MultipartFile multipartFilePhoto) throws IOException {
//        System.out.println("je suis icciii");
//        String fileNamePhoto = StringUtils.cleanPath(multipartFilePhoto.getOriginalFilename());
//        media.setNom(fileNamePhoto);
//        Media m = mediaRepository.save(media);
//        String uploadDirPhoto = "src/main/resources/Galerie/photo/" + m.getId();
//        FileUploadUtil.saveFile(uploadDirPhoto, fileNamePhoto, multipartFilePhoto);
//        return m;
//    }
//    @Override
//    public byte[] getmedia(Long Id) throws IOException {
//        Media media = mediaRepository.findById(Id).get();
//        String iconPhoto = media.getNom();
//        File file = new File("src/main/resources/Galerie/photo/"+ media.getId() +"/" +iconPhoto);
//        Path path = Paths.get(file.toURI());
//        return Files.readAllBytes(path);
//    }
//    @Override
//    public List<Media> afficherListemedia() {
//        return mediaRepository.findAll();
//    }
//
//
//    @Override
//    public Void supprimerMedia(Long id) {
//        return null;
//    }
}
