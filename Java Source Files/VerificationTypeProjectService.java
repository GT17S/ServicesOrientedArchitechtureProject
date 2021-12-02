package Services;

public class VerificationTypeProjectService {

	
	public static String VerificationTypeProjectService(String clientNom,String clientPrenom,int choixProjet)
	{
		
		switch (choixProjet) {
		  case 1:
		    System.out.println("1, Product and application dévelopment");
		    return "1, Product and application dévelopment";
		    
		  case 2:
		    System.out.println("2, Data Engineering");
		    return "2, Data Engineering";
		  
		  case 3:
		    System.out.println("3, Business Intelligence");
		    return "3, Business Intelligence";
		  
		  case 4:
		    System.out.println("4, Data Science");
		    return "4, Data Science";

		  case 5:
		    System.out.println("5, Social Media Analytics");
		    return "5, Social Media Analytics";
		    
		  case 6:
		    System.out.println("6, Video Analytics");
		    return "6, Video Analytics";
		    
		  case 7:
		    System.out.println("7, Chatbot");
		    return "7, Chatbot";
		    
		  case 8:
			    System.out.println("8, Formation et transfert de connaissances");
			    return "8, Formation et transfert de connaissances";
			  
			  
		  default:
			    System.out.println("Le type de projet que vous cherchez n'est pas conçevable chez nous");
			    return "Votre projet est refusé car aucune de nos équipes peut le concevoir.";
		}
	}
   
}