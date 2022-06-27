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

	//レシピのランダムアラート
	let recipe = document.getElementsByClassName('Random');

	let i = Math.floor(Math.random()*recipe.length);

	console.log(i);

	if(recipe.length != 0){
		alert(recipe[i].textContent + 'を作ってみましょう');
	}

	//目標金額が未設定だった際の処理
	if(money === ""){
		alert('目標金額を設定してください。');
		window.location.href = '/EngelS/goalServlet';
	}

}
