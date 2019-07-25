package org.ccunix.javaweb.service.iface;
import org.ccunix.javaweb.vo.MemberVO;
/**
 * 会员操作接口
 * @author Administrator
 *
 */
public interface MemberServiceIface {
	/**
	 * 用户登陆
	 * @param loginName 用户名
	 * @param loginPwd  密码
	 * @return 用户对象
	 */
	public MemberVO loginValidate(String loginName,String loginPwd);
	/**
	 * 用户注册 
	 * @param memberLevel 会员级别
	 * @param memberName 真实姓名
	 * @param loginName  登陆账号
	 * @param loginPwd  密码
	 * @param phone 电话
	 * @param address 地址
	 * @param zip 邮编
	 * @param email 邮箱
	 * @return true成功  false  失败
	 */
	public boolean regedit(int memberLevel,String memberName,String loginName,String loginPwd,String phone,String address,String zip,String email);
    /**
     * 用户退出
     * @return
     */
    public boolean exitUser();
    
    /**
	 * 用户修改
	 * @param id 会员id主键
	 * @param memberLevel 会员级别
	 * @param memberName 真实姓名
	 * @param loginName  登陆账号
	 * @param loginPwd  密码
	 * @param phone 电话
	 * @param address 地址
	 * @param zip 邮编
	 * @param email 邮箱
	 * @return true成功  false  失败
	 */
    public boolean update(int id,int memberLevel,String memberName,String loginName,String loginPwd,String phone,String address,String zip,String email);
}
