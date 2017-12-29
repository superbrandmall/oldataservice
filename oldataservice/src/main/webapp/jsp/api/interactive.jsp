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
	function login123() {
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
				$("#result").html(JSON.stringify(res));
				//alert(JSON.stringify(res));
				if ("C0" == res.code) {
					Login = request.getResponseHeader('Login');
					Authorization = request.getResponseHeader('Authorization');
				} else {
					//alert(res.message);
				}
			},
			error : function(e) {
				alert("系统错误");
			}
		});
	}

	//查询
	function test123() {
		login123();
		//return;
		/*
		var url = "${base}/ol/api/interactive/merchant/receive";
		var map = {  
			merchant: {
				code: "OLMERCHANT170718000001"
			},
			method: "accress" 
		};
		 */
		/*
		var url = "${base}/ol/api/interactive/brand/receive";
		var map = {  
			brand: {
				code: "OLBRAND170717000011"
			},
			method: "accress" 
		};
		 */
		/*
		var url = "${base}/ol/api/interactive/bidresult/approve";
		var map = {  
			bidResultReceives : [
				{
					bid : {
						billNumber : "1000011712220002",
						isApprove : 1,
						expireDate : "2017-12-30"
					},
					bidContract : {
						depositBillNumber : "7777777",
						fileId : "0f90d779c9600ca6074d9bc204d705a62fa2005f1b0e1fd0e9250791e5c668d066994f119b191b45"
					}
				}

//				{
//					bid : {
//						billNumber : "23334",
//						isApprove : 2
//					}
//				}
			]
		};
		*/
		///*
		var url = "${base}/ol/api/interactive/bidresult/effect";
		var map = {  
			bidResultReceives : [
				{
					bid : {
						billNumber : "1000011712220002",
						isEffect : 1
					}
				}
//				,
//				{
//					bid : {
//						billNumber : "23334",
//						isEffect : 2
//					}
//				}
			]
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
					<td><input type="button" value="test" id="test"
						onclick="test123()" /> <input type="button" value="login"
						id="login" onclick="login123()" /></td>
				</tr>
			</table>
			<span id="result"></span> <br />
			<HR style="border: 3 double #987cb9" width="100%" color=#987cb9
				SIZE=3>
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