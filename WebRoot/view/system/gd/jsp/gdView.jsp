<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
    <head>
        <title>工单表单</title>
    </head>
    <body style="width:100%;height:100%;">
		<script type="text/javascript" src="<s:url value="/view/system/gd/js/gdView.js"/>"></script>
        <div region="center"  border="false" fit="true" style="background-color:#FAFAFA;background-repeat:repeat;">
	        <div class="container">
				<div class="row">
						<!-- 以下是新增工单表单(客户用)1 -->
					<fieldset id="fieldset4new" style="margin:20px; display:none;">
<!-- 					    <legend style="font-size:200%;">客户维护申请页面</legend> -->
						<div class="col-md-7">
							<div class="table-responsive">
								<table class="table">
									<tr>
										<td><font class="myInput">联系人*</font></td>
										<td><input id="lxr1" class="myInput form-control" value="<s:property value="#session.user.lxr" />"/></td>
									</tr>
									<tr>
										<td><font class="myInput">联系方式*</font></td>
										<td><input id="lxfs1" class="myInput form-control" value="<s:property value="#session.user.lxfs" />"/></td>
									</tr>
									<tr>
										<td><font class="myInput">具体科室</font></td>
										<td><input id="jtks1" class="myInput form-control" value="<s:property value="#session.gd.jtks" />"/></td>
									</tr>
			                        <tr>
										<td><font class="myInput">工单类型*</font></td>
										<td><input id="gdlxBox1" class="myBox form-control" value="<s:property value="#session.gd.gdlx" />"/></td>
									</tr>
									<tr>
										<td><font class="myInput">要求开始时间*</font></td>
										<td><input id="yqkssj1" class="easyui-datetimebox" style="width:250px;height:35px;"  value="<s:property value="#session.gd.yqkssj" />"/></td>
									</tr>
									<tr>
										<td><font class="myInput">要求完成时间*</font></td>
										<td><input id="yqwcsj1" class="easyui-datetimebox" style="width:250px;height:35px;" value="<s:property value="#session.gd.yqwcsj" />"/></td>
									</tr>
									<tr>
										<td><font class="myInput">产品名称</font></td>
										<td><input id="cpmc1" class="myInput form-control" value="<s:property value="#session.gd.cpmc" />"/></td>
									</tr>
									<tr>
										<td><font class="myInput">版本号</font></td>
										<td><input id="bbh1" class="myInput form-control" value="<s:property value="#session.gd.bbh" />"/></td>
									</tr>
									<tr>
										<td><font class="myInput">详细内容说明:</font></td>
									</tr>
								</table>
								<table class="table">
									<tr>
										<td><textarea id="xxnrsm1" class="timeFont form-control" rows="5" cols="50" style="width:500px;"><s:property value="#session.gd.xxnrsm" /></textarea></td>
									</tr>
								</table>
								<table class="table">
									<tr>
										<td><font class="myInput">附件:</font></td>
										<td><input id="fj1" type="file" name="file" class="myInput" value=null /></td>
									</tr>
								</table>
							</div>
						</div>
					</fieldset>
						<!-- 以下是经理主动派单表单2 -->
					<fieldset id="fieldset4zdpd" style="margin:20px; display:none;">
					    <legend style="font-size:200%;">主动派单表单</legend>
						<div class="col-md-7">
							<div class="table-responsive">
								<table class="table">
									<tr>
										<td><font class="myInput">指派人员*</font></td>
										<td><input id="zpryBox2" class="myBox form-control" value="<s:property value="#session.gd.zpryId" />"/></td>
									</tr>
									<tr>
										<td><font class="myInput">客户名称*</font></td>
										<td><input id="khmcBox2" class="myBox form-control" value="<s:property value="#session.gd.khmc" />"/></td>
									</tr>
									<tr>
										<td><font class="myInput">联系人</font></td>
										<td><input id="lxr2" class="myInput form-control" value="<s:property value="#session.gd.lxr" />"/></td>
									</tr>
									<tr>
										<td><font class="myInput">联系方式</font></td>
										<td><input id="lxfs2" class="myInput form-control" value="<s:property value="#session.gd.lxfs" />"/></td>
									</tr>
									<tr>
										<td><font class="myInput">具体科室</font></td>
										<td><input id="jtks2" class="myInput form-control" value="<s:property value="#session.gd.jtks" />"/></td>
									</tr>
									<tr>
										<td><font class="myInput">是否紧急</font></td>
										<td><input id="jjBox2" class="myBox form-control" value="<s:property value="#session.gd.jj" />"/></td>
									</tr>
									<tr>
										<td><font class="myInput">产品名称</font></td>
										<td><input id="cpmc2" class="myInput form-control" value="<s:property value="#session.gd.cpmc" />"/></td>
									</tr>
									<tr>
										<td><font class="myInput">版本号</font></td>
										<td><input id="bbh2" class="myInput form-control" value="<s:property value="#session.gd.bbh" />"/></td>
									</tr>
									<tr>
										<td><font class="myInput">指定开始时间</font></td>
										<td><input id="zdkssj2" class="easyui-datetimebox" style="width:250px;height:35px;" value="<s:property value="#session.gd.zdkssj" />"/></td>
									</tr>
									<tr>
										<td><font class="myInput">指定完成时间</font></td>
										<td><input id="zdwcsj2" class="easyui-datetimebox" style="width:250px;height:35px;" value="<s:property value="#session.gd.zdwcsj" />"/></td>
									</tr>
									<tr>
										<td><font class="myInput">指定工时(小时)</font></td>
										<td><input id="zdgs2" class="easyui-numberbox" data-options="precision:1" style="width:250px;height:35px;" value="<s:property value="#session.gd.zdgs" />"/></td>
									</tr>
									<tr>
										<td><font class="myInput">指定其他时间(小时)</font></td>
										<td><input id="zdqtsj2" class="easyui-numberbox" data-options="precision:1" style="width:250px;height:35px;" value="<s:property value="#session.gd.zdqtsj" />"/></td>
									</tr>
									<tr>
										<td><font class="myInput">详细内容说明:</font></td>
									</tr>
								</table>
								<table class="table">
									<tr>
										<td><textarea id="xxnrsm2" class="timeFont form-control" rows="5" cols="50" style="width:500px;"><s:property value="#session.gd.xxnrsm" /></textarea></td>
									</tr>
								</table>
								<table class="table">
									<tr>
										<td><font class="myInput">附件:</font></td>
										<td><input id="fj2" type="file" name="file" class="myInput" value=null /></td>
									</tr>
								</table>
								<table class="table">
									<tr>
										<td><font class="myInput">补充说明:</font></td>
									</tr>
								</table>
								<table class="table">
									<tr>
										<td><textarea id="bcsm2" class="timeFont form-control" rows="5" cols="50" style="width:500px;"><s:property value="#session.gd.bcsm" /></textarea></td>
									</tr>
								</table>
							</div>
						</div>
					</fieldset>
						<!-- 以下是工单详情表单(通用)3 -->
					<fieldset id="fieldset4gd" style="margin:20px; display:none;">
					    <legend style="font-size:200%;">工单详情</legend>
						<div class="col-md-7">
							<div class="table-responsive">
								<table class="table">
									<tr>
										<td><font class="redInput">工单号：</font></td>
										<td><font id="gdh3" class="redInput" ><s:property value="#session.gd.gdh" /></font></td>
										<td colspan="2"></td>
									</tr>
									<tr>
										<td><font class="redInput">状态：</font></td>
										<td><font id="zt3" class="redInput" ><s:property value="#session.gd.zt_string" /></font></td>
										<td colspan="2"></td>
									</tr>
								</table>
								<table class="table">
			                        <tr>
										<td><font class="myInput">工单类型</font></td>
										<td><input id="gdlxBox3" class="myBox form-control readonly" value="<s:property value="#session.gd.gdlx" />"/></td>
									</tr>
									<tr>
										<td><font class="myInput">是否紧急</font></td>
										<td><input id="jjBox3" class="myBox form-control readonly" value="<s:property value="#session.gd.jj" />"/></td>
									</tr>
									<tr>
										<td><font class="myInput">客户名称</font></td>
										<td><a id="khxxxx" class="myA" ><s:property value="#session.gd.khmc" /></a></td>
									</tr>
									<tr>
										<td><font class="myInput">具体科室</font></td>
										<td><input id="jtks3" class="myInput form-control readonly" value="<s:property value="#session.gd.jtks" />"/></td>
									</tr>
									<tr>
										<td><font class="myInput">联系人</font></td>
										<td><input id="lxr3" class="myInput form-control readonly" value="<s:property value="#session.gd.lxr" />"/></td>
									</tr>
									<tr>
										<td><font class="myInput">联系方式</font></td>
										<td><input id="lxfs3" class="myInput form-control readonly" value="<s:property value="#session.gd.lxfs" />"/></td>
									</tr>
									<tr>
										<td><font class="myInput">产品名称</font></td>
										<td><input id="cpmc3" class="myInput form-control readonly" value="<s:property value="#session.gd.cpmc" />"/></td>
									</tr>
									<tr>
										<td><font class="myInput">版本号</font></td>
										<td><input id="bbh3" class="myInput form-control readonly" value="<s:property value="#session.gd.bbh" />"/></td>
									</tr>
									<tr>
										<td><font class="myInput">要求开始时间</font></td>
										<td><input id="yqkssj3" class="easyui-datetimebox readonly" style="width:250px;height:35px;"  value="<s:property value="#session.gd.yqkssj" />"/></td>
									</tr>
									<tr>
										<td><font class="myInput">要求完成时间</font></td>
										<td><input id="yqwcsj3" class="easyui-datetimebox readonly" style="width:250px;height:35px;" value="<s:property value="#session.gd.yqwcsj" />"/></td>
									</tr>
									<tr>
										<td><font class="myInput">详细内容说明:</font></td>
									</tr>
								</table>
								<table class="table">
									<tr>
										<td><textarea id="xxnrsm3" class="timeFont form-control readonly" rows="5" cols="50" style="width:500px;"><s:property value="#session.gd.xxnrsm" /></textarea></td>
									</tr>
								</table>
								<table class="table">
									<tr>
										<td><font class="myInput">附件:</font></td>
										<td><a class="myInput" href='download_filedownload.action?fileName=<s:property value="#session.gd.fjUrl" />'><s:property value="#session.gd.fjName" /></a></td>
									</tr>
								</table>
							</div>
						</div>
					</fieldset>
						<!-- 以下是实施详情表单(客户用)4 -->
					<fieldset id="fieldset4ssxq" style="margin:20px; display:none;">
					    <legend style="font-size:200%;">实施详情</legend>
						<div class="col-md-7">
							<div class="table-responsive">
								<table class="table">
									<tr>
										<td><font class="myInput">施工人员</font></td>
										<td><input id="zpry4" class="myInput form-control readonly" value="<s:property value="#session.gd.zpryLxr" />"/></td>
									</tr>
									<tr>
										<td><font class="myInput">联系方式</font></td>
										<td><input id="zpry4" class="myInput form-control readonly" value="<s:property value="#session.gd.zpryLxfs" />"/></td>
									</tr>
									<tr>
										<td><font class="myInput">预计开始时间</font></td>
										<td><input id="zdkssj4" class="easyui-datetimebox readonly" style="width:250px;height:35px;" value="<s:property value="#session.gd.zdkssj" />"/></td>
									</tr>
									<tr>
										<td><font class="myInput">预计完成时间</font></td>
										<td><input id="zdwcsj4" class="easyui-datetimebox readonly" style="width:250px;height:35px;" value="<s:property value="#session.gd.zdwcsj" />"/></td>
									</tr>
								</table>
							</div>
						</div>
					</fieldset>
							<!-- 以下是被动派单表单5 -->
					<fieldset id="fieldset4bdpd" style="margin:20px; display:none;">
					    <legend style="font-size:200%;">施工人员详情</legend>
						<div class="col-md-7">
							<div class="table-responsive">
								<table class="table">
									<tr>
										<td><font class="myInput">指派人员</font></td>
										<td><input id="zpryBox5" class="myBox form-control readonly" value="<s:property value="#session.gd.zpryId" />"/></td>
									</tr>
									<tr>
										<td><font class="myInput">指定开始时间</font></td>
										<td><input id="zdkssj5" class="easyui-datetimebox readonly" style="width:250px;height:35px;" value="<s:property value="#session.gd.zdkssj" />"/></td>
									</tr>
									<tr>
										<td><font class="myInput">指定完成时间</font></td>
										<td><input id="zdwcsj5" class="easyui-datetimebox readonly" style="width:250px;height:35px;" value="<s:property value="#session.gd.zdwcsj" />"/></td>
									</tr>
									<tr>
										<td><font class="myInput">指定工时(小时)</font></td>
										<td><input id="zdgs5" class="easyui-numberbox readonly" data-options="min:0,precision:1" style="width:250px;height:35px;" value="<s:property value="#session.gd.zdgs" />"/></td>
									</tr>
									<tr>
										<td><font class="myInput">指定其他时间(小时)</font></td>
										<td><input id="zdqtsj5" class="easyui-numberbox readonly" data-options="min:0,precision:1" style="width:250px;height:35px;" value="<s:property value="#session.gd.zdqtsj" />"/></td>
									</tr>
									<tr>
										<td><font class="myInput">补充说明:</font></td>
									</tr>
								</table>
								<table class="table">
									<tr>
										<td><textarea id="bcsm5" class="timeFont form-control readonly" rows="5" cols="50" style="width:500px;"><s:property value="#session.gd.bcsm" /></textarea></td>
									</tr>
								</table>
							</div>
						</div>
					</fieldset>
							<!-- 以下是施工人员表单6 -->
					<fieldset id="fieldset4sgry" style="margin:20px; display:none;">
					    <legend style="font-size:200%;">完工详情</legend>
						<div class="col-md-7">
							<div class="table-responsive">
								<table class="table">
									<tr>
										<td><font class="myInput">实际开始时间</font></td>
										<td><input id="sjkssj6" class="easyui-datetimebox readonly" style="width:250px;height:35px;" value="<s:property value="#session.gd.sjkssj" />"/></td>
									</tr>
									<tr>
										<td><font class="myInput">实际完成时间*</font></td>
										<td><input id="sjwcsj6" class="easyui-datetimebox readonly" style="width:250px;height:35px;" value="<s:property value="#session.gd.sjwcsj" />"/></td>
									</tr>
									<tr>
										<td><font class="myInput">实际工时(小时)</font></td>
										<td><input id="sjgs6" class="easyui-numberbox readonly" data-options="min:0,precision:1" style="width:250px;height:35px;" value="<s:property value="#session.gd.sjgs" />"/></td>
									</tr>
									<tr>
										<td><font class="myInput">其他耗时(小时)</font></td>
										<td><input id="qths6" class="easyui-numberbox readonly" data-options="min:0,precision:1" style="width:250px;height:35px;" value="<s:property value="#session.gd.qths" />"/></td>
									</tr>
									<tr>
										<td><font class="myInput">完成说明:</font></td>
									</tr>
								</table>
								<table class="table">
									<tr>
										<td><textarea id="wcsm6" class="timeFont form-control readonly" rows="5" cols="50" style="width:500px;"><s:property value="#session.gd.wcsm" /></textarea></td>
									</tr>
								</table>
							</div>
						</div>
					</fieldset>
						<!-- 以下是评价表单7 -->
					<fieldset id="fieldset4pj" style="margin:20px; display:none;">
					    <legend style="font-size:200%;">评价表单</legend>
						<div class="col-md-7">
							<div class="table-responsive">
								<table class="table">
									<tr>
										<td><font class="myInput">是否满意</font></td>
										<td><input id="pjBox" class="myBox form-control readonly" value="<s:property value="#session.gd.pj" />"/></td>
									</tr>
								</table>
								<table class="table">
									<tr>
										<td><font class="myInput">评价内容:</font></td>
									</tr>
								</table>
								<table class="table">
									<tr>
										<td><textarea id="pjnr" class="timeFont form-control readonly" rows="5" cols="50" style="width:500px;"><s:property value="#session.gd.pjnr" /></textarea></td>
									</tr>
								</table>
							</div>
						</div>
					</fieldset>
					<!-- 以下是回访计分表单8 -->
					<fieldset id="fieldset4jf" style="margin:20px; display:none;">
					    <legend style="font-size:200%;">回访计分表单</legend>
						<div class="col-md-7">
							<div class="table-responsive">
								<table class="table">
									<tr>
										<td><font class="myInput">是否计分</font></td>
										<td><input id="jfBox" class="myBox form-control readonly" value="<s:property value="#session.gd.jf" />"/></td>
									</tr>
								</table>
							</div>
						</div>
					</fieldset>
				</div>
			</div>
		</div>
		<!-- 以下是查看创建者信息 -->
		<div id="dd4User"></div>
		<!-- 创建者ID信息 -->
        <input type="hidden" id="khId" value="<s:property value="#session.gd.khId" />"/>
    </body>
</html>