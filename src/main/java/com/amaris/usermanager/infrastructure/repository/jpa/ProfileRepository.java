package com.amaris.usermanager.infrastructure.repository.jpa;

import com.amaris.usermanager.infrastructure.repository.model.ProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends JpaRepository<ProfileEntity, Long> {
}
