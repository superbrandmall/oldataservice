<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>onlineleasing</title>
<link href="${base}/css/base20141103.css" rel="stylesheet"
	type="text/css">
<link href="${base}/css/about_us.css" rel="stylesheet" type="text/css">
<style type="text/css">
.title {
	text-align: center;
	background-color: #e9e9e9;
	font-weight: bold;
}

.common {
	text-align: center;
}

.complete {
	background-color: #efffff;
}

.page {
	margin: 20px auto;
}
</style>
</head>

<script src="${base}/js/jquery.js"></script>
<script type="text/javascript">
	$(function() {

	});

	Login = "";
	Authorization = "";
	lang = 2;
	source = "oldataservice";
	function login() {
		var url = "${base}/ol/api/login/adminLogin";
		//var url = "${base}/ol/api/login/login";
		var map = {
			username : "admin@superbrandmall.com",
			//username : "demo@superbrandmall.com",
			password : "12345678"
		};
		$.ajax({
			url : url,
			type : 'POST',
			async : false,
			dataType : "json",
			contentType : "application/json",
			data : JSON.stringify(map),
			beforeSend : function(request) {
				request.setRequestHeader("Lang", lang);
				request.setRequestHeader("Source", source);
				//request.setRequestHeader("login", "junkai.zhang");
				//request.setRequestHeader("Authorization", "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJPbmxpbmVMZWFzaW5nIiwiYXVkIjoianVua2FpLnpoYW5nIiwidGVzdCI6IjEyMyIsImlzcyI6InN1cGVyYnJhbmRtYWxsIiwiZXhwIjoxNTAxNjY1MTQwNzUxLCJpYXQiOjE1MDE2NjE1NDA3NTEsImp0aSI6IjEifQ.JNK6ruOUMMSHE-OfB_rokCocpLSJE7qwX4n-YM5qN_E");
			},
			success : function(res, textStatus, request) {
				//$("#result").html(JSON.stringify(res));
				//alert(JSON.stringify(res));
				if ("C0" == res.code) {
					Login = request.getResponseHeader('Login');
					Authorization = request.getResponseHeader('Authorization');
				} else {
					alert(res.message);
				}
			},
			error : function(e) {
				alert("系统错误");
			}
		});
	}

	//查询
	function test123() {
		login();
		//return;
		/*
		var url = "${base}/ol/api/register/merchantcheck/search";
		var map = {  
			uscc :  $("#search123").val()
		};
		*/ 
		///* 
		var url = "${base}/ol/api/partner/tianyancha/search";
		var map = {  
			word :  $("#search123").val()
		}; 
		//*/
		$.ajax({
			url : url,
			type : 'POST',
			async : false,
			dataType : "json",
			contentType : "application/json",
			data : JSON.stringify(map),
			beforeSend : function(request) {
				request.setRequestHeader("Lang", lang);
				request.setRequestHeader("Source", source);
				request.setRequestHeader("Login", Login);
				request.setRequestHeader("Authorization", Authorization);
			},
			success : function(res, textStatus, request) {
				$("#result").html(JSON.stringify(res));
				//alert(JSON.stringify(res));
				//alert(request.getResponseHeader('Login'));
				//alert(request.getResponseHeader('Authorization'));
			},
			error : function(e) {
				alert("系统错误");
			}
		});
	}

	function test1234() {
		login();
		var url = "${base}/ol/api/partner/tianyancha/baseInfo";
		var map = {  
			id : $("#baseInfo").val()
		};
		/*
		var url = "${base}/ol/api/register/merchantcheck/baseInfo";
		var map = {  
			merchantCode : $("#baseInfo").val()
		};
		*/
		$.ajax({
			url : url,
			type : 'POST',
			async : false,
			dataType : "json",
			contentType : "application/json",
			data : JSON.stringify(map),
			beforeSend : function(request) {
				request.setRequestHeader("Lang", lang);
				request.setRequestHeader("Login", Login);
				request.setRequestHeader("Authorization", Authorization);
			},
			success : function(res, textStatus, request) {
				$("#result1").html(JSON.stringify(res));
				//alert(JSON.stringify(res));
				//alert(request.getResponseHeader('Login'));
				//alert(request.getResponseHeader('Authorization'));
			},
			error : function(e) {
				alert("系统错误");
			}
		});
	}
	
</script>
</head>
<body>

	<form id="csform">

		<!--联系我们页头▼-->
		<div class="linkheader" style="width: 1200px;">
			<a href="http://www.superbrandmall.com/" target="_blank" class="logo">
				<img src="${base}/image/logonew2014.png">
			</a> <span>onlineleasing</span>
		</div>
		<!--联系我们页头▲-->
		<!--内容框架▼-->
		<!-- jdeAcitivity -->
		<div class="main_content nobg" style="width: 1220px;">
			<table id="csSearch" style="width: 1000px;">
				<tr>
					<td>
						<input type="text" value="913100007362253920" id="search123" />
						<input type="button" value="test" id="test"
						onclick="test123()" />
					</td>
				</tr>
			</table>
			<span id="result"></span>
		</div>
		<div class="main_content nobg" style="width: 1220px;">
			<table id="csSearch1" style="width: 1000px;">
				<tr>
					<td>
						<input type="text" value="" id="baseInfo"/>
						<input type="button" value="test" id="test1"
						onclick="test1234()" />
					</td>
				</tr>
			</table>
			<span id="result1"></span>
		</div>
		<br />
		<!--内容框架▲-->
	</form>
	<br />
	<br />
	<br />
	<br />
	<span>azure storage test</span>
	<br />
	<img
		src="http://onlineleasing.blob.core.chinacloudapi.cn/test/pdf/20170815/logonew2014.png" />
	<br />

</body>
</html>