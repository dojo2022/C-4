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
			data : Arraydata(),
			yAxisID : 'yAxes',

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
		plugins : {
			title : {
				display : true,
				text : '日々の削減金額'
			}
		},
		scales: {
			xAxes: {
				title: {
					display: true,
					text: '日付'
				}
			},
			yAxes: {
				min : 0,		//y軸の最小値設定
				title: {
					display: true,
					text: '金額：円'
				}
			}
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
	var hoge = document.getElementsByClassName('day');
	var label = [];

	for(let i = 0; i < hoge.length; i++){
		label.push(hoge[i].textContent);
	};
	return label;
}

//目標金額の日割り計算
function Arrayquota(){
	var hoge = document.getElementsByClassName('day');
	const goal = document.getElementsByClassName('goal');
	const daymax = document.getElementsByClassName('daymax');
	const quotadata = Math.floor(goal[0].textContent/daymax[0].textContent);
	var quota = [];

	for(let i = 0; i < hoge.length; i++){
		quota.push(quotadata);
	};
	return quota;
}