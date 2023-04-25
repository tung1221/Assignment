<%-- 
    Document   : Cart
    Created on : Oct 31, 2020, 9:42:21 PM
    Author     : trinh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
      rel="stylesheet"
    />
    <link
      href="https://getbootstrap.com/docs/5.2/assets/css/docs.css"
      rel="stylesheet"
    />
    <title></title>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
        <link href="css/cartStyle.css" rel="stylesheet" type="text/css"/>
    </head>

    <body>
        <nav class="navbar navbar-expand-md navbar-dark bg-dark">
            <div class="container">
                <a class="navbar-brand" href="home">Phone Store</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>

                <div class="collapse navbar-collapse justify-content-end" id="navbarsExampleDefault">
                    <ul class="navbar-nav m-auto">
                        <li class="nav-item">
                            <a class="nav-link" href="lists">Manager Product</a>
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

                    
                        <a class="btn btn-success btn-sm ml-3" href="#">
                            <i class="fa fa-shopping-cart"></i> Cart
                            <span class="badge badge-light">
                                <c:if test="${sessionScope.cart == null || session.cart.isEmpty()}">
                                    0
                                </c:if>
                                <c:if test="${sessionScope.cart != null}">
                                    ${sessionScope.cart.size()}
                                </c:if>
                            </span>
                        </a>
                    
                </div>
            </div>
        </nav>
        
        <section class="h-100 h-custom" style="background-color: #d2c9ff;">
            <div class="container py-5 h-100">
                <div class="row d-flex justify-content-center align-items-center h-100">
                    <div class="col-12">
                        <div class="card card-registration card-registration-2" style="border-radius: 15px;">
                            <div class="card-body p-0">
                                <div class="row g-0">
                                    <div class="col-lg-8">
                                        <div class="p-5">
                                            <div class="d-flex justify-content-between align-items-center mb-5">
                                                <h1 class="fw-bold mb-0 text-black">Shopping Cart</h1>
                                                <h6 class="mb-0 text-muted">${sessionScope.cart.size()} items</h6>
                                            </div>
                                            <hr class="my-4">
                                            <c:forEach items="${sessionScope.cart}" var="i">
                                                <div class="row mb-4 d-flex justify-content-between align-items-center">
                                                    <div class="col-md-2 col-lg-2 col-xl-2">
                                                        <img
                                                            src="${i.key.image}"
                                                            class="img-fluid rounded-3">
                                                    </div>
                                                    <div class="col-md-3 col-lg-3 col-xl-3">
                                                        
                                                        <h6 class="text-black mb-0">${i.key.pname}</h6>
                                                    </div>
                                                    <div class="col-md-3 col-lg-3 col-xl-2 d-flex">
                                                        <button class="btn btn-block px-2 "
                                                                onclick="this.parentNode.querySelector('input[type=number]').stepDown()">
                                                            <i class="fas fa-minus"><a href="addToCart?pid=${i.key.pid}&mode=decrease">-</a></i>
                                                        </button>

                                                        <input id="form1" min="0" max="10" value="${i.value}" type="number"
                                                               class="form-control form-control-sm"/>

                                                        <button class="btn btn-block px-2">
                                                            <i class="fas fa-plus"><a href="addToCart?pid=${i.key.pid}&mode=increase">+</a></i>
                                                        </button>
                                                    </div>
                                                    <div class="col-md-3 col-lg-2 col-xl-2 offset-lg-1">
                                                        <h6 class="mb-0">${i.value * i.key.price}</h6>
                                                    </div>
                                                    <div class="col-md-1 col-lg-1 col-xl-1 text-end">
                                                        <a href="addToCart?pid=${i.key.pid}&mode=remove" class="text-muted"><i class="fas fa-times"></i>x</a>
                                                    </div>
                                                </div>

                                                <hr class="my-4">
                                                    
                                            </c:forEach>        
                                            

                                            <div class="pt-5">
                                                <h6 class="mb-0"><a href="home" class="text-body"><i
                                                            class="fas fa-long-arrow-alt-left me-2"></i>Back to shop</a></h6>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-lg-4 bg-grey">
                                        <div class="p-5">
                                            <h3 class="fw-bold mb-5 mt-2 pt-1">Summary</h3>
                                            <hr class="my-4">

                                            <div class="d-flex justify-content-between mb-4">
                                                <h5 class="text-uppercase">items ${sessionScope.cart.size()}</h5>
                                                <h5>${requestScope.total}</h5>
                                            </div>

                                            <h5 class="text-uppercase mb-3">Shipping</h5>

                                            <div class="mb-4 pb-2">
                                                <select class="select">
                                                    <option value="1">Standard-Delivery- €5.00</option>
                                                    <option value="2">free ship</option>
                                                    
                                                </select>
                                            </div>

                                            <hr class="my-4">

                                            <div class="d-flex justify-content-between mb-5">
                                                <h5 class="text-uppercase">Total price</h5>
                                                <h5>${requestScope.total} $</h5>
                                            </div>
                                                <c:if test="${sessionScope.account == null}" >   
                                            <button type="button" class="btn btn-dark btn-block btn-lg"
                                                    data-mdb-ripple-color="blue"><a href="SignUp.jsp">Register</a></button>
                                                </c:if>
                                                 <c:if test="${sessionScope.account != null}" >   
                                                <button type="button" class="btn btn-dark btn-block btn-lg"
                                                        data-mdb-ripple-color="blue"><a href="checkout">Checkout</a></button>
                                                </c:if>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>    
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js" integrity="sha384-cuYeSxntonz0PPNlHhBs68uyIAVpIIOZZ5JqeqvYYIcEL727kskC66kF92t6Xl2V" crossorigin="anonymous"></script>
    </body>

</html>
</html>
