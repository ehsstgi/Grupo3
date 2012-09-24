<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  
<script language="JavaScript">
    
function changeFunc() {
    
    document.getElementById("origemAraraquara").style.display = 'none';
    document.getElementById("origemSantos").style.display = 'none';
    
    var selectBox = document.getElementById("origem");
    var selectedValue = selectBox.options[selectBox.selectedIndex].value;
    document.getElementById("origem"+selectedValue).style.display = 'block';
    
   }
function mostrarDestino() {
    
    if (document.getElementById("novoDest").style.display == 'none')
        document.getElementById("novoDest").style.display = 'block'
    else{
        document.getElementById("novoDest").style.display = 'none'
    }   
   }
</script>
<title>Comprar - Nome da Empresa Transportes</title>
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
			<li><a href="index.jsp" title="">In�cio</a></li>
			<li><a href="agencias.jsp" title="">Ag�ncias</a></li>
			<li><a href="comprar.jsp" title="" class="current" >Comprar</a></li>
			<li><a href="cadastro.jsp" title="">Cadastro</a></li>
                        <li><a href="autorizaHistorico.jsp" title="">Historico de Compras</a></li>
			<li><a href="previsao.jsp" title="">Previs�o do Tempo</a></li>
			<li><a href="sobre.jsp" title="">Sobre</a></li>
			<li><a href="contato.jsp" title="">Contato</a></li>
		</ul>
	</div>
	
	<div class="principal">
            <form name="dadosViagem" id="dadosViagem" action="ComprarPassagem" method="post">
        Selecione a origem:
        <select name="origem" id="origem">
            <option>Selecione</option> 
            <option value="Araraquara">Araraquara</option> 
            <option value="Campinas">Campinas</option> 
            <option value ="Ribeirao Preto">Ribeir�o Preto</option> 
            <option value="Santos">Santos</option> 
            <option value="Sao Paulo">S�o Paulo</option>         
        </select><br/>
        
        Selecione o destino:
        <select name="destino" id="destino">
            <option>Selecione</option>
            <option value="Araraquara">Araraquara</option> 
            <option value="Campinas">Campinas</option> 
            <option value ="Ribeirao Preto">Ribeir�o Preto</option> 
            <option value="Santos">Santos</option>     
            <option value="Sao Paulo">S�o Paulo</option>         
        </select><br/>
        
        Adicionar pr�ximo destino: <input type="checkbox" name="checkDestino" id="checkDestino" onclick="mostrarDestino()"><br/>
       
        <div id="novoDest" name="novoDest" style="display: none">
        Outro destino: <select name="outroDestino" id="outroDestino" onchange="changeFunc();">
            <option>Selecione</option>  
            <option value="Araraquara">Araraquara</option> 
            <option value="Campinas">Campinas</option> 
            <option value ="Ribeirao Preto">Ribeir�o Preto</option> 
            <option value="Santos">Santos</option>       
        </select><br/>
        </div>
        <input type="submit">
        </form>
	</div>
			
	</div>	
	</div>
</body>
</html>