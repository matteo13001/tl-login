package mondo.conv.tra.login.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import mondo.conv.tra.login.bean.AppUserEntity;

@Repository
@Transactional(readOnly = true)
public interface AppUserRepository extends JpaRepository<AppUserEntity, Long> {

	Optional<AppUserEntity> finByEmail(String email);
	
}
