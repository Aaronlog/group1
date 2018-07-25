<%--
  Created by IntelliJ IDEA.
  User: ibm
  Date: 2018/6/14
  Time: 14:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="js/jquery-1.8.1.js"></script>
    <script type="text/javascript" src="js/echarts.min.js"></script>

</head>
<body>
<div id="container" style="width: 600px;height: 400px"></div>


<script>
    
    $.ajax({
        type:"GET",
        url:"../barc.action",
        dataType:"json",
        success:function (data) {
            myChart.hideLoading();
            myChart.setOption({
                series: [{
                    data:data,
                }]
            })
        },
    })

    option = {
        xAxis: {
            type: 'category',
            data: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun']
        },
        yAxis: {
            type: 'value'
        },
        series: [{
            data: [820, 932, 901, 934, 1290, 1330, 1320],
            type: 'line'
        }]
    };


    var dom = document.getElementById("container");
    var myChart = echarts.init(dom);

    myChart.setOption(option, true);
    myChart.showLoading();
    
</script>

</body>
</html>
