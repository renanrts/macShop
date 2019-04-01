	<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Cadastro de Cliente</title>
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
                                <a href="contact?btnOperacao=CONSULTAR&FormName=VHCLIENTE&txtID=9">Contato</a>
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

    <!-- Title Page -->
    <section class="bg-title-page p-t-40 p-b-50 flex-col-c-m"
        style="background-image: url(../images/carrinho_banner.jpg);">
        <h2 class="l-text2 t-center">
            Cadastro de Cliente
        </h2>
    </section>

<c:forEach items="${erro}" var="msg">
<label style="color:red;">${msg}</label><br/>
</c:forEach>
	                    <c:forEach items="${sucesso}" var="msg">
	                        <label style="color:green;">${msg}</label><br/>
	                    </c:forEach>

    <section class="bgwhite p-t-45 p-b-58">
        <div class="container">
            <section class="ftco-section">
                <div class="container bgwhite p-t-35 p-b-80">
                    <div class="container">
                        <div class="row justify-content-center">
                            <div class="col-xl-8 ftco-animate">



                                <form action="/macShop/Pages/cadastroCliente" method="POST" class="billing-form bg-light p-3 p-md-5">


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
                                                
                                                 <select name="txtGenero" id="txtGenero" class="form-control">
                                                                     <c:forEach var="genero" items="${baseCadastro.listaGenero }" >
                                                            
                                                                      <option name="txtGenero" value="${genero }">${genero }</option>
															
																     </c:forEach>   
																 <option name="txtGenero" value="${cliente.genero }">${cliente.genero }</option>
                                                      </select>
                                                
                                                
                                            </div>
                                        </div>

                                        <div class="w-100"></div>
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label for="streetaddress">Data de Nascimento</label>
                                                <input value="${cliente.dataNascimento}" type="date" class="form-control" id="txtDataNascimento" name="txtDataNascimento" placeholder=""  maxlength="10" autocomplete="off">

                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label for="streetaddress">CPF</label>
                                                  <input value="${cliente.cpf}" type="text" class="form-control" id="txtCPF" name="txtCPF" placeholder="" onread="mascara(this, '###.###.###-##')" maxlength="11" >

                                            </div>
                                        </div>
                                        <div class="w-100"></div>
                                        
                                        <div class="col-md-3">
                                            <div class="form-group">
                                               <label for="towncity">Tipo Telefone</label>
                                                <select name="txtTipoTelefone" id="txtCategoria" class="form-control">
	                                               <c:forEach var="tipoTelefone" items="${baseCadastro.listaTipoTelefone }" >
	                                                    <option name="txtTipoTelefone" value="${tipoTelefone }">${tipoTelefone }</option>
												   </c:forEach>  
												   <option name="txtTipoTelefone" value="${cliente.telefone.tipoTelefone }">${cliente.telefone.tipoTelefone }</option>
												   </select>
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
                                        <div class="w-100"></div>
                                        <div class="col-md-12">
                                            <div class="form-group">
                                                <label for="postcodezip">E-mail</label>
                                                 <input value="${cliente.email}" type="text" class="form-control" id="txtEmail" name="txtEmail" placeholder="" >

                                            </div>
                                        </div>
                                      
                                        <div class="w-100"></div>
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label for="phone">Senha</label>
                                                <input value="" type="text" class="form-control" id="txtSenha1" name="txtSenha1" placeholder="" >
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label for="emailaddress">Repetir senha</label>
                                                <input value="" type="text" class="form-control" id="txtSenha2" name="txtSenha2" placeholder="" >
                                            </div>
                                        </div>
										
                                        <div class="w-100"></div>
                                        <hr>
                                        <h3 class="mb-4 billing-heading">Endereço de Cobrança</h3>
                                        <div class="w-100"></div>
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label for="streetaddress">Tipo de residência</label>
                                                <select name="txtTipoEndereco" id="txtCategoria" class="form-control">
                                                  <c:forEach var="listaTipoEndereco" items="${baseCadastro.listaTipoEndereco }" >
                                                            
                                                                      <option name="txtTipoEndereco" value="${listaTipoEndereco }">${listaTipoEndereco }</option>
															
																     </c:forEach>  
																     <option name="txtTipoEndereco" value="${cliente.listEnderecos[0].tipoEndereco }">${cliente.listEnderecos[0].tipoEndereco}</option>
																     </select>
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label for="streetaddress">Tipo de logradouro</label>
                                                  <select name="txtTiposLogradouro" id="txtCategoria" class="form-control">
                                                  <c:forEach var="tiposLogradouro" items="${baseCadastro.tiposLogradouro }" >
                                                            
                                                                      <option name="txtTiposLogradouro" value="${tiposLogradouro }">${tiposLogradouro }</option>
															
																     </c:forEach>  
																     <option name="txtTiposLogradouro" value="${cliente.listEnderecos[0].tipoLogradouro }">${cliente.listEnderecos[0].tipoLogradouro}</option>
																     </select>
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
                                            <label for="streetaddress">Número</label>
                                                <input value="${cliente.listEnderecos[0].numero}" type="text" class="form-control" id="txtNumero" name="txtNumero" placeholder="" >
                                            </div>
                                        </div>

                                        <div class="col-md-6">
                                            <div class="form-group">
                                            <label for="streetaddress">Bairro</label>
                                                <input value="${cliente.listEnderecos[0].bairro}" type="text" class="form-control" id="txtBairro" name="txtBairro" placeholder="" >
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label for="country">Estado</label>
                                                <div class="select-wrap">
                                                    <div class="icon"><span class="ion-ios-arrow-down"></span></div>
                                                    <select name="txtEstado" id="txtEstado" class="form-control">
                                                  <c:forEach var="listaEstados" items="${baseCadastro.listaEstados }" >
                                                            
                                                                      <option name="txtEstado" value="${listaEstados.id }">${listaEstados.nome }</option>
															
																     </c:forEach>  
																     <option name="txtEstado" value="${cliente.listEnderecos[0].cidade.estado.id }">${cliente.listEnderecos[0].cidade.estado.nome}</option>
																     
																     </select>
                                                </div>
                                            </div>
                                        </div>

                                        <div class="w-100"></div>
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label for="country">Cidade</label>
                                                <div class="select-wrap">
                                                    <div class="icon"><span class="ion-ios-arrow-down"></span></div>
                                                        <select name="txtCidade" id="txtCidade" class="form-control">
                                                  <c:forEach var="listaCidades" items="${baseCadastro.listaCidades }" >
                                                            
                                                                      <option name="txtCidade" value="${listaCidades.id }">${listaCidades.nome }</option>
															
																     </c:forEach>
																     <option name="txtCidade" value="${cliente.listEnderecos[0].cidade.id }">${cliente.listEnderecos[0].cidade.nome}</option>
																     </select>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label for="postcodezip">CEP</label>
                                                <input value="${cliente.listEnderecos[0].cep}" type="text" class="form-control" id="txtCEP" name="txtCEP" placeholder="" >
                                            </div>
                                        </div>

                                        <div class="col-md-12">
                                            <div class="col-md-13">
                                                <div class="form-group">
                                                    <label for="towncity">Observações</label>
                                              <textarea type="text" class="form-control" placeholder="" id="txtObservacao" name="txtObservacao" value="${cliente.listEnderecos[0].observacao}">${cliente.listEnderecos[0].observacao}</textarea>
                                           
                                                </div>
                                            </div>
                                        </div>


