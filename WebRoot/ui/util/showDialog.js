$(function () {

	//陈涛开发
	//对话框控件 for easyUI
	//需要依赖外界的postData(i){}方法,可以参考projectTable.js的方法
	//如果postData方法不存在或返回值为0,此时i将直接作为Ajax的post的参数
	//需要依赖外界的afterData(i,result){}方法(只限showDialogWithUpload方法)
	
	showDialog0 = function (localDialog, localTitle, localHref) {
		showDialogAll0(800, '80%', localDialog, localTitle, localHref);
	};
		
	showDialogAll0 = function (width, height, localDialog, localTitle, localHref) {
    	localDialog.dialog({
            title: localTitle,
            width: width,
            height: height,
            closed: false,
            cache: false,
            href: localHref,
            modal: true,
            buttons: [{
                    text: '关闭',
                    width: 80,
                    handler: function () {
                    	localDialog.window('close');
                    }
                }]
        });
    };
        
    showDialog1 = function (localDialog, localTitle, localHref, localText, postUrl, i) {
    	showDialogAll1(800, '80%', localDialog, localTitle, localHref, localText, postUrl, i);
    };
    
	showDialogAll1 = function (width, height, localDialog, localTitle, localHref, localText, postUrl, i) {
    	localDialog.dialog({
            title: localTitle,
            width: width,
            height: height,
            closed: false,
            cache: false,
            href: localHref,
            modal: true,
            buttons: [{
                    text: localText,
                    width: 120,
                    handler: function () {
                    	var myData = 0;
                    	if(typeof(postData) == 'function') {
                    		myData = postData(i);
                    	}
                    	if (myData != "stop") {
                    		$.ajax({
                                url: postUrl,
                                data: myData,
                                dataType: 'json',
                                success: function (result) {
                                	myresult = result;
                                    if (result.success) {
                                        $.messager.alert('系统提示', result.message, 'info', function () {
                                            refshDatagrid();
                                        });
                                    } else {
                                        $.messager.alert('系统提示', result.message, 'info');
                                    }
                                }
                            });
                            localDialog.window('close');
                		}
                    }
                }, {
                    text: '关闭',
                    width: 80,
                    handler: function () {
                    	localDialog.window('close');
                    }
                }]
        });
    };
    
    showDialog2 = function (localDialog, localTitle, localHref, localText, postUrl, i, localText2, postUrl2, i2) {
    	showDialogAll2(800, '80%', localDialog, localTitle, localHref, localText, postUrl, i, localText2, postUrl2, i2);
    };
    
    showDialogAll2 = function (width, height, localDialog, localTitle, localHref, localText, postUrl, i, localText2, postUrl2, i2) {
    	localDialog.dialog({
            title: localTitle,
            width: width,
            height: height,
            closed: false,
            cache: false,
            href: localHref,
            modal: true,
            buttons: [{
                    text: localText,
                    width: 120,
                    handler: function () {
                    	var myData = 0;
                    	if(typeof(postData) == 'function') {
                    		myData = postData(i);
                    	}
                    	if (myData != "stop") {
                    		$.ajax({
                                url: postUrl,
                                data: myData,
                                dataType: 'json',
                                success: function (result) {
                                    if (result.success) {
                                        $.messager.alert('系统提示', result.message, 'info', function () {
                                            refshDatagrid();
                                        });
                                    } else {
                                        $.messager.alert('系统提示', result.message, 'info');
                                    }
                                }
                            });
                            localDialog.window('close');
                		}
                    }
                }, {
                    text: localText2,
                    width: 120,
                    handler: function () {
                    	var myData2 = 0;
                    	if(typeof(postData) == 'function') {
                    		myData2 = postData(i);
                    	}
                    	if (myData2 != "stop") {
	                        $.ajax({
	                            url: postUrl2,
	                            data: myData2,
	                            dataType: 'json',
	                            success: function (result) {
	                            	myresult = result;
	                                if (result.success) {
	                                    $.messager.alert('系统提示', result.message, 'info', function () {
	                                        refshDatagrid();
	                                    });
	                                } else {
	                                    $.messager.alert('系统提示', result.message, 'info');
	                                }
	                            }
	                        });
	                        localDialog.window('close');
                    	}
                    }
                }, {
                    text: '关闭',
                    width: 80,
                    handler: function () {
                        localDialog.window('close');
                    }
                }]
        });
    };
    
    showDialog3 = function (localDialog, localTitle, localHref, localText, postUrl, i, localText2, postUrl2, i2, localText3, postUrl3, i3) {
    	showDialogAll3(800, '80%', localDialog, localTitle, localHref, localText, postUrl, i, localText2, postUrl2, i2, localText3, postUrl3, i3);
    };
    
    showDialogAll3 = function (width, height, localDialog, localTitle, localHref, localText, postUrl, i, localText2, postUrl2, i2, localText3, postUrl3, i3) {
    	localDialog.dialog({
            title: localTitle,
            width: width,
            height: height,
            closed: false,
            cache: false,
            href: localHref,
            modal: true,
            buttons: [{
                    text: localText,
                    width: 120,
                    handler: function () {
                    	var myData = 0;
                    	if(typeof(postData) == 'function') {
                    		myData = postData(i);
                    	}
                    	if (myData != "stop") {
                    		$.ajax({
                                url: postUrl,
                                data: myData,
                                dataType: 'json',
                                success: function (result) {
                                	myresult = result;
                                    if (result.success) {
                                        $.messager.alert('系统提示', result.message, 'info', function () {
                                            refshDatagrid();
                                        });
                                    } else {
                                        $.messager.alert('系统提示', result.message, 'info');
                                    }
                                }
                            });
                    	}
                        localDialog.window('close');
                    }
                }, {
                    text: localText2,
                    width: 120,
                    handler: function () {
                    	var myData2 = 0;
                    	if(typeof(postData) == 'function') {
                    		myData2 = postData(i);
                    	}
                    	if (myData2 != "stop") {
                    		$.ajax({
                                url: postUrl2,
                                data: myData2,
                                dataType: 'json',
                                success: function (result) {
                                	myresult = result;
                                    if (result.success) {
                                        $.messager.alert('系统提示', result.message, 'info', function () {
                                            refshDatagrid();
                                        });
                                    } else {
                                        $.messager.alert('系统提示', result.message, 'info');
                                    }
                                }
                            });
                            localDialog.window('close');
                    	}
                    }
                }, {
                    text: localText3,
                    width: 120,
                    handler: function () {
                    	var myData3 = 0;
                    	if(typeof(postData) == 'function') {
                    		myData3 = postData(i);
                    	}
                    	if (myData3 != "stop") {
                    		$.ajax({
                                url: postUrl3,
                                data: myData3,
                                dataType: 'json',
                                success: function (result) {
                                	myresult = result;
                                    if (result.success) {
                                        $.messager.alert('系统提示', result.message, 'info', function () {
                                            refshDatagrid();
                                        });
                                    } else {
                                        $.messager.alert('系统提示', result.message, 'info');
                                    }
                                }
                            });
                            localDialog.window('close');
                    	}
                    }
                }, {
                    text: '关闭',
                    width: 80,
                    handler: function () {
                        localDialog.window('close');
                    }
                }]
        });
    };

    showDialogWithUpload = function (width, height, localDialog, localTitle, localHref, localText, postUrl, i) {
    	localDialog.dialog({
            title: localTitle,
            width: width,
            height: height,
            closed: false,
            cache: false,
            href: localHref,
            modal: true,
            buttons: [{
                    text: localText,
                    width: 120,
                    handler: function () {
                    	var myData = 0;
                    	if(typeof(postData) == 'function') {
                    		myData = postData(i);
                    	}
                    	if (myData != "stop") {
                    		var myasync = true;
                        	if(typeof(afterData) == 'function') {
                        		myasync = false;
                        	}
                            $.ajax({
                                url: postUrl,
                                async: myasync,
                                data: myData,
                                dataType: 'json',
                                success: function (result) {
                                    if (result.success) {
                                    	if (myasync) {
                                    		$.messager.alert('系统提示', result.message, 'info', function () {
                                                refshDatagrid();
                                            });
                                    	} else {
                                    		refshDatagrid();
                                    		afterData(i, result);
                                    	};
                                    } else {
                                        $.messager.alert('系统提示', result.message, 'info');
                                    }
                                }
                            });
                            localDialog.window('close');
                		}
                    }
                }, {
                    text: '关闭',
                    width: 80,
                    handler: function () {
                    	localDialog.window('close');
                    }
                }]
        });
    };
    
});