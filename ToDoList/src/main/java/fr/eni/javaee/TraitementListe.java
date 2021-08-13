package fr.eni.javaee;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Traitement
 */
@WebServlet("/TraitementListe")
public class TraitementListe extends HttpServlet {
	//ma liste de tâches et stockée dans mon servlet
	private List<String> ListeAFaire; 
	
	public void init() throws ServletException {
		this.ListeAFaire = new ArrayList<String>();
	}
	/* est appelé quand on accède directmenet au site
	 * */
	 

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			//1-  ajoute en attribut de requête la liste des tâches	
		request.setAttribute("ListeAFaire",this.ListeAFaire);
		//2- rediriger vers la JSP
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/formulaire.jsp");
		rd.forward(request, response);
	}
	

	/**
	 * est appelé quand on valide le formulaire
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String choseAFaire = request.getParameter("afaire");
		//String modifierID = request.getParameter("update");
		String supprimerID = request.getParameter("delete");
		
		//Si jamais le paramètre delete est present
		if(supprimerID !=null) {
			//Alors je supprime la tâche à l'index correspondant
			this.ListeAFaire.remove(Integer.parseInt(supprimerID));
		}else { /*if (modifierID !=null) {
			this.ListeAFaire.set(Integer.parseInt(modifierID));*/
		
			this.ListeAFaire.add(choseAFaire);
	}
//	
				
//			supprimer : ListeAFaire.set(0, choseAFaire) ; 
//				}
//			modifier :  ListeAFaire.remove(0
	
		response.sendRedirect("./");


	}

}
