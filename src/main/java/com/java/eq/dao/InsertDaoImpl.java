package com.java.eq.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
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
public class InsertDaoImpl implements InsertDao {

    @Autowired
    EqMapper eqMapper;

    private Equipment eq;

    private final EqHistory history;

    // equipment table の初期挿入 eq_historyにも並行して挿入
    @Override
    @Transactional
    public void InitInsertEquipment() throws IOException {

        // TSVファイルを指定し順に読み出す
        CsvMapper mapper = new CsvMapper();
        // ヘッダあり、タブ区切り
        CsvSchema schema = mapper.schemaFor(Equipment.class).withHeader().withColumnSeparator('\t');
        String listPath = "//shsv1/kaihatsu/secret/2021/アクション/C-71_社内受託開発/005_総務備品管理/eq_test.csv";
        Path path = Paths.get(listPath);

        try ( BufferedReader br = Files.newBufferedReader(path) ) {
            MappingIterator<Equipment> it = mapper.readerFor(Equipment.class).with(schema).readValues(br);
            // 登録
            while (it.hasNextValue()) {
                // TSVファイルを順に呼び出す
                eq = it.nextValue();

                // equipmentテーブルにInsert
                log.info("備品マスタの初期登録: " + eq.toString());
                eqMapper.insertEquipment(eq);

                // eq_historyテーブルにもInsert
                history.setEqId(eq.getEqId());
                history.setRecUpdDate(new Timestamp(System.currentTimeMillis()));
                history.setStatus("Add");
                history.setComment(eq.getEqName() + "の初期登録を行いました。");
                log.info("備品ヒストリー: " + history.toString());
                eqMapper.insertEqHistory(history);
            }
        }
    }

    // equipment table の挿入
    @Override
    public void InsertEquipment(Equipment eq) {
        eqMapper.insertEquipment(eq);
        log.info("備品マスタの登録: " + eq.toString());

        // historyテーブルにもInsert
        history.setEqId(eq.getEqId());
        history.setRecUpdDate(new Timestamp(System.currentTimeMillis()));
        history.setStatus("Add");
        history.setComment(eq.getEqName() + "の登録を行いました。");
        eqMapper.insertEqHistory(history);
        log.info("備品ヒストリー: " + history.toString());
    }

    // employee table の挿入（今後はoffice-home連携で行う予定のため、将来的に不要）
    @Override
    @Transactional
    public void InsertEmployee(Employee emp) {
        eqMapper.insertEmployee(emp);
        log.info("ユーザー情報の登録: " + emp.toString());
    }

    // reserve_land table の挿入
    @Override
    @Transactional
    public void InsertReservelend(ReserveLend res) {
        eqMapper.insertReserveLend(res);
        log.info("予約貸出情報の登録: " + res.toString());
    }
}
