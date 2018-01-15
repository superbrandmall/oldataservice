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
			//username : "junkai.zhang@superbrandmall.com",
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
		var url = "${base}/ol/api/brand/findAllByConditionPage";
		var map = {
			brand : {
				page : 1,
				pageCount : 2
			}
		};
		*/
		/*
		var url = "${base}/ol/api/brand/findByCode";
		var map = {
			brand : {
				code : "OLBRAND171212001561"
			}
		};
		*/

		/*
		var url = "${base}/ol/api/building/findAllByConditionPage";
		var map = {
			building : {
				page : 1,
				pageCount : 2
			}
		};
		*/
		/*
		var url = "${base}/ol/api/building/findByCode";
		var map = {
			building : {
				code : "OLBUILDING171212000004"
			}
		};
		*/

		/*
		var url = "${base}/ol/api/mall/findAllByConditionPage";
		var map = {
			mall : {
				page : 1,
				pageCount : 2
			}
		};
		*/
		/*
		var url = "${base}/ol/api/mall/findByCode";
		var map = {
			mall : {
				code : "OLMALL171212000008"
			}
		};
		*/

		/*
		var url = "${base}/ol/api/mall/saveOrUpdate";
		var map = {
			mall : {
				code : "OLMALL171212000008"
			},
			mallBidStandard : {
				id : 3,
				updated : "2018-01-08 15:35:40",
				maintenanceFee : "60"
			}
		};
		*/

		/*
		var url = "${base}/ol/api/shop/findAllByConditionPage";
		var map = {
			shop : {
				page : 1,
				pageCount : 2
			}
		};
		*/
		/*
		var url = "${base}/ol/api/shop/findByCode";
		var map = {
			shop : {
				code : "OLSHOP171212000329"
			}
		};
		*/

		/*
		var url = "${base}/ol/api/merchant/findAllByConditionPage";
		var map = {
			merchant : {
				page : 1,
				pageCount : 2
			}
		};
		*/
		/*
		var url = "${base}/ol/api/merchant/findByCode";
		var map = {
			merchant : {
				code : "OLMERCHANT171212002226"
			}
		};
		*/

		/*
		var url = "${base}/ol/api/floor/findAllByConditionPage";
		var map = {
			floor : {
				page : 1,
				pageCount : 2
			}
		};
		*/
		/*
		var url = "${base}/ol/api/floor/findByCode";
		var map = {
			floor : {
				code : "OLFLOOR171212000021"
			}
		};
		*/

		/*
		var url = "${base}/ol/api/bid/findAllByConditionPage";
		var map = {
			bid : {
				page : 1,
				pageCount : 2
			}
		};
		*/
		/*
		var url = "${base}/ol/api/bid/findByCode";
		var map = {
			bid : {
				code : "OLBID171222000002"
			}
		};
		*/

		/*
		var url = "${base}/ol/api/user/findAllByConditionPage";
		var map = {
			user : {
				page : 1,
				pageCount : 2
			}
		};
		*/
		///*
		var url = "${base}/ol/api/user/findByCode";
		var map = {
			user : {
				code : "OLUSER171214000004"
			}
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