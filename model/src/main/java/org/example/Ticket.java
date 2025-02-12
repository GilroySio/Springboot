package org.example;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Ticket {
    private int tickerNumber;
    private String title;
    private String body;
    private String assignee;
    private String status;
    private String createdDate;
    private String createdBy;
    private String updatedDate;
    private String updatedBy;
    private String remarks;

    public Ticket(int tickerNumber, String title, String body) {
        this.tickerNumber = tickerNumber;
        this.title = title;
        this.body = body;
    }
}
