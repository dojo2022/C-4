'use strict'

console.log('JSテスト');

window.onload=function(){
	//画面上にある値をjsで取得する。
	let sum=document.getElementById("sum").innerHTML;
	let money=document.getElementById("money").innerHTML;
	let sagaku=money-sum;
	document.getElementById('sagaku').innerHTML=(sagaku);
}

let goalForm = document.getElementById('goal_form');
let Error = document.getElementById('error');
console.log(goalForm);
console.log(Error);

goalForm.onsubmit = function(){
	if(goalForm.new_money.value ==="" ){
		Error.textContent='※必須項目を入力してください！';
		document.getElementById("error").style.color = "red";
		return false;
	}
}
