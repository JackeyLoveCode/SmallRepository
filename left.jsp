<!DOCTYPE html>
<%@page pageEncoding="utf-8"%>
<%
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
 %>
<html>
	<head>
	<base href=<%=basePath %>>
		<title>left.html</title>
		<meta content="text/html;charset='gb2312'"/>
	</head>
	<body>
		<ul>
			<li>境内业务管理
				<ul>
					<li>基本信息登记
						<ul>
							<li>企业投资人信息登记
								<ul>
									<li><a href="basicInfo/OrgList.jsp" target="f3">录入</a></li>
								</ul>
							</li>
						</ul>
					</li>
					<li>
						<ul>
							<li>企业外汇信息登记
								<ul>
									<li>新设外商企业登记
										<ul>
											<li><a href="foreignExchange/EntView.jsp" target="f3">录入</a></li>
										</ul>
									</li>
								</ul>
							</li>

						</ul>
					</li>
					<li>核准管理
							<ul>
								<li>资本金账户管理
									<ul>
										<li>资本金账户开户核准
											<ul>
												<li><a href="author/inputOrg.jsp" target="f3">录入</a></li>
											</ul>
										</li>
									</ul>
								</li>
							</ul>
					</li>
					<li>银行登记管理
							<ul>
								<li><a href=" bankAuthor/inputAuthorCode.jsp" target="f3">银行核准类信息反馈</a></li>
							</ul>
					</li>
				</ul>
			
			</li>
			<li>系统管理
				<ul>
					<li><a href="user_pageQuery.action" target="f3">用户管理</a></li>
				</ul>
			</li>
		</ul>
	</body>
</html>