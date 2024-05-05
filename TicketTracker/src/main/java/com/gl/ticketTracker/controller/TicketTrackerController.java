package com.gl.ticketTracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.gl.ticketTracker.entity.Tickets;
import com.gl.ticketTracker.services.TicketServices;

@Controller
@RequestMapping("/tickets")
public class TicketTrackerController {

	@Autowired
	TicketServices ticketServices;

	@RequestMapping("/welcome")
	public String getName() {
		return "welcome";
	}

	@RequestMapping("/list")
	public String listAllEmployess(Model model) {
		List<Tickets> tickets = ticketServices.list();
		model.addAttribute("tickets", tickets);
		return "list-tickets";
	}

	@PostMapping("/save")
	public String saveTicket(@ModelAttribute("ticket") Tickets ticket) {

		// save the Ticket
		ticket.setDate(java.time.LocalDate.now());
		ticketServices.save(ticket);

		// use a redirect to prevent duplicate submissions
		return "redirect:/tickets/list";
	}

	@RequestMapping("/showticketForm_Edit")
	public String editTcket_Step1(@RequestParam("ticketId") Long ticketId, Model theModel) {

		// get the ticket from the service
		Tickets ticket = ticketServices.findById(ticketId);

		// set ticket as a model attribute to pre-populate the form
		theModel.addAttribute("ticket", ticket);

		// send over to our form
		return "edit-ticket";
	}

	@RequestMapping("/delete")
	public String delete(@RequestParam("ticketId") Long ticketId) {

		// delete the Employee
		ticketServices.deleteById(ticketId);

		// redirect to Employees-Listing page
		return "redirect:/tickets/list";
	}

	@RequestMapping("/newticket")
	public String newTicket(Model model) {
		Tickets ticket = new Tickets();

		model.addAttribute("ticket", ticket);
		return "new-ticket";
	}

	@RequestMapping("/search")
	public String searchTicket(@RequestParam("ticket") String ticket, Model theModel) {
		List<Tickets> TicketList = ticketServices.searchTicket(ticket);
		theModel.addAttribute("tickets", TicketList);
		return "list-tickets";
	}
}
