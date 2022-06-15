function logfun(){
	document.getElementById('logform').onsubmit = function(){
		//各データを取得
    	const log=document.getElementById('logform').user.value;
    	const pass=document.getElementById('logform').pw.value;

		//未入力欄の検出とエラーメッセージの表示
		if(log === ''){
			if(pass === ''){
	        	document.getElementById('err').textContent='ログインIDとパスワードが未入力です';
				return false;
			} else {
				document.getElementById('err').textContent='ログインIDが未入力です';
				return false;
			}
    	} else if(pass === ''){
			if(log === ''){
				document.getElementById('err').textContent='ログインIDとパスワードが未入力です';
				return false;
			} else {
				document.getElementById('err').textContent='パスワードが未入力です';
				return false;
			}
		} else {
			document.getElementById('err').textContent='';
		}

 	};
};