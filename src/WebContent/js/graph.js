var ctx = document.getElementById('myChart').getContext('2d');
var chart = new Chart(ctx, {
	type : 'line',

	// データを指定
	data : {
		labels : Arraylabel(),
		datasets : [ {
			label : '1日の削減金額',
			borderColor : 'rgb(75, 192, 192)',
			fill : false,
			data : Arraydata()

		}, {
			label : '1日のノルマ',
			borderColor : '#f88',
			fill : false,
			data : Arrayquota()
		} ]
	},

	// 設定はoptionsに記述
	options : {
		//タイトル
		title : {
			display : true,
			text : '日々の削減金額'
		},
		//y軸の最小値を設定,
		y: {
			min: 0,
		},
		scales: {
			xAxes: [{
				scaleLabel: {
					display: true,
					labelString: '日付'
				}
			}],
			yAxes: [{
				scaleLabel: {
					display: true,
					labelString: '金額：円'
				}
			}]
		}
	}
});

//グラフデータの設定
function Arraydata(){
	var hoge = document.getElementsByClassName('savings');
	var data = [];

	for(let i = 0; i < hoge.length; i++){
		data.push(hoge[i].textContent);
	};
	return data;
}

//ラベルの設定
function Arraylabel(){
	var hoge = document.getElementsByClassName('date');
	var label = [];

	for(let i = 0; i < hoge.length; i++){
		label.push(hoge[i].textContent);
	};
	return label;
}

//目標金額の日割り計算
function Arrayquota(){
	var hoge = document.getElementsByClassName('date');
	const goal = document.getElementsByClassName('goal');
	const daymax = document.getElementsByClassName('daymax');
	const quotadata = Math.floor(goal[0].textContent/daymax[0].textContent);
	var quota = [];

	for(let i = 0; i < hoge.length; i++){
		quota.push(quotadata);
	};
	return quota;
}