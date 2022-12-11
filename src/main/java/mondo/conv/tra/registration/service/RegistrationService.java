package mondo.conv.tra.registration.service;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import mondo.conv.tra.login.entity.AppUser;
import mondo.conv.tra.login.enumuser.Role;
import mondo.conv.tra.login.service.AppUserService;
import mondo.conv.tra.registration.request.RegistrationRequest;
import mondo.conv.tra.registration.validator.EmailValidator;

@Service
@AllArgsConstructor
public class RegistrationService {

	private final AppUserService appUserService;

	private final EmailValidator emailValidator;

	public String register(RegistrationRequest registrationRequest) {
		boolean isValidEmail = emailValidator.test(registrationRequest.getEmail());
		if (!isValidEmail) {
			throw new IllegalStateException("Email not valid");
		}
		AppUser appUser = new AppUser(registrationRequest.getUsername(), registrationRequest.getPassword(), Role.ADMIN,registrationRequest.getEmail());

		return appUserService.signUpUser(appUser, registrationRequest.getPassword());

	}

}
