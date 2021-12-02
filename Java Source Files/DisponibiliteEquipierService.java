package Services;

public class DisponibiliteEquipierService {

	//Retourne les ingenieurs disponibles
	//pour la réalisation du projet
	
	public static String DisponibiliteEquipierService(int typeProjet) 
	{
			
		int[] listeDispos = new int [8];
		int j=0;
		
		//donner le nombre d'ingenieurs existants dans le systeme d'informations
		while(j < 8)
		{
			
			switch (j+1) {
			  case 1:
			    listeDispos[0] = RandomSOA(5); 
				  break;
			 
			  case 2:
				listeDispos[1] = RandomSOA(4); 
				  break;
			    
			  case 3:
			    listeDispos[2] = RandomSOA(3);
				  break;
			    
			  case 4:
			    listeDispos[3] = RandomSOA(2);
				  break;
			    
			  case 5:
				listeDispos[4] = RandomSOA(5);
				  break;
			    
			  case 6:
				listeDispos[5] = RandomSOA(5);
				  break;
				
			  case 7:
				  listeDispos[6] = RandomSOA(8);
				  break;
				  
			  case 8:
				  listeDispos[7] = RandomSOA(5);
				  break;
			
			}
			
			j++;
		}
		
		
			
		j=0;
		while(j < 8)
		{
			System.out.println("Le service "+ (j+1)+ " a    " +listeDispos[j]+" ingenieurs dispos");

			j++;
		}
	
		switch (typeProjet) {
		  case 1:
		    return String.valueOf(listeDispos[0]);
		    
		  case 2:
			 return String.valueOf(listeDispos[1]);
			    
		  case 3:
			  return String.valueOf(listeDispos[2]);
			
		  case 4:
			  return String.valueOf(listeDispos[3]);
			     
		  case 5:
			  return String.valueOf(listeDispos[4]);
			    
		  case 6:
			  return String.valueOf(listeDispos[5]);
			    
		  case 7:
			  return String.valueOf(listeDispos[6]);
			    
		  case 8:
			  return String.valueOf(listeDispos[7]);
			  
		  default:
			    return "Pas de disponibilite possible pour votre type de projet, votre type de projet n'est pas inclus dans nos services";
		
		}
				
	}
			
	public static int RandomSOA(int capaciteMaxChaqueEquipe)
	{
		 double d = Math.random();
	        int n = (int)d;
	        
	        	n = 0+(int)(Math.random() * (capaciteMaxChaqueEquipe+1));
	        
	        
		return n;
	}
	/*
	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		
		int i=0;
		while(i<5){
		System.out.println(DisponibiliteEquipierService(4));
		i++;
		}
		
		
	}
	*/

}