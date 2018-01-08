<?php

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
namespace MyApp\UserBundle\Controller;
use Symfony\Bundle\FrameworkBundle\Controller\Controller;
/**
 * Description of VisitorController
 *
 * @author mouad
 */
class VisitorController extends Controller{
    public function indexAction(){
        
        return $this->render('MyAppUserBundle:Visitor:index.html.twig');
    }
    //put your code here

    public function serviceAction(){
        
        
      return $this->render('MyAppUserBundle:Visitor:service.html.twig');
 
    }
    public function abouttnAction(){
        
        
      return $this->render('MyAppUserBundle:Visitor:abouttn.html.twig');
 
    }
    public function contactAction(){
        
        
      return $this->render('MyAppUserBundle:Visitor:contact.html.twig');
 
    }
    
    public function newsAction(){
        
        
      return $this->render('MyAppUserBundle:Visitor:news.html.twig');
 
    }
    public function ecitoyenniteAction(){
        
        
      return $this->render('MyAppUserBundle:Visitor:ecitoyennite.html.twig');
 
    }
    public function ecitoyenniteplusAction(){
        
        
      return $this->render('MyAppUserBundle:Visitor:ecitoyenniteplus.html.twig');
 
    }
    public function erouteAction(){
        
        
      return $this->render('MyAppUserBundle:Visitor:eroute.html.twig');
 
    }
    public function estudentAction(){
        
        
      return $this->render('MyAppUserBundle:Visitor:estudent.html.twig');
 
    }
    public function ejobAction(){
        
        
      return $this->render('MyAppUserBundle:Visitor:ejob.html.twig');
 
    }
    public function signinAction(){
        
        
      return $this->render('MyAppUserBundle:Visitor:signin.html.twig');
 
    }
    public function signupAction(){
        
        
      return $this->render('MyAppUserBundle:Visitor:signup.html.twig');
 
    }
    
      public function menu_permisAction(){
        
        
      return $this->render('MyAppUserBundle:Visitor:menu_permis.html.twig');
 
    }
    
         public function menu_carte_griseAction(){
        
        
      return $this->render('MyAppUserBundle:Visitor:menu_carte_grise.html.twig');

    }
    
        public function  menu_attestation_residenceAction(){
        
        
      return $this->render('MyAppUserBundle:Visitor:menu_attestation_residence.html.twig');

    }
    
          public function  ajout_permisAction(){
        
        
      return $this->render('MyAppUserBundle:Visitor:ajout_permis.html.twig');

    }
    
             public function  ajout_carte_griseAction(){
        
        
      return $this->render('MyAppUserBundle:Visitor:ajout_carte_grise.html.twig');

    }
            public function  ajout_attestation_residenceAction(){
        
        
      return $this->render('MyAppUserBundle:Visitor:ajout_attestation_residence.html.twig');

    }
    
    
             public function  edit_permisAction(){
        
        
      return $this->render('MyAppUserBundle:Visitor:edit_permis.html.twig');

    }
    
             public function  edit_carte_griseAction(){
        
        
      return $this->render('MyAppUserBundle:Visitor:edit_carte_grise.html.twig');

    }
            public function  edit_attestation_residenceAction(){
        
        
      return $this->render('MyAppUserBundle:Visitor:edit_attestation_residence.html.twig');

    }
    
                 public function  affiche_permisAction(){
        
        
      return $this->render('MyAppUserBundle:Visitor:affiche_permis.html.twig');

    }
    
             public function  affiche_carte_griseAction(){
        
        
      return $this->render('MyAppUserBundle:Visitor:affiche_carte_grise.html.twig');

    }
            public function  affiche_attestation_residenceAction(){
        
        
      return $this->render('MyAppUserBundle:Visitor:affiche_attestation_residence.html.twig');

    }
    
    public function menuPasseportAction(){
        
        
      return $this->render('MyAppUserBundle:Visitor:menuPasseport.html.twig');
 
    }
    
    public function menuContratAction(){
        
        
      return $this->render('MyAppUserBundle:Visitor:menuContrat.html.twig');
 
    }
    
     public function menuCarteAction(){
        
        
      return $this->render('MyAppUserBundle:Visitor:menuCarte.html.twig');
     }
     public function  ajout_passeportAction(){
        
        
      return $this->render('MyAppUserBundle:Visitor:ajout_passeport.html.twig');

    }
    
    public function  affiche_passeportAction(){
        
        
      return $this->render('MyAppUserBundle:Visitor:affiche_passeport.html.twig');

    }
    
    public function  lister_passeportAction(){
        
        
      return $this->render('MyAppUserBundle:Visitor:lister_passeport.html.twig');

    }
    public function  modif_passeportAction(){
        
        
      return $this->render('MyAppUserBundle:Visitor:modif_passeport.html.twig');

    }
      public function  ajout_contratAction(){
        
        
      return $this->render('MyAppUserBundle:Visitor:ajout_contrat.html.twig');

    }
    }

  
