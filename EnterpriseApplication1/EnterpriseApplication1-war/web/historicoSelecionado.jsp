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
<body class="">
            
            
	
           
            <table border="1"' style="text-align: center;">
                <tr> <td colspan="6"><h3>Comprovante Passagem - Expresso Xavante</h3</td> </tr>
                <tr><td colspan="2">Nome: <%=request.getAttribute("nome") %></td> <td colspan="2">RG: <%=request.getAttribute("rg") %> </td> <td colspan="2">Poltrona: <%=request.getAttribute("poltronas") %></td</tr>
                <tr><td> <b>Cod. Passagem</b> </td> <td> <b>Data</b> </td> <td> <b>Horario</b></td> <td> <b>Origem</b> </td> <td> <b>Destino</b> </td> <td> <b>Preco</b> </td> </tr>
                <tr> <td> <b><%=request.getAttribute("codPassagem") %></b> </td> <td> <b><%=request.getAttribute("data") %></b> </td> <td> <b><%=request.getAttribute("horario")%></b></td> <td> <b><%=request.getAttribute("origem")%></b> </td> <td> <b><%=request.getAttribute("destino")%></b> <td> <b><%=request.getAttribute("preco")%></b> </td> </tr>
                <tr> <td colspan="6" style="height:50px;">Assinatura: ___________________________ </td> </tr>
            </table> <br/>
                                        
</body>
</html>