<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Carrinho</title>
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
							<li><a href="pedidos-cli.jsp">Pedidos</a></li>
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
					<li><a
						href="orders?btnOperacao=CONSULTAR&FormName=VHPEDIDO&cli_id=10&Direcionamento=CLIENTE">Pedidos</a></li>
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
	<h2 class="l-text2 t-center">Carrinho</h2>
	</section>





	<!-- Cart -->

	<c:forEach items="${erro}" var="msg">
		<label style="color: red;">${msg}</label>
		<br />
	</c:forEach>
	<c:forEach items="${sucesso}" var="msg">
		<label style="color: green;">${msg}</label>
		<br />
	</c:forEach>
	<section class="cart bgwhite p-t-70 p-b-100">
	<div class="container">
		<!-- Cart item -->
		<c:if test="${sessionScope.carrinho.itensCarrinho[0] != null}">

			<div class="container-table-cart pos-relative">
				<div class="wrap-table-shopping-cart bgwhite">
					<table class="table-shopping-cart">
						<tr class="table-head">
							<th class="column-1">Foto</th>
							<th class="column-2">Produto</th>
							<th class="column-5">Preço</th>
							<th class="column-1">Quantidade</th>
							<th class="column-3">Total</th>
							<th class="column-6">Ação</th>
						</tr>


						<c:forEach var="eletronico"
							items="${sessionScope.carrinho.itensCarrinho }">
							<tr class="table-row">
								<td class="column-1">
									<div class="cart-img-product b-rad-4 o-f-hidden">
										<img src="../images/item-10.jpg" alt="IMG-PRODUCT">
									</div>
								</td>
								<td class="column-2"><input
									class="m-text18 t-center num-product" type="text" id="txtNome"
									name="txtNome" value=" ${eletronico.produto.nome }"></td>
								<td class="column-5"><input
									class="size8 m-text18 t-center num-product" type="text"
									id="txtPreco" name="txtPreco"
									value=" ${eletronico.produto.preco }"></td>
								<td class="column-1">

									<div class="flex-w  of-hidden w-size17">
			<%-- 							<form action="/macShop/Pages/carrinho" method="POST">
											<button type="submit" class="color1 flex-c-m size7 bg8 eff2"
												id="btnOperacaoSalvar" name="btnOperacao"
												value="CARRINHOALTERAR">
												<i class="fs-12 fa fa-minus" aria-hidden="true"></i>
											</button>
											<input type="hidden" id="Tipo" name="Tipo"
												value="${eletronico.produto.tipo}" /> <input type="hidden"
												id="FormName" name="FormName" value="VHBLOQUEIO" /> <input
												type="hidden" id="txtNome" name="txtNome"
												value="${eletronico.produto.nome}" /> <input type="hidden"
												id="txtID" name="txtID" value="${eletronico.produto.id}" />
											<input type="hidden" id="operation" name="operation"
												value="minus" />

										</form> --%>
										<input class="size8 m-text18 t-center num-product"
											type="number" id="qtdeComprada" name="qtdeComprada"
											value="${eletronico.quantidade }" readonly>
										<%-- <form action="/macShop/Pages/carrinho" method="POST">
											<button type="submit" class="color1 flex-c-m size7 bg8 eff2"
												id="btnOperacaoSalvar" name="btnOperacao"
												value="CARRINHOALTERAR">
												<i class="fs-12 fa fa-plus" aria-hidden="true"></i>
											</button>
											<input type="hidden" id="Tipo" name="Tipo"
												value="${eletronico.produto.tipo}" /> <input type="hidden"
												id="FormName" name="FormName" value="VHBLOQUEIO" /> <input
												type="hidden" id="txtNome" name="txtNome"
												value="${eletronico.produto.nome}" /> <input type="hidden"
												id="txtID" name="txtID" value="${eletronico.produto.id}" />
											<input type="hidden" id="operation" name="operation"
												value="add" />
										</form> --%>
									</div>

								</td>
								<td class="column-3 totalProduto"> ${eletronico.quantidade * eletronico.produto.preco} </td>
								<td><a href="#deleteEmployeeModal" class="confirm"
									data-toggle="modal" style="display: inline-block"> <i
										class="material-icons" data-toggle="tooltip" title="Add"
										style="display: inline-block"
										onclick="setaDadosModal('${eletronico.produto.nome }', '${eletronico.produto.tipo }' , '${eletronico.produto.id }')">
											&#xE872;</i></a></td>
							</tr>
						</c:forEach>

					</table>

				</div>
			</div>

		</c:if>

		<c:forEach items="${sessionScope.sucessos }" var="msg">
			<label style="color: red;">${msg}</label>
			<br />
		</c:forEach>

	

			<c:if test="${sessionScope.carrinho.itensCarrinho[0] == null}">
				<h5 class="m-text20 p-b-24">Não há itens incluídos no carrinho.
					Por favor, consulte o catálogo de produtos.</h5>

			</c:if>

		

		<c:if test="${sessionScope.carrinho.itensCarrinho[0] != null}">
			<!-- Total -->
			<div
				class="bo9 w-size18 p-l-40 p-r-40 p-t-30 p-b-38 m-t-30 m-r-0 m-l-auto p-lr-15-sm">
				<h5 class="m-text20 p-b-24">Total Pedido</h5>

				<!--  -->
				<div class="flex-w flex-sb-m p-b-12">
					<span class="s-text18 w-size19 w-full-sm"> Subtotal: </span> <span
						class="m-text21 w-size20 w-full-sm"> <input
						class="size8 m-text18 t-center num-product" type="text"
						id="subtotal" name="subtotal" value=1>
					</span>


				</div>

				<div class="flex-w flex-sb bo10 p-t-15 p-b-20">
					<span class="s-text18 w-size19 w-full-sm"> CEP: </span> <span
						class="m-text21 w-size20 w-full-sm"> <input
						class="sizefull s-text7 p-l-15 p-r-15" type="text" name="postcode"
						placeholder="CEP" onBlur=CalcFrete(this.value)
						value="${sessionScope.cep }">
					</span>


				</div>


				<div class="flex-w flex-sb bo10 p-t-15 p-b-30">
					<span class="s-text18 w-size19 w-full-sm"> Frete: </span> <span
						class="m-text21 w-size20 w-full-sm"> <input
						class="size8 m-text18 t-center num-product" type="text" id="frete"
						name="txtFrete" onchange="CalcTotalProduto('this.value')"
						value="${sessionScope.frete }">
					</span>


				</div>


				<!--  -->
				<div class="flex-w flex-sb-m p-t-26 p-b-30">
					<span class="m-text22 w-size19 w-full-sm"> Total: </span> 
					<span class="m-text21 w-size20 w-full-sm"> 
						<input
						class="size8 m-text18 t-center num-product" type="text"
						id="valorTotal" name="valorTotal">
					</span>
				</div>

				<div class="size15 trans-0-4">
					<!-- Button -->
					<a
						href="contact?btnOperacao=CONSULTAR&FormName=VHCLIENTE&txtID=10&Direcionamento=PAGAMENTO"
						class="flex-c-m size1 bg1 bo-rad-20 hov1 s-text1 trans-0-4">
						Pagamento </a>
				</div>
			</div>
		</c:if>
	</div>
	<div id="deleteEmployeeModal" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<form action="/macShop/Pages/carrinho" method="POST">
					<div class="modal-header">
						<h4 class="modal-title">Excluir do carrinho</h4>
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
					</div>
					<div class="modal-body">
						<p>Tem certeza que deseja o produto do carrinho?</p>

					</div>
					<input type="text" id="TipoExclusao" name="Tipo"
						value="${eletronico.produto.tipo}" /> <input type="text"
						id="FormNameExclusao" name="FormName" value="VHBLOQUEIO" /> <input
						type="text" id="txtNomeExclusao" name="txtNome"
						value="${eletronico.produto.nome}" /> <input type="text"
						id="txtIDExclusao" name="txtID" value="${eletronico.produto.id}" />
					<div class="modal-footer">
						<input type="button" class="btn btn-default" data-dismiss="modal"
							value="Cancelar"> <input type="submit"
							class="btn btn-danger" id="btnOperacaoSalvar" name="btnOperacao"
							value="CARRINHOEXCLUIR">
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
            minimumResultsForSearch: 20,
            dropdownParent: $('#dropDownSelect1')
        });

        $(".selection-2").select2({
            minimumResultsForSearch: 20,
            dropdownParent: $('#dropDownSelect2')
        });
    </script>

	<script type="text/javascript">
	function Calc(){

	// Variavel que recebe o valor didtado no campo, em negrito(ID do campo de texto)
	ValorUm = parseFloat(document.getElementById('txtPreco').value);

	// Variavel que recebe o valor didtado no campo, em negrito(ID do campo de texto)
	ValorDois = parseFloat(document.getElementById('qtdeComprada').value);

    // Em negrito(nome do campo que vai receber os valores), esse *1 é para o Javascript entender que você está fazendo uma operação com números.
    document.getElementById('resultado').value = (ValorUm*ValorDois).toFixed(2);
}
</script>

	<script type="text/javascript">
	async function CalcFrete(cep){
	console.log("Passou por aqui")
	await fetch("/macShop/Pages/calcFrete?cep=" + cep)
	document.location.reload()
	
	
    // Em negrito(nome do campo que vai receber os valores), esse *1 é para o Javascript entender que você está fazendo uma operação com números.
}
</script>

	<script type="text/javascript">
	function CalcTotalProduto(frete){

    // Em negrito(nome do campo que vai receber os valores), esse *1 é para o Javascript entender que você está fazendo uma operação com números.
    document.getElementById('valorTotal').value = frete + document.getElementById('subtotal').value;
}
</script>
	<!--===============================================================================================-->
	<script src="../js/main.js"></script>

</body>

<script type="text/javascript">
    function setaDadosModal(nome, tipo, id) {
        document.getElementById("txtNomeExclusao").value = nome;
        document.getElementById("TipoExclusao").value = tipo;
        document.getElementById("txtIDExclusao").value = id;
    }
    </script>
    
<script type="text/javascript">
let total = 0;

$(".totalProduto").each(function(){
	total+=Number($(this).html())
})

total += Number($("#frete").val())

$("#valorTotal").val(total)

console.log($("#valorTotal").parent().html())
sessionStorage.setItem("total", total)
</script>





</html>