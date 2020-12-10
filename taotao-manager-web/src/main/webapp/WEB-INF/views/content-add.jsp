<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="/js/jquery-easyui-1.4.1/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="/js/jquery-easyui-1.4.1/themes/icon.css" />
<link rel="stylesheet" type="text/css" href="/css/taotao.css" />
<script type="text/javascript" src="/js/jquery-easyui-1.4.1/jquery.min.js"></script>
<script type="text/javascript" src="/js/jquery-easyui-1.4.1/jquery.easyui.min.js"></script>
<script type="text/javascript" src="/js/jquery-easyui-1.4.1/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="/js/common.js"></script>

<link href="/js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="/js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="/js/kindeditor-4.1.10/lang/zh_CN.js"></script>

<title>新增内容</title>
</head>
<body>
<div style="padding:10px 10px 10px 10px">
	<form id="contentAddForm" class="itemForm" method="post">
		<input type="hidden" name="categoryId"/>
	    <table cellpadding="5">
	        <tr>
	            <td>内容标题:</td>
	            <td><input class="easyui-textbox" type="text" name="title" data-options="required:true" style="width: 280px;"></input></td>
	        </tr>
	        <tr>
	            <td>内容子标题:</td>
	            <td><input class="easyui-textbox" type="text" name="subTitle" style="width: 280px;"></input></td>
	        </tr>
	        <tr>
	            <td>内容描述:</td>
	            <td><input class="easyui-textbox" name="titleDesc" data-options="multiline:true,validType:'length[0,150]'" style="height:60px;width: 280px;"></input>
	            </td>
	        </tr>
	         <tr>
	            <td>URL:</td>
	            <td><input class="easyui-textbox" type="text" name="url" style="width: 280px;"></input></td>
	        </tr>
	        <tr>
	            <td>图片:</td>
	            <td>
	                <a href="javascript:void(0)" class="easyui-linkbutton onePicUpload">图片上传</a>
	                <br><input type="hidden" name="pic" />
	            </td>
	        </tr>
	        <tr>
	            <td>图片2:</td>
	            <td>
	            	<a href="javascript:void(0)" class="easyui-linkbutton onePicUpload">图片上传</a>
	            	<br><input type="hidden" name="pic2" />
	            </td>
	        </tr>
	        <tr>
	            <td>内容:</td>
	            <td>
	                <textarea style="width:700px;height:300px;visibility:hidden;" name="content"></textarea>
	            </td>
	        </tr>
	    </table>
	</form>
	<div style="padding:5px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()">提交</a>
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()">重置</a>
	</div>
</div>
<script type="text/javascript">
	//编辑器参数
	kingEditorParams = {
		filePostName  : "uploadFile",   
		uploadJson : '/rest/pic/upload',	
		dir : "image" 
	};

	var contentAddEditor ;
	$(function(){
		//创建富文本编辑器
		contentAddEditor =  KindEditor.create("#contentAddForm [name=content]", kingEditorParams);
		//初始化单图片上传
		initOnePicUpload();
		//把内容分类id放到input中，提交到后台
		$("#contentAddForm [name=categoryId]").val($("#contentCategoryTree").tree("getSelected").id);
	});
	
	//提交逻辑
	function submitForm(){
		//校验
		if(!$('#contentAddForm').form('validate')){
			$.messager.alert('提示','表单还未填写完成!');
			return ;
		}
		contentAddEditor.sync();
		
		//提交到后台的RESTful
		$.ajax({
		   type: "POST",
		   url: "/rest/content",
		   data: $("#contentAddForm").serialize(),
		   success: function(msg){
			   $.messager.alert('提示','新增内容成功!');
 						$("#contentList").datagrid("reload");
 						TT.closeCurrentWindow();
		   },
		   error: function(){
			   $.messager.alert('提示','新增内容失败!');
		   }
		});
	}
	
	function clearForm(){
		$('#contentAddForm').form('reset');
		contentAddEditor.html('');
	}
	
	function initOnePicUpload(){
    	$(".onePicUpload").click(function(){
			var input = $(this).siblings("input");
			KindEditor.editor(kingEditorParams).loadPlugin('image', function() {
				this.plugin.imageDialog({
					showRemote : false,
					clickFn : function(url, title, width, height, border, align) {
						input.parent().find("img").remove();
						input.val(url);
						input.after("<a href='"+url+"' target='_blank'><img src='"+url+"' width='80' height='50'/></a>");
						this.hideDialog();
					}
				});
			});
		});
    }
			
			
</script>
</body>
</html>
