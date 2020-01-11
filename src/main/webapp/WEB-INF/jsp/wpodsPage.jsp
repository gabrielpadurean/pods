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
	<script type="text/javascript">
		$(document).ready(function() {
			$('.materialboxImage').materialbox();
		});

		function viewLargeVersion(elem) {
			var newDate = $(elem).parent().parent().find('.card-action').html();
			var newContent = $(elem).parent().parent().find('.card-content .hidden').html();
			var newMedia = $(elem).parent().children()[0].outerHTML;

			$('.bigCard .card-content p').html(newContent);
			$('.bigCard .card-action').html(newDate);
			$('.bigCard .card-image').children().first().replaceWith(newMedia);
			
			$('.bigCard .materialboxImage').materialbox();
			
			$(document).scrollTop(0);
		};
	</script>

    <title>WPODs</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
</head>
<body>
	<jsp:include page="header.jsp"/>

	<main>
		<div class="container">
			<div class="row bigCard">
				<div class="col s12">
					<div class="card hoverable">
						<div class="card-image">
							<img class="materialboxImage" title="Click to enlarge image" src="${wpods[0].link}"/>
						</div>
						<div class="card-content">
							<p>${wpods[0].description}</p>
						</div>
						<div class="card-action">
							<fmt:parseDate value="${wpods[0].date}" pattern="yyyy-MM-dd" var="wpodDate" type="date"/>
							Date: <fmt:formatDate pattern="dd MMMM, yyyy" value="${wpodDate}"/>
						</div>
					</div>
				</div>
			</div>
			<div class="row smallCards">
				<c:forEach var="wpod" varStatus="wpodsMeta" items="${wpods}">
					<div class="col s12 s6 l4">
						<div class="card large hoverable">
							<div class="card-image">
								<img class="materialboxImage" title="Click to enlarge image" src="${wpod.link}"/>
								<a class="btn-floating halfway-fab waves-effect waves-light red" title="Click to view large version" href="javascript:;" onclick="viewLargeVersion(this);"><i class="material-icons">add</i></a>
							</div>
							<div class="card-content">
								<p>${fn:substring(wpod.description,0, 200)}...</p>
								<p class="hidden">${wpod.description}</p>
							</div>
							<div class="card-action">
								<fmt:parseDate value="${wpod.date}" pattern="yyyy-MM-dd" var="wpodDate" type="date"/>
								Date: <fmt:formatDate pattern="dd MMMM, yyyy" value="${wpodDate}"/>
							</div>
						</div>
					</div>
					<c:if test="${wpodsMeta.count % 3 == 0 && !wpodsMeta.last}">
						<div class="clear"></div>
					</c:if>
				</c:forEach>
			</div>
		</div>
	</main>
	
	<jsp:include page="footer.jsp"/>
</body>
</html>