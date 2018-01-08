<?php

namespace MyApp\UserBundle\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\Controller;

class DefaultController extends Controller
{
    public function indexAction()
    {
//        return $this->render('MyAppUserBundle:Default:index.html.twig', array('name' => $name));
    return $this->render('MyAppUserBundle:index.html.twig');
        
    }
}
