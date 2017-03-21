<#macro header>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<link id="easyuiTheme" href="<@m.path/>/easyui/themes/metro-blue/easyui.css" rel="stylesheet" type="text/css" />
    <link href="<@m.path/>/easyui/themes/icon.css" rel="stylesheet" type="text/css" />
    <link href="<@m.path/>/easyui/icons/icon-all.css" rel="stylesheet" type="text/css" />
    <script src="<@m.path/>/easyui/jquery-1.11.0.js" type="text/javascript"></script>

    <script src="<@m.path/>/easyui/jquery-easyui-1.3.5/jquery.easyui.min.js" type="text/javascript"></script>
    <script src="<@m.path/>/easyui/jquery-easyui-datagridview/datagrid-detailview.js" type="text/javascript"></script>
    <script src="<@m.path/>/easyui/jquery-easyui-1.3.5/locale/easyui-lang-zh_CN.js" type="text/javascript"></script>
    <script src="<@m.path/>/easyui/jeasyui-extensions/jquery.jdirk.js" type="text/javascript"></script>
    <link  href="<@m.path/>/easyui/jeasyui-extensions/jeasyui.extensions.css" rel="stylesheet" type="text/css" />

    <script src="<@m.path/>/easyui/jeasyui-extensions/jeasyui.extensions.js" type="text/javascript"></script>
    <script src="<@m.path/>/easyui/jeasyui-extensions/jeasyui.extensions.linkbutton.js" type="text/javascript"></script>
    <script src="<@m.path/>/easyui/jeasyui-extensions/jeasyui.extensions.validatebox.js" type="text/javascript"></script>
    <script src="<@m.path/>/easyui/jeasyui-extensions/jeasyui.extensions.combo.js" type="text/javascript"></script>
    <script src="<@m.path/>/easyui/jeasyui-extensions/jeasyui.extensions.combobox.js" type="text/javascript"></script>
    <script src="<@m.path/>/easyui/jeasyui-extensions/jeasyui.extensions.form.js" type="text/javascript"></script>
    <script src="<@m.path/>/easyui/jeasyui-extensions/jeasyui.extensions.menu.js" type="text/javascript"></script>
    <script src="<@m.path/>/easyui/jeasyui-extensions/jeasyui.extensions.searchbox.js" type="text/javascript"></script>
    <script src="<@m.path/>/easyui/jeasyui-extensions/jeasyui.extensions.panel.js" type="text/javascript"></script>
    <script src="<@m.path/>/easyui/jeasyui-extensions/jeasyui.extensions.window.js" type="text/javascript"></script>
    <script src="<@m.path/>/easyui/jeasyui-extensions/jeasyui.extensions.dialog.js" type="text/javascript"></script>
    <script src="<@m.path/>/easyui/jeasyui-extensions/jeasyui.extensions.layout.js" type="text/javascript"></script>
    <script src="<@m.path/>/easyui/jeasyui-extensions/jeasyui.extensions.tree.js" type="text/javascript"></script>
    <script src="<@m.path/>/easyui/jeasyui-extensions/jeasyui.extensions.datagrid.js" type="text/javascript"></script>
    <script src="<@m.path/>/easyui/jeasyui-extensions/jeasyui.extensions.treegrid.js" type="text/javascript"></script>
    <script src="<@m.path/>/easyui/jeasyui-extensions/jeasyui.extensions.combogrid.js" type="text/javascript"></script>
    <script src="<@m.path/>/easyui/jeasyui-extensions/jeasyui.extensions.combotree.js" type="text/javascript"></script>

    <script src="<@m.path/>/easyui/icons/jeasyui.icons.all.js" type="text/javascript"></script>
    <script src="<@m.path/>/easyui/jeasyui-extensions/jeasyui.extensions.icons.js" type="text/javascript"></script>
    <script src="<@m.path/>/easyui/jeasyui-extensions/jquery-easyui-toolbar/jquery.toolbar.js" type="text/javascript"></script>
    <script src="<@m.path/>/easyui/jeasyui-extensions/jquery-easyui-comboicons/jquery.comboicons.js" type="text/javascript"></script>
    <script src="<@m.path/>/easyui/jeasyui-extensions/jeasyui.extensions.gridselector.js" type="text/javascript"></script>
    <script src="<@m.path/>/easyui/jeasyui-extensions/jquery-easyui-comboselector/jquery.comboselector.js" type="text/javascript"></script>
    <script src="<@m.path/>/easyui/jeasyui-extensions/jquery-easyui-my97/WdatePicker.js" type="text/javascript"></script>
    <script src="<@m.path/>/easyui/jeasyui-extensions/jquery-easyui-my97/jquery.my97.js" type="text/javascript"></script>
    <script src="<@m.path/>/easyui/jeasyui-extensions/jquery-easyui-portal/jquery.portal.js" type="text/javascript"></script>
    <script type="text/javascript" src="<@m.path/>/easyui/jquery.cookie.js"></script>
    <style type="text/css">
        .ftitle{  
            font-size:14px;  
            font-weight:bold;  
            padding:5px 0;  
            margin-bottom:10px;  
            border-bottom:1px solid #ccc;  
        }  
        .fitem{  
            margin-bottom:5px;  
        }  
        .fitem label{  
            display:inline-block;  
            width:80px;  
        }  
    </style>
    
    <script type="text/javascript">
   		 $(function(){
			$("body").after("<script type='text/javascript'>$(function(){$('body').css('visibility','visible');});<\/script>");
			var $easyuiTheme = $('#easyuiTheme');
			var url = $easyuiTheme.attr('href');
			var href = url.substring(0, url.indexOf('themes')) + 'themes/' + $.cookie('easyuiThemeName') + '/easyui.css';
			$easyuiTheme.attr('href', href);
		});
		function confirm(title,text,callback) {
			$.messager.defaults = {ok:"确定",cancel: "取消"};
        	$.messager.confirm(title, text, function(r) {
            	if (r) {
            		callback();
            	}
        	});
		}
		
		function show(message) {
			$.messager.show({
				title : '消息',
				msg : message,
				timeout : 4000,
				showType : 'show'
			});
		}
	</script>
