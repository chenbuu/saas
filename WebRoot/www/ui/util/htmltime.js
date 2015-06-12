/**
 * 在html页面上输出当前时间
 */
today = new Date();
function initArray() {
	this.length = initArray.arguments.length;
	for (var i = 0; i < this.length; i++)
		this[i + 1] = initArray.arguments[i];
}
var d = new initArray("星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六");
document.write("<font color=#333 style='font-size:9pt;font-family: 宋体'> ",
		today.getFullYear(), "年", today.getMonth() + 1, "月", today.getDate(),
		"日", d[today.getDay() + 1], "</font>");
