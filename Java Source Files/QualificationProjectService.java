package Services;

import java.rmi.RemoteException;

import Services.AffectationServiceStub.AffectationService;
import Services.AffectationServiceStub.AffectationServiceResponse;
import Services.DisponibiliteEquipierServiceStub.DisponibiliteEquipierService;
import Services.DisponibiliteEquipierServiceStub.DisponibiliteEquipierServiceResponse;
import Services.PlanExecutionServiceStub.PlanExecutionService;
import Services.PlanExecutionServiceStub.PlanExecutionServiceResponse;
import Services.VerificationTypeProjectServiceStub.VerificationTypeProjectService;
import Services.VerificationTypeProjectServiceStub.VerificationTypeProjectServiceResponse;


public class QualificationProjectService {


		    public static String QualificationProjectService(String nomClient,String prenomClient,int typeProjet) throws RemoteException {
		        
		    	//initialisation des stubs
		    	VerificationTypeProjectServiceStub verifStub = new VerificationTypeProjectServiceStub();
		    	PlanExecutionServiceStub planStub = new PlanExecutionServiceStub();
		    	DisponibiliteEquipierServiceStub dispoStub = new DisponibiliteEquipierServiceStub();
		    	AffectationServiceStub affecStub = new AffectationServiceStub();
		    	
		    	//initialisation des services à appeler
		    	VerificationTypeProjectService verifService = new VerificationTypeProjectService();
		    	PlanExecutionService planService = new PlanExecutionService();
		    	DisponibiliteEquipierService dispoService = new DisponibiliteEquipierService();
		    	AffectationService affectService = new AffectationService();

		        //initialisation des reponses de services
		    	VerificationTypeProjectServiceResponse verifResponse = new VerificationTypeProjectServiceResponse();
		    	PlanExecutionServiceResponse planResponse = new PlanExecutionServiceResponse();
		    	DisponibiliteEquipierServiceResponse dispoResponse = new DisponibiliteEquipierServiceResponse();
		    	AffectationServiceResponse affectResponse = new AffectationServiceResponse();
		    	
		        //lancer la verification
		    	verifService.setClientNom(nomClient);
		    	verifService.setClientPrenom(prenomClient);
		    	verifService.setChoixProjet(typeProjet);
		    	
		    	//retourne la reponse de verification
		    	verifResponse = verifStub.verificationTypeProjectService(verifService);	
		    	
		    	System.out.println(verifResponse.get_return());
		    	String S= verifResponse.get_return();
		        if((S.charAt(0)=='1')||(S.charAt(0)=='2')||(S.charAt(0)=='3')||(S.charAt(0)=='4')||(S.charAt(0)=='5')||(S.charAt(0)=='6')||(S.charAt(0)=='7')||(S.charAt(0)=='8'))
		        {
		        	//lancer le service de plan d'execution
		        	planService.setTypeProjet(typeProjet);
		        	planResponse = planStub.planExecutionService(planService);
		        	if(!planResponse.get_return().matches("0"))
		        	{
		        		//lancer le service de disponibilite
			        	dispoService.setTypeProjet(typeProjet);
			        	dispoResponse = dispoStub.disponibiliteEquipierService(dispoService);
			        	System.out.println("plan " + planResponse.get_return());
		        		if(!dispoResponse.get_return().matches("Pas de disponibilite possible pour votre type de projet, votre type de projet n'est pas inclus dans nos services"))
		        		{
		        			System.out.println("dispo " + dispoResponse.get_return());
		        			//lancer le service d'affectation
		        			if(Integer.parseInt(dispoResponse.get_return()) >= Integer.parseInt(planResponse.get_return()))
		        			{
			        			affectService.setIdProject(typeProjet);
			        			affectResponse = affecStub.affectationService(affectService);
			        			
			        			return "Mr "+nomClient+" "+ prenomClient+ " votre"+affectResponse.get_return()+" Nombre d'ingenieurs "+dispoResponse.get_return();
		        			}else return "Pas assez d'ingenieurs pour le projet";
		        		}
		        		else return "Indisponibilite d'ingenieurs pour le projet desiré";
		        	}
		        	else return "Y'en a pas de plan d'execution correct pour votre projet";
		        }
		        
		        return  "Pas de disponibilite possible pour votre type de projet, votre type de projet n'est pas inclus dans nos services";
		}
	

		   

}