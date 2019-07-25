package org.ccunix.javaweb.dao.impl_sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.ccunix.javaweb.model.CategoryModel;
import org.ccunix.javaweb.model.MerchandiseModel;
import org.ccunix.javaweb.service.iface.MerchandiseServiceIface;
import org.ccunix.javaweb.util.DBManager;
import org.ccunix.javaweb.vo.MemberVO;
import org.ccunix.javaweb.vo.MerchandiseVO;

public class MerchandiseDAO {
	public List<MerchandiseVO> getMerchandiseListByCategory(int category) {
		List<MerchandiseVO> merchandiseList = new ArrayList<MerchandiseVO>();
		Connection connection = null;
		PreparedStatement ps = null;
		connection = DBManager.getConnection();
		String sql = "select merchandise.ID,Category,MerName,Price,SPrice,MerModel,Picture,MerDesc,Manufacturer,LeaveFactoryDate,Special,category.CateName categroyName"
				+ " from merchandise,category  where merchandise.Category=category.ID  and merchandise.Category=?";
		try {
			// 事务
			connection.setAutoCommit(false);
			ps = connection.prepareStatement(sql);
			ps.setInt(1, category);
			ResultSet set = ps.executeQuery();
			while (set.next()) {
				MerchandiseVO merchandiseVO = new MerchandiseVO(set.getInt("id"), set.getInt("category"),
						set.getString("mername"), set.getDouble("price"), set.getDouble("sprice"),
						set.getString("picture"), set.getString("merdesc"), set.getString("manufacturer"),
						set.getString("leavefactorydate"), set.getString("mermodel"), set.getInt("special"),
						set.getString("categroyName"));

				merchandiseList.add(merchandiseVO);
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
		return merchandiseList;
	}

	public List<MerchandiseModel> getMerchandiseListByLikeName(String name) {

		return null;
	}

	/**
	 * 商品搜索
	 * @param category
	 * @param name
	 * @return
	 */
	public List<MerchandiseVO> getMerchandiseListByLikeName(int category, String name) {

		List<MerchandiseVO> merchandiseList = new ArrayList<MerchandiseVO>();
		Connection connection = null;
		PreparedStatement ps = null;
		connection = DBManager.getConnection();
		String sql = "select merchandise.ID,Category,MerName,Price,SPrice,MerModel,Picture,MerDesc,Manufacturer,LeaveFactoryDate,Special,category.CateName categroyName"
				+ " from merchandise,category  where merchandise.Category=category.ID ";
		//拼接sql语句
		if(category!=0) {
			sql = sql+" and merchandise.Category="+category;
		}
		if(!"商品关键字".equals(name)) {
			sql = sql + " and MerName like '%"+name+"%'";
		}
		System.out.println("sql:"+sql);
		try {
			// 事务
			connection.setAutoCommit(false);
			ps = connection.prepareStatement(sql);
			ResultSet set = ps.executeQuery();
			while (set.next()) {
				MerchandiseVO merchandiseVO = new MerchandiseVO(set.getInt("id"), set.getInt("category"),
						set.getString("mername"), set.getDouble("price"), set.getDouble("sprice"),
						set.getString("picture"), set.getString("merdesc"), set.getString("manufacturer"),
						set.getString("leavefactorydate"), set.getString("mermodel"), set.getInt("special"),
						set.getString("categroyName"));

				merchandiseList.add(merchandiseVO);
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
		return merchandiseList;
	}

	public List<MerchandiseVO> getMerchandiseListBySpecial(int special) {
		List<MerchandiseVO> merchandiseList = new ArrayList<MerchandiseVO>();
		Connection connection = null;
		PreparedStatement ps = null;
		connection = DBManager.getConnection();
		String sql = "select merchandise.ID,Category,MerName,Price,SPrice,MerModel,Picture,MerDesc,Manufacturer,LeaveFactoryDate,Special,category.CateName categroyName"
				+ " from merchandise,category  where merchandise.Category=category.ID and special=?";
		try {
			// 事务
			connection.setAutoCommit(false);
			ps = connection.prepareStatement(sql);
			ps.setInt(1, special);
			ResultSet set = ps.executeQuery();
			while (set.next()) {
				MerchandiseVO merchandiseVO = new MerchandiseVO(set.getInt("id"), set.getInt("category"),
						set.getString("mername"), set.getDouble("price"), set.getDouble("sprice"),
						set.getString("picture"), set.getString("merdesc"), set.getString("manufacturer"),
						set.getString("leavefactorydate"), set.getString("mermodel"), set.getInt("special"),
						set.getString("categroyName"));

				merchandiseList.add(merchandiseVO);
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

		return merchandiseList;
	}

	public MerchandiseVO getMerchandise(int id) {
		MerchandiseVO merchandiseVO = null;
		Connection connection = null;
		PreparedStatement ps = null;
		connection = DBManager.getConnection();
		String sql = "select merchandise.ID,Category,MerName,Price,SPrice,MerModel,Picture,MerDesc,Manufacturer,LeaveFactoryDate,Special,category.CateName categroyName"
				+ " from merchandise,category  where merchandise.Category=category.ID and merchandise.ID=?";
		try {
			// 事务
			connection.setAutoCommit(false);
			ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet set = ps.executeQuery();
			if (set.next()) {
				merchandiseVO = new MerchandiseVO(set.getInt("id"), set.getInt("category"), set.getString("mername"),
						set.getDouble("price"), set.getDouble("sprice"), set.getString("picture"),
						set.getString("merdesc"), set.getString("manufacturer"), set.getString("leavefactorydate"),
						set.getString("mermodel"), set.getInt("special"), set.getString("categroyName"));

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
		return merchandiseVO;
	}

	/**
	 * 获得所有商品类别
	 * 
	 * @return
	 */
	public List<CategoryModel> getCategoryList() {
		List<CategoryModel> categoryList = new ArrayList<CategoryModel>();
		Connection connection = null;
		PreparedStatement ps = null;
		connection = DBManager.getConnection();
		String sql = "select id, cateName, cateDesc from category";
		try {
			// 事务
			connection.setAutoCommit(false);
			ps = connection.prepareStatement(sql);
			ResultSet set = ps.executeQuery();
			while (set.next()) {
				CategoryModel categoryModel = new CategoryModel(set.getInt("id"), set.getString("cateName"),
						set.getString("cateDesc"));
				categoryList.add(categoryModel);
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
		return categoryList;
	}

	public static void main(String[] args) {
		// System.out.println(new
		// MerchandiseDAO().getMerchandiseListBySpecial(1).size());
		// System.out.println(new MerchandiseDAO().getCategoryList().size());
		System.out.println(new MerchandiseDAO().getMerchandiseListByLikeName(4,"商品关键字").size());
	}
}
