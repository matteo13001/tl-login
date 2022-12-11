package mondo.conv.tra.registration.validator;

import java.util.function.Predicate;

import javax.websocket.server.ServerEndpoint;

import org.springframework.stereotype.Service;

@Service
public class EmailValidator implements Predicate<String> {

	@Override
	public boolean test(String t) {
		
		return true;
	}

	
}
