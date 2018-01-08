<?php

namespace MyApp\UserBundle\Controller;

use Symfony\Component\HttpFoundation\Request;
use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use MyApp\UserBundle\Entity\CarteGrise;
use MyApp\UserBundle\Form\CarteGriseType;

/**
 * Description of AdminCGController
 *
 * @author Aya
 */
class AdminCGController extends Controller {

    public function show_carte_grise_adminAction($idCarteGrise) {

        $em = $this->getDoctrine()->getEntityManager();
        $user = $this->container->get('security.context')->getToken()->getUser();



        $carte = $em->getRepository('MyAppUserBundle:CarteGrise')->find($idCarteGrise);

        return $this->render('MyAppUserBundle:CarteGrise:show_carte_grise.html.twig', array('carte' => $carte,'user' => $user));
    }

    public function liste_carte_griseAction() {

        $em = $this->getDoctrine()->getEntityManager();



        $carte = $em->getRepository('MyAppUserBundle:CarteGrise')->findAll();
        return $this->render('MyAppUserBundle:CarteGrise:admin_liste_carte.html.twig', array('carte' => $carte));
    }

    public function supprimer_carte_griseAction($idCarteGrise) {

        $em = $this->getDoctrine()->getEntityManager();
       
        $carte1 = $em->getRepository('MyAppUserBundle:CarteGrise')->find($idCarteGrise);
        $em->remove($carte1);
        $em->flush();
        $carte = $em->getRepository('MyAppUserBundle:CarteGrise')->findAll();
        return $this->render('MyAppUserBundle:CarteGrise:admin_liste_carte.html.twig', array('carte' => $carte));
    }
       
   

    public function rechAction(Request $request) {
        $em = $this->getDoctrine()->getManager();

        if ($request->getMethod() == 'POST') {

            $idCarteGrise = $this->get('request')->request->get('idCarteGrise');


            $query = $em->createQuery("SELECT u FROM MyApp\UserBundle\Entity\CarteGrise u WHERE u.idCarteGrise LIKE '%$idCarteGrise%' ");

            $carte = $query->getResult();
        }
        return $this->render('MyAppUserBundle:CarteGrise:admin_liste_carte.html.twig', array('carte' => $carte));
    }

  

    public function valider_carteAction($idCarteGrise) {

        $em = $this->getDoctrine()->getEntityManager();

        $carte = $em->getRepository('MyAppUserBundle:CarteGrise')->findAll();

        $carte1 = $em->getRepository('MyAppUserBundle:CarteGrise')->find($idCarteGrise);

        $carte1->setValidation("validé");
        $em->flush();





        return $this->render('MyAppUserBundle:CarteGrise:admin_liste_carte.html.twig', array('carte' => $carte));
    }

}
