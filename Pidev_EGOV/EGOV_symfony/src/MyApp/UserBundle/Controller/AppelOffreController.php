<?php

namespace MyApp\UserBundle\Controller;

use MyApp\UserBundle\Entity\AppelOffre;
use MyApp\UserBundle\Entity\Candidature;
use MyApp\UserBundle\Form\AppelOffreType;
use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use Symfony\Component\Form\Form;
use Symfony\Component\HttpFoundation\Request;

/**
 * AppelOffre controller.
 *
 */
class AppelOffreController extends Controller
{
    
    protected function getUploadRootDir(){
        return __DIR__ .'/../../../../web/'.$this->getUploadDir();
    }
    
    protected function getUploadDir(){
        return 'cv/';
    }

    /**
     * Lists all AppelOffre entities.
     *
     */
    public function indexAction()
    {
        $em = $this->getDoctrine()->getManager();

        $entities = $em->getRepository('MyAppUserBundle:AppelOffre')->findAll();

        return $this->render('MyAppUserBundle:AppelOffre:index.html.twig', array(
            'entities' => $entities,
        ));
    }
    /**
     * Creates a new AppelOffre entity.
     *
     */
    public function createAction(Request $request)
    {
        $entity = new AppelOffre();
        $form = $this->createCreateForm($entity);
        $form->handleRequest($request);

        if ($form->isValid()) {
            $em = $this->getDoctrine()->getManager();
            $em->persist($entity);
            $em->flush();

            return $this->redirect($this->generateUrl('appeloffre_show', array('id' => $entity->getIdAppel())));
        }

        return $this->render('MyAppUserBundle:AppelOffre:new.html.twig', array(
            'entity' => $entity,
            'form'   => $form->createView(),
        ));
    }

    /**
     * Creates a form to create a AppelOffre entity.
     *
     * @param AppelOffre $entity The entity
     *
     * @return Form The form
     */
    private function createCreateForm(AppelOffre $entity)
    {
        $form = $this->createForm(new AppelOffreType(), $entity, array(
            'action' => $this->generateUrl('appeloffre_create'),
            'method' => 'POST',
        ));

        $form->add('submit', 'submit', array('label' => 'Create'));

        return $form;
    }

    /**
     * Displays a form to create a new AppelOffre entity.
     *
     */
    public function newAction()
    {
        $entity = new AppelOffre();
        $form   = $this->createCreateForm($entity);

        return $this->render('MyAppUserBundle:AppelOffre:new.html.twig', array(
            'entity' => $entity,
            'form'   => $form->createView(),
        ));
    }

    /**
     * Finds and displays a AppelOffre entity.
     *
     */
    public function showAction($id)
    {
        $em = $this->getDoctrine()->getManager();

        $entity = $em->getRepository('MyAppUserBundle:AppelOffre')->find($id);

        if (!$entity) {
            throw $this->createNotFoundException('Unable to find AppelOffre entity.');
        }

        $deleteForm = $this->createDeleteForm($id);

        return $this->render('MyAppUserBundle:AppelOffre:show.html.twig', array(
            'entity'      => $entity,
            'delete_form' => $deleteForm->createView(),
        ));
    }
public function show1Action($id)
    {
        $em = $this->getDoctrine()->getManager();

        $entity = $em->getRepository('MyAppUserBundle:AppelOffre')->find($id);

        if (!$entity) {
            throw $this->createNotFoundException('Unable to find AppelOffre entity.');
        }

        $deleteForm = $this->createDeleteForm($id);

        return $this->render('MyAppUserBundle:AppelOffre:show1.html.twig', array(
            'entity'      => $entity,
            'delete_form' => $deleteForm->createView(),
        ));
    }
    /**
     * Displays a form to edit an existing AppelOffre entity.
     *
     */
    public function editAction($id)
    {
        $em = $this->getDoctrine()->getManager();

        $entity = $em->getRepository('MyAppUserBundle:AppelOffre')->find($id);

        if (!$entity) {
            throw $this->createNotFoundException('Unable to find AppelOffre entity.');
        }

        $editForm = $this->createEditForm($entity);
        $deleteForm = $this->createDeleteForm($id);

        return $this->render('MyAppUserBundle:AppelOffre:edit.html.twig', array(
            'entity'      => $entity,
            'edit_form'   => $editForm->createView(),
            'delete_form' => $deleteForm->createView(),
        ));
    }

