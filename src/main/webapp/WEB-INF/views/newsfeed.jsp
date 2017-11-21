<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page import="java.util.List, java.util.Iterator, com.gsahu.newsfeed.model.Article;" %>
<html>
<head>
<title>News Feed</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css"
	integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb"
	crossorigin="anonymous">
</head>
<body>

	<div>	
	<% 
		List<Article> articleList = (List<Article>) request.getAttribute("articles");
		Iterator<Article> articleIterator = articleList.iterator();
		Article article = null;
		
		while(articleIterator.hasNext()) {
			article = articleIterator.next();
			pageContext.setAttribute("article", article);
	%>

	<div class="card mb-3" style="width:900px">
		<img class="card-img-top" src="${pageScope.article.urlToImage}" alt="Card image cap">
		<div class="card-body">
			<h4 class="card-title">${pageScope.article.title}</h4>
			<p class="card-text">${pageScope.article.description}</p>
			<p class="card-text">
				<small class="text-muted">${pageScope.article.publishedAt}</small>
			</p>
		</div>
	</div>

	<%
		}
	%>
	</div>
	
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous" />
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js"
		integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh"
		crossorigin="anonymous" />
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"
		integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ"
		crossorigin="anonymous" />
</body>
</html>
