package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TicketController {
    TicketService ticketService;

    @Autowired
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping("/tickets")
    public List<TicketDTO> getTickets() {
        return ticketService.getTickets();
    }

    @GetMapping("/tickets/{id}")
    public TicketDTO getTicketById(@PathVariable("id") int id) {
        return ticketService.getTicketById(id);
    }

    @PutMapping("/tickets/{id}")
    public void editTicket(@PathVariable("id") int id, @RequestBody Ticket ticket) {
        ticketService.editTicket(id, ticket);
    }

    @PostMapping("add-ticket")
    public void addTicket(@RequestBody Ticket ticket) {
        ticketService.addTicket(ticket);
    }

    @DeleteMapping("delete-ticket/{id}")
    public void deleteTicket(@PathVariable("id") int id) {
        ticketService.deleteTicket(id);
    }

    @PutMapping("resolve/{id}")
    public void resolveTicket(@PathVariable("id") int id) {
        ticketService.resolveTicket(id);
    }

    @PutMapping("remarks/{id}")
    public void addRemarks(@PathVariable("id") int id, @RequestBody Ticket ticket) {
        ticketService.addRemarks(id, ticket);
    }

}
