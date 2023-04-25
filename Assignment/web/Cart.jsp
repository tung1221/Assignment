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
        <title>JSP Page</title>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <!------ Include the above in your HEAD tag ---------->
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
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

                    <form action="home" method="post" class="form-inline my-2 my-lg-0">
                        <div class="input-group input-group-sm">
                            <input name="txt" type="text" class="form-control" aria-label="Small" aria-describedby="inputGroup-sizing-sm" placeholder="Search...">
                            <div class="input-group-append">
                                <button type="submit" class="btn btn-secondary btn-number">
                                    <i class="fa fa-search"></i>
                                </button>
                            </div>
                        </div>
                        <a class="btn btn-success btn-sm ml-3" href="#">
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
                <p class="lead text-muted mb-0">Uy tín tạo nên thương hiệu với hơn 10 năm cung cấp các sản phầm  Trung Quốc</p>
            </div>
        </section>
        <section class="h-100 h-custom" style="background-color: #eee;">
            <div class="container h-100 py-5">
                <div class="row d-flex justify-content-center align-items-center h-100">
                    <div class="col">
                        <div class="card shopping-cart" style="border-radius: 15px;">
                            <div class="card-body text-black">

                                <div class="row">
                                    <div class="col-lg-6 px-5 py-4">

                                        <h3 class="mb-5 pt-2 text-center fw-bold text-uppercase">Your products</h3>

                                        <div class="d-flex align-items-center mb-5">
                                            <div class="flex-shrink-0">
                                                <img src="https://mdbcdn.b-cdn.net/img/Photos/Horizontal/E-commerce/Products/13.webp"
                                                     class="img-fluid" style="width: 150px;" alt="Generic placeholder image">
                                            </div>
                                            <div class="flex-grow-1 ms-3">
                                                <a href="#!" class="float-end text-black"><i class="fas fa-times"></i></a>
                                                <h5 class="text-primary">Samsung Galaxy M11 64GB</h5>
                                                <h6 style="color: #9e9e9e;">Color: white</h6>
                                                <div class="d-flex align-items-center">
                                                    <p class="fw-bold mb-0 me-5 pe-3">799$</p>
                                                    <div class="def-number-input number-input safari_only">
                                                        <button onclick="this.parentNode.querySelector('input[type=number]').stepDown()"
                                                                class="minus"></button>
                                                        <input class="quantity fw-bold text-black" min="0" name="quantity" value="1"
                                                               type="number">
                                                        <button onclick="this.parentNode.querySelector('input[type=number]').stepUp()"
                                                                class="plus"></button>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>

                                        <div class="d-flex align-items-center mb-5">
                                            <div class="flex-shrink-0">
                                                <img src="https://mdbcdn.b-cdn.net/img/Photos/Horizontal/E-commerce/Products/6.webp"
                                                     class="img-fluid" style="width: 150px;" alt="Generic placeholder image">
                                            </div>
                                            <div class="flex-grow-1 ms-3">
                                                <a href="#!" class="float-end text-black"><i class="fas fa-times"></i></a>
                                                <h5 class="text-primary">Headphones Bose 35 II</h5>
                                                <h6 style="color: #9e9e9e;">Color: Red</h6>
                                                <div class="d-flex align-items-center">
                                                    <p class="fw-bold mb-0 me-5 pe-3">239$</p>
                                                    <div class="def-number-input number-input safari_only">
                                                        <button onclick="this.parentNode.querySelector('input[type=number]').stepDown()"
                                                                class="minus"></button>
                                                        <input class="quantity fw-bold text-black" min="0" name="quantity" value="1"
                                                               type="number">
                                                        <button onclick="this.parentNode.querySelector('input[type=number]').stepUp()"
                                                                class="plus"></button>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>

                                        <div class="d-flex align-items-center mb-5">
                                            <div class="flex-shrink-0">
                                                <img src="https://mdbcdn.b-cdn.net/img/Photos/Horizontal/E-commerce/Products/1.webp"
                                                     class="img-fluid" style="width: 150px;" alt="Generic placeholder image">
                                            </div>
                                            <div class="flex-grow-1 ms-3">
                                                <a href="#!" class="float-end text-black"><i class="fas fa-times"></i></a>
                                                <h5 class="text-primary">iPad 9.7 6-gen WiFi 32GB</h5>
                                                <h6 style="color: #9e9e9e;">Color: rose pink</h6>
                                                <div class="d-flex align-items-center">
                                                    <p class="fw-bold mb-0 me-5 pe-3">659$</p>
                                                    <div class="def-number-input number-input safari_only">
                                                        <button onclick="this.parentNode.querySelector('input[type=number]').stepDown()"
                                                                class="minus"></button>
                                                        <input class="quantity fw-bold text-black" min="0" name="quantity" value="2"
                                                               type="number">
                                                        <button onclick="this.parentNode.querySelector('input[type=number]').stepUp()"
                                                                class="plus"></button>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>

                                        <hr class="mb-4" style="height: 2px; background-color: #1266f1; opacity: 1;">

                                        <div class="d-flex justify-content-between px-x">
                                            <p class="fw-bold">Discount:</p>
                                            <p class="fw-bold">95$</p>
                                        </div>
                                        <div class="d-flex justify-content-between p-2 mb-2" style="background-color: #e1f5fe;">
                                            <h5 class="fw-bold mb-0">Total:</h5>
                                            <h5 class="fw-bold mb-0">2261$</h5>
                                        </div>

                                    </div>
                                    <div class="col-lg-6 px-5 py-4">

                                        <h3 class="mb-5 pt-2 text-center fw-bold text-uppercase">Payment</h3>

                                        <form class="mb-5">

                                            <div class="form-outline mb-5">
                                                <input type="text" id="typeText" class="form-control form-control-lg" siez="17"
                                                       value="1234 5678 9012 3457" minlength="19" maxlength="19" />
                                                <label class="form-label" for="typeText">Card Number</label>
                                            </div>

                                            <div class="form-outline mb-5">
                                                <input type="text" id="typeName" class="form-control form-control-lg" siez="17"
                                                       value="John Smith" />
                                                <label class="form-label" for="typeName">Name on card</label>
                                            </div>

                                            <div class="row">
                                                <div class="col-md-6 mb-5">
                                                    <div class="form-outline">
                                                        <input type="text" id="typeExp" class="form-control form-control-lg" value="01/22"
                                                               size="7" id="exp" minlength="7" maxlength="7" />
                                                        <label class="form-label" for="typeExp">Expiration</label>
                                                    </div>
                                                </div>
                                                <div class="col-md-6 mb-5">
                                                    <div class="form-outline">
                                                        <input type="password" id="typeText" class="form-control form-control-lg"
                                                               value="&#9679;&#9679;&#9679;" size="1" minlength="3" maxlength="3" />
                                                        <label class="form-label" for="typeText">Cvv</label>
                                                    </div>
                                                </div>
                                            </div>

                                            <p class="mb-5">Lorem ipsum dolor sit amet consectetur, adipisicing elit <a
                                                    href="#!">obcaecati sapiente</a>.</p>

                                            <button type="button" class="btn btn-primary btn-block btn-lg">Buy now</button>

                                            <h5 class="fw-bold mb-5" style="position: absolute; bottom: 0;">
                                                <a href="#!"><i class="fas fa-angle-left me-2"></i>Back to shopping</a>
                                            </h5>

                                        </form>

                                    </div>
                                </div>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    </body>

</html>
</html>
