<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
            <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Consulta de Pedidos</title>
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
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="../css/util.css">
    <link rel="stylesheet" type="text/css" href="../css/main.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    
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
                                <a href="product?btnOperacao=CONSULTAR&FormName=VHELETRONICO&direcionamento=CATALOGO&txtStatus=Ativo">Catálogo de Produtos</a>
                            </li>

                            <li>
                                <a href="contact.jsp">Contato</a>
                            </li>



                             <li>
                                <a href="index.jsp">Área Cliente</a>
                                <ul class="sub_menu">
                                    <li><a href="LoginControllerMeusDados">Meus Dados</a></li>
                                    <li><a href="LoginControllerPedidos">Pedidos</a></li>
                                    <li><a href="#">Logout</a></li>
                                </ul>
                            </li>

                            <li>
                                <a href="index.jsp">Área Admin</a>
                                <ul class="sub_menu">
                                    <li><a href="#">Consultar Clientes</a></li>
                                    <li><a href="consulta-prod.jsp">Produtos</a></li>
                                    <li><a href="orders?btnOperacao=CONSULTAR&FormName=VHPEDIDO&Direcionamento=ADMIN">Consultar Pedidos</a></li>
                                 <li><a href="gerarCupom.jsp">Gerar Cupom</a></li>
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
									<li><a href="orders?btnOperacao=CONSULTAR&FormName=VHPEDIDO&cli_id=10&Direcionamento=CLIENTE">Pedidos</a></li>
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

    <!-- Title Page -->
    <section class="bg-title-page p-t-40 p-b-50 flex-col-c-m" style="background-image: url(../images/iphone_banner.jpg);">
        <h2 class="l-text2 t-center">
           Pedido
        </h2>
    </section>

    <!-- content page -->





    <section class="bgwhite p-t-36 p-b-60">

      	<div class="modal-dialog modal-confirm">
		<div class="modal-content">
			<div class="modal-header">				
				<h4 class="modal-title">Parabéns!</h4>	
			</div>
			<div class="modal-body">
				<p class="text-center">Sua compra foi efetuada com sucesso! Verifique a área do cliente para detalhes do pedido.</p>
			</div>
			<div class="modal-footer">
			<form action="/macShop/Pages/orders" method="POST">
                        				  <input type="hidden" id="FormName" name="FormName" value="VHPEDIDO" />
                        				  <input type="hidden" id="cli_id" name="cli_id" value="10" />
                        				  <input type="hidden" id="Direcionamento" name="Direcionamento" value="CLIENTE" />
               <center> <button class="btn btn-success btn-block" id= "btnOperacaoSalvar" name="btnOperacao" value="CONSULTAR">Meus Pedidos</button> </center>
			</form>
			</div>
		</div>
	</div>


	</section>






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
        <script type="text/javascript">
    function setaDadosModal(carrinho) {
    	<c:set var="message" value="carrinho" />
    	var message = <c:out value="${message}"/>
    	console.log(message)
    	itensCarrinho = carrinho.itensCarrinho;
    	
    	//console.log(carrinho.getItensCarrinho())
    	
     
    	/*carrinho.forEach(item)=> {
    		console.log()
    		console.log(item.quantidade)
    		
    	})*/
    	
     	$("#addEstoque").modal("show")   
    }
    </script>
        
        
        <!--===============================================================================================-->
        <script src="../https://maps.googleapis.com/maps/api/js?key=AIzaSyAKFWBqlKAGCeS1rMVoaNlwyayu0e0YRes"></script>
        <script src="../js/map-custom.js"></script>
        <!--===============================================================================================-->
        <script src="../js/main.js"></script>

</body>

</html>