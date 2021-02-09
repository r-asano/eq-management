package com.java.eq.dto;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Repository;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * reserve_lendテーブルDTO
 */
@Entity
@Repository
@Table(name = "reserve_lend")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ReserveLend {
    @Id
    private String resId;

    private String eqId;

    private String employeeId;

    private Date resDate ;

    private Date planLendDate;

    private Date planReturnDate;

    private Date lentDate;

    private String lentContactPerson;

    private Date returnedDate;

    private String returnedContactPerson;
}