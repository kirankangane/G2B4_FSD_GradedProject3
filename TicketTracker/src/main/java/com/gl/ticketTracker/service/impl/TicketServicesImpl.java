package com.gl.ticketTracker.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.ticketTracker.entity.Tickets;
import com.gl.ticketTracker.repository.TicketRepository;
import com.gl.ticketTracker.services.TicketServices;

@Service
public class TicketServicesImpl implements TicketServices {

	@Autowired
	TicketRepository ticketRepo;

	@Override
	public List<Tickets> list() {
		// TODO Auto-generated method stub
		return ticketRepo.findAll();
	}

	@Override
	public void save(Tickets ticket) {
		ticketRepo.save(ticket);
	}

	@Override
	public Tickets findById(Long ticketID) {
		return ticketRepo.findById(ticketID).get();
	}

	@Override
	public void deleteById(Long ticketID) {
		ticketRepo.deleteById(ticketID);
	}

	@Override
	public List<Tickets> searchTicket(String ticket) {

		return ticketRepo.searchTicket(ticket);

	}

}
