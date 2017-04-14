<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>微博列表</title>
    <link rel="stylesheet" href="/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/posts_index.css">
    <link rel="stylesheet" href="/css/custom.css">
</head>
<script>
    function deletePost(id) {
        $.ajax({
            method: 'delete',
            url: 'users/' + id,
            dataType: 'text',
            success: function (data) {
                if (data == "success") {
                    alert("删除成功");
                    location.reload();
                }
            }
        });
    }
</script>
<body>

<jsp:include page="/WEB-INF/view/public/header.jsp" flush="true"/>
<%--
<h3 style="margin-top: 90px">
    ${session_user}
    <br>
    ${session_relationshipList1}
    <br>
    ${session_relationshipList2}
    <br>
    ${session_bymasterid}

</h3>--%>
<div class="container" style="margin-top: 110px">
    <div class="row">
        <aside class="col-md-4">
            <section class="user_info">
                <a href="/users/${session_user.id}">
                    <img alt="${session_user.name==null?true:false}" class="gravatar" src="${session_user.toux}"/>

                </a>
                <h1>${session_user.name == null? "" : session_user.name}</h1>
                <span><a href="/users/${session_user.id}">查看主页</a></span>

                <span>共
                     <c:if test="${session_bymasterid ne null}">
                         ${session_bymasterid.size()}
                     </c:if>
                     <c:if test="${session_bymasterid eq null}">
                         0
                     </c:if>
                     则微博
                 </span>

            </section>
            <section class="stats">
                <div class="stats">
                    <a href="/users/${session_user.id}/following">
                        <strong id="following" class="stat">
                            <c:if test="${session_relationshipList1 ne null}">
                                ${session_relationshipList1.size()}
                            </c:if>
                            <c:if test="${session_relationshipList1 eq null}">
                                0
                            </c:if>
                        </strong>
                        关注
                    </a>
                    <a href="/users/${session_user.id}/followers">
                        <strong id="followers" class="stat">
                            <c:if test="${session_relationshipList2 ne null}">
                                ${session_relationshipList2.size()}
                            </c:if>
                            <c:if test="${session_relationshipList2 eq null}">
                                0
                            </c:if>
                        </strong>
                        粉丝
                    </a>
                    <a href="/users/${session_user.id}">
                        <strong class="stat">
                            <c:if test="${session_bymasterid ne null}">
                                ${session_bymasterid.size()}
                            </c:if>
                            <c:if test="${session_bymasterid eq null}">
                                0
                            </c:if>
                        </strong>
                        微博
                    </a>
                </div>

            </section>

        </aside>

        <div class="col-md-8">
            <h3>微博(${session_bymasterid.size()})</h3>
            <c:if test="${session_bymasterid ne null}">
                <c:forEach items="${session_bymasterid}" var="post" varStatus="status">
                    <div class="media">
                        <a class="pull-left" href="/users/${session_user.id}">
                            <img class="media-object" src="${session_user.toux}" alt="頭像"/>
                        </a>
                        <div class="media-body">
                            <a href="/users/${session_user.id}">${session_user.name}</a>

                            <p>${post.crateTime}
                                <a href="javascript:void(0)" onclick="deleteUser(${post.id})">delete</a>
                            </p>
                            <p><img class="media-object" src="${post.pic}"/></p>
                            <p>${post.content}</p>

                        </div>
                    </div>
                    <hr>
                </c:forEach>
            </c:if>
            <c:if test="${users eq null}">
                <div class="media">
                    <h3>暂时没有微博!</h3>
                </div>
            </c:if>
        </div>
    </div>
</div>

<script src="/js/jquery.js"></script>
<script src="/js/bootstrap.min.js"></script>
<script>

</script>
</body>
</html>
