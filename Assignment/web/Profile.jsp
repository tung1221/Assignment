<%-- 
    Document   : editProduct
    Created on : 24-Apr-2023, 2:55:04 AM
    Author     : HLC
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <!------ Include the above in your HEAD tag ---------->
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <nav class="navbar navbar-expand-md navbar-dark bg-dark">
            
            <a class="navbar-brand" href="home">Back to Store</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
            <div class="container">
                
                

                <div class="collapse navbar-collapse justify-content-end" id="navbarsExampleDefault">
                    <ul class="navbar-nav m-auto">
                        <c:if test="${sessionScope.account.isAdmin eq 1}">
                            <li class="nav-item">
                            <a class="nav-link" href="lists">Manager Product</a>
                            </li>
                        </c:if>
                        
                        <c:if test="${sessionScope.account ne null}">
                            <li class="nav-item">
                            <a class="nav-link" href="#">Hello ${sessionScope.account.cname}</a>
                            </li>
                            <li class="nav-item">
                            <a class="nav-link" href="logout">Logout</a>
                            </li>
                        </c:if>
                        
                            <c:if test="${sessionScope.account == null}">
                                <li class="nav-item">
                                    <a class="nav-link" href="Login.jsp">Login</a>
                                </li>
                            </c:if>
                    </ul>

                    <form action="search" method="post" class="form-inline my-2 my-lg-0">
                        <div class="input-group input-group-sm">
                            <input name="txt" type="text" class="form-control" aria-label="Small" aria-describedby="inputGroup-sizing-sm" placeholder="Search...">
                            <div class="input-group-append">
                                <button type="submit" class="btn btn-secondary btn-number">
                                    <i class="fa fa-search"></i>
                                </button>
                            </div>
                        </div>
                        <a class="btn btn-success btn-sm ml-3" href="show">
                            <i class="fa fa-shopping-cart"></i> Cart
                            <span class="badge badge-light">${sessionScope.cart.size()}</span>
                        </a>
                    </form>
                </div>
            </div>
        </nav>
        <section class="jumbotron text-center">
            <div class="container">
                <h1 class="jumbotron-heading">Shop điện thoại chất lượng cao</h1>
                <p class="lead text-muted mb-0">Uy tín tạo nên thương hiệu với hơn 10 năm cung cấp các sản phầm giày nhập từ Trung Quốc</p>
            </div>
        </section>
        
        <div class="modal-dialog">
                <div class="modal-content">
                    <form action="profile" method="post">
                        <div class="modal-header">						
                            <h4 class="modal-title">edit Profile</h4>
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        </div>
                        <div class="modal-body">
                            <input type="hidden" name="id" value="${c.cid}">
                            <div class="form-group">
                                <label>Name</label>
                                <input name="name" type="text" class="form-control" value="${sessionScope.account.cname}" required>
                            </div>
                            <div class="form-group">
                                <label>UserName</label>
                                <input name="username" type="text" class="form-control" value="${c.username}" readonly>
                            </div>
                            <div class="form-group">
                                <label>password</label>
                                <input name="password" type="text" class="form-control" value="${c.password}" required>
                            </div>
                            
                            <div class="form-group">
                                <label >address</label>
                                <input type="text" name="address" class="form-control" value="${c.address}" placeholder="${c.address}" required/>
                            </div>
                            <div class="form-group">
                                <label>Phone</label>
                                <input type="tel" name="phone" pattern="[0-9]{3}-[0-9]{3}-[0-9]{4}" value="${c.phone}" placeholder="123-456-7890" required/>
                            </div>

                        </div>
                        <div class="modal-footer">
                            <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                            <input type="submit" class="btn btn-success" value="Update">
                        </div>
                    </form>
                </div>
            </div>
    </body>
</html>
