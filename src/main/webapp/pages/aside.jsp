<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	 <aside id="box2">	
	 		<ul>
                <li id="l_top"><a href="${pageContext.request.contextPath}/pages/main.jsp">功能菜单</a></li>
                <li class="bottom 1"><a href="${pageContext.request.contextPath}/user/findUseList"> <i class="bottom_1 cli">用户管理</i></a></li>
                <li class="bottom 1"><a href="${pageContext.request.contextPath}/pages/list-book.jsp"> <i class="bottom_1 cli">好书查找</i></a></li>
                <li class="bottom 1"><a href="${pageContext.request.contextPath}/findbook/recom"> <i class="bottom_1 cli">每日推荐</i></a></li>
                <li class="bottom 1"><a href="${pageContext.request.contextPath}/user/manager"> <i class="bottom_1 cli">其他管理</i></a></li>
                 
               </ul> 
        </aside>--%>
 <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%> 
<%@taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<aside class="main-sidebar">
	<!-- sidebar: style can be found in sidebar.less -->
	<section class="sidebar">
		<!-- Sidebar user panel -->
		<div class="user-panel">
			<div class="pull-left image">
				<img src="${pageContext.request.contextPath}/img/touxiang.jpg"
					class="img-circle" alt="User Image">
			</div>
			<div class="pull-left info">
				<p><security:authentication property="principal.username"/></p>
				<a href="#"><i class="fa fa-circle text-success"></i> 在线</a>
			</div>
		</div>

		<!-- sidebar menu: : style can be found in sidebar.less -->
		<ul class="sidebar-menu">
			<li class="header">菜单</li>
			<li id="admin-index"><a
				href="${pageContext.request.contextPath}/pages/main.jsp"><i
					class="fa fa-dashboard"></i> <span>首页</span></a></li>

			<li class="treeview"><a href="#"> <i class="fa fa-cogs"></i>
					<span>系统管理</span> <span class="pull-right-container"> <i
						class="fa fa-angle-left pull-right"></i>
				</span>


			</a>
				<ul class="treeview-menu">

					<li id="system-setting">
					<security:authorize access="hasRole('ADMIN')">
					<a
						href="${pageContext.request.contextPath}/user/findUseList"> <i
							class="fa fa-circle-o"></i> 用户管理
					</a>
					</security:authorize>
					</li>
					<li id="system-setting"><a
						href="${pageContext.request.contextPath}/findbook/allbook"> <i
							class="fa fa-circle-o"></i> 好书查找
					</a></li>
					<li id="system-setting"><a
						href="${pageContext.request.contextPath}/findbook/recom">
							<i class="fa fa-circle-o"></i> 图书推荐
					</a></li>
					<li id="system-setting">
					<security:authorize access="hasRole('ADMIN')">
					<a
						href="${pageContext.request.contextPath}/sysLog/findAllHis"> <i
							class="fa fa-circle-o"></i> 访问日志
					</a>
					</security:authorize>
					</li>
				</ul></li>
			<li class="treeview"><a href="#"> <i class="fa fa-cube"></i>
					<span>基础数据</span> <span class="pull-right-container"> <i
						class="fa fa-angle-left pull-right"></i>
				</span>
			</a>
				<ul class="treeview-menu">
					<li id="system-setting"><a
						href="${pageContext.request.contextPath}/pages/chart-show.jsp"> <i
							class="fa fa-circle-o"></i> 图书分类
					</a></li>

				</ul></li>

		</ul>
	</section>
	<!-- /.sidebar -->
</aside>