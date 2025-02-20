package org.example;

import java.util.List;

public interface TicketService {
    public List<TicketDTO> getTickets();
    public TicketDTO getTicketById(int id);
    public TicketDTO addTicket(Ticket ticket);
    public TicketDTO editTicket(int id, Ticket t);
    public void deleteTicket(int id);
    public TicketDTO resolveTicket(int id, String s);
    public TicketDTO addRemarks(int id, Ticket t);
}
