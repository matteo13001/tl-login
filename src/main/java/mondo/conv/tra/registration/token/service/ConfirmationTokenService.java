package mondo.conv.tra.registration.token.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import mondo.conv.tra.registration.token.entity.ConfirmationToken;
import mondo.conv.tra.registration.token.repository.ConfimationTokenRepository;

@Service
@AllArgsConstructor
public class ConfirmationTokenService {


	private final ConfimationTokenRepository confimationTokenRepository;
	
	public void saveConfirmationToken(ConfirmationToken token) {
		confimationTokenRepository.save(token);
	}
	
	public Optional<ConfirmationToken> getToken(String token) {
		return confimationTokenRepository.findByToken(token);
	}

	public void setConfirmedAt(ConfirmationToken confirmationToken) {

		confirmationToken.setConfirmed(LocalDateTime.now());
		
		confimationTokenRepository.save(confirmationToken);
	}

	public boolean idActive(String email) {
		System.out.println(LocalDateTime.now());
		return confimationTokenRepository.isActiveAppUser(email, LocalDateTime.now())>0;
	}


	
	
	
	
	
	
}
