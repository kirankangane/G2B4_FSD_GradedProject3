package com.gl.ticketTracker.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gl.ticketTracker.entity.Tickets;

@Service
public interface TicketServices {

	List<Tickets> list();

	public void save(Tickets ticket);

	public Tickets findById(Long ticketID);

	public void deleteById(Long ticketId);

	List<Tickets> searchTicket(String ticket);
}
