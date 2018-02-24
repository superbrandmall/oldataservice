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

	function doUpload() {
		login();
		var formData = new FormData($("#uploadForm")[0]);
		$.ajax({
			//url : 'http://127.0.0.1:8750/onlineleasing-file/api/upload/multi',
			url : 'http://10.130.12.15:8750/zuul/onlineleasing-file/api/upload/multi',
			type : 'POST',
			data : formData,
			async : false,
			cache : false,
			contentType : false,
			processData : false,
			beforeSend : function(request) {
				request.setRequestHeader("login", Login);
				request.setRequestHeader("Authorization", Authorization);
			},
			success : function(res) {
				$("#result").html(JSON.stringify(res));
			},
			error : function(returndata) {
				alert(JSON.stringify(returndata));
			}
		});
	}
</script>
</head>
<body>
	<form id="uploadForm">
		<p>
			用户编号： <input type="text" name="vo.userCode"
				value="OLUSER170717000002" />
		</p>
		<p>
			容器名称： <input type="text" name="vo.containerName" value="test" />
		</p>
		<p>
			前缀： <input type="text" name="vo.prefix"
				value="OLUSER170717000002/pdf/contract" />
		</p>
		<p>
			上传文件： <input type="file" name="files" multiple="multiple" />
		</p>
		<input type="button" value="上传" onclick="doUpload()" />
	</form>
	<br/>
	<br/>
	<span id="result"></span>


</body>
</html>