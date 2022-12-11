package mondo.conv.tra.registration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
	
	public String register(@RequestBody RegistrationRequest registrationRequest) {
		return registrationService.register(registrationRequest);
	}
	
}
