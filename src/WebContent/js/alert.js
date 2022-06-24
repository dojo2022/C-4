'use strict';

//alert.jspに読み込まれるファイル

//必須項目を入力してくださいとだけを出るようにする

function alert_confirm() {
	document.getElementById('alert_form').onsubmit = function() {
		//各データを取得
		const days = document.getElementsByClassName('days');
		const morningMin = document.getElementById('alert_form').morning_alertMin.value;
		const morningMax = document.getElementById('alert_form').morning_alertMax.value;
		const lunchMin = document.getElementById('alert_form').lunch_alertMin.value;
		const lunchMax = document.getElementById('alert_form').lunch_alertMax.value;
		const dinnerMin = document.getElementById('alert_form').dinner_alertMin.value;
		const dinnerMax = document.getElementById('alert_form').dinner_alertMax.value;

		console.log(morningMin);


		//days抜け漏れ
		let count = 0;
		for (let i = 0; i < days.length; i++) {
			if (days[i].checked) {
				count++;
			}
		}
		if (count === 0) {
			document.getElementById('date_alert').textContent = `*日にちを選択してください`;
			return false;
		}

		//朝昼夕抜け
		if((morningMin === "" || morningMax === "") && (lunchMin === "" || lunchMax === "") && (dinnerMin === "" || dinnerMax === "")){
			document.getElementById('morning_alert').textContent = `*朝・昼・夕のアラート設定をしてください`;
			return false;
		}
		//morning抜け漏れ✓
		else if (morningMin === "" || morningMax === ""){
			document.getElementById('morning_alert').textContent = `*朝のアラート設定をしてください`;
			return false;
		}
		//lunch抜け漏れ✓
		else if (lunchMin === "" || lunchMax === "") {
			document.getElementById('morning_alert').textContent = `*昼のアラート設定をしてください`;
			return false;
		}
		//dinner抜け漏れ✓
		else if (dinnerMin === "" || dinnerMax === "") {
			document.getElementById('morning_alert').textContent = `*夕のアラート設定をしてください`;
			return false;
		}
		else{
			alert('登録できました');
		}

	}
}