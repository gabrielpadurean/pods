<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <link rel="shortcut icon" type="image/png" href="/images/favicon.png"/>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link type="text/css" rel="stylesheet" href="css/main.css" media="screen,projection"/>
    <link type="text/css" rel="stylesheet" href="css/materialize.min.css" media="screen,projection"/>

    <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="js/materialize.min.js"></script>

    <title>Pods</title>
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
								<c:when test="${apod.mediaType == 'video'}">
								    <div class="video-container">
										<iframe width="510" height="300" src="${apod.url}" frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
									</div>
								</c:when>
								<c:otherwise>
									<img src="${apod.url}"/>
								</c:otherwise>
							</c:choose>
						</div>
						<div class="card-action">
							<a href="/apods">View all astronomical pictures of the day</a>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col s12">
					<div class="card hoverable">
						<div class="card-image">
							<img src="${wpod.link}"/>
						</div>
						<div class="card-action">
							<a href="/wpods">View all wikipedia pictures of the day</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</main>
	
	<jsp:include page="footer.jsp"/>
</body>
</html>