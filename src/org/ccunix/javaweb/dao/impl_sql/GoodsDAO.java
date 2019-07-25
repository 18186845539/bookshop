package org.ccunix.javaweb.dao.impl_sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.ccunix.javaweb.model.GoodsModel;
import org.ccunix.javaweb.util.DBManager;

public class GoodsDAO {

	public List<GoodsModel> getGoodsList() throws SQLException {
		List<GoodsModel> goodsList = new ArrayList<GoodsModel>();
		Connection connection = DBManager.getConnection();
		PreparedStatement statement = null;
		String sql = "select id,gid,name,descs,price,img from goods";
		statement = connection.prepareStatement(sql);

		ResultSet rs = statement.executeQuery();
		while (rs.next()) {
			GoodsModel model = new GoodsModel(rs.getInt("id"), rs.getString("gid"), rs.getString("name"),
					rs.getString("descs"), rs.getDouble("price"), rs.getString("img"));
			
			goodsList.add(model);
		}

		return goodsList;
	}

	// insert into goods(gid,name,descs,price,img) values
	// ('g1009','IPHONE7S','很好8',7500,'images/j8.jpg')

	public static void main(String[] args) {
		try {
			System.out.println(new GoodsDAO().getGoodsList().size());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean deleteGoodsByGid(String gid)  throws SQLException{
		Connection connection = DBManager.getConnection();
		PreparedStatement statement = null;
		String sql = "delete from goods where gid=?";
		statement = connection.prepareStatement(sql);
		statement.setString(1, gid);
		int row = statement.executeUpdate();
		if(row>0)
			return true;
		return false;
	}

	public GoodsModel queryGoodsByGid(String gid)  throws SQLException{
		GoodsModel goodsModel = null;
		Connection connection = DBManager.getConnection();
		PreparedStatement statement = null;
		String sql = "select id,gid,name,descs,price,img from goods where gid=?";
		statement = connection.prepareStatement(sql);
		statement.setString(1, gid);
		
		ResultSet rs = statement.executeQuery();
		if (rs.next()) {
			goodsModel = new GoodsModel(rs.getInt("id"), rs.getString("gid"), rs.getString("name"),
					rs.getString("descs"), rs.getDouble("price"), rs.getString("img"));
		}
		return goodsModel;
	}

	public boolean updateGoodsByGid(String gid, GoodsModel goodsModel)  throws SQLException{
		Connection connection = DBManager.getConnection();
		PreparedStatement statement = null;
		String sql = "update goods set name=?,descs=?,price=?,img=? where gid=?";
		statement = connection.prepareStatement(sql);
		statement.setString(1, goodsModel.getName());
		statement.setString(2,  goodsModel.getDescs());
		statement.setDouble(3,goodsModel.getPrice());
		statement.setString(4, goodsModel.getImg());
		statement.setString(5, gid);
		int row = statement.executeUpdate();
		if(row>0)
			return true;
		return false;
	}
}
