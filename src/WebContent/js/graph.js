<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/3.8.0/chart.min.js" integrity="sha512-sW/w8s4RWTdFFSduOTGtk4isV1+190E/GghVffMA9XczdJ2MDzSzLEubKAs5h0wzgSJOQTRYyaz73L3d6RtJSg==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>

<script>
 var ctx = document.getElementById('myChart').getContext('2d');
 var chart = new Chart(ctx, {
     type: 'line',

     // データを指定
     data: {
         labels: ['月', '火', '水', '木', '金', '土', '日'],
         datasets: [{
             label: 'dataset example',
             borderColor: 'rgb(75, 192, 192)',
             fill: false,
             data: [10, 2, 5, 4, 6, 7, 11]
         }]
     },

     // 設定はoptionsに記述
     options: {
       //タイトル
       title: {
         display: true,
         text: '線グラフの例'
       }
     }
});
</script>