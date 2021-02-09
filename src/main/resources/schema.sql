---- テーブルの初期化
--DROP TABLE equipment;
--DROP TABLE reserve_lend;
--DROP TABLE eq_history;
--DROP TABLE employee;

CREATE TABLE IF NOT EXISTS equipment (
  eq_id varchar(255) NOT NULL,
  somu_id varchar(255),
  eq_name varchar(255) NOT NULL,
  manufacturer varchar(255) NOT NULL,
  model_number varchar(255),
  place varchar(3) NOT NULL,
  lend_period int NOT NULL,
  PRIMARY KEY (eq_id)
);

CREATE TABLE IF NOT EXISTS employee (
  employee_id varchar(255) NOT NULL,
  employee_name varchar(255) NOT NULL,
  address varchar(255) NOT NULL,
  PRIMARY KEY (employee_id)
);

CREATE TABLE IF NOT EXISTS reserve_lend (
  res_id varchar(255) NOT NULL,
  eq_id varchar(255) NOT NULL,
  employee_id varchar(255) NOT NULL,
  res_date DATE NOT NULL,
  plan_lend_date DATE,
  plan_return_date DATE,
  lent_date DATE,
  lent_contact_person varchar(255),
  returned_date DATE,
  returned_contact_person varchar(255),
  PRIMARY KEY (res_id)
);

--CREATE TYPE status_enum AS ENUM ('Delete', 'Update', 'Add');
CREATE TABLE IF NOT EXISTS eq_history (
  history_id SERIAL NOT NULL,
  eq_id varchar(255) NOT NULL,
  rec_upd_date TIMESTAMP NOT NULL,
  status varchar(6) NOT NULL,
  comment varchar(255),
  PRIMARY KEY (history_id)
);
