<?php


namespace MyApp\UserBundle\Controller;

use Symfony\Component\HttpFoundation\Request;
use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use MyApp\UserBundle\Entity\User;
use MyApp\UserBundle\Entity\Passeport;
use MyApp\UserBundle\Form\PasseportType;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Description of AdminPasseportController
 *
 * @author boumaiza
 */
class AdminPasseportController extends Controller {
    
    
        public function show_passeportAction($numPasseport){
        
        $em = $this->getDoctrine()->getEntityManager();
        /* @var $user type */
        $user = $this->container->get('security.context')->getToken()->getUser();
         
         
     
$passeport = $em->getRepository('EGOVUserBundle:Passeport')->find($numPasseport);
       
        return $this->render('EGOVUserBundle:Passeport:admin_show_passeport.html.twig',array('passeport'=>$passeport));
 
    }
    
    
    
     public function liste_passeportAction(){
        
        $em = $this->getDoctrine()->getEntityManager();
    $passeport = $em->getRepository('EGOVUserBundle:Passeport')->findAll();
return $this->render('EGOVUserBundle:Passeport:liste_passeport.html.twig',array('passeport'=>$passeport));
 



    }
     public function valider_passeportAction($numPasseport){
        
        $em = $this->getDoctrine()->getEntityManager();
         
         $passeport = $em->getRepository('EGOVUserBundle:Passeport')->findAll();
         
     $passeport1 = $em->getRepository('EGOVUserBundle:Passeport')->find($numPasseport);
     $passeport1->setValidation("validé");
      $em->flush();
      
        
    
return $this->render('EGOVUserBundle:Passeport:liste_passeport.html.twig',array('passeport'=>$passeport));
 

    }

    public function supprimer_passeportAction($numPasseport){
        
        $em = $this->getDoctrine()->getEntityManager();
        $passeport1 = $em->getRepository('EGOVUserBundle:Passeport')->find($numPasseport);
        $em->remove($passeport1);
         $passeport = $em->getRepository('EGOVUserBundle:Passeport')->findAll();
            
         
        $em->flush();
      return 1;
      
      
  
 
    }
}
