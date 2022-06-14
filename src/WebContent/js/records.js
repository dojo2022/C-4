'use strict';

document.getElementById('record_form').onsubmit = function(event) {
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