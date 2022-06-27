'use strict';



//節約金額の合計を自動で算出する
function plus() {
	let plusList = document.getElementsByName('savings');
	let total = 0;

	for (let i of plusList) {
		if (Boolean(Number(i.value))) {
			total += Number(i.value);
		}
	}

	//結果を戻す
	document.getElementById('total').textContent = total + '円です!';
}

//必須項目を入力してくださいとだけを出るようにする

function records_confirm() {
	document.getElementById('record_form').onsubmit = function() {
		//各データを取得
		const w1 = document.getElementById('record_form').morning.value;
		const w2 = document.getElementById('record_form').lunch.value;
		const w3 = document.getElementById('record_form').dinner.value;

		//確認
		console.log(w1);

		//朝昼夕すべて抜け漏れ
		if (w1 === '*選択してください' && w2 === '*選択してください' && w3 == '*選択してください') {
			document.getElementById('output').textContent = `*朝・昼・夕の食事記録を書いてください`;
			return false;
		}

		//複数
		//朝・昼抜け
		else if (w1 === '*選択してください' && w2 === '*選択してください') {
			document.getElementById('output').textContent = `*朝・昼の食事記録を書いてください`;
			return false;
		}
		//朝・夜抜け
		else if (w1 === '*選択してください' && w3 === '*選択してください') {
			document.getElementById('output').textContent = `*朝・夕の食事記録を書いてください`;
			return false;
		}
		//昼・夜抜け
		else if (w2 === '*選択してください' && w3 === '*選択してください') {
			document.getElementById('output').textContent = `*昼・夕の食事記録を書いてください`;
			return false;
		}

		//単数
		//朝抜け漏れ
		else if (w1 === '*選択してください') {
			document.getElementById('output').textContent = `*朝の食事記録を書いてください`;
			return false;
		}
		//昼抜け漏れ
		else if (w2 === '*選択してください') {
			document.getElementById('output').textContent = `*昼の食事記録を書いてください`;
			return false;
		}
		//夕抜け漏れ
		else if (w3 === '*選択してください') {
			document.getElementById('output').textContent = `*夕の食事記録を書いてください`;
			return false;
		}
		//すべて記入できたら…
		else {
			alert('登録されました'); //登録されたのか更新されたのかで別の結果を出したい(時間次第)
		}
	}
}


//朝食１品追加
function addMorningMenu() {
	addSelect('morning_recipe', 'morningRecipe');
}


//昼食１品追加
function addlunchMenu() {
	addSelect('lunch_recipe', 'lunchRecipe');
}

//夕食1品追加
function adddinnerMenu() {
	addSelect('dinner_recipe', 'dinnerRecipe');
}

function addSelect(td_name, select_name) {

	//レシピのプルダウンを追加する処理
	//①どこに足すか
	let td = document.getElementById(td_name);

	//②何を足すか
	let select = document.getElementById(select_name).cloneNode(true);

	//select変数のonchangeイベントにselectFunctionを紐づける。
	select.addEventListener('onchange', selectFunction, false);

	//brを入れて次に段になるようしている。
	td.appendChild(document.createElement('br'));

	//①で取得したelement要素に、②の要素を追加
	td.appendChild(select);
}


//朝食の増えたプルダウンを削除する
function removeMorningMenu() {
	//増えたプルダウンももとからあるプルダウンも全選択する
	const pullMorning = document.getElementsByName('morning_option');
	console.log(pullMorning);

	//プルダウンを増やしていない場合には削除させない処理
	if(pullMorning.length - 1 === 0){
		return false;
	} else {
		//プルダウンで増やしたものを特定する
		const morningLast = pullMorning[pullMorning.length - 1];
		console.log(morningLast);

		//削除brも
		morningLast.previousElementSibling.remove();
		morningLast.remove();

		plus();
	}
}

//昼食のプルダウンを1つ削除
function removelunchMenu() {
	//増えたプルダウンももとからあるプルダウンも全選択する
	const pullLunch = document.getElementsByName('lunch_option');
	//console.log(pullMorning);

	//プルダウンを増やしていない場合には削除させない処理
	if(pullLunch.length - 1 === 0){
		return false;
	} else {
		//プルダウンで増やしたものを特定する
		const lunchLast = pullLunch[pullLunch.length - 1];
		//console.log(morningLast);

		//削除brも
		lunchLast.previousElementSibling.remove();
		lunchLast.remove();

		plus();
	}

}

//夕食のidを取る
function removeDinnerMenu() {
	//増えたプルダウンももとからあるプルダウンも全選択する
	const pullDinner = document.getElementsByName('dinner_option');
	console.log(pullDinner);


	//プルダウンを増やしていない場合には削除させない処理
	if(pullDinner.length - 1 === 0){
		return false;
	} else {
		//プルダウンで増やしたものを特定する
		const dinnerLast = pullDinner[pullDinner.length - 1];
		console.log(dinnerLast);

		//削除brも
		dinnerLast.previousElementSibling.remove();
		dinnerLast.remove();

		plus();
	}
}

//レシピと金額連動させる 朝
function selectFunction(ele) {
	//eleにはイベントが発生したelementが入っている。

	let index = ele.selectedIndex;			//選択されたコードを取得
	let saving = ele.nextElementSibling; 	//隣接している次の兄弟要素を取得

	saving.selectedIndex = index;			//金額のプルダウン切替

	//計算処理を呼び出す。plus();

	plus();
}
