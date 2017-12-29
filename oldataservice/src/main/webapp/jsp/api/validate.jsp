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
<script src="${base}/js/jquery.validate.min.js"></script>
<script type="text/javascript">

	//var aaa = JSON.stringify({mobile:$('#mobile').val()});
	/*var aaa = (function () {
		return JSON.stringify({mobile:$('#mobile').val()});
	})();
	*/

	$.validator.addMethod( "zjk", function( value, element, param, method ) {
		if ( this.optional( element ) ) {
			return "dependency-mismatch";
		}
		method = typeof method === "string" && method || "zjk";

		var previous = this.previousValue( element, method ),
			validator, data, optionDataString;

		if ( !this.settings.messages[ element.name ] ) {
			this.settings.messages[ element.name ] = {};
		}
		previous.originalMessage = previous.originalMessage || this.settings.messages[ element.name ][ method ];
		this.settings.messages[ element.name ][ method ] = previous.message;

		param = typeof param === "string" && { url: param } || param;
		optionDataString = $.param( $.extend( { data: value }, param.data ) );
		if ( previous.old === optionDataString ) {
			return previous.valid;
		}

		previous.old = optionDataString;
		validator = this;
		this.startRequest( element );
		data = {};
		data[ element.name ] = value;
		data = JSON.stringify(data);
		$.ajax( $.extend( true, {
			mode: "abort",
			port: "validate" + element.name,
			dataType: "json",
			data: data,
			context: validator.currentForm,
			success: function( response ) {
				var valid = response === true || response === "true",
					errors, message, submitted;

				validator.settings.messages[ element.name ][ method ] = previous.originalMessage;
				if ( valid ) {
					submitted = validator.formSubmitted;
					validator.resetInternals();
					validator.toHide = validator.errorsFor( element );
					validator.formSubmitted = submitted;
					validator.successList.push( element );
					validator.invalid[ element.name ] = false;
					validator.showErrors();
				} else {
					errors = {};
					message = response || validator.defaultMessage( element, { method: method, parameters: value } );
					errors[ element.name ] = previous.message = message;
					validator.invalid[ element.name ] = true;
					validator.showErrors( errors );
				}
				previous.valid = valid;
				validator.stopRequest( element, valid );
			}
		}, param ) );
		return "pending";
	}, "zjk123" );

	
	$(function() {
		$("#validForm").validate({
			onkeyup : false,
			
	        rules: {
	            mobile: {
	                required: true,
	                rangelength: [11,11],
	                digits: true,
	                zjk: {
	                    url: "http://oldataservice.chinacloudsites.cn/onlineleasing/ol/api/register/check/mobile",
	                    type: "post",
	                    dataType: "json",
	                    contentType: "application/json",
	                    dataFilter: function(data,type) {
	                        var very = JSON.parse(data).code;
	                        if (very === 'C0')
	                            return true;
	                        else
	                            return false;
	                    } 
	                }
	            }
	        },
	        
	        messages: {
	            mobile: {
	                required: "主要联系人手机为必填项",
	                rangelength: "请输入正确手机号码",
	                digits: "请输入正确手机号码",
	                zjk: "手机号已存在"
	            }
	        },
	        submitHandler: function() {
	            $.ajax({
	                url: $.api.base+"/register/step1",
	                type: "POST",
	                data: JSON.stringify(map),
	                async: false,
	                dataType: "json",
	                contentType: "application/json",
	                success: function (response, status, xhr) {
	                    alert(JSON.stringify(response));
	                },
	                error: function(jqXHR, textStatus, errorThrown) {
	                	alert(JSON.stringify(jqXHR));
	                }
	            });
	        }
	    });
	});

	

	
</script>
</head>
<body>
	<form id="validForm">
		<input type="text" id="mobile" name="mobile" placeholder="手机*" />
	</form>


</body>
</html>