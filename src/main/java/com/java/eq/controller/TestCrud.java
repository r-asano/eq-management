package com.java.eq.controller;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.eq.dao.DeleteDao;
import com.java.eq.dao.InsertDao;
import com.java.eq.dao.UpdateDao;
import com.java.eq.dto.Employee;
import com.java.eq.dto.Equipment;
import com.java.eq.dto.ReserveLend;
import com.java.eq.mapper.EqMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RequiredArgsConstructor
@Service
@Log4j2
public class TestCrud {

    @Autowired
    EqMapper eqMapper;

    private final InsertDao insert;

    private final UpdateDao update;

    private final DeleteDao delete;

    private Equipment eq;

    private Employee emp;

    private ReserveLend res;

    public void testInsert() {
        log.info("testInsert 開始");

        eq.setEqId("EQ-0020");
        eq.setSomuId("SM-0020");
        eq.setEqName("ディスプレイ");
        eq.setManufacturer("LG");
        eq.setModelNumber("MN-00020");
        eq.setPlace("osa");
        insert.InsertEquipment(eq);

        emp.setEmployeeId("010222");
        emp.setEmployeeName("淺野紫乃");
        emp.setAddress("shino@jprs.co.jp");
        insert.InsertEmployee(emp);

        res.setResId("RELE-0002");
        res.setEqId("EQ-0020");
        res.setEmployeeId("010222");
        res.setResDate(new Timestamp(System.currentTimeMillis()));
        res.setPlanLendDate(new Timestamp(System.currentTimeMillis()));
        insert.InsertReservelend(res);

        log.info("testInsert 終了");
    }

    public void testUpdate() throws ParseException {
        log.info("testUpdate 開始");

        // eq_nameの更新
        String targetEqId = "EQ-0001";
        eq = eqMapper.selectEquipment(targetEqId);
        eq.setEqName("プロジェクター②");
        update.updateEquipment(eq, targetEqId);

        // plan_return_dateの更新
        String targetResId = "RELE-0001";
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse("2021-02-22");
        res = eqMapper.selectReserveLend(targetResId);
        res.setPlanReturnDate(date);
        update.updateReserveLend(res, targetResId);

        log.info("testUpdate 終了");
    }

    public void testDelete() {
        log.info("testDelete 開始");

        String targetEqId = "EQ-0002";
        eq = eqMapper.selectEquipment(targetEqId);
        delete.deleteEquipment(eq);

        String targetEmpId = "010221";
        emp = eqMapper.selectEmployee(targetEmpId);
        delete.deleteEmployee(emp);

        String targetResId = "RELE-0002";
        res = eqMapper.selectReserveLend(targetResId);
        delete.deleteReservelend(res);

        log.info("testDelete 終了");
    }
}
