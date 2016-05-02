<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>
<head>
<title>

</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


<style>
.leftDiv {
 float: left;
 width: 12%;
 border: 1px solid #B0C4DE;
}
.rightDiv {
 float: right;
 height:99%;
 width: 87.6%;
 border: 1px solid #B0C4DE;
}

</style>	
</head>

<body>

<form action="/CustomHandlerMethodArgumentResolver" method="post">
	<input type="text" name="p.name" />
	<input type="text" name="name" />
	<input type="text" name="p.age" />
	<input type="text" name="weight" />
	<input type="text" name="p.height" />
	<input type="submit" value="提交"/>
</form>


</body>

<script type="text/javascript">

$(document).ready(function(){
	$("#browser").treeview({
		toggle: function() {
			//console.log("%s was toggled.", $(this).find(">span").text());
		}
	});
	/*  增加树项功能函数
	$("#add").click(function() {
		var branches = $("<li><span class='folder'>New Sublist</span><ul>" + 
			"<li><span class='file'>Item1</span></li>" + 
			"<li><span class='file'>Item2</span></li></ul></li>").appendTo("#browser");
		$("#browser").treeview({
			add: branches
		});
	});
	*/
});



</script>

</html>
