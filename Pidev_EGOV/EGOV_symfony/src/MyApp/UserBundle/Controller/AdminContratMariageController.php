<?php

namespace MyApp\UserBundle\Controller;

use Symfony\Component\HttpFoundation\Request;
use Symfony\Bundle\FrameworkBundle\Controller\Controller;

use MyApp\UserBundle\Entity\ContratMariage;
use MyApp\UserBundle\Form\ContratMariageType;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Description of AdminContratMariage
 *
 * @author boumaiza
 */
class AdminContratMariageController extends Controller{
    public function show_contratAction($id_contrat){
        
        $em = $this->getDoctrine()->getEntityManager();
        /* @var $user type */
        $user = $this->container->get('security.context')->getToken()->getUser();
         
         
     
$contratmariage = $em->getRepository('EGOVUserBundle:ContratMariage')->find($id_contrat);
       
        return $this->render('EGOVUserBundle:ContratMariage:admin_show_contrat.html.twig',array('contratmariage'=>$contratmariage));
 
    }
    
      public function liste_contratAction(){
        
        $em = $this->getDoctrine()->getEntityManager();
    $contratmariage = $em->getRepository('EGOVUserBundle:ContratMariage')->findAll();
return $this->render('EGOVUserBundle:ContratMariage:liste_ContratMariage.html.twig',array('contratmariage'=>$contratmariage));
    
}


public function valider_contratAction($id_contrat){
        
        $em = $this->getDoctrine()->getEntityManager();
         
         $contratmariage = $em->getRepository('EGOVUserBundle:ContratMariage')->findAll();
         
     $contratmariage = $em->getRepository('EGOVUserBundle:ContratMariage')->find($id_contrat);
     $mail= $contratmariage->getUtilisateur()->getEmail();
      $contratmariage->setValidation("validé");
      $em->flush();
      $mailer = $this->container->get('mailer');
        $message = \Swift_Message::newInstance()
                ->setSubject('Confirmation de la creation de votre contrat')
                ->setFrom('amina.mahdhaoui@esprit.tn')
                ->setTo($mail)
                ->setCharset('utf-8')
                ->setContentType('text/html')
                ->setBody('Votre contrat est validé');
        
        $mailer->send($message);
        
    
return $this->render('EGOVUserBundle:ContratMariage:liste_ContratMariage.html.twig',array('contratmariage'=>$contratmariage));
 

    }
    
       public function supprimer_contratAction($id_contrat){
        
        $em = $this->getDoctrine()->getEntityManager();
               $contratmariage = $em->getRepository('EGOVUserBundle:ContratMariage')->findAll();
         $contratmariage = $em->getRepository('EGOVUserBundle:ContratMariage')->find($id_contrat);
         foreach ($id_contrat as $id_contrat) {
         $em->remove($id_contrat);}
        $em->flush();
      return 1;
      
      
  
 
    }

}
