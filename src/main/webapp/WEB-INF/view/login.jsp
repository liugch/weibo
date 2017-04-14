<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>用户登录</title>
    <link rel="stylesheet" href="/css/bootstrap.min.css">
</head>
<body>

<jsp:include page="/WEB-INF/view/public/header.jsp" flush="true"></jsp:include>
<div class="container" style="margin-top:60px">
    <h1 style="text-align: center">登录</h1>
    <div class="row">
        <div class="col-md-offset-3 col-md-6">
            <form:form action="/login" method="post" modelAttribute="user">
                <div class="alert alert-danger alert-dismissable hide" id="alerts">
                    <button type="button" class="close" data-dismiss="alert"
                            aria-hidden="true">
                        &times;
                    </button>
                    <p>错误！请进行一些更改。</p>
                    <form:errors element="p" path="*">

                    </form:errors>
                </div>
                <div class="form-group">
                    <label for="mail">邮箱</label>
                    <form:input type="email" id="mail" path="mail" class="form-control" placeholder="请输入您的邮箱"/>
                </div>
                <div class="form-group">
                    <label for="pwd">密码</label>
                    <form:input type="password" path="pwd" id="pwd" class="form-control" placeholder="请输入您密码"/>
                </div>
                <div class="form-group">
                    <button class="btn btn-primary btn-block" type="submit">我要登录</button>
                </div>
            </form:form>
        </div>
    </div>
</div>


<script src="/js/jquery.js"></script>
<script src="/js/bootstrap.min.js"></script>

<script type="text/javascript">
    // $("#alerts").removeClass("hide");
</script>
</body>
</html>
