<#macro filterheader>
<div class="navbar hidden-xs" role="navigation">
 <div class="container-fluid">
	 <div class="collapse navbar-collapse">
		 <ul class="nav navbar-nav">
       <li class="secured">
				 <a href="/laboratoire">Espace Enseignants</a>
			 </li>
       <li>
          <a href="/listAtelier">Liste des Ateliers</a>
       </li>
       <li>
         <a href="/accueil?faq">FAQ</a>
       </li>
       <li>
         <a href="/accueil?historique">Historique</a>
       </li>
			 <li>
				 <a href="/accueil?disconnect">Déconnexion</a>
			 </li>
		 </ul>
	 </div>
 </div>
</div>

<nav class="navbar navbar-inverse visible-xs-block" id="xsmenu">
 <div class="container">
	 <div class="navbar-header">
		 <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
			 <span class="sr-only">Toggle navigation</span>
			 <span class="icon-bar"></span>
			 <span class="icon-bar"></span>
			 <span class="icon-bar"></span>
		 </button>
		 <a class="navbar-brand" href="/">Circuit Scientifique Bordelais</a>
	 </div>
	 <div id="navbar" class="collapse navbar-collapse">
		 <ul class="nav navbar-nav">
			 <li class="dropdown">
				 <a href="#" class="dropdown-toggle" data-toggle="dropdown">Le circuit</a>
				 <ul class="dropdown-menu" role="menu">
					 <li><a href="/">Accueil</a></li>
					 <li><a href="/detailsAtelier">detailsAtelier</a></li>
				 </ul>
			 </li>
			 <li class="secured"><a href="/teachers">Espace Enseignants</a></li>
			 <li><a href="/page/faq">FAQ</a></li>
		 </ul>
	 </div><!--/.nav-collapse -->
 </div>
</nav>
</#macro>
