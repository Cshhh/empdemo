<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>addEmp</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/r/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/r/css/style.css">
</head>
<body>
<div class="container">
    <div class="row head"></div>
    <div class="row body">
        <form class="form-horizontal" id="updateEmpForm" action="${pageContext.request.contextPath}/emp/updateEmp" method="post">
            <input type="hidden" value="${emp.id}" name="id" >
            <div class="form-group">
                <label for="name" class="col-sm-2 control-label">姓名</label>
                <div class="col-sm-6">
                    <input type="text" class="form-control" id="name" placeholder="name" name="name" value="${emp.name}">
                </div>
                <div class="col-sm-2" id="checkname">
                </div>
            </div>
            <div class="form-group">
                <label for="phone" class="col-sm-2 control-label">电话</label>
                <div class="col-sm-6">
                    <input type="text" class="form-control" id="phone" placeholder="phone" name="phone" value="${emp.phone}">
                </div>
                <div class="col-sm-2" id="checkphone">
                </div>
            </div>
            <div class="form-group">
                <label for="sex" class="col-sm-2 control-label">性别</label>
                <div class="col-sm-6">
                    <label>
                        <input type="radio" name="sex" <c:if test="${emp.sex=='男'}">checked</c:if> value="男" >
                        男
                    </label>
                    <label>
                        <input type="radio" name="sex" <c:if test="${emp.sex=='女'}">checked</c:if> value="女">
                        女
                    </label>
                </div>
            </div>
            <div class="form-group">
                <label for="salary" class="col-sm-2 control-label">工资</label>
                <div class="col-sm-6">
                    <input type="text" class="form-control" id="salary" placeholder="salary" name="salary" value="${emp.salary}">
                </div>
                <div class="col-sm-2" id="checksalary"></div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">部门</label>
                <div class="col-sm-6">
                    <select class="form-control" name="dept_id">
                        <c:forEach items="${deptlist}" var="dept">
                            <option <c:if test="${dept.id==emp.dept_id}">selected="selected"</c:if>value="${dept.id}">${dept.dname}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button type="button" class="btn btn-default sub">Sign in</button>
                </div>
            </div>
        </form>
    </div>
    <div class="row foot"></div>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/r/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/r/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript">
    $(function () {
        var isname=true;
        var isphone=true;
        var issalary=true;
        $("#name").blur(function () {
            var name = $("#name").val();
            var reg =/^[\u4e00-\u9fa5]{2,4}$/
            if (reg.test(name)){
                $("#checkname").html("√");
                isname=true;
            }else {
                $("#checkname").html("请输入2-4位中文");
                isname=false;
            }
        })
        $("#phone").blur(function () {
            var phone=$("#phone").val();
            var reg=/^[1][3,4,5,7,8][0-9]{9}$/;
            if (reg.test(phone)){
                $("#checkphone").html("√");
                isphone=true;
            }else {
                $("#checkphone").html("请输入11位国内手机号码");
                isphone=false;
            }
        })
        $("#phone").keyup(function () {
            $("#phone").val($("#phone").val().replace(/[^\d]/g,""));
        });
        $("#salary").keyup(function () {
            $("#salary").val($("#salary").val().replace(/[^\d]/g,""));
        });
        $("#salary").blur(function () {
            var salary = $("#salary").val();
            var reg = /^[0-9]{2,6}$/
            if (reg.test(salary)){
                $("#checksalary").html("√");
                issalary=true;
            }else {
                $("#checksalary").html("请输入2-6位月薪");
                issalary=false;
            }
        })
        $(".sub").click(function () {
            if (issalary && isphone && isname) {
                $("#updateEmpForm").submit();
            }else {
                alert("请检查输入框错误");
            }
        })
    })
</script>
</body>
</html>