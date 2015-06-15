<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:h="http://java.sun.com/jsf/html"
      xmlns:f="http://java.sun.com/jsf/core"
      xmlns:ui="http://java.sun.com/jsf/facelets">
 
 <f:view>     
    <h:head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title>Day Calculator Input</title>
        
        <!-- <h:outputScript name="js/jquery-ui.js"/>
        <h:outputScript>
           $(function() {
	          $( "#datepicker,#datepicker1" ).datepicker();
	       });
        </h:outputScript>

        <h:outputStylesheet target="head" name="css/jquery-ui.css" /> -->
    </h:head>
    
    <h:body>
        <h1>Day Calculator Input</h1>
<%--         <jsp:useBean scope="page" class="sheridan.DayCalculator"/> --%>
        <h2>Today Date:</h2>
        ${dayCalculator.date} or ${dayCalculator.dateDisplay}
        <form action="result.jsp">
            <h2>Start Date:</h2>
            <p><input name="date" 
                      value="${dayCalculator.date}"/></p>
            <h2>Number of Days to Add:</h2>
            <p><input type="text" name="days"/></p>
            <h2>Get the Calculated Date</h2>
            <p><input type="submit" value="Calculate"/></p>
        </form>
    </h:body>
</f:view>
</html>
