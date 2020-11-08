package com.forum.restcontroller;

import java.awt.desktop.ScreenSleepEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.JsonObject;

@RestController
@RequestMapping("editor")
public class RichTextEditorRestController {

	@PostMapping("upload_image")
	@ResponseBody
	Map<String, String> saveImage(@RequestParam("image") MultipartFile multiPart, @ModelAttribute("listImage") ArrayList<String> listImage) throws IllegalStateException, IOException, InterruptedException{
		Map<String,String> map = new HashMap<String, String>();
		String fileName = StringUtils.cleanPath(multiPart.getOriginalFilename());	
		LocalDateTime myDateObj = LocalDateTime.now();
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH-mm-ss");
		String timestamp =  myDateObj.format(myFormatObj);
		 
		String uploadDir = "src/main/resources/static/images/"  + timestamp + " " + fileName;
		byte[] bytes = multiPart.getBytes();
	
		// process
		Path path = Paths.get(uploadDir);
		Files.write(path, bytes);
		listImage.add(fileName);
		map.put("link", "images/" + timestamp + " " + fileName);	
		
		TimeUnit.SECONDS.sleep(3);
		return map;
	}
	
	@PostMapping( "image_delete")
	ResponseEntity<String> delete(@RequestBody JsonObject  path) throws IOException {
		String fileName = path.get("src").getAsString();
		 FileUtils.touch(new File("src/test/resources/fileToDelete_commonsIo.txt"));
		 File fileToDelete = FileUtils.getFile("src/test/resources/fileToDelete_commonsIo.txt");
		    boolean success = FileUtils.deleteQuietly(fileToDelete);
		System.out.println(fileName);
		System.out.println(success);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
}
