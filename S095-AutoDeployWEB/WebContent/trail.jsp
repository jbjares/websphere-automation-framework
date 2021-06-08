<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="sitenav" type="com.ibm.etools.siteedit.sitelib.core.SiteNavBean" scope="request"/>
<%@ page language="java" contentType="text/html; charset=SHIFT_JIS" pageEncoding="SHIFT_JIS" %>
<HTML>
<HEAD>
<TITLE>trail</TITLE>
</HEAD>
<BODY>
<DIV>
<c:out value='${sitenav.start}' escapeXml='false'/>
<font class="fontNavigationTree">
<c:forEach var="item" items="${sitenav.items}" begin="0" step="1" varStatus="status">
<c:if test="${!status.first}"><c:out value='${sitenav.separator}' escapeXml='false'/></c:if>
<c:choose> 
	<c:when test="${item.self}"><c:out value='${item.label}'/></c:when>
	<c:otherwise><c:out value='<A href="${item.href}" class="${sitenav.navclass}" style="${sitenav.navstyle}">${item.label}</A>' escapeXml='false'/></c:otherwise>
</c:choose>
</c:forEach>
</font>
<c:out value='${sitenav.end}' escapeXml='false'/>

</DIV>
</BODY>
</HTML>

