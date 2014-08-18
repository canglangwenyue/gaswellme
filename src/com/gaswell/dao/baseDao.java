package com.gaswell.dao;

import java.util.List;

import com.gaswell.entity.gw_show;

public interface baseDao {

	public void add(gw_show gh);

	public void update(String name);

	public boolean checkUserExistsWithName(String gwName);

	public List<gw_show> getgaswell();

}
