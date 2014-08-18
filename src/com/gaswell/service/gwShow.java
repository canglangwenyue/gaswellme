package com.gaswell.service;

import java.util.List;

import com.gaswell.entity.gw_show;

public interface gwShow {

	public List<gw_show> lists();

	public abstract void add(gw_show gh) throws Exception;

	public abstract boolean exists(gw_show gh) throws Exception;

	public void update(String name);
}
