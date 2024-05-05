package com.gl.ticketTracker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gl.ticketTracker.entity.Tickets;

@Repository
public interface TicketRepository extends JpaRepository<Tickets, Long> {

	@Query(value = "SELECT * FROM tickets WHERE title LIKE CONCAT('%',:ticket,'%') OR description LIKE CONCAT('%',:ticket,'%');", nativeQuery = true)
	public List<Tickets> searchTicket(@Param("ticket") String ticket);

}
