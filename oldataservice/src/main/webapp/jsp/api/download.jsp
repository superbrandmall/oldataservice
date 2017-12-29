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

		/* $('#business_license').on("change", function () {
		    var url = "${base}/ol/api/login/login";

		    var formData = new FormData();
		    formData.append('file', $('#file')[0].files[0]);
		    
		    $.ajax({
		        type: "POST",
		        url: url,
		        data: formData,
		        mimeTypes:"multipart/form-data",
		        processData: false,
		        contentType: false,
		        cache: false,
		        success: function(data) {
		            $('#hidden_business_license').val(data.path);
		            $('<div class="col-md-6">< img src="'+data.path+'" class="img-responsive"></div>').insertBefore($('#business_license'));
		        }
		    });
		}); */

	});

	var lang = 1;
	
	function login() {
		var url = "${base}/ol/api/login/login";
		var map = {
			username : "demo@superbrandmall.com",
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
				//request.setRequestHeader("login", "junkai.zhang");
				//request.setRequestHeader("Authorization", "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJPbmxpbmVMZWFzaW5nIiwiYXVkIjoianVua2FpLnpoYW5nIiwidGVzdCI6IjEyMyIsImlzcyI6InN1cGVyYnJhbmRtYWxsIiwiZXhwIjoxNTAxNjY1MTQwNzUxLCJpYXQiOjE1MDE2NjE1NDA3NTEsImp0aSI6IjEifQ.JNK6ruOUMMSHE-OfB_rokCocpLSJE7qwX4n-YM5qN_E");
			},
			success : function(res, textStatus, request) {
				//$("#result").html(JSON.stringify(res));
				//alert(JSON.stringify(res));
				Login = request.getResponseHeader('Login');
				Authorization = request.getResponseHeader('Authorization');
			},
			error : function(e) {
				alert("系统错误");
			}
		});
	}

	var key = "";
	
	function test123() {
		login();

		var url = "${base}/ol/api/download/pre";
		var map = {
			detail : {
				uri : "http://cre.trunk.hd123.cn/HDMediaService-web/fileget?fileID=5b15c15d5b6f03ce90e96e5c3cab833fbe819e7ce3297208d1fbc91ce6ec00bd66994f119b191b45&fileName=15a4fa5db3a393cc2f80e59340eabfb9ecb00d1f5cf2043dfcbdd1c9260913db1ea76abb3ea220b2a119432727ca794b&size=0,0"
			}
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
				request.setRequestHeader("Login", Login);
				request.setRequestHeader("Authorization", Authorization);
			},
			success : function(res, textStatus, request) {
				$("#result").html(JSON.stringify(res));
				key = res.data.key;
				//alert(JSON.stringify(res));
				//alert(request.getResponseHeader('Login'));
				//alert(request.getResponseHeader('Authorization'));
			},
			error : function(e) {
				alert("系统错误");
			}
		});
	}

	function show123() {
		return;
		var url = "${base}/ol/api/download/file?key=" + key;
		$("#result").html(JSON.stringify(url));
		var str = "<object data=\"" + url + "\" type=\"application/pdf\" width=\"100%\" height=\"800px\"></object>";
		
		$("downloaddiv").append(str);	
		alert(1);
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
						onclick="test123()" /></td>
					<td><input type="button" value="show" id="show"
						onclick="show123()" /></td>
				</tr>
			</table>
			<span id="result"></span>
		</div>
		<br />
		<!--内容框架▲-->
	</form>

	<br />
	<br />
	<br />
	<br />
	<span>下载测试：</span>
	<object
		data="${base}/ol/api/download/file?key=pdf_d895f884-86f9-43bf-981b-1e176f9b6b1a"
		type="application/pdf" width="100%" height="800px"> </object>



</body>
</html>