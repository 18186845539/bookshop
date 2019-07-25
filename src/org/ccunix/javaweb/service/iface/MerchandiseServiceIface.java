package org.ccunix.javaweb.service.iface;
import java.util.List;

import org.ccunix.javaweb.model.CategoryModel;
import org.ccunix.javaweb.model.MerchandiseModel;
import org.ccunix.javaweb.vo.MerchandiseVO;
/**
 * 商品业务接口
 * @author Administrator
 *
 */
public interface MerchandiseServiceIface {
    /**
     * 根据商品类别 查询商品信息集合
     * @param category 商品类别
     * @return 商品集合
     */
	
	public List<MerchandiseVO> getMerchandiseListByCategory(int category);
	/**
	 * 根据商品关键字  查询所有满足条件的商品集合   
	 * @param name 匹配的名称
	 * @return 商品集合
	 */
	public List<MerchandiseModel> getMerchandiseListByLikeName(String name);
	/**
	 * 查询特定类型商品  具有此关键字的商品
	 * @param category 商品的类型
	 * @param name 匹配的商品名称
	 * @return 商品集合
	 */
	public List<MerchandiseVO> getMerchandiseListByLikeName(int category,String name);
	/**
	 * 查询新品或者特价的商品集合
	 * @param special 是否特价
	 * @return 商品集合
	 */
	public List<MerchandiseVO> getMerchandiseListBySpecial(int special);
	/**
	 * 按照商品主键查询商品详情     
	 * @param id  主键
	 * @return 一个商品信息
	 */
	public MerchandiseVO getMerchandise(int id);
	/**
	 * 获得商品类别
	 * @return
	 */
	public List<CategoryModel> getMerCategoryList();

}
