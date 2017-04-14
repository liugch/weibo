<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>所有的用户</title>
    <link rel="stylesheet" href="/css/bootstrap.min.css">
</head>
<body>

<jsp:include page="/WEB-INF/view/public/header.jsp" flush="true"></jsp:include>

<h3 style="margin-top: 80px">

    ${users}
</h3>

<c:forEach items="${users}" var="u" varStatus="status">
    <div class="media">
        <a class="pull-left" href="/users/${u.id}">
            <img class="media-object" src="${u.toux}" alt="頭像">
        </a>
        <div class="media-body">
            <a href="/users/${u.id}">${u.name}</a>
        </div>
    </div>
    <hr>
</c:forEach>


<%--<div class="container" style="margin-top: 60px">
    <div class="row" style="margin-bottom: 60px">
        <div class="page-header col-md-offset-2 col-md-8" style="text-align: center; ">
            <h1>发现神之奥妙世界!</h1>
            <h3>想要发现更多的好友尽情的关注,发微博吧!</h3>
            <h5>I'm crazy......</h5>
        </div>
    </div>
    <div class="row">
        <div class="col-md-8 col-md-offset-2">
            <div>
                <ul class="pager">
                    <li class="previous"><a href="#">&larr; Older</a></li>
                    <li class="next"><a href="#">Newer &rarr;</a></li>
                </ul>
            </div>
            <c:if test="${users ne null}">
                <c:forEach items="${users}" var="u" varStatus="status">
                    <div class="media">
                        <a class="pull-left" href="/users/${u.id}">
                            <img class="media-object" src="${u.toux}" alt="頭像">
                        </a>
                        <div class="media-body">
                            <a href="/users/${u.id}">${u.name}</a>
                        </div>
                    </div>
                    <hr>
                </c:forEach>
            </c:if>
            <c:if test="${users eq null}">
                <div class="media">
                    <h3>暂时还没有用户</h3>
                </div>
            </c:if>
            <div>
                <ul class="pager">
                    <li class="previous"><a href="#">&larr; Older</a></li>
                    <li class="next"><a href="#">Newer &rarr;</a></li>
                </ul>
            </div>
        </div>
    </div>
</div>--%>

<script src="/js/jquery.js"></script>
<script src="/js/bootstrap.min.js"></script>

<script>
    //    function guanzhu(masterid, forlowedid) {
    //        alert(masterid + "," + forlowedid);
    //        $.ajax({
    //            method: 'POST',
    //            url: '/users/' + masterid,
    //            data: {"masterid": masterid, "folowedid": forlowedid},
    //            success: function (data) {
    //                //alert(data);
    //            }
    //        });
    //    }
    //    ;

</script>
</body>
</html>

