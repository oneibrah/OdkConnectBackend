package com.odk.connect.controller;

import com.odk.connect.constants.fileConstant;
import com.odk.connect.exception.ExceptionHandling;
import com.odk.connect.exception.model.ForumException;
import com.odk.connect.exception.model.NotAnImageFileException;
import com.odk.connect.model.CategoryForum;
import com.odk.connect.model.User;
import com.odk.connect.service.CategoryService;
import lombok.RequiredArgsConstructor;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static com.odk.connect.constants.fileConstant.*;
import static org.springframework.http.HttpStatus.*;
import static org.springframework.http.MediaType.IMAGE_JPEG_VALUE;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin
@RestController
@RequestMapping("/odkConnect/forum/category")
@RequiredArgsConstructor
public class CategoryController extends ExceptionHandling {

	private final CategoryService categoryService;

	@PostMapping("/SaveCategoryFroum")
	public ResponseEntity<CategoryForum> ajouterCategory(@RequestParam("libelle") String description,
			@RequestParam("id") Long idUser,
			@RequestParam(value = "categoryImage", required = false) MultipartFile categoryImage)
			throws ForumException, IOException, NotAnImageFileException {
		CategoryForum catForum = categoryService.ajouterCategory(description, idUser, categoryImage);
		return new ResponseEntity<CategoryForum>(catForum, OK);
	}
	@GetMapping("/listCateForum")
	public ResponseEntity<List<CategoryForum>> getAllCateForum() {
		List<CategoryForum> catForum = categoryService.getAllCateforum();
		return new ResponseEntity<List<CategoryForum>>(catForum, OK);
	}

	@GetMapping(path = "/image/{username}/{fileName}", produces = IMAGE_JPEG_VALUE)
	public byte[] getCategoryImage(@PathVariable("username") String username, @PathVariable("fileName") String fileName)
			throws IOException {
		return Files.readAllBytes(Paths.get(CATEGORY_FOLDER + username + FORWARD_SLASH + fileName));
	}
	@DeleteMapping("/supprimer/{id}")
	Void supprimer(@PathVariable("id") Long id) {
		return categoryService.supprimerCategory(id);
	}

}
