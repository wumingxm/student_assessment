$(function() {
	$("#ul").tree({
		url : '/selectModel',
		lines : true,
		animate : true,
		onClick : function(node) {
			if ($("#u1").tree('isLeaf', node.target)) {
					if(!$("#tabs").tabs('exists',node.text)){
						$("#tabs").tabs('add',{
							title:node.text,
							href:node.url,
							closable:true,
						});
					}
					var tab = $('#tabs').tabs('getSelected');  // 获取选择的面板s
					$('#tabs').tabs('update', {
						tab: tab,
						options: {
							title:node.text,
							href:node.url  // 新内容的URL
						}
					});
					
			} else {
				if (node.state == 'open') {
					$("#ul").tree('collapse', node.target);
				} else {
					$("#ul").tree('expand', node.target);
				}
			}
		}
	});
});
