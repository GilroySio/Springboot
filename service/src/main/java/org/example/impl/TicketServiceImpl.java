package org.example.impl;

import jakarta.transaction.Transactional;
import org.example.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {
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
    public TicketDTO addTicket(Ticket ticket) {
        if(ticket.getTitle() == null || ticket.getTitle().isEmpty()) {
            throw new IllegalArgumentException("cannot add ticket without title");
        }
        if(ticket.getBody() == null || ticket.getBody().isEmpty()) {
            throw new IllegalArgumentException("cannot add ticket without body");
        }
        ticket.setStatus("draft");
        ticket.setCreatedBy(employeeRepo.findById(2).orElseThrow(() -> new IllegalArgumentException("default employee with id 2 for ticket creation does not exist")));
        ticket.setCreatedDate(LocalDate.now());
        ticketRepo.save(ticket);
        return new TicketDTO(ticket);
    }

    @Transactional
    public TicketDTO editTicket(int id, Ticket t) {
        Ticket ticket = ticketRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("ticket with id " + id + " does not exist"));
        if(t.getTitle() != null && !t.getTitle().isEmpty()) {
            ticket.setTitle(t.getTitle());
        }
        if(t.getBody() != null && !t.getBody().isEmpty()) {
            ticket.setBody(t.getBody());
        }
        ticket.setUpdatedBy(employeeRepo.findById(2).orElseThrow(() -> new IllegalArgumentException("default employee with id 2 for ticket update does not exist")));
        ticket.setUpdatedDate(LocalDate.now());
        return new TicketDTO(ticket);
    }

    public void deleteTicket(int id) {
        if(!ticketRepo.existsById(id)) {
            throw new IllegalArgumentException("ticket with id " + id + " does not exist");
        }
        ticketRepo.deleteById(id);
    }

    @Transactional
    public TicketDTO resolveTicket(int id, String s) {
        Ticket ticket = ticketRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("ticket with id " + id + " does not exist"));
        if(s == null || s.isEmpty()) {
            throw new IllegalArgumentException("status cannot be blank");
        }
        ticket.setStatus(s);
        ticket.setUpdatedBy(employeeRepo.findById(2).orElseThrow(() -> new IllegalArgumentException("default employee with id 2 for ticket update does not exist")));
        ticket.setUpdatedDate(LocalDate.now());
        ticket.getAssignees().clear();
        return new TicketDTO(ticket);
    }

    @Transactional
    public TicketDTO addRemarks(int id, Ticket t) {
        Ticket ticket = ticketRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("ticket with id " + id + " does not exist"));
        if(t.getRemarks() == null || t.getRemarks().isEmpty()) {
            throw new IllegalArgumentException("no remarks found");
        }
        ticket.setRemarks(t.getRemarks());
        ticket.setUpdatedBy(employeeRepo.findById(2).orElseThrow(() -> new IllegalArgumentException("default employee with id 2 for ticket update does not exist")));
        ticket.setUpdatedDate(LocalDate.now());
        return new TicketDTO(ticket);
    }
}
