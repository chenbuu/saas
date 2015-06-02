<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
    <head>
        <title>工单管理</title>
        
        <link rel="stylesheet" type="text/css" href="<s:url value="/view/bootstrap/css/bootstrap.min.css"/>">
        
        <script type="text/javascript" src="<s:url value="/view/jquery/jquery.min.js"/>"></script>
	    <script type="text/javascript" src="<s:url value="/view/jquery/jquery.easyui.min.js"/>"></script>
	    <script type="text/javascript" src="<s:url value="/view/jquery/locale/easyui-lang-zh_CN.js"/>"></script>
	    <link rel="stylesheet" type="text/css" href="<s:url value="/view/jquery/themes/metro/easyui.css"/>">
	    <link rel="stylesheet" type="text/css" href="<s:url value="/view/jquery/themes/icon.css"/>">
	    <link rel="stylesheet" type="text/css" href="<s:url value="/view/jquery/demo/demo.css"/>">
		
		<script type="text/javascript" src="<s:url value="/view/system/mgmt/js/dic4Box.js"/>"></script>
		<script type="text/javascript" src="<s:url value="/view/system/mgmt/js/showDialog.js"/>"></script>
        <script type="text/javascript" src="<s:url value="/view/system/gd/js/gdTable.js"/>"></script>
        
        <script type="text/javascript" src="<s:url value="/view/bootstrap/js/bootstrap.min.js"/>"></script>
		<script type="text/javascript" src="<s:url value="/view/AjaxFileUploader/ajaxfileupload.js"/>"></script>
    </head>
    <body id="panel0" class="easyui-layout">
	    <div id="panel1" data-options="region:'north',split:true" style="height:185px;display:none;background-color:#FFFAFA;">
			<table cellspacing="10px" border-spacing="10px" class="table table-condensed">
                <tr>
                    <td>工单号：</td>
                    <td><input id="search_gdh" class="searchInput" /><br></td>
                    <td>状态：</td>
                    <td><input id="search_zt" class="searchInput"  /><br></td>
                    <td>工单类型：</td>
                    <td><input id="search_gdlx" class="searchInput"  /><br></td>
                </tr>
                <tr>
                    <td>紧急：</td>
                    <td><input id="search_jj" class="searchInput" /><br></td>
                    <td>客户名称：</td>
                    <td><input id="search_khmc" class="searchInput" /><br></td>
                    <td>联系人：</td>
                    <td><input id="search_lxr" class="searchInput" /><br></td>
                </tr>
                <tr>
                    <td>联系方式：</td>
                    <td><input id="search_lxfs" class="searchInput" /><br></td>
                    <td>创建时间从：</td>
                    <td><input id="search_cjsj1" class="easyui-datetimebox" style="width:200px;height:25px;" /><br></td>
                    <td>到：</td>
                    <td><input id="search_cjsj2" class="easyui-datetimebox" style="width:200px;height:25px;" /><br></td>
                </tr>
                <tr>
                    <td>施工人员：</td>
                    <td><input id="search_zpry" class="searchInput" /></td>
                </tr>
                <tr align="center">
                   <td colspan="6">
                       <input type="button" id="searchDo" style="width:60;" value="查询"/>
                       <input type="button" id="searchRest" style="width:60;" value="重置"/>
                   </td>
                </tr>
            </table>
	    </div>
		<div id="panel2" data-options="region:'center',split:true" >
			<table id="gd_table1" fit="true"></table>
        	<div id="dd"></div>
		</div>
        
        <!-- 是否只读 -->
        <input type="hidden" id="hasReadonly">
        <!-- 隐藏新增工单表单(客户用) -->
        <input type="hidden" id="hasShowFieldset4new">
        <!-- 隐藏工单详情表单(通用) -->
        <input type="hidden" id="hasShowFieldset4gd">
        <!-- 隐藏实施详情表单(客户用) -->
        <input type="hidden" id="hasShowFieldset4ssxq">
        <!-- 隐藏被动派单 -->
        <input type="hidden" id="hasShowFieldset4bdpd">
        <!-- 隐藏主动派单 -->
        <input type="hidden" id="hasShowFieldset4zdpd">
        <!-- 隐藏施工人员表单 -->
        <input type="hidden" id="hasShowFieldset4sgry">
        <!-- 隐藏评价表单 -->
        <input type="hidden" id="hasShowFieldset4pj">
        <!-- 隐藏计分表单 -->
        <input type="hidden" id="hasShowFieldset4jf">
        
    </body>
</html>