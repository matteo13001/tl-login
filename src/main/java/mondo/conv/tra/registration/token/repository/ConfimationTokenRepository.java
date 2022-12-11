package mondo.conv.tra.registration.token.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mondo.conv.tra.registration.token.entity.ConfirmationToken;

@Repository
public interface ConfimationTokenRepository extends JpaRepository<ConfirmationToken, Long> {

	ConfirmationToken findByToken(String token);

}
