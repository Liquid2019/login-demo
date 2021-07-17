<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>title</title>
    <!-- Bootstrap -->
    <link rel="stylesheet" href="static/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js" integrity="sha384-nvAa0+6Qg9clwYCGGPpDQLVpLNn0fRaROjHqs13t4Ggj3Ez50XnGQqc/r8MhnRDZ" crossorigin="anonymous"></script>
    <script src="static/js/bootstrap.min.js"></script>
</head>
<body>
<h1>登陆</h1>
<form class="form-horizontal" action="${pageContext.request.contextPath}/LoginServlet">
    <div class="form-group">
        <label class="col-sm-2 control-label">username</label>
        <div class="col-sm-10">
            <input class="form-control" id="inputEmail3" placeholder="username" name="username">
        </div>
    </div>
    <div class="form-group">
        <label for="inputPassword3" class="col-sm-2 control-label">Password</label>
        <div class="col-sm-10">
            <input type="password" class="form-control" id="inputPassword3" placeholder="Password" name="password">
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <div class="checkbox">
                <label>
                    <input type="checkbox"> Remember me
                </label>
            </div>
        </div>
    </div>
    <div>
        checkcode<input type="text" name="checkCode">
        <a href="javascript:refreshCode()">
            <img id="vcode" title="刷新" src="${pageContext.request.contextPath}/CheckCodeServlet">
        </a>
    </div>
    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <button type="submit" class="btn btn-default">Sign in</button>
        </div>
    </div>
<%--    <div><%--%>
<%--        out.print(request.getAttribute("login_msg"));--%>
<%--    %></div>--%>
    <div>${login_msg}</div>
</form>
</body>
<script>
    function refreshCode() {
        var img = document.getElementById("vcode");
        img.src="${pageContext.request.contextPath}/CheckCodeServlet?time="+new Date().getTime();
    }
</script>
</html>
