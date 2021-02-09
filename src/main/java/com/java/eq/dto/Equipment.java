package com.java.eq.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * equipmentテーブルDTO
 */
//CSVの各項目を読み込む順序を設定する
@JsonPropertyOrder({
        "eqId",
        "somuId",
        "eqName",
        "manufacturer",
        "modelNumber",
        "place" })
@Entity
@Repository
@Table(name = "equipment")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Equipment {
    @Id
    private String eqId;

    private String somuId;

    private String eqName;

    private String manufacturer;

    private String modelNumber;

    // ENUM {tyo, osa}
    private String place;

    private int lendPeriod;
}
