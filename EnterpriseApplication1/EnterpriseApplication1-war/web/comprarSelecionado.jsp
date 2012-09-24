<%@page import="java.util.ArrayList"%>
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
function selecionar(o,name) {
        if (o.className == "livre"){
            o.className = "selecionada";
            var formDibujo=document.getElementById("confirmacao");
            var newField = document.createElement("input");
            newField.type = "hidden";
            newField.name = name;
            newField.value = o.firstChild.data;
            o.appendChild(newField);
        } else {
            o.className = "livre";
            if (o.lastChild.type == "hidden"){
                    o.removeChild(o.lastChild);
            }
    }
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
			<li><a href="index.jsp" title="">Início</a></li>
			<li><a href="agencias.jsp" title="">Agências</a></li>
			<li><a href="comprar.jsp" title="" class="current" >Comprar</a></li>
			<li><a href="cadastro.jsp" title="">Cadastro</a></li>
                        <li><a href="autorizaHistorico.jsp" title="">Historico de Compras</a></li>
			<li><a href="previsao.jsp" title="">Previsão do Tempo</a></li>
			<li><a href="sobre.jsp" title="">Sobre</a></li>
			<li><a href="contato.jsp" title="">Contato</a></li>
		</ul>
	</div>
	
	<div class="principal">
            Sua compra:
            <form name="confirmacao" action="ConfirmacaoCompra" method="post">
            <table class ='tabelaPreco' width='625' border='1' style='text-align: center;'>
                <tr> <td> <b>Data</b> </td> <td> <b>Horario</b></td> <td> <b>Origem</b> </td> <td> <b>Destino</b> </td> <td> <b>Preco</b> </td> </tr>
                <tr> <td> <b><%=request.getAttribute("data") %></b> </td> <td> <b><%=request.getAttribute("horario")%></b></td> <td> <b><%=request.getAttribute("origem")%></b> </td> <td> <b><%=request.getAttribute("destino")%></b> <td> <b><%=request.getAttribute("preco")%></b> </td> 
                <input type="hidden" name="data" value="<%=request.getAttribute("data") %>"> <input type="hidden" name="horario" value="<%=request.getAttribute("horario") %>"> <input type="hidden" name="origem" value="<%=request.getAttribute("origem") %>"> <input type="hidden" name="destino" value="<%=request.getAttribute("destino") %>"> 
                </tr>
            </table> <br/>
            <%String s = (String) request.getAttribute("poltronas");
              String[] assentosOcupados = s.split(",");
              ArrayList assentosOcupadosList = new ArrayList();
              for(int m=1;m<assentosOcupados.length;m++){
                 assentosOcupadosList.add(Integer.parseInt(assentosOcupados[m]));
                }
            %>
            
            <div id="buss">
                 <table class="cpo1" border="0" cellpadding="2" cellspacing="2">
                        <tbody>
                                <tr>
                                    <td>
                                        <table class="cpo1" border="0" cellpadding="2" cellspacing="2">
                                            <tbody>
                                                <tr>
                                                    <%for(int i=3; i<=39; i+=4){
                                                        if(assentosOcupadosList.contains(i)){
                                                    %>
                                                        <td class="ocupada" name="poltrona" value="<%=i%>"><%=i%></td>
                                                    <%}else{%>
                                                        <td class="livre" name="poltrona" value="<%=i%>" onclick="selecionar(this,'bi0');"><%=i%></td>
                                                    <%}}%>
                                                </tr>
                                                <tr>
                                                    <%for(int i=4; i<=40; i+=4){
                                                        if(assentosOcupadosList.contains(i)){
                                                    %>
                                                        <td class="ocupada" name="poltrona" value="<%=i%>"><%=i%></td>
                                                    <%}else{%>
                                                        <td class="livre" name="poltrona" value="<%=i%>" onclick="selecionar(this,'bi0');"><%=i%></td>
                                                    <%}}%>
                                                </tr>
                                                <tr>
                                                    <td class="vazia">&nbsp;&nbsp;</td><td class="vazia">&nbsp;&nbsp;</td><td class="vazia">&nbsp;&nbsp;</td><td class="vazia">&nbsp;&nbsp;</td>
                                                    <td class="vazia">&nbsp;&nbsp;</td><td class="vazia">&nbsp;&nbsp;</td><td class="vazia">&nbsp;&nbsp;</td><td class="vazia">&nbsp;&nbsp;</td>
                                                    <td class="vazia">&nbsp;&nbsp;</td><td class="vazia">&nbsp;&nbsp;</td>
                                                </tr>
                                                <tr>
                                                    <%for(int i=2; i<=38; i+=4){
                                                        if(assentosOcupadosList.contains(i)){
                                                    %>
                                                        <td class="ocupada" name="poltrona" value="<%=i%>"><%=i%></td>
                                                    <%}else{%>
                                                        <td class="livre" name="poltrona" value="<%=i%>" onclick="selecionar(this,'bi0');"><%=i%></td>
                                                    <%}}%>
                                                </tr>
                                                <tr>
                                                    <%for(int i=1; i<=37; i+=4){
                                                        if(assentosOcupadosList.contains(i)){
                                                    %>
                                                        <td class="ocupada" name="poltrona" value="<%=i%>"><%=i%></td>
                                                    <%}else{%>
                                                        <td class="livre" name="poltrona" value="<%=i%>" onclick="selecionar(this,'bi0');"><%=i%></td>
                                                    <%}}%>
                                                </tr>
                                               </tbody>
                                        </table>
                                </td>
                        </tr>
                     </tbody>
                    </table>
                            
                                
                            
            </div>
            
                Antes de confirmar a compra, informe seu RG:
                <input type="text" name="rg">
                
             <input type="submit" value="Confirmar Compra!">
            </form>
	</div>	
</body>
</html>