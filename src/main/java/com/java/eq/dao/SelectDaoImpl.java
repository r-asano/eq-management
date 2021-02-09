package com.java.eq.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.eq.dto.EqHistory;
import com.java.eq.dto.Equipment;
import com.java.eq.dto.ReserveLend;
import com.java.eq.mapper.EqMapper;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class SelectDaoImpl implements SelectDao {

    @Autowired
    EqMapper eqMapper;

    @Override
    public Equipment selectEquipment(String eqID) {
        log.info("対象備品の取得");
        return eqMapper.selectEquipment(eqID);
    }

    @Override
    public EqHistory selectEqHistory(String historyId) {
        log.info("対象備品ヒストリーの取得");
        return eqMapper.selectEqHistory(historyId);
    }

    @Override
    public List<EqHistory> selectAllEqHistory() {
        log.info("すべての備品ヒストリーの取得");
        return eqMapper.selectAllEqHistory();
    }

    @Override
    public ReserveLend selectReserveLend(String resId) {
        log.info("予約貸出情報の取得");
        return eqMapper.selectReserveLend(resId);
    }

}
