package com.github.gobars.id.util;

import com.alibaba.druid.pool.DruidDataSource;
import lombok.val;
import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

public class DbTypeTest {
  @Test
  public void detectDbTypeMySQL() {
    val dataSource = new DruidDataSource();
    dataSource.setDriverClassName("com.mysql.jdbc.Driver");
    dataSource.setUrl(
        "jdbc:mysql://106.75.241.121:3306/id?useSSL=false&zeroDateTimeBehavior=convertToNull&useUnicode=yes&autoReconnect=true&characterEncoding=UTF-8&characterSetResults=UTF-8");
    dataSource.setUsername("root");
    dataSource.setPassword("root");

    assertThat(DbType.getDbType(dataSource)).isEqualTo(DbType.MYSQL);
  }

  @Test
  public void detectDbTypePostgeqSQL() {
    val dataSource = new DruidDataSource();
    dataSource.setDriverClassName("org.postgresql.Driver");
    dataSource.setUrl(
        "jdbc:postgresql://106.75.241.121:5432/id");
    dataSource.setUsername("postgres");
    dataSource.setPassword("postgres");

    assertThat(DbType.getDbType(dataSource)).isEqualTo(DbType.POSTGRESQL);
  }

  @Test
  public void detectDbTypeOracle() {
    val dataSource = new DruidDataSource();
    dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
    dataSource.setUrl("jdbc:oracle:thin:@106.75.241.121:1521:xe");
    dataSource.setUsername("system");
    dataSource.setPassword("oracle");

    assertThat(DbType.getDbType(dataSource)).isEqualTo(DbType.ORACLE);
  }
}
