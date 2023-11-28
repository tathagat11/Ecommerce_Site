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
public class PaymentDTO {
    private Long studentId;
    private String description;
    private Float amount;
    private LocalDate paymentDate;
    private Long billId;
}
