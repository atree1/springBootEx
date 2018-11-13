package org.zerock.persietence;

import org.springframework.data.repository.CrudRepository;
import org.zerock.domain.Profile;

public interface ProfileRepository extends CrudRepository<Profile, Long>{
	
}
