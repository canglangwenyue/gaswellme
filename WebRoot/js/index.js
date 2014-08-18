/**
 * 设置zTree树
 */
var setting = {
	async: {
		enable: true,
		url: getUrlByNodeId
	},
	check: {
		enable: false
	},
	data: {
		simpleData: {
			enable: true
		}
	},
	view: {
		expandSpeed: ""
	},
	callback: {
		beforeExpand: beforeExpand,
		onAsyncSuccess: onAsyncSuccess,
		onAsyncError: onAsyncError,
		onClick: zTreeOnClick
	}
};
var zNodes =[
	{name:"生产数据管理", id:"1",isParent:true,iconOpen:"zTree/css/zTreeStyle/img/diy/1_open.png", iconClose:"zTree/css/zTreeStyle/img/diy/1_close.png"},
	{name:"电子巡井", id:"2",isParent:true,iconOpen:"zTree/css/zTreeStyle/img/diy/1_open.png", iconClose:"zTree/css/zTreeStyle/img/diy/1_close.png"},
	{name:"天然气生产管理", id:"3",isParent:true,iconOpen:"zTree/css/zTreeStyle/img/diy/1_open.png", iconClose:"zTree/css/zTreeStyle/img/diy/1_close.png"},
	{name:"报警管理", id:"4",isParent:true,iconOpen:"zTree/css/zTreeStyle/img/diy/1_open.png", iconClose:"zTree/css/zTreeStyle/img/diy/1_close.png"},
	{name:"系统管理", id:"5",isParent:true,iconOpen:"zTree/css/zTreeStyle/img/diy/1_open.png", iconClose:"zTree/css/zTreeStyle/img/diy/1_close.png"}
];
/**
 * @author ZhengHaibo
 * 功能：通过NodeId获得节点的孩子节点
 * 调用：当父节点展开时，调用，返回该父节点的子节点
 * 后台数据格式：JSON
 * @param treeId 树控件的Id
 * @param treeNode 树节点对象：包含Id等信息
 * @return
 */
function getUrlByNodeId(treeId, treeNode) {
	return "getNodesDataById?treeNodeId="+treeNode.id;
}
/**
 * 展开之前执行的函数
 * @param treeId
 * @param treeNode
 * @return
 */
function beforeExpand(treeId, treeNode) {
	if (!treeNode.isAjaxing) {
		ajaxGetNodes(treeNode, "refresh");
		return true;
	} else {
		alert("Loading...");
		return false;
	}
}
/**
 * 加载成功后执行的函数
 * @param event 封装了js的事件
 * @param treeId 树控件的Id
 * @param treeNode 树节点对象
 * @param msg 返回的JSON格式的消息
 * @return
 */
function onAsyncSuccess(event, treeId, treeNode, msg) {
    console.log("treeId");
    console.log(treeId);
    console.log("treeNode");
    console.log(treeNode);
    console.log("msg");
    console.log(msg);
	if (!msg || msg.length == 0) {
		return;
	}
	var zTree = $.fn.zTree.getZTreeObj("treeDemo");
	treeNode.icon = "";
	zTree.updateNode(treeNode);//更新树结构
	zTree.selectNode(treeNode.children[0]);//设置为第一个子节点为选中状态
}
function onAsyncError(event, treeId, treeNode, XMLHttpRequest, textStatus, errorThrown) {
	var zTree = $.fn.zTree.getZTreeObj("treeDemo");
	alert("Error ! 异步获取数据异常");
	treeNode.icon = "";
	zTree.updateNode(treeNode);
}
function ajaxGetNodes(treeNode, reloadType) {
	var zTree = $.fn.zTree.getZTreeObj("treeDemo");
	if (reloadType == "refresh") {
		treeNode.icon = "zTree/css/zTreeStyle/img/loading.gif";
		zTree.updateNode(treeNode);
	}
	zTree.reAsyncChildNodes(treeNode, reloadType, true);
}
/**
 * 功能：当点击树节点时，调用该函数
 * @param event
 * @param treeId
 * @param treeNode
 * @return
 */
function zTreeOnClick(event, treeId, treeNode) {
    console.log("zTreeOnClickLog:--------------------------------")
    console.log(treeId);
    console.log(treeNode);
    console.log(treeNode.id);
    switch(treeNode.id+""){//根据树节点的Id判断
    case "1":
    case "1121":
    	document.getElementById("iframepage").src="demo.jsp";
    	break;
    case "1122":
    	document.getElementById("iframepage").src="test.jsp";
    	break;
    case "12":
    	document.getElementById("iframepage").src="test.jsp";
    	break;
    case "13":
    	document.getElementById("iframepage").src="tree_click_page.jsp?treeNodeId="+treeNode.id;
    	break;
    case "2":
    case "21":
    	document.getElementById("iframepage").src="tree_click_page.jsp?treeNodeId="+treeNode.id;
    	break;
    case "22":
    	document.getElementById("iframepage").src="tree_click_page.jsp?treeNodeId="+treeNode.id;
    	break;
    case "23":
    	document.getElementById("iframepage").src="tree_click_page.jsp?treeNodeId="+treeNode.id;
    	break;
    case "24":
    	document.getElementById("iframepage").src="tree_click_page.jsp?treeNodeId="+treeNode.id;
    	break;
    case "3":
    case "31":
    	document.getElementById("iframepage").src="tree_click_page.jsp?treeNodeId="+treeNode.id;
    	break;
    case "32":
    	document.getElementById("iframepage").src="tree_click_page.jsp?treeNodeId="+treeNode.id;
    	break;
    case "4":
    case "31":
    	document.getElementById("iframepage").src="tree_click_page.jsp?treeNodeId="+treeNode.id;
    	break;
    case "32":
    	document.getElementById("iframepage").src="tree_click_page.jsp?treeNodeId="+treeNode.id;
    	break;
    case "5":
    case "31":
    	document.getElementById("iframepage").src="tree_click_page.jsp?treeNodeId="+treeNode.id;
    	break;	
    case "32":
    	document.getElementById("iframepage").src="tree_click_page.jsp?treeNodeId="+treeNode.id;
    	break;
    }
}
$(document).ready(function(){
	$.fn.zTree.init($("#treeDemo"), setting, zNodes);//初始化zTree树
	SelectNode();
});
function SelectNode() {
    var treeObj = $.fn.zTree.getZTreeObj("treeDemo");
    
    for(i=1; i<6; i++)
    {
    	var treenode = treeObj.getNodeByParam("id", i, null);
    	treeObj.expandNode(treenode, true, true, true);
    	treeObj.selectNode(treenode);
    }
}

