<%--
  Created by IntelliJ IDEA.
  User: ibm
  Date: 2018/6/14
  Time: 16:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript" src="js/jquery-1.8.1.js"></script>
<html>
<head>
    <title>Title</title>

</head>
<body>

<a href="/getCust.action">展示全部</a>
<input type="button" value="提交" onClick="exc()"></input>

<script>
    function exc() {
        $.ajax({
            type:"get",
            url:"exc.action",
            success:function(data){
                if (data=="ok"){
                    alert("数据导出成功")
                }
            },
            error:function () {
                alert("数据导入失败")
            }
        })
    }
</script>

</body>
</html>