</#macro>
<!--设置datagrid自动适应页面宽度和高度-->
<#macro resize viewname='datagrid' viewid='dg'>
	<script type="text/javascript">
		$(function(){
			$("body").after("<script type='text/javascript'>$(function(){$('body').show();});<\/script>");
			$("body").height($(window).height());
			$("body").width($(window).width());
			$(window).resize(function() {
				$("body").height($(window).height());
				$("body").width($(window).width());
				$('#${viewid}').${viewname}('resize');
			});
		});
	</script>
</#macro>
<!--平台名称配置-->
<#macro sysname>
	西安邮电大学快速应用开发平台<#nested>
</#macro>

<!--登陆页面名称-->
<#macro loginsysname>
	西安邮电大学<br>快速应用开发平台
</#macro>
<!--登陆页面底部-->
<#macro loginfooter>
	快速应用开发平台v3.0 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  Copyright &copy; 2014 <a href="http://www.xiyou.edu.cn" target="_blank">西安邮电大学 http://www.xiyou.edu.cn</a>
</#macro>
<!--平台logo配置   大小 50*50  png格式-->
<#macro syslogo><@m.path/>/images/logo/logo.png<#nested>
</#macro>
<#macro path>${Application['path']}</#macro>
<#macro footer>
	Copyright &copy;2014 西安邮电大学 (快速应用开发平台3.0)
	<#nested>
	<#nested>
	<#nested>
</#macro>

<!--编辑器需要的js文件-->
<#macro kindeditor>
	<link rel="stylesheet" type="text/css" href="<@m.path/>/source/kindeditor/themes/default/default.css"/>
    <script type="text/javascript" src="<@m.path/>/source/kindeditor/lang/zh_CN.js"></script>
    <script type="text/javascript" src="<@m.path/>/source/kindeditor/kindeditor-min.js"></script>
</#macro>
<!--打印需要的js文件-->
<#macro lodop>
    <script type="text/javascript" src="<@m.path/>/source/lodopPrint/LodopFuncs.js"></script>
	<object id="LODOP_OB" classid="clsid:2105C259-1E0C-4534-8141-A753534CB4CA" width=0 height=0>
		<embed id="LODOP_EM" type="application/x-print-lodop" width=0 height=0 pluginspage="<@m.path/>/source/lodopPrint/install_lodop32.exe"></embed>
	</object>
