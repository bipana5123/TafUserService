package com.tekarch.TafUserService.Repository;

import com.tekarch.TafUserService.models.Taf;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TafRepository extends JpaRepository<Taf, Long> {

}