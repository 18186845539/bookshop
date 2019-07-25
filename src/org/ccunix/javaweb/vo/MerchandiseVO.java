package org.ccunix.javaweb.vo;

import org.ccunix.javaweb.model.MerchandiseModel;

/**
 * 从数据库中获取商品信息的类 扩展model 对单表的对应
 * 
 * @author Administrator
 *
 */
public class MerchandiseVO extends MerchandiseModel {
	/**
	 * 商品类型名称
	 */
	private String categroyName;

	public MerchandiseVO(int id, int category, String mername, double price, double sprice, String picture,
			String merdesc, String manufacturer, String leavefactorydate, String mermodel, int special,
			String categroyName) {
		super(id, category, mername, price, sprice, picture, merdesc, manufacturer, leavefactorydate, mermodel,
				special);
		this.categroyName = categroyName;
	}

	public String getCategroyName() {
		return categroyName;
	}

	public void setCategroyName(String categroyName) {
		this.categroyName = categroyName;
	}

}
