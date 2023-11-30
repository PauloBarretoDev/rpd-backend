package com.rpdbackend.repositories;

import com.rpdbackend.models.IncidentReport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IncidentReportRepository extends JpaRepository<IncidentReport, Long> {

}
