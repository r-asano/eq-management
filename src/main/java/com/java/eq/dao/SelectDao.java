package com.java.eq.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.java.eq.dto.EqHistory;
import com.java.eq.dto.Equipment;
import com.java.eq.dto.ReserveLend;

@Service
public interface SelectDao {
    Equipment selectEquipment(String eqID);

    EqHistory selectEqHistory(String historyId);

    List<EqHistory> selectAllEqHistory();

    ReserveLend selectReserveLend(String resId);
}
