<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="span10 last">
		<div class="topNav clearfix">
			<ul>
				<s:if test="#session.existUser != null">
					<li class="headerLogin" style="display: list-item;">
						<a href="#">${sessionScope.existUser.username }</a>|<!-- 进入个人中心 -->
					</li>
					<li class="headerLogin" style="display: list-item;">
						<a href="${pageContext.request.contextPath }/user_exit">退出</a>|<!-- 进入个人中心 -->
					</li>
				</s:if>
				<s:else>
					<li id="headerLogin" class="headerLogin" style="display: list-item;">
						<a href="${pageContext.request.contextPath}/user_loginPage.action">登录</a>|
					</li>
					<li id="headerRegister" class="headerRegister" style="display: list-item;">
						<a href="${pageContext.request.contextPath}/user_registPage.action">注册</a>|
					</li>
				</s:else>
				<li id="headerUsername" class="headerUsername"></li>
				<li id="headerLogout" class="headerLogout">
					<a>[退出]</a>|
				</li>
						<li>
							<a>会员中心</a>
							|
						</li>
						<li>
							<a>购物指南</a>
							|
						</li>
						<li>
							<a>关于我们</a>
							
						</li>
			</ul>
		</div>
		<div class="cart">
			<a  href="./购物车.htm">购物车</a>
		</div>
			<div class="phone">
				客服热线:
				<strong>96008/53277764</strong>
			</div>
	</div>
