<%@page contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<script type="text/javascript">
    jQuery(function ($) {
    	//获取权限总数
    	var permNum = <%=session.getAttribute("permNum")%>;
    	//获取全部权限列表,并且拆分成Boolean的perm[i]
        var permList = [<s:iterator value = "#session.permIds" var = "p"><s:property value = "#p" />,</s:iterator>];
        var perm = new Array();
        for(var i = 1; i <= permNum; i++) {
        	if($.inArray(i, permList) > -1){
        		perm[i] = true;
        	};
        };
        //alert("权限列表/" + permList);
        // 获取用户Id
		var userId = <%=session.getAttribute("userId")%>;
		getUserId = function () {
			return userId;
		};
        // 获取用户角色类型
		var roleId = <%=session.getAttribute("roleId")%>;
		getRoleId = function () {
			return roleId;
		};
		// 获取用户saasId
		var saasId = <%=session.getAttribute("saasId")%>;
		getSaasId = function () {
			return saasId;
		};
    });
</script>