'use strict';

function plus() {
	let number1 = document.getElementById('number1');
	let number2 = document.getElementById('number2');
	let number3 = document.getElementById('number3');

	console.log(number1);
	console.log(number2);
	console.log(number3);
	//結果を戻す
	document.getElementById('total').textContent = number1 + number2 + number3;
}

//必須項目を入力してくださいとだけを出るようにする。 required=""で実装してみる

function records() {
	document.getElementById('record_form').onsubmit = function() {
		//各データを取得
		const w1 = document.getElementById('record_form').morning_recipeid.name;
		const w2 = document.getElementById('record_form').lunch_recipeid.name;
		const w3 = document.getElementById('record_form').dinner_recipeid.name;

		//朝昼夕すべて抜け漏れ
		if (w1 === '' && w2 === '' && w3 == '') {
			document.getElementById('output').textcontent = `*朝・昼・夕の食事記録を書いてください`;
			return false;
		}
		//朝抜け漏れ
		else if (w1 === '') {
			document.getElementById('output').textcontent = `*朝の食事記録を書いてください`;
			return false;
		}
		//昼抜け漏れ
		if (w2 === '') {
			document.getElementById('output').textcontent = `*昼の食事記録を書いてください`;
			return false;
		}
		//夕抜け漏れ
		if (w3 === '') {
			document.getElementById('output').textcontent = `*夕の食事記録を書いてください`;
			return false;
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

function addSelect(td_name, select_name){

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

//レシピと金額連動させる 朝
function selectFunction(ele){
	//eleにはイベントが発生したelementが入っている。

	let index = ele.selectedIndex;			//選択されたコードを取得
	let saving = ele.nextElementSibling; 	//隣接している次の兄弟要素を取得

	saving.selectedIndex = index;
	//
	//const select = document.getElementById('morning');
	//const savings = document.getElementById('morning_savings');
	//let index = select.selectedIndex;
	//console.log(index);

	//選ぶ
	//savings.selectedIndex = index;
}

//レシピと金額連動させる 昼
//function selectFunctions(){
//	//
//	const select = document.getElementById('lunch');
//	const savings = document.getElementById('lunch_savings');
//	let index = select.selectedIndex;
//	//console.log(index);
//
//	//選ぶ
//	savings.selectedIndex = index;
//}

//レシピと金額連動させる 夕
//function selectFunctionss(){
//	//
//	const select = document.getElementById('dinner');
//	const savings = document.getElementById('dinner_savings');
//	let index = select.selectedIndex;
//	//console.log(index);

//	//選ぶ
//	savings.selectedIndex = index;
//}
