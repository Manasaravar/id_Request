<%@ page import="org.klozevitz.lesson_08.model.Notepad" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Arrays" %>
<%@ page import="java.util.stream.Collectors" %>
<%@ page import="java.lang.reflect.Field" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/style.css">
</head>
<body>
<div class="container">
  <div class="modal">


    <% Notepad notepad = (Notepad) request.getAttribute("id");%>
    <form class = "requestForm" method="get" action="${pageContext.request.contextPath}/id">
      <br>
      <label align="center"> Введите запрос
        <br>
        ID: <input name="id"  type="number" min=1 />
      </label>
      <br>
      <input type="submit" value="Добавить" />
    </form>
    <table class="responseTable" align="center">
<%--      <%! List<String> nameHead = Arrays.stream(Notepad.class.getDeclaredFields())--%>
<%--              .map(Field::getName)--%>
<%--              .collect(Collectors.toList()); %>--%>
      <thead>
<%--      <%for (String name: nameHead) {%>--%>
      <tr>
<%--        <th><%=name%></th>--%>
        <th class="cell">Id</th>
        <th class="cell">Brand</th>
        <th class="cell">Model</th>
        <th class="cell">PageAmount</th>
        <th class="cell">Cover</th>
        <th class="cell">Country</th>
        <th class="cell">PageType</th>
      </tr>
<%--      <%}%>--%>

      </thead>
      <tbody>
      <%if (notepad != null) {%>
      <tr>
        <td class="cell"><%=notepad.getId()%></td>
        <td class="cell"><%=notepad.getBrand()%></td>
        <td class="cell"><%=notepad.getModel()%></td>
        <td class="cell"><%=notepad.getPageAmount()%></td>
        <td class="cell"><%=notepad.getCover()%></td>
        <td class="cell"><%=notepad.getCountry()%></td>
        <td class="cell"><%=notepad.getPageType()%></td>
      </tr>
      <%}%>
      </tbody>
    </table>
  </div>
</div>
</body>
</html>
