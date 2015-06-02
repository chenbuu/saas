$(function () {

	//陈涛开发
	//下拉框字典控件 for easyUI
	
	dic4Box = function (obj, attr, boxName) {
		$.ajax({
	        url: 'dic_dic4Box',
	        data: {"dic.obj": obj,
	            "dic.attr": attr
	        },
	        dataType: 'json',
	        async: false,
	        success: function (result) {
	            if (result.success) {
	            	boxName.combobox({
	                    valueField: 'id',
	                    textField: 'text',
	                    editable: false,
	                    data: result.box
	                });
	            }
	        }
	    });
		selectBox(boxName);
    };
    
    url4Box = function (urlName, postData, boxName) {
		$.ajax({
	        url: urlName,
	        data: postData,
	        dataType: 'json',
	        async: false,
	        success: function (result) {
	            if (result.success) {
	            	boxName.combobox({
	                    valueField: 'id',
	                    textField: 'text',
	                    editable: false,
	                    data: result.box
	                });
	            }
	        }
	    });
		selectBox(boxName);
    };
    
    local4Box = function (localData, boxName) {
        if (localData != null) {
        	boxName.combobox({
                valueField: 'id',
                textField: 'text',
                editable: false,
                data: localData
        	});
        };
		selectBox(boxName);
    };

    selectBox = function (boxName) {
    	if (boxName.val() != null) {
	        var thisdata = boxName.val();
	        var data = boxName.combobox('getData');
	        if (data.length > 0) {
	        	if (typeof(thisdata) == "number") {
	        		for (var i = 0; i < data.length; i++) {
		                if (thisdata == data[i].id) {
		                	boxName.combobox('select', data[i].id);
		                }
		            }
	        	} else if (typeof(thisdata) == "string") {
	        		for (var i = 0; i < data.length; i++) {
		                if (thisdata == data[i].text) {
		                	boxName.combobox('select', data[i].id);
		                }
		            }
	        	}
	        }
	    }
    };

});