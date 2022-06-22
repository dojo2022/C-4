//☆49行目以降、費用cost分以降の処理合っているか要確認
//☆☆エラーメッセージ、必須項目適応させる/*☆エラー表示関係停止中*/
//☆エラーメッセージ、今後各項目で①～を入力してください！②半角数字で～と表示させる


/*☆エラー表示関係停止中*/
 //BC引用必須項目エラー関係

	/*記入に関するエラー関係の変数宣言*/
	// [登録]ボタンをクリックしたときの処理 */

	function onload(){

		var recipeformObj = document.getElementById('recipe');
		var costformObj = document.getElementById('cost');	//☆costの処理記述もonload function内に書く
		var timeformObj = document.getElementById('time');

		//☆☆jsp上でのエラーメッセージ表示の処理
		//(resultモデルと同一名のerrからerror_messageに変更中)

		//var errorMessageObj = document.getElementById('err');

		//レシピ名focusout時のエラー表示
		var recipeerrorMessageObj = document.getElementById('recipeerror_message');

		//費用focusout時の未入力エラー表示
		var costerrorMessageObj = document.getElementById('costerror_message');

		//費用の半角数字エラーチェックの表示
		var costNumterrorMessageObj = document.getElementById('costnum_error_message');

		//submit起動時のエラー表示(ボタン下のspanタグ)
		var errorMessageObj = document.getElementById('error_message');

		//どこまで動作できているか確認する用のプログラム
		//alert(formObj.user_id.value);
		//alert(formObj.ID.value);


		//☆☆6/22タスク
		//☆☆Jsデバッグの際、中身確認時は変数名カーソル！
		//まずはサンプル参考に入れてみる
		//もし全角も含まれて問題があれば全角チェックの処理
		//全角を半角に直す

		//bodyタグにonloadを付けて、javascriptが適切なタイミングで処理されるようにする
    	//1つのonload内のファンクションは複数記述可能
    	//Jsファイルに関して、変数宣言はファンクション内で行う(エラー表示もない)
    	//onloadが伴うファンクションの大きなカッコ内に、処理したい記述を書いていく！

		//必須項目のエラー表示
		//今後は半角数字表記判定も入れていく
		//html inputタグ内にonchange,…input要素に文字を入力後、フォーカスが外れたタイミングでイベントが発動
		//		/^[0-9]+$/	←半角数字のみ(空文字NG)の正規表現
		// 例：if(str.match(/^[0-9]+$/)){	(matchは変更？)


		/*必須項目：フォームが入力された時に処理される(onchange→focusoutに変更)*/
		//レシピに文字が入力されたか確認(空文字NG)

		recipeformObj.addEventListener('focusin', e => {
	      console.log('recipe:focusin');
	    });

		recipeformObj.addEventListener('focusout', e => {

		  console.log('recipe:focusout');

		  //レシピ欄を読み取る
		  document.getElementById('recipe');

		  //レシピ欄が空欄またはスペースの場合
		  //☆☆スペースの場合の処理は未実装 trimで対応検討

		  if (recipe.value == null || recipe.value =="") {
		  	recipeerrorMessageObj.textContent = '※レシピ名を入力してください！';
		  	return false;
		  	}
		  	//入力されていればエラー表示なし
		  	recipeerrorMessageObj.textContent = null;
	      }
	    );



		//☆☆6/22タスク
		//まずはサンプル参考に入れて試す
		//もし全角も含まれて問題があれば全角チェックの処理
		//全角を(処理で強制的に)半角に直す

	    //費用・時間の半角数字チェック
	    //イベントリスナー使用
	    //カーソルをクリック(focusin)した時の処理
	    costformObj.addEventListener('focusin', e => {
	      console.log('cost:focusin');
	    });

		//カーソル選択状態から別の部分をクリック(focusout)した時の処理
		costformObj.addEventListener('focusout', e => {
		  console.log('cost:focusout');

		  //変数宣言
		  let costNumterrorMessageObj = document.getElementById('costnum_error_message');

		  //費用欄を読み取る
		  let cost = document.getElementById('cost');

		  //費用欄が未入力だった場合 ☆☆追ってtrimでスペースあれば削除する機能を入れる
		  if (cost.value == null || cost.value =="") {

		  	//(前に半角数字エラーが出ていたら消した上で入力指示エラーを表示する)
		  	costNumterrorMessageObj.textContent = null;
		  	costerrorMessageObj.textContent = '※費用を入力してください！';
		  	return false;
		  }
	      //入力されていればエラー表示なし
		  costerrorMessageObj.textContent = null;


		  //費用cost欄を読み取る
		  var coststr = document.getElementById('cost').value;

		  //半角数字での入力があれば
		  if(coststr.match(/^[0-9]+$/)){
		  	//エラー表示なし
		  	costNumterrorMessageObj.textContent = null;
		  }

		  	//半角数字以外なら必須項目入力のエラーを消して半角エラー表示を出す
		  	//☆☆trimや例外対応の処理確認
		  	costerrorMessageObj.textContent = null;
		  	costNumterrorMessageObj.textContent = '※費用は半角数字で入力してください！';
	    });

    }//functon onloadのカッコ閉じ





	/*上記テストのため停止中
	//function recipecheck(){
		//変数宣言
		//不要？　var recipeformObj = document.getElementById('recipe');
		//if (recipe.value == null || inputValue == "") {
	        //エラーメッセージを表示させる
	        //errorMessageObj.textContent = '※レシピ名を入力してください！';
	        //return false;
	    //}
	        //errorMessageObj.textContent = null;
	//};
	*/


	//☆☆チェック中：費用costに半角数字が入力されたか確認(空文字NG) 関数宣言のパターン
	//function costcheck(){
	//}



	/*テスト(実行できず)*/
	//費用costに半角数字が入力されたか確認(空文字NG) 関数宣言のパターン
	//function costcheck(){
		//変数宣言
		//var costformObj = document.getElementById('cost');
		//半角数字のみの記入なら、メッセージなしで正常起動
		//if (str.match(/^[0-9]+$/)) {
		     //errorMessageObj.textContent = null;
	  	     //}
	  	     //半角で入力が無かった場合にエラーメッセージを表示させる
	         //errorMessageObj.textContent = '※費用は半角で入力してください！';
	         //return false;
	    //};


     /*要調整(必須３か所チェック手段)　一旦停止
	 //formObj.onsubmit = function() {
	   //必須項目のいずれか(レシピ名か費用か所要時間)が入力されていない場合
	   //if (!recipeformObj.recipe.value || !costformObj.cost.value || !timeformObj.time.value) {
	      //共通のエラーメッセージを表示させる
	      //errorMessageObj.textContent = '※必須項目を入力してください！';
	      //return false;
	      //}
	      //errorMessageObj.textContent = null;
	   //};
     */

	/* [リセット]ボタンをクリックしたときの処理(実装済) */
	formObj.onreset = function() {
	  errorMessageObj.textContent = null;
	};




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

