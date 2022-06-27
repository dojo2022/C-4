//ここから、6/14を持ってく来たやつ
function init(){
	//モーダルウィンドウの編集

	// ボタン、モダル、モダルの閉じるボタン、オーバーレイを変数に格納
	//const btn = document.querySelector('.btn');
	//const btn = document.getElementById('modal_regist');

	//詳細リンクの要素をすべて取得。
	const btns = document.getElementsByName('modal_regist');

	const modal = document.querySelector('.modalform');
	const closeBtn = document.querySelector('.close');
	const overlay = document.querySelector('.overlay');

	//複数の詳細リンクに対して、clickイベントを紐づける処理。
	btns.forEach(function(btn){

		// ボタンをクリックしたら、モダルとオーバーレイに.activeを付ける
		btn.addEventListener('click', function(e){
		  // aタグのデフォルトの機能を停止する
		  e.preventDefault();
		  //setting the value for recipe, cost, time, url, remarks
		  onclick_regist(e);

		  // モーダルとオーバーレイにactiveクラスを付与する
		  modal.classList.add('active');
		  overlay.classList.add('active');
		});

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


function onclick_regist(e){
	//モーダルウィンドウの表示したい場所に画面の値をセットする。
document.getElementById("modal_recipe").innerHTML = e.target.getAttribute("data-recipe")
document.getElementById("modal_cost").innerHTML = e.target.getAttribute("data-cost")
document.getElementById("modal_time").innerHTML = e.target.getAttribute("data-time")
document.getElementById("modal_url").innerHTML = e.target.getAttribute("data-url")
document.getElementById("modal_remarks").innerHTML = e.target.getAttribute("data-remarks")

}
}
