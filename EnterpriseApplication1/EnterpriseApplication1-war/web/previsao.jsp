
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>Previsão do Tempo - Nome da Empresa Transportes</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="title" content="Web site" />
<meta name="description" content="Site description here" />
<meta name="keywords" content="keywords here" />
<meta name="language" content="en" />
<meta name="subject" content="Site subject here" />
<meta name="robots" content="All" />
<meta name="copyright" content="Your company" />
<meta name="abstract" content="Site description here" />
<meta name="MSSmartTagsPreventParsing" content="true" />
<link id="theme" rel="stylesheet" type="text/css" href="style.css"
	title="theme" />
</head>
<body>
	<div class="header" style="text-align: center"> 
		
	</div>
	
	<div class="nav1">	
		<ul id="menu">
			<li><a href="index.jsp" title="">Início</a></li>
			<li><a href="agencias.jsp" title="">Agências</a></li>
			<li><a href="comprar.jsp" title="">Comprar</a></li>
			<li><a href="cadastro.jsp" title="">Cadastro</a></li>
                        <li><a href="autorizaHistorico.jsp" title="">Historico de Compras</a></li>
			<li><a href="previsao.jsp" title="" class="current">Previsão do Tempo</a></li>
			<li><a href="sobre.jsp" title="">Sobre</a></li>
			<li><a href="contato.jsp" title="">Contato</a></li>
		</ul>
	</div>
	
	<div class="principal">
	
	<div  style="margin-left: 10px;">
		<p class="contentText">
			Acompanhe a previsão do tempo das cidades.<br/><br/>
			<!-- Araraquara -->
			<iframe src='http://selos.climatempo.com.br/selos/MostraSelo120.php?CODCIDADE=397&SKIN=padrao' scrolling='no' frameborder='0' width=120 height='170' marginheight='0' marginwidth='0'></iframe>
		
			<!-- Campinas -->
			<iframe src='http://selos.climatempo.com.br/selos/MostraSelo120.php?CODCIDADE=418&SKIN=padrao' scrolling='no' frameborder='0' width=120 height='170' marginheight='0' marginwidth='0'></iframe>
		
			<!-- Ribeirão Preto -->
			<iframe src='http://selos.climatempo.com.br/selos/MostraSelo120.php?CODCIDADE=530&SKIN=padrao' scrolling='no' frameborder='0' width=120 height='170' marginheight='0' marginwidth='0'></iframe>
		
			<!-- Santos -->
			<iframe src='http://selos.climatempo.com.br/selos/MostraSelo120.php?CODCIDADE=540&SKIN=padrao' scrolling='no' frameborder='0' width=120 height='170' marginheight='0' marginwidth='0'></iframe> 
			
			<!-- São Paulo -->
			<iframe src='http://selos.climatempo.com.br/selos/MostraSelo120.php?CODCIDADE=558&SKIN=padrao' scrolling='no' frameborder='0' width=120 height='170' marginheight='0' marginwidth='0'></iframe> 
			
			
		</p>
		
		
	</div>
			
	</div>
</body>
</html>