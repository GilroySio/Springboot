package org.example;

import java.util.List;

public interface TicketService {
    public List<TicketDTO> getTickets();
    public TicketDTO getTicketById(int id);
    public void addTicket(Ticket ticket);
    public void editTicket(int id, Ticket t);
    public void deleteTicket(int id);
    public void resolveTicket(int id);
    public void addRemarks(int id, Ticket t);
}
