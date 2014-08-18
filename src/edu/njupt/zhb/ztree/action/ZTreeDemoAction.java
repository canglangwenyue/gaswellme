/*
 * $filename: ZTreeDemoAction.java,v $
 * $Date: Sep 27, 2013  $
 * Copyright (C) ZhengHaibo, Inc. All rights reserved.
 * This software is Made by Zhenghaibo.
 */
package edu.njupt.zhb.ztree.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * @author canglangwenyue
 *
 */
public class ZTreeDemoAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3318989776253565435L;

	private int treeNodeId;// 保存树节点的Id

	/**
	 * 返回树的根节点的Json格式数据
	 * 
	 * @return
	 */
	public String getNodesDataById() {
		System.out.println("treeNodeId = " + treeNodeId);
		String iconPath = ",icon:\"zTree/css/zTreeStyle/img/diy/3.png\"";
		String icon9Path = ",icon:\"zTree/css/zTreeStyle/img/diy/9.png\"";
		String nodesJson = "";
		if (treeNodeId == 1) {
			nodesJson = "[{id:11, pId:" + treeNodeId
					+ ", name: \"中国石油长庆油田分公司\",isParent:true" + iconPath + "},"
					+ "{id:12, pId:" + treeNodeId
					+ ", name: \"附属设施\",isParent:true" + iconPath + "},"
					+ "{id:13, pId:" + treeNodeId
					+ ", name: \"调试待安装气井\",isParent:false" + iconPath + "}"
					+ "]";
		} else if (treeNodeId == 11) {
			nodesJson = "[{id:111, pId:" + treeNodeId
					+ ", name: \"作业一区\",isParent:true" + icon9Path + "},"
					+ "{id:112, pId:" + treeNodeId
					+ ", name: \"作业二区\",isParent:true" + icon9Path + "}," + "]";
		} else if (treeNodeId == 111) {
			nodesJson = "[{id:1111, pId:" + treeNodeId
					+ ", name: \"高－2集气站\",isParent:false" + icon9Path + "},"
					+ "{id:1112, pId:" + treeNodeId
					+ ", name: \"高－4集气站\",isParent:false" + icon9Path + "},"
					+ "{id:1113, pId:" + treeNodeId
					+ ", name: \"高－5集气站\",isParent:false" + icon9Path + "},"
					+ "{id:1114, pId:" + treeNodeId
					+ ", name: \"高－7集气站\",isParent:false" + icon9Path + "},"
					+ "{id:1115, pId:" + treeNodeId
					+ ", name: \"高－8集气站\",isParent:false" + icon9Path + "},"
					+ "{id:1116, pId:" + treeNodeId
					+ ", name: \"高－9集气站\",isParent:false" + icon9Path + "},"
					+ "{id:1117, pId:" + treeNodeId
					+ ", name: \"高－11集气站\",isParent:false" + icon9Path + "},"
					+ "{id:1118, pId:" + treeNodeId
					+ ", name: \"高－12集气站\",isParent:false" + icon9Path + "},"
					+ "{id:1119, pId:" + treeNodeId
					+ ", name: \"高－13集气站\",isParent:false" + icon9Path + "},"
					+ "]";
		}
		else if (treeNodeId == 112) {
			nodesJson = "[{id:1120, pId:" + treeNodeId
					+ ", name: \"苏南－11集气站\",isParent:false" + icon9Path + "},"
					+ "{id:1121, pId:" + treeNodeId
					+ ", name: \"苏南－12集气站\",isParent:false" + icon9Path + "},"
					+ "{id:1122, pId:" + treeNodeId
					+ ", name: \"苏南－13集气站\",isParent:false" + icon9Path + "},"
					+ "{id:1123, pId:" + treeNodeId
					+ ", name: \"苏南－15集气站\",isParent:false" + icon9Path + "},"
					+ "{id:1124, pId:" + treeNodeId
					+ ", name: \"苏南－16集气站\",isParent:false" + icon9Path + "},"
					+ "{id:1125, pId:" + treeNodeId
					+ ", name: \"苏南－18集气站\",isParent:false" + icon9Path + "},"
					+ "{id:1126, pId:" + treeNodeId
					+ ", name: \"苏南－21集气站\",isParent:false" + icon9Path + "},"
					+ "{id:1127, pId:" + treeNodeId
					+ ", name: \"苏南－22集气站\",isParent:false" + icon9Path + "},"
					+ "{id:1128, pId:" + treeNodeId
					+ ", name: \"苏南－27集气站\",isParent:false" + icon9Path + "},"
					+ "{id:1129, pId:" + treeNodeId
					+ ", name: \"苏南－29集气站\",isParent:false" + icon9Path + "},"
					+ "{id:1130, pId:" + treeNodeId
					+ ", name: \"苏南－32集气站\",isParent:false" + icon9Path + "},"
					+ "]";
		} else if (treeNodeId == 12) {
			nodesJson = "[{id:121, pId:" + treeNodeId
					+ ", name: \"第一净化厂\",isParent:false" + icon9Path + "},"
					+ "{id:122, pId:" + treeNodeId
					+ ", name: \"油房庄\",isParent:false" + icon9Path + "},"
					+ "{id:122, pId:" + treeNodeId
					+ ", name: \"第五处理厂\",isParent:false" + icon9Path + "},"
					+ "{id:122, pId:" + treeNodeId
					+ ", name: \"第四净化厂\",isParent:false" + icon9Path + "},"
					+ "{id:122, pId:" + treeNodeId
					+ ", name: \"志丹\",isParent:false" + icon9Path + "},"
					+ "]";
		} else if(treeNodeId == 2) {
			nodesJson = "[{id:21, pId:" + treeNodeId
					+ ", name: \"中国石油长庆油田分公司\",isParent:true" + iconPath + "},"
					+ "]";
		} else if (treeNodeId == 21) {
			nodesJson = "[{id:211, pId:" + treeNodeId
					+ ", name: \"作业一区\",isParent:true" + icon9Path + "},"
					+ "{id:212, pId:" + treeNodeId
					+ ", name: \"作业二区\",isParent:true" + icon9Path + "}," + "]";
		} else if (treeNodeId == 211) {
			nodesJson = "[{id:2111, pId:" + treeNodeId
					+ ", name: \"高－2集气站\",isParent:false" + icon9Path + "},"
					+ "{id:2112, pId:" + treeNodeId
					+ ", name: \"高－4集气站\",isParent:false" + icon9Path + "},"
					+ "{id:2113, pId:" + treeNodeId
					+ ", name: \"高－5集气站\",isParent:false" + icon9Path + "},"
					+ "{id:2114, pId:" + treeNodeId
					+ ", name: \"高－7集气站\",isParent:false" + icon9Path + "},"
					+ "{id:2115, pId:" + treeNodeId
					+ ", name: \"高－8集气站\",isParent:false" + icon9Path + "},"
					+ "{id:2116, pId:" + treeNodeId
					+ ", name: \"高－9集气站\",isParent:false" + icon9Path + "},"
					+ "{id:2117, pId:" + treeNodeId
					+ ", name: \"高－11集气站\",isParent:false" + icon9Path + "},"
					+ "{id:2118, pId:" + treeNodeId
					+ ", name: \"高－12集气站\",isParent:false" + icon9Path + "},"
					+ "{id:2119, pId:" + treeNodeId
					+ ", name: \"高－13集气站\",isParent:false" + icon9Path + "},"
					+ "]";
		}
		else if (treeNodeId == 212) {
			nodesJson = "[{id:2121, pId:" + treeNodeId
					+ ", name: \"苏南－11集气站\",isParent:false" + icon9Path + "},"
					+ "{id:2122, pId:" + treeNodeId
					+ ", name: \"苏南－12集气站\",isParent:false" + icon9Path + "},"
					+ "{id:2123, pId:" + treeNodeId
					+ ", name: \"苏南－13集气站\",isParent:false" + icon9Path + "},"
					+ "{id:2124, pId:" + treeNodeId
					+ ", name: \"苏南－15集气站\",isParent:false" + icon9Path + "},"
					+ "{id:2125, pId:" + treeNodeId
					+ ", name: \"苏南－16集气站\",isParent:false" + icon9Path + "},"
					+ "{id:2126, pId:" + treeNodeId
					+ ", name: \"苏南－18集气站\",isParent:false" + icon9Path + "},"
					+ "{id:2127, pId:" + treeNodeId
					+ ", name: \"苏南－21集气站\",isParent:false" + icon9Path + "},"
					+ "{id:2128, pId:" + treeNodeId
					+ ", name: \"苏南－22集气站\",isParent:false" + icon9Path + "},"
					+ "{id:2129, pId:" + treeNodeId
					+ ", name: \"苏南－27集气站\",isParent:false" + icon9Path + "},"
					+ "{id:2130, pId:" + treeNodeId
					+ ", name: \"苏南－29集气站\",isParent:false" + icon9Path + "},"
					+ "{id:2131, pId:" + treeNodeId
					+ ", name: \"苏南－32集气站\",isParent:false" + icon9Path + "},"
					+ "]";
		}  else if (treeNodeId == 3) {
			nodesJson = "[{id:31, pId:" + treeNodeId
					+ ", name: \"天然气生产\",isParent:false" + iconPath + "},"
					+ "{id:32, pId:" + treeNodeId
					+ ", name: \"集输管线\",isParent:false" + iconPath + "},"
					+ "{id:33, pId:" + treeNodeId
					+ ", name: \"气井管理\",isParent:false" + iconPath + "},"
					+ "{id:34, pId:" + treeNodeId
					+ ", name: \"气井统计\",isParent:false" + iconPath + "},"
					+ "{id:35, pId:" + treeNodeId
					+ ", name: \"管线信息管理\",isParent:false" + iconPath + "},"
					+ "{id:36, pId:" + treeNodeId
					+ ", name: \"气井开关配置\",isParent:false" + iconPath + "},"
					+ "{id:37, pId:" + treeNodeId
					+ ", name: \"气井开关策略\",isParent:false" + iconPath + "},"
					+ "{id:38, pId:" + treeNodeId
					+ ", name: \"特殊气井监控\",isParent:false" + iconPath + "},]";
		} else if (treeNodeId == 4) {
			nodesJson = "[{id:41, pId:" + treeNodeId
					+ ", name: \"报警查询\",isParent:false" + iconPath + "},"
					+ "{id:42, pId:" + treeNodeId
					+ ", name: \"报警信息\",isParent:false" + iconPath + "},"
					+ "{id:43, pId:" + treeNodeId
					+ ", name: \"报警配置\",isParent:false" + iconPath + "},"+ "{id:43, pId:" + treeNodeId
					+ ", name: \"报警策略\",isParent:false" + iconPath + "},]";
		}  else if (treeNodeId == 5) {
			nodesJson = "[{id:51, pId:" + treeNodeId
					+ ", name: \"用户管理\",isParent:false" + iconPath + "},"
					+ "{id:52, pId:" + treeNodeId
					+ ", name: \"角色管理\",isParent:false" + iconPath + "},"
					+ "{id:53, pId:" + treeNodeId
					+ ", name: \"单位管理\",isParent:false" + iconPath + "},"+ "{id:54, pId:" + treeNodeId
					+ ", name: \"系统参数\",isParent:false" + iconPath + "},]";
		}  
		else {
			nodesJson = "[]";// 其他情况：父节点没有子节点
		}
		getPrintWriter().write(nodesJson);
		return SUCCESS;
	}

	/**
	 * 获得HttpServletResponse对象
	 * 
	 * @return
	 */
	public static HttpServletResponse getResponse() {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		return response;
	}

	public PrintWriter getPrintWriter() {
		PrintWriter pw = null;
		try {
			pw = getResponse().getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return pw;
	}

	public int getTreeNodeId() {
		return treeNodeId;
	}

	public void setTreeNodeId(int treeNodeId) {
		this.treeNodeId = treeNodeId;
	}
}
