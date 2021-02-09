package com.java.eq.dao;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.java.eq.dto.Employee;
import com.java.eq.dto.EqHistory;
import com.java.eq.dto.Equipment;
import com.java.eq.dto.ReserveLend;
import com.java.eq.mapper.EqMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RequiredArgsConstructor
@Service
@Log4j2
public class DeleteDaoImpl implements DeleteDao {

    @Autowired
    EqMapper eqMapper;

    private final EqHistory history;

    @Override
    @Transactional
    public void deleteEquipment(Equipment eq) {
        log.info("備品マスタの削除: " + eq.toString());

        // eq_historyテーブルにもInsert
        history.setEqId(eq.getEqId());
        history.setRecUpdDate(new Timestamp(System.currentTimeMillis()));
        history.setStatus("Delete");
        history.setComment(eq.getEqName() + "の削除を行いました。");
        eqMapper.insertEqHistory(history);
        log.info("備品ヒストリー: " + history.toString());

        eqMapper.deleteEquipment(eq);
    }

    @Override
    @Transactional
    public void deleteEmployee(Employee emp) {
        log.info("ユーザーの削除: " + emp.toString());
        eqMapper.deleteEmployee(emp);
    }

    @Override
    @Transactional
    public void deleteReservelend(ReserveLend res) {
        log.info("予約貸出情報の削除: " + res.toString());
        eqMapper.deleteReserveLend(res);
    }
}
