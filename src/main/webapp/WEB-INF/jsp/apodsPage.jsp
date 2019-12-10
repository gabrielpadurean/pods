<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <link rel="shortcut icon" type="image/png" href="/images/favicon.png"/>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link type="text/css" rel="stylesheet" href="css/main.css" media="screen,projection"/>
    <link type="text/css" rel="stylesheet" href="css/materialize.min.css" media="screen,projection"/>

    <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="js/materialize.min.js"></script>

    <title>APODs</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
</head>
<body>
	<jsp:include page="header.jsp"/>

	<main>
		<div class="container">
			<div class="row">
				<div class="col s12">
					<div class="card hoverable">
						<div class="card-image">
							<c:choose>
								<c:when test="${apods[0].mediaType == 'video'}">
								    <div class="video-container">
										<iframe src="${apods[0].url}" frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
									</div>
								</c:when>
								<c:otherwise>
									<img src="${apods[0].url}"/>
								</c:otherwise>
							</c:choose>
							<span class="card-title">${apods[0].title}</span>
						</div>
						<div class="card-content">
							<p>${apods[0].explanation}</p>
						</div>
						<div class="card-action">
							<fmt:parseDate value="${apods[0].date}" pattern="yyyy-MM-dd" var="apodDate" type="date"/>
							Date: <fmt:formatDate pattern="dd MMMM, yyyy" value="${apodDate}"/>
						</div>
					</div>
				</div>
			</div>
			<div class="row smallCards">
				<c:forEach var="apod" varStatus="apodsMeta" items="${apods}">
					<div class="col s12 s6 l4">
						<div class="card large hoverable">
							<div class="card-image">
								<c:choose>
									<c:when test="${apod.mediaType == 'video'}">
									    <div class="video-container">
											<iframe src="${apod.url}" frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
										</div>
									</c:when>
									<c:otherwise>
										<img src="${apod.url}"/>
									</c:otherwise>
								</c:choose>
								<span class="card-title">${apod.title}</span>				
								<a class="btn-floating halfway-fab waves-effect waves-light red" title="Click to view large version"><i class="material-icons">add</i></a>
							</div>
							<div class="card-content">
								<p>${fn:substring(apod.explanation,0, 200)}...</p>
							</div>
							<div class="card-action">
								<fmt:parseDate value="${apod.date}" pattern="yyyy-MM-dd" var="apodDate" type="date"/>
								Date: <fmt:formatDate pattern="dd MMMM, yyyy" value="${apodDate}"/>
							</div>
						</div>
					</div>
					<c:if test="${apodsMeta.count % 3 == 0 && !apodsMeta.last}">
						<div class="clear"></div>
					</c:if>
				</c:forEach>
			</div>
		</div>
	</main>
	
	<jsp:include page="footer.jsp"/>
</body>
</html>