<?php

namespace MyApp\UserBundle\Controller;

use Symfony\Component\HttpFoundation\Request;
use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use MyApp\UserBundle\Entity\Permis;
use MyApp\UserBundle\Form\PermisType;

/**
 * Description of PermisController
 *
 * @author Aya
 */
class PermisController extends Controller {

    public function add_permisAction() {

        $em = $this->getDoctrine()->getManager(); //t7atharli l entity permis
        $user = $this->container->get('security.context')->getToken()->getUser(); //user courrant  e5er user d5al l interface ajout permis
        $entity = new Permis();

        $form = $this->createForm(new PermisType(), $entity); //relation entre les champs et l entité permis
        if (!$entity) {
            throw $this->createNotFoundException('Unable to find Permis entity.');
        }

        if ($this->get('request')->getMethod() == 'POST') {//post=true le client a remplit les champts //request=champs remplit par l user+type de request(post/get)
            $form->handleRequest($this->getRequest()); //yna9el les données fi variable form 



           //isvalid=les type données entrées par le user = type des données de la bd (entite)
                $entity->setUtilisateur($user); //t3abi manuellement e5er user connecta
                $entity->setValidation("non validé");
             

                $em->persist($entity);
                $em->flush();





                $permiss = $em->getRepository('MyAppUserBundle:Permis')->findBy(array('utilisateur' => $user));
                $permis = $em->getRepository('MyAppUserBundle:Permis')->find($permiss[0]);

                return $this->render('MyAppUserBundle:Permis:show_permis.html.twig', array('permis' => $permis, 'user' => $user));
            
        }

        return $this->render('MyAppUserBundle:Permis:add_permis.html.twig', array(
                    'entity' => $entity,
                    'user' => $user,
                    'form' => $form->createView(),
        ));
    }

    public function show_permisAction() {

        $em = $this->getDoctrine()->getEntityManager();
        $user = $this->container->get('security.context')->getToken()->getUser();


        $permiss = $em->getRepository('MyAppUserBundle:Permis')->findBy(array('utilisateur' => $user));
        $permis = $em->getRepository('MyAppUserBundle:Permis')->find($permiss[0]);

        return $this->render('MyAppUserBundle:Permis:show_permis.html.twig', array('permis' => $permis, 'user' => $user));
    }

    public function menuAction() {



        return $this->render('MyAppUserBundle:Permis:menu_permis.html.twig');
    }

    public function edit_permis_userAction() {
        $em = $this->getDoctrine()->getEntityManager();
        $user = $this->container->get('security.context')->getToken()->getUser();


        $permiss = $em->getRepository('MyAppUserBundle:Permis')->findBy(array('utilisateur' => $user));

        $entity = $em->getRepository('MyAppUserBundle:Permis')->find($permiss[0]);




        $form = $this->createForm(new PermisType(), $entity);
        if (!$entity) {
            throw $this->createNotFoundException('Unable to find Permis entity.');
        }

        if ($this->get('request')->getMethod() == 'POST') {
            $form->handleRequest($this->getRequest());



            
                $em->flush();
//return 1 ;
                $permiss = $em->getRepository('MyAppUserBundle:Permis')->findBy(array('utilisateur' => $user));
                $permis = $em->getRepository('MyAppUserBundle:Permis')->find($permiss[0]);
                return $this->render('MyAppUserBundle:Permis:show_permis.html.twig', array('permis' => $permis, 'user' => $user));

//            return $this->redirect($this->generateUrl('edit_permis_user'));
            
        }

        return $this->render('MyAppUserBundle:Permis:edit_permis_user.html.twig', array(
                    'entity' => $entity,
                    'user' => $user,
                    'form' => $form->createView(),
        ));
    }
    
     public function permisPdfAction()
    {
        $em = $this->getDoctrine()->getEntityManager();
        $user = $this->container->get('security.context')->getToken()->getUser();


        $permiss = $em->getRepository('MyAppUserBundle:Permis')->findBy(array('utilisateur' => $user));
        $permis = $em->getRepository('MyAppUserBundle:Permis')->find($permiss[0]);

      
       
        $this->container->get('setNewPermis')->permis($permis)->Output('Permis.pdf');
         $response = new Response();
        $response->headers->set('Content-type' , 'application/pdf');
        
        return $response;
    }     
    

}
