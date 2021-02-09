package com.java.eq;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.java.eq.controller.TestCrud;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RequiredArgsConstructor
@Component
@Log4j2
public class EqManagementRunner implements ApplicationRunner {

    private final TestCrud test;

//    private final InsertDao insert;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        log.info("Eq-ManagementApplication 開始");

        test.testDelete();
//        insert.InitInsertEquipment();

        log.info("Eq-ManagementApplication 終了");
    }

}
