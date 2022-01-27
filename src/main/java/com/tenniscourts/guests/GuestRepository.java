package com.tenniscourts.guests;

import com.tenniscourts.schedules.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GuestRepository extends JpaRepository<Guest, Long> {

    Optional<Guest> findByName(String name);
}
