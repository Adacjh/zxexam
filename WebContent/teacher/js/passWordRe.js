/**
 * 
 */
$(document).ready(function() {
	$('#oldPassWork').blur(function() {
		var passWord = $('#oldPassWork').val();
		if (passWord == "") {
		} else {
			$.ajax({
				type : "POST",// 提交类型
				url : "../../user/yZpassWord.do",
				dataType : "text",
				data : "passWord=" + passWord,
				async : false,// 异步
				success : function(json) {
					if (json == '1') {
					} else {
						alert(json)
					}
				}
			});
		}
	});
	$("#save").click(function() {
		$.ajax({
			type : "POST",// 提交类型
			url : "../../user/updatePassWord.do",
			dataType : "text",
			data : $('#submitform').serialize(),
			async : false,// 异步
			success : function(json) {
				if (json == '1') {
					alert("修改成功")
				} else {
					alert(json)
				}
			}
		});
	});

});
