package org.ccunix.javaweb.dao.impl_sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.ccunix.javaweb.model.LeaveWordModel;
import org.ccunix.javaweb.util.DBManager;
import org.ccunix.javaweb.vo.LeaveWordVO;
import org.ccunix.javaweb.vo.MerchandiseVO;

public class LeavewordDAO {

	public boolean addLeaveword(String title, String content,int member,String leaveDate) {
		Connection connection = null;
		PreparedStatement ps = null;
		connection = DBManager.getConnection();
		String sql = "insert into leaveword(member,title,content,leaveDate)"
				+ " values (?,?,?,?)";
		try {
			// 事务
			connection.setAutoCommit(false);
			ps = connection.prepareStatement(sql);
			//对?赋值
			ps.setInt(1,member);
			ps.setString(2,title);
			ps.setString(3,content);
			ps.setString(4,leaveDate);
			int row = ps.executeUpdate();
			
			connection.commit();// 手动提交
			if(row>0) {
			   return true;				
			}
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			DBManager.close(connection, ps);
		}
		return false;
	}

	public List<LeaveWordVO> getLeaveWordModelList() {
		List<LeaveWordVO> leaveWordList = new ArrayList<LeaveWordVO>();
		Connection connection = null;
		PreparedStatement ps = null;
		connection = DBManager.getConnection();
		String sql = "select leaveword.id,member,admin,title,content,leaveDate,answerContent,answerDate,member.memberName"
				+ " from leaveword,member where member.id=leaveword.member";
		try {
			// 事务
			connection.setAutoCommit(false);
			ps = connection.prepareStatement(sql);
			ResultSet set = ps.executeQuery();
			while (set.next()) {
				LeaveWordVO leaveWordVO = new LeaveWordVO(set.getInt("id"), set.getInt("member"), set.getInt("admin"),
						set.getString("title"), set.getString("content"), set.getString("leaveDate"),
						set.getString("answerContent"), set.getString("answerDate"), set.getString("memberName"));

				leaveWordList.add(leaveWordVO);

			}
			connection.commit();// 手动提交
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			DBManager.close(connection, ps);
		}
		return leaveWordList;
	}
}
