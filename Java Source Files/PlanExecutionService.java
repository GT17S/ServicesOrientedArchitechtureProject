package Services;

public class PlanExecutionService {
	public int res;
	//Retourne le nombre d'ingenieurs que le projet à besoin 
	//Projet non figurant dans les services pour sa réalisation
	
	//int typeProjet Par Rapport Au nuùm d'Equipes
	public static String PlanExecutionService(int typeProjet)
	{
		PlanExecutionService p= new PlanExecutionService();
		
		switch (typeProjet) {
		  case 1:
		    System.out.println("1, Product and application dévelopment");
		    return String.valueOf(p.RandomSOA(5));
		    
		  case 2:
		    System.out.println("2, Data Engineering");
		    return String.valueOf(p.RandomSOA(4));
		    
		  case 3:
		    System.out.println("3, Business Intelligence");
		    return String.valueOf(p.RandomSOA(3));
		    
		  case 4:
		    System.out.println("4, Data Science");
		    return String.valueOf(p.RandomSOA(2));
		    
		  case 5:
		    System.out.println("5, Social Media Analytics");
		    return String.valueOf(p.RandomSOA(5));
		    
		    
		  case 6:
		    System.out.println("6, Video Analytics");
		    return String.valueOf(p.RandomSOA(5));
		    
		  case 7:
		    System.out.println("7, Chatbot");
		    return String.valueOf(p.RandomSOA(8));
		    
		  case 8:
			System.out.println("8, Formation et transfert de connaissances");
			return String.valueOf(p.RandomSOA(5));
			         
			  
		  default:
			    return "0";
		}
	}
   
		
		
		 public int RandomSOA(int capaciteMaxChaqueEquipe)
			{
				 double d = Math.random();
			        int n = (int)d;
			        	n = 0 + (int)(Math.random() * (capaciteMaxChaqueEquipe+1));
			        
				return n;
			}
	
		
}