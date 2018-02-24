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
		var url = "https://api/login/login";
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
		//login();

		var url = "http://10.130.12.15:8750/onlineleasing-file/api/download/pre";
		var map = {
			uri : "http://10.130.12.22:8280/HDMediaService-Web/fileget?fileID=5b3ea5be715bb575af0ac75ff027245a35d22da04f99bcec2576d7b18bda192c66994f119b191b45&fileName=5b3ea5be715bb575af0ac75ff027245a35d22da04f99bcec2576d7b18bda192c66994f119b191b45&size=0,0"
		};
		
		$.ajax({
			url : url,
			type : 'POST',
			async : false,
			data : map,
			beforeSend : function(request) {
//				request.setRequestHeader("Lang", lang);
//				request.setRequestHeader("Login", Login);
//				request.setRequestHeader("Authorization", Authorization);
			},
			success : function(res, textStatus, request) {
				$("#result").html(JSON.stringify(res));
				key = res.data.key;
				//alert(JSON.stringify(res));
				//alert(request.getResponseHeader('Login'));
				//alert(request.getResponseHeader('Authorization'));
			},
			error : function(e) {
				alert(JSON.stringify(e));
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
		data="http://10.130.12.15:8750/onlineleasing-file/api/download/file?key=pdf_eb1a9963-80e2-459f-a4e5-5660d797166a"
		type="application/pdf" width="100%" height="800px"> </object>



</body>
</html>