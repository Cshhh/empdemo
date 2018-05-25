<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>deptlist</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/r/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/r/css/style.css">
</head>
<body>
    <div class="container">
        <div class="row head"></div>
        <div class="row">
            <table class="table table-striped table-hover">
                <thead>
                    <tr>
                        <th><input type="checkbox"></th>
                        <th>#</th>
                        <th>部门</th>
                        <th>地点</th>
                        <th>操作</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${pageInfo.list}" var="dept" varStatus="index">
                        <tr>
                            <td><input type="checkbox"></td>
                            <td>${index.index + 1}</td>
                            <td>${dept.dname}</td>
                            <td>${dept.location}</td>
                            <td>
                                <button type="button" class="btn btn-info">修改</button>
                                <button type="button" class="btn btn-danger">删除</button>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        <div class="row">
            <div class="col-sm-9">
                <button type="button" class="btn btn-primary">增加</button>
                <button type="button" class="btn btn-danger">删除</button>
            </div>
            <div class="col-sm-3">
                <nav aria-label="Page navigation">
                    <ul class="pagination">
                        <li<c:if test="${pageInfo.pageNum==1}">class="disabled"</c:if>>
                            <a href="${pageContext.request.contextPath}/dept/deptlist?pageNum=${pageInfo.prePage}" aria-label="Previous">
                                <span aria-hidden="true">&laquo;</span>
                            </a>
                        </li>


                        <li class="active"><a href="#">1</a></li>

                        <c:if test="${pageInfo.pageNum!=pageInfo.pages}">
                            <li class="disabled">
                                <a href="${pageContext.request.contextPath}/dept/deptlist?pageNum=${pageInfo.nextPage}" aria-label="Next" >
                                    <span aria-hidden="true">&raquo;</span>
                                </a>
                            </li>
                        </c:if>
                        <c:if test="${pageInfo.pageNum==pageInfo.pages}">
                            <li class="disabled">
                                <a href="javascript:;" aria-label="Next" >
                                    <span aria-hidden="true">&raquo;</span>
                                </a>
                            </li>
                        </c:if>
                    </ul>
                </nav>
            </div>
        </div>
        <div class="row foot"></div>
    </div>
    <script type="text/javascript" src="${pageContext.request.contextPath}/r/js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/r/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
