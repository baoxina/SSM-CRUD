<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Employee List</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/bootstrap-3.3.7-dist/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<!-- 标题行 -->
		<div class="row">
			<div class="col-md-12">SSM</div>
		</div>
		<!-- 按钮行 -->
		<div class="row">
			<div class="col-md-4 col-md-offset-8">
				<button type="button" class="btn btn-primary btn-sm">新增</button>
				<button type="button" class="btn btn-danger btn-sm">删除</button>
			</div>
		</div>
		<!-- 表格行 -->
		<div class="row">
			<div class="col-md-12">
				<table class="table table-hover">
					<tr>
						<th><input class="checkbox" type="checkbox"></th>
						<th>ID</th>
						<th>姓名</th>
						<th>性别</th>
						<th>邮箱</th>
						<th>部门</th>
						<th>操作</th>
					</tr>
					
					<c:forEach items="${pageInfo.list }" var="emp">
						<tr>
							<td><input class="checkbox" type="checkbox"></td>
							<td>${emp.empId }</td>
							<td>${emp.empName }</td>
							<td>${emp.gender == "M" ? "男" : "女" }</td>
							<td>${emp.email }</td>
							<td>${emp.department.deptName }</td>
							<td>
								<button type="button" class="btn btn-primary btn-sm">
									<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>编辑
								</button>
								<button type="button" class="btn btn-danger btn-sm">
									<span class="glyphicon glyphicon-trash" aria-hidden="true"></span>删除
								</button>
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
		<!-- 分页栏行 -->
		<div class="row">
			<div class="col-md-6">
				当前第${pageInfo.pageNum }页,共有${pageInfo.pages }页,总计${pageInfo.total }条记录
			</div>
			<div class="col-md-6">
				<nav aria-label="Page navigation">
				  <ul class="pagination">
				  	<c:if test="${pageInfo.pageNum > 1 }">
					  	<li><a href="${pageContext.request.contextPath }/emp/getEmps/1">首页</a></li>
				  	</c:if>
				  	<c:if test="${pageInfo.hasPreviousPage }">
					    <li>
					      <a href="${pageContext.request.contextPath }/emp/getEmps/${pageInfo.pageNum - 1 }" aria-label="Previous">
					        <span aria-hidden="true">&laquo;</span>
					      </a>
					    </li>
				  	</c:if>
				  	<c:forEach items="${pageInfo.navigatepageNums }" var="page_num">
				  		<c:if test="${page_num == pageInfo.pageNum}">
						    <li class="active"><a href="${pageContext.request.contextPath }/emp/getEmps/${page_num}">${page_num }</a></li>
				  		</c:if>
				  		<c:if test="${page_num != pageInfo.pageNum}">
				  			<li><a href="${pageContext.request.contextPath }/emp/getEmps/${page_num}">${page_num }</a></li>
				  		</c:if>
				  	</c:forEach>
				    <c:if test="${pageInfo.hasNextPage }">
					    <li>
					      <a href="${pageContext.request.contextPath }/emp/getEmps/${pageInfo.pageNum + 1 }" aria-label="Next">
					        <span aria-hidden="true">&raquo;</span>
					      </a>
					    </li>
				    </c:if>
				    <c:if test="${pageInfo.pageNum != pageInfo.pages}">
					    <li><a href="${pageContext.request.contextPath }/emp/getEmps/${pageInfo.pages}">末页</a></li>
				    </c:if>
				  </ul>
				</nav>
			</div>
		</div>
	</div>
</body>
</html>