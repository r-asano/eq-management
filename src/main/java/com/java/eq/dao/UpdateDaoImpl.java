package com.java.eq.dao;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.java.eq.dto.EqHistory;
import com.java.eq.dto.Equipment;
import com.java.eq.dto.ReserveLend;
import com.java.eq.mapper.EqMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RequiredArgsConstructor
@Service
@Log4j2
public class UpdateDaoImpl implements UpdateDao {

    @Autowired
    EqMapper eqMapper;

    private final EqHistory history;

    @Override
    @Transactional
    public void updateEquipment(Equipment eq, String id) {
        eqMapper.updateEquipment(eq, id);
        log.info("備品マスタの更新");
        log.info("対象eq_id: " + id + ",更新内容: " + eq.toString());

        // eq_historyテーブルにもInsert
        history.setEqId(eq.getEqId());
        history.setRecUpdDate(new Timestamp(System.currentTimeMillis()));
        history.setStatus("Update");
        history.setComment(eq.getEqName() + "の更新を行いました。");
        eqMapper.insertEqHistory(history);
        log.info("備品ヒストリー: " + history.toString());
    }

    @Override
    @Transactional
    public void updateReserveLend(ReserveLend res, String id) {
        eqMapper.updateReserveLend(res, id);
        log.info("予約貸出情報の更新");
        log.info("対象res_id: " + id + ", " + res.toString());
    }

}
