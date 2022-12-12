package mondo.conv.tra.login.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import mondo.conv.tra.login.entity.AppUser;
import mondo.conv.tra.login.repository.AppUserRepository;
import mondo.conv.tra.registration.token.entity.ConfirmationToken;
import mondo.conv.tra.registration.token.service.ConfirmationTokenService;

@Service
@AllArgsConstructor
public class AppUserService implements UserDetailsService {

	private AppUserRepository appUserRepository;

	private final BCryptPasswordEncoder bCryptPasswordEncoder;

	private final static String USER_NOT_FOUND_MSG = "user with email %s not found";

	
	private final ConfirmationTokenService confirmationTokenService;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return appUserRepository.findByEmail(email)
				.orElseThrow(() -> new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG, email)));
	}

	public String signUpUser(AppUser appUser, String password) {

		boolean userExist = appUserRepository.findByEmail(appUser.getEmail()).isPresent();
		boolean attivo = confirmationTokenService.idActive(appUser.getEmail());
		if (userExist && attivo) {
			throw new IllegalStateException("Email already taken and Token is valid, also");
		}
		String passwordEncode = bCryptPasswordEncoder.encode(password);
		appUser.setPassword(passwordEncode);
		
		
		//elimina tutti quelli con quella email che però non è stata eliminata
		
		
		appUserRepository.save(appUser);
		String token = UUID.randomUUID().toString();

		ConfirmationToken confirmationToken = new ConfirmationToken(token, LocalDateTime.now(),
				LocalDateTime.now().plusMinutes(15), appUser);
		
		System.out.println(confirmationToken.getConfirmed());

		confirmationTokenService.saveConfirmationToken(confirmationToken);
		return token;
	}

	public void enableAppUser(String email) {
		
		AppUser appUser = appUserRepository.getByEmail(email).orElse(null);
		
		if (appUser == null) {
			throw new IllegalStateException("qualcosa è andato storto, contattare il supporto");
		}
		
		appUser.setEnable(true);
		appUserRepository.save(appUser);
		
	}
}
