<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
	<%--<script type="text/javascript">--%>
		<%--setInterval(function(){--%>
			<%--window.location.href = "/wirelessplatform/client.html?method=list";--%>
		<%--},1000 * 50);--%>
	<%--</script>--%>
	<style type="text/css">
		table td{
			text-align: center;
		}
	</style>
</head>
<body>
	<!-- 页面标题 -->
	<div id="TitleArea">
		<div id="TitleArea_Head"></div>
		<div id="TitleArea_Title">
			<div id="TitleArea_Title_Content">
				<img border="0" width="13" height="13"
					src="${pageContext.request.contextPath}/sys/style/images/title_arrow.gif" /> 餐厅订单列表
			</div>
		</div>
		<div id="TitleArea_End"></div>
	</div>

	<!-- 主内容区域（数据列表或表单显示） -->
	<div id="MainArea">
		<table class="MainArea_Content" align="center" cellspacing="0" cellpadding="0">
			<!-- 表头-->
			<thead>
				<tr align="center" valign="middle" id="TableTitle">
					<td>订单编号</td>
					<td>餐桌名</td>
					<td>下单日期</td>
					<td>总金额</td>
					<td>状态</td>
					<td>操作</td>
				</tr>
			</thead>
			<!--显示数据列表 -->
			<tbody id="TableData">
				<c:choose>
					<c:when test="${not empty requestScope.orderList}">
						<c:forEach var="order" items="${requestScope.orderList}">
							<tr height="60">
								<td>${order.id}</td>
								<td>${order.tableName}</td>
								<td>${order.orderDate}</td>
								<td>${order.totalPrice}</td>
								<c:if test="${order.orderStatus == 0}">
									<td>未结账&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
								</c:if>
								<c:if test="${order.orderStatus == 1}">
									<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
								</c:if>
								<td>
									<a href="${pageContext.request.contextPath}/orderDetail?method=list&orderId=${order.id}" class="FunctionButton">详细</a>

									<c:if test="${order.orderStatus == 0}">
										<a href="${pageContext.request.contextPath}/orders?method=checkOut&id=${order.id}" class="FunctionButton">结账</a>
									</c:if>
								</td>
							</tr>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<tr height="60">
							<td colspan="6" align="center">对不起！数据库中没有数据！</td>
						</tr>
					</c:otherwise>
				</c:choose>
			 	
			</tbody>
		</table>
		<!-- 其他功能超链接 -->
		<div id="TableTail" align="center">
		</div>
	</div>
</body>
</html>
