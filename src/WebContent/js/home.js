'use strict'

console.log('JSテスト');

window.onload=function(){
	//画面上にある値をjsで取得する。
	let sum=document.getElementById("sum").innerHTML;
	console.log(sum);
	let money=document.getElementById("money").innerHTML;
	console.log(money);
	let sagaku=money-sum;
	console.log(sagaku);
	document.getElementById('sagaku').innerHTML=(sagaku);
}
