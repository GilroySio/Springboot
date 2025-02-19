package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TicketController {
    TicketServiceImpl ticketServiceImpl;

    @Autowired
    public TicketController(TicketServiceImpl ticketServiceImpl) {
        this.ticketServiceImpl = ticketServiceImpl;
    }

    @GetMapping("/tickets")
    public List<TicketDTO> getTickets() {
        return ticketServiceImpl.getTickets();
    }

    @GetMapping("/tickets/{id}")
    public TicketDTO getTicketById(@PathVariable("id") int id) {
        return ticketServiceImpl.getTicketById(id);
    }

    @PutMapping("/tickets/{id}")
    public void editTicket(@PathVariable("id") int id, @RequestBody Ticket ticket) {
        ticketServiceImpl.editTicket(id, ticket);
    }

    @PostMapping("add-ticket")
    public void addTicket(@RequestBody Ticket ticket) {
        ticketServiceImpl.addTicket(ticket);
    }

    @DeleteMapping("delete-ticket/{id}")
    public void deleteTicket(@PathVariable("id") int id) {
        ticketServiceImpl.deleteTicket(id);
    }

    @PutMapping("resolve/{id}")
    public void resolveTicket(@PathVariable("id") int id) {
        ticketServiceImpl.resolveTicket(id);
    }

    @PutMapping("remarks/{id}")
    public void addRemarks(@PathVariable("id") int id, @RequestBody Ticket ticket) {
        ticketServiceImpl.addRemarks(id, ticket);
    }

}
