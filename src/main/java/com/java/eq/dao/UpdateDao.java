package com.java.eq.dao;

import org.springframework.stereotype.Service;

import com.java.eq.dto.Equipment;
import com.java.eq.dto.ReserveLend;

@Service
public interface UpdateDao {
    void updateEquipment(Equipment eq, String id);

    void updateReserveLend(ReserveLend res, String id);
}
