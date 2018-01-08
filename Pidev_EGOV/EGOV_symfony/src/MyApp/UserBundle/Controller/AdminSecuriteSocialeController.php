<?php

namespace MyApp\UserBundle\Controller;

use Symfony\Component\HttpFoundation\Request;
use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use MyApp\UserBundle\Entity\User;
use MyApp\UserBundle\Entity\SecuriteSociale;
use MyApp\UserBundle\Form\SecuriteSocialeType;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Description of AdminSecuriteSocialeController
 *
 * @author boumaiza
 */
class AdminSecuriteSocialeController extends Controller {

    public function show_cartetAction($idSC) {

        $em = $this->getDoctrine()->getEntityManager();
        /* @var $user type */
        $user = $this->container->get('security.context')->getToken()->getUser();



        $securitesociale = $em->getRepository('EGOVUserBundle:SecuriteSociale')->find($idSC);

        return $this->render('EGOVUserBundle:SecuriteSociale:admin_show_carte.html.twig', array('securitesociale' => $securitesociale));
    }
    

    public function liste_carteAction() {

        $em = $this->getDoctrine()->getEntityManager();
        $securitesociale = $em->getRepository('EGOVUserBundle:SecuriteSociale')->findAll();
        return $this->render('EGOVUserBundle:SecuriteSociale:liste_carte.html.twig', array('securitesociale' => $securitesociale));
    }

    public function valider_carteAction($idSC) {

        $em = $this->getDoctrine()->getEntityManager();

        $securitesociale = $em->getRepository('EGOVUserBundle:SecuriteSociale')->findAll();

        $securitesociale1 = $em->getRepository('EGOVUserBundle:SecuriteSociale')->find($idSC);
        $securitesociale1->setValidation("validé");
        $em->flush();



        return $this->render('EGOVUserBundle:SecuriteSociale:liste_carte.html.twig', array('securitesociale' => $securitesociale));
    }

    public function supprimer_carteAction($idSC) {

        $em = $this->getDoctrine()->getEntityManager();
        $securitesociale1 = $em->getRepository('EGOVUserBundle:SecuriteSociale')->find($idSC);
        $em->remove($securitesociale1);
        $securitesociale = $em->getRepository('EGOVUserBundle:SecuriteSociale')->findAll();


        $em->flush();
        return 1;
    }

}
