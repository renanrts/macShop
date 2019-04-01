<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <title>Checkout</title>
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
                <a href="../index.jsp" class="logo">
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
            <a href="../index.jsp" class="logo-mobile">
                <img src="../images/icons/logo.png" alt="IMG-LOGO">
            </a>

            <!-- Button show menu -->
            <div class="btn-show-menu">
                <!-- Header Icon mobile -->
                <div class="header-icons-mobile">
                    <a href="../#" class="header-wrapicon1 dis-block">
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
                        <a href="../index.jsp">Home</a>

                    </li>

                    <li class="item-menu-mobile">
                        <a href="../product.jsp">Catálogo de Produtos</a>
                    </li>

                    <li class="item-menu-mobile">
                        <a href="../contact.jsp">Contato</a>
                    </li>

                    <li class="item-menu-mobile">
                        <a href="../index.jsp">Área Cliente</a>
                        <ul class="sub-menu">
                            <li><a href="../area-cli.jsp"">Meus Dados</a></li>
								<li><a href="../ pedidos-cli.jsp">Pedidos</a></li>
                            <li><a href="../#">Logout</a></li>
                        </ul>
                        <i class="arrow-main-menu fa fa-angle-right" aria-hidden="true"></i>
                    </li>

                    <li class="item-menu-mobile">
                        <a href="../index.jsp">Área Admin</a>
                        <ul class="sub-menu">
                            <li><a href="../consulta-cli.jsp">Consultar Clientes</a></li>
                            <li><a href="../consulta-prod.jsp">Produtos</a></li>
                            <li><a href="../troca.jsp">Consultar Trocas</a></li>
                            <li><a href="../pedidos-adm.jsp">Consultar Pedidos</a></li>
                            <li><a href="../relatorio.jsp">Relatórios</a></li>
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
            Área do Cliente
        </h2>
    </section>



    <section class="bgwhite p-t-45 p-b-58">
        <div class="container">

            <!-- Tab01 -->
            <div class="tab01">
                <!-- Nav tabs -->
                <ul class="nav nav-tabs" role="tablist">
                    <li class="nav-item">
                        <a class="nav-link active" data-toggle="tab" href="#best-seller" role="tab">Meus dados</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" data-toggle="tab" href="#categoria" role="tab">Alterar Senha</a>
                    </li>

                    <li class="nav-item">
                        <a class="nav-link" data-toggle="tab" href="#endereco" role="tab">Endereços de Entrega</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" data-toggle="tab" href="#pagamento" role="tab">Formas de Pagamento</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" data-toggle="tab" href="#cupom" role="tab">Meus cupons</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" data-toggle="tab" href="#exclusao" role="tab">Excluir conta</a>
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



                                            <form action="#" class="billing-form bg-light p-3 p-md-5">


                                                <h3 class="mb-4 billing-heading">Dados pessoais</h3>
                                                <div class="row align-items-end">
                                                    <div class="col-md-6">
                                                        <div class="form-group">
                                                            <label for="firstname">Nome</label>
                                                            <input value="${cliente.nome}" type="text" class="form-control" id="txtNome" name="txtNome" placeholder="">
                                                        </div>
                                                    </div>
                                                    <div class="col-md-6">
                                                        <div class="form-group">
                                                            <label for="lastname">Gênero</label>
                                                            <input name="txtGenero" value="${cliente.genero }" READONLY>
                                                        </div>
                                                    </div>

                                                    <div class="w-100"></div>
                                                    <div class="col-md-6">
                                                        <div class="form-group">
                                                            <label for="streetaddress">Data de Nascimento</label>
                                                          <input value="${cliente.dataNascimento}" type="text" class="form-control" id="txtDataNascimento" name="txtDataNascimento" placeholder=""  READONLY>

                                                        </div>
                                                    </div>
                                                    <div class="col-md-6">
                                                        <div class="form-group">
                                                            <label for="streetaddress">CPF</label>
                                           <input value="${cliente.cpf}" type="text" class="form-control" id="txtCPF" name="txtCPF" placeholder="" onread="mascara(this, '###.###.###-##')" maxlength="11" READONLY>

                                                        </div>
                                                    </div>
                                                    <div class="w-100"></div>
