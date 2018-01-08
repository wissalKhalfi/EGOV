<?php

namespace MyApp\UserBundle\Controller;

use Symfony\Component\HttpFoundation\Request;
use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use MyApp\UserBundle\Entity\Articles;
use MyApp\UserBundle\Entity\Diplome;
use MyApp\UserBundle\Form\ArticlesType;
use Symfony\Component\HttpFoundation\StreamedResponse;

/**
 * Articles controller.
 *
 */
class ArticlesController extends Controller {

    /**
     * Lists all Articles entities.
     *
     */
 
       
//   public function affichageadminAction()
//    {      $em = $this->getDoctrine()->getManager();
//
//        $articles = $em->getRepository('MyAppUserBundle:Articles')->findAll();
//
//        return $this->render('MyAppUserBundle:Articles:AfficherArticle.html.twig', array(
//                    'articles' => $articles,
//        ));
//    }

       public function affichageadminAction()
 
    {       $em=$this->getDoctrine()->getManager();
            $requet=  $this->get('request');   
            $articles=$em->getRepository('MyAppUserBundle:Articles')->findAll();
            if($requet->isMethod('POST'))
            { $type=$requet->get('typearticle');
            $articles=$em->getRepository('MyAppUserBundle:Articles')->findBytype($type); 
            
            }         
            return $this->render('MyAppUserBundle:Adiministrateur:AfficherArticle.html.twig', array(
                'articles' => $articles,
    ));}
    public function detailarticleAction($id) {

        $em = $this->getDoctrine()->getManager();

        $entity = $em->getRepository('MyAppUserBundle:Articles')->find($id);

          return $this->render('MyAppUserBundle:Articles:Afficher_detaticle.html.twig', array(
            'entity'      => $entity,
  
        ));
    }
  
    public function showarticleposteAction() {
        $em = $this->getDoctrine()->getManager();
        $results = $em->getRepository('MyAppUserBundle:Articles')->createQueryBuilder('a')
                ->where('a.type = :type')
                ->setParameter('type', 'post')
                ->getQuery()
                ->getResult();
        return $this->render('MyAppUserBundle:Articles:Articlesposte.html.twig', array(
                    'results' => $results,));
    }

    public function showarticletunisieAction() {
        $em = $this->getDoctrine()->getManager();
        $results = $em->getRepository('MyAppUserBundle:Articles')->createQueryBuilder('a')
                ->where('a.type = :type')
                ->setParameter('type', 'tunisie')
                ->getQuery()
                ->getResult();
        return $this->render('MyAppUserBundle:Articles:ArticlesTunisie.html.twig', array(
                    'results' => $results,));
    }

    public function showarticleinterieurAction() {
        $em = $this->getDoctrine()->getManager();
        $results = $em->getRepository('MyAppUserBundle:Articles')->createQueryBuilder('a')
                ->where('a.type = :type')
                ->setParameter('type', 'interieur')
                ->getQuery()
                ->getResult();
        return $this->render('MyAppUserBundle:Articles:Articlesinterieur.html.twig', array(
                    'results' => $results,));
    }

    public function showarticleindustrieAction() {
        $em = $this->getDoctrine()->getManager();
        $results = $em->getRepository('MyAppUserBundle:Articles')->createQueryBuilder('a')
                ->where('a.type = :type')
                ->setParameter('type', 'industrie')
                ->getQuery()
                ->getResult();
        return $this->render('MyAppUserBundle:Articles:Articlesindustrie.html.twig', array(
                    'results' => $results,));
    }

    public function showarticlegouvernementAction() {
        $em = $this->getDoctrine()->getManager();
        $results = $em->getRepository('MyAppUserBundle:Articles')->createQueryBuilder('a')
                ->where('a.type = :type')
                ->setParameter('type', 'gouvernement')
                ->getQuery()
                ->getResult();
        return $this->render('MyAppUserBundle:Articles:Articlesgov.html.twig', array(
                    'results' => $results,));
    }

    public function showarticlejournauxAction() {
        $em = $this->getDoctrine()->getManager();
        $results = $em->getRepository('MyAppUserBundle:Articles')->createQueryBuilder('a')
                ->where('a.type = :type')
                ->setParameter('type', 'journaux')
                ->getQuery()
                ->getResult();
        return $this->render('MyAppUserBundle:Articles:Articlesjournaux.html.twig', array(
                    'results' => $results,));
    }

 
 
    private function AjoutForm(Articles $article) {
        $form = $this->createForm(new ArticlesType(), $article, array(
            'action' => $this->generateUrl('articles_nouveau'),
            'method' => 'POST',
        ));

        $form->add('submit', 'submit', array('label' => 'Ajout'));

        return $form;
    }

    public function nouveauAction(Request $request) {
        $entity = new Articles();
       $form = $this->AjoutForm($entity);
        $form->handleRequest($request);

        if ($form->isValid()) {
            $stream = fopen($entity->getFile(), 'rb');
            $entity->setImageArticle(stream_get_contents($stream));
            $em = $this->getDoctrine()->getManager();
            
            $em->persist($entity);
            $em->flush();

        }
        return $this->render('MyAppUserBundle:Adiministrateur:AjouterArticle.html.twig', array(
                    'entity' => $entity,
                    'form' => $form->createView(),
        ));
    }
      public function photoAction($id) {
        $em = $this->getDoctrine()->getManager();
        $image_obj = $em->getRepository('MyAppUserBundle:Articles')->find($id);
        $photo = $image_obj->getImageArticle();

        $response = new StreamedResponse(function () use ($photo) {
            echo stream_get_contents($photo);
        });
        $response->headers->set('Content-Type', 'image/png');
        return $response;
    }


