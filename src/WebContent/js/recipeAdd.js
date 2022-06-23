//☆49行目以降、費用cost分以降の処理合っているか要確認
//☆☆エラーメッセージ、必須項目適応させる/*☆エラー表示関係停止中*/
//☆エラーメッセージ、今後各項目で①～を入力してください！②半角数字で～と表示させる



	/*記入に関するエラー関係の変数宣言*/
	// [登録]ボタンをクリックしたときの処理 */

	function onload(){

		var recipeformObj = document.getElementById('recipe');
		var costformObj = document.getElementById('cost');
		var timeformObj = document.getElementById('time');

		//☆☆jsp上でのエラーメッセージ表示の処理
		//(resultモデルと同一名のerrからerror_messageに変更中)

		//var errorMessageObj = document.getElementById('err');

		//レシピ名focusout時のエラー表示
		var recipeerrorMessageObj = document.getElementById('recipeerror_message');

		//費用costのfocusout時未入力エラー表示
		var costerrorMessageObj = document.getElementById('costerror_message');

		//費用costの半角数字エラーチェック表示
		var costNumerrorMessageObj = document.getElementById('costnum_error_message');

		//所要時間timeのfocusout時未入力エラー表示
		var timeerrorMessageObj = document.getElementById('timeerror_message');

		//所要時間timeの半角数字エラーチェック表示
		var timeNumerrorMessageObj = document.getElementById('timenum_error_message');

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


		/*必須項目：フォームが入力された時に処理される(focusout)*/
		//レシピ欄チェック(空文字NG)

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

	    //費用の未入力・半角数字チェック
	    //イベントリスナー使用
	    //カーソルをクリック(focusin)した時の処理
	    costformObj.addEventListener('focusin', e => {

	      //コンソール内表示(テスト)
	      console.log('cost:focusin');
	    });

		//カーソル選択状態から別の部分をクリック(focusout)した時の処理
		costformObj.addEventListener('focusout', e => {
		  console.log('cost:focusout');

		  //変数宣言
		  let costNumerrorMessageObj = document.getElementById('costnum_error_message');

		  //費用欄を読み取る
		  let cost = document.getElementById('cost');

		  //費用欄の未入力チェック ☆☆追ってtrimでスペースあれば削除する機能を入れる
		  if (cost.value == null || cost.value =="") {

		  	//(前に半角数字エラーが出ていたら消した上で入力指示エラーを表示する)
		  	costNumerrorMessageObj.textContent = null;
		  	costerrorMessageObj.textContent = '※費用を入力してください！';
		  	return false;
		  }
		  else{
	      	//入力されていればエラー表示なし
		  	costerrorMessageObj.textContent = null;
		  }


		  //費用cost欄を読み取る
		  var coststr = document.getElementById('cost').value;
		  //let cost = document.getElementById('cost');

		  //費用cost欄半角数字チェック
		  if(coststr.match(/^[0-9]+$/)){

		  	//半角数字での入力があればエラー表示なし
		  	costNumerrorMessageObj.textContent = null;
		  }
		  else{
		  	//半角数字以外なら必須項目入力のエラーを消して半角エラー表示を出す
		  	//☆☆trimや例外対応の処理確認
		  	costerrorMessageObj.textContent = null;
		  	costNumerrorMessageObj.textContent = '※費用は半角数字で入力してください！';
		  }

	    });//101行目イベントリスナーのカッコ閉じ


	    //所要時間の未入力・半角数字チェック
	    //カーソルをクリック(focusin)した時の処理
	    timeformObj.addEventListener('focusin', e => {

	      //コンソール内表示(テスト)
	      console.log('time:focusin');
	    });

		//カーソル選択状態から別の部分をクリック(focusout)した時の処理
		timeformObj.addEventListener('focusout', e => {
		  console.log('time:focusout');

		  //変数宣言
		  let timeNumerrorMessageObj = document.getElementById('timenum_error_message');

		  //費用欄を読み取る
		  let time = document.getElementById('time');

		  //費用欄の未入力チェック ☆☆追ってtrimでスペースあれば削除する機能を入れる
		  if (time.value == null || time.value =="") {

		  	//(前に半角数字エラーが出ていたら消した上で入力指示エラーを表示する)
		  	timeNumerrorMessageObj.textContent = null;
		  	timeerrorMessageObj.textContent = '※所要時間を入力してください！';
		  	return false;
		  }
		  else{
	      	//入力されていればエラー表示なし
		  	timeerrorMessageObj.textContent = null;
		  }


		  //所要時間time欄を読み取る
		  var timestr = document.getElementById('time').value;
		  //let time = document.getElementById('time');

		  //所要時間time欄半角数字チェック
		  if(timestr.match(/^[0-9]+$/)){

		  	//半角数字での入力があればエラー表示なし
		  	timeNumerrorMessageObj.textContent = null;
		  }
		  else{
		  	//半角数字以外なら必須項目入力のエラーを消して半角エラー表示を出す
		  	//☆☆trimや例外対応の処理確認
		  	timeerrorMessageObj.textContent = null;
		  	timeNumerrorMessageObj.textContent = '※所要時間は半角数字で入力してください！';
		  }

	    });//150行目イベントリスナーのカッコ閉じ

    }//functon onloadのカッコ閉じ


	/* [リセット]ボタンをクリックしたときの処理(実装済) */
	formObj.onreset = function() {
	  errorMessageObj.textContent = null;
	};


	/*登録ボタンクリック時のエラーチェック処理*/
	//処理上手くいかなければボディタグのonload内に入れることも検討する
	//function submit(){

		//必須項目3か所の要素を取得
		//const submit = document.getElementById('recipe','cost','time');

		//もし3か所のいずれかに記入漏れがあったら
		//if(!recipeformObj.recipe.value || !costformObj.cost.value || !timeformObj.time.value){

			//「入力に不備があります。チェックしてください。」と表示する
			//errorMessageObj.textContent = '※入力に不備があります。チェックしてください。';
			//return false;
		//}
		//else{
			//else：Jsでの判定範囲でエラーがなければエラー表示せずにモジュール画面へ移動
			//errorMessageObj.textContent = null;

		//}


	//}//function submitのカッコ閉じ


     /*要調整(必須３か所チェック手段)　一旦停止*/
	 //formObj.onsubmit = function() {
	   //必須項目のいずれか(レシピ名か費用か所要時間)が入力されていない場合
	   //if (!recipeformObj.recipe.value || !costformObj.cost.value || !timeformObj.time.value) {
	      //共通のエラーメッセージを表示させる
	      //errorMessageObj.textContent = '※必須項目を入力してください！';
	      //return false;
	      //}
	      //errorMessageObj.textContent = null;
	   //};




