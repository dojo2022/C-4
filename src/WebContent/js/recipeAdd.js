


function init(){
	//モーダルウィンドウの編集

	// ボタン、モダル、モダルの閉じるボタン、オーバーレイを変数に格納
	//const btn = document.querySelector('.btn');
	const btn = document.getElementById('modal_regist');
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
	});



}

function onclick_regist(){
	//モーダルウィンドウの表示したい場所に画面の値をセットする。

	let recipe = document.getElementById("recipe").value;
	document.getElementById("modal_recipe").innerHTML = recipe;
	document.getElementById("hidden_recipe").value = recipe;
}






