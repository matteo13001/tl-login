package mondo.conv.tra.registration.token.repository;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import mondo.conv.tra.registration.token.entity.ConfirmationToken;

@Repository
public interface ConfimationTokenRepository extends JpaRepository<ConfirmationToken, Long> {

	Optional<ConfirmationToken> findByToken(String token);

	
	@Query("SELECT COUNT(*) FROM ConfirmationToken WHERE appUser.email = :email AND expiresAt > :now")
	Integer isActiveAppUser(String email, LocalDateTime now);




}
