package com.java.eq.dao;

import org.springframework.stereotype.Service;

import com.java.eq.dto.Employee;
import com.java.eq.dto.Equipment;
import com.java.eq.dto.ReserveLend;

@Service
public interface DeleteDao {
    void deleteEquipment(Equipment eq);

    void deleteEmployee(Employee user);

    // カレンダー形式で使用する場合、ペイロード長が次第に大きくなるため定期削除が必要？（積み上げ？）
    void deleteReservelend(ReserveLend res);
}
