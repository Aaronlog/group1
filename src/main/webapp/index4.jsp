<%--
  Created by IntelliJ IDEA.
  User: ibm
  Date: 2018/6/14
  Time: 10:38
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

<div id="container" style="width: 800px;height: 300px"></div>
<script>
    $.ajax({
        type:"GET",
        url:"../bar.action",
        dataType:"json",
        success:function (data) {
            var x=[];
            var y=[];
            $(data).each(function (index,item) {
                x.push(item.name)
                y.push(item.age)
            })
            myChart.hideLoading();
            myChart.setOption({
                xAxis: {
                    type: 'category',
                    data: x
                },
                yAxis: {
                    type: 'value'
                },
                series: [{
                    data: y,
                    type: 'bar'
                }]
            })
        },
        error:function () {
            alert("加载数据失败")
        }
    })
    var dom = document.getElementById("container");
    var myChart = echarts.init(dom);
    // option = null;
    // option = {
    //     xAxis: {
    //         type: 'category',
    //         data: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun']
    //     },
    //     yAxis: {
    //         type: 'value'
    //     },
    //     series: [{
    //         data: [120, 200, 150, 80, 70, 110, 130],
    //         type: 'bar'
    //     }]
    // };
    myChart.setOption(option, true);

    myChart.showLoading();



</script>


<%--<form action="../saveCust.action" method="post">--%>
    <%--<input type="text" name="cname">--%>
<%--<input type="text" name="cage">--%>
<%--<input type="text" name="caddress">--%>
<%--<input type="submit" value="提交">--%>
<%--</form>--%>

</body>
</html>
