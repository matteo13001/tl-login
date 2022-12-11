package mondo.conv.tra.registration.token.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import mondo.conv.tra.registration.token.entity.ConfirmationToken;
import mondo.conv.tra.registration.token.repository.ConfimationTokenRepository;

@Service
@AllArgsConstructor
public class ConfirmationTokenService {


	private final ConfimationTokenRepository confimationTokenRepository;
	
	public void saveConfirmationToken(ConfirmationToken token) {
		confimationTokenRepository.save(token);
	}
	
	
	
	
	
}
