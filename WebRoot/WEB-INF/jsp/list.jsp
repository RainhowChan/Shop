<%@ page pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- saved from url=(0048)http://localhost:8080/mango/product/list/1.jhtml -->
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

	<title>蔬菜 - Powered By Mango Team</title>
	<meta name="author" content="Mango Team">
		<meta name="copyright" content="Mango">
			<meta name="keywords" content="蔬菜">
				<meta name="description" content="蔬菜">
					<link href="${pageContext.request.contextPath}/css/common.css"
						rel="stylesheet" type="text/css">
						<link href="${pageContext.request.contextPath}/css/product.css"
							rel="stylesheet" type="text/css">
</head>
<body>
	<div class="container header">
		<div class="span5">
			<div class="logo">
				<a href="${pageContext.request.contextPath}/index"> <img
					src="${pageContext.request.contextPath}/image/r___________renleipic_01/logo.gif"
					alt="传智播客"></a>
			</div>
		</div>
		<div class="span9">
			<div class="headerAd">
				<img src="${pageContext.request.contextPath}/image/header.jpg"
					width="320" height="50" alt="正品保障" title="正品保障">
			</div>
		</div>
		<%@ include file="header.jsp"%>

		<%@ include file="menu.jsp"%>

	</div>
	<div class="container productList">
		<div class="span6">
			<div class="hotProductCategory">
				<s:iterator value="categories" var="category">
					<dl>
						<dt>
							<a href="${pageContext.request.contextPath}/image/蔬菜 - Powered By Mango Team.htm"><s:property value="#category.cname" /></a>
						</dt>
						<s:iterator value="#category.categorySeconds" var="c">
							<dd>
								<a><s:property value="#c.csname" /></a>
							</dd>
						</s:iterator>
					</dl>
				</s:iterator>
			</div>
		</div>
		<div class="span18 last">

			<form id="productForm"
				action="${pageContext.request.contextPath}/image/蔬菜 - Powered By Mango Team.htm"
				method="get">
				<input type="hidden" id="brandId" name="brandId" value=""> <input
					type="hidden" id="promotionId" name="promotionId" value="">
						<input type="hidden" id="orderType" name="orderType" value="">
							<input type="hidden" id="pageNumber" name="pageNumber" value="1">
								<input type="hidden" id="pageSize" name="pageSize" value="20">

									<div id="result" class="result table clearfix">
										<ul>
										<s:iterator value="pageBean.list" var="p">
										<li>
											<a href="./京华亿家分页面.htm"> 
												<img src="${pageContext.request.contextPath}/<s:property value="#p.image"/>"
													width="170" height="170" style="display: inline-block;"/>
												<span style='color:green'><s:property value="#p.pname"/> </span> <span class="price">亿家价： ￥<s:property value="#p.market_price"/>/份 </span>
											</a>
										</li>
										</s:iterator>
											
											
										</ul>
									</div>
									<div class="pagination">
										<span class="firstPage">&nbsp;</span> <span
											class="previousPage">&nbsp;</span> <span class="currentPage">1</span>
										<a href="javascript: $.pageSkip(2);">2</a> <a class="nextPage"
											href="javascript: $.pageSkip(2);">&nbsp;</a> <a
											class="lastPage" href="javascript: $.pageSkip(2);">&nbsp;</a>
									</div>
			</form>
		</div>
	</div>
	<div class="container footer">
		<div class="span24">
			<div class="footerAd">
				<img src="${pageContext.request.contextPath}/image/footer.jpg"
					width="950" height="52" alt="我们的优势" title="我们的优势">
			</div>
		</div>
		<div class="span24">
			<ul class="bottomNav">
				<li><a>关于我们</a> |</li>
				<li><a>联系我们</a> |</li>
				<li><a>诚聘英才</a> |</li>
				<li><a>法律声明</a> |</li>
				<li><a>友情链接</a> |</li>
				<li><a target="_blank">支付方式</a> |</li>
				<li><a target="_blank">配送方式</a> |</li>
				<li><a>SHOP++官网</a> |</li>
				<li><a>SHOP++论坛</a></li>
			</ul>
		</div>
		<div class="span24">
			<div class="copyright">Copyright © 2005-2013 Mango商城 版权所有</div>
		</div>
	</div>
</body>
</html>