$(function () {

	//样式修改必须放在最前列
	$(".redInput").attr("style","font-family: Microsoft YaHei;color:red;font-size:130%;width:250px;");
	
	$(".myInput").attr("style","font-family: Microsoft YaHei;font-size:130%;width:250px;");
	
	$(".myA").attr("style","font-family: Microsoft YaHei;font-size:130%;width:250px;cursor:pointer;");
		
	$(".myBox").attr("style","width:250px;height:35px;");
		
	$(".timeInput").attr("style","font-family: Microsoft YaHei;font-size:130%;width:150px;");
	
	$(".timeFont").attr("style","font-family: Microsoft YaHei;font-size:130%;");
	
	$(".datagrid-body").attr("style","background-color:#F4F4F4;background-repeat:repeat;");
	
	$(".myTitle").attr("style","font-family: Microsoft YaHei;font-size:150%;");
	
	var localData1 = [{
		id: 1,
		text: "普通"
	},{
		id: 2,
		text: "紧急"
	}];
			
	//是否显示
	if($('#hasShowFieldset4new').val() == 1) {
		dic4Box("Gd", "gdlx", $("#gdlxBox1"));
    	$('#fieldset4new').show();
    } else {
    	$('#fieldset4new').hide();
    };
    
    if($('#hasShowFieldset4zdpd').val() == 1) {
    	var khmcBox2 = $("#khmcBox2");
    	var lxr2 = $("#lxr2");
    	var lxfs2 = $("#lxfs2");
    	url4Box("user_zpry4Box", null, $("#zpryBox2"));
    	url4Box("user_khmc4Box", null, khmcBox2);
    	local4Box(localData1, $("#jjBox2"));
		$("#jjBox2").combobox('select', 1);
    	khmcBox2.combobox({
   	        onChange:function(){
   	        	localKhmcId = khmcBox2.combobox('getValue');
   	        	lxr2.val(null);
	            lxfs2.val(null);
	            $.ajax({
	    	             url: 'user_findUser4Zdpd?dataId=' + localKhmcId,
	    	             dataType: 'json',
	    	             async: false ,
	    	             success: function (result) {
	    	            	lxr2.val(result.user_lxr);
	    	            	lxfs2.val(result.user_lxfs);
    	 	        	}
    	        	});
   	        }
   		});
    	$('#fieldset4zdpd').show();
    } else {
    	$('#fieldset4zdpd').hide();
    };
    
    viewData2 = function (dataId, i) {
        $.ajax({
            url: 'user_userViewData2?dataId=' + dataId,
            async: false
        });
        var localDialog2 = $('#dd4User');
        localDialog2.dialog({
            title: '查看创建人信息',
            width: 800,
            height: '80%',
            closed: false,
            cache: false,
            href: 'user_userViewPage2',
            modal: true,
            buttons: [{
                    text: '关闭',
                    width: 80,
                    handler: function () {
                    	localDialog2.window('close');
                    }
                }]
        });
    };
    
	if($('#hasShowFieldset4gd').val() == 1) {
		dic4Box("Gd", "gdlx", $("#gdlxBox3"));
		local4Box(localData1, $("#jjBox3"));
		//点击工单查看创建用户信息
		var khIdVal = $('#khId').val();
		var khxxxx = $('#khxxxx');
		khxxxx.click(function() {
			viewData2(khIdVal, 0);
		});
    	$('#fieldset4gd').show();
    } else {
    	$('#fieldset4gd').hide();
    };

    if($('#hasShowFieldset4ssxq').val() == 1) {
    	$('#fieldset4ssxq').show();
    } else {
    	$('#fieldset4ssxq').hide();
    };
    
    if($('#hasShowFieldset4bdpd').val() == 1) {
    	url4Box("user_zpry4Box", null, $("#zpryBox5"));
    	$('#fieldset4bdpd').show();
    } else {
    	$('#fieldset4bdpd').hide();
    };
    
    if($('#hasShowFieldset4sgry').val() == 1) {
    	$('#fieldset4sgry').show();
    } else {
    	$('#fieldset4sgry').hide();
    };
    
    if($('#hasShowFieldset4pj').val() == 1) {
    	dic4Box("Gd", "pj", $("#pjBox"));
    	if ($("#pjBox").combobox('getText').length == 0 ) {
        	$("#pjBox").combobox('select', 1);
    	}
    	$('#fieldset4pj').show();
    } else {
    	$('#fieldset4pj').hide();
    };
    
    if($('#hasShowFieldset4jf').val() == 1) {
    	var localData_jf = [{
    		id: 1,
    		text: "计分"
    	},{
    		id: 2,
    		text: "不计分"
    	}];
    	local4Box(localData_jf, $("#jfBox"));
    	$('#fieldset4jf').show();
    } else {
    	$('#fieldset4jf').hide();
    };
    
    //是否只读 放在最后判断
	if($('#hasReadonly').val() == 1) {
		$(".readonly").attr("readonly","readonly");
		$(".myBox.readonly").combobox({
			disabled:true
		});
		$(".easyui-datetimebox.readonly").datetimebox({
			disabled:true
		});
		$(".easyui-numberbox.readonly").datetimebox({
			disabled:true
		});
    }
    
});