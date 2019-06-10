<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Consulta de Produtos</title>
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
                                    <li><a href="contact?btnOperacao=CONSULTAR&FormName=VHCLIENTE&txtID=10&Direcionamento=DADOS">Meus Dados</a></li>
                                    <li><a href="orders?btnOperacao=CONSULTAR&FormName=VHPEDIDO&cli_id=10&Direcionamento=CLIENTE">Pedidos</a></li>
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

    <!-- Title Page -->
    <section class="bg-title-page p-t-40 p-b-50 flex-col-c-m" style="background-image: url(../images/iphone_banner.jpg);">
        <h2 class="l-text2 t-center">
            Consulta de Produtos
        </h2>
    </section>

    <!-- content page -->
     <section class="ftco-section">
<center>
<div class="tab-pane fade show active" id="best-seller" role="tabpanel">
                        <section class="ftco-section">
                            <div class="container bgwhite p-t-35 p-b-30">
                                <div class="container">

            	 <form action="/macShop/Pages/consultaCategoria" method="POST">
            	    <input type="hidden" id="FormName" name="FormName" value="VHCATEGORIA" />
            	 
            	 
            	   <button class="btn btn-success" id= "btnOperacaoSalvar" name="btnOperacao" value="CONSULTAR">Cadastrar novo produto</button>
            	   
            	   </form>
            	   
            	 </center>  	 
     </div>
     </div>
     </div>
     
            </section>
            
            <c:forEach items="${erro}" var="msg">
