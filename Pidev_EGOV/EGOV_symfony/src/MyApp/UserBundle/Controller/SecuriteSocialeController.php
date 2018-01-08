<?php

namespace MyApp\UserBundle\Controller;

use Symfony\Component\HttpFoundation\Request;
use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use EGOV\UserBundle\Entity\SecuriteSociale;
use EGOV\UserBundle\Form\SecuriteSocialeType;

class SecuriteSocialeController extends Controller {

    public function add_carteAction() {

        $em = $this->getDoctrine()->getManager(); //t7atharli l entity passeport
        $user = $this->container->get('security.context')->getToken()->getUser(); //user courrant  e5er user d5al l interface ajout passeport
        $entity = new SecuriteSociale();

        $form = $this->createForm(new SecuriteSocialeType(), $entity); //relation entre les champs et l entité passeport
        if (!$entity) {
            throw $this->createNotFoundException('Unable to find carte entity.');
        }

        if ($this->get('request')->getMethod() == 'POST') {//post=true le client a remplit les champts //request=champs remplit par l user+type de request(post/get)
            $form->handleRequest($this->getRequest()); //yna9el les données fi variable form 



            if ($form->isValid()) {//isvalid=les type données entrées par le user = type des données de la bd (entite)
                $entity->setUtilisateur($user); //t3abi manuellement e5er user connecta
                $entity->setValidation("non validé");


                $em->persist($entity);
                $em->flush();



                return 1;

//                return $this->redirect($this->generateUrl('EGOVUserBundle:SecuriteSociale:show_carte.html.twig'), array(
//                            'entity' => $entity,
//                            'user' => $user
//                ));
                //return 1;
            }
        }
        return $this->render('EGOVUserBundle:SecuriteSociale:add_carte.html.twig', array(
                    'entity' => $entity,
                    'user' => $user,
                    'form' => $form->createView()
        ));
    }

    public function show_carteAction() {

        $em = $this->getDoctrine()->getEntityManager();
        $user = $this->container->get('security.context')->getToken()->getUser();


        $securite = $em->getRepository('EGOVUserBundle:SecuriteSociale')->findOneBy(array('utilisateur' => $user));
      // var_dump($securite);
        //exit();
        
      //  $securitesociale = $em->getRepository('EGOVUserBundle:SecuriteSociale')->findBy($securite[0]);




        return $this->render('EGOVUserBundle:SecuriteSociale:show_carte.html.twig', array('securitesociale' => $securite));
    }
    
    public function edit_carte_userAction() {
        
        
        
        $em = $this->getDoctrine()->getEntityManager();
        $user = $this->container->get('security.context')->getToken()->getUser();

        var_dump($user);
        exit();



        $entity = $em->getRepository('EGOVUserBundle:SecuriteSociale')->findOneBy(array('utilisateur' => $user));


        //$entity = $em->getRepository('EGOVUserBundle:SecuriteSociale')->find($carte[0]);


        $form = $this->createForm(new SecuriteSocialeType(), $entity);
        if (!$entity) {
            throw $this->createNotFoundException('Unable to find Carte Sécurité sociale entity.');
        }

        if ($this->get('request')->getMethod() == 'POST') {
            $form->handleRequest($this->getRequest());

            if ($form->isValid()) {
                $em->flush();
               
             return $this->redirect($this->generateUrl('EGOVUserBundle:SecuriteSociale:show_carte.html.twig'), array(
                            'entity' => $entity,
                            'user' => $user
                ));
            }
        }
        
        
         


        return $this->render('EGOVUserBundle:SecuriteSociale:edit_carte_user.html.twig', array(
                    'entity' => $entity,
                    'user' => $user,
                    'form' => $form->createView(),
        ));
    }

}
