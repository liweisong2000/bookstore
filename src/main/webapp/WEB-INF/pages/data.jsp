<%--
  Created by IntelliJ IDEA.
  User: 宋轹蔚
  Date: 2022/5/25
  Time: 17:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html style="height: 100%">

<head>
    <meta charset="utf-8">
</head>

<body style="height: 100%; margin: 0">


<div id="container" style="height: 100%"></div>

<script type="text/javascript" src="js/echarts.min.js"></script>
<script type="text/javascript">
    var json='${sessionScope.json}';

    var jsonobj=JSON.parse(json);//将字符串转换成JavaScript对象
    //获取json中的数值
    var dataName = [];
    var dataNum = [];
    var temp = jsonobj;

    //匿名函数解析json串中的数值，关键点
    (function() {
        for(var i = 0; i < temp.length; i++) {
            dataName.push(temp[i].bookname);
            dataNum.push(temp[i].number);
        }
    })();

    var dom = document.getElementById("container");
    var a="ss";
    var myChart = echarts.init(dom);
    var app = {};

    app.title = '环形图';

    option = {
        title: {
            text: '购买统计',
            left: 'center'
        },
        tooltip: {
            trigger: 'item'
        },
        legend: {
            orient: 'vertical',
            left: 'left'
        },
        series: [
            {
                name: 'Access From',
                type: 'pie',
                radius: '50%',
                data: (function() { //饼状图需要函数解析数字内的值
                    var res = [];
                    var len = dataName.length;
                    while(len--) {
                        res.push({
                            name: dataName[len],
                            value: dataNum[len]
                        });
                    }
                    return res;
                })(),
                emphasis: {
                    itemStyle: {
                        shadowBlur: 10,
                        shadowOffsetX: 0,
                        shadowColor: 'rgba(0, 0, 0, 0.5)'
                    }
                }
            }
        ]
    };

    if(option && typeof option === "object") {
        myChart.setOption(option, true);
    }
</script>
<a style="position:absolute;left:1330px;top:622px;font-size:20px;" href="${pageContext.request.contextPath}/index">返回首页</a>
</body>

</html>
