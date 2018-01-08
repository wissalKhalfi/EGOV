<?php

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

namespace MyApp\UserBundle\Controller;

use Swift_Mailer;
use Swift_Message;
use Swift_SmtpTransport;
use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use Symfony\Component\HttpFoundation\Request;

/**
 * Description of UserController
 *
 * @author mouad
 */
class UserController extends Controller {

    //put your code here
    public function indexAction() {

        return $this->render('MyAppUserBundle:User_Front:index.html.twig');
    }

    public function serviceAction() {


        return $this->render('MyAppUserBundle:User_Front:service.html.twig');
    }

    public function abouttnAction() {


        return $this->render('MyAppUserBundle:User_Front:abouttn.html.twig');
    }

    public function contactAction(Request $request) {

        $Request = $this->getRequest();
if ($Request->getMethod()== "POST"){
 $name = $Request->get('txtName') ; 
 $email = $Request->get('txtEmail') ; 
 $message = $Request->get('txtText') ; 
 
 $mailer =  $this->container->get('mailer');
 $transport = \Swift_SmtpTransport::newInstance('smtp.gmail.com', 465,'ssl')
        ->setUsername('linkin.mouadh@gmail.com')
        ->setPassword('asefthukom');
         $mailer = Swift_Mailer::newInstance($transport);
            $message = Swift_Message::newInstance('test')
                    ->setSubject($name)
                    ->setFrom('linkin.mouadh@gmail.com')
                    ->setTo($email)
                    ->setBody($message);
            $this->get('mailer')->send ($message) ;  
}

        return $this->render('MyAppUserBundle:User_Front:contact.html.twig');
    }

    public function newsAction() {



        return $this->render('MyAppUserBundle:User_Front:news.html.twig');
    }

    public function ecitoyenniteAction() {


        return $this->render('MyAppUserBundle:User_Front:ecitoyennite.html.twig');
    }

    public function ecitoyenniteplusAction() {


        return $this->render('MyAppUserBundle:User_Front:ecitoyenniteplus.html.twig');
    }

    public function erouteAction() {


        return $this->render('MyAppUserBundle:User_Front:eroute.html.twig');
    }

    public function estudentAction() {


      return $this->render('MyAppUserBundle:User_Front:epaiement.html.twig');
    }

    public function ejobAction() {

        $em = $this->getDoctrine()->getEntityManager();
        $offre = $em->getRepository('MyAppUserBundle:AppelOffre')->findAll();

        return $this->render('MyAppUserBundle:User_Front:ejob.html.twig', array('offres' => $offre));
    }
public function indexmailAction() 
        { 
    return $this->render('MyAppUserBundle:User_Front:mail.html.twig', array()); 
    
        }
public function sendMailAction(Request $request) 
        { 
    $to = "mouadh.riahi@esprit.tn"; 
    $mail = new \MyApp\UserBundle\Entity\Mail();
    $form= $this->createForm(new \MyApp\UserBundle\Form\MailType(), $mail); 
    $request->get('request'); $form->handleRequest($request) ; 
    if ($form->isValid()) 
        { 
        $message = Swift_Message::newInstance('smtp.gmail.com', 465, 'ssl') 
                ->setSubject($mail->getNom()) 
                ->setFrom($mail-> getFrom()) 
                ->setTo($to) 
                ->setBody($mail->getText()); 
        $this->get('mailer')->send($message); 
        return $this->render('MyAppUserBundle:User_Front:mail.html.twig', array('to' => $to, 'from' => $mail-> getFrom() )); 
        
        } return $this->redirect($this->generateUrl('my_app_mail_form'));
        
         
        
        }
        public function newAction(Request $requestt) {
            $mail = new \MyApp\UserBundle\Entity\Mail(); 
            $form= $this-> createForm(new \MyApp\UserBundle\Form\MailType(), $mail); 
                    $form->handleRequest($requestt) ; 
                    if ($form->isValid()) 
                        { 
                        $this->sendMailAction('mouadh.riahi@esprit.tn', 
                                $mail-> getFrom(), 
                                $mail->getNom(), 
                                $mail->getText()); 
                  
                        } 
                        return $this->render('MyAppUserBundle:User_Front:new.html.twig', array('form' => $form->createView())) ; }
        
        }