    /**
     * Finds and displays a Articles entity.
     *
     */
    public function showAction($id) {
        $em = $this->getDoctrine()->getManager();

        $entity = $em->getRepository('MyAppUserBundle:Articles')->find($id);

        if (!$entity) {
            throw $this->createNotFoundException('Unable to find Articles entity.');
        }

        $deleteForm = $this->createDeleteForm($id);

        return $this->render('MyAppUserBundle:Articles:show.html.twig', array(
                    'entity' => $entity,
                    'delete_form' => $deleteForm->createView(),
        ));
    }

    /**
     * Displays a form to edit an existing Articles entity.
     *
     */
    public function ModifierArticleAction($id) {
        $em = $this->getDoctrine()->getManager();

        $entity = $em->getRepository('MyAppUserBundle:Articles')->find($id);

        if (!$entity) {
            throw $this->createNotFoundException('article nn existant.');
        }

        $editForm = $this->createEditForm($entity);
        $deleteForm = $this->createDeleteForm($id);

        return $this->render('MyAppUserBundle:Adiministrateur:ModifierArticle.html.twig', array(
                    'entity' => $entity,
                    'edit_form' => $editForm->createView(),
                    'delete_form' => $deleteForm->createView(),
        ));
    }
    
    
     public function ajoutdiplomeAction()
{ $requete=  $this->get('request');
  $texte=$requete->get('texte');
  $nome=$requete->get('nome');
if($texte!="" && $nome!="")
{        $Diplome=new Diplome();
        $Diplome->setText($texte);
        $Diplome->setNome($nome);
        $em=$this->getDoctrine()->getManager();
        $em->persist($Diplome);
        $em->flush();
            return $this->redirect($this->generateUrl('diplome_affiche'));
        }
return $this->render('MyAppUserBundle:Diplome:ajout.html.twig');}
        
 public function afficherdiplomeAction(){
         $em= $this->getDoctrine()->getManager();
         $diplomes=$em->getRepository('MyAppUserBundle:Diplome')->findAll();
         return $this->render('MyAppUserBundle:Diplome:afficher.html.twig',array('diplomes'=>$diplomes));
    }
 public function modifierdiplomeAction($id){
        $em=$this->getDoctrine()->getManager();
        $diplome = $em->getRepository("MyAppUserBundle:Diplome")->findOneById($id);
        $form=  $this->createForm(new DiplomeForm(),$diplome);
        $requet=  $this->get('request');
        if($requet->isMethod('POST'))
        {
            $form->bind($requet);
            if($form->isValid())
            {
                $em->persist($diplome);
                $em->flush();
                return $this->redirectToRoute("diplome_affiche");
                }
        }
        return $this->render('MyAppUserBundle:Diplome:modifier.html.twig',array('form'=>$form->createView(),'diplome'=>$diplome));
    } 
    /**
     * Creates a form to edit a Articles entity.
     *
     * @param Articles $entity The entity
     *
     * @return \Symfony\Component\Form\Form The form
     */
    private function createEditForm(Articles $entity) {
        $form = $this->createForm(new ArticlesType(), $entity, array(
            'action' => $this->generateUrl('articles_update', array('id' => $entity->getIdArticle())),
            'method' => 'PUT',
        ));

        $form->add('submit', 'submit', array('label' => 'Update'));

        return $form;
    }

    /**
     * Edits an existing Articles entity.
     *
     */
    public function updateAction(Request $request, $id) {
        $em = $this->getDoctrine()->getManager();

        $entity = $em->getRepository('MyAppUserBundle:Articles')->find($id);

        if (!$entity) {
            throw $this->createNotFoundException('Unable to find Articles entity.');
        }

        $deleteForm = $this->createDeleteForm($id);
        $editForm = $this->createEditForm($entity);
        $editForm->handleRequest($request);

        if ($editForm->isValid()) {
            $em->flush();

            return $this->redirect($this->generateUrl('articles_edit', array('id' => $id)));
        }

        return $this->render('MyAppUserBundle:Articles:edit.html.twig', array(
                    'entity' => $entity,
                    'edit_form' => $editForm->createView(),
                    'delete_form' => $deleteForm->createView(),
        ));
    }

    /**
     * Deletes a Articles entity.
     *
     */
    public function deleteAction(Request $request, $id) {
        $form = $this->createDeleteForm($id);
        $form->handleRequest($request);

        if ($form->isValid()) {
            $em = $this->getDoctrine()->getManager();
            $entity = $em->getRepository('MyAppUserBundle:Articles')->find($id);

            if (!$entity) {
                throw $this->createNotFoundException('Unable to find Articles entity.');
            }

            $em->remove($entity);
            $em->flush();
        }

        return $this->redirect($this->generateUrl('articles_showalladmin'));
    }

    /**
     * Creates a form to delete a Articles entity by id.
     *
     * @param mixed $id The entity id
     *
     * @return \Symfony\Component\Form\Form The form
     */
    private function createDeleteForm($id) {
        return $this->createFormBuilder()
                        ->setAction($this->generateUrl('articles_delete', array('id' => $id)))
                        ->setMethod('DELETE')
                        ->add('submit', 'submit', array('label' => 'Delete'))
                        ->getForm()
        ;
    }
   
}
