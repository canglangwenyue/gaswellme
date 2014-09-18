package com.gaswell.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.gaswell.entity.gw_show;
import com.gaswell.service.gwShow;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
@Component("gs_showAction")
@Scope("prototype")
public class gs_showAction extends ActionSupport {

	private List<gw_show> gsList;
	private gwShow dao;

	public gwShow getDao() {
		return dao;
	}

	@Resource(name = "gwShow")
	public void setDao(gwShow dao) {
		this.dao = dao;
	}

	public List<gw_show> getGsList() {
		return gsList;
	}

	public void setGsList(List<gw_show> gsList) {
		this.gsList = gsList;
	}

	@Override
	public String execute() throws Exception {
		list();
		return "list";
	}

	public List<gw_show> list() {
		this.gsList = this.dao.lists();
		System.out.println(gsList.get(0).getLand_voltage());
		return gsList;
	}
}
