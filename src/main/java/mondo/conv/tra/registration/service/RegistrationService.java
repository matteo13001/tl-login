package mondo.conv.tra.registration.service;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import mondo.conv.tra.registration.request.RegistrationRequest;
import mondo.conv.tra.registration.validator.EmailValidator;

@Service
@AllArgsConstructor
public class RegistrationService {

	private EmailValidator emailValidator;
	
	public String register(RegistrationRequest registrationRequest) {
		boolean isValidEmail = emailValidator.test(registrationRequest.getEmail());
		return "works";

	}

}
