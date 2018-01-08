<?php

namespace MyApp\UserBundle\Controller;

use Symfony\Component\HttpFoundation\Request;
use Symfony\Bundle\FrameworkBundle\Controller\Controller;

use MyApp\UserBundle\Entity\Candidature;
use MyApp\UserBundle\Form\CandidatureType;

/**
 * Candidature controller.
 *
 */
class CandidatureController extends Controller
{

    /**
     * Lists all Candidature entities.
     *
     */
    public function indexAction()
    {
        $em = $this->getDoctrine()->getManager();

        $entities = $em->getRepository('MyAppUserBundle:Candidature')->findAll();

        return $this->render('MyAppUserBundle:Candidature:index.html.twig', array(
            'entities' => $entities,
        ));
    }
    /**
     * Creates a new Candidature entity.
     *
     */
    public function createAction(Request $request)
    {
        $entity = new Candidature();
        $form = $this->createCreateForm($entity);
        $form->handleRequest($request);

        if ($form->isValid()) {
            $em = $this->getDoctrine()->getManager();
            $em->persist($entity);
            $em->flush();

            return $this->redirect($this->generateUrl('candidature_show', array('id' => $entity->getId())));
        }

        return $this->render('MyAppUserBundle:Candidature:new.html.twig', array(
            'entity' => $entity,
            'form'   => $form->createView(),
        ));
    }

    /**
     * Creates a form to create a Candidature entity.
     *
     * @param Candidature $entity The entity
     *
     * @return \Symfony\Component\Form\Form The form
     */
    private function createCreateForm(Candidature $entity)
    {
        $form = $this->createForm(new CandidatureType(), $entity, array(
            'action' => $this->generateUrl('candidature_create'),
            'method' => 'POST',
        ));

        $form->add('submit', 'submit', array('label' => 'Create'));

        return $form;
    }

    /**
     * Displays a form to create a new Candidature entity.
     *
     */
    public function newAction()
    {
        $entity = new Candidature();
        $form   = $this->createCreateForm($entity);

        return $this->render('MyAppUserBundle:Candidature:new.html.twig', array(
            'entity' => $entity,
            'form'   => $form->createView(),
        ));
    }

    /**
     * Finds and displays a Candidature entity.
     *
     */
    public function showAction($id)
    {
        $em = $this->getDoctrine()->getManager();

        $entity = $em->getRepository('MyAppUserBundle:Candidature')->find($id);

        if (!$entity) {
            throw $this->createNotFoundException('Unable to find Candidature entity.');
        }

        $deleteForm = $this->createDeleteForm($id);

        return $this->render('MyAppUserBundle:Candidature:show.html.twig', array(
            'entity'      => $entity,
            'delete_form' => $deleteForm->createView(),
        ));
    }

    /**
     * Displays a form to edit an existing Candidature entity.
     *
     */
    public function editAction($id)
    {
        $em = $this->getDoctrine()->getManager();

        $entity = $em->getRepository('MyAppUserBundle:Candidature')->find($id);

        if (!$entity) {
            throw $this->createNotFoundException('Unable to find Candidature entity.');
        }

        $editForm = $this->createEditForm($entity);
        $deleteForm = $this->createDeleteForm($id);

        return $this->render('MyAppUserBundle:Candidature:edit.html.twig', array(
            'entity'      => $entity,
            'edit_form'   => $editForm->createView(),
            'delete_form' => $deleteForm->createView(),
        ));
    }

    /**
    * Creates a form to edit a Candidature entity.
    *
    * @param Candidature $entity The entity
    *
    * @return \Symfony\Component\Form\Form The form
    */
    private function createEditForm(Candidature $entity)
    {
        $form = $this->createForm(new CandidatureType(), $entity, array(
            'action' => $this->generateUrl('candidature_update', array('id' => $entity->getId())),
            'method' => 'PUT',
        ));

        $form->add('submit', 'submit', array('label' => 'Update'));

        return $form;
    }
    /**
     * Edits an existing Candidature entity.
     *
     */
    public function updateAction(Request $request, $id)
    {
        $em = $this->getDoctrine()->getManager();

        $entity = $em->getRepository('MyAppUserBundle:Candidature')->find($id);

        if (!$entity) {
            throw $this->createNotFoundException('Unable to find Candidature entity.');
        }

        $deleteForm = $this->createDeleteForm($id);
        $editForm = $this->createEditForm($entity);
        $editForm->handleRequest($request);

        if ($editForm->isValid()) {
            $em->flush();

            return $this->redirect($this->generateUrl('candidature_edit', array('id' => $id)));
        }

        return $this->render('MyAppUserBundle:Candidature:edit.html.twig', array(
            'entity'      => $entity,
            'edit_form'   => $editForm->createView(),
            'delete_form' => $deleteForm->createView(),
        ));
    }
    /**
     * Deletes a Candidature entity.
     *
     */
    public function deleteAction(Request $request, $id)
    {
        $form = $this->createDeleteForm($id);
        $form->handleRequest($request);

        if ($form->isValid()) {
            $em = $this->getDoctrine()->getManager();
            $entity = $em->getRepository('MyAppUserBundle:Candidature')->find($id);

            if (!$entity) {
                throw $this->createNotFoundException('Unable to find Candidature entity.');
            }

            $em->remove($entity);
            $em->flush();
        }

        return $this->redirect($this->generateUrl('candidature'));
    }

    /**
     * Creates a form to delete a Candidature entity by id.
     *
     * @param mixed $id The entity id
     *
     * @return \Symfony\Component\Form\Form The form
     */
    private function createDeleteForm($id)
    {
        return $this->createFormBuilder()
            ->setAction($this->generateUrl('candidature_delete', array('id' => $id)))
            ->setMethod('DELETE')
            ->add('submit', 'submit', array('label' => 'Delete'))
            ->getForm()
        ;
    }
    
    
    public function accepterAction(Candidature $candidature){
          $em = $this->getDoctrine()->getManager();
            $candidature->setEtat('1');
            $em->persist($candidature);
            $em->flush();
              return $this->redirect($this->generateUrl('entreprise_ejob'));
    }
    
    
     public function refuserAction(Candidature $candidature){
          $em = $this->getDoctrine()->getManager();
            $candidature->setEtat('0');
            $em->persist($candidature);
            $em->flush();
              return $this->redirect($this->generateUrl('entreprise_ejob'));
    }
    public function rechercheAction (Request $request)
    {
         $em = $this->getDoctrine()->getManager();

        if ($request->getMethod() == 'POST') {

            $id =  $this->get('request')->request->get('id1');

            $query = $em->createQuery("SELECT u FROM MyApp\UserBundle\Entity\Candidature u WHERE u.idCandidature LIKE '%$id%' ");
            $candidature = $query->getResult();

        }
              return $this->render('MyAppUserBundle:Entreprises_Front:ejob.html.twig' , array('candidatures'=>$candidature));

    }
    
   
}
