package com.jaovo.msg.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.PreparedStatement;

public class DBUtil {
	public  static  Connection getConnection() {
		/*
		 * ��������
		 */
		try {
			
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		String user = "root";
		String password = "123456";
		String url = "jdbc:mysql://localhost:3306/jibencrud";
		/*
		 * �������Ӷ���
		 */
		Connection connection = null;
		try {
			
			 connection = DriverManager.getConnection(url,user,password);
			 //System.out.println("ok");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return connection;
	}
	/*
	 * �ر���Դ�ķ���
	 */
	
	public static void close(Connection connection ) {//�ر����Ӷ���ķ���
		try {
			if (connection != null) {
				connection.close();
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	public static void close(PreparedStatement preparedStatement ) {//�ر���䴫�����ķ���
		try {
			if (preparedStatement != null) {
				preparedStatement.close();
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	public static void close(ResultSet resultSet ) {//�رս�����ķ���
		try {
			if (resultSet != null) {
				resultSet.close();
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	



}
