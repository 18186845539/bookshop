package org.ccunix.javaweb.model;
/**
 * 商品模型
 * @author Administrator
 *
 */
public class GoodsModel {
	private Integer id;
	private String gid;// 商品id
	private String name;// 商品姓名
	private String descs;// 商品描述
	private double price;// 商品价格
	private String img;// 商品图片

	public GoodsModel() {
	}

	public GoodsModel(Integer id,String gid, String name, String descs, double price,
			String img) {
		this.id = id;
		this.gid = gid;
		this.name = name;
		this.descs = descs;
		this.price = price;
		this.img = img;
	}
	public GoodsModel(String gid, String name, String descs, double price,
			String img) {
		this.gid = gid;
		this.name = name;
		this.descs = descs;
		this.price = price;
		this.img = img;
	}

	public String getGid() {
		return gid;
	}

	public void setGid(String gid) {
		this.gid = gid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescs() {
		return descs;
	}

	public void setDescs(String descs) {
		this.descs = descs;
	}

}
