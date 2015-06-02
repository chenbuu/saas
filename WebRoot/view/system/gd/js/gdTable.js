$(function () {
	//不读缓存
	$.ajaxSetup({ cache: false });
    //快速搜索变量
    var nameValue;
    
    //本地变量化表格，优化显示速度
    var localTable = $('#gd_table1');
    var localDialog = $('#dd');
    var localHref = 'gd_gdViewPage';
    
    //是否显示
    var hasReadonly = $('#hasReadonly');
    var hasShowFieldset4new = $('#hasShowFieldset4new');
    var hasShowFieldset4gd = $('#hasShowFieldset4gd');
    var hasShowFieldset4ssxq = $('#hasShowFieldset4ssxq');
    var hasShowFieldset4bdpd = $('#hasShowFieldset4bdpd');
    var hasShowFieldset4zdpd = $('#hasShowFieldset4zdpd');
    var hasShowFieldset4sgry = $('#hasShowFieldset4sgry');
    var hasShowFieldset4pj = $('#hasShowFieldset4pj');
    var hasShowFieldset4jf = $('#hasShowFieldset4jf');
	//默认都不显示
	hasShowInitial = function () {
		hasReadonly.val(0);
		hasShowFieldset4new.val(0);
		hasShowFieldset4gd.val(0);
		hasShowFieldset4ssxq.val(0);
		hasShowFieldset4bdpd.val(0);
		hasShowFieldset4zdpd.val(0);
		hasShowFieldset4sgry.val(0);
		hasShowFieldset4pj.val(0);
		hasShowFieldset4jf.val(0);
	};
    //获取查询类型
    var gdTypeVal = parent.getGdType();
    var pdTypeVal = parent.getPdType();
    var userIdVal = parent.getUserId();
    var roleIdVal = parent.getRoleId();
    
    localTable.datagrid({
        url: 'gd_listGd',
        queryParams: {"searchType": gdTypeVal
        	},
        //fitColumns:true,
        idField: 'id',
        fit: true,
        loadMsg: '数据正在加载,请耐心的等待...',
        rownumbers: true,
        singleSelect: true,
        pagination: true,
        pageSize: 30,
        striped: true,
        onRefresh: function () {
            localTable.datagrid('unselectAll');
        },
        rowStyler: function(index,row){
        	return 'color:black;';
    	},
        columns: [[
                {
                    field: 'id',
                    title: 'ID',
                    align: 'center',
                    sortable: true,
                    hidden: true
                }, {
                    field: 'gdh',
                    title: '工单号',
                    align: 'center',
                    sortable: true,
                    width: 250,
                    formatter: function (val, data, index) {
                        return '<a href="#" style="color:red;" onclick="viewData(\'' + data.id + '\')">' + val + '</a>';
                    }
                }, {
                    field: 'zt_string',
                    title: '状态',
                    align: 'center',
                    sortable: true
                }, {
                    field: 'cjsj',
                    title: '创建时间',
                    align: 'center',
                    sortable: true
                }, {
                    field: 'gdlx_string',
                    title: '工单类型',
                    align: 'center',
                    sortable: true
                }, {
                    field: 'jj_string',
                    title: '紧急',
                    align: 'center',
                    sortable: true
                }, {
                    field: 'khmc',
                    title: '客户名称',
                    align: 'center',
                    sortable: true
                }, {
                    field: 'jtks',
                    title: '具体科室',
                    align: 'center',
                    sortable: true
                }, {
                    field: 'lxr',
                    title: '联系人',
                    align: 'center',
                    sortable: true
                }, {
                    field: 'lxfs',
                    title: '联系方式',
                    align: 'center',
                    sortable: true
                }, {
                    field: 'cpmc',
                    title: '产品名称',
                    align: 'center',
                    sortable: true
                }, {
                    field: 'bbh',
                    title: '版本号',
                    align: 'center',
                    sortable: true
                }, {
                    field: 'zpryLxr',
                    title: '施工人员',
                    align: 'center',
                    sortable: true
                }, {
                    field: 'action',
                    title: '操作',
                    align: 'center',
                    formatter: function (val, data, index) {
                        var v = '<a href="#" style="color:red;" onclick="viewData(\'' + data.id + '\', \'' + 0 + '\')">查看</a>';
                        if (gdTypeVal == 0) {
                        	if (roleIdVal == 3 || roleIdVal == 99) {
                        		var a = '<a href="#" style="color:red;" onclick="editData(\'' + data.id + '\', \'' + 7 + '\')">修改</a>';
                        		return v + "  " + a + "  ";
                        	} else {
                        		return v + "  ";
                        	}
                        } else if (gdTypeVal == 1 && data.zt == 1) {
                        	var a = '<a href="#" style="color:red;" onclick="editData(\'' + data.id + '\', \'' + 1 + '\')">撤销</a>';
                            return v + "  " + a + "  ";
                        } else if (gdTypeVal == 1 ) {
                        	return v + "  ";
                        } else if (gdTypeVal == 2 && data.zt == 4) {
                        	var a = '<a href="#" style="color:red;" onclick="editData(\'' + data.id + '\', \'' + 2 + '\')">评价</a>';
                            return v + "  " + a + "  ";
                        } else if (gdTypeVal == 2 && data.zt == 5) {
                        	var a = '<a href="#" style="color:red;" onclick="editData(\'' + data.id + '\', \'' + 2 + '\')">修改评价</a>';
                            return v + "  " + a + "  ";
                        } else if (gdTypeVal == 3 && data.zt == 2) {
                        	var a = '<a href="#" style="color:red;" onclick="editData(\'' + data.id + '\', \'' + 3 + '\')">开始</a>';
                            return v + "  " + a + "  ";
                        } else if (gdTypeVal == 3 && data.zt == 3) {
                        	var a = '<a href="#" style="color:red;" onclick="editData(\'' + data.id + '\', \'' + 4 + '\')">确认施工完成</a>';
                        	return v + "  " + a + "  ";
                        } else if (gdTypeVal == 4) {
                            return v + "  ";
                        } else if (gdTypeVal == 5) {
                        	var a = '<a href="#" style="color:red;" onclick="editData(\'' + data.id + '\', \'' + 5 + '\')">修改</a>';
                        	var b = '<a href="#" style="color:red;" onclick="editData(\'' + data.id + '\', \'' + 6 + '\')">派单</a>';
                            return v + "  " + a + "  " + b + "  ";
                        } else if (gdTypeVal == 6) {
                        	//var a = '<a href="#" style="color:red;" onclick="editData(\'' + data.id + '\', \'' + 9 + '\')">回访计分</a>';
                        	//var b = '<a href="#" style="color:red;" onclick="editData(\'' + data.id + '\', \'' + 8 + '\')">删除</a>';
                        	var a = '<a href="#" style="color:red;" onclick="jfData(\'' + data.id + '\', \'' + 1 + '\')">计分</a>';
                        	var b = '<a href="#" style="color:red;" onclick="jfData(\'' + data.id + '\', \'' + 2 + '\')">不计分</a>';
                            return v + "  " + a + "  " + b + "  ";
                        }
                        return v + "  ";
                    }
                }]],
                toolbar: [
          	            {
          	                text: '查询',
          	                iconCls: 'icon-search',
          	                handler: function () {
          	                    if (text.val() == val) {
          	                        nameValue = '';
          	                    } else {
          	                        nameValue = text.val();
          	                    }
          	                    localTable.datagrid('load', {"searchName": nameValue,
          	                    							"searchType": gdTypeVal
          	                    							});
          	                    localTable.datagrid('unselectAll');
          	                }
          	            }, {
          	                text: '客户维护申请',
          	                id: 'add',
          	                iconCls: 'icon-add',
          	                handler: function () {
          	                    addData(0, 1);
          	                }
          	            }, {
        	                text: '主动派单',
        	                id: 'add',
        	                iconCls: 'icon-add',
        	                handler: function () {
        	                    addData(0, 2);
        	                }
        	            }]
    });
    
    //只有新建页面的时候显示'新建'按钮
    if(gdTypeVal == 1) {
    	$('div.datagrid-toolbar a').eq(2).hide();
    } else if(gdTypeVal == 5) {
    	$('div.datagrid-toolbar a').eq(1).hide();
    } else if(gdTypeVal == 0) {
    	$('div.datagrid-toolbar a').eq(0).hide();
    	$('div.datagrid-toolbar a').eq(1).hide();
    	$('div.datagrid-toolbar a').eq(2).hide();
    } else {
    	$('div.datagrid-toolbar a').eq(1).hide();
    	$('div.datagrid-toolbar a').eq(2).hide();
    };
    
    if (gdTypeVal != 0) {
    	var val = "请输入工单号匹配关键字";
        var td = $("<td style='padding: 0 8px;'></td>");
        var text = $("<input type='text' value='请输入工单号匹配关键字' style='width:200px;' />");

        text.appendTo(td);
        td.prependTo(".datagrid-toolbar table tbody tr");

        text.focus(function () {
            with (text[0]) {
                if (value == val) {
                    value = "";
                }
            }
        });

        text.blur(function () {
            with (text[0]) {
                if (value == "") {
                    value = val;
                }
            }
        });

        text.bind('keypress', function (event) {
            if (event.keyCode == "13")
            {
                if (text.val() == val) {
                    nameValue = '';
                } else {
                    nameValue = text.val();
                }
                localTable.datagrid('load', {"searchName": nameValue,
                							"searchType": gdTypeVal
    										});
                localTable.datagrid('unselectAll');
            }
        });
    }
    
    //showDialog.js控件的依赖组件,名称必然为postData(i){}
    postData = function (k) {
    	var localPostData = "";
    	if (k == 1001){//客户维护申请
    		if ($("#lxr1").val() == 0) {
    			alert("联系人必填");
    			return "stop";
    		}
    		if ($("#lxfs1").val() == 0) {
    			alert("联系方式必填");
    			return "stop";
    		}
    		if ($("#gdlxBox1").combobox('getValue') == 0 ) {
    			alert("工单类型必填");
    			return "stop";
    		}
    		if ($("#yqkssj1").datetimebox('getValue') == 0 ) {
    			alert("要求开始时间必填");
    			return "stop";
    		}
    		if ($("#yqwcsj1").datetimebox('getValue') == 0 ) {
    			alert("要求完成时间必填");
    			return "stop";
    		}
    		localPostData = {"searchType": 1,
		    				"gd.qtlxr": $("#lxr1").val(),
		                    "gd.qtlxfs": $("#lxfs1").val(),
		                    "gd.jtks": $("#jtks1").val(),
    						"gd.gdlx": $("#gdlxBox1").combobox('getValue'),
		                    "gd.jj": 1,
		                    "gd.yqkssj": $("#yqkssj1").datetimebox('getValue'),
		                    "gd.yqwcsj": $("#yqwcsj1").datetimebox('getValue'),
		                    "gd.cpmc": $("#cpmc1").val(),
		                    "gd.bbh": $("#bbh1").val(),
		                    "gd.xxnrsm": $("#xxnrsm1").val()
		                	};
    	} else if (k == 1002){//主动派单
    		if ($("#zpryBox2").combobox('getValue') == 0 ) {
    			alert("指派人员必填");
    			return "stop";
    		}
    		if ($("#khmcBox2").combobox('getValue') == 0 ) {
    			alert("客户名称必填");
    			return "stop";
    		}
    		localPostData = {"searchType": 2,
    						"gd.zt": 2,
    						"kh.id":$("#khmcBox2").combobox('getValue'),
    						"gd.qtlxr": $("#lxr2").val(),
		                    "gd.qtlxfs": $("#lxfs2").val(),
    						"gd.jtks": $("#jtks2").val(),
    						"gd.jj": $("#jjBox2").combobox('getValue'),
		                    "gd.cpmc": $("#cpmc2").val(),
		                    "gd.bbh": $("#bbh2").val(),
		                    "gd.xxnrsm": $("#xxnrsm2").val(),
		                    "zpry.id":$("#zpryBox2").combobox('getValue'),
							"gd.zdkssj": $("#zdkssj2").datetimebox('getValue'),
							"gd.zdwcsj": $("#zdwcsj2").datetimebox('getValue'),
							"gd.zdgs": $("#zdgs2").val(),
							"gd.zdqtsj": $("#zdqtsj2").val(),
							"gd.bcsm": $("#bcsm2").val()
		                	};
    	} else if (k == 1){//撤销
    		localPostData = {"gd.state": 0};
    	} else if (k == 2){//评价
    		localPostData = {"gd.zt": 5,
    						"gd.pj":$("#pjBox").combobox('getValue'),
							"gd.pjnr": $("#pjnr").val()
		        			};
    	} else if (k == 3){//开始
    		localPostData = {"gd.zt": 3};
    	} else if (k == 4){//确认施工完成
    		if ($("#sjwcsj6").datetimebox('getValue') == 0 ) {
    			alert("实际完成时间必填");
    			return "stop";
    		}
    		localPostData = {"gd.zt": 4,
    						"gd.sjkssj":$("#sjkssj6").datetimebox('getValue'),
		    				"gd.sjwcsj":$("#sjwcsj6").datetimebox('getValue'),
		    				"gd.sjgs":$("#sjgs6").val(),
		    				"gd.qths":$("#qths6").val(),
		    				"gd.wcsm":$("#wcsm6").val()
		        			};
    	} else if (k == 5){//修改
    		localPostData = {"gd.gdlx": $("#gdlxBox3").combobox('getValue'),
    						"gd.jj": $("#jjBox3").combobox('getValue'),
    						"gd.jtks": $("#jtks3").val(),
    						"gd.qtlxr": $("#lxr3").val(),
		                    "gd.qtlxfs": $("#lxfs3").val(),
		                    "gd.cpmc": $("#cpmc3").val(),
		                    "gd.bbh": $("#bbh3").val(),
		                    "gd.yqkssj": $("#yqkssj3").datetimebox('getValue'),
		                    "gd.yqwcsj": $("#yqwcsj3").datetimebox('getValue'),
		                    "gd.xxnrsm": $("#xxnrsm3").val()
		        			};
    	} else if (k == 6){//被动派单
    		if ($("#zpryBox5").combobox('getValue') == 0 ) {
    			alert("指派人员必填");
    			return "stop";
    		}
    		localPostData = {"gd.zt": 2,
    						"zpry.id":$("#zpryBox5").combobox('getValue'),
							"gd.zdkssj": $("#zdkssj5").datetimebox('getValue'),
							"gd.zdwcsj": $("#zdwcsj5").datetimebox('getValue'),
							"gd.zdgs": $("#zdgs5").val(),
							"gd.zdqtsj": $("#zdqtsj5").val(),
							"gd.bcsm": $("#bcsm5").val(),
							
							"gd.gdlx": $("#gdlxBox3").combobox('getValue'),
    						"gd.jj": $("#jjBox3").combobox('getValue'),
    						"gd.jtks": $("#jtks3").val(),
    						"gd.qtlxr": $("#lxr3").val(),
		                    "gd.qtlxfs": $("#lxfs3").val(),
		                    "gd.cpmc": $("#cpmc3").val(),
		                    "gd.bbh": $("#bbh3").val(),
		                    "gd.yqkssj": $("#yqkssj3").datetimebox('getValue'),
		                    "gd.yqwcsj": $("#yqwcsj3").datetimebox('getValue'),
		                    "gd.xxnrsm": $("#xxnrsm3").val()
		        			};
    	} else if (k == 7){//修改
    		localPostData = {"gd.gdlx": $("#gdlxBox3").combobox('getValue'),
							"gd.jj": $("#jjBox3").combobox('getValue'),
							"gd.jtks": $("#jtks3").val(),
							"gd.qtlxr": $("#lxr3").val(),
		                    "gd.qtlxfs": $("#lxfs3").val(),
		                    "gd.cpmc": $("#cpmc3").val(),
		                    "gd.bbh": $("#bbh3").val(),
		                    "gd.yqkssj": $("#yqkssj3").datetimebox('getValue'),
		                    "gd.yqwcsj": $("#yqwcsj3").datetimebox('getValue'),
		                    "gd.xxnrsm": $("#xxnrsm3").val(),
		                    
		                    "zpry.id":$("#zpryBox5").combobox('getValue'),
							"gd.zdkssj": $("#zdkssj5").datetimebox('getValue'),
							"gd.zdwcsj": $("#zdwcsj5").datetimebox('getValue'),
							"gd.zdgs": $("#zdgs5").val(),
							"gd.zdqtsj": $("#zdqtsj5").val(),
							"gd.bcsm": $("#bcsm5").val(),
							
							"gd.sjkssj":$("#sjkssj6").datetimebox('getValue'),
		    				"gd.sjwcsj":$("#sjwcsj6").datetimebox('getValue'),
		    				"gd.sjgs":$("#sjgs6").val(),
		    				"gd.qths":$("#qths6").val(),
		    				"gd.wcsm":$("#wcsm6").val(),
		    											
							"gd.jf": $("#jfBox").combobox('getValue')
        			};
    	} else if (k == 8){//删除
    		localPostData = {"gd.state": 0};
    	} else if (k == 9){//回访计分
    		localPostData = {"gd.jf": $("#jfBox").combobox('getValue')};
    	} else {
    		return 0;
    	}
    	return localPostData;
    };
    
    //showDialog.js控件的依赖组件,名称必然为afterData(i){}
    afterData = function (k, gdresult) {
    	var myFj = null;
    	var myfileElementId = null;
    	if (k == 1001){//客户维护申请
    		myFj = $("#fj1");
    		myfileElementId = "fj1";
    	} else if (k == 1002){//主动派单
    		myFj = $("#fj2");
    		myfileElementId = "fj2";
    	}
    	if (myFj.val()) {
			$.ajaxFileUpload({
    	        url : 'upload_upload',
    	        secureuri : false,//安全协议
    	        fileElementId: myfileElementId,//id
    	        type : 'POST',
    	        dataType : 'json',
    	        async : false,
    	        success : function(upresult, state) {
    	            if (upresult.success) {
    	            	$.ajax({
                            url: 'gd_updateGd?dataId=' + gdresult.id,
                            async : false,
                            data: {"gd.id": gdresult.id,
                            		"fj.id": upresult.id
                            		},
                            dataType: 'json',
                            success: function (result2) {
                                if (result2.success) {
                            		$.messager.alert('系统提示', result2.message, 'info');
                                } else {
                                    $.messager.alert('系统提示', '新增工单成功,上传附件成功,关联附件失败', 'info');
                                }
                            }
                        });
    	            } else {
    	            	$.messager.alert('系统提示', '新增工单成功,上传附件失败', 'info');
    	            }
    	        }
    	    });
		} else {
			$.messager.alert('系统提示', gdresult.message, 'info');
		}
    };
    
    addData = function (dataId, i) {
    	hasShowInitial();
    	$.ajax({
            url: 'gd_gdClean',
            async: false
        });
    	if (i == 1) {
    		$.ajax({
                url: 'user_userViewData?dataId=' + userIdVal,
                async: false
            });
    		hasShowFieldset4new.val(1);
    		showDialogWithUpload('100%', '100%', localDialog, '客户维护申请页面', localHref, '保存提交', 'gd_saveGd', 1001);
    	} else if (i == 2) {
    		hasShowFieldset4zdpd.val(1);
    		showDialogWithUpload('100%', '100%', localDialog, '主动派单页面', localHref, '保存提交', 'gd_saveGd', 1002);
    	}
    };
    
    viewData = function (dataId, i) {
    	hasShowInitial();
    	hasReadonly.val(1);
    	hasShowFieldset4gd.val(1);
    	if (gdTypeVal == 1 ) {
    		hasShowFieldset4ssxq.val(1);
    	} else if (gdTypeVal == 2 ) {
    		hasShowFieldset4ssxq.val(1);
    		hasShowFieldset4pj.val(1);
    	} else if (gdTypeVal == 3 ) {
    		hasShowFieldset4bdpd.val(1);
    	} else if (gdTypeVal == 4 ) {
    		hasShowFieldset4bdpd.val(1);
    		hasShowFieldset4sgry.val(1);
    	} else if (gdTypeVal == 5 ) {
    		hasShowFieldset4bdpd.val(1);
    	} else if (gdTypeVal == 6 ) {
    		hasShowFieldset4bdpd.val(1);
    		hasShowFieldset4sgry.val(1);
    		hasShowFieldset4pj.val(1);
    		hasShowFieldset4jf.val(1);
    	} else if (gdTypeVal == 0 ) {
    		hasShowFieldset4bdpd.val(1);
    		hasShowFieldset4sgry.val(1);
    		hasShowFieldset4pj.val(1);
    		hasShowFieldset4jf.val(1);
    	}
        $.ajax({
            url: 'gd_gdViewData?dataId=' + dataId,
            async: false
        });
        showDialogAll0('100%', '100%', localDialog, '查看', localHref);
    };

    editData = function (dataId, i) {
    	hasShowInitial();
    	$.ajax({
            url: 'gd_gdViewData?dataId=' + dataId,
            async: false
        });
    	var postUrl = 'gd_updateGd?dataId=' + dataId;
    	if (i == 1 ) {
    		hasShowFieldset4gd.val(1);
    		hasShowFieldset4ssxq.val(1);
    		hasReadonly.val(1);
    		showDialogAll1('100%', '100%', localDialog, '撤销', localHref, '确定撤销', postUrl, 1);
    	} else if (i == 2 ) {
    		hasShowFieldset4pj.val(1);
    		showDialogAll1('100%', '100%', localDialog, '评价', localHref, '确定评价', postUrl, 2);
    	} else if (i == 3 ) {
    		hasShowFieldset4gd.val(1);
    		hasShowFieldset4bdpd.val(1);
    		hasReadonly.val(1);
    		showDialogAll1('100%', '100%', localDialog, '开始', localHref, '确定开始', postUrl, 3);
    	} else if (i == 4 ) {
    		hasShowFieldset4sgry.val(1);
    		showDialogAll1('100%', '100%', localDialog, '确认施工完成', localHref, '确认施工完成', postUrl, 4);
    	} else if (i == 5 ) {
    		hasShowFieldset4gd.val(1);
    		showDialogAll1('100%', '100%', localDialog, '修改', localHref, '修改', postUrl, 5);
    	} else if (i == 6 ) {
    		hasShowFieldset4gd.val(1);
    		hasShowFieldset4bdpd.val(1);
    		showDialogAll1('100%', '100%', localDialog, '被动派单', localHref, '确定派单', postUrl, 6);
    	} else if (i == 7 ) {
    		hasShowFieldset4gd.val(1);
    		hasShowFieldset4bdpd.val(1);
    		hasShowFieldset4sgry.val(1);
    		hasShowFieldset4jf.val(1);
    		showDialogAll1('100%', '100%', localDialog, '修改', localHref, '修改', postUrl, 7);
    	} else if (i == 8 ) {
    		$.messager.confirm('确认对话框', '您确认删除吗？', function(r){
          		if (r){
              		  $.ajax({
                          url: postUrl,
                          data: {"gd.state": 0},
                          dataType: 'json',
                          success: function (result) {
                              if (result.success) {
                                  refshDatagrid();
                              } else {
                                  $.messager.alert('系统提示', result.message, 'info');
                              }
                          }
                      });
          		}
          	});
    	} else if (i == 9 ) {
    		hasShowFieldset4jf.val(1);
    		showDialogAll1('100%', '100%', localDialog, '评价计分', localHref, '保存', postUrl, 9);
    	}
    };
    
    jfData = function (dataId, i) {
    	var postUrl = 'gd_updateGd?dataId=' + dataId;
    	if (i == 1) {
    		$.messager.confirm('确认对话框', '计分吗？', function(r){
          		if (r){
              		  $.ajax({
                          url: postUrl,
                          data: {"gd.jf": 1},
                          dataType: 'json',
                          success: function (result) {
                              if (result.success) {
                                  refshDatagrid();
                              } else {
                                  $.messager.alert('系统提示', result.message, 'info');
                              }
                          }
                      });
          		}
          	});
    	} else if (i == 2) {
    		$.messager.confirm('确认对话框', '不计分吗？', function(r){
          		if (r){
              		  $.ajax({
                          url: postUrl,
                          data: {"gd.jf": 2},
                          dataType: 'json',
                          success: function (result) {
                              if (result.success) {
                                  refshDatagrid();
                              } else {
                                  $.messager.alert('系统提示', result.message, 'info');
                              }
                          }
                      });
          		}
          	});
    	}
    };
    
    refshDatagrid = function () {
        localTable.datagrid('load');
        localTable.datagrid('unselectAll');
    };
    
    //自动页面跳转
    if (pdTypeVal == 1) {
    	addData(0, 1);
    } else if (pdTypeVal == 2) {
    	addData(0, 2);
    }
    
    //高级查询
    //样式修改必须放在最前列
    if (gdTypeVal == 0 ) {
    	$("#panel1").show();
    	$(".searchInput").attr("style","font-family: Microsoft YaHei;color:red;font-size:100%;width:200px;height:25px;");
    	var localData_search_jj = [{
    		id: 1,
    		text: "普通"
    	},{
    		id: 2,
    		text: "紧急"
    	}];
    	local4Box(localData_search_jj, $("#search_jj"));
    	$("#search_jj").combobox('select',null);
    	dic4Box("Gd", "zt", $("#search_zt"));
    	dic4Box("Gd", "gdlx", $("#search_gdlx"));
    	//重新布局layout
    	$("#panel0").layout('resize');
    }
	    
    var searchDataState = true;
    $("#searchRest").click(function(){
    	//先暂停动态查询 否则一直触发查询
    	searchDataState = false;
        $("#search_gdh").val(null);
        $("#search_zt").combobox('select',null);
        $("#search_gdlx").combobox('select',null);
        $("#search_jj").combobox('select',null);
        $("#search_khmc").val(null);
        $("#search_lxr").val(null);
        $("#search_lxfs").val(null);
        $("#search_cjsj1").datetimebox('setValue', null);
        $("#search_cjsj2").datetimebox('setValue', null);
        $("#search_zpry").val(null);
        searchDataState = true;
        searchData();
    });
    
    $("#searchDo").click(function(){
    	searchData();
    });
    
    //动态查询
	$("#search_gdh, #search_khmc, #search_lxr, #search_lxfs, #search_zpry").change(function(){ 
    	searchData();
    });
    
    $("#search_zt, #search_gdlx, #search_jj").combobox({
        onChange:function(){
        	searchData();
        }
    });
    
    $("#search_cjsj1, #search_cjsj2").datetimebox({
        onChange:function(){
        	searchData();
        }
    });
    
    searchData = function () {
    	if (searchDataState) {
    		var localPostData2 = {"searchName": $("#search_gdh").val(),
					"searchType": gdTypeVal,
					"gd.zt": $("#search_zt").combobox('getValue'),
					"gd.gdlx": $("#search_gdlx").combobox('getValue'),
					"gd.jj": $("#search_jj").combobox('getValue'),
					"kh.khmc": $("#search_khmc").val(),
					"gd.qtlxr": $("#search_lxr").val(),
					"gd.qtlxfs": $("#search_lxfs").val(),
					"gd.cjsj": $("#search_cjsj1").datetimebox('getValue'),
					"gd2.cjsj": $("#search_cjsj2").datetimebox('getValue'),
					"zpry.lxr": $("#search_zpry").val()
	    	};
			localTable.datagrid('load', localPostData2);
			localTable.datagrid('unselectAll');
    	}
    };

});