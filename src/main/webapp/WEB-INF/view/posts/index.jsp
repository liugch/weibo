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
    ${session_posts}
    <br>
    ${session_bymasterid}

</h3>--%>

<c:if test="${info ne null}">
    <div class="container" style="margin-top: 90px">
        <div class="row">
            <div class="span12">
                <div class="alert alert-info">
                    <button type="button" class="close alert-dismissable"  data-dismiss="alert">×</button>
                    <h4>
                        提示!<strong>${info}</strong>
                    </h4>
                </div>
            </div>
        </div>
    </div>
</c:if>

<div class="container" style="margin-top: 110px">
    <div class="row">
        <aside class="col-md-4">
            <section class="user_info">
                <a href="/users/${session_user.id}">
                    <img alt="${session_user.name==null?true:false}" class="gravatar" src="${session_user.toux}"/>

                </a>
                <h1>${session_user.name == null? "" : session_user.name}</h1>
                <span><a href="/users/${session_user.id}">查看主页</a></span>

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
                    <a href="/users/${session_user.id}/myblog">
                        <strong class="stat">

                            <c:if test="${session_user.postss ne null}">
                                ${session_user.postss.size()}
                            </c:if>
                            <c:if test="${session_user.postss eq null}">
                                0
                            </c:if>
                        </strong>
                        微博
                    </a>
                </div>

            </section>
            <section class="post_form">
                <form class="new_post" id="new_post" enctype="multipart/form-data" action="/posts/${session_user.id}"
                      accept-charset="UTF-8" method="post">
                    <div class="field">
                        <textarea placeholder="发布新微博..." name="content" id="post_content"></textarea>
                    </div>
                    <input type="submit" name="commit" value="发布" class="btn btn-primary" data-disable-with="发布"/>

                    <span class="picture">
                        <input accept="image/jpeg,image/gif,image/png" type="file" name="picfile" id="post_picture"/>
                    </span>
                </form>
                <script type="text/javascript">
                    $('#post_picture').bind('change', function () {
                        var size_in_megabytes = this.files[0].size / 1024 / 1024;
                        if (size_in_megabytes > 5) {
                            alert('文件的最大限制是 5M, 请重新选择');
                        }
                    });
                </script>
            </section>
        </aside>

        <div class="col-md-8">
            <h3>微博动态</h3>
            <c:if test="${session_posts ne null}">
                <c:forEach items="${session_posts}" var="p" varStatus="status">
                    <ol class="posts">
                        <li id="post-${p.id}">

                            <a href="/users/">
                                <img alt="" class="gravatar" src="${p.user.toux}"/>
                            </a>

                            <span class="user">
                              <a href="/users/">${p.user.name}</a>
                        </span>
                            <span class="timestamp">
                        ${p.crateTime}

                        </span>
                            <span class="content">
                                    ${p.content}
                            </span>
                            <span class="content">
                            <img src="${p.pic}">
                        </span>
                        </li>
                    </ol>
                </c:forEach>
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
