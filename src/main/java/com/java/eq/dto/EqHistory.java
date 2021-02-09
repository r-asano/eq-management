package com.java.eq.dto;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Repository;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * eq_historyテーブルDTO
 */
@Entity
@Repository
@Table(name = "eq_history")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class EqHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //IDENTITY を指定しなければ正しく動作しない
    private int historyId;

    private String eqId;

    private Timestamp recUpdDate;

    // ENUM {Delete, Update, Add}
    private String status;

    private String comment;
}