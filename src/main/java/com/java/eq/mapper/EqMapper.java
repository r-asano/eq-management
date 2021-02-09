package com.java.eq.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.java.eq.dto.Employee;
import com.java.eq.dto.EqHistory;
import com.java.eq.dto.Equipment;
import com.java.eq.dto.ReserveLend;

/*
 * マッパー
 */
@Mapper
public interface EqMapper {
    // equipment テーブル
    void insertEquipment(Equipment eq);

    void updateEquipment(@Param("eq") Equipment eq, String id);

    Equipment selectEquipment(String eqID);

    void deleteEquipment(Equipment eq);


    // eq_history テーブル
    void insertEqHistory(EqHistory history);

    EqHistory selectEqHistory(String historyId);

    List<EqHistory> selectAllEqHistory();


    // reserve_lend テーブル
    void insertReserveLend(ReserveLend res);

    void updateReserveLend(@Param("res") ReserveLend res, String id);

    ReserveLend selectReserveLend(String resId);

    void deleteReserveLend(ReserveLend res);


    // user テーブル
    void insertEmployee(Employee emp);

    Employee selectEmployee(String employeeId);

    void deleteEmployee(Employee emp);

    //    List<UserDto> selectAllDomain();

    //    List<UserDto> selectG3Domain();

    //    int countG3();

    //    UserDto selectOneCert(String dnCn);
    //

    //    @MapKey("jointAgentId")
    //    List<Map<String, Object>>  countG3GroupByAgent(); // asでaliasしないとmap.get("id")が使えない
    //
    //    String selectJointAgentId(UserDto domain);

}
