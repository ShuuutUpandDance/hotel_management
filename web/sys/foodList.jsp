﻿<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<!-- 包含公共的JSP代码片段 -->
	
<title>无线点餐平台</title>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="${pageContext.request.contextPath}/sys/style/js/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/sys/style/js/page_common.js"></script>
<link href="${pageContext.request.contextPath}/sys/style/css/common_style_blue.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/sys/style/css/index_1.css" />
</head>
<body>
<!-- 页面标题 -->
<div id="TitleArea">
	<div id="TitleArea_Head"></div>
	<div id="TitleArea_Title">
		<div id="TitleArea_Title_Content">
			<img border="0" width="13" height="13" src="${pageContext.request.contextPath}/sys/style/images/title_arrow.gif"/> 菜品列表
		</div>
    </div>
	<div id="TitleArea_End"></div>
</div>


	<!-- 过滤条件 -->
	<div id="QueryArea">
		<form action="${pageContext.request.contextPath}/food" method="get">
			<input type="hidden" name="method" value="search">
			<input type="text" name="keyword" title="请输入菜品名称">
			<input type="submit" value="搜索">
		</form>
	</div>
<!-- 主内容区域（数据列表或表单显示） -->
<div id="MainArea">
    <table class="MainArea_Content" align="center" cellspacing="0" cellpadding="0">
        <!-- 表头-->
        <thead>
            <tr align="center" valign="middle" id="TableTitle">
				<td>菜编号</td>
				<td>菜名</td>
				<td>所属菜系</td>
				<td>价格</td>
                <td>会员价格</td>
				<td>操作</td>
			</tr>
		</thead>	
		<!--显示数据列表 -->
        <tbody id="TableData">
			<c:choose>
				<c:when test="${not empty requestScope.pageBean.pageData}">
					<c:forEach var="food" items="${requestScope.pageBean.pageData}" varStatus="vs">
						<tr class="TableDetail1">
							<td>${vs.count}</td>
							<td>${food.foodName}</td>
							<td>${food.typeName}</td>
							<td>${food.price}</td>
							<td>${food.mprice}</td>
							<td>
								<a href="${pageContext.request.contextPath}/food?method=viewUpdate&id=${food.id}" class="FunctionButton">更新</a>
								<a href="${pageContext.request.contextPath}/food?method=delete&id=${food.id}" onClick="return delConfirm();"class="FunctionButton">删除</a>
							</td>
						</tr>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<tr>
						<td colspan="6">对不起！数据库中没有数据！</td>
					</tr>
				</c:otherwise>
			</c:choose>

			<tr>
				<td colspan="6">
					当前${requestScope.pageBean.currentPage}/${requestScope.pageBean.totalPage}页
					&nbsp;&nbsp;
					<a href="${pageContext.request.contextPath}/food?currentPage=1&method=list">
						[首页]
					</a>
					<a href="${pageContext.request.contextPath}/food?currentPage=${requestScope.pageBean.currentPage-1}&method=list">
						[上一页]
					</a>
					<a href="${pageContext.request.contextPath}/food?currentPage=${requestScope.pageBean.currentPage+1}&method=list">
						[下一页]
					</a>
					<a href="${pageContext.request.contextPath}/food?currentPage=${requestScope.pageBean.totalPage}&method=list">
						[末页]
					</a>
				</td>
			</tr>
        </tbody>
    </table>

   <!-- 其他功能超链接 -->
	<div id="TableTail" align="center">
		<div class="FunctionButton"><a href="${pageContext.request.contextPath}/food?method=viewSave">添加</a></div>
    </div> 
</div>
</body>
</html>
