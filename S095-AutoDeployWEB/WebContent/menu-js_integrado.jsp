<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/lib/bnbtaglibrary.jar" prefix="bnb" %>
<jsp:useBean id="sitenav" type="com.ibm.etools.siteedit.sitelib.core.SiteNavBean" scope="request" />
<%@ page language="java" contentType="text/html; charset=SHIFT_JIS"
	pageEncoding="SHIFT_JIS"%>
<!-- A alteracao na quantidade de niveis tem quer ser feita tambem no arquivo de template. -->
<HTML>
<HEAD>
<TITLE>sitemap_vertical</TITLE>
</HEAD>
<BODY>
<c:out value='<SCRIPT language="JavaScript">
var menu =
[//inicio'
	escapeXml='false' />
<c:forEach var="top" items="${sitenav.tops}">
	<c:choose><c:when test="${top.item.group}">
		<c:out value="['<img src=\"" escapeXml='false'/><%=request.getContextPath()%><c:out value='/img/seta.png">' escapeXml='false'/><c:out value="', '${top.item.label}', null, null, '${top.item.label}'," escapeXml='false'/>
	</c:when><c:otherwise>
		<c:out value="['<img src=\"" escapeXml='false'/><%=request.getContextPath()%><c:out value='/img/seta.png">' escapeXml='false'/><c:out value="', '${top.item.label}', '${top.item.href}', null, '${top.item.label}'," escapeXml='false'/>
	</c:otherwise></c:choose>
	<c:set var="firstNode" value="true"/>
	<c:forEach var="node" items="${top.children}">
		<bnb:Limitantes nomes="Acesso a pagina" recurso="${node.item.href}">
		<c:if test="${!firstNode && !node.item.group}">
			_cmSplit,
		</c:if>
		<c:set var="firstNode" value="false"/>
		<c:choose><c:when test="${node.item.group}">
			<c:out value="[null, '${node.item.label}', null, null, '${node.item.label}'" escapeXml='false'/>
		</c:when><c:otherwise>
			<c:out value="[null, '${node.item.label}', '${node.item.href}', null, '${node.item.label}'" escapeXml='false'/>
		</c:otherwise></c:choose>
		<c:if test="${0 < node.childcount}">
		<c:set var="firstNode2" value="true"/>
		<c:forEach var="node2" items="${node.children}">
			<bnb:Limitantes nomes="Acesso a pagina" recurso="${node2.item.href}">
			<c:if test="${firstNode2}">
				<c:out value="," escapeXml='false'/>
			</c:if>
			<c:if test="${!firstNode2 && !node.item.group}">
				_cmSplit,
			</c:if>
			<c:set var="firstNode2" value="false"/>
			<c:choose><c:when test="${node2.item.group}">
				<c:out value="[null, '${node2.item.label}', null, null, '${node2.item.label}'" escapeXml='false'/>
			</c:when><c:otherwise>
				<c:out value="[null, '${node2.item.label}', '${node2.item.href}', null, '${node2.item.label}'" escapeXml='false'/>
			</c:otherwise></c:choose>
			<c:if test="${0 < node2.childcount}">
			<c:set var="firstNode3" value="true"/>
			<c:forEach var="node3" items="${node2.children}">
				<bnb:Limitantes nomes="Acesso a pagina" recurso="${node3.item.href}">
				<c:if test="${firstNode3}">
					<c:out value="," escapeXml='false'/>
				</c:if>
				<c:if test="${!firstNode3 && !node.item.group}">
					_cmSplit,
				</c:if>
				<c:set var="firstNode3" value="false"/>
				<c:choose><c:when test="${node3.item.group}">
					<c:out value="[null, '${node3.item.label}', null, null, '${node3.item.label}'" escapeXml='false'/>
				</c:when><c:otherwise>
					<c:out value="[null, '${node3.item.label}', '${node3.item.href}', null, '${node3.item.label}'" escapeXml='false'/>
				</c:otherwise></c:choose>
				<c:if test="${0 < node3.childcount}">
				<c:set var="firstNode4" value="true"/>
				<c:forEach var="node4" items="${node3.children}">
					<bnb:Limitantes nomes="Acesso a pagina" recurso="${node4.item.href}">
					<c:if test="${firstNode4}">
						<c:out value="," escapeXml='false'/>
					</c:if>
					<c:if test="${!firstNode4 && !node.item.group}">
						_cmSplit,
					</c:if>
					<c:set var="firstNode4" value="false"/>
					<c:choose><c:when test="${node4.item.group}">
						<c:out value="[null, '${node4.item.label}', null, null, '${node4.item.label}'" escapeXml='false'/>
					</c:when><c:otherwise>
						<c:out value="[null, '${node4.item.label}', '${node4.item.href}', null, '${node4.item.label}'" escapeXml='false'/>
					</c:otherwise></c:choose>
					<c:out value="]" escapeXml='false'/><c:if test="${!status4.last}"><c:out value="," escapeXml='false'/></c:if>
					</bnb:Limitantes>
				</c:forEach><%--node4--%>
				</c:if>
				<c:out value="]" escapeXml='false'/><c:if test="${!status3.last}"><c:out value="," escapeXml='false'/></c:if>
				</bnb:Limitantes>
			</c:forEach><%--node3--%>
			</c:if>
			<c:out value="]" escapeXml='false'/><c:if test="${!status2.last}"><c:out value="," escapeXml='false'/></c:if>
			</bnb:Limitantes>
		</c:forEach><%--node2--%>
		</c:if>
		<c:out value="]" escapeXml='false'/><c:if test="${!status.last}"><c:out value="," escapeXml='false'/></c:if>
		</bnb:Limitantes>
	</c:forEach><%--node--%>
<c:out value="      ]" escapeXml='false'/>
</c:forEach><%--top--%>
<c:out value="];
cmDraw ('menuID', menu, 'vbr', cmThemeOffice, 'ThemeOffice');
</SCRIPT>" escapeXml='false'/>
</BODY>
</HTML>