<div class="col-md-3">
                                            <div class="form-group">
                                               <label for="towncity">Tipo Telefone</label>
                                              
												   <input name="txtTipoTelefone" value="${cliente.telefone.tipoTelefone }" >
												
                                            </div>
                                        </div>
                                        <div class="col-md-3">
                                            <div class="form-group">
                                           		 <label for="towncity">DDD</label>
                                                <input value="${cliente.telefone.ddd}" type="text" class="form-control" id="txtDDD" name="txtDDD" placeholder=""  maxlength="2" >
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-group">
												<label for="towncity">Número</label>
                                                <input value="${cliente.telefone.numero}" type="text" class="form-control" id="txtNumeroTel" name="txtNumeroTel" placeholder="" >
                                            </div>
                                        </div>
                                                    <div class="col-md-6">
                                                        <div class="form-group">
                                                            <label for="postcodezip">E-mail</label>
                                                             <input value="${cliente.email}" type="text" class="form-control" id="txtEmail" name="txtEmail" placeholder="" READONLY>
                                                        </div>
                                                    </div>

                                                    <div class="w-100"></div>
                                                    <div class="col-md-12">
                                                        <div class="form-group mt-4">
                                                            <center>
                                                                <div class="header-cart-wrapbtn">
                                                                    <!-- Button -->
                                                                    <a href="#"
                                                                        class="flex-c-m size1 bg1 bo-rad-20 hov1 s-text1 trans-0-4">
                                                                        Salvar
                                                                    </a>
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



                    <!-- - -->
                    <div class="tab-pane fade" id="categoria" role="tabpanel">
                        <section class="ftco-section">
                            <div class="container bgwhite p-t-35 p-b-80">
                                <div class="container">
                                    <div class="row justify-content-center">
                                        <div class="col-xl-8 ftco-animate">



                                            <form action="#" class="billing-form bg-light p-3 p-md-5">


                                                <h3 class="mb-4 billing-heading">Senha</h3>
                                                <div class="row align-items-end">

                                                    <div class="w-100"></div>
                                                    <div class="col-md-6">
                                                        <div class="form-group">
                                                            <label for="phone">Senha</label>
                                                            <input type="text" class="form-control" placeholder="">
                                                        </div>
                                                    </div>
                                                    <div class="col-md-6">
                                                        <div class="form-group">
                                                            <label for="emailaddress">Repetir senha</label>
                                                            <input type="text" class="form-control" placeholder="">
                                                        </div>
                                                    </div>

                                                </div>
                                                <div class="w-100"></div>
                                                <div class="col-md-12">
                                                    <div class="form-group mt-4">
                                                        <center>
                                                            <div class="header-cart-wrapbtn">
                                                                <!-- Button -->
                                                                <a href="#"
                                                                    class="flex-c-m size1 bg1 bo-rad-20 hov1 s-text1 trans-0-4">
                                                                    Salvar
                                                                </a>
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
                    <div class="tab-pane fade" id="endereco" role="tabpanel">
                        <section class="ftco-section">
                            <div class="container bgwhite p-t-35 p-b-80">
                                <div class="container">
                                    <div class="row justify-content-center">
                                        <div class="col-xl-8 ftco-animate">



                                            <form action="#" class="billing-form bg-light p-3 p-md-5">
                                                <h3 class="mb-4 billing-heading">Selecionar endereço de entrega
                                                    preferencial</h3>
                                                <div class="row align-items-end">

                                                    <div class="billing-form bg-light p-md-4">
														<c:forEach var="eletronico" items="${entrega }" >
                                                        <div class="form-group">
                                                            <div class="col-md-12">
                                                                <div class="radio">
                                                                    <label><input type="radio" name="optradio"
                                                                            class="mr-2" >${eletronico.tipoEndereco } - ${eletronico.tipoLogradouro  } - ${eletronico.logradouro } </label>
                                                                    <a href="#alterarEndereco" class="edit"
                                                                        data-toggle="modal"><i class="material-icons"
                                                                            data-toggle="tooltip"
                                                                            title="Edit" onclick="setaDadosModal('${eletronico.tipoEndereco }', '${eletronico.tipoLogradouro  }', '${eletronico.logradouro }' , '${eletronico.numero }' , '${eletronico.cidade.estado.nome }', '${eletronico.cidade.nome }' , '${eletronico.cep }', '${eletronico.observacao }')">&#xE254;</i></a>
                                                                    <a href="#inativar" class="delete"
                                                                        data-toggle="modal"><i class="material-icons"
                                                                            data-toggle="tooltip"
                                                                            title="Add">&#xE872;</i></a>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        </c:forEach>
                                                       

                                                    </div>

                                                    <div class="w-100"></div>
                                                    <hr>
                                                    <h3 class="mb-4 billing-heading">Cadastrar novo endereço de entrega
                                                    </h3>
                                                    <div class="w-100"></div>
                                                    <div class="col-md-6">
                                                        <div class="form-group">
                                                            <label for="streetaddress">Tipo de residência</label>
                                                            <input type="text" class="form-control"
                                                                placeholder="Casa, apartamento...">
                                                        </div>
                                                    </div>
                                                    <div class="col-md-6">
                                                        <div class="form-group">
                                                            <label for="streetaddress">Tipo de logradouro</label>
                                                            <input type="text" class="form-control" placeholder="">
                                                        </div>
                                                    </div>
                                                    <div class="w-100"></div>
                                                    <div class="col-md-6">
                                                        <div class="form-group">
                                                            <label for="streetaddress">Logradouro</label>
                                                             <input value="${cliente.listEnderecos[0].logradouro}" type="text" class="form-control" id="txtLogradouro" name="txtLogradouro" placeholder="" >
                                                        </div>
                                                    </div>
                                                    <div class="col-md-6">
                                                        <div class="form-group">
                                                            <input type="text" class="form-control"
                                                                placeholder="Número">
                                                        </div>
                                                    </div>

                                                    <div class="col-md-6">
                                                        <div class="form-group">
                                                            <label for="country">País</label>
                                                            <div class="select-wrap">
                                                                <div class="icon"><span
                                                                        class="ion-ios-arrow-down"></span></div>
                                                                <select name="" id="" class="form-control">
                                                                    <option value="">Brasil</option>
                                                                    <option value="">Canadá</option>
                                                                </select>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-6">
                                                        <div class="form-group">
                                                            <label for="country">Estado</label>
                                                            <div class="select-wrap">
                                                                <div class="icon"><span
                                                                        class="ion-ios-arrow-down"></span></div>
                                                                <select name="" id="" class="form-control">
                                                                    <option value="">São Paulo</option>
                                                                    <option value="">Rio de Janeiro</option>
                                                                </select>
                                                            </div>
                                                        </div>
                                                    </div>

                                                    <div class="w-100"></div>
                                                    <div class="col-md-6">
                                                        <div class="form-group">
                                                            <label for="country">Cidade</label>
                                                            <div class="select-wrap">
                                                                <div class="icon"><span
                                                                        class="ion-ios-arrow-down"></span></div>
                                                                <select name="" id="" class="form-control">
                                                                    <option value="">São Paulo</option>
                                                                    <option value="">Mogi das Cruzes</option>
                                                                </select>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-6">
                                                        <div class="form-group">
                                                            <label for="postcodezip">CEP</label>
                                                            <input type="text" class="form-control" placeholder="">
                                                        </div>
                                                    </div>

                                                    <div class="col-md-12">
                                                        <div class="col-md-13">
                                                            <div class="form-group">
                                                                <label for="towncity">Observações</label>
                                                                <textarea class="form-control" name="message"
                                                                    placeholder=""></textarea>
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
                                                                <a href="#"
                                                                    class="flex-c-m size1 bg1 bo-rad-20 hov1 s-text1 trans-0-4">
                                                                    Salvar
                                                                </a>
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
                    <div class="tab-pane fade" id="pagamento" role="tabpanel">
                        <section class="ftco-section">
                            <div class="container bgwhite p-t-35 p-b-80">
                                <div class="container">
                                    <div class="row justify-content-center">
                                        <div class="col-xl-8 ftco-animate">



                                            <form action="#" class="billing-form bg-light p-3 p-md-5">
                                                <h3 class="mb-4 billing-heading">Selecionar cartão preferencial</h3>
                                                <div class="row align-items-end">

                                                    <div class="billing-form bg-light p-md-4">

                                                        <div class="form-group">
                                                            <div class="col-md-12">
                                                                <div class="radio">
                                                                    <label><input type="radio" name="optradio"
                                                                            class="mr-2">Cartão 1</label>
                                                                    <a href="#alterarCartao" class="edit"
                                                                        data-toggle="modal"><i class="material-icons"
                                                                            data-toggle="tooltip" title="Edit"
                                                                            style="display: align-right">&#xE254;</i></a>
                                                                    <a href="#inativarCartao" class="delete"
                                                                        data-toggle="modal"><i class="material-icons"
                                                                            data-toggle="tooltip"
                                                                            title="Add">&#xE872;</i></a>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="form-group">
                                                            <div class="col-md-12">
                                                                <div class="radio">
                                                                    <label><input type="radio" name="optradio"
                                                                            class="mr-2">Cartão 2</label>
                                                                    <a href="#alterarCartao" class="edit"
                                                                        data-toggle="modal"><i class="material-icons"
                                                                            data-toggle="tooltip" title="Edit"
                                                                            style="display: align-right">&#xE254;</i></a>
                                                                    <a href="#inativarCartao" class="delete"
                                                                        data-toggle="modal"><i class="material-icons"
                                                                            data-toggle="tooltip"
                                                                            title="Add">&#xE872;</i></a>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="form-group">
                                                            <div class="col-md-12">
                                                                <div class="radio">
                                                                    <label><input type="radio" name="optradio"
                                                                            class="mr-2">Cartão 3</label>
                                                                    <a href="#alterarCartao" class="edit"
                                                                        data-toggle="modal"><i class="material-icons"
                                                                            data-toggle="tooltip" title="Edit"
                                                                            style="display: align-right">&#xE254;</i></a>
                                                                    <a href="#inativarCartao" class="delete"
                                                                        data-toggle="modal"><i class="material-icons"
                                                                            data-toggle="tooltip"
                                                                            title="Add">&#xE872;</i></a>
                                                                </div>
                                                            </div>
                                                        </div>

                                                    </div>

                                                    <div class="w-100"></div>
                                                    <h3 class="mb-4 billing-heading">Cadastrar novo cartão de crédito
                                                    </h3>
                                                    <div class="row align-items-end">
                                                        <div class="col-md-4">
                                                            <div class="form-group">
                                                                <label for="country">Bandeira</label>
                                                                <div class="select-wrap">
                                                                    <div class="icon"><span
                                                                            class="ion-ios-arrow-down"></span></div>
                                                                    <select name="" id="" class="form-control">
                                                                        <option value="">Visa</option>
                                                                        <option value="">Master</option>
                                                                    </select>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="col-md-8">
                                                            <div class="form-group">
                                                                <label for="postcodezip">Número</label>
                                                                <input type="text" class="form-control" placeholder="">
                                                            </div>
                                                        </div>


                                                        <div class="w-100"></div>

                                                        <div class="col-md-12">
                                                            <div class="form-group">
                                                                <label for="postcodezip">Nome</label>
                                                                <input type="text" class="form-control"
                                                                    placeholder="Nome impresso no cartão">
                                                            </div>
                                                        </div>

                                                        <div class="col-md-4">
                                                            <div class="form-group">
                                                                <label for="postcodezip">Código de Segurança</label>
                                                                <input type="text" class="form-control" placeholder="">
                                                            </div>
                                                        </div>









                                                    </div>
                                                    <div class="w-100"></div>
                                                    <div class="col-md-12">
                                                        <div class="form-group mt-4">
                                                            <center>
                                                                <div class="header-cart-wrapbtn">
                                                                    <!-- Button -->
                                                                    <a href="#"
                                                                        class="flex-c-m size1 bg1 bo-rad-20 hov1 s-text1 trans-0-4">
                                                                        Salvar
                                                                    </a>
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
                    <!-- - -->
                    <div class="tab-pane fade" id="cupom" role="tabpanel">
                        <section class="ftco-section">
                            <div class="container bgwhite p-t-35 p-b-80">
                                <div class="container">
                                    <div class="row justify-content-center">
                                        <div class="col-xl-8 ftco-animate">



                                            <form action="#" class="billing-form bg-light p-3 p-md-5">


                                                <h3 class="mb-4 billing-heading">Meus cupons</h3>
                                                <div class="row align-items-end">

                                                    <div class="w-100"></div>
                                                    <div class="col-md-6">
                                                        <div class="form-group">
                                                            <label for="phone">Código</label>
                                                            <input type="text" class="form-control" placeholder="">
                                                        </div>
                                                    </div>
                                                    <div class="col-md-6">
                                                        <div class="form-group">
                                                            <label for="phone">Valor</label>
                                                            <input type="text" class="form-control" placeholder="">
                                                        </div>
                                                    </div>

                                                </div>

                                        </div>
                                        </form><!-- END -->
                                    </div> <!-- .col-md-8 -->
                                </div>
                            </div>
                        </section> <!-- .section -->

                    </div>
                    <div class="tab-pane fade" id="exclusao" role="tabpanel">
                        <section class="ftco-section">
                            <div class="container bgwhite p-t-35 p-b-80">
                                <div class="container">
                                    <div class="row justify-content-center">
                                        <div class="col-xl-8 ftco-animate">



                                            <form action="#" class="billing-form bg-light p-3 p-md-5">
                                                <h3 class="mb-4 billing-heading">Excluir conta</h3>
                                                <div class="row align-items-end">

                                                    <div class="billing-form bg-light p-md-4">

                                                        <div class="form-group">
                                                            <div class="col-md-12">
                                                                <div class="form-group">
                                                                    <div class="col-md-12">
                                                                        <div class="checkbox">
                                                                            <label><input type="checkbox" value=""
                                                                                    class="mr-2"> Desejo realmente
                                                                                excluir minha conta.</label>
                                                                        </div>
                                                                    </div>
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
                                                                    <a href="#"
                                                                        class="flex-c-m size1 bg1 bo-rad-20 hov1 s-text1 trans-0-4">
                                                                        Excluir
                                                                    </a>
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




                    <div id="alterarEndereco" class="modal fade">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <form>
                                    <div class="modal-header">
                                        <h4 class="modal-title">Alterar Endereço</h4>
                                        <button type="button" class="close" data-dismiss="modal"
                                            aria-hidden="true">&times;</button>
                                    </div>
                                    <div class="modal-body" style="background: #ecf0f1;">
                                        <div class="row align-items-end">
                                            <div class="w-100"></div>
                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <label for="streetaddress">Tipo de residência</label>
                                                 <input type="text" class="form-control" id="txtTipoEndereco" name="txtTipoEndereco"  placeholder="" value="${eletronico.tipoEndereco}">
                                                </div>
                     		
                                            </div>
                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <label for="streetaddress">Tipo de logradouro</label>
                                                    <input type="text" class="form-control" id="txtTipoLogradouro" name="txtTipoLogradouro"  placeholder="" value="${eletronico.tipoLogradouro}">
                                                </div>
                                            </div>
                                            <div class="w-100"></div>
                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <label for="streetaddress">Logradouro</label>
                                                    <input type="text" class="form-control" placeholder="" id="txtLogradouro" name="txtLogradouro" value="${eletronico.logradouro}">
                                                </div>
                                            </div>
                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <input type="text" class="form-control" placeholder="Número">
                                                </div>
                                            </div>

                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <label for="country">País</label>
                                                    <div class="select-wrap">
                                                        <div class="icon"><span class="ion-ios-arrow-down"></span></div>
                                                        <select name="" id="" class="form-control">
                                                            <option value="">Brasil</option>
                                                           
                                                        </select>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <label for="country">Estado</label>
                                                    <input type="text" class="form-control" id="txtEstado" name="txtEstado"  placeholder="" value="${eletronico.cidade.estado.nome}">
                                                </div>
                                            </div>

                                            <div class="w-100"></div>
                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <label for="country">Cidade</label>
                                                <input type="text" class="form-control" id="txtCidade" name="txtCidade"  placeholder="" value="${eletronico.cidade.nome}">

                                                </div>
                                            </div>
                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <label for="postcodezip">CEP</label>
                                                    <input type="text" class="form-control" id="txtCep" name="txtCep"  placeholder="" value="${eletronico.cep}">
                                                </div>
                                            </div>

                                            <div class="col-md-12">
                                                <div class="col-md-13">
                                                    <div class="form-group">
                                                        <label for="towncity">Observações</label>
                                                        <input type="text" class="form-control" id="txtObs" name="txtObs"  placeholder="" value="${eletronico.observacao}">
                                                    </div>
                                                </div>
                                            </div>

                                        </div>



                                    </div>

                                    <div class="modal-footer">
                                        <input type="button" class="btn btn-default" data-dismiss="modal"
                                            value="Cancelar">
                                        <input type="submit" class="btn btn-info" value="Salvar">
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>













                    <div id="inativarCartao" class="modal fade">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <form>
                                    <div class="modal-header">
                                        <h4 class="modal-title">Excluir cartão</h4>
                                        <button type="button" class="close" data-dismiss="modal"
                                            aria-hidden="true">&times;</button>
                                    </div>
                                    <div class="modal-body">
                                        <p>Tem certeza que deseja excluir o cartão?</p>

                                    </div>

                                    <div class="modal-footer">
                                        <input type="button" class="btn btn-default" data-dismiss="modal"
                                            value="Cancelar">
                                        <input type="submit" class="btn btn-danger" value="Excluir">
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
                                        <h4 class="modal-title">Excluir endereço</h4>
                                        <button type="button" class="close" data-dismiss="modal"
                                            aria-hidden="true">&times;</button>
                                    </div>
                                    <div class="modal-body">
                                        <p>Tem certeza que deseja excluir o endereço?</p>

                                    </div>

                                    <div class="modal-footer">
                                        <input type="button" class="btn btn-default" data-dismiss="modal"
                                            value="Cancelar">
                                        <input type="submit" class="btn btn-danger" value="Excluir">
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>


                    <div id="alterarCartao" class="modal fade">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <form>
                                    <div class="modal-header">
                                        <h4 class="modal-title">Alterar Cartão</h4>
                                        <button type="button" class="close" data-dismiss="modal"
                                            aria-hidden="true">&times;</button>
                                    </div>
                                    <div class="modal-body" style="background: #ecf0f1;">

                                        <div class="row align-items-end">
                                            <div class="col-md-4">
                                                <div class="form-group">
                                                    <label for="country">Bandeira</label>
                                                    <div class="select-wrap">
                                                        <div class="icon"><span class="ion-ios-arrow-down"></span></div>
                                                        <select name="" id="" class="form-control">
                                                            <option value="">Visa</option>
                                                            <option value="">Master</option>
                                                        </select>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-md-8">
                                                <div class="form-group">
                                                    <label for="postcodezip">Número</label>
                                                    <input type="text" class="form-control" placeholder="">
                                                </div>
                                            </div>


                                            <div class="w-100"></div>

                                            <div class="col-md-12">
                                                <div class="form-group">
                                                    <label for="postcodezip">Nome</label>
                                                    <input type="text" class="form-control"
                                                        placeholder="Nome impresso no cartão">
                                                </div>
                                            </div>

                                            <div class="col-md-4">
                                                <div class="form-group">
                                                    <label for="postcodezip">Código de Segurança</label>
                                                    <input type="text" class="form-control" placeholder="">
                                                </div>
                                            </div>





                                        </div>

                                        <div class="modal-footer">
                                            <input type="button" class="btn btn-default" data-dismiss="modal"
                                                value="Cancelar">
                                            <input type="submit" class="btn btn-danger" value="Excluir">
                                        </div>
                                </form>
                            </div>
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
                    aria-hidden="true"></i> by <a href="../https://colorlib.com" target="_blank">Colorlib</a>
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

<script type="text/javascript">
    function setaDadosModal(valor, tipo, ativo, numero, estado, cidade, cep, obs) {
        document.getElementById("txtTipoEndereco").value = valor ;
        document.getElementById("txtTipoLogradouro").value = tipo ;
        document.getElementById("txtLogradouro").value = ativo ;
        document.getElementById("txtNumero").value = numero ;
        document.getElementById("txtEstado").value = estado ;
        document.getElementById("txtCidade").value = cidade ;
        document.getElementById("txtCep").value = cep ;
        document.getElementById("txtObs").value = obs ;
        
    }
    </script>
    <!--===============================================================================================-->
    <script src="../js/main.js"></script>
	
</body>
</html>