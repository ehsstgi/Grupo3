
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<script type="text/javascript">

function validaCampo(){
	if(document.cadastro.nome.value==""){
		alert("O Campo nome é obrigatório!");
		return false;
	}else if(document.cadastro.rg.value==""){
		alert("O Campo RG é obrigatório!");
		return false;
	}else if(document.cadastro.cpf.value==""){
		alert("O Campo CPF é obrigatório!");
		return false;
	}else if(document.cadastro.telefone.value==""){
		alert("O Campo Telefone é obrigatório!");
		return false;
	}else if(document.cadastro.endereco.value==""){
		alert("O Campo Endereco é obrigatório!");
		return false;
	}else return true;
}
</script>


<title>Cadastro - Xavante Express</title>
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
			<li><a href="cadastro.jsp" title="" class="current">Cadastro</a></li>
                        <li><a href="autorizaHistorico.jsp" title="">Historico de Compras</a></li>
			<li><a href="previsao.jsp" title="">Previsão do Tempo</a></li>
			<li><a href="sobre.jsp" title="">Sobre</a></li>
			<li><a href="contato.jsp" title="">Contato</a></li>
		</ul>
	</div>
	
	<div class="principal">
	<div  style="margin-left: 10px;">
		<p class="contentText">
		<form id="cadastro" name="cadastro" method="post" action="AlterarCadastro" onsubmit="return validaCampo(); return false;">
		  <table width="625" border="0">
		    <tr>
		      <td width="69">Nome:</td>
		      <td width="546"><input name="nome" type="text" id="nome" size="70" maxlength="60" value="<%=request.getAttribute("nome")%>"/>
		        <input type="hidden" name="rgAntigo" value="<%=request.getAttribute("rgAntigo")%>">
                          <span class="obrigatorio">*</span></td>
		    </tr>
		    <tr>
		      <td>RG:</td>
		      <td><input name="rg" type="text" id="rg" maxlength="9" value="<%=request.getAttribute("rg")%>"/>
		      <span class="obrigatorio">Apenas números</span></td>
		    </tr>
		    <tr>
		      <td>CPF:</td>
		      <td><input name="cpf" type="text" id="cpf" maxlength="11" value="<%=request.getAttribute("cpf")%>"/>
                           <span class="obrigatorio">Apenas números</span>
		      </td>
		    </tr>
                    <tr>
		      <td>Cartao de Crédito:</td>
		      <td><input name="cartaoCredito" type="text" id="cpf" maxlength="11" value="<%=request.getAttribute("cartaoCredito")%>"/>
                           <span class="obrigatorio">Apenas números</span>
		      </td>
		    </tr>
                    <tr>
		      <td>Telefone:</td>
		      <td><input name="telefone" type="text" id="telefone" maxlength="8" value="<%=request.getAttribute("telefone")%>"/>
                           <span class="obrigatorio">Apenas números</span>
		      </td>
		    </tr>
		    <tr>
		      <td>Endereço:</td>
		      <td><input name="endereco" type="text" id="endereco" size="70" maxlength="70" value="<%=request.getAttribute("endereco")%>" />
		        <span class="obrigatorio">*</span></td>
		    </tr>
		    
		    <tr>
		      <td colspan="2"><p>
		        <input name="cadastrar" type="submit" id="cadastrar" value="Alterar meu Cadastro!" /> 
		        
		
		          <input name="limpar" type="reset" id="limpar" value="Limpar Campos preenchidos!" />
		          
		
		          <span class="obrigatorio">* Campos com * são obrigatórios!          </span>
                          </p>
		      </td>
		    </tr>
		  </table>
		</form>
	</div>
			
	</div>
</body>
</html>