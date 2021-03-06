<%@ page import="by.akimova.TP_lab_servlet.FirstServlet" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">

    <title>Calculate</title>
</head>
<body>
<h1 class="text-center"><%= "Вариант 1" %>
<h1 class="text-center"><%= "3ИТ-7 Акимова Анастасия" %>
</h1>
<h1>
    <div class="text-center"><%= "Welcome to Calculator App" %></div>
</h1>
<br/>
<form method="post" action="${pageContext.request.contextPath}/CalculateServlet">
    <fieldset>
<div class="container">
    <div class="row">
        <div class="col">

            <input name="num1" type="text" class="form-control" aria-label="Sizing example input"
                   aria-describedby="inputGroup-sizing-lg" placeholder="Enter first number ">
        </div>
        <div class="col">
            <select name="parameters" class="form-select form-select-lg mb-1" aria-label=".form-select-lg example">
                <option selected>Select option</option>
                <option value="+">+</option>
                <option value="-">-</option>
                <option value="*">*</option>
                <option value="/">/</option>
            </select>
        </div>
        <div class="col">
            <input name="num2" type="text" class="form-control" aria-label="Sizing example input"
                   aria-describedby="inputGroup-sizing-lg" placeholder="Enter second number ">
        </div>
    </div>
</div>
<div class="text-center">
    <button value="calculate" type="submit" class="btn btn-success btn-lg text-center">Calculate</button>
</div>
</fieldset>
</form>

<h1 class="text-center">${!empty(error)?err:str}</h1>

</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
        integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.min.js"
        integrity="sha384-Atwg2Pkwv9vp0ygtn1JAojH0nYbwNJLPhwyoVbhoPwBhjQPR5VtM2+xf0Uwh9KtT"
        crossorigin="anonymous"></script>

</html>