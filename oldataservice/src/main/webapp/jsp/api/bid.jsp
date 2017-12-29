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
		//var url = "${base}/ol/api/login/adminLogin"; 
		var url = "${base}/ol/api/login/login"; 
		var map = { 
			//username : "admin@superbrandmall.com",
			//username : "demo@superbrandmall.com",
			username : "junkai.zhang@superbrandmall.com",
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
		var url = "${base}/ol/api/bid/info";
		var map = { 
			shop : {
				code : "OLSHOP170718001031"
			},
			searchShopDetail : {
				//code : "OLSEARCHSHOP170807000021"
			},
			bidMerchantBrandVo : {
				code : "OLMERCHANT171010000001"
			},
			//bid : {
				//code : "OLBID171025000003"
			//} 
		};
		*/
		/*
		var url = "${base}/ol/api/bid/save";
		var map = { 
		    bid: {
		        bindingCondition: "", 
		        brandCode: "OLBRAND171027000002", 
		        businessFreePeriod: null, 
		        businessHours: 1, 
		        cashierMode: 1, 
		        compareFrequency: 2,
		        endDate: "2023-10-23 00:00:00", 
		        exclusiveCondition: "", 
		        extendedDecoration: null, 
		        extraBusinessHour_1: "", 
		        extraBusinessHour_2: "", 
		        freeDays: 75, 
		        gurantee: 1433657.82, 
		        maintenanceAfterDecoration: 240733.2, 
		        maintenanceCompensate: "1000", 
		        maintenanceDuringDecoration: 240733.2, 
		        merchantCode: "OLMERCHANT171010000001", 
		        opening: "2018-01-08 00:00:00", 
		        page: 0, 
		        pageCount: 0, 
		        practiceRateReached: null, 
		        processState: 1, 
		        promotion: 2, 
		        promotionBudget: 1.5, 
		        promotionKind: 1, 
		        publicDeposit: 5000, 
		        rentMethod: 2, 
		        shopCode: "OLSHOP170718001031", 
		        startDate: "2017-12-25 00:00:00",
		        target: 500000, 
		        transferCondition: "无",
		        userCode: "OLUSER170717000002"
		    }, 
		    bidDetails: [
				{
				    startDate : "2017-12-25 00:00:00",
                    endDate: "2023-10-23 00:00:00",
					deadRent : 0,
					floatingRentalRate : 0,
					orders : 1
				}
		    ]
		};
		*/
		/*
		var url = "${base}/ol/api/bid/details";
		var map = {
			bid : {
				userCode : "OLUSER170717000002",
				page : 1,
				pageCount : 2,
			}
		};
		*/
		/*
		var url = "${base}/ol/api/bid/contractdetails";
		var map = {
			bid : {
				userCode : "OLUSER170717000002",
				page : 1,
				pageCount : 2,
			}
		};
		*/
		/*
		var url = "${base}/ol/api/bid/preview";
		var map = { 
			code : "OLBID171030000005",
		};
		*/
		/*
		var url = "${base}/ol/api/bid/view";
		var map = { 
			key : "OLBID171030000005_316868d2-ee13-4fd0-b3e7-b066801416d9",
		};
		*/
		/*
		var url = "${base}/ol/api/bid/saveLegalSuggest";
		var map = { 
			suggestVo : {
				code : "OLBID171030000001",
				legalSuggest : "我有异议"
			} 
		};
		*/ 
		/*
		var url = "${base}/ol/api/bid/saveBusinessSuggest";
		var map = { 
			suggestVo : {
				code : "OLBID171030000001",
				businessSuggest : "我有异议"
			} 
		};
		*/
		/*
		var url = "${base}/ol/api/bid/submit";
		var map = {
			code : "OLBID171221000003"
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