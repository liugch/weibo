<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>

</head>
<body>
<header class="navbar navbar-fixed-top navbar-inverse ">
    <div class="container">
        <div class="navbar-header">
            <a href="/index" class="navbar-brand" style="">Myblog</a>
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
        </div>

        <div class="collapse navbar-collapse" id="navbar-collapse">
            <ul class="nav navbar-nav navbar-right" style="margin-top:0">
                <li class="active"><a href="/index"> 首页</a></li>
                <li><a href="/login">登录</a></li>
                <li><a href="/regist">注册</a></li>
                <li class="dropdown">
                    <c:if test="${session_user ne null}">
                        <a class="dropdown-toggle" data-toggle="dropdown">
                                ${session_user.name}<b class="caret"></b>
                        </a>
                        <ul class="dropdown-menu">
                            <li><a href="/users/${session_user.id}">个人主页</a></li>
                            <li><a href="/users/${session_user.id}/edit">修改资料</a></li>
                            <li class="divider"></li>
                            <li>
                                <a rel="nofollow" data-method="delete" href="/logout">注销</a>
                            </li>
                        </ul>
                    </c:if>
                </li>
            </ul>
        </div>
    </div>
</header>
</body>
</html>
