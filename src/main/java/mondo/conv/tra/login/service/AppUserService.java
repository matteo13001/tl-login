package mondo.conv.tra.login.service;

import java.nio.channels.IllegalSelectorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import mondo.conv.tra.login.entity.AppUser;
import mondo.conv.tra.login.repository.AppUserRepository;

@Service
@AllArgsConstructor
public class AppUserService implements UserDetailsService {

	private AppUserRepository appUserRepository;

	private final BCryptPasswordEncoder bCryptPasswordEncoder;

	private final static String USER_NOT_FOUND_MSG = "user with email %s not found";

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return appUserRepository.findByEmail(email)
				.orElseThrow(() -> new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG, email)));
	}

	public String signUpUser(AppUser appUser, String password) {

		boolean userExist = appUserRepository.findByEmail(appUser.getEmail()).isPresent();

		if (userExist) {
			throw new IllegalStateException("Email already taken");
		}
		String passwordEncode = bCryptPasswordEncoder.encode(password);
		appUser.setPassword(passwordEncode);
		appUserRepository.save(appUser);

		return "it works";
	}
}
