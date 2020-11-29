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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.forum.security.MyUserDetailsService;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


@RestController
@RequestMapping("editor")
public class RichTextEditorRestController {	
	
	@Autowired
	MyUserDetailsService userSV;
	
	@PostMapping("upload_image")
	@ResponseBody
	Map<String, String> uploadImage(@RequestParam("image") MultipartFile multiPart, @ModelAttribute("listImage") ArrayList<String> listImage) throws IllegalStateException, IOException, InterruptedException{
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
		// wait for refresh image folder
		while(true) { 
			try {
			File file = new ClassPathResource("static/images/" + timestamp + " " + fileName).getFile();
			if (file.exists()) break;
			} catch(Exception e) {			
			}
		}
		return map;
	}
	@DeleteMapping("image_delete")
	void delete(@RequestBody String src) throws IOException {
		JsonObject json = new JsonParser().parse(src).getAsJsonObject();
		Path path = Paths.get("src/main/resources/static/" + json.get("src").getAsString());
		Files.delete(path);
	}
	@PostMapping("save")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	String save(@RequestBody String text) {
		System.out.println(text);	
		return text;
	}	
	
	
	
}
