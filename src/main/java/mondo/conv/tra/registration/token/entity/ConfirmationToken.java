package mondo.conv.tra.registration.token.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mondo.conv.tra.login.entity.AppUser;

@Getter
@Setter
@NoArgsConstructor
@Entity()
public class ConfirmationToken {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String token;
	private LocalDateTime createAt;
	private LocalDateTime expiresAt;
	private LocalDateTime confirmed;

	@ManyToOne
	@JoinColumn(
			nullable = false,
			name = "id_User"
			)
	private AppUser appUser;
	
	public ConfirmationToken(String token, LocalDateTime createAt, LocalDateTime expiresAt,
			AppUser appUser) {
		super();
		this.token = token;
		this.createAt = createAt;
		this.expiresAt = expiresAt;
		this.appUser = appUser;
	}

}
