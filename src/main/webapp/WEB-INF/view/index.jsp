<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>首页</title>
    <link rel="stylesheet" href="/css/bootstrap.min.css">
</head>

<body>

<jsp:include page="/WEB-INF/view/public/header.jsp" flush="true"></jsp:include>

<c:if test="${activate eq null}">
    <div class="container-fluid" style="margin-top:80px">
            <div class="row-fluid">
                <div class="span12">
                    <div class="alert alert-info">
                        <button type="button" class="close" data-dismiss="alert">×</button>
                        <h4>提示!</h4>
                        请前往你邮箱进行激活账号
                    </div>
                </div>
            </div>
        </div>
</c:if>

<div class="container clearfix" style="margin-top:100px;text-align: center">
    <div class="jumbotron">
        <h1>欢迎使用Myblog！</h1>
        <p>小老鼠，上灯台，偷油吃，下不来！发条微博叫人来。</p>
        <p><a href="/regist" class="btn btn-primary btn-lg" role="button"> 立刻注册！</a>
        </p>
    </div>
</div>

<script src="/js/jquery.js"></script>
<script src="/js/bootstrap.min.js"></script>
</body>
</html>
