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
		//var url = "${base}/ol/api/merchantinfo/get";
		//var url = "${base}/ol/api/serialcode/next/MALL";
		//var map = {
		//	merchantCode : "OLMERCHANT170718000001"
		//};
		//var url = "${base}/ol/api/register/step1";
		/*
		var map = {
			user : {
				email : "1223@qq.com",
				mobile : "122333",
				password : "2234",
				type : "2"	
			},
			merchant : {
				name : "ddd",
				type : "1"	
			},
			merchantContacts : {
				name : "zzzz"
				
			}
		};
		 */
		/*
		var url = "${base}/ol/api/mail/send";
		var map = {      
			mailTemplate : {
				code : "CMAILTEMP170801000001"
			},
			details : [
				{
					sentTo : "junkai.zhang@superbrandmall.com",
					paramsMap : {
						//name : "马俊",
						id : "007",
						address : "陆家嘴西路正大广场"
					}
				}
			]
		};
		 */
		/*
		var url = "${base}/ol/api/sysmessage/details";
		var map = {      
			sysMessage : {
				userCode : "OLUSER170728000001",
				type : 0,
				page : 1,
				pageCount : 2
			}
		};
		 */
		///*
		var url = "${base}/ol/api/searchshop/details";
		var map = { 
			vo : {	     
				userCode : "OLUSER170718000010",
				brandCode : "OLBRAND170717000011",
				minArea : 100,
				maxArea : 3000,
				start : "2017-08-09",
				end : "2017-08-31",
				mallCodes : [
					"OLMALL170717000001"
				] 
			}
		};  
		//*/
		/*
		var url = "${base}/ol/api/searchshop/histories";
		var map = {  
			vo : {
				userCode : "OLUSER170717000002",
				page : 2,
				pageCount : 2,
			}	    
		};
		 */
		/*
		var url = "${base}/ol/api/verificationcode/email";
		var map = {  
			keyword : "junkai.zhang@superbrandmall.com"     
		};
		 */
		/*
		var url = "${base}/ol/api/verificationcode/check";
		var map = {  
			key : "EMAIL_junkai.zhang@superbrandmall.com_2068b8a2-84f6-4000-9028-3fc740e38663",
			value : "SNUQKU"   
		};
		 */
		/*
		var url = "${base}/ol/api/verificationcode/mobile";
		var map = {  
			keyword : "13818768168"     
		};
		 */
		/*
		var url = "${base}/ol/api/verificationcode/check";
		var map = {  
			key : "MOBILE_13817200846_13a161ae-e6c6-4efb-92f3-823db7a7a324",
			value : "RYRSW4"   
		};
		*/
		/*
		var url = "${base}/ol/api/login/login";
		var map = { 
			username : "demo@superbrandmall.com",
			password : "12345678"   
		};
		 */
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
		        created: "2017-10-25 17:47:39", 
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
		        startDate: "2017-10-25 00:00:00", 
		        target: 500000, 
		        transferCondition: "无", 
		        updated: "2017-10-27 15:50:22", 
		        userCode: "OLUSER170717000002"
		    }, 
		    bidDetails: [
		    ]
		};
		*/
		/*
		var url = "${base}/ol/api/bid/details";
		var map = {
			bid : {
				userCode : "OLUSER170718000010",
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
		var url = "${base}/ol/api/download/pre";
		var map = {
			detail : {
				uri : "http://onlineleasing.blob.core.chinacloudapi.cn/test/OLUSER170718000010/photo/businesslicense/49cd20c1-ab09-4e0c-a1f7-4ceac262c467"
			}
		};
		 */
		/*
		var url = "${base}/ol/api/login/lang";
		var map = {
			code : "OLUSER170718000010",
			lang : 2
		};
		 */
		/*
		var url = "${base}/ol/api/brandinfo/list";
		var map = {
			merchantBrand : {
				merchantCode : "OLMERCHANT170718002248"   
			}  
		};
		 */
		/*
		var url = "${base}/ol/api/brandinfo/getByCode";
		var map = {  
			merchantBrand : {
				brandCode : "OLBRAND170717000537" 
			}    
		};
		 */
		/*
		var url = "${base}/ol/api/brandinfo/getByName";
		var map = {  
			merchantBrand : {
				name : "望湘园" 
			}   
		};
		 */
		/*
		var url = "${base}/ol/api/brandinfo/addExistingBrandWithoutUpdate";
		var map = {  
			merchantBrand : {
				merchantCode : "OLMERCHANT170718002248",
				brandCode : "OLBRAND170717000537"
			}   
		};
		 */
		/*
		var url = "${base}/ol/api/brandinfo/addExistingBrandWithUpdate";
		var map = {  
			merchantBrand : {
				merchantCode : "OLMERCHANT170718002248",
				brandCode : "OLBRAND170717000537"
			},
			brand : {

			}   
		};
		 */
		/*
		var url = "${base}/ol/api/brandinfo/addNewBrand";
		var map = {  
			merchantBrand : {
				merchantCode : "OLMERCHANT170718002248"
			},
			brand : {

			}   
		};
		*/
		/*
		var url = "${base}/ol/api/brandinfo/updateExistingBrand";
		var map = {  
			brand : {

			}   
		};
		 */
		/*
		var url = "${base}/ol/api/brandinfo/delete";
		var map = {  
			merchantBrand : {
				id : 16
			}   
		};
		 */
		/*
		var url = "${base}/ol/api/myfavourite/details";
		var map = {
			myFavourite : {
				userCode : "OLUSER170718000010",
				page : 1,
				pageCount : 2
			}
		};
		 */
		/*
		var url = "${base}/ol/api/myfavourite/save";
		var map = {
			myFavourite : {
				userCode : "OLUSER170718000010",
				shopCode : "OLSHOP170718000931"
			}
		};
		*/
		/*
		var url = "${base}/ol/api/myfavourite/delete";
		var map = {
			myFavourite : {
				id : "12"
			}
		};
		 */
		/*
		var url = "${base}/ol/api/sysmessage/read";
		var map = {
			list : [ {
				id : "1",
				code : "OLSYSMESSAGE170727000001",
				created : "2017-07-27 08:57:48",
				updated : "2017-09-11 17:50:22",
				state : "1",
				userCode : "OLUSER170727000018",
				message : "商户准入流程已发起，商户编码：OLMERCHANT170727000018",
			}, {
				id : "2",
				code : "OLSYSMESSAGE170727000002",
				created : "2017-07-27 08:57:49",
				updated : "2017-09-11 17:50:22",
				state : "1",
				userCode : "OLUSER170727000018",
				message : "品牌准入流程已发起，品牌编码：OLBRAND170727000001",
			}, ]
		};
		 */
		/*
		var url = "${base}/ol/api/shopinfo/get";
		var map = {
			myFavourite : {
				userCode : "OLUSER170718000010",
				shopCode : "OLSHOP170718000983"
			}
		};
		 */
		/*
		var url = "${base}/ol/api/shopinfo/getBeforeLogin";
		var map = {
			myFavourite : {
				shopCode : "OLSHOP170718000983"
			}
		};
		 */
		/*
		var url = "${base}/ol/api/userinfo/check/exist/mobile";
		var map = {
			username : "12345678911"
		};
		 */
		/*
		var url = "${base}/ol/api/userinfo/check/isNotExist/mobile";
		var map = {
			username : "13818768167"
		};
		 */
		/*
		var url = "${base}/ol/api/userinfo/check/isNotExist/idCard";
		var map = {
			idCard : "110224199901011136"
		};
		*/
		/*
		var url = "${base}/ol/api/userinfo/check/exist/email";
		var map = {
			username : "demo1@superbrandmall.com"
		};
		 */
		/* 
		var url = "${base}/ol/api/userinfo/check/isNotExist/email";
		var map = {
			username : "demo1@superbrandmall.com"
		};
		 */
		/*
		var url = "${base}/ol/api/userinfo/change/email";
		var map = {
			userCode : "OLUSER170908000001",
			username : "CCC123@hotmail.com"
		};
		 */
		/*
		var url = "${base}/ol/api/userinfo/forget/password";
		var map = {
			username : "13818758165",
			password : "99999999"
		};
		 */
		/*
		var url = "${base}/ol/api/userinfo/change/password";
		var map = {
			userCode : "OLUSER170816000002",
			oldPassword : "99999999",
			password : "11111111"
		};
		 */
		/*
		var url = "${base}/ol/api/register/step1";
		var map = {
			user : {
				email : "29533321187@qq.com",
				mobile : "13331818",
				password : "2234"
			},
			userContacts : {
				name : "zzzz",
				idCard : "310101139010044010",
				idCardType : "1"
			}
		};
		 */
		/*
		var url = "${base}/ol/api/register/step3AddExistingBrandWithoutUpdate";
		var map = {
			brandInfo : {
				merchantBrand : {
					merchantCode : "OLMERCHANT171212000026",
					brandCode : "OLBRAND171212001744"
				},
				brand : {
					status : 3
				}
			}
		};
		*/
		/*
		var url = "${base}/ol/api/baseinfo/modality/getModalityList";
		var map = {  
			     
		};
		 */
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
						billNumber : "23333",
						isApprove : 1,
						expireDate : "2017-11-30"
					},
					bidContract : {
						depositBillNumber : "222222",
						fileId : "2bca6189f70aa63dfa8e9fe91f461a268993f858b5607b6c94608e8f298f8e7d66994f119b191b45"
					}
				},
				{
					bid : {
						billNumber : "23334",
						isApprove : 2
					}
				}
			]
		};
		*/
		/*
		var url = "${base}/ol/api/interactive/bidresult/effect";
		var map = {  
			bidResultReceives : [
				{
					bid : {
						billNumber : "23333",
						isEffect : 1
					}
				},
				{
					bid : {
						billNumber : "23334",
						isEffect : 2
					}
				}
			]
		}; 
		*/
		/*
		var url = "${base}/ol/api/register/merchantcheck/baseInfo/V2";
		var map = {  
			uscc:"913716007677650413",
			name:"滨州滨海皮业有限公司"
		};
		*/
		/*
		var url = "${base}/ol/api/register/idcardcheck/idcard";
		var map = {
			name:"葛勇",
			idCard:"320926197510100415"
		};
		*/
		/*
		var url = "${base}/ol/api/brand/findAllByConditionPage";
		var map = {  
			page : 1,
			pageCount : 2
		};
		 */
		/*
		var url = "${base}/ol/api/merchant/findAllByConditionPage";
		var map = {  
			page : 1,
			pageCount : 2
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
				code : "OLSHOP170718000983"
			}
		};
		*/
        /*
		var url = "${base}/ol/api/shop/saveOrUpdate";
		var map = {
			shop : {
				code : "OLSHOP170718000983"
			},
			images : [{
			    id : 93,
			    deleteFlag : true,
			    image : "123",
				position : 9
			},{
                id : 92,
                deleteFlag : true,
                image : "123",
                position : 9
            }]
		};
		*/
		/*
		var url = "${base}/ol/api/merchantdetail/findAllByConditionPage";
		var map = {  
			merchantCourtAnnouncement : {
				code : "OLMERCHANT171010000001",
				page : 1,
				pageCount : 2
			},	
			merchantIllegalInfo : {
				code : "OLMERCHANT171010000001",
				page : 1,
				pageCount : 2
			},	
			merchantLawsuit : {
				code : "OLMERCHANT171010000001",
				page : 1,
				pageCount : 2
			},	
			merchantOwnTax : {
				code : "OLMERCHANT171010000001",
				page : 1,
				pageCount : 2
			},	
			merchantPunishmentInfo : {
				code : "OLMERCHANT171010000001",
				page : 1,
				pageCount : 2
			}	
		};
		*/
		/*
		var url = "${base}/ol/api/baseinfo/bidparam/getBidParam";
		var map = {  
		};
		*/
		/*
		var url = "${base}/ol/api/baseinfo/mallinfo/getMallInfo";
		var map = {  
			code : "OLMALL170717000001"	
		};
		*/
		/*
		var url = "${base}/ol/api/baseinfo/floorinfo/getFloorInfo";
		var map = {  
			code : "OLFLOOR171115000007"	
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