//モーダルウィンドウ処理制御ファンクション
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
		if(onclick_regist()){
			 // aタグのデフォルトの機能を停止する
			 e.preventDefault();
			 // モーダルとオーバーレイにactiveクラスを付与する
			 modal.classList.add('active');
			 overlay.classList.add('active');
		}
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

//モーダルウィンドウの処理前にエラーチェックを行う作業
//①onclickで内に書く　チェック項目が少ない時とか
//②check用のfunctionを別に書く　実際に動いているものと←こちらを利用！

//実装手順
//①checkfunctionが正常起動しているかアラートのみの実装で確認(モーダルの処理まで確認)→OK
//②　①確認後、リターンfalseを付けてモーダル処理へ飛ばないか確認
//→returnだと処理が実行されるため別案検討(Jsにはexitが無いのでtry catch?)
//try cacthを使った場合、例外が投げられるため、例外取得時の処理を追加する必要あり？
//③checkファンクションに本格的な実装を進める

//メソッドの処理を終了して呼び出し元のメソッドに戻るにはreturn文を使いますが、
//return文ではメソッドを抜けた後の処理はそのまま実行されてしまいます。

//check.onclick = function(){
	//try {
	//ファンクション内で必要な変数宣言
	//	const～
	//ifでエラーチェック処理(エラーがあればの条件式)
//	if()｛
	//エラーです
//	}//エラーがあった場合は実行されない部分にonclick_registの処理を入れる？
//	else{
//	}



function onclick_regist(){

	//入力データのチェックをするメソッドを呼び出す
	//
	alert("onclick_registfun start");

	if(check() == false){

		alert("onclick_registfun false");
		//checkファンクションがfalseを返したらここでもfalseを返す
		return false;

	}
	//エラーが無ければ登録するメソッドを呼び出す
	alert("onclick_registfun true");
	regist();
	return true;

}



//★★★編集中！(212辺りのエラーチェック処理を持ってくる)
//resistにいかないようにfalse記入も忘れずに！trueも使う
function check(){
	//テスト開始用のアラート
	alert("checkfun start");

	//必須項目部分の変数宣言
	var recipeformObj = document.getElementById('recipe');
	var costformObj = document.getElementById('cost');
	var timeformObj = document.getElementById('time');

	//エラーメッセージ用の変数宣言
	let errorMessageObj = document.getElementById('error_message');

	//エラーが無いかチェックする処理(未入力の部分があればエラーを返す)
	if(recipe.value == null || recipe.value =="" ||cost.value == null || cost.value =="" || time.value == null || time.value ==""){
		//エラーメッセージを表示
		alert("checkfun false");
		errorMessageObj.textContent = '※必須項目に未入力の部分があります。チェックしてください。';
		//falseを返す(initファンクション内イベントリスナー(259行目～)の処理へ移行させない)
		return false;

		//エラーなく処理されればtrueを返し、onclick_registファンクションへ移行する(現在310行目～記載)
	}else{
		alert("checkfun true");
		return true;
	}
}



function regist(){
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