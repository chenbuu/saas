<%@page contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<script type="text/javascript">
    jQuery(function ($) {
    	//全部菜单列表
        var cdList = [<s:iterator value = "#session.cdList" var = "p"><s:property value = "#p" />,</s:iterator>];
        var mgmt = $("#mgmt");
        var perm = new Array();
        for(var i = 1; i< 100; i++) {
        	if($.inArray(i, cdList) > -1){
        		perm[i] = true;
        	};
        };
        //alert("菜单权限列表/" + cdList);
        //静态化iframe 提高性能
        var iframe1 = $("#iframe1");
        mgmt.empty();
        //获取用户Id
		var userId = <%=session.getAttribute("userId")%>;
		getUserId = function () {
			return userId;
		};
        //获取用户角色类型
		var roleId = <%=session.getAttribute("roleId")%>;
		getRoleId = function () {
			return roleId;
		};
		mgmt.append("<br>");
		//客户页面
		if (perm[1] ) {
        	mgmt.append("<p id='khwhsqym'><button class='default' role='button'>客户维护申请页面</button></p><br>");
        }
        
        if (perm[2] ) {
        	mgmt.append("<p id='gdTable1'><button class='default' role='button'>未完工单</button></p><br>");
        }
        
        if (perm[3] ) {
        	mgmt.append("<p id='gdTable2'><button class='default' role='button'>已完评价</button></p><br>");
        }
        
        if (perm[4] ) {
        	mgmt.append("<p id='tsjy'><button class='default' role='button'>投诉建议</button></p><br>");
        }
        
        //施工人员页面
        if (perm[5] ) {
        	mgmt.append("<p id='gdTable3'><button class='default'>待接工单</button></p><br>");
        }
        
        if (perm[6] ) {
        	mgmt.append("<p id='gdTable4'><button class='default' role='button'>已完工单</button></p><br>");
        }
        
        //售后维护经理页面
        if (perm[7] ) {
        	mgmt.append("<p id='zdpd'><button class='default' role='button'>主动派单</button></p><br>");
        }
        
        if (perm[8] ) {
        	mgmt.append("<p id='khgl'><button class='default' role='button'>客户管理</button></p><br>");
        }
        
        if (perm[9] ) {
        	mgmt.append("<p id='gdTable5'><button class='default' role='button'>被动派单</button></p><br>");
        }
        
        if (perm[10] ) {
        	mgmt.append("<p id='rygl'><button class='default' role='button'>人员管理</button></p><br>");
        }
        
        if (perm[11] ) {
        	mgmt.append("<p id='gdTable0'><button class='default' role='button'>工单列表</button></p><br>");
        }
        
        if (perm[12] ) {
        	mgmt.append("<p id='gzltj'><button class='default' role='button'>工作量统计(施工)</button></p><br>");
        }
        
        if (perm[16] ) {
        	mgmt.append("<p id='gzltj2'><button class='default' role='button'>工作量统计(客户)</button></p><br>");
        }
        
        //回访人员页面
        if (perm[13] ) {
        	mgmt.append("<p id='gdTable6'><button class='default' role='button'>已完成工单列表</button></p><br>");
        }
        
        if (perm[14] ) {
        	mgmt.append("<p id='cktsjy'><button class='default' role='button'>查看投诉建议</button></p><br>");
        }
        
        //修改密码
        if (perm[15] ) {
        	mgmt.append("<p id='mm'><button class='default' role='button'>修改密码</button></p><br>");
        }
        
        //标示不同的工单状态
		var gdType = 0;
		getGdType = function () {
			return gdType;
		};
		
		//标示不同的页面跳转方式
		var pdType = 0;
		getPdType = function () {
			return pdType;
		};
		
        $("#gdTable0").click(function () {
        	gdType = 0;
        	pdType = 0;
            iframe1.attr("src", "<s:url value='/view/system/gd/jsp/gdTable.jsp'/>");
        });
        
        $("#gdTable1").click(function () {
        	gdType = 1;
        	pdType = 0;
            iframe1.attr("src", "<s:url value='/view/system/gd/jsp/gdTable.jsp'/>");
        });
        
        $("#gdTable2").click(function () {
        	gdType = 2;
        	pdType = 0;
            iframe1.attr("src", "<s:url value='/view/system/gd/jsp/gdTable.jsp'/>");
        });
        
        $("#gdTable3").click(function () {
        	gdType = 3;
        	pdType = 0;
            iframe1.attr("src", "<s:url value='/view/system/gd/jsp/gdTable.jsp'/>");
        });
        
        $("#gdTable4").click(function () {
        	gdType = 4;
        	pdType = 0;
            iframe1.attr("src", "<s:url value='/view/system/gd/jsp/gdTable.jsp'/>");
        });
        
        $("#gdTable5").click(function () {
        	gdType = 5;
        	pdType = 0;
            iframe1.attr("src", "<s:url value='/view/system/gd/jsp/gdTable.jsp'/>");
        });
        
        $("#gdTable6").click(function () {
        	gdType = 6;
        	pdType = 0;
            iframe1.attr("src", "<s:url value='/view/system/gd/jsp/gdTable.jsp'/>");
        });
        
        $("#khwhsqym").click(function () {
        	gdType = 1;
        	pdType = 1;
            iframe1.attr("src", "<s:url value='/view/system/gd/jsp/gdTable.jsp'/>");
        });
        
        $("#zdpd").click(function () {
        	gdType = 5;
        	pdType = 2;
            iframe1.attr("src", "<s:url value='/view/system/gd/jsp/gdTable.jsp'/>");
        });
        
        //标示不同的投诉状态
		var tsjyType = 0;
		getTsjyType = function () {
			return tsjyType;
		};
		
        $("#tsjy").click(function () {
        	tsjyType = 1;
        	pdType = 1;
            iframe1.attr("src", "<s:url value='/view/system/tsjy/jsp/tsjyTable.jsp'/>");
        });
        
        $("#cktsjy").click(function () {
        	tsjyType = 2;
        	pdType = 2;
            iframe1.attr("src", "<s:url value='/view/system/tsjy/jsp/tsjyTable.jsp'/>");
        });
        
        //标示不同的人员状态
		var userType = 0;
		getUserType = function () {
			return userType;
		};
		
        $("#khgl").click(function () {
        	userType = 1;
            iframe1.attr("src", "<s:url value='/view/system/user/jsp/userTable.jsp'/>");
        });
        
        $("#rygl").click(function () {
        	userType = 2;
            iframe1.attr("src", "<s:url value='/view/system/user/jsp/userTable.jsp'/>");
        });
        
        $("#gzltj").click(function () {
            iframe1.attr("src", "<s:url value='/view/system/tj/jsp/tjTable.jsp'/>");
        });
        
        $("#gzltj2").click(function () {
            iframe1.attr("src", "<s:url value='/view/system/tj/jsp/tjTable2.jsp'/>");
        });
        
        $("#mm").click(function () {
        	$.ajax({
	            url: 'user_userViewData?dataId=' + userId,
	            async: false
        	});
            iframe1.attr("src", "<s:url value='/view/system/user/jsp/mmView.jsp'/>");
        });
    });
</script>