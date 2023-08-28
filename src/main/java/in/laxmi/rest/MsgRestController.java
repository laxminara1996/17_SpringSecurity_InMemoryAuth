package in.laxmi.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MsgRestController {
	@GetMapping("/contact")
	public String getContact() {
		return "call us";
	}
	@GetMapping("/greet")
	public String greetMsg() {
		return "Good Evening";
	}
	@GetMapping("/welcome")
	public String welcomeMsg() {
		return "welcome";
	}
}