<div class="w-100"></div>
                                        <hr>
                                        <h3 class="mb-4 billing-heading">Endereço de Entrega</h3>
                                        <div class="w-100"></div>
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label for="streetaddress">Tipo de residência</label>
                                                <select name="txtTipoEnderecoEntrega" id="txtCategoria" class="form-control">
                                                  <c:forEach var="listaTipoEndereco" items="${baseCadastro.listaTipoEndereco }" >
                                                            
                                                                      <option name="txtTipoEnderecoEntrega" value="${listaTipoEndereco }">${listaTipoEndereco }</option>
															
																     </c:forEach>  
																     <option name="txtTipoEnderecoEntrega" value="${cliente.listEnderecos[1].tipoEndereco }">${cliente.listEnderecos[1].tipoEndereco}</option>
																     </select>
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label for="streetaddress">Tipo de logradouro</label>
                                                  <select name="txtTiposLogradouroEntrega" id="txtCategoria" class="form-control">
                                                  <c:forEach var="tiposLogradouro" items="${baseCadastro.tiposLogradouro }" >
                                                            
                                                                      <option name="txtTiposLogradouroEntrega" value="${tiposLogradouro }">${tiposLogradouro }</option>
															
																     </c:forEach>  
																     <option name="txtTiposLogradouroEntrega" value="${cliente.listEnderecos[1].tipoLogradouro }">${cliente.listEnderecos[1].tipoLogradouro}</option>
																     </select>
                                            </div>
                                        </div>
                                        <div class="w-100"></div>
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label for="streetaddress">Logradouro</label>
                                                <input value="${cliente.listEnderecos[1].logradouro}" type="text" class="form-control" id="txtLogradouro" name="txtLogradouroEntrega" placeholder="" >
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-group">
                                            <label for="streetaddress">Número</label>
                                                <input value="${cliente.listEnderecos[1].numero}" type="text" class="form-control" id="txtNumero" name="txtNumeroEntrega" placeholder="" >
                                            </div>
                                        </div>

                                      <div class="col-md-6">
                                            <div class="form-group">
                                            <label for="streetaddress">Bairro</label>
                                                <input value="${cliente.listEnderecos[1].bairro}" type="text" class="form-control" id="txtBairroEntrega" name="txtBairroEntrega" placeholder="" >
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label for="country">Estado</label>
                                                <div class="select-wrap">
                                                    <div class="icon"><span class="ion-ios-arrow-down"></span></div>
                                                    <select name="txtEstadoEntrega" id="txtEstado" class="form-control">
                                                  <c:forEach var="listaEstados" items="${baseCadastro.listaEstados }" >
                                                            
                                                                      <option name="txtEstadoEntrega" value="${listaEstados.id }">${listaEstados.nome }</option>
															
																     </c:forEach>  
																      <option name="txtEstadoEntrega" value="${cliente.listEnderecos[1].cidade.estado.id }">${cliente.listEnderecos[1].cidade.estado.nome}</option>
																     </select>
                                                </div>
                                            </div>
                                        </div>

                                        <div class="w-100"></div>
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label for="country">Cidade</label>
                                                <div class="select-wrap">
                                                    <div class="icon"><span class="ion-ios-arrow-down"></span></div>
                                                        <select name="txtCidadeEntrega" id="txtCidade" class="form-control">
                                                  <c:forEach var="listaCidades" items="${baseCadastro.listaCidades }" >
                                                            
                                                                      <option name="txtCidadeEntrega" value="${listaCidades.id }">${listaCidades.nome }</option>
															
																     </c:forEach> 
																         <option name="txtCidadeEntrega" value="${cliente.listEnderecos[1].cidade.id }">${cliente.listEnderecos[1].cidade.nome}</option> 
																     </select>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label for="postcodezip">CEP</label>
                                                <input value="${cliente.listEnderecos[1].cep}" type="text" class="form-control" id="txtCEP" name="txtCEPEntrega" placeholder="" >
                                            </div>
                                        </div>

                                        <div class="col-md-12">
                                            <div class="col-md-13">
                                                <div class="form-group">
                                                    <label for="towncity">Observações</label>
                                              <textarea type="text" class="form-control" placeholder="" id="txtObservacao" name="txtObservacaoEntrega" value="${cliente.listEnderecos[1].observacao}">${cliente.listEnderecos[1].observacao}</textarea>
                                           
                                                </div>
                                            </div>
                                        </div>




