package servlet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import database.MainDatabase;
import metier.Atelier;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class LaboratoireServlet extends AbstractServlet{


	@Override
	public ModelAndView handle(Request req, Response res) throws Exception {

		if(req.requestMethod() == "GET")
		{

			Map<String, Object> attributes = new HashMap<>();
			List<Atelier> listAtelier = new ArrayList<Atelier>();
			attributes.put("header", "Laboratoire");
			if(!req.session().attributes().isEmpty())
				attributes.put("laboName", req.session().attributes().iterator().next());
			else 
				attributes.put("laboName", "Default name");
			
			try{

			listAtelier = MainDatabase.getAtelierByResponsable(req.session().attributes().iterator().next());

			Iterator i = listAtelier.iterator();
			// Un visiteur veut lister les ateliers disponibles à la date du jour
			
			// attributes contient une liste d'objets Ateliers
			// le template va ensuite "looper" dans cette liste pour les afficher grâce à <#list ateliers as atelier> ... </#list>
			attributes.put("ateliers", listAtelier);
	        return new ModelAndView(attributes, "laboratoire.ftl");
			}
			catch(Exception e){
				listAtelier = new ArrayList<Atelier>();
				listAtelier.add(new Atelier("Aucun", "Vous n'avez pas encore enregistré d'atelier", "", "", "", "", "", 0));
				attributes.put("ateliers",listAtelier);
		        return new ModelAndView(attributes, "laboratoire.ftl");
			}
		}
		return null;

	}

}
