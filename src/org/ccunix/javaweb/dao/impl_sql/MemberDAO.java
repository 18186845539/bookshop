package org.ccunix.javaweb.dao.impl_sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.ccunix.javaweb.dao.iface.MemberDAO_Iface;
import org.ccunix.javaweb.model.MemberModel;
import org.ccunix.javaweb.util.DBManager;
import org.ccunix.javaweb.vo.MemberVO;

public class MemberDAO implements MemberDAO_Iface {

	public MemberVO loginValidate(String loginName, String loginPwd) {
		MemberVO memberModel = null;
		Connection connection = null;
		PreparedStatement ps = null;

		connection = DBManager.getConnection();
		String sql = "select member.id, memberLevel, memberName, loginName, loginPwd, phone, address, zip, regDate, lastDate, loginTimes, email,levelName,favourable from member,memberlevel where member.Memberlevel=memberlevel.id"
				+ "  and loginName=? and loginPwd=?";
		try {
			// 事务
			connection.setAutoCommit(false);
			ps = connection.prepareStatement(sql);
			ps.setString(1, loginName);
			ps.setString(2, loginPwd);
			
			ResultSet set = ps.executeQuery();

			if (set.next()) {
				memberModel = new MemberVO(set.getInt("id"), set.getInt("memberLevel"), set.getString("memberName"),
						set.getString("loginName"), set.getString("loginPwd"), set.getString("phone"),
						set.getString("address"), set.getString("zip"), set.getString("regDate"),
						set.getString("lastDate"), set.getInt("loginTimes"), set.getString("email"),
						set.getString("levelName"),
						set.getInt("favourable"));
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

		return memberModel;
	}

	public boolean regedit(MemberModel model) {

		return false;
	}

	public boolean exitUser() {

		return false;
	}

	public boolean update(int id, MemberModel model) {
		Connection connection = null;
		PreparedStatement ps = null;

		connection = DBManager.getConnection();
		String sql = "update member set memberLevel=?, memberName=?, loginName=?, loginPwd=?, phone=?, address=?, zip=?, regDate=?,email=?"
				+ " where id=?";
		try {
			// 事务
			connection.setAutoCommit(false);
			ps = connection.prepareStatement(sql);
			ps.setInt(1, model.getMemberLevel());
			ps.setString(2, model.getMemberName());
			ps.setString(3, model.getLoginName());
			ps.setString(4, model.getLoginPwd());
			ps.setString(5, model.getPhone());
			ps.setString(6, model.getAddress());
			ps.setString(7, model.getZip());
			ps.setString(8, model.getRegDate());
			ps.setString(9, model.getEmail());
			ps.setInt(10, id);
			int row = ps.executeUpdate();
			if(row>0) {
				connection.commit();// 手动提交
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
}
