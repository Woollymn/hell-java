<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="referer"><%=request.getHeader("referer")%></c:set>
<c:set var="currentPath"><%=request.getContextPath() + "/"%></c:set>

<c:if test="${referer ne currentPath}">
    <c:redirect url="/"></c:redirect>
</c:if>
