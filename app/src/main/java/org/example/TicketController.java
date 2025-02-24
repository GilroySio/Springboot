package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TicketController {
    @Autowired
    TicketService ticketService;

    @GetMapping("/tickets")
    public List<TicketDTO> getTickets() {
        return ticketService.getTickets();
    }

    @GetMapping("/tickets/{id}")
    public TicketDTO getTicketById(@PathVariable("id") int id) {
        return ticketService.getTicketById(id);
    }

    @PutMapping("/tickets/{id}")
    public TicketDTO editTicket(@PathVariable("id") int id, @RequestBody Ticket ticket) {
        return ticketService.editTicket(id, ticket);
    }

    @PostMapping("add-ticket")
    public TicketDTO addTicket(@RequestBody Ticket ticket) {
        return ticketService.addTicket(ticket);
    }

    @DeleteMapping("delete-ticket/{id}")
    public void deleteTicket(@PathVariable("id") int id) {
        ticketService.deleteTicket(id);
    }

    @PutMapping("resolve/{id}")
    public TicketDTO resolveTicket(@PathVariable("id") int id, @RequestParam(name = "status") String status) {
        return ticketService.resolveTicket(id, status);
    }

    @PutMapping("remarks/{id}")
    public TicketDTO addRemarks(@PathVariable("id") int id, @RequestBody Ticket ticket) {
        return ticketService.addRemarks(id, ticket);
    }

}
