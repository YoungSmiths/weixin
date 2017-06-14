package com.wangjing.wechat.utils;

import java.sql.Connection;

import org.apache.commons.dbcp.BasicDataSource;

/**
 * 
 * @ClassName: DBCPConnection
 * @Description: TODO
 * @author YoungSmith
 * @date 2017年6月10日 下午11:30:32
 *
 */
public class DBCPConnection {
	public Connection getConnection() {
		Connection conn = null;
		try {
			BasicDataSource ds = new BasicDataSource();
			ds.setUsername("root");
			ds.setPassword("root");
			ds.setUrl("jdbc:mysql://localhost:3306/weixindb?autoReconnect=true&useUnicode=true&characterEncoding=utf8");
			ds.setDriverClassName("com.mysql.jdbc.Driver");

			ds.setMaxActive(20);
			ds.setMaxIdle(10);
			ds.setInitialSize(10);
			ds.setMinIdle(2);
			ds.setMaxWait(1000);

			conn = ds.getConnection();
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
