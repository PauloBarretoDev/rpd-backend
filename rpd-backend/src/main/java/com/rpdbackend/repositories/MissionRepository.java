package com.rpdbackend.repositories;

import com.rpdbackend.models.Mission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MissionRepository extends JpaRepository<Mission, Long> {

}
