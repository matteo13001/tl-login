package mondo.conv.tra.registration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import mondo.conv.tra.registration.request.RegistrationRequest;
import mondo.conv.tra.registration.service.RegistrationService;

@RestController
@RequestMapping(path = "api/v1/registration")
@AllArgsConstructor
public class RegistrationController {

	@Autowired
	private RegistrationService registrationService;

	@PostMapping()
	public String register(@RequestBody RegistrationRequest registrationRequest) {
		return registrationService.register(registrationRequest);
	}

	@PostMapping(path = "/confirm")
	public String confirm(@RequestParam("token") String token) {

		return registrationService.confirmToken(token);
	}
	
	
	

}
