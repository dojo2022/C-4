function chafun(){
	document.getElementById('chaform').onsubmit = function(){
		//各データを取得
    	const oldpw=document.getElementById('chaform').oldpw.value;
    	const newpw=document.getElementById('chaform').newpw.value;

		//未入力欄の検出とエラーメッセージの表示
		if(newpw === ''){
			document.getElementById('err').textContent='新しいパスワードを入力してください。';
			return false;
    	} else if(oldpw === newpw){
			document.getElementById('err').textContent='既存のパスワードとは異なるものを入力してください。';
			return false;
		} else {
			//全メッセージを削除
			document.getElementById('err').textContent='';
		}

 	};
};