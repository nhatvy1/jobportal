<%-- 
    Document   : jobposting
    Created on : Aug 24, 2022, 9:27:29 AM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="container">
    <h1 class="text-center">Đăng bài tuyển dụng</h1>
    <div class="card">
        <c:url value="/jobposting" var="action"/>
        <form:form method="post" action="${action}" enctype="multipart/form-data" modelAttribute="posting" class="p-5">
            <div class="form-group">
                <label for="name">Job Title</label>
                <form:input path="name" class="form-control"/>
            </div>
            <div class="form-group">
                <label for="description">Description</label>
                <form:input type="text" path="description" class="form-control"/>
            </div>
            <div class="form-group">
                <label for="experience">Experience</label>
                <form:input type="text" path="experience" class="form-control"/>
            </div>
            <div class="form-group">
                <label for="salary">Salary</label>
                <form:input type="text" path="salary" class="form-control"/>
            </div>
            <div class="form-group">
                <label for="jobLocation">Job Location</label>
                <form:input type="text" path="jobLocation" class="form-control"/>
            </div>
            <div class="form-group">
                <label for="jobLocation">Image</label>
                <form:input type="file" path="file" class="form-control"/>
            </div>
            <div class="form-group">
                <label for="jobCategoryId">Job Category</label>
                <form:select path="jobCategoryId" class="form-control w-100 mb-20">
                    <c:forEach items="${jobCategories}" var="cate">
                        <form:option value="${cate.id}">${cate.name}</form:option>
                    </c:forEach>
                </form:select>
            </div>
            <input type="submit" value="Dang bai" class="btn"/>
        </form:form>
    </div>
</div>