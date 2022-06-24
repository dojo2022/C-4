function signupfun(){
	document.getElementById('signupform').onsubmit = function(){
		//各データを取得
    	const log=document.getElementById('signupform').user.value;
    	const name=document.getElementById('signupform').name.value;
    	const pass=document.getElementById('signupform').pw.value;

		//未入力欄の検出とエラーメッセージの表示
		if(log === '' && pass === '' && name === ''){
			document.getElementById('err').textContent='全ての項目が未入力です';
			return false;
		}

		if(log === ''){
			if(pass === ''){
	        	document.getElementById('err').textContent='ログインIDとパスワードが未入力です';
				return false;
			} else if(name === ''){
				document.getElementById('err').textContent='ログインIDとニックネームが未入力です';
				return false;
			} else {
				document.getElementById('err').textContent='ログインIDが未入力です';
				return false;
			}
		} else if(name === ''){
			if(pass === ''){
	        	document.getElementById('err').textContent='ニックネームとパスワードが未入力です';
				return false;
			} else if(log === ''){
				document.getElementById('err').textContent='ログインIDとニックネームが未入力です';
				return false;
			} else {
				document.getElementById('err').textContent='ニックネームが未入力です';
				return false;
			}
    	} else if(pass === ''){
			if(log === ''){
				document.getElementById('err').textContent='ログインIDとパスワードが未入力です';
				return false;
			} else if(name === ''){
				document.getElementById('err').textContent='ニックネームとパスワードが未入力です';
				return false;
			} else {
				document.getElementById('err').textContent='パスワードが未入力です';
				return false;
			}
		} else {
			document.getElementById('err').textContent='';
		}


		if(log === name){
			if(name === pass){
				document.getElementById('err').textContent='全ての項目で同じ内容が入力されています。';
				return false;
			} else {
				document.getElementById('err').textContent='ログインIDとニックネームで同じ内容が入力されています。';
				return false;
			}
		} else if(name === pass){
			if(log === pass){
				document.getElementById('err').textContent='全ての項目で同じ内容が入力されています。';
				return false;
			} else {
				document.getElementById('err').textContent='ニックネームとパスワードで同じ内容が入力されています。';
				return false;
			}
		} else if(log === pass){
			if(name === pass){
				document.getElementById('err').textContent='全ての項目で同じ内容が入力されています。';
				return false;
			} else {
				document.getElementById('err').textContent='ログインIDとパスワードで同じ内容が入力されています。';
				return false;
			}
		} else {
			document.getElementById('err').textContent='';
		}
 	};
};