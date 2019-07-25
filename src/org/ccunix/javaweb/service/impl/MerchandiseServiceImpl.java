package org.ccunix.javaweb.service.impl;

import java.util.List;

import org.ccunix.javaweb.dao.impl_sql.MerchandiseDAO;
import org.ccunix.javaweb.model.CategoryModel;
import org.ccunix.javaweb.model.MerchandiseModel;
import org.ccunix.javaweb.service.iface.MerchandiseServiceIface;
import org.ccunix.javaweb.vo.MerchandiseVO;

public class MerchandiseServiceImpl implements MerchandiseServiceIface{
	
	MerchandiseDAO merchandiseDao = new MerchandiseDAO();
	@Override
	public List<MerchandiseVO> getMerchandiseListByCategory(int category) {
		
		return merchandiseDao.getMerchandiseListByCategory(category);
	}

	@Override
	public List<MerchandiseModel> getMerchandiseListByLikeName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MerchandiseVO> getMerchandiseListByLikeName(int category, String name) {
		
		return merchandiseDao.getMerchandiseListByLikeName(category, name);
	}

	@Override
	public List<MerchandiseVO> getMerchandiseListBySpecial(int special) {
		
		return merchandiseDao.getMerchandiseListBySpecial(special);
	}

	@Override
	public MerchandiseVO getMerchandise(int id) {
		
		return merchandiseDao.getMerchandise(id);
	}

	@Override
	public List<CategoryModel> getMerCategoryList() {
		return merchandiseDao.getCategoryList();
	}

}
