<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta http-equiv="Access-Control-Allow-Origin" content="*">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <title><decorator:title default="seavisual"></decorator:title></title>
    <decorator:head></decorator:head>
</head>

<body>
   <span style="text-align: right;">hello , welcome ${user.name }</span>
    <hr>
    <decorator:body></decorator:body>
    <hr>
    <span style="text-align: center;">copyright seavisual</span>
</body>
</html>