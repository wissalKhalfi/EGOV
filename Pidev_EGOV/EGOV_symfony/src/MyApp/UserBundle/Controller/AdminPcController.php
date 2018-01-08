<?php


namespace MyApp\UserBundle\Controller;
use Swift_Mailer;
use Swift_Message;
use Swift_SmtpTransport;
use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use Symfony\Component\HttpFoundation\Request;



use MyApp\UserBundle\Entity\Permis;
use MyApp\UserBundle\Form\PermisType;





/**
 * Description of PermisPcController
 *
 * @author Aya
 */
class AdminPcController extends Controller {

    
    public function show_permisAction($numPermis){
        
        $em = $this->getDoctrine()->getEntityManager();
         $user = $this->container->get('security.context')->getToken()->getUser();
         
         
     
$permis = $em->getRepository('MyAppUserBundle:Permis')->find($numPermis);
       
        return $this->render('MyAppUserBundle:Permis:admin_show_permis.html.twig',array('permis'=>$permis));
 
    }
    
    
    
    
     public function liste_permisAction(){
        
        $em = $this->getDoctrine()->getEntityManager();
         
         
         
     $permis = $em->getRepository('MyAppUserBundle:Permis')->findAll();
return $this->render('MyAppUserBundle:Permis:liste_permis.html.twig',array('permis'=>$permis));
 



    }
    
    
    
    
    
    
        
     public function valider_permisAction($numPermis){
        
        $em = $this->getDoctrine()->getEntityManager();
         
         $permis = $em->getRepository('MyAppUserBundle:Permis')->findAll();
         
     $permis1 = $em->getRepository('MyAppUserBundle:Permis')->find($numPermis);
     $mail= $permis1->getUtilisateur()->getEmail();
      $permis1->setValidation("validé");
      $em->flush();
     $mailer =  $this->container->get('mailer');
 $transport = \Swift_SmtpTransport::newInstance('smtp.gmail.com', 465,'ssl')
        ->setUsername('linkin.mouadh@gmail.')
        ->setPassword('asefthukom');
         $mailer = Swift_Mailer::newInstance($transport);
            $message = Swift_Message::newInstance('test')
                    ->setSubject("validation permis")
                    ->setFrom('linkin.mouadh@gmail.com')
                    ->setTo('amina.mahdhaoui@gmail.com')
                    ->setBody("ayaa");
            $this->get('mailer')->send ($message) ;  
        
    
return $this->render('MyAppUserBundle:Permis:liste_permis.html.twig',array('permis'=>$permis));
 

    }

    public function supprimer_permisAction($numPermis){
        
        $em = $this->getDoctrine()->getEntityManager();
               $permis = $em->getRepository('MyAppUserBundle:Permis')->findAll();
         $permis1 = $em->getRepository('MyAppUserBundle:Permis')->find($numPermis);
        $em->remove($permis1);
        $em->flush();
      return 1;
 
    }
    
    
            public function rechAction(Request $request)
    {
        $em = $this->getDoctrine()->getManager();

        if ($request->getMethod() == 'POST') {

            $numPermis =  $this->get('request')->request->get('numPermis');

            
            $query = $em->createQuery("SELECT u FROM MyApp\UserBundle\Entity\Permis u WHERE u.numPermis LIKE '%$numPermis%' ");
            
            $permiss = $query->getResult();
          
            

        }
            return $this->render('MyAppUserBundle:Permis:liste_permis.html.twig',array('permis'=>$permiss));

    }

}

