package com.forum.controller;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.text.RandomStringGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.forum.EmailSender;
import com.forum.entity.Profile;
import com.forum.entity.User;
import com.forum.service.ProfileService;
import com.forum.service.UserService;

@Controller
public class AccountController {

	@Autowired
	UserService userService;

	@Autowired
	ProfileService profileService;
	
	 @Autowired
	 public JavaMailSender emailSender;
	
	@GetMapping("/setting")
	public String showSetting(HttpServletRequest rq, HttpServletResponse rs, ModelMap model) throws IOException {
		if (rq.getSession().getAttribute("username") == null) {
			return "redirect:/";
		}
		model.addAttribute("profile", userService.findById( (String) rq.getSession().getAttribute("username")).getProfile());
		return "setting-account";
	}
	
	@GetMapping("/reset-password")
	public String showPassword() {
		return "reset-password";
	}
	
	public String generateRandomSpecialCharacters() {
		 String upperCaseLetters = RandomStringUtils.random(2, 65, 90, true, true);
		    String lowerCaseLetters = RandomStringUtils.random(2, 97, 122, true, true);
		    String numbers = RandomStringUtils.randomNumeric(2);
		    String specialChar = RandomStringUtils.random(2, 33, 47, false, false);
		    String totalChars = RandomStringUtils.randomAlphanumeric(2);
		    String combinedChars = upperCaseLetters.concat(lowerCaseLetters)
		      .concat(numbers)
		      .concat(specialChar)
		      .concat(totalChars);
		    List<Character> pwdChars = combinedChars.chars()
		      .mapToObj(c -> (char) c)
		      .collect(Collectors.toList());
		    Collections.shuffle(pwdChars);
		    String password = pwdChars.stream()
		      .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
		      .toString();
		    return password;
	}
	
    @RequestMapping("/sendSimpleEmail/{username}/{email}")
    public void sendSimpleEmail(@PathVariable("username") String username,@PathVariable("email") String email, HttpServletResponse rs) throws IOException, MessagingException {
    	MimeMessage mimeMessage = emailSender.createMimeMessage();
    	MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
    	
    	//save
    	 String psw = generateRandomSpecialCharacters();
    	 User user =  userService.findById(username);
    	 user.setPassword(userService.encrypPassword(psw));
    	 userService.save(user);
    	 
        // Create a Simple MailMessage.
        SimpleMailMessage message = new SimpleMailMessage();
        String html = "<b>Mật khẩu mới của bạn là: " + psw + "</b>\r\n"
        		+ "<br><br><br>\r\n"
        		+ "<b><u>*VUI LÒNG ĐỔI LẠI MẬT KHẨU SAU KHI ĐĂNG NHẬP LẠI*</u></b>";
         
        helper.setTo(email);
        helper.setSubject("FORUM PTIT-LẤY LẠI MẬT KHẨU"); 
        
        helper.setText(html, true);
 
        // Send Message!
        this.emailSender.send(mimeMessage);
        
        rs.sendRedirect("/");
    }
	
}