<label style="color:red;">${msg}</label><br/>
</c:forEach>
	                    <c:forEach items="${sucesso}" var="msg">
	                        <label style="color:green;">${msg}</label><br/>
	                    </c:forEach>
     <div class="tab-pane fade show active" id="best-seller" role="tabpanel">
                        <section class="ftco-section">
                            <div class="container bgwhite p-t-35 p-b-80">
                                <div class="container">
                                    <div class="row justify-content-center">
                                        <div class="col-xl-8 ftco-animate">



                                            <form action="/macShop/Pages/cadastroEletronico" method="POST" class="billing-form bg-light p-3 p-md-5">
												

                                                <h3 class="mb-4 billing-heading"><center>Consultas</center></h3>
                                                <div class="row align-items-end">
                                                    <div class="col-md-12">
                                                        <div class="form-group">
                                                            <label for="firstname">Nome</label>
                                                            <input value="" type="text" class="form-control" id="txtNome" name="txtNome" placeholder="">
                                                        </div>
                                                    </div>
                                                    <div class="w-100"></div>
                                                    <div class="col-md-12">
                                                        <div class="form-group">
                                                            <label for="country">Categoria</label>
                                                            <div class="select-wrap">
                                                                <div class="icon"><span
                                                                        class="ion-ios-arrow-down"></span></div>
                                                                   <select name="txtCategoria" id="txtCategoria" class="form-control">
                                                
                                                                      <option name="txtCategoria" value="1">iPhone</option>
                                                                      <option name="txtCategoria" value="2">iPad</option>
                                                                      <option name="txtCategoria" value="3">Macbook</option>
                                                                      <option name="txtCategoria" value="4">Acessório</option>
															
                                                                    </select>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="w-100"></div>
                                                    <div class="col-md-6">
                                                        <div class="form-group">
                                                            <label for="streetaddress">Código do Produto</label>
                                                            <input type="text" class="form-control" placeholder="" id="txtID" name="txtID" value="">
                                                        </div>
                                                    </div>
                                                    <div class="col-md-6">
                                                        <div class="form-group">
                                                            <label for="streetaddress">Modelo</label>
                                                            <input type="text" class="form-control" placeholder="" id="txtModelo" name="txtModelo" value="">
                                                        </div>
                                                    </div>
                                                    <div class="w-100"></div>
                                                    <div class="col-md-6">
                                                        <div class="form-group">
                                                            <label for="towncity">Cor</label>
                                                            <input type="text" class="form-control" placeholder="" id="txtCor" name="txtCor" value="">
                                                        </div>
                                                    </div>
                                                 
                                                    
                                                    <div class="col-md-6">
                                                        <div class="form-group">
                                                            <label for="phone">Código de Barras</label>
                                                            <input type="text" class="form-control" placeholder="" id="txtCodBarras" name="txtCodBarras" value="">
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="w-100"></div>
                                                <div class="col-md-12">
                                                    <div class="form-group mt-4">
                                                        <center>
                                                            <div class="header-cart-wrapbtn">
                                                                <!-- Button -->
                                                                <input type="hidden" id="FormName" name="FormName" value="VHELETRONICO" />
                                                                <input type="hidden" id="FormName" name="txtCat" value="" />
                                                                <button class="btn mosh-btn mt-50" id= "btnOperacaoSalvar" name="btnOperacao" value="SALVAR">Consultar por parâmetros</button>
                                                             
                                                            </div>
                                                            
                                                            <div class="header-cart-wrapbtn">
                                                              <form action="/macShop/Pages/consultaProdutos" method="POST">
            	   	    <input type="hidden" id="FormName" name="FormName" value="VHELETRONICO" />
            	   	 <input type="hidden" id="FormName" name="direcionamento" value="CONSULTA" />
            		
            	   <button class="btn mosh-btn mt-50" id= "btnOperacaoSalvar" name="btnOperacao" value="CONSULTAR">Consultar todos eletronicos</button>
            	   
            	   </form>
            	   </div>
            	   
            	   <div class="header-cart-wrapbtn">
            	   <form action="/macShop/Pages/consultaProdutos" method="POST">
            	   	    <input type="hidden" id="FormName" name="FormName" value="VHACESSORIO" />
            	   	 <input type="hidden" id="FormName" name="direcionamento" value="CONSULTA" />
            		
            	   <button class="btn mosh-btn mt-50" id= "btnOperacaoSalvar" name="btnOperacao" value="CONSULTAR">Consultar todos acessórios</button>
            	   
            	   </form>
                                                        </center>
                                                    </div>
                                                </div>
                                        </div>
                                        </form>
                                        <!-- END -->
                                    </div> <!-- .col-md-8 -->
                                </div>
                            </div>
                        </section> <!-- .section -->




                    </div>

  
            
            
            
            
            
            
            
            <div class="table-wrapper">

                <table class="table table-striped table-hover">
                    <thead>
                        <tr>

                            <th>Código</th>
                            <th>Nome</th>
                            <th>Categoria</th>
                            <th>Código de Barras</th>
                            <th>Estoque</th>
                            <th>Status</th>
                            <th>Ações</th>
                        </tr>
                    </thead>
                    <tbody>
                         <c:forEach var="eletronico" items="${resultado }" >
                        <tr>

                            <td>${eletronico.id } </td>
                            <td>${eletronico.nome }</td>
                            <td>${eletronico.categoria.descricao }</td>
                            <td>${eletronico.codigoBarras }</td>
                            <td>${eletronico.estoque }</td>
                            <td>${eletronico.ativo }</td>
                            <td>
                              
                                <a href="#deleteEmployeeModal" class="delete" data-toggle="modal"><i
                                        class="material-icons" data-toggle="tooltip" title="Add" onclick="setaDadosModal('${eletronico.id }', '${eletronico.tipo }', '${eletronico.ativo }')">&#xE872;</i></a>
                                <a href="#addEstoque" class="confirm" data-toggle="modal"
                                    style="display:inline-block"><i class="material-icons" data-toggle="tooltip"
                                        title="Add" style="display:inline-block" onclick="setaEstoque('${eletronico.id }', '${eletronico.tipo }', '${eletronico.ativo }', '${eletronico.categoria.id }')">add</i></a>
                                        
                                    <form action="/macShop/Pages/visualizarProduto" method="POST">
            						    <input type="hidden" id="FormName" name="FormName" value="VHPRODUTO" />
            	 					<input type="hidden" id="FormName" name="txtStatus" value="${eletronico.ativo }" />	
            					    <input type="hidden" id="FormName" name="txtID" value="${eletronico.id }" />
            					     <input type="hidden" id="Tipo" name="Tipo" value="${eletronico.tipo }" />
            					     <input type="hidden" id="direcionamento" name="direcionamento" value="visualizar" />
            	      			  <input type="submit" class="btn mosh-btn mt-50" style="display:inline-block" name="btnOperacao" value="VISUALIZAR">
            					   </form>    
                                        
                       
                            
                          
                           
                              
                        </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
        <!-- Edit Modal HTML -->


        <div id="addEstoque" class="modal fade">
            <div class="modal-dialog">
                <div class="modal-content">
                    <form>
                        <div class="modal-header">
                            <h4 class="modal-title">Adicionar Estoque</h4>
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        </div>
                        
                        <form action="/macShop/Pages/alterarEletronico" method="post" billing-form bg-light p-3 p-md-5">
                        <div class="modal-body">
                            <div class="form-group">
                                <label for="firstname">Quantidade</label>
                                <div class="flex-w bo5 of-hidden w-size17">
                                    <button class="btn-num-product-down color1 flex-c-m size7 bg8 eff2">
                                        <i class="fs-12 fa fa-minus" aria-hidden="true"></i>
                                    </button>

                                    <input class="size8 m-text18 t-center num-product" type="number" name="txtEstoque"
                                        value="1">

                                    <button class="btn-num-product-up color1 flex-c-m size7 bg8 eff2">
                                        <i class="fs-12 fa fa-plus" aria-hidden="true"></i>
                                    </button>
                                </div>
                            </div>

                        </div>
                        <div class="modal-footer">
                            <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancelar">
                            <input type="hidden" name="txtID" id="txtIdentificacaoEstoque" value="txtID">
                        	<input type="hidden" name="Tipo" id="txtTipoEstoque" value="txtTipo">
                        	<input type="hidden" name="txtStatus" id="txtAtivoEstoque" value="txtAtivo">
                        	<input type="hidden" name="txtCategoria" id="txtCategoriaEstoque" value="txtCategoria">
                        	<input type="hidden" id="FormName" name="FormName" value="VHPRODUTO" />
                        	<input type="hidden" id="direcionamento" name="direcionamento" value="Estoque" />
                        	
                        	<button class="btn mosh-btn mt-50" id= "btnOperacaoSalvar" name="btnOperacao" value="ALTERAR">Salvar</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>

        <div id="inativar" class="modal fade">
            <div class="modal-dialog">
                <div class="modal-content">
                    <form>
                        <div class="modal-header">
                            <h4 class="modal-title">Ativar produto</h4>
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        </div>
                        <div class="modal-body">
                            <p>Tem certeza que deseja ativar o produto?</p>

                        </div>
                        <div class="modal-body">

                            <label for="towncity">Motivo</label>
                            <textarea class="form-control" name="message" placeholder=""></textarea>
                        </div>
                        <div class="modal-footer">
                            <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancelar">
                            <input type="submit" class="btn btn-info" value="Ativar">
                        </div>
                    </form>
                </div>
            </div>
        </div>






        <!-- Delete Modal HTML -->
        <div id="deleteEmployeeModal" class="modal fade">
            <div class="modal-dialog">
                <div class="modal-content">
                    
                        <div class="modal-header">
                            <h4 class="modal-title">Inativar produto</h4>
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        </div>
                        
                        
                        <div class="modal-body">
                            <p>Tem certeza que deseja inativar o produto? ${eletronico.id }</p>

                        </div>
                        <div class="modal-body">
						<form id="deleteEmployeeModal" method="post" action="/macShop/Pages/inativarProduto">
                            <label for="towncity">Motivo</label>
                            <textarea type="text" class="form-control"  id="txtMotivo"  placeholder="" name="txtMotivo" value=""></textarea>
                        </div>
                        
            
                        <div class="modal-footer">
                       
                        	
                        	<input type="hidden" name="txtID" id="txtIdentificacao" value="txtID">
                        	<input type="hidden" name="Tipo" id="txtTipo" value="txtTipo">
                        	<input type="hidden" name="txtStatus" id="txtAtivo" value="txtAtivo">
                        	<input type="hidden" id="FormName" name="FormName" value="VHPRODUTO" />
                        	<input type="hidden" id="FormName" name="txtCategoria" value="txtCategoria" />
                        	<button class="btn mosh-btn mt-50" id= "btnOperacaoSalvar" name="btnOperacao" value="INATIVAR">Inativar</button>
                       			 
                   			 </form>
                          
                     
                        </div>
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
    function setaDadosModal(valor, tipo, ativo) {
        document.getElementById("txtIdentificacao").value = valor ;
        document.getElementById("txtTipo").value = tipo ;
        document.getElementById("txtAtivo").value = ativo ;
    }
    </script>
    
    <script type="text/javascript">
    function setaEstoque(valor, tipo, ativo, categoria) {
        document.getElementById("txtIdentificacaoEstoque").value = valor ;
        document.getElementById("txtTipoEstoque").value = tipo ;
        document.getElementById("txtAtivoEstoque").value = ativo ;
        document.getElementById("txtCategoriaEstoque").value = categoria;
    }
    </script>
    <!--===============================================================================================-->
    <script src="../https://maps.googleapis.com/maps/api/js?key=AIzaSyAKFWBqlKAGCeS1rMVoaNlwyayu0e0YRes"></script>
    <script src="../js/map-custom.js"></script>
    <!--===============================================================================================-->
    <script src="../js/main.js"></script>

</body>

</html>