package org.example;

import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TicketDTO {
    private int id;
    private String title;
    private String body;
    private List<Integer> assignees = new ArrayList<Integer>();
    private String status;
    private LocalDate createdDate;
    private Integer createdBy;
    private LocalDate updatedDate;
    private Integer updatedBy;
    private String remarks;

    public TicketDTO(Ticket t) {
        this.id = t.getId();
        this.title = t.getTitle();
        this.body = t.getBody();
        this.assignees = t.getAssignees().stream().map(Employee::getId).toList();
        this.status = t.getStatus();
        this.createdDate = t.getCreatedDate();
        this.createdBy = t.getCreatedBy().getId();
        this.updatedDate = t.getUpdatedDate();
        if(t.getUpdatedBy() != null) {
            this.updatedBy = t.getUpdatedBy().getId();
        }
        this.remarks = t.getRemarks();
    }
}
