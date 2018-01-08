<?php

namespace MyApp\UserBundle\Controller;

use Symfony\Component\HttpFoundation\Request;
use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use MyApp\UserBundle\Entity\Passeport;
use MyApp\UserBundle\Form\PasseportType;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Description of PasseportController
 *
 * 
 */
class PasseportController extends Controller {

    public function add_passeportAction() {

        $em = $this->getDoctrine()->getManager(); //t7atharli l entity passeport
        $user = $this->container->get('security.context')->getToken()->getUser(); //user courrant  e5er user d5al l interface ajout passeport
        $entity = new Passeport();

        $form = $this->createForm(new PasseportType(), $entity); //relation entre les champs et l entité passeport
        if (!$entity) {
            throw $this->createNotFoundException('Unable to find Passeport entity.');
        }

        if ($this->get('request')->getMethod() == 'POST') {//post=true le client a remplit les champts //request=champs remplit par l user+type de request(post/get)
            $form->handleRequest($this->getRequest()); //yna9el les données fi variable form 



            if ($form->isValid()) {//isvalid=les type données entrées par le user = type des données de la bd (entite)
                $entity->setUtilisateur($user); //t3abi manuellement e5er user connecta
                $entity->setValidation("non validé");


                $em->persist($entity);
                $em->flush();


                return 1;
            }
        }

        return $this->render('MyAppUserBundle:Passeport:add_passeport.html.twig', array(
                    'entity' => $entity,
                    'user' => $user,
                    'form' => $form->createView(),
        ));
    }

    public function show_passeportAction() {

        $em = $this->getDoctrine()->getEntityManager();
        $user = $this->container->get('security.context')->getToken()->getUser();
        
        $passeport = $em->getRepository('MyAppUserBundle:Passeport')->findOneBy(array('Utilisateur' => $cit));
     //   $passeport = $em->getRepository('MyAppUserBundle:Passeport')->findBy($passeportt);
        
        
        

        return $this->render('MyAppUserBundle:Passeport:show_passeport.html.twig', array('passeport' => $passeport, 'user' => $user));
    }

    public function edit_passeport_userAction() {
        $em = $this->getDoctrine()->getEntityManager();
        $user = $this->container->get('security.context')->getToken()->getUser();


        $passeport = $em->getRepository('MyAppUserBundle:Passeport')->findBy(array('utilisateur' => $user));

        $entity = $em->getRepository('MyAppUserBundle:Passeport')->find($passeport[0]);




        $form = $this->createForm(new PasseportType(), $entity);
        if (!$entity) {
            throw $this->createNotFoundException('Unable to find Passeport entity.');
        }

        if ($this->get('request')->getMethod() == 'POST') {
            $form->handleRequest($this->getRequest());



            if ($form->isValid()) {
                $em->flush();
               
             return $this->redirect($this->generateUrl('MyAppUserBundle:Passeport:edit_passeport_user.html.twig'), array(
                            'entity' => $entity,
                            'user' => $user
                ));
            }
        }
        
        
         
//         var_dump(user)->getId();
//         var_dump(user)->getPrenom();
//         exit();

        return $this->render('MyAppUserBundle:Passeport:edit_passeport_user.html.twig', array(
                    'entity' => $entity,
                    'user' => $user,
                    'form' => $form->createView(),
        ));
    }

}
