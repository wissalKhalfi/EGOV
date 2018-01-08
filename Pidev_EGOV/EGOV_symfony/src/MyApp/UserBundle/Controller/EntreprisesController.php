<?php

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
namespace MyApp\UserBundle\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\Controller;

/**
 * Description of UserController
 *
 * @author mouad
 */
class EntreprisesController extends Controller{
    //put your code here
    public function indexAction(){
        
        return $this->render('MyAppUserBundle:Entreprises_Front:index.html.twig');
   
}
public function serviceAction(){
        
        
      return $this->render('MyAppUserBundle:Entreprises_Front:service.html.twig');
 
    }
    public function abouttnAction(){
        
        
      return $this->render('MyAppUserBundle:Entreprises_Front:abouttn.html.twig');
 
    }
    public function contactAction(){
        
        
      return $this->render('MyAppUserBundle:Entreprises_Front:contact.html.twig');
 
    }
    
    public function newsAction(){
        
        
      return $this->render('MyAppUserBundle:Entreprises_Front:news.html.twig');
 
    }
    public function ecitoyenniteAction(){
        
        
      return $this->render('MyAppUserBundle:Entreprises_Front:ecitoyennite.html.twig');
 
    }
    public function ecitoyenniteplusAction(){
        
        
      return $this->render('MyAppUserBundle:Entreprises_Front:ecitoyenniteplus.html.twig');
 
    }
    public function erouteAction(){
        
        
      return $this->render('MyAppUserBundle:Entreprises_Front:eroute.html.twig');
 
    }
    public function estudentAction(){
        
        
      return $this->render('MyAppUserBundle:Entreprises_Front:estudent.html.twig');
 
    }
    public function ejobAction(){
        
      $em = $this->getDoctrine()->getEntityManager();
      $Candidature = $em->getRepository('MyAppUserBundle:Candidature')->findAll();
      
      return $this->render('MyAppUserBundle:Entreprises_Front:ejob.html.twig' , array('candidatures'=>$Candidature));
 
    }
    
  
}