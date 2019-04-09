	<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Produto</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!--===============================================================================================-->
    <link rel="icon" type="image/png" href="../images/icons/favicon.png" />
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="../vendor/bootstrap/css/bootstrap.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="../fonts/font-awesome-4.7.0/css/font-awesome.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="../fonts/themify/themify-icons.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="../fonts/Linearicons-Free-v1.0.0/icon-font.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="../fonts/elegant-font/html-css/style.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="../vendor/animate/animate.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="../vendor/css-hamburgers/hamburgers.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="../vendor/animsition/css/animsition.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="../vendor/select2/select2.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="../vendor/slick/slick.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="../css/util.css">
    <link rel="stylesheet" type="text/css" href="../css/main.css">
    <!--===============================================================================================-->
</head>

<body class="animsition">

    <!-- Header -->
    <header class="header1">
        <!-- Header desktop -->
        <div class="container-menu-header">

            <div class="wrap_header">
                <!-- Logo -->
                <a href="index.jsp" class="logo">
                    <img src="../images/icons/logo.png" alt="IMG-LOGO">
                </a>

                <!-- Menu -->
                <div class="wrap_menu">
                    <nav class="menu">
                        <ul class="main_menu">
                            <li>
                                <a href="index.jsp">Home</a>

                            </li>

                            <li>
                                <a href="product.jsp">Catálogo de Produtos</a>
                            </li>

                            <li>
                                <a href="contact.jsp">Contato</a>
                            </li>



                            <li>
                                <a href="index.jsp">Área Cliente</a>
                                <ul class="sub_menu">
                                    <li><a href="area-cli.jsp">Meus Dados</a></li>
                                    <li><a href="pedidos-cli.jsp">Pedidos</a></li>
                                    <li><a href="#">Logout</a></li>
                                </ul>
                            </li>

                            <li>
                                <a href="index.jsp">Área Admin</a>
                                <ul class="sub_menu">
                                    <li><a href="consulta-cli.jsp">Consultar Clientes</a></li>
                                    <li><a href="consulta-prod.jsp">Produtos</a></li>
                                    <li><a href="troca.jsp">Consultar Trocas</a></li>
                                    <li><a href="pedidos-adm.jsp">Consultar Pedidos</a></li>
                                    <li><a href="relatorio.jsp">Relatórios</a></li>
                                </ul>
                            </li>
                        </ul>
                    </nav>
                </div>

                <!-- Header Icon -->
                <div class="header-icons">
                    <a href="login.jsp" class="header-wrapicon1 dis-block">
                        <img src="../images/icons/icon-header-01.png" class="header-icon1" alt="ICON">
                    </a>

                    <span class="linedivide1"></span>

                    <div class="header-wrapicon2">
                        <a href="cart.jsp" class="header-wrapicon1 dis-block">
                            <img src="../images/icons/icon-header-02.png" class="header-icon1" alt="ICON">
                        </a>


                    </div>
                </div>
            </div>
        </div>

        <!-- Header Mobile -->
        <div class="wrap_header_mobile">
            <!-- Logo moblie -->
            <a href="index.jsp" class="logo-mobile">
                <img src="../images/icons/logo.png" alt="IMG-LOGO">
            </a>

            <!-- Button show menu -->
            <div class="btn-show-menu">
                <!-- Header Icon mobile -->
                <div class="header-icons-mobile">
                    <a href="#" class="header-wrapicon1 dis-block">
                        <img src="../images/icons/icon-header-01.png" class="header-icon1" alt="ICON">
                    </a>

                    <span class="linedivide2"></span>

                    <div class="header-wrapicon2">
                        <img src="../images/icons/icon-header-02.png" class="header-icon1 js-show-header-dropdown"
                            alt="ICON">

                    </div>
                </div>

                <div class="btn-show-menu-mobile hamburger hamburger--squeeze">
                    <span class="hamburger-box">
                        <span class="hamburger-inner"></span>
                    </span>
                </div>
            </div>
        </div>

        <!-- Menu Mobile -->
        <div class="wrap-side-menu">
            <nav class="side-menu">
                <ul class="main-menu">


                    <li class="item-menu-mobile">
                        <a href="index.jsp">Home</a>

                    </li>

                    <li class="item-menu-mobile">
                        <a href="product.jsp">Catálogo de Produtos</a>
                    </li>

                    <li class="item-menu-mobile">
                        <a href="contact.jsp">Contato</a>
                    </li>

                    <li class="item-menu-mobile">
                        <a href="index.jsp">Área Cliente</a>
                        <ul class="sub-menu">
                            <li><a href="area-cli.jsp"">Meus Dados</a></li>
									<li><a href=" pedidos-cli.jsp">Pedidos</a></li>
                            <li><a href="#">Logout</a></li>
                        </ul>
                        <i class="arrow-main-menu fa fa-angle-right" aria-hidden="true"></i>
                    </li>

                    <li class="item-menu-mobile">
                        <a href="index.jsp">Área Admin</a>
                        <ul class="sub-menu">
                            <li><a href="consulta-cli.jsp">Consultar Clientes</a></li>
                            <li><a href="consulta-prod.jsp">Produtos</a></li>
                            <li><a href="troca.jsp">Consultar Trocas</a></li>
                            <li><a href="pedidos-adm.jsp">Consultar Pedidos</a></li>
                            <li><a href="relatorio.jsp">Relatórios</a></li>
                        </ul>
                        <i class="arrow-main-menu fa fa-angle-right" aria-hidden="true"></i>
                    </li>


                </ul>
            </nav>
        </div>
    </header>



    <!-- Product Detail -->
    <div class="container bgwhite p-t-35 p-b-80">
        <div class="flex-w flex-sb">
            <div class="w-size13 p-t-30 respon5">
                <div class="wrap-slick3 flex-sb flex-w">
                    <div class="wrap-slick3-dots"></div>

                    <div class="slick3">
                        <div class="item-slick3" data-thumb="images/thumb-item-01.jpg">
                            <div class="wrap-pic-w">
                                <img src="../images/product-detail-01.jpg" alt="IMG-PRODUCT">
                            </div>
                        </div>

                        <div class="item-slick3" data-thumb="images/thumb-item-02.jpg">
                            <div class="wrap-pic-w">
                                <img src="../images/product-detail-02.jpg" alt="IMG-PRODUCT">
                            </div>
                        </div>

                        <div class="item-slick3" data-thumb="images/thumb-item-03.jpg">
                            <div class="wrap-pic-w">
                                <img src="../images/product-detail-03.jpg" alt="IMG-PRODUCT">
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="w-size14 p-t-30 respon5">
                <h4 class="product-detail-name m-text16 p-b-13">
                    ${eletronico.nome}
                </h4>

                <span class="m-text17">
                    $${eletronico.preco}
                </span>



                <!--  -->
                <div class="p-t-33 p-b-60">


                    <div class="flex-r-m flex-w p-t-10">
                        <div class="w-size16 flex-m flex-w">
                            <div class="flex-w bo5 of-hidden m-r-22 m-t-10 m-b-10">
                                <button class="btn-num-product-down color1 flex-c-m size7 bg8 eff2">
                                    <i class="fs-12 fa fa-minus" aria-hidden="true"></i>
                                </button>

                                <input class="size8 m-text18 t-center num-product" type="number" name="num-product"
                                    value="1">

                                <button class="btn-num-product-up color1 flex-c-m size7 bg8 eff2">
                                    <i class="fs-12 fa fa-plus" aria-hidden="true"></i>
                                </button>
                            </div>

                            <div class="btn-addcart-product-detail size9 trans-0-4 m-t-10 m-b-10">
                                <!-- Button -->
                                <button class="flex-c-m sizefull bg1 bo-rad-23 hov1 s-text1 trans-0-4">
                                    Comprar
                                </button>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="p-b-45">

                    <span class="s-text8"><b>Categorias: </b>${eletronico.categoria.descricao }</span>
                </div>

                <!--  -->
                <div class="wrap-dropdown-content bo6 p-t-15 p-b-14 active-dropdown-content">
                    <h5 class="js-toggle-dropdown-content flex-sb-m cs-pointer m-text19 color0-hov trans-0-4">
                        Descrição
                        <i class="down-mark fs-12 color1 fa fa-minus dis-none" aria-hidden="true"></i>
                        <i class="up-mark fs-12 color1 fa fa-plus" aria-hidden="true"></i>
                    </h5>

                    <div class="dropdown-content dis-none p-t-15 p-b-23">
                        <p class="s-text8">
                            ${eletronico.descricao}
                        </p>
                    </div>
                </div>

                <div class="wrap-dropdown-content bo7 p-t-15 p-b-14">
                    <h5 class="js-toggle-dropdown-content flex-sb-m cs-pointer m-text19 color0-hov trans-0-4">
                        Modelo
                        <i class="down-mark fs-12 color1 fa fa-minus dis-none" aria-hidden="true"></i>
                        <i class="up-mark fs-12 color1 fa fa-plus" aria-hidden="true"></i>
                    </h5>

                    <div class="dropdown-content dis-none p-t-15 p-b-23">
                        <p class="s-text8">
                            Modelo: ${eletronico.modelo}
                        </p>
                        <p class="s-text8">
                            Ano de Fabricação: ${eletronico.dataaFabricacao}
                        </p>
                        <p class="s-text8">
                            Cor: ${eletronico.cor}
                        </p>
                    </div>
                </div>

                <div class="wrap-dropdown-content bo6 p-t-15 p-b-14">
                    <h5 class="js-toggle-dropdown-content flex-sb-m cs-pointer m-text19 color0-hov trans-0-4">
                        Configurações
                        <i class="down-mark fs-12 color1 fa fa-minus dis-none" aria-hidden="true"></i>
                        <i class="up-mark fs-12 color1 fa fa-plus" aria-hidden="true"></i>
                    </h5>

                    <div class="dropdown-content dis-none p-t-15 p-b-23">
                        <p class="s-text8">
                            Dimensões: ${eletronico.dimensoes}
                        </p>
                        <p class="s-text8">
                            Memória: ${eletronico.memoria}
                        </p>
                        <p class="s-text8">
                            Processador: ${eletronico.processador}
                        </p>
                        <p class="s-text8">
                            Tamanho do display: ${eletronico.tamanhoDisplay}
                        </p>
                        <p class="s-text8">
                            Resolução camera: ${eletronico.resolucaoCamera}
                        </p>
                        <p class="s-text8">
                            Alimentação: ${eletronico.alimentacao}
                        </p>
                        <p class="s-text8">
                            RAM: ${eletronico.RAM}
                        </p>
                        <p class="s-text8">
                            S.O: ${eletronico.sistemaOperacional}
                        </p>
                    </div>
                </div>

                <div class="wrap-dropdown-content bo6 p-t-15 p-b-14">
                    <h5 class="js-toggle-dropdown-content flex-sb-m cs-pointer m-text19 color0-hov trans-0-4">
                        Conteúdo da Embalagem
                        <i class="down-mark fs-12 color1 fa fa-minus dis-none" aria-hidden="true"></i>
                        <i class="up-mark fs-12 color1 fa fa-plus" aria-hidden="true"></i>
                    </h5>

                    <div class="dropdown-content dis-none p-t-15 p-b-23">
                        <p class="s-text8">
                           ${eletronico.conteudoEmbalagem}
                        </p>
                    </div>
                </div>




            </div>
        </div>
    </div>




    <!-- Footer -->
    <footer class="bg6 p-t-45 p-b-43 p-l-45 p-r-45">
        <div class="flex-w p-b-90">
            <div class="w-size6 p-t-30 p-l-15 p-r-15 respon3">
                <h4 class="s-text12 p-b-30">
                    Entre em contato!
                </h4>

                <div>
                    <p class="s-text7 w-size27">
                        Entre em contato através do e-mail macshop@fatec.com ou se preferir, pelo telefone (11)
                        2312-2312
                    </p>

                    <div class="flex-m p-t-30">
                        <a href="#" class="fs-18 color1 p-r-20 fa fa-facebook"></a>
                        <a href="#" class="fs-18 color1 p-r-20 fa fa-instagram"></a>
                        <a href="#" class="fs-18 color1 p-r-20 fa fa-pinterest-p"></a>
                        <a href="#" class="fs-18 color1 p-r-20 fa fa-snapchat-ghost"></a>
                        <a href="#" class="fs-18 color1 p-r-20 fa fa-youtube-play"></a>
                    </div>
                </div>
            </div>

            <div class="w-size7 p-t-30 p-l-15 p-r-15 respon4">
                <h4 class="s-text12 p-b-30">
                    Categorias
                </h4>

                <ul>
                    <li class="p-b-9">
                        <a href="#" class="s-text7">
                            iPhone
                        </a>
                    </li>

                    <li class="p-b-9">
                        <a href="#" class="s-text7">
                            iPad
                        </a>
                    </li>

                    <li class="p-b-9">
                        <a href="#" class="s-text7">
                            Macbook
                        </a>
                    </li>

                    <li class="p-b-9">
                        <a href="#" class="s-text7">
                            Acessórios
                        </a>
                    </li>
                </ul>
            </div>

            <div class="w-size7 p-t-30 p-l-15 p-r-15 respon4">
                <h4 class="s-text12 p-b-30">
                    Links
                </h4>

                <ul>
                    <li class="p-b-9">
                        <a href="#" class="s-text7">
                            Busca
                        </a>
                    </li>

                    <li class="p-b-9">
                        <a href="#" class="s-text7">
                            Catálogo de Produtos
                        </a>
                    </li>

                    <li class="p-b-9">
                        <a href="#" class="s-text7">
                            Contato
                        </a>
                    </li>

                </ul>
            </div>

            <div class="w-size7 p-t-30 p-l-15 p-r-15 respon4">
                <h4 class="s-text12 p-b-30">
                    Help
                </h4>

                <ul>
                    <li class="p-b-9">
                        <a href="#" class="s-text7">
                            Carrinho
                        </a>
                    </li>

                    <li class="p-b-9">
                        <a href="#" class="s-text7">
                            Pedidos
                        </a>
                    </li>
                </ul>
            </div>

            <div class="w-size8 p-t-30 p-l-15 p-r-15 respon3">
                <h4 class="s-text12 p-b-30">
                    Newsletter
                </h4>

                <form>
                    <div class="effect1 w-size9">
                        <input class="s-text7 bg6 w-full p-b-5" type="text" name="email"
                            placeholder="email@example.com">
                        <span class="effect1-line"></span>
                    </div>

                    <div class="w-size2 p-t-20">
                        <!-- Button -->
                        <button class="flex-c-m size2 bg4 bo-rad-23 hov1 m-text3 trans-0-4">
                            Subscribe
                        </button>
                    </div>

                </form>
            </div>
        </div>

        <div class="t-center p-l-15 p-r-15">
            <a href="#">
                <img class="h-size2" src="../images/icons/paypal.png" alt="IMG-PAYPAL">
            </a>

            <a href="#">
                <img class="h-size2" src="../images/icons/visa.png" alt="IMG-VISA">
            </a>

            <a href="#">
                <img class="h-size2" src="../images/icons/mastercard.png" alt="IMG-MASTERCARD">
            </a>

            <a href="#">
                <img class="h-size2" src="../images/icons/express.png" alt="IMG-EXPRESS">
            </a>

            <a href="#">
                <img class="h-size2" src="../images/icons/discover.png" alt="IMG-DISCOVER">
            </a>

            <div class="t-center s-text8 p-t-20">
                Copyright © 2018 All rights reserved. | This template is made with <i class="fa fa-heart-o"
                    aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a>
            </div>
        </div>
    </footer>



    <!-- Back to top -->
    <div class="btn-back-to-top bg0-hov" id="myBtn">
        <span class="symbol-btn-back-to-top">
            <i class="fa fa-angle-double-up" aria-hidden="true"></i>
        </span>
    </div>

    <!-- Container Selection -->
    <div id="dropDownSelect1"></div>
    <div id="dropDownSelect2"></div>



    <!--===============================================================================================-->
    <script type="text/javascript" src="../vendor/jquery/jquery-3.2.1.min.js"></script>
    <!--===============================================================================================-->
    <script type="text/javascript" src="../vendor/animsition/js/animsition.min.js"></script>
    <!--===============================================================================================-->
    <script type="text/javascript" src="../vendor/bootstrap/js/popper.js"></script>
    <script type="text/javascript" src="../vendor/bootstrap/js/bootstrap.min.js"></script>
    <!--===============================================================================================-->
    <script type="text/javascript" src="../vendor/select2/select2.min.js"></script>
    <script type="text/javascript">
        $(".selection-1").select2({
            minimumResultsForSearch: 20,
            dropdownParent: $('#dropDownSelect1')
        });

        $(".selection-2").select2({
            minimumResultsForSearch: 20,
            dropdownParent: $('#dropDownSelect2')
        });
    </script>
    <!--===============================================================================================-->
    <script type="text/javascript" src="../vendor/slick/slick.min.js"></script>
    <script type="text/javascript" src="../js/slick-custom.js"></script>
    <!--===============================================================================================-->
    <script type="text/javascript" src="../vendor/sweetalert/sweetalert.min.js"></script>
    <script type="text/javascript">
        $('.block2-btn-addcart').each(function () {
            var nameProduct = $(this).parent().parent().parent().find('.block2-name').jsp();
            $(this).on('click', function () {
                swal(nameProduct, "is added to cart !", "success");
            });
        });

        $('.block2-btn-addwishlist').each(function () {
            var nameProduct = $(this).parent().parent().parent().find('.block2-name').jsp();
            $(this).on('click', function () {
                swal(nameProduct, "is added to wishlist !", "success");
            });
        });

        $('.btn-addcart-product-detail').each(function () {
            var nameProduct = $('.product-detail-name').jsp();
            $(this).on('click', function () {
                swal(nameProduct, "is added to wishlist !", "success");
            });
        });
    </script>

    <!--===============================================================================================-->
    <script src="../js/main.js"></script>

</body>

</html>