<div class="w-100"></div>
                                        <hr>
                                        <h3 class="mb-4 billing-heading">Endereço Residencial</h3>
                                        <div class="w-100"></div>
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label for="streetaddress">Tipo de residência</label>
                                                <select name="txtTipoEnderecoResidencial" id="txtCategoria" class="form-control">
                                                  <c:forEach var="listaTipoEndereco" items="${baseCadastro.listaTipoEndereco }" >
                                                            
                                                                      <option name="txtTipoEnderecoResidencial" value="${listaTipoEndereco }">${listaTipoEndereco }</option>
															
																     </c:forEach>  
																     <option name="txtTipoEnderecoResidencial" value="${cliente.listEnderecos[2].tipoEndereco }">${cliente.listEnderecos[2].tipoEndereco}</option>
																     </select>
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label for="streetaddress">Tipo de logradouro</label>
                                                  <select name="txtTiposLogradouroResidencial" id="txtCategoria" class="form-control">
                                                  <c:forEach var="tiposLogradouro" items="${baseCadastro.tiposLogradouro }" >
                                                            
                                                                      <option name="txtTiposLogradouroResidencial" value="${tiposLogradouro }">${tiposLogradouro }</option>
															
																     </c:forEach>  
																     <option name="txtTiposLogradouroResidencial" value="${cliente.listEnderecos[2].tipoLogradouro }">${cliente.listEnderecos[2].tipoLogradouro}</option>
																     </select>
                                            </div>
                                        </div>
                                   
                                        
                                        <div class="w-100"></div>
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label for="streetaddress">Logradouro</label>
                                                <input value="${cliente.listEnderecos[2].logradouro}" type="text" class="form-control" id="txtLogradouro" name="txtLogradouroResidencial" placeholder="" >
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-group">
                                            <label for="streetaddress">Número</label>
                                                <input value="${cliente.listEnderecos[2].numero}" type="text" class="form-control" id="txtNumero" name="txtNumeroResidencial" placeholder="" >
                                            </div>
                                        </div>
                                        
                                        

                                        <div class="col-md-6">
                                            <div class="form-group">
                                            <label for="streetaddress">Bairro</label>
                                                <input value="${cliente.listEnderecos[2].bairro}" type="text" class="form-control" id="txtBairroResidencial" name="txtBairroResidencial" placeholder="" >
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label for="country">Estado</label>
                                                <div class="select-wrap">
                                                    <div class="icon"><span class="ion-ios-arrow-down"></span></div>
                                                    <select name="txtEstadoResidencial" id="txtEstado" class="form-control">
                                                  <c:forEach var="listaEstados" items="${baseCadastro.listaEstados }" >
                                                            
                                                                      <option name="txtEstadoResidencial" value="${listaEstados.id }">${listaEstados.nome }</option>
															
																     </c:forEach>  
																     <option name="txtEstadoResidencial" value="${cliente.listEnderecos[2].cidade.estado.id }">${cliente.listEnderecos[2].cidade.estado.nome} </option>
																     </select>
                                                </div>
                                            </div>
                                        </div>

                                        <div class="w-100"></div>
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label for="country">Cidade</label>
                                                <div class="select-wrap">
                                                    <div class="icon"><span class="ion-ios-arrow-down"></span></div>
                                                        <select name="txtCidadeResidencial" id="txtCidade" class="form-control">
                                                  <c:forEach var="listaCidades" items="${baseCadastro.listaCidades }" >
                                                            
                                                                      <option name="txtCidadeResidencial" value="${listaCidades.id }">${listaCidades.nome }</option>
															
																     </c:forEach>  
																     <option name="txtCidadeResidencial" value="${cliente.listEnderecos[2].cidade.id }">${cliente.listEnderecos[2].cidade.nome}</option> 
																     </select>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label for="postcodezip">CEP</label>
                                                <input value="${cliente.listEnderecos[2].cep}" type="text" class="form-control" id="txtCEP" name="txtCEPResidencial" placeholder="" >
                                            </div>
                                        </div>

                                        <div class="col-md-12">
                                            <div class="col-md-13">
                                                <div class="form-group">
                                                    <label for="towncity">Observações</label>
                                              <textarea type="text" class="form-control" placeholder="" id="txtObservacao" name="txtObservacaoResidencial" value="${cliente.listEnderecos[2].observacao}">${cliente.listEnderecos[2].observacao}</textarea>
                                           
                                                </div>
                                            </div>
                                        </div>

                                        <div class="w-100"></div>
                                                                                <div class="w-100"></div>
                                        <hr>
                                        <h3 class="mb-4 billing-heading">Pagamento</h3>


                                        <div class="w-100"></div>
                                        <div class="col-md-4">
                                            <div class="form-group">
                                                <label for="country">Bandeira</label>
                                                <div class="select-wrap">
                                                    <div class="icon"><span class="ion-ios-arrow-down"></span></div>
                                                      <select name="txtBandeira" id="txtCategoria" class="form-control">
                                                                     <c:forEach var="listaBandeira" items="${baseCadastro.listaBandeira }" >
                                                            
                                                                      <option name="txtBandeira" value="${listaBandeira }">${listaBandeira }</option>
															
																     </c:forEach>   
																<option name="txtBandeira" value="${cliente.listCartoes[0].bandeira }">${cliente.listCartoes[0].bandeira }</option>
                                                      </select>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-md-8">
                                            <div class="form-group">
                                                <label for="postcodezip">Número</label>
                                                <input value="${cliente.listCartoes[0].numero}" type="text" class="form-control" id="txtNumeroCartao" name="txtNumeroCartao" placeholder="" >
                                            </div>
                                        </div>


                                        <div class="w-100"></div>

                                        <div class="col-md-12">
                                            <div class="form-group">
                                                <label for="postcodezip">Nome</label>
                                             <input value="${cliente.listCartoes[0].nome}" type="text" class="form-control" id="txtNomeCartao" name="txtNomeCartao" placeholder="" >

                                            </div>
                                        </div>

                                        <div class="col-md-5">
                                            <div class="form-group">
                                                <label for="postcodezip">Código de Segurança</label>
                               <input value="${cliente.listCartoes[0].codSeguranca}" type="text" class="form-control" id="txtCodSeguranca" name="txtCodSeguranca" placeholder="" >

                                            </div>
                                        </div>
                                        <div class="col-md-7">
                                            <div class="form-group">
                                                <label for="streetaddress">Data de Vencimento</label>
                                                <input value="${cliente.listCartoes[0].dtVenciamento}" type="date" class="form-control" id="txtDataVencimento" name="txtDataVencimento" placeholder=""  maxlength="10" autocomplete="off">

                                            </div>
                                        </div>


                                    </div>
                                    <div class="w-100"></div>
                                    <div class="col-md-12">
                                        <div class="form-group mt-4">
                                            <center>
                                                <div class="header-cart-wrapbtn">
                                                    <!-- Button -->
                                                    <input type="hidden" id="FormName" name="FormName" value="VHCLIENTE" />
                                                                <input type="hidden" id="Tipo" name="Tipo" value="VHCLIENTE" />
                                                                
                                                                <button class="btn mosh-btn mt-50" id= "btnOperacaoSalvar" name="btnOperacao" value="SALVAR">Cadastrar</button>
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
    <script>


    function mascara(t, mask){
    	 var i = t.value.length;
    	 var saida = mask.substring(1,0);
    	 var texto = mask.substring(i)
    	 if (texto.substring(0,1) != saida){
    	 t.value += texto.substring(0,1);
    	 }
  	}


</script>

 <script>
 
 function onlynumber(evt) {
 var theEvent = evt || window.event;
 var key = theEvent.keyCode || theEvent.which;
 key = String.fromCharCode( key );
 //var regex = /^[0-9.,]+$/;
 var regex = /^[0-9.]+$/;
 if( !regex.test(key) ) {
    theEvent.returnValue = false;
    if(theEvent.preventDefault) theEvent.preventDefault();
 }
 }
 </script>

    <!--===============================================================================================-->
    <script src="../js/main.js"></script>

</body>
</html>