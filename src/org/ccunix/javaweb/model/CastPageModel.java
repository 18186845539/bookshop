package org.ccunix.javaweb.model;

import java.util.ArrayList;
import java.util.List;

/*
 * 
1 *  g1002	IPHONE4	很好1	4000	images/j2.jpg
2	g1003	IPHONE4S	很好2	4500	images/j1.jpg
3	g1004	IPHONE5	很好3	5000	images/j3.jpg
4	g1005	IPHONE5S	很好4	5500	images/j4.jpg
5	g1006	IPHONE6	很好5	6000	images/j5.jpg
6	g1007	IPHONE6S	很好6	6500	images/j6.jpg
7	g1008	IPHONE7	很好7	7000	images/j7.jpg
8	g1009	IPHONE7S	很好8	7500	images/j8.jpg


0
1
2
7
 * 
 * x页        (x-1)*5       5*x-1
 * 1页：    0              4
 * 2页       5              9
 * 3页       10             14
 * 
 */
public class CastPageModel {
	/**
	 * 页面中的数据
	 */
	private List dataList;

	/**
	 * 总条数
	 */

	private int totalNum;
	/**
	 * 显示当前页的数据信息
	 */
	private List currentDataList = new ArrayList();// dataList的子集
	/**
	 * 每页显示的数据条数 5条信息
	 */
	private int everyPageNum = 3;
	/**
	 * 总页数
	 */
	private int totalPage;
	/**
	 * 当前第多少页
	 */
	private int nowPage;
	/**
	 * 上一页
	 */
	private int upPage;
	/**
	 * 下一页
	 */
	private int nextPage;

	/**
	 * 构造器
	 * 
	 * @param dataList
	 *            所有数据
	 * @param nowPage
	 *            当前是第几页
	 */
	public CastPageModel(List dataList, int nowPage) {
		this.dataList = dataList;
		// 总条数
		totalNum = dataList.size();
		// 总页数 10条数据 5
		if (totalNum % everyPageNum == 0) {
			totalPage = totalNum / everyPageNum;
		} else {
			totalPage = totalNum / everyPageNum + 1;
		}
		//设置当前页不能大于总页数
		if(nowPage>totalPage) {
			this.nowPage = totalPage;
		}else {
			this.nowPage = nowPage;
		}
	}
	//设置数据
	public void setCurrentDataInfo() {
		// 上一页
		if (nowPage == 1) {
			upPage = 1;
		} else {
			upPage = nowPage - 1;
		}
		// 下一页
		if (nowPage == totalPage) {
			nextPage = nowPage;
		} else {
			nextPage = nowPage + 1;
		}

		// 组装数据
		if(dataList.size()==0) {
			return;
		}
		for (int i = (nowPage - 1) * everyPageNum; i <= nowPage*everyPageNum-1 && i < totalNum; i++) {
			currentDataList.add(dataList.get(i));
		}
	}
	public int getTotalNum() {
		return totalNum;
	}

	public List getCurrentDataList() {
		return currentDataList;
	}

	public int getEveryPageNum() {
		return everyPageNum;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public int getNowPage() {
		return nowPage;
	}

	public int getUpPage() {
		return upPage;
	}

	public int getNextPage() {
		return nextPage;
	}

}