</#macro>
<!--artdiag需要的js文件-->
<#macro artdialog>
	<link rel="stylesheet" type="text/css" href="<@m.path/>/source/artDialog/skins/default.css" />
	<script type="text/javascript" src="<@m.path/>/source/artDialog/artDialog.js"></script>
    <script type="text/javascript" src="<@m.path/>/source/artDialog/iframeTools.js"></script>
    <script type="text/javascript" src="<@m.path/>/source/artDialog/artDialog.plugins.min.js"></script> 
</#macro>
<!--系统首页地址-->
<#macro homepage>
	http://www.xiyou.edu.cn
</#macro>
<#macro plupload>
	<link type="text/css" rel="stylesheet" href="<@m.path/>/source/plupload/bootstrap.css" media="screen" />
	<link type="text/css" rel="stylesheet" href="<@m.path/>/source/plupload/font-awesome.min.css" media="screen" />
	<link type="text/css" rel="stylesheet" href="<@m.path/>/source/plupload/my.css" media="screen" />
	<link type="text/css" rel="stylesheet" href="<@m.path/>/source/plupload/prettify.css" media="screen" />
	<link type="text/css" rel="stylesheet" href="<@m.path/>/source/plupload/shCore.css" media="screen" />
	<link type="text/css" rel="stylesheet" href="<@m.path/>/source/plupload/shCoreEclipse.css" media="screen" />
	<link type="text/css" rel="stylesheet" href="<@m.path/>/source/plupload/jquery-ui.min.css" media="screen" />
	<link type="text/css" rel="stylesheet" href="<@m.path/>/source/plupload/jquery.ui.plupload.css" media="screen" />
	<script type="text/javascript" src="<@m.path/>/source/plupload/jquery.js" charset="UTF-8"></script>
	<script type="text/javascript" src="<@m.path/>/source/plupload/bootstrap.js" charset="UTF-8"></script>
	<script type="text/javascript" src="<@m.path/>/source/plupload/shCore.js" charset="UTF-8"></script>
	<script type="text/javascript" src="<@m.path/>/source/plupload/shBrushPhp.js" charset="UTF-8"></script>
	<script type="text/javascript" src="<@m.path/>/source/plupload/shBrushjScript.js" charset="UTF-8"></script>
	<script type="text/javascript" src="<@m.path/>/source/plupload/jquery-ui.min.js" charset="UTF-8"></script>
	<script type="text/javascript" src="<@m.path/>/source/plupload/plupload.full.min.js" charset="UTF-8"></script>
	<script type="text/javascript" src="<@m.path/>/source/plupload/jquery.ui.plupload.js" charset="UTF-8"></script>
	<script type="text/javascript" src="<@m.path/>/source/plupload/themeswitcher.js" charset="UTF-8"></script>
</#macro>
<#macro CommApplet>
<!--"CONVERTED_APPLET"-->
	<!-- HTML CONVERTER -->
	<OBJECT id="CommApplet" name="CommApplet" classid="clsid:8AD9C840-044E-11D1-B3E9-00805F499D93"
		WIDTH="0" HEIGHT="0"
		codebase="http://java.sun.com/update/1.6.0/jinstall-6u17-windows-i586.cab#Version=6,0,0,4"
		MAYSCRIPT>
		<PARAM NAME=CODE VALUE="xiyou.applet.CommApplet.class">
		<PARAM NAME=CODEBASE VALUE="<@m.path/>/comm">
		<PARAM NAME=ARCHIVE VALUE="comm.jar,xy.jar">
		<PARAM NAME="type" VALUE="application/x-java-applet;version=1.6">
		<PARAM NAME="scriptable" VALUE="true">
		<COMMENT> <EMBED
			type="application/x-java-applet;version=1.6"
			CODE="xiyou.applet.CommApplet.class" CODEBASE="<@m.path/>/comm"
			ARCHIVE="comm.jar,xy.jar" WIDTH="0" HEIGHT="0" scriptable=true id="CommApplet" name="CommApplet"
			pluginspage="http://java.sun.com/products/plugin/index.html#download">
			<NOEMBED> </NOEMBED>
		</EMBED> </COMMENT>
	</OBJECT>
	<!--"END_CONVERTED_APPLET"-->
</#macro>