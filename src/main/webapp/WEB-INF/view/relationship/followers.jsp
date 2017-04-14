<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/posts_index.css">
    <link rel="stylesheet" href="/css/custom.css">
</head>
<body>


<jsp:include page="/WEB-INF/view/public/header.jsp" flush="true"/>

<div class="container" style="margin-top: 110px">
    <div class="row">
        <aside class="col-md-4">
            <section class="user_info">
                <a href="/users/${session_user.id}">
                    <img alt="${session_user.name==null?true:false}" class="gravatar" src="${session_user.toux}"/>

                </a>
                <h1>${session_user.name == null? "" : session_user.name}</h1>
                <span><a href="/users/${session_user.id}">查看主页</a></span>
                <span>共 ${session_posts.size()} 则微博</span>

            </section>
            <section class="stats">
                <div class="stats">
                    <a href="/users/${id}/following">
                        <strong id="following" class="stat">
                            ${session_relationshipList1.size()}
                        </strong>
                        关注
                    </a>
                    <a href="/users/${id}/followers">
                        <strong id="followers" class="stat">
                            ${session_relationshipList2.size()}
                        </strong>
                        粉丝
                    </a>
                    <a href="/users/${id}/followers">
                        <strong class="stat">
                            ${session_posts.size()}
                        </strong>微博
                    </a>
                </div>

            </section>
        </aside>

        <div class="col-md-8">
            <h3>我的粉丝</h3>
            <c:forEach items="${session_posts}" var="p" varStatus="status">

            </c:forEach>
        </div>
    </div>
</div>

<script src="/js/jquery.js"></script>
<script src="/js/bootstrap.min.js"></script>
<script>
    $(function () {
    });
</script>
</body>
</html>
