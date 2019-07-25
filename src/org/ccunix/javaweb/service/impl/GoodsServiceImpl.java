package org.ccunix.javaweb.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.ccunix.javaweb.dao.impl_sql.GoodsDAO;
import org.ccunix.javaweb.model.GoodsModel;
import org.ccunix.javaweb.service.iface.GoodsServiceIface;

public class GoodsServiceImpl implements GoodsServiceIface{

	@Override
	public List<GoodsModel> getGoodsList() throws SQLException {
		GoodsDAO goodsDAO = new GoodsDAO();
		return goodsDAO.getGoodsList();
	}

	@Override
	public boolean deleteGoodsByGid(String gid) throws SQLException {
		GoodsDAO goodsDAO = new GoodsDAO();
		return goodsDAO.deleteGoodsByGid(gid);
	}

	@Override
	public GoodsModel queryGoodsByGid(String gid) throws SQLException {
		GoodsDAO goodsDAO = new GoodsDAO();
		return goodsDAO.queryGoodsByGid(gid);
	}

	@Override
	public boolean updateGoodsByGid(String gid, String name, double price, String descs, String img)
			throws SQLException {
		GoodsDAO goodsDAO = new GoodsDAO();
		GoodsModel goodsModel = new GoodsModel(gid, name, descs, price, img);
		return goodsDAO.updateGoodsByGid(gid,goodsModel);
	}

}
