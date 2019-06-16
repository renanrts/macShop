	<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Cadastro de Produto</title>
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
    <section class="bg-title-page p-t-40 p-b-50 flex-col-c-m"
        style="background-image: url(../images/carrinho_banner.jpg);">
        <h2 class="l-text2 t-center">
            Cadastro de Produtos
        </h2>
    </section>



    <section class="bgwhite p-t-45 p-b-58">
        <div class="container">

            <!-- Tab01 -->
            <div class="tab01">
                <!-- Nav tabs -->
                <ul class="nav nav-tabs" role="tablist">
                    <li class="nav-item">
                        <a class="nav-link active" data-toggle="tab" href="#best-seller" role="tab">Eletrônico</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" data-toggle="tab" href="#featured" role="tab">Acessório</a>
                    </li>

                </ul>

                <!-- Tab panes -->
                <div class="tab-content p-t-35">

                    <div class="tab-pane fade show active" id="best-seller" role="tabpanel">
                        <section class="ftco-section">
                            <div class="container bgwhite p-t-35 p-b-80">
                                <div class="container">
                                    <div class="row justify-content-center">
                                        <div class="col-xl-8 ftco-animate">



                                            <form action="/macShop/Pages/cadastroEletronico" method="POST" class="billing-form bg-light p-3 p-md-5">
												

                                                <h3 class="mb-4 billing-heading">Cadastrar eletrônico</h3>
                                                <div class="row align-items-end">
                                                    <div class="col-md-6">
                                                        <div class="form-group">
                                                            <label for="firstname">Nome</label>
                                                            <input value="${eletronico.nome}" type="text" class="form-control" id="txtNome" name="txtNome" placeholder="">
                                                        </div>
                                                    </div>
                                                    <div class="col-md-6">
                                                        <div class="form-group">
                                                            <label for="lastname">Preço</label>
                                                            <input value="${eletronico.preco}" type="text" class="form-control" placeholder="" id="txtPreco" name="txtPreco">
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
                                                                     <c:forEach var="categoria" items="${resultado }" >
                                                            
                                                                      <option name="txtCategoria" value="${categoria.id }">${categoria.id } - ${categoria.descricao } ${eletronico.categoria.descricao}</option>
															
																     </c:forEach>   
																	   <option name="txtCategoria" value="${eletronico.categoria.id }">${eletronico.categoria.descricao } </option>
                                                                    </select>
                                      
                                                               
                                                                
                                                                
                                                                
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="w-100"></div>
                                                    <div class="col-md-6">
                                                        <div class="form-group">
                                                            <label for="streetaddress">Ano de Fabricação</label>
                                                            <input type="text" class="form-control" placeholder="" id="txtAnoFabricacao" name="txtAnoFabricacao" value="${eletronico.dataaFabricacao}">
                                                        </div>
                                                    </div>
                                                    <div class="col-md-6">
                                                        <div class="form-group">
                                                            <label for="streetaddress">Modelo</label>
                                                            <input type="text" class="form-control" placeholder="" id="txtModelo" name="txtModelo" value="${eletronico.modelo}">
                                                        </div>
                                                    </div>
                                                    <div class="w-100"></div>
                                                    <div class="col-md-6">
                                                        <div class="form-group">
                                                            <label for="towncity">Cor</label>
                                                            <input type="text" class="form-control" placeholder="" id="txtCor" name="txtCor" value="${eletronico.cor}">
                                                        </div>
                                                    </div>
                                                    <div class="col-md-6">
                                                        <div class="form-group">
                                                            <label for="postcodezip">Dimensões</label>
                                                            <input type="text" class="form-control" placeholder="" id="txtDimensoes" name="txtDimensoes" value="${eletronico.dimensoes}">
                                                        </div>
                                                    </div>
                                                    <div class="w-100"></div>
                                                    <div class="col-md-6">
                                                        <div class="form-group">
                                                            <label for="phone">Código de Barras</label>
                                                            <input type="text" class="form-control" placeholder="" id="txtCodBarras" name="txtCodBarras" value="${eletronico.codigoBarras}">
                                                        </div>
                                                    </div>
                                                    <div class="col-md-6">
                                                        <div class="form-group">
                                                            <label for="emailaddress">Foto do Produto</label>
                                                            <input type="text" class="form-control"
                                                                placeholder="Inserir o caminho da foto" id="txtFoto" name="txtFoto" value="${eletronico.caminhoFoto}">
                                                        </div>
                                                    </div>
                                                    <div class="w-100"></div>
                                                    <div class="col-md-6">
                                                        <div class="form-group">
                                                            <label for="towncity">Memória</label>
                                                            <input type="text" class="form-control" placeholder=""id="txtMemoria" name="txtMemoria" value="${eletronico.memoria}">
                                                        </div>
                                                    </div>
                                                    <div class="col-md-6">
                                                        <div class="form-group">
                                                            <label for="postcodezip">Processador</label>
                                                            <input type="text" class="form-control" placeholder="" id="txtProcessador" name="txtProcessador" value="${eletronico.processador}">
                                                        </div>
                                                    </div>
                                                    <div class="w-100"></div>
                                                    <div class="col-md-6">
                                                        <div class="form-group">
                                                            <label for="towncity">Tamanho Display</label>
                                                            <input type="text" class="form-control" placeholder="" id="txtTamanhoDisplay" name="txtTamanhoDisplay" value="${eletronico.tamanhoDisplay}">
                                                        </div>
                                                    </div>
                                                    <div class="col-md-6">
                                                        <div class="form-group">
                                                            <label for="postcodezip">Resolução Camera</label>
                                                            <input type="text" class="form-control" placeholder="" id="txtResolucaoCamera" name="txtResolucaoCamera" value="${eletronico.resolucaoCamera}">
                                                        </div>
                                                    </div>
                                                    <div class="w-100"></div>
                                                    <div class="col-md-6">
                                                        <div class="form-group">
                                                            <label for="towncity">Conteúdo da embalagem</label>
                                                            <input type="text" class="form-control" placeholder="" id="txtConteudoEmbalagem" name="txtConteudoEmbalagem" value="${eletronico.conteudoEmbalagem}">
                                                        </div>
                                                    </div>
                                                    <div class="col-md-6">
                                                        <div class="form-group">
                                                            <label for="postcodezip">Alimentação</label>
                                                            <input type="text" class="form-control" placeholder="" id="txtAlimentacao" name="txtAlimentacao" value="${eletronico.alimentacao}">
                                                        </div>
                                                    </div>
                                                    <div class="w-100"></div>
                                                    <div class="col-md-6">
                                                        <div class="form-group">
                                                            <label for="towncity">RAM</label>
                                                            <input type="text" class="form-control" placeholder="" id="txtRAM" name="txtRAM" value="${eletronico.RAM}">
                                                        </div>
                                                    </div>
                                                    <div class="col-md-6">
                                                        <div class="form-group">
                                                            <label for="postcodezip">Sistema Operacional</label>
                                                            <input type="text" class="form-control" placeholder="" id="txtSO" name="txtSO" value="${eletronico.sistemaOperacional}">
                                                        </div>
                                                    </div>
                                                    <div class="w-100"></div>
                                                    <div class="col-md-12">
                                                        <div class="form-group">
                                                            <label for="towncity">Descrição</label>
                                                            <textarea type="text" class="form-control" value="" placeholder="" id="txtDescricao" name="txtDescricao" value="${eletronico.descricao}">${eletronico.descricao}</textarea>
                                                        </div>
                                                    </div>
                                          

                                                </div>
                                                <div class="w-100"></div>
                                                <div class="col-md-12">
                                                    <div class="form-group mt-4">
                                                        <center>
                                                            <div class="header-cart-wrapbtn">
                                                                <!-- Button -->
                                                                <input type="hidden" id="FormName" name="FormName" value="VHPRODUTO" />
                                                                <input type="hidden" id="Tipo" name="Tipo" value="VHELETRONICO" />
                                                                <input type="hidden" id="FormName" name="txtCat" value="${eletronico.categoria.id }" />
                                                                <button class="btn mosh-btn mt-50" id= "btnOperacaoSalvar" name="btnOperacao" value="SALVAR">Salvar</button>
                                                             
                                                            </div>
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

                    <!-- - -->
                    <div class="tab-pane fade" id="featured" role="tabpanel">
                        <section class="ftco-section">
                            <div class="container bgwhite p-t-35 p-b-80">
                                <div class="container">
                                    <div class="row justify-content-center">
                                        <div class="col-xl-8 ftco-animate">



                                            <form action="/macShop/Pages/cadastroAcessorio" class="billing-form bg-light p-3 p-md-5">



                                                <h3 class="mb-4 billing-heading">Cadastrar acessório</h3>
                                                <div class="row align-items-end">
                                                    <div class="col-md-6">
                                                        <div class="form-group">
                                                            <label for="firstname">Nome</label>
                                                            <input value="${acessorio.nome}" type="text" class="form-control" id="txtNomeProd" name="txtNome" placeholder="">
                                                        </div>
                                                    </div>
                                                    <div class="col-md-6">
                                                        <div class="form-group">
                                                            <label for="lastname">Preço</label>
                                                            <input value="${acessorio.preco}" type="text" class="form-control" id="txtPrecoProd" name="txtPreco" placeholder="">
                                                        </div>
                                                    </div>
                                                    <div class="w-100"></div>
                                                    <div class="col-md-12">
                                                        <div class="form-group">
                                                            <label for="country">Categoria</label>
                                                            <div class="select-wrap">
                                                                <div class="icon"><span class="ion-ios-arrow-down"></span></div>
                                                                <select name="txtCategoria" id="txtCategoria" class="form-control">
                                                                     <option name="txtCategoria" value="4">Acessórios</option>
                                                                </select>
                                                            </div>
                                                        </div>
                                                    </div>
                                                  <div class="w-100"></div>
                                                    <div class="col-md-6">
                                                        <div class="form-group">
                                                            <label for="streetaddress">Ano de Fabricação</label>
                                                               <input type="text" class="form-control" placeholder="" id="txtAnoFabricacaoProd" name="txtAnoFabricacao" value="${acessorio.dataaFabricacao}">

                                                        </div>
                                                    </div>
                                                     <div class="col-md-6">
                                                        <div class="form-group">
                                                            <label for="towncity">Modelos Compatíveis</label>
                                                            <input type="text" class="form-control"
                                                                placeholder="" id="txtModeloCompativel" name="txtModeloCompativel" value="${acessorio.modeloCompativel}">
                                                        </div>
                                                    </div>
           
                                                    <div class="w-100"></div>
                                                    <div class="col-md-6">
                                                        <div class="form-group">
                                                            <label for="towncity">Cor</label>
                                                            <input type="text" class="form-control" placeholder="" id="txtCorProd" name="txtCor" value="${acessorio.cor}">
                                                        </div>
                                                    </div>
                                                    <div class="col-md-6">
                                                        <div class="form-group">
                                                            <label for="postcodezip">Dimensões</label>
                                                              <input type="text" class="form-control" placeholder="" id="txtDimensoesProd" name="txtDimensoes" value="${acessorio.dimensoes}">
                                                        </div>
                                                    </div>
                                                    <div class="w-100"></div>
                                                    <div class="col-md-6">
                                                        <div class="form-group">
                                                            <label for="phone">Código de Barras</label>
                                                         		<input type="text" class="form-control" placeholder="" id="txtCodBarrasProd" name="txtCodBarras" value="${acessorio.codigoBarras}">
                                                        </div>
                                                    </div>
                                                    <div class="col-md-6">
                                                        <div class="form-group">
                                                            <label for="emailaddress">Foto do Produto</label>
                                                           <input type="text" class="form-control"
                                                                placeholder="Inserir o caminho da foto" id="txtFotoProd" name="txtFoto" value="${acessorio.caminhoFoto}">
                                                        </div>
                                                    </div>
                                                    
                                                   
                                                 

                                                    <div class="w-100"></div>
                                                    <div class="col-md-12">
                                                        <div class="form-group">
                                                            <label for="towncity">Descrição</label>
                                                          <textarea type="text" class="form-control" value="" placeholder="" id="txtDescricaoProd" name="txtDescricao" value="${acessorio.descricao}">${acessorio.descricao}</textarea>
                                                        </div>
                                                    </div>

                                                   
                                                    <div class="form-group">
                                                        <div class="col-md-12">
                                                            <div class="checkbox">
                                                                <label><input type="checkbox" class="mr-2" name="txtMFI" value="Ativo"> O
                                                                    acessório possui selo MFI.</label>
                                                            </div>
                                                        </div>
                                                    </div>

                                                </div>
                                                <div class="w-100"></div>
                                                <div class="col-md-12">
                                                    <div class="form-group mt-4">
                                                        <center>
                                                            <div class="header-cart-wrapbtn">
                                                                <!-- Button -->
																<input type="hidden" id="FormName" name="FormName" value="VHPRODUTO" />
                                                                <input type="hidden" id="FormName" name="txtCat" value="4" />
                                                                <input type="hidden" id="Tipo" name="Tipo" value="VHACESSORIO" />
                                                                <button class="btn mosh-btn mt-50" id= "btnOperacaoSalvarProd" name="btnOperacao" value="SALVAR">Salvar</button>
                                                            </div>
                                                        </center>
                                                    </div>
                                                </div>
                                        </div>
                                        </form><!-- END -->
                                    </div> <!-- .col-md-8 -->
                                </div>
                            </div>
                        </section> <!-- .section -->





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

    <!--===============================================================================================-->
    <script type="text/javascript" src="../vendor/slick/slick.min.js"></script>
    <script type="text/javascript" src="../js/slick-custom.js"></script>
    <!--===============================================================================================-->
    <script type="text/javascript" src="../vendor/sweetalert/sweetalert.min.js"></script>
   

    <!--===============================================================================================-->
    <script src="../js/main.js"></script>

</body>
</html>