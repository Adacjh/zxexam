<!DOCTYPE>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Trumbowyg by Alex-D</title>

<link rel="stylesheet" href="trumbowyg/design/css/trumbowyg.css">
<script type="text/javascript" src="../js/jquery-1.7.2.js"></script>
<script type="text/javascript" src="../js/updateChQuestion.js"></script>
<script type="text/javascript" src="../js/bootstrap.min.js"></script>
<link rel="stylesheet" href="../css/bootstrap.min.css" />
<link rel="stylesheet" href="../css/addQuestions.css" />
<style type="text/css">
html, body {
	margin: 0;
	padding: 0;
	background-color: #F2F2F2;
	font-family: "Trebuchet MS", Verdana, Arial, Helvetica, sans-serif;
}

header {
	text-align: center;
}

#main {
	max-width: 960px;
	margin: 0 auto;
}

</style>

</head>

<body>

	<div id="main" role="main">
		<form id="submitform">
		<input type="hidden" id="hiddenId" name="checkId" value="<%=request.getParameter("id")%>">
			<div id="simple-editor">

			</div>		
			<table>
			<tr><td colspan="3"><h1>请添加选项</h1>
			<input type="hidden" id="xianshi" name="checkContent"/>
			</td></tr>
			<tr>
			<td>选项A:&nbsp;&nbsp;</td>
			<td align="center"><input type="checkbox" name="checkAnswer" id="A" value="A"/></td>
			<td><input placeholder="请输入选项A" type="text" class="text" name="checkAnswerA" id="checkAnswerA"/></td>
			</tr>
			<tr>
			<td>选项B:&nbsp;&nbsp;</td>
			<td align="center"><input type="checkbox" name="checkAnswer" value="B" id="B"/></td>
			<td><input placeholder="请输入选项B" type="text" class="text" name="checkAnswerB" id="checkAnswerB"/></td>
			</tr>
			<tr>
			<td>选项C:&nbsp;&nbsp;</td>
			<td align="center"><input type="checkbox" name="checkAnswer" value="C" id="C"/></td>
			<td><input placeholder="请输入选项C" type="text" class="text" name="checkAnswerC" id="checkAnswerC"/></td>
			</tr>
			<tr>
			<td>选项D:&nbsp;&nbsp;</td>
			<td align="center"><input type="checkbox" name="checkAnswer" value="D" id="D"/></td>
			<td><input placeholder="请输入选项D" type="text" class="text" name="checkAnswerD" id="checkAnswerD"/></td>
			</tr>
			
			<tr>
			<td>难度：&nbsp;&nbsp;</td>
			<td>
			<select name="checkDifficulty" id="checkDifficulty">
			<option value="1" id="jian">简单</option>   
			<option value="2" id="kun">困难</option>   
			</select>
			</td>
			</tr>
			<tr>
			<td>科目：&nbsp;&nbsp;</td>
			<td>
			<select name="checkSubName" id="checkSubName">
			</select>
			</td>
			</tr>
			<tr>
			<td colspan="3" id="td1" align="right"><button type="button" class="btn btn-primary" id="save">保存</button></td>
			
			</tr> 
			</table>
			
		</form>
		

	</div>

	

	<script src="trumbowyg/trumbowyg.js"></script>

	<script src="trumbowyg/langs/fr.js"></script>

	<script src="trumbowyg/plugins/upload/trumbowyg.upload.js"></script>

	<script src="trumbowyg/plugins/base64/trumbowyg.base64.js"></script>

	<script>
		/** Default editor configuration **/

		$('#simple-editor').trumbowyg();

		/********************************************************

		 * Customized button pane + buttons groups + dropdowns

		 * Use upload plugin

		 *******************************************************/

		/*

		 * Add your own groups of button

		 */

		$.trumbowyg.btnsGrps.test = [ 'bold', 'link' ];

		/* Add new words for customs btnsDef just below */

		$.extend(true, $.trumbowyg.langs, {

			fr : {

				align : 'Alignement',

				image : 'Image'

			}

		});

		$('#customized-buttonpane').trumbowyg(
				{

					lang : 'fr',

					closable : true,

					fixedBtnPane : true,

					btnsDef : {

						// Customizables dropdowns

						align : {

							dropdown : [ 'justifyLeft', 'justifyCenter',
									'justifyRight', 'justifyFull' ],

							ico : 'justifyLeft'

						},

						image : {

							dropdown : [ 'insertImage', 'upload', 'base64' ],

							ico : 'insertImage'

						}

					},

					btns : [ 'viewHTML',

					'|', 'formatting',

					'|', 'btnGrp-test',

					'|', 'align',

					'|', 'btnGrp-lists',

					'|', 'image' ]

				});

		/** Simple customization with current options **/

		$('#form-content').trumbowyg({

			lang : 'fr',

			closable : true,

			mobile : true,

			fixedBtnPane : true,

			fixedFullWidth : true,

			semantic : true,

			resetCss : true,

			autoAjustHeight : true,

			autogrow : true

		});

		$('.editor').on('dblclick', function(e) {

			$(this).trumbowyg({

				lang : 'fr',

				closable : true,

				fixedBtnPane : true

			});

		});
	</script>

</body>

</html>

