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
			<div class="row smallCards">
				<div class="col s12 m6 l6">
					<div class="card hoverable">
						<div class="card-image">
							<img src="/images/apodLogo.png"/>
						</div>
						<div class="card-action">
							<a href="/apods">View all astronomy pictures of the day</a>
						</div>
					</div>
				</div>
				<div class="col s12 m6 l6">
					<div class="card hoverable">
						<div class="card-image">
							<img src="/images/wpodLogo.png"/>
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