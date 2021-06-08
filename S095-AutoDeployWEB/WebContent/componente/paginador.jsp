<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@page	language="java" contentType="text/html; charset=ISO-8859-1"	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://www.ibm.com/jsf/html_extended" prefix="hx"%>

<html>
<head>
<link rel="stylesheet" href="../theme/Master.css" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
	<body>
		<h:panelGrid styleClass="totalizadorRegistros">							
		       <h:panelGroup>   
					<h:outputText
		                  value="Página " />
					<hx:outputStatistics 
					statusText="{0}" style="font-weight: bold"/>
					<h:outputText
		                  value=" de " />
					<hx:outputStatistics 
					statusText="{1}" style="font-weight: bold"/>
			   </h:panelGroup> 								
		       <h:panelGroup>   
					<h:outputText
		                  value="Total de Registros:" style="font-weight: normal;"/>  
		                  <hx:outputStatistics 
		                  statusText="{3}" total="true" style="font-weight: bold"/> 
		      </h:panelGroup>
		</h:panelGrid>
	</body>
</html>