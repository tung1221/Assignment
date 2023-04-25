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
            <a href="lists" class="navbar-brand">Back to Manager</a>
            <a class="navbar-brand" href="home">Shoes</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
            <div class="container">
                
                

                <div class="collapse navbar-collapse justify-content-end" id="navbarsExampleDefault">
                    <ul class="navbar-nav m-auto">
                        <li class="nav-item">
                            <a class="nav-link" href="#">Manager Account</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Hello Alias</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Logout</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Login</a>
                        </li>
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
                            <span class="badge badge-light">3</span>
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
                    <form action="editProduct" method="post">
                        <div class="modal-header">						
                            <h4 class="modal-title">edit Profile</h4>
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        </div>
                        <div class="modal-body">
                            
                            <div class="form-group">
                                <label>Name</label>
                                <input name="name" type="text" class="form-control" value="${sessionScope.account.cname}" required>
                            </div>
                            <div class="form-group">
                                <label>UserName</label>
                                <input name="username" type="text" class="form-control" value="${p.quantity}" readonly>
                            </div>
                            <div class="form-group">
                                <label>password</label>
                                <input name="password" type="text" class="form-control" value="${p.price}" required>
                            </div>
                            <div class="form-group">
                                <label>re-password</label>
                                <input name="password" type="text" class="form-control" value="${p.price}" required>
                            </div>
                            
                            <div class="form-group">
                                <label for="address"><i class="zmdi zmdi-lock-outline"></i></label>
                                <input type="address" name="address" id="address" placeholder="address" required/>
                            </div>
                            <div class="form-group">
                                <label>status</label>
                                <select name="status">
                                    <option value="1" ${p.status == 1 ? "selected" : ""}>Enable</option>
                                    <option value="0" ${p.status == 0 ? "selected" : ""}>Disable</option>
                                </select>
                            </div>
                          
                            <div class="form-group">
                                <label>Description</label>
                                <textarea name="description" class="form-control" >${p.description}</textarea>
                            </div>

                        </div>
                        <div class="modal-footer">
                            <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                            <input type="submit" class="btn btn-success" value="Save">
                        </div>
                    </form>
                </div>
            </div>
    </body>
</html>
