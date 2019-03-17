<%--
  Created by IntelliJ IDEA.
  User: xcheng
  Date: 2019/3/10
  Time: 22:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="title" value="杭州二手房" />
<c:set var="home" value="home" />
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>${title}</title>
    <!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="/css/style.css" rel="stylesheet">
    <link href="/css/bootstrap-theme.css.css" rel="stylesheet">
    <link href="/css/bootstrap.css" rel="stylesheet">
  </head>

  <body>
  <div class="container" >
    <table class="table table-hover table-striped">
      <thead>
      <tr>
        <th scope="col">#</th>
        <th scope="col">房屋描述</th>
        <th scope="col">位置</th>
        <th scope="col">层高</th>
        <th scope="col">年限</th>
        <th scope="col">朝向</th>
        <th scope="col">大小</th>
        <th scope="col">总价格</th>
        <th scope="col">区域</th>
        <th scope="col">户型</th>
        <th scope="col">单价</th>
      </tr>
      </thead>
      <tbody>
      <jsp:useBean id="houses" scope="request" type="java.util.List"/>
      <c:forEach items="${houses}" var="c" varStatus="vs">
        <tr>
          <th scope="row">${c.id}</th>
          <td>${c.description}</td>
          <td>${c.location}</td>
          <td>${c.high}</td>
          <td>${c.year}</td>
          <td>${c.orient}</td>
          <td>${c.meter}</td>
          <td>${c.totalPrice}</td>
          <td>${c.zone}</td>
          <td>${c.area}</td>
          <td>${c.unitPrice}</td>
        </tr>
      </c:forEach>
      </tbody>
    </table>
  </div>

  <%@include file="adminPage.jsp" %>

  <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
  <script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
  <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>
  </body>
</html>
