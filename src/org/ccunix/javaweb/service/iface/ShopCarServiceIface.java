package org.ccunix.javaweb.service.iface;
/**
 * 购物车接口
 * @author Administrator
 *
 */

import java.util.List;

import org.ccunix.javaweb.model.CartModel;
import org.ccunix.javaweb.vo.CartSelectedMerVO;
import org.ccunix.javaweb.vo.OrderVO;
import org.ccunix.javaweb.vo.ShopCarVO;

public interface ShopCarServiceIface {
	
    public boolean addShopCar(int member,double money) ; 
    /**
     * 购物车详情中是否存在该商品
     * @param merchandise
     * @return
     */
    public boolean isExistShopCartItem(int merchandise,int cart);
  
    /**
     * 查看是否存在该会员的购物车  如果有  返回去
     * @param merchandise 会员id
     * @return 购物车信息
     */
    public CartModel isShopCartItemExistId(int merchandise);
    /**
     * 向购物车中插入商品    如果商品项中  没有该商品  那么数量就是1   否则  数量+1
     * @param cart
     * @param merchandise
     * @param price
     * @param i 
     * @return
     */
    public boolean addShopCartItem(int cart,int merchandise,double price, int favourable);
    /**
     * 更新购物车中的总金额
     * @param price
     * @return
     */
    public boolean updateShopCartMoney(double price);
    
    /**
     * 查看购物车     商品表   购物车表   详情表
     * 
     */
    public List<ShopCarVO> getShopCartList(String member);
    /**
     * 购物车清空   输入：用户id、购物车状态0    输出：boolean 
     * @param member
     */
    public boolean deleteShopCart(int cart);
    
    //清空购物车详情
    public boolean deleteShopCartItem(int cart);
    /**
     * 通过加购物车更新商品
     * @param merchandise 商品id
     * @param id 商品购物车
     */
	public boolean updateCartselected(int merchandise, int cart);
	/**
	 * 通过改变商品项的数量  更新商品
	 * @param itemId 商品项id
	 * @param cart 购物车
	 * @param num 数量
	 * @return
	 */
	public boolean updateCartselected(int itemId, int cart,int num);
	/**
	 * 根据购物车id查询购物详情
	 * @param cart
	 * @return
	 */
	public List<CartSelectedMerVO> getShopCartItemList(int cart); 
    /**
     * 按照商品详情id删除购物车详情信息
     * @param id
     * @return
     */
	public boolean deleteShopCartByItemId(int id,int cart);
	
}
