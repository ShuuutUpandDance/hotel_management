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
</head>
<body>

<!-- 页面标题 -->
<div id="TitleArea">
	<div id="TitleArea_Head"></div>
	<div id="TitleArea_Title">
		<div id="TitleArea_Title_Content">

					<img border="0" width="13" height="13" src="${pageContext.request.contextPath}/sys/style/images/title_arrow.gif"/> 更新新菜品
			
		</div>
    </div>
	<div id="TitleArea_End"></div>
</div>

<!-- 主内容区域（数据列表或表单显示） -->
<div id="MainArea">
	<!-- 表单内容 -->
	<form action="${pageContext.request.contextPath}/food?method=update" method="post" enctype="multipart/form-data" accept-charset="UTF-8">
		<input type="hidden" name="Id" value="${requestScope.food.id}">
		<!-- 本段标题（分段标题） -->
		<div class="ItemBlock_Title">
        	<img width="4" height="7" border="0" src="${pageContext.request.contextPath}/sys/style/images/item_point.gif"> 菜品信息&nbsp;
        </div>
		<!-- 本段表单字段 -->
        <div class="ItemBlockBorder">
            <div class="ItemBlock">
				<div class="ItemBlock2">
					<table cellpadding="0" cellspacing="0" class="mainForm">
                    <tr>
							<td width="80px">菜系</td>
							<td>
                            <select name="FoodType_id" style="width:80px">
								<!--先把目标的菜系显示在选框里-->
								<c:forEach var="foodType" items="${requestScope.foodTypeList}">
									<c:if test="${foodType.id == requestScope.food.foodType_id}">
										<option value="${requestScope.food.foodType_id}" selected="selected">
												${foodType.typeName}
										</option>
									</c:if>
								</c:forEach>
								<!--再显示剩下的-->
								<c:choose>
									<c:when test="${not empty requestScope.foodTypeList}">
										<c:forEach var="foodType" items="${requestScope.foodTypeList}">
											<c:if test="${foodType.id != requestScope.food.foodType_id}">
												<option value="${foodType.id}">
													${foodType.typeName}
												</option>
											</c:if>
										</c:forEach>
									</c:when>
									<c:otherwise>
										<option selected="selected">没有数据！</option>
									</c:otherwise>
								</c:choose>
                            </select>*
                             <%--<input type="hidden" name="id" value="1" />--%>
							</td>
						</tr>
						<tr>
							<td width="80px">菜名</td>
							<td><input type="text" name="FoodName" class="InputStyle" value="${requestScope.food.foodName}"/> *</td>
						</tr>
						<tr>
							<td>价格</td>
							<td><input type="text" name="Price" class="InputStyle" value="${requestScope.food.price}"/> *</td>
						</tr>
                        <tr>
							<td>会员价格</td>
							<td><input type="text" name="Mprice" class="InputStyle" value="${requestScope.food.mprice}"/> *</td>
						</tr>
						
						<tr>
							<td>简介</td>
							<td><textarea name="Remark" class="TextareaStyle">${requestScope.food.remark}</textarea></td>
						</tr>
						<tr>
							<td width="80px">菜品图片</td>
							<td>
								<%--<c:choose>--%>
									<%--<c:when test="${not empty requestScope.food.img}">--%>
										<%--<img style='max-width:68px;width:68px;width:expression(width>68?"68px":width "px");max-width: 68px;'--%>
											 <%--src="E:/hotel_img/${requestScope.food.img}">--%>
										<%--&lt;%&ndash;<img src="E:/hotel_img/${requestScope.food.img}">&ndash;%&gt;--%>
									<%--</c:when>--%>
									<%--<c:otherwise>--%>
										<%--对不起，没有图片！--%>
									<%--</c:otherwise>--%>
								<%--</c:choose>--%>
								<input type="hidden" name="Img" value="${requestScope.food.img}">
								<%--<input type="file" name="imgUrl"/> *--%>
							</td>
						</tr>
					</table>
				</div>
            </div>
        </div>
		
		
		<!-- 表单操作 -->
		<div id="InputDetailBar">
				
					 <input type="submit" value="修改" class="FunctionButtonInput">

            <a href="javascript:history.go(-1);" class="FunctionButton">返回</a>
        </div>
	</form>
</div>
</body>
</html>
