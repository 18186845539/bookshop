package org.ccunix.javaweb.service.iface;

import java.sql.SQLException;
import java.util.List;

import org.ccunix.javaweb.model.GoodsModel;

public interface GoodsServiceIface {
	/**
	 * 查询所有商品信息
	 * 
	 * @return 商品列表
	 */
	public List<GoodsModel> getGoodsList() throws SQLException;

	/**
	 * 按照商品编号删除商品信息
	 * 
	 * @param gid
	 *            商品编号
	 * @return 是否成功
	 * @throws SQLException
	 *             sql异常
	 */
	public boolean deleteGoodsByGid(String gid) throws SQLException;

	/**
	 * 按照商品id查询商品信息
	 * @param gid 商品id
	 * @return 商品
	 * @throws SQLException sql异常
	 */
	public GoodsModel queryGoodsByGid(String gid) throws SQLException;
    /**
     * 根据商品id 修改商品信息
     * @param gid
     * @param name
     * @param price
     * @param descs
     * @param img
     * @return
     * @throws SQLException
     */
	public boolean updateGoodsByGid(String gid, String name, double price, String descs, String img) throws SQLException;
}
