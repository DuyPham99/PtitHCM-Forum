import org.apache.catalina.filters.ExpiresFilter.XServletOutputStream;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.forum.entity.User;
import com.forum.service.UserService;

public class PasswordGenerator {

	public static void main(String[] args) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String rawPsw = "duy";
		String encodePassword = encoder.encode(rawPsw);
		System.out.println(encodePassword);
		
//		UserService userSV = new UserService();
//		User user = userSV.findById("duy");
//		
//		System.out.println(user);
	}
}
