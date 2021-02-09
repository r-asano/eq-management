package com.java.eq.dao;

import java.io.IOException;

import org.springframework.stereotype.Service;

import com.java.eq.dto.Employee;
import com.java.eq.dto.Equipment;
import com.java.eq.dto.ReserveLend;

@Service
public interface InsertDao {
    void InitInsertEquipment() throws IOException;

    void InsertEquipment(Equipment eq);

    void InsertEmployee(Employee user);

    void InsertReservelend(ReserveLend res);
}
