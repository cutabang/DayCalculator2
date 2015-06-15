<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Day Calculator Result</title>
    </head>
    <body>
        <h1>Day Calculator Result</h1>
        <jsp:useBean id="calculator" scope="page" class="sheridan.DayCalculator"/>
        <h2>Today Date:</h2>
        ${calculator.date} or ${calculator.dateDisplay}
        <h2>Start Date:</h2>
        <jsp:setProperty name="calculator" property="*"/>
        ${calculator.date} or ${calculator.dateDisplay}
        <h2>Days Added:</h2>
        <% String days = request.getParameter("days"); %>
        <%= days %>
        <% calculator.addDays(days); %>
        <h2>Result Date:</h2>
        ${calculator.date} or ${calculator.dateDisplay}
        <p><a href=".">Back to the Calculator</a></p>
    </body>
</html>
 