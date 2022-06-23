
	// [詳細]ボタンをクリックしたときの処理

	function onload(){

		var recipeformObj = document.getElementById('recipe');
		var costformObj = document.getElementById('cost');
		var timeformObj = document.getElementById('time');
		var urlformObj = document.getElementById('url');
		var remarksformObj = document.getElementById('remarks');




/* ボタン、モダル、モダルの閉じるボタン、オーバーレイを変数に格納
まだ、コピペをもってきただけ。*/

const btn = document.querySelector('.btn');
const modal = document.querySelector('.modal');
const closeBtn = document.querySelector('.close');
const overlay = document.querySelector('.overlay');

// ボタンをクリックしたら、モダルとオーバーレイに.activeを付ける
btn.addEventListener('click', function(e){
  // aタグのデフォルトの機能を停止する
  e.preventDefault();

 // モーダルとオーバーレイにactiveクラスを付与する
  modal.classList.add('active');
  overlay.classList.add('active');
});

// モダルの閉じるボタンをクリックしたら、モダルとオーバーレイのactiveクラスを外す
closeBtn.addEventListener('click', function(){
  modal.classList.remove('active');
  overlay.classList.remove('active');
});

// オーバーレイをクリックしたら、モダルとオーバーレイのactiveクラスを外す
overlay.addEventListener('click', function() {
  modal.classList.remove('active');
  overlay.classList.remove('active');
})/**
 *
 */
 // ボタン、モダル、モダルの閉じるボタン、オーバーレイを変数に格納
const btn = document.querySelector('.btn');
const modal = document.querySelector('.modal');
const closeBtn = document.querySelector('.close');
const overlay = document.querySelector('.overlay');


function onclick_regist(){


	//レシピ名recipe
	let recipe = document.getElementById("recipe").value;
	document.getElementById("modal_recipe").innerHTML = recipe;
	document.getElementById("hidden_recipe").value = recipe;

	//費用cost
	let cost = document.getElementById("cost").value;
	document.getElementById("modal_cost").innerHTML = cost;
	document.getElementById("hidden_cost").value = cost;

	//所要時間time
	let time = document.getElementById("time").value;
	document.getElementById("modal_time").innerHTML = time;
	document.getElementById("hidden_time").value = time;

	//参考URLurl
	let url = document.getElementById("url").value;
	document.getElementById("modal_url").innerHTML = url;
	document.getElementById("hidden_url").value = url;

	//備考remarks
	let remarks = document.getElementById("remarks").value;
	document.getElementById("modal_remarks").innerHTML = remarks;
	document.getElementById("hidden_remarks").value = remarks;


}