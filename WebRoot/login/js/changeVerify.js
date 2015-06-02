$(function () {

	//点击图片更换验证码
    $("#Verify").click(function(){
        $(this).attr("src","security_getCodeImage?timestamp="+new Date().getTime());
    });
});