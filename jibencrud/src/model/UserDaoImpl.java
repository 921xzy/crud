package model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;


import com.jaovo.msg.Util.DBUtil;

import com.jaovo.msg.Util.UserException;



public class UserDaoImpl{

	
	@SuppressWarnings("resource")
	public void add(User user) {//增加
		Connection connection = DBUtil.getConnection();
		String sql = "insert into crud(teacher,address,course) values (?,?,?)";//sql语句
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, user.getTeacher());
			preparedStatement.setString(2, user.getAddress());
			preparedStatement.setString(3, user.getCourse());
			//preparedStatement.setInt(4, user.getId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			
			
			DBUtil.close(preparedStatement);
			DBUtil.close(connection);
		}
		
	}
	
	public List<User> load() {//查询出整个数据库的数据 ，显示
		Connection connection = DBUtil.getConnection();
		
		String sql = "select * from crud";
		
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		List<User> users = new ArrayList<User>();
		User user = null;
		try {
			preparedStatement = connection.prepareStatement(sql);
			
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				user = new User();
				user.setTeacher(resultSet.getString("teacher"));
				user.setAddress(resultSet.getString("address"));
				user.setCourse(resultSet.getString("course"));
				user.setId(resultSet.getInt("id"));
				users.add(user);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			DBUtil.close(resultSet);
			DBUtil.close(preparedStatement);
			DBUtil.close(connection);
		}
		return  users;
		}
	
		public void deletesing(int id) {//根据id删除记录
		
		
		Connection connection = DBUtil.getConnection();
		String sql = "delete from crud where id = ?";
		PreparedStatement preparedStatement = null;
		
		try {
			preparedStatement =  connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			DBUtil.close(preparedStatement);
			DBUtil.close(connection);
		}
		
	}
	
		//更新数据库的函数
		public void updatesing(User xiugai,int id) {
			Connection connection = DBUtil.getConnection();
			PreparedStatement preparedStatement = null;
			String sql = "update crud set teacher=?,address=?,course=? where id = ?";
		    try {
		    	preparedStatement = connection.prepareStatement(sql);
		    	
				preparedStatement.setString(1, xiugai.getTeacher());
				preparedStatement.setString(2, xiugai.getAddress());
				preparedStatement.setString(3, xiugai.getCourse());
				preparedStatement.setInt(4, id);
				preparedStatement.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				DBUtil.close(connection);
				DBUtil.close(preparedStatement);
			}
		}
		
		public List<User> loadspell(String course ) {//根据课程查询信息
			Connection connection = DBUtil.getConnection();
			
			String sql = "select * from crud where course  = ?";
			
			PreparedStatement preparedStatement = null;
			ResultSet resultSet = null;
			
			List<User> users = new ArrayList<User>();
			User user = null;
			try {
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1, course);
				resultSet = preparedStatement.executeQuery();
				
				while(resultSet.next()) {
					user = new User();
					user.setTeacher(resultSet.getString("teacher"));
					user.setAddress(resultSet.getString("address"));
					user.setCourse(resultSet.getString("course"));
					users.add(user);
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}finally {
				DBUtil.close(resultSet);
				DBUtil.close(preparedStatement);
				DBUtil.close(connection);
			}
			return  users;
			}
}
