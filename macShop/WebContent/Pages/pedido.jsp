<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Checkout</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->
<link rel="icon" type="image/png" href="../images/icons/favicon.png" />
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="../vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="../fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="../fonts/themify/themify-icons.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="../fonts/Linearicons-Free-v1.0.0/icon-font.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="../fonts/elegant-font/html-css/style.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="../vendor/animate/animate.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="../vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="../vendor/animsition/css/animsition.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="../vendor/select2/select2.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css" href="../vendor/slick/slick.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css" href="../css/util.css">
<link rel="stylesheet" type="text/css" href="../css/main.css">
<!--===============================================================================================-->
</head>

<body class="animsition">

	<!-- Header -->
	<header class="header1"> <!-- Header desktop -->
	<div class="container-menu-header">

		<div class="wrap_header">
			<!-- Logo -->
			<a href="index.jsp" class="logo"> <img
				src="../images/icons/logo.png" alt="IMG-LOGO">
			</a>

			<!-- Menu -->
			<div class="wrap_menu">
				<nav class="menu">
				<ul class="main_menu">
					<li><a href="index.jsp">Home</a></li>

					<li><a
						href="product?btnOperacao=CONSULTAR&FormName=VHELETRONICO&direcionamento=CATALOGO&txtStatus=Ativo">Catálogo
							de Produtos</a></li>

					<li><a href="contact.jsp">Contato</a></li>



					<li><a href="index.jsp">Área Cliente</a>
						<ul class="sub_menu">
							<li><a
								href="contact?btnOperacao=CONSULTAR&FormName=VHCLIENTE&txtID=10&Direcionamento=DADOS">Meus
									Dados</a></li>
							<li><a
								href="orders?btnOperacao=CONSULTAR&FormName=VHPEDIDO&cli_id=10&Direcionamento=CLIENTE">Pedidos</a></li>
							<li><a href="#">Logout</a></li>
						</ul></li>

					<li><a href="index.jsp">Área Admin</a>
						<ul class="sub_menu">
							<li><a href="#">Consultar Clientes</a></li>
							<li><a href="consulta-prod.jsp">Produtos</a></li>
                                    <li><a href="orders?btnOperacao=CONSULTAR&FormName=VHPEDIDO&Direcionamento=ADMIN">Consultar Pedidos</a></li>
							<li><a href="gerarCupom.jsp">Gerar Cupom</a></li>
							<li><a href="relatorio.jsp">Relatórios</a></li>
						</ul></li>
				</ul>
				</nav>
			</div>

			<!-- Header Icon -->
			<div class="header-icons">
				<a href="login.jsp" class="header-wrapicon1 dis-block"> <img
					src="../images/icons/icon-header-01.png" class="header-icon1"
					alt="ICON">
				</a> <span class="linedivide1"></span>

				<div class="header-wrapicon2">
					<a href="cart.jsp" class="header-wrapicon1 dis-block"> <img
						src="../images/icons/icon-header-02.png" class="header-icon1"
						alt="ICON">
					</a>


				</div>
			</div>
		</div>
	</div>

	<!-- Header Mobile -->
	<div class="wrap_header_mobile">
		<!-- Logo moblie -->
		<a href="index.jsp" class="logo-mobile"> <img
			src="../images/icons/logo.png" alt="IMG-LOGO">
		</a>

		<!-- Button show menu -->
		<div class="btn-show-menu">
			<!-- Header Icon mobile -->
			<div class="header-icons-mobile">
				<a href="#" class="header-wrapicon1 dis-block"> <img
					src="../images/icons/icon-header-01.png" class="header-icon1"
					alt="ICON">
				</a> <span class="linedivide2"></span>

				<div class="header-wrapicon2">
					<img src="../images/icons/icon-header-02.png"
						class="header-icon1 js-show-header-dropdown" alt="ICON">

				</div>
			</div>

			<div class="btn-show-menu-mobile hamburger hamburger--squeeze">
				<span class="hamburger-box"> <span class="hamburger-inner"></span>
				</span>
			</div>
		</div>
	</div>

	<!-- Menu Mobile -->
	<div class="wrap-side-menu">
		<nav class="side-menu">
		<ul class="main-menu">


			<li class="item-menu-mobile"><a href="index.jsp">Home</a></li>

			<li class="item-menu-mobile"><a href="product.jsp">Catálogo
					de Produtos</a></li>

			<li class="item-menu-mobile"><a href="contact.jsp">Contato</a></li>

			<li class="item-menu-mobile"><a href="index.jsp">Área
					Cliente</a>
				<ul class="sub-menu">
					<li><a href="area-cli.jsp"">Meus Dados</a></li>
					<li><a href=" pedidos-cli.jsp">Pedidos</a></li>
					<li><a href="#">Logout</a></li>
				</ul> <i class="arrow-main-menu fa fa-angle-right" aria-hidden="true"></i>
			</li>

			<li class="item-menu-mobile"><a href="index.jsp">Área Admin</a>
				<ul class="sub-menu">
					<li><a href="consulta-cli.jsp">Consultar Clientes</a></li>
					<li><a href="consulta-prod.jsp">Produtos</a></li>
					<li><a href="troca.jsp">Consultar Trocas</a></li>
					<li><a href="pedidos-adm.jsp">Consultar Pedidos</a></li>
					<li><a href="relatorio.jsp">Relatórios</a></li>
				</ul> <i class="arrow-main-menu fa fa-angle-right" aria-hidden="true"></i>
			</li>


		</ul>
		</nav>
	</div>
	</header>

	<!-- Title Page -->
	<section class="bg-title-page p-t-40 p-b-50 flex-col-c-m"
		style="background-image: url(../images/carrinho_banner.jpg);">
	<h2 class="l-text2 t-center">Checkout</h2>
	</section>
	<c:forEach items="${erro}" var="msg">
		<label style="color: red;">${msg}</label>
		<br />
	</c:forEach>
	<c:forEach items="${sucesso}" var="msg">
		<label style="color: green;">${msg}</label>
		<br />
	</c:forEach>
	<section class="bgwhite p-t-45 p-b-58">
	<div class="container">

		<!-- Tab01 -->
		<div class="tab01">
			<!-- Nav tabs -->
			<ul class="nav nav-tabs" role="tablist">


				<li class="nav-item"><a class="nav-link active"
					data-toggle="tab" href="#endereco" role="tab">Resumo do Pedido</a></li>
				<li class="nav-item"><a class="nav-link" data-toggle="tab"
					href="#pagamento" role="tab">Adicionar Formas de Pagamento</a></li>

				<li class="nav-item"><a class="nav-link" data-toggle="tab"
					href="#pedido" role="tab">Adicionar Endereço de Entrega</a></li>

			</ul>

			<!-- Tab panes -->
			<div class="tab-content p-t-35">





				<!-- - -->


				<div class="tab-pane fade show active" id="endereco" role="tabpanel">
					<section class="ftco-section">
					<div class="container bgwhite p-t-35 p-b-80">
						<div class="container">
							<div class="row justify-content-center">
								<div class="col-xl-8 ftco-animate">
									<div class="billing-form bg-light p-md-4">

									<form action="/macShop/Pages/pedido" method="POST">
										<h3 class="mb-4 billing-heading">Selecionar endereço de
											entrega</h3>
										<div class="col-md-6">
											<select name="enderecoselecionado_id"
												id="enderecoselecionado_id" class="form-control">
												<c:forEach var="enderecoEntrega"
													items="${cliente.listEnderecosEntrega }">
													<option name="enderecoselecionado_id" class="end_sel_id"
														value="${enderecoEntrega.id }">${enderecoEntrega.tipoEndereco }
														- ${enderecoEntrega.tipoLogradouro  } -
														${enderecoEntrega.logradouro }</option>
												</c:forEach>

											</select>
										</div>
										<hr>
										<h3 class="mb-4 billing-heading">Selecionar cartão para
											pagamento</h3>
										<div class="row align-items-end">
											<div class="w-100"></div>
											<div class="col-md-3">
												<div class="form-group">
													<label> Cartão 1 </label>
													<div class="select-wrap">
														<div class="icon">
															<span class="ion-ios-arrow-down"></span>
														</div>
														 <select name="idcartaoPagamento1"
												id="idcartaoPagamento1" class="form-control">
												<c:forEach var="cartao" items="${cliente.listCartoes }">
													<option name="idcartaoPagamento1"
														class="idcartaoPagamento1" value="${cartao.id }">${cartao.bandeira }</option>
												</c:forEach>

											</select>
													</div>
												</div>
											</div>
											<div class="col-md-9">
												<div class="form-group">
														<label> Parcela </label> <input type="number"
											name="parcelasCartao1" class="mr-2" placeholder="parcelas">
										<label> Valor </label> <input type="number"
											name="valorCartao1" class="mr-2" placeholder="valor">
												</div>
											</div>
											<div class="w-100"></div>
											<div class="col-md-3">
												<div class="form-group">
													<label> Cartão 2 </label>
													<div class="select-wrap">
														<div class="icon">
															<span class="ion-ios-arrow-down"></span>
														</div>
														 <select name="idcartaoPagamento2"
												id="idcartaoPagamento2" class="form-control">
												<option name="idcartaoPagamento2"
														class="idcartaoPagamento2" value="0">Nenhum</option>
												<c:forEach var="cartao" items="${cliente.listCartoes }">
													<option name="idcartaoPagamento2"
														class="idcartaoPagamento2" value="${cartao.id }">${cartao.bandeira }</option>
												</c:forEach>
													
											</select>
													</div>
												</div>
											</div>
											<div class="col-md-9">
												<div class="form-group">
														<label> Parcela </label> <input type="number"
											name="parcelasCartao2" class="mr-2" placeholder="parcelas" >
										<label> Valor </label> <input type="number"
											name="valorCartao2" class="mr-2" placeholder="valor">
												</div>
											</div>
								</div>





										<hr>

										<h3 class="billing-heading mb-4">Cupons de Desconto</h3>
										<div class="billing-form bg-light p-md-4">
											<h3 class="billing-heading mb-4">Cupons de Troca</h3>

											<c:if test="${cliente.cupons != null}">
												<c:forEach var="cupom" items="${cliente.cupons }">
													<div class="form-group">
														<div class="col-md-12">
															<div class="radio">
																<label><input type="checkbox" name="cupom-troca"
																	class="mr-2" value="${cupom.id }" id="cupomTroca" >ID:
																	${cupom.id } - VALOR: R$${cupom.valor } </label>
															</div>
														</div>
													</div>
												</c:forEach>
											</c:if>

											<c:if test="${cliente.cupons == null}">
												<h5>Não há cupons de troca disponíveis</h5>
											</c:if>

											<hr>
											<h3 class="billing-heading mb-4">Cupons Promocionais</h3>
											
											
											<select name="idcupom" id = "idcupom" class="form-control">
											 <option name="idcupom" class="end_sel_id" value="0"> Nenhum
							</option>
											<c:forEach var="cupons" items="${cliente.cuponsPromocionais }">
												<!-- <div class="form-group">
													<div class="col-md-12">
														<div class="radio">
														
														
												 -->			
												 <option name="idcupom" class="end_sel_id" value="${cupons.id }" preco="${cupons.valor }"> ID: ${cupons.id } - VALOR: R$ ${cupons.valor }
																
												</option>
														</div>
													</div>
												</div>
											</c:forEach>
											</select>

										</div>
										<hr>
										<h3 class="billing-heading mb-4">Total do Pedido</h3>
										<div class="billing-form bg-light p-md-4">

											<p class="d-flex">
											<p>SubTotal + Frete</p>
											<span id="subtotal"> </span>
											</p>
											<p class="d-flex">
											<p>Desconto</p>
											<span id="descontos"></span>
											</p>
											<hr>
											<p class="d-flex total-price">
											<p>Total</p>
											<span id="total"></span>
											</p>
										</div>
									</div>







									<div class="w-100"></div>
									<div class="col-md-12">
										<div class="form-group mt-4">
											<center>
												<div class="header-cart-wrapbtn">
													<!-- Button -->
													<input type="hidden" id="FormName" name="FormName"
														value="VHPEDIDO" /> <input type="hidden" name="cli_id"
														class="mr-2" value="${cliente.id }">
													<button class="btn mosh-btn mt-50" id="btnOperacaoSalvar"
														name="btnOperacao" value="SALVAR">Comprar</button>
												</form>
												</div>
											</center>
										</div>
									</div>
								</div>
								




								<!-- END -->
							</div>
							<!-- .col-md-8 -->
						</div>
					</div>
					</section>
					<!-- .section -->

				</div>
				<div class="tab-pane fade" id="pagamento" role="tabpanel">
					<section class="ftco-section">
					<div class="container bgwhite p-t-35 p-b-80">
						<div class="container">
							<div class="row justify-content-center">
								<div class="col-xl-8 ftco-animate">

									<form action="/macShop/Pages/cartao" method="POST"
										class="billing-form bg-light p-3 p-md-5">
										<h3 class="mb-4 billing-heading">Cadastrar novo cartão</h3>
										<div class="row align-items-end">
											<div class="w-100"></div>
											<div class="col-md-4">
												<div class="form-group">
													<label for="country">Bandeira</label>
													<div class="select-wrap">
														<div class="icon">
															<span class="ion-ios-arrow-down"></span>
														</div>
														<select name="txtBandeira" id="txtCategoria"
															class="form-control">
															<c:forEach var="listaBandeira"
																items="${baseCadastro.listaBandeira }">

																<option name="txtBandeira" value="${listaBandeira }">${listaBandeira }</option>

															</c:forEach>
														</select>
													</div>
												</div>
											</div>
											<div class="col-md-8">
												<div class="form-group">
													<label for="postcodezip">Número</label> <input type="text"
														class="form-control" id="txtNumeroCartao"
														name="txtNumeroCartao" placeholder="">
												</div>
											</div>


											<div class="w-100"></div>

											<div class="col-md-12">
												<div class="form-group">
													<label for="postcodezip">Nome</label> <input type="text"
														class="form-control" id="txtNomeCartao"
														name="txtNomeCartao" placeholder="">

												</div>
											</div>

											<div class="col-md-5">
												<div class="form-group">
													<label for="postcodezip">Código de Segurança</label> <input
														type="text" class="form-control" id="txtCodSeguranca"
														name="txtCodSeguranca" placeholder="">

												</div>
											</div>
											<div class="col-md-7">
												<div class="form-group">
													<label for="streetaddress">Data de Vencimento</label> <input
														type="date" class="form-control" id="txtDataVencimento"
														name="txtDataVencimento" placeholder="" maxlength="10"
														autocomplete="off">

												</div>
											</div>
											<div class="w-100"></div>
											<div class="col-md-12">
												<div class="form-group mt-4">
													<center>
														<div class="header-cart-wrapbtn">
															<!-- Button -->
															<input type="hidden" id="FormName" name="FormName"
																value="VHCARTAO" /> <input type="hidden"
																id="Direcionamento" name="Direcionamento" value="COMPRA" />
															<input type="hidden" id="txtCliID" name="txtCliID"
																value="${cliente.id }" />
															<button class="btn mosh-btn mt-50" id="btnOperacaoSalvar"
																name="btnOperacao" value="SALVAR">Cadastrar</button>
									</form>

								</div>
								</center>
							</div>
						</div>
					</div>
					<!-- END -->
				</div>
				<!-- .col-md-8 -->
			</div>
		</div>
	</section>
	<!-- .section -->
	</div>
	<!-- - -->
	<div class="tab-pane fade" id="pedido" role="tabpanel">
		<section class="ftco-section">
		<div class="container bgwhite p-t-35 p-b-80">
			<div class="container">
				<div class="row justify-content-center">
					<div class="col-xl-8 ftco-animate">

						<form action="/macShop/Pages/endereco" method="POST"
							class="billing-form bg-light p-3 p-md-5">
							<h3 class="mb-4 billing-heading">Cadastrar novo endereço de
								entrega</h3>
							<div class="row align-items-end">


								<div class="w-100"></div>
								<div class="col-md-6">
									<div class="form-group">
										<label for="streetaddress">Tipo de residência</label> <select
											name="txtTipoEnderecoEntrega" id="txtCategoria"
											class="form-control">
											<c:forEach var="listaTipoEndereco"
												items="${baseCadastro.listaTipoEndereco }">

												<option name="txtTipoEnderecoEntrega">${listaTipoEndereco }</option>

											</c:forEach>

										</select>
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<label for="streetaddress">Tipo de logradouro</label> <select
											name="txtTiposLogradouroEntrega" id="txtCategoria"
											class="form-control">

											<c:forEach var="tiposLogradouro"
												items="${baseCadastro.tiposLogradouro }">

												<option name="txtTiposLogradouroEntrega"
													value="${tiposLogradouro }">${tiposLogradouro }</option>

											</c:forEach>

										</select>
									</div>
								</div>
								<div class="w-100"></div>
								<div class="col-md-6">
									<div class="form-group">
										<label for="streetaddress">Logradouro</label> <input
											type="text" class="form-control" id="txtLogradouro"
											name="txtLogradouroEntrega" placeholder="">

									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<input type="text" class="form-control" id="txtNumero"
											name="txtNumeroEntrega" placeholder="">

									</div>
								</div>

								<div class="col-md-6">
									<div class="form-group">
										<label for="streetaddress">Bairro</label> <input type="text"
											class="form-control" id="txtBairro" name="txtBairroEntrega"
											placeholder="">
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<label for="country">Estado</label>
										<div class="select-wrap">
											<div class="icon">
												<span class="ion-ios-arrow-down"></span>
											</div>
											<select name="txtEstadoEntrega" id="txtEstado"
												class="form-control">
												<c:forEach var="listaEstados"
													items="${baseCadastro.listaEstados }">

													<option name="txtEstadoEntrega" value="${listaEstados.id }">${listaEstados.nome }</option>

												</c:forEach>

											</select>
										</div>
									</div>
								</div>

								<div class="w-100"></div>
								<div class="col-md-6">
									<div class="form-group">
										<label for="country">Cidade</label>
										<div class="select-wrap">
											<div class="icon">
												<span class="ion-ios-arrow-down"></span>
											</div>
											<select name="txtCidadeEntrega" id="txtCidade"
												class="form-control">
												<c:forEach var="listaCidades"
													items="${baseCadastro.listaCidades }">

													<option name="txtCidadeEntrega" value="${listaCidades.id }">${listaCidades.nome }</option>

												</c:forEach>

											</select>
										</div>
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<label for="postcodezip">CEP</label> <input value=""
											type="text" class="form-control" id="txtCEP"
											name="txtCEPEntrega" placeholder="">
									</div>
								</div>

								<div class="col-md-12">
									<div class="col-md-13">
										<div class="form-group">
											<label for="towncity">Observações</label>
											<textarea type="text" class="form-control" placeholder=""
												id="txtObservacao" name="txtObservacaoEntrega" value=""></textarea>

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
											<input type="hidden" id="FormName" name="FormName"
												value="VHENDERECO" /> <input type="hidden"
												id="Direcionamento" name="Direcionamento" value="COMPRA" />
											<input type="hidden" id="cliId" name="cliId"
												value="${cliente.id }" />
											<button class="btn mosh-btn mt-50" id="btnOperacaoSalvar"
												name="btnOperacao" value="SALVAR">Cadastrar</button>
										</div>
									</center>
								</div>
							</div>
					</div>
					</form>



					<!-- END -->
				</div>
				<!-- .col-md-8 -->
			</div>
		</div>
		</section>
		<!-- .section -->
	</div>









	</div>
	</div>
	</section>








	<!-- Footer -->
	<footer class="bg6 p-t-45 p-b-43 p-l-45 p-r-45">
	<div class="flex-w p-b-90">
		<div class="w-size6 p-t-30 p-l-15 p-r-15 respon3">
			<h4 class="s-text12 p-b-30">Entre em contato!</h4>

			<div>
				<p class="s-text7 w-size27">Entre em contato através do e-mail
					macshop@fatec.com ou se preferir, pelo telefone (11) 2312-2312</p>

				<div class="flex-m p-t-30">
					<a href="#" class="fs-18 color1 p-r-20 fa fa-facebook"></a> <a
						href="#" class="fs-18 color1 p-r-20 fa fa-instagram"></a> <a
						href="#" class="fs-18 color1 p-r-20 fa fa-pinterest-p"></a> <a
						href="#" class="fs-18 color1 p-r-20 fa fa-snapchat-ghost"></a> <a
						href="#" class="fs-18 color1 p-r-20 fa fa-youtube-play"></a>
				</div>
			</div>
		</div>

		<div class="w-size7 p-t-30 p-l-15 p-r-15 respon4">
			<h4 class="s-text12 p-b-30">Categorias</h4>

			<ul>
				<li class="p-b-9"><a href="#" class="s-text7"> iPhone </a></li>

				<li class="p-b-9"><a href="#" class="s-text7"> iPad </a></li>

				<li class="p-b-9"><a href="#" class="s-text7"> Macbook </a></li>

				<li class="p-b-9"><a href="#" class="s-text7"> Acessórios </a>
				</li>
			</ul>
		</div>

		<div class="w-size7 p-t-30 p-l-15 p-r-15 respon4">
			<h4 class="s-text12 p-b-30">Links</h4>

			<ul>
				<li class="p-b-9"><a href="#" class="s-text7"> Busca </a></li>

				<li class="p-b-9"><a href="#" class="s-text7"> Catálogo de
						Produtos </a></li>

				<li class="p-b-9"><a href="#" class="s-text7"> Contato </a></li>

			</ul>
		</div>

		<div class="w-size7 p-t-30 p-l-15 p-r-15 respon4">
			<h4 class="s-text12 p-b-30">Help</h4>

			<ul>
				<li class="p-b-9"><a href="#" class="s-text7"> Carrinho </a></li>

				<li class="p-b-9"><a href="#" class="s-text7"> Pedidos </a></li>
			</ul>
		</div>

		<div class="w-size8 p-t-30 p-l-15 p-r-15 respon3">
			<h4 class="s-text12 p-b-30">Newsletter</h4>

			<form>
				<div class="effect1 w-size9">
					<input class="s-text7 bg6 w-full p-b-5" type="text" name="email"
						placeholder="email@example.com"> <span
						class="effect1-line"></span>
				</div>

				<div class="w-size2 p-t-20">
					<!-- Button -->
					<button class="flex-c-m size2 bg4 bo-rad-23 hov1 m-text3 trans-0-4">
						Subscribe</button>
				</div>

			</form>
		</div>
	</div>

	<div class="t-center p-l-15 p-r-15">
		<a href="#"> <img class="h-size2" src="../images/icons/paypal.png"
			alt="IMG-PAYPAL">
		</a> <a href="#"> <img class="h-size2" src="../images/icons/visa.png"
			alt="IMG-VISA">
		</a> <a href="#"> <img class="h-size2"
			src="../images/icons/mastercard.png" alt="IMG-MASTERCARD">
		</a> <a href="#"> <img class="h-size2"
			src="../images/icons/express.png" alt="IMG-EXPRESS">
		</a> <a href="#"> <img class="h-size2"
			src="../images/icons/discover.png" alt="IMG-DISCOVER">
		</a>

		<div class="t-center s-text8 p-t-20">
			Copyright © 2018 All rights reserved. | This template is made with <i
				class="fa fa-heart-o" aria-hidden="true"></i> by <a
				href="https://colorlib.com" target="_blank">Colorlib</a>
		</div>
	</div>
	</footer>



	<!-- Back to top -->
	<div class="btn-back-to-top bg0-hov" id="myBtn">
		<span class="symbol-btn-back-to-top"> <i
			class="fa fa-angle-double-up" aria-hidden="true"></i>
		</span>
	</div>

	<!-- Container Selection -->
	<div id="dropDownSelect1"></div>
	<div id="dropDownSelect2"></div>



	<!--===============================================================================================-->
	<script type="text/javascript"
		src="../vendor/jquery/jquery-3.2.1.min.js"></script>
	<!--===============================================================================================-->
	<script type="text/javascript"
		src="../vendor/animsition/js/animsition.min.js"></script>
	<!--===============================================================================================-->
	<script type="text/javascript" src="../vendor/bootstrap/js/popper.js"></script>
	<script type="text/javascript"
		src="../vendor/bootstrap/js/bootstrap.min.js"></script>
	<!--===============================================================================================-->
	<script type="text/javascript" src="../vendor/select2/select2.min.js"></script>
	<script type="text/javascript">
		$(".selection-1").select2({
			minimumResultsForSearch : 20,
			dropdownParent : $('#dropDownSelect1')
		});

		$(".selection-2").select2({
			minimumResultsForSearch : 20,
			dropdownParent : $('#dropDownSelect2')
		});
	</script>
	<!--===============================================================================================-->
	<script type="text/javascript" src="../vendor/slick/slick.min.js"></script>
	<script type="text/javascript" src="../js/slick-custom.js"></script>
	<!--===============================================================================================-->
	<script type="text/javascript"
		src="../vendor/sweetalert/sweetalert.min.js"></script>
	<script type="text/javascript">
		$('.block2-btn-addcart').each(
				function() {
					var nameProduct = $(this).parent().parent().parent().find(
							'.block2-name').jsp();
					$(this).on('click', function() {
						swal(nameProduct, "is added to cart !", "success");
					});
				});

		$('.block2-btn-addwishlist').each(
				function() {
					var nameProduct = $(this).parent().parent().parent().find(
							'.block2-name').jsp();
					$(this).on('click', function() {
						swal(nameProduct, "is added to wishlist !", "success");
					});
				});

		$('.btn-addcart-product-detail').each(function() {
			var nameProduct = $('.product-detail-name').jsp();
			$(this).on('click', function() {
				swal(nameProduct, "is added to wishlist !", "success");
			});
		});
	</script>
	<script>
	$().ready(function(){
	 var subtotal =	sessionStorage.getItem("total")
	 
	 $("#subtotal").text("R$ " + subtotal)
	 
	
	})
	

	
	
	</script>
	
	<script>
	
	$("#idcupom").change(function(){
		var totalDescontos = 0 
		totalDescontos += Number($("#idcupom option:selected").attr("preco"))	
		$("#descontos").text("R$ " + totalDescontos)
		
		var a = subtotal.innerText.trim().replace("R$ ", "")

		 $("#total").text("R$ " + (a-totalDescontos))
	})
	
	
	
	
	</script>
	
		<script>
		$("#cupomTroca").change(function(){
			var totalDescontos = 0 
			totalDescontos += Number($("#idcupom option:selected").attr("preco"))	
			$("#descontos").text("R$ " + totalDescontos)
			
			var a = subtotal.innerText.trim().replace("R$ ", "")

			 $("#total").text("R$ " + (a-totalDescontos))
		})
	
	
	
	
	
	</script>
	
	<!--===============================================================================================-->
	<script src="../js/main.js"></script>
	<script src="../js/customizacoes.js"></script>
</body>

</html>