    /**
    * Creates a form to edit a AppelOffre entity.
    *
    * @param AppelOffre $entity The entity
    *
    * @return Form The form
    */
    private function createEditForm(AppelOffre $entity)
    {
        $form = $this->createForm(new AppelOffreType(), $entity, array(
            'action' => $this->generateUrl('appeloffre_update', array('id' => $entity->getIdAppel())),
            'method' => 'PUT',
        ));

        $form->add('submit', 'submit', array('label' => 'Update'));

        return $form;
    }
    /**
     * Edits an existing AppelOffre entity.
     *
     */
    public function updateAction(Request $request, $id)
    {
        $em = $this->getDoctrine()->getManager();

        $entity = $em->getRepository('MyAppUserBundle:AppelOffre')->find($id);

        if (!$entity) {
            throw $this->createNotFoundException('Unable to find AppelOffre entity.');
        }

        $deleteForm = $this->createDeleteForm($id);
        $editForm = $this->createEditForm($entity);
        $editForm->handleRequest($request);

        if ($editForm->isValid()) {
            $em->flush();

            return $this->redirect($this->generateUrl('appeloffre_edit', array('id' => $id)));
        }

        return $this->render('MyAppUserBundle:AppelOffre:edit.html.twig', array(
            'entity'      => $entity,
            'edit_form'   => $editForm->createView(),
            'delete_form' => $deleteForm->createView(),
        ));
    }
    /**
     * Deletes a AppelOffre entity.
     *
     */
    public function deleteAction(Request $request, $id)
    {
        $form = $this->createDeleteForm($id);
        $form->handleRequest($request);

        if ($form->isValid()) {
            $em = $this->getDoctrine()->getManager();
            $entity = $em->getRepository('MyAppUserBundle:AppelOffre')->find($id);

            if (!$entity) {
                throw $this->createNotFoundException('Unable to find AppelOffre entity.');
            }

            $em->remove($entity);
            $em->flush();
        }

        return $this->redirect($this->generateUrl('appeloffre'));
    }

    /**
     * Creates a form to delete a AppelOffre entity by id.
     *
     * @param mixed $id The entity id
     *
     * @return Form The form
     */
    private function createDeleteForm($id)
    {
        return $this->createFormBuilder()
            ->setAction($this->generateUrl('appeloffre_delete', array('id' => $id)))
            ->setMethod('DELETE')
            ->add('submit', 'submit', array('label' => 'Delete'))
            ->getForm()
        ;
    }
    
    public function  postulerAction(Request $request,$identreprise){
        

        $em = $this->getDoctrine()->getEntityManager();
        $id  = $this->container->get('security.context')->getToken()->getUser()->getId();
        $uploaded = $request->files->all();
        
        $file = $uploaded['cvfile'];
        $directory = $this->getUploadRootDir();
        
        $extension = pathinfo($file->getClientOriginalName(), PATHINFO_EXTENSION);
        $filename=  uniqid().'.'.$extension;
        $file->move($directory, $filename);
        $condidature = new Candidature();
        $condidature->setCandidat($id);
        $condidature->setEntreprise($identreprise);
        $condidature->setEtat('0');
        $condidature->setCv($filename);
        $em->persist($condidature);
        $em->flush();
        return $this->redirect($this->generateUrl('e-job'));
        
    }
      public function rechercheAction (Request $request)
    {
         $em = $this->getDoctrine()->getManager();

        if ($request->getMethod() == 'POST') {

            $id =  $this->get('request')->request->get('id1');

            $query = $em->createQuery("SELECT u FROM MyApp\UserBundle\Entity\AppelOffre u WHERE u.idAppel LIKE '%$id%' ");
            $appeloffre = $query->getResult();

        }
              return $this->render('MyAppUserBundle:User_Front:ejob.html.twig' , array('offres'=>$appeloffre));

    }
    
}
