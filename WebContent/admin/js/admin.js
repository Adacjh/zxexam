/**
 * 
 */
$(document).ready(
		function() {
			var userInfo;
			var getName = $('#getName').val();
			if (getName == "") {
				alert("请登录！")
				window.location.href = "../../jsp/login.jsp";
			} else {
				$.ajax({
					type : "POST",// 提交类型
					url : "../../user/searchUserInfo.do",
					dataType : "json",
					async : false,// 异步
					success : function(json) {
						userInfo = json;
						if (userInfo[0].userName == ""
								|| userInfo[0].userName == null) {
							alert("请登录！")
							window.location.href = "../../jsp/login.jsp";
						} else {
							$("#userNickName").html(userInfo[0].userName);
						}
					}
				});
			}

			$('#iframe2').attr("src", "../jsp/Hello.jsp?userName=" + getName);// 增加属性
			$('.l2').hide();
			$(".l1 > a").click(
					function() {
						$(this).addClass("current").next().show().parent()
								.siblings().children("a")
								.removeClass("current").next().hide();
						return false;
					});
		   $('#teacherAdd').click(function (){
			   $('#iframe2').attr("src", "../jsp/teacherAdd.jsp");
		   });

			$('#studentInfo').click(function() {
				$('#iframe2').attr("src", "../jsp/Student.jsp");// 增加属性

			});
			$('#teacherInfo').click(function() {
				$('#iframe2').attr("src", "../jsp/Teacher.jsp");// 增加属性

			});
			$('#radioQuestionsInfo').click(function() {
				$('#iframe2').attr("src", "../jsp/choiceSub.jsp?type=1");// 增加属性

			});
			$('#addRaQuestionsInfo').click(function() {
				$('#iframe2').attr("src", "../jsp/addRaQuestions.jsp");// 增加属性

			});
			$('#addChQuestionsInfo').click(function() {
				$('#iframe2').attr("src", "../jsp/addChQuestions.jsp");// 增加属性

			});
			$('#checkQuestionsInfo').click(function() {
				$('#iframe2').attr("src", "../jsp/choiceSub.jsp?type=2");// 增加属性

			});
			$('#zujuan').click(function() {
				$('#iframe2').attr("src", "../jsp/zujuan.jsp");// 增加属性

			});
			$('#zujuanInfo').click(function() {
				$('#iframe2').attr("src", "../jsp/zujuanInfo.jsp");// 增加属性

			});
			$('#out').click(function() {
				window.location.href = "../../jsp/login.jsp";

			});

		});