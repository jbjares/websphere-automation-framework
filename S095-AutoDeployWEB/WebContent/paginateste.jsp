<%-- jsf:pagecode language="java" location="/src/pagecode/Paginateste.java" --%><%-- /jsf:pagecode --%><%-- tpl:insert page="/S095_BNJSFJavaWebTemplate_integrado.jtpl" --%><!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">


<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://www.ibm.com/jsf/html_extended" prefix="hx"%>
<%@ taglib uri="/WEB-INF/lib/bnbtaglibrary.jar" prefix="bnb"%>
<%@ taglib uri="http://www.ibm.com/siteedit/sitelib" prefix="siteedit"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<HTML>
<HEAD>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%!public void jspInit() {

	}%>
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<META name="GENERATOR" content="IBM Software Development Platform">
<META http-equiv="Content-Style-Type" content="text/css">
<LINK href="<%=request.getContextPath()%>/theme/Master.css"
	rel="stylesheet" type="text/css">
<%-- tpl:put name="headarea" --%>
<link rel="stylesheet" href="theme/Master.css" type="text/css">
<title>Teste Recurso URL Pagina de Acesso Negado</title>
<%-- /tpl:put --%>
<SCRIPT LANGUAGE="JavaScript" SRC="<%=request.getContextPath()%>/JSCookMenu/JSCookMenu.js"></SCRIPT>
<SCRIPT LANGUAGE="JavaScript" SRC="<%=request.getContextPath()%>/JSCookMenu/ThemeOffice/theme.js"></SCRIPT>
<SCRIPT LANGUAGE="JavaScript" SRC="<%=request.getContextPath()%>/js/Util.js"></SCRIPT>
<LINK REL="stylesheet" HREF="<%=request.getContextPath()%>/JSCookMenu/ThemeOffice/theme.css" TYPE="text/css">
<LINK rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/theme/stylesheet.css" title="Style">
</HEAD>
<f:view>
	<BODY>
	<hx:scriptCollector id="scriptCollectorBNBTemplate">
	<h:form styleClass="form" id="formBNBTemplate">
	 <TABLE class="tableTitle" cellpadding="5" cellspacing="0">
		<TR>
  			<TD class="cellImage"><a href="http://d001wwv06" target="_blank"><IMG alt="Banco do Nordeste" src="<%=request.getContextPath()%>/img/logo_bnb.gif" border="0"></a></TD>
  			<TD class="cellProjectName"><%= (String)application.getAttribute("com.ibm.websphere.servlet.application.name") %></TD>
		</TR>
	</TABLE>
	<TABLE class="tableMenu">
		<TR>
			<TD class="cellMenu">
			<DIV id="menuID"></DIV>
				<siteedit:sitemap targetlevel="1-5" spec="/menu-js_integrado.jsp"/>
			</TD>
			<TD class="cellNavigationTree">
			<%
				final String PAGINA_INDEX = "index.jsp";
				final String PAGINA_AJUDA = "ajuda.jsp";
				String paginaPadrao= PAGINA_AJUDA;

				if (!request.getServletPath().equals("/"+PAGINA_INDEX) && !request.getServletPath().equals("/"+ PAGINA_AJUDA)) {
		   	%>
							<siteedit:navtrail start='[' end=']' target='home,parent,ancestor,self' separator='&gt;' spec="/trail.jsp" />
			<% 
			   }
			%>

			</TD>
			<TD class="cellLastText">
			<!--  <SPAN style="font-weight: bold; font-size: 10pt; font-color=#0066cc;">-->
			<SPAN>
			<!--  Controla o menu padrão com as páginas de Ajuda (ou Início) e Sair -->
						<% 
						   if (request.getServletPath().equals("/"+PAGINA_AJUDA)) {
						   		paginaPadrao="index.jsp";
						   	%>
						   	<A href="<%=request.getContextPath()%>/faces/<%=paginaPadrao%>" class="outputLinkEx" id="linkExAjuda">
								<h:outputText id="textAjuda1" style="outputText" value="Início"></h:outputText>
							</A>
						   	<% 
						   } else {
						   %>
							<A href="<%=request.getContextPath()%>/faces/<%=paginaPadrao%>" class="outputLinkEx" id="linkExAjuda">
							<h:outputText id="textAjuda2" style="outputText" value="Ajuda"></h:outputText>
							</A>
						   <% 
						   }
				   		%> 
				   		<!--  Fim do menu padrão com as páginas de Ajuda (ou Início) e Sair -->
						<%-- | <h:commandLink styleClass="commandLink" id="linkSair">
									<h:outputText id="textSair" styleClass="outputText" value="Sair"></h:outputText>
					</h:commandLink> --%>
			</SPAN></TD>
		</TR>
	</TABLE>
	<!-- Código utilizado para exibir as mensagens das páginas -->
	<c:if test="${!empty requestScope.mensagem}">
		<table class="tableTemplate">
			<tr>
				<td>
					<c:set var="t" value="${requestScope.mensagem}"></c:set>
					<c:set var="mensagemErro" value="${requestScope.mensagemErro}" ></c:set>
					<c:set var="mensagemAviso" value="${requestScope.mensagemAviso}" ></c:set>
					<c:set var="mensagemSucesso" value="${requestScope.mensagemSucesso}" ></c:set>
					<c:choose>
						<c:when test="${t == mensagemErro}">
							<h:messages styleClass="mensagemErro" id="messageErroBNB" globalOnly="true"></h:messages>
						</c:when>
						<c:when test="${t == mensagemAviso}">
							<h:messages styleClass="mensagemAviso" id="messageAvisoBNB" globalOnly="true"></h:messages>
						</c:when>
						<c:when test="${t == mensagemSucesso}">
							<h:messages styleClass="mensagemSucesso" id="messageSucessoBNB" globalOnly="true"></h:messages>
						</c:when>
					</c:choose>
				</td>
				<td>
				</td>
			</tr>
		</table>
	</c:if>
	<!-- Fim do código para mensagens -->
	</h:form></hx:scriptCollector>
	<bnb:Limitantes nomes="Acesso a pagina" condicao="NENHUM">
		<%
				try {
				javax.naming.InitialContext ctx = new javax.naming.InitialContext();
				java.net.URL URLObject = (java.net.URL) ctx
				.lookup("java:comp/env/"
						+ application
						.getInitParameter("jndi.pagina.acesso.negado"));
				response.sendRedirect(URLObject.toString());				
				
			} catch (Exception e) {
				out.write("Acesso negado!");
				e.printStackTrace();
			}
		%>
	</bnb:Limitantes>
	<bnb:Limitantes nomes="Acesso a pagina">
	<%-- tpl:put name="bodyarea" --%>
teste
	<%-- /tpl:put --%>
	</bnb:Limitantes>
	<DIV id="Layer0" class="copyRight">&copy; 2009 Banco do Nordeste - Versão 1.7</DIV>
	</BODY>
</f:view>
</HTML><%-- /tpl:insert --%>