package facebook;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.User;
import org.springframework.social.facebook.api.impl.FacebookTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	
	private static final Logger logger = LoggerFactory.getLogger(TestController.class);

	@GetMapping("/test")
	public String test(String accessToken) {
		logger.info("access_token : " + accessToken);
		
		if(accessToken != null) {
			Facebook facebook = new FacebookTemplate(accessToken);
			
			//User profile = facebook.userOperations().getUserProfile();
			String [] fields = { "id", "email",  "first_name", "last_name" };
			User profile = facebook.fetchObject("me", User.class, fields);
			
			return profile.getEmail();
		}
		
		return "error";
	}
}
