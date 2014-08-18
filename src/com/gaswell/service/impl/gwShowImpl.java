package com.gaswell.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.gaswell.dao.baseDao;
import com.gaswell.dao.impl.baseDaoImpl;
import com.gaswell.entity.gw_show;
import com.gaswell.service.gwShow;

@Component("gwShow")
public class gwShowImpl implements gwShow {

	private baseDao dao = new baseDaoImpl();

//	public baseDao getDao() {
//		return dao;
//	}
//
//	@Resource
//	public void setDao(baseDao dao) {
//		this.dao = dao;
//	}

	public List<gw_show> lists() {
		// TODO Auto-generated method stub
		return this.dao.getgaswell();
	}

	public void add(gw_show gh) throws Exception {

		// dao = new baseDaoImpl();
		dao.add(gh);

	}

	public boolean exists(gw_show gh) throws Exception {
		// TODO Auto-generated method stub
		return this.dao.checkUserExistsWithName(gh.getName());
	}

	public void update(String name) {
		// TODO Auto-generated method stub

	}

}
