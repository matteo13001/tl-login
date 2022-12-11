package mondo.conv.tra.registration.request;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class RegistrationRequest {

	private final String firstName;
	private final String lastName;
	private final String username;
	private final String email;
	private final String password;

	
}
