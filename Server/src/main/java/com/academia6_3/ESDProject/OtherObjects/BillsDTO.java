package com.academia6_3.ESDProject.OtherObjects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BillsDTO {
    private String description;
    private Float amount;
    private LocalDate billDate;
    private LocalDate deadline;
    private Long studentId;
    private Boolean paid;
}
