package com.forum.restcontroller;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.naming.Binding;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.forum.entity.Comment;
import com.forum.entity.Post;
import com.forum.entity.Profile;
import com.forum.entity.User;
import com.forum.service.ProfileService;
import com.forum.service.UserService;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@RestController
public class AccountRestController {

	@Autowired
	UserService userService;

	@Autowired
	ProfileService profileService;
	
	String pathSave;
	String filename;

	@PostMapping("/create/setting/save")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	void save(@Valid @RequestBody Profile profile, HttpServletRequest request, ModelMap model, HttpSession session) {
		profile.setAvatar("images/" + session.getAttribute("username").toString().trim()+ ".jpg");
		profileService.save(profile);
	}

	
	@PostMapping("/image/save")
	void saveImage(@RequestParam("avatar") MultipartFile file, HttpSession session, HttpServletResponse response, ModelMap model) throws IOException {
		String path = session.getServletContext().getRealPath("/");
		filename = file.getOriginalFilename();
		pathSave = "src/main/resources/static/images/"
				+ session.getAttribute("username").toString().trim()+ ".jpg";
		try {
			byte barr[] = file.getBytes();
			BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream(pathSave));
			bout.write(barr);
			bout.flush();
			bout.close();
		} catch (Exception e) {
			System.out.println(e);
		}	
		model.addAttribute("image", pathSave);
		response.sendRedirect("/setting");
	}
	
	@PostMapping("/account/update/password")
	@ResponseBody
	public ResponseEntity<?> ChangePassword(@RequestBody String json   ,BindingResult errors, HttpServletResponse rp, HttpSession session) {
		JSONObject jsonObj = new JSONObject(json);
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		System.out.println(jsonObj.get("oldPassword").toString());
		if (jsonObj.get("oldPassword").toString().isEmpty() || jsonObj.get("retypePassword").toString().isEmpty() || 
				jsonObj.get("newPassword").toString().isEmpty()) {
			return new ResponseEntity<>("Không được để trống các ô!" ,HttpStatus.BAD_REQUEST);
		}
		if (passwordEncoder.matches( jsonObj.get("oldPassword").toString(), userService.findById(session.getAttribute("username").toString()).getPassword()) 
				== false) {
			return new ResponseEntity<>("Mật khẩu cũ không đúng!" ,HttpStatus.BAD_REQUEST);
		}
		if (!jsonObj.get("newPassword").toString().equalsIgnoreCase(jsonObj.get("retypePassword").toString())) {
			return new ResponseEntity<>("Mật khẩu không trùng khớp với mật khẩu nhập lại!" ,HttpStatus.BAD_REQUEST);
		}
		
		
		String encrip = userService.encrypPassword(jsonObj.get("newPassword").toString());
		User user =  userService.findById(session.getAttribute("username").toString());
		user.setPassword(encrip);
		userService.save(user);
		
		return new ResponseEntity<>("" ,HttpStatus.OK);
	}
}
