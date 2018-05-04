//设置系统时间
window.setInterval(function() {
	var d = new Date();
	$("#time").html(d.toLocaleString());
}, 1000);
<!--展开下来菜单-->
	$('li.dropdown').mouseover(function() {   
		$(this).addClass('open');    	}).mouseout(
     function() {        
     	$(this).removeClass('open');    
     }); 
     window.setInterval(function() {
     	var d=new Date();
     	var date=d.toLocaleString();
     	var day=d.getDay();
     	switch(day){
     		case 0:
     			date+="星期日";
     			break;
     		case 1:
     			date+="星期一";
     			break;
     		case 2:
     			date+="星期二";
     			break;
     		case 3:
     			date+="星期三";
     			break;
     		case 4:
     			date+="星期四";
     			break;
     		case 5:
     			date+="星期五";
     			break;
     		case 6:
     			date+="星期六";
     			break;
     	}
     	$("#p1").html(date);
     },1000);