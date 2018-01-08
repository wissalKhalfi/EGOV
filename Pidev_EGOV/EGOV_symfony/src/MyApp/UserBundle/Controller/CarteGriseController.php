<?php

namespace MyApp\UserBundle\Controller;

use Symfony\Component\HttpFoundation\Request;
use Symfony\Bundle\FrameworkBundle\Controller\Controller;

use MyApp\UserBundle\Entity\CarteGrise;
use MyApp\UserBundle\Form\CarteGriseType;


/**
 * Description of CarteGriseController
 *
 * @author Aya
 */
class CarteGriseController extends Controller {
    
      public function add_carte_griseAction()
    {
       
        $em = $this->getDoctrine()->getManager();//t7atharli l entity permis
        $user = $this->container->get('security.context')->getToken()->getUser();//user courrant  e5er user d5al l interface ajout permis
        $entity = new CarteGrise();
       
         $form = $this->createForm(new CarteGriseType(), $entity);//relation entre les champs et l entité permis
        if (!$entity) {
            throw $this->createNotFoundException('Unable to find CarteGrise entity.');
        }

         if ($this->get('request')->getMethod() == 'POST') {//post=true le client a remplit les champts //request=champs remplit par l user+type de request(post/get)
            $form->handleRequest($this->getRequest());//yna9el les données fi variable form 
        
       

        if ($form->isValid()) {//isvalid=les type données entrées par le user = type des données de la bd (entite)
            $entity->setUtilisateur($user);
            $entity->setValidation("non validé");
            $em->persist($entity);
            $em->flush();
            

          
            return $this->redirect($this->generateUrl('edit_carte_grise'));
         }}

        return $this->render('MyAppUserBundle:CarteGrise:add_carte_grise.html.twig', array(
            'entity'      => $entity,
             'user'      => $user,
            'form'   => $form->createView(),
            
            
        ));
    }

    
    
    
    
        
    public function show_carte_griseAction(){
        
        $em = $this->getDoctrine()->getEntityManager();
         $user = $this->container->get('security.context')->getToken()->getUser();
         
         
     $cartee = $em->getRepository('MyAppUserBundle:CarteGrise')->findBy(array('utilisateur' => $user));
     $carte = $em->getRepository('MyAppUserBundle:CarteGrise')->find($cartee[0]);
       
        return $this->render('MyAppUserBundle:CarteGrise:show_carte_grise.html.twig',array('carte'=>$carte,'user'=>$user));
 
    }
    
    
    
        
  public function edit_carte_griseAction( )
    {        $em = $this->getDoctrine()->getEntityManager();
         $user = $this->container->get('security.context')->getToken()->getUser();
         
         
     $cartee = $em->getRepository('MyAppUserBundle:CarteGrise')->findBy(array('utilisateur' => $user));
  
$entity = $em->getRepository('MyAppUserBundle:CarteGrise')->find($cartee[0]);
      
       

       
         $form = $this->createForm(new CarteGriseType(), $entity);
        if (!$entity) {
            throw $this->createNotFoundException('Unable to find Carte Grise entity.');
        }

         if ($this->get('request')->getMethod() == 'POST') {
            $form->handleRequest($this->getRequest());
        
       

        if ($form->isValid()) {
            $em->flush();

            return $this->redirect($this->generateUrl('liste_carte_grise'));
         }}

        return $this->render('MyAppUserBundle:CarteGrise:edit_carte_grise.html.twig', array(
            'entity'      => $entity,
             'user'      => $user,
            'form'   => $form->createView(),
            
        ));
    }
    
}
