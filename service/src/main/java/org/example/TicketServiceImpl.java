package org.example;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TicketServiceImpl implements  TicketService {
    @Autowired
    TicketRepo ticketRepo;
    @Autowired
    EmployeeRepo employeeRepo;

    public List<TicketDTO> getTickets() {
        return ticketRepo.findAll().stream().map(TicketDTO::new).toList();
    }

    public TicketDTO getTicketById(int id) {
        Ticket ticket = ticketRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("ticket with id " + id + " does not exist"));
        return new TicketDTO(ticket);
    }

    @Transactional
    public void addTicket(Ticket ticket) {
        if(ticket.getTitle() == null || ticket.getTitle().isEmpty()) {
            throw new IllegalArgumentException("cannot add ticket without title");
        }
        if(ticket.getBody() == null || ticket.getBody().isEmpty()) {
            throw new IllegalArgumentException("cannot add ticket without body");
        }
        ticket.setStatus("unresolved");
        ticket.setCreatedBy(employeeRepo.findById(2).orElseThrow(() -> new IllegalArgumentException("default employee with id 2 for ticket creation does not exist")));
        ticket.setCreatedDate(LocalDate.now());
        ticketRepo.save(ticket);
    }

    @Transactional
    public void editTicket(int id, Ticket t) {
        Ticket ticket = ticketRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("ticket with id " + id + " does not exist"));
        if(t.getTitle() != null && !t.getTitle().isEmpty()) {
            ticket.setTitle(t.getTitle());
        }
        if(t.getBody() != null && !t.getBody().isEmpty()) {
            ticket.setBody(t.getBody());
        }
        ticket.setUpdatedBy(employeeRepo.findById(2).orElseThrow(() -> new IllegalArgumentException("default employee with id 2 for ticket update does not exist")));
        ticket.setUpdatedDate(LocalDate.now());
    }

    public void deleteTicket(int id) {
        if(!ticketRepo.existsById(id)) {
            throw new IllegalArgumentException("ticket with id " + id + " does not exist");
        }
        ticketRepo.deleteById(id);
    }

    @Transactional
    public void resolveTicket(int id) {
        Ticket ticket = ticketRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("ticket with id " + id + " does not exist"));
        ticket.setStatus("resolved");
        ticket.setUpdatedBy(employeeRepo.findById(2).orElseThrow(() -> new IllegalArgumentException("default employee with id 2 for ticket update does not exist")));
        ticket.setUpdatedDate(LocalDate.now());
        ticket.getAssignees().clear();
    }

    @Transactional
    public void addRemarks(int id, Ticket t) {
        Ticket ticket = ticketRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("ticket with id " + id + " does not exist"));
        if(t.getRemarks() == null || t.getRemarks().isEmpty()) {
            throw new IllegalArgumentException("no remarks found");
        }
        ticket.setRemarks(t.getRemarks());
        ticket.setUpdatedBy(employeeRepo.findById(2).orElseThrow(() -> new IllegalArgumentException("default employee with id 2 for ticket update does not exist")));
        ticket.setUpdatedDate(LocalDate.now());
    }
}
