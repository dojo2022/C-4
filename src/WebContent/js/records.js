'use strict';

function plus() {
	document.getElementById('number1');
	document.getElementById('number2');
	document.getElementById('number3');
	//結果を戻す
	//const totals = number1 + number2 + number3;
	const total_value = document.getElementById('total').value = number1 + number2 + number3;
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

	//朝食１品追加
	function addMorningMenu() {

		//どこに足すか
		let td = document.getElementById('morning');

		//何を足すか
		let select = document.getElementById('morningSelect').cloneNode(true);
		td.appendChild(document.createElement('br'));
		td.appendChild(select);

	}
}