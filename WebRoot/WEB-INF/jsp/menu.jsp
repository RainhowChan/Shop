<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="span24">
		<ul class="mainNav">
					<li>
						<a href="${pageContext.request.contextPath }/index">首页</a>
						|
					</li>
					<s:iterator value="#session.categories" var="category">
						<li>
							<a href="${pageContext.request.contextPath }/product_findByCid.action?cid=<s:property value="#category.cid"/>&page=1"><s:property value="#category.cname"/></a>
							|
						</li>
					</s:iterator>
		</ul>
	</div>
