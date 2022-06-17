//☆49行目以降、費用cost分以降の処理合っているか要確認
//☆☆エラーメッセージ、必須項目適応させる/*☆エラー表示関係停止中*/
//☆エラーメッセージ、今後各項目で①～を入力してください！②半角数字で～と表示させる


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
	//☆js文51行目、コスト以降合っているか要確認
	//innerHTML：HTML要素の取得、変更、削除、追加などが可能。

	//レシピ名recipeの分
	let recipe = document.getElementById("recipe").value;
	document.getElementById("modal_recipe").innerHTML = recipe;
	document.getElementById("hidden_recipe").value = recipe;

	//費用costの分
	let cost = document.getElementById("cost").value;
	document.getElementById("modal_cost").innerHTML = cost;
	document.getElementById("hidden_cost").value = cost;

	//所要時間timeの分
	let time = document.getElementById("time").value;
	document.getElementById("modal_time").innerHTML = time;
	document.getElementById("hidden_time").value = time;

	//参考URLurlの分
	let url = document.getElementById("url").value;
	document.getElementById("modal_url").innerHTML = url;
	document.getElementById("hidden_url").value = url;

	//備考remarksの分
	let remarks = document.getElementById("remarks").value;
	document.getElementById("modal_remarks").innerHTML = remarks;
	document.getElementById("hidden_remarks").value = remarks;

}

/*☆エラー表示関係停止中*/
 //BC引用必須項目エラー関係

	/* [登録]ボタンをクリックしたときの処理 */
	var recipeformObj = document.getElementById('recipe');
	var costformObj = document.getElementById('cost');
	var timeformObj = document.getElementById('time');
	var errorMessageObj = document.getElementById('err');


	//確認用プログラム
	//alert(formObj.user_id.value);
	//alert(formObj.ID.value);

/*
	//必須項目のエラー表示
	//今後は
	formObj.onsubmit = function() {
	  //必須項目のいずれか(レシピ名か費用か所要時間)が入力されていない場合
	  if (!recipeformObj.recipe.value || !costformObj.cost.value || !timeformObj.time.value) {
	    //共通のエラーメッセージを表示させる
	    errorMessageObj.textContent = '※必須項目を入力してください！';
	    return false;
	  }
	  errorMessageObj.textContent = null;
	};
*/

	/* [リセット]ボタンをクリックしたときの処理(実装済) */
	formObj.onreset = function() {
	  errorMessageObj.textContent = null;
	};

