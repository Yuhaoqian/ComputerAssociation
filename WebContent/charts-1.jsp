<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE HTML>
<html>

<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no"/>
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <!--[if lt IE 9]>
    <script type="text/javascript" src="js/html5shiv.js"></script>
    <script type="text/javascript" src="js/respond.min.js"></script>
    <![endif]-->
    <link rel="stylesheet" type="text/css" href="res/css/H-ui.min.css"/>
    <link rel="stylesheet" type="text/css" href="res/css/H-ui.admin.css"/>
    <link rel="stylesheet" type="text/css" href="res/css/Hui-iconfont/1.0.8/iconfont.css"/>
    <link rel="stylesheet" type="text/css" href="skin/default/skin.css" id="skin"/>
    <link rel="stylesheet" type="text/css" href="res/css/style.css"/>
    <!--[if IE 6]>
    <script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js"></script>
    <script>DD_belatedPNG.fix('*');</script>
    <![endif]-->
    <title>折线图</title>
</head>

<body>

<div class="page-container">
<!--    <div class="f-14 c-error">特别声明：Highcharts 是一个用纯-->
<!--        JavaScript编写的一个图表库，仅免费提供给个人学习、个人网站，如果在商业项目中使用，请去Highcharts官网网站购买商业授权。-->
<!--		或者您也可以选择其他免费的第三方图表插件，例如百度echarts。本模板不承担任何版权问题。-->
<!--    </div>-->
    <div id="container" style="min-width:700px;height:400px"></div>
</div>
<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="res/layui/lay/modules/layer.js"></script>
<script type="text/javascript" src="js/H-ui.min.js"></script>
<script type="text/javascript" src="js/H-ui.admin.js"></script>
<!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="js/hcharts/Highcharts/5.0.6/js/highcharts.js"></script>
<script type="text/javascript" src="js/hcharts/Highcharts/5.0.6/js/modules/exporting.js"></script>
<script type="text/javascript">
    $(function () {
    	$.getJSON('fundServlet',
				function(result){
    		let jsonFunds = eval(result);
    		var chartJson ={
                    title: {
                        text: '财务支出明细',
                        x: -20 //center
                    },
                    subtitle: {
                        text: '来源: 计算机协会',
                        x: -20
                    },
                    xAxis: {
                        categories: []
                    },
                    yAxis: {
                        title: {
                            text: '支出 (￥)'
                        },
                        plotLines: [{
                            value: 0,
                            width: 1,
                            color: '#808080'
                        }]
                    },
                    tooltip: {
                        valueSuffix: '￥'
                    },
                    legend: {
                        layout: 'vertical',
                        align: 'right',
                        verticalAlign: 'middle',
                        borderWidth: 0
                    },
                    series: [{
                    	name:'',
                    	data:[]
                    }]
                }
        	chartJson.series[0].name='花费';
        	var j=0;
    		for(i in jsonFunds){
    			chartJson.xAxis.categories[j]=jsonFunds[i].user_id+':'+jsonFunds[i].f_purpose;
    			chartJson.series[0].data[j]=jsonFunds[i].amount;
    			j++;
            }
            Highcharts.chart('container', chartJson);
		}); 
    });
</script>
</body>

</html>