<?php

namespace MyApp\UserBundle\Controller;

use Symfony\Component\HttpFoundation\Request;
use Symfony\Bundle\FrameworkBundle\Controller\Controller;

use EGOV\UserBundle\Entity\ContratMariage;
use EGOV\UserBundle\Form\ContratMariageType;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Description of ContratMariageController
 *
 * @author boumaiza
 */
class ContratMariageController extends Controller {
     public function add_contratmariageAction()
    {
       
        $em = $this->getDoctrine()->getManager();//t7atharli l entity contrat
        $user = $this->container->get('security.context')->getToken()->getUser();//user courrant  e5er user d5al l interface ajout contrat
        $entity = new ContratMariage();
       
         $form = $this->createForm(new ContratMariageType(), $entity);//relation entre les champs et l entité contrat
        if (!$entity) {
            throw $this->createNotFoundException('Unable to find Contrat entity.');
        }

         if ($this->get('request')->getMethod() == 'POST') {//post=true le client a remplit les champts //request=champs remplit par l user+type de request(post/get)
            $form->handleRequest($this->getRequest());//yna9el les données fi variable form 
        
       

        if ($form->isValid()) {//isvalid=les type données entrées par le user = type des données de la bd (entite)
            $entity->setUtilisateur($user);//t3abi manuellement e5er user connecta
            $entity->setValidation("non validé");
            
            
            $em->persist($entity);
            $em->flush();
            

            return 1;
         }}

        return $this->render('EGOVUserBundle:ContratMariage:add_ContratMariage.html.twig', array(
            'entity'      => $entity,
             'user'      => $user,
            
            'form'   => $form->createView(),
            
            
        ));
    }
    
    
     public function show_contratmariageAction(){
        
        $em = $this->getDoctrine()->getEntityManager();
         $user = $this->container->get('security.context')->getToken()->getUser();
         
         
     $contratmariage = $em->getRepository('EGOVUserBundle:ContratMariage')->findBy(array('utilisateur' => $user));
     $contratmariage = $em->getRepository('EGOVUserBundle:ContratMariage')->find($contratmariage[0]);
       
        return $this->render('EGOVUserBundle:ContratMariage:show_ContratMariage.html.twig',array('contratmariage'=>$contratmariage,'user'=>$user));
 
    }
    
     public function edit_contrat_userAction( )
    {        $em = $this->getDoctrine()->getEntityManager();
         $user = $this->container->get('security.context')->getToken()->getUser();
         
         
     $contratmariage = $em->getRepository('EGOVUserBundle:ContratMariage')->findBy(array('utilisateur' => $user));
  
$entity = $em->getRepository('EGOVUserBundle:ContratMariage')->find($contratmariage[0]);
      
       

       
         $form = $this->createForm(new ContratMariageType(), $entity);
        if (!$entity) {
            throw $this->createNotFoundException('Unable to find ContratMariage entity.');
        }

         if ($this->get('request')->getMethod() == 'POST') {
            $form->handleRequest($this->getRequest());
        
       

        if ($form->isValid()) {
            $em->flush();
return 1 ;
//            return $this->redirect($this->generateUrl('edit_contrat_user'));
         }}

        return $this->render('EGOVUserBundle:ContratMariage:edit_ContratMariage_user.html.twig', array(
            'entity'      => $entity,
             'user'      => $user,
            'form'   => $form->createView(),
            
        ));
    }
}
