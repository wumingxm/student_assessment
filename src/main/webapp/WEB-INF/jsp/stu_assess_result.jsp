<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    	<meta charset="utf-8">
    </head>
    <body>
    <jsp:include page="base.jsp"></jsp:include>
       <script type="text/javascript" src="../js/echarts.js"></script>
     <div id="chartmain" style="width:600px; height: 400px;"></div>
     <script type="text/javascript">
   	option = {
    		    title : {
    		        text: '大学生学生评价结果分析\n',
    		        x:'center',
    		        y:370
    		    },
    		    tooltip : {
    		        trigger:'axis'
    		    },
    		    legend: {
    		        data:['1分','2分','3分','4分','5分']
    		    },
    		    toolbox: {
    		        show : true,
    		        feature : {
    		            mark : {show: true},
    		            dataView : {show: true, readOnly: false},
    		            magicType : {show: true, type: ['line', 'bar']},
    		            restore : {show: true},
    		            saveAsImage : {show: true}
    		        }
    		    },
    		    calculable : true,
    		    xAxis : [
    		        {
    		            type : 'category',
    		            data : ['道德素质','公民素养','交流与合作','运动与健康','审美表现']
    		        }
    		    ],
    		    yAxis : [
    		        {
    		            type : 'value'
    		        }
    		    ],
    		    series : [
    		        {
    		            name:'1分',
    		            type:'bar',
    		            data:[1, 1,1,1,1],
    		            markPoint : {
    		                data : [
    		                    {type : 'max', name: '最大值'},
    		                    {type : 'min', name: '最小值'}
    		                ]
    		            },
    		            markLine : {
    		                data : [
    		                    {type : 'average', name: '平均值'}
    		                ]
    		            }
    		        },
    		        {
    		            name:'2分',
    		            type:'bar',
    		            data:[2, 2,2,2,2],
    		            markPoint : {
    		                data : [
    		                    {type : 'max', name: '最大值'},
    		                    {type : 'min', name: '最小值'}
    		                ]
    		            },
    		            markLine : {
    		                data : [
    		                    {type : 'average', name: '平均值'}
    		                ]
    		            }
    		        },
    		        {
    		            name:'3分',
    		            type:'bar',
    		            data:[3, 3,3,3,3],
    		            markPoint : {
    		                data : [
    		                    {type : 'max', name: '最大值'},
    		                    {type : 'min', name: '最小值'}
    		                ]
    		            },
    		            markLine : {
    		                data : [
    		                    {type : 'average', name: '平均值'}
    		                ]
    		            }
    		        },
    		        {
    		            name:'4分',
    		            type:'bar',
    		            data:[4, 4,4,4,4],
    		            markPoint : {
    		                data : [
    		                    {type : 'max', name: '最大值'},
    		                    {type : 'min', name: '最小值'}
    		                ]
    		            },
    		            markLine : {
    		                data : [
    		                    {type : 'average', name: '平均值'}
    		                ]
    		            }
    		        },
    		        {
    		            name:'5分',
    		            type:'bar',
    		            data:[5, 5,5,5,5],
    		            markPoint : {
    		                data : [
    		                    {type : 'max', name: '最大值'},
    		                    {type : 'min', name: '最小值'}
    		                ]
    		            },
    		            markLine : {
    		                data : [
    		                    {type : 'average', name: '平均值'}
    		                ]
    		            }
    		        }
    		    ]
    		}; 
    		/*   var option = {
    	            title:{
    	                text:'ECharts 数据统计'
    	            },            
    	            series:[{
    	                name:'访问量',
    	                type:'pie',    
    	                radius:'60%', 
    	                data:[
    	                    {value:500,name:'Android'},
    	                    {value:200,name:'IOS'},
    	                    {value:360,name:'PC'},
    	                    {value:100,name:'Ohter'}
    	                ]
    	            }]
    	        }; */
     //初始化echarts实例
     var myChart = echarts.init(document.getElementById('chartmain'));
     //使用制定的配置项和数据显示图表
     myChart.setOption(option);                   
    </script>
    </body>
</html>

