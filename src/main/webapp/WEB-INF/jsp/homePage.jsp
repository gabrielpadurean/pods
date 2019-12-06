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
	<header>
		<nav class="orange lighten-1"></nav>
	</header>
	<main>
		<div class="container">
			<div class="row">
				<div class="col s6 m5 left">
					<div class="card">
						<div class="card-image">
							<img src="${apod.hdurl}"/>
						</div>
						<div class="card-action">
							<a href="/apods">View all astronomical pictures of the day</a>
						</div>
					</div>
				</div>
				<div class="col s6 m5 right">
					<div class="card">
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
	<footer class="page-footer teal">
		<div class="container">
			<div class="row">
				<div class="col l6 s12">
					<h5 class="white-text">Pods</h5>
					<p class="grey-text text-lighten-4">
						This Pods website contains collections with the latest astronomical pictures of the day from
						<a href="https://www.nasa.gov/" target="_blank" class="grey-text text-lighten-3"><i>NASA</i></a> and the latest pictures of the day from 
						<a href="https://www.wikipedia.org/" target="_blank" class="grey-text text-lighten-3"><i>Wikipedia</i></a>.
					</p>
				</div>
				<div class="col l4 offset-l2 s12">
				    <h5 class="white-text">Links</h5>
					<ul>
						<li><a class="grey-text text-lighten-3" href="/apods">APODs</a></li>
						<li><a class="grey-text text-lighten-3" href="/wpods">WPODs</a></li>
						<li><a class="grey-text text-lighten-3" href="/about">About</a></li>
						<li><a class="grey-text text-lighten-3" href="/contact">Contact</a></li>
					</ul>
				</div>
			</div>
		</div>
		<div class="footer-copyright">
			<div class="container">&copy; 2019 Pods, All rights reserved.</div>
		</div>
	</footer>
</body>
</html>