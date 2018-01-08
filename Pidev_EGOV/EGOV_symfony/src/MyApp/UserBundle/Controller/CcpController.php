<?php

namespace MyApp\UserBundle\Controller;

use Symfony\Component\HttpFoundation\Request;
use Symfony\Bundle\FrameworkBundle\Controller\Controller;

use MyApp\UserBundle\Entity\Ccp;
use MyApp\UserBundle\Form\CcpType;

/**
 * Ccp controller.
 *
 */
class CcpController extends Controller
{
   
    public function formccpAction() {

        $requete = $this->get('request');
        $reponse1 = $requete->get('reponseq1');
        $reponse2 = $requete->get('reponseq2');
        $reponse3 = $requete->get('reponseq3');
        if ($reponse1 != "" && $reponse2 != "" && $reponse3 != "") {
            $Ccp = new Ccp();
            $Ccp->setreponseq1($reponse1);
            $Ccp->setreponseq2($reponse2);
            $Ccp->setreponseq3($reponse3);
            $Ccp->setValidatorCreation(0);
            $em = $this->getDoctrine()->getManager();
            $em->persist($Ccp);
            $em->flush();
            return $this->redirect($this->generateUrl('carteedinar_succes'));
        }
        return $this->render('MyAppUserBundle:Ccp:formccp.html.twig');
    }
   public function acceuilAction(){
        
        
      return $this->render('MyAppUserBundle:Ccp:Userfontccp.html.twig');
 
    }
      public function authccpAction(){
        
        
      return $this->render('MyAppUserBundle:Ccp:authccp.html.twig');
 
    }
//       public function formccpAction(){
//        
//        
//      return $this->render('MyAppUserBundle:Ccp:formccp.html.twig');
// 
//    }
       public function infoccpAction(){
        
        
      return $this->render('MyAppUserBundle:Ccp:infoccp.html.twig');
 
    }
    public function indexAction()
    {
        $em = $this->getDoctrine()->getManager();

        $entities = $em->getRepository('MyAppUserBundle:Ccp')->findAll();

        return $this->render('MyAppUserBundle:Ccp:index.html.twig', array(
            'entities' => $entities,
        ));
    }
    /**
     * Creates a new Ccp entity.
     *
     */
    public function createAction(Request $request)
    {
        $entity = new Ccp();
        $form = $this->createCreateForm($entity);
        $form->handleRequest($request);

        if ($form->isValid()) {
            $em = $this->getDoctrine()->getManager();
            $em->persist($entity);
            $em->flush();

            return $this->redirect($this->generateUrl('ccp_show', array('id' => $entity->getId())));
        }

        return $this->render('MyAppUserBundle:Ccp:new.html.twig', array(
            'entity' => $entity,
            'form'   => $form->createView(),
        ));
    }
    
    public function listedemandeajoutAction() {

        $em = $this->getDoctrine()->getManager();
        $results = $em->getRepository('MyAppUserBundle:Ccp')->createQueryBuilder('c')
                ->where('c.validator_creation= :validator_creation')
                ->setParameter('validator_creation', '0')
                ->getQuery()
                ->getResult();
        return $this->render('MyAppUserBundle:Adiministrateur:Listedemandeajoutc.html.twig', array(
                    'results' => $results,
        ));
    }
    function supprimerccp($id) {
        $em = $this->getDoctrine()->getManager();
        $carte = $em->getRepository('MyAppUserBundle:Ccp')->find($id);
        $em->remove($carte);
        $em->flush();
        return $this->redirect($this->generateUrl('carteedinar_listedemandeajout'));
    }

    /**
     * Creates a form to create a Ccp entity.
     *
     * @param Ccp $entity The entity
     *
     * @return \Symfony\Component\Form\Form The form
     */
    private function createCreateForm(Ccp $entity)
    {
        $form = $this->createForm(new CcpType(), $entity, array(
            'action' => $this->generateUrl('ccp_create'),
            'method' => 'POST',
        ));

        $form->add('submit', 'submit', array('label' => 'Create'));

        return $form;
    }

    /**
     * Displays a form to create a new Ccp entity.
     *
     */
    public function newAction()
    {
        $entity = new Ccp();
        $form   = $this->createCreateForm($entity);

        return $this->render('MyAppUserBundle:Ccp:new.html.twig', array(
            'entity' => $entity,
            'form'   => $form->createView(),
        ));
    }

    /**
     * Finds and displays a Ccp entity.
     *
     */
    public function showAction($id)
    {
        $em = $this->getDoctrine()->getManager();

        $entity = $em->getRepository('MyAppUserBundle:Ccp')->find($id);

        if (!$entity) {
            throw $this->createNotFoundException('Unable to find Ccp entity.');
        }

        $deleteForm = $this->createDeleteForm($id);

        return $this->render('MyAppUserBundle:Ccp:show.html.twig', array(
            'entity'      => $entity,
            'delete_form' => $deleteForm->createView(),
        ));
    }

    /**
     * Displays a form to edit an existing Ccp entity.
     *
     */
    public function editAction($id)
    {
        $em = $this->getDoctrine()->getManager();

        $entity = $em->getRepository('MyAppUserBundle:Ccp')->find($id);

        if (!$entity) {
            throw $this->createNotFoundException('Unable to find Ccp entity.');
        }

        $editForm = $this->createEditForm($entity);
        $deleteForm = $this->createDeleteForm($id);

        return $this->render('MyAppUserBundle:Ccp:edit.html.twig', array(
            'entity'      => $entity,
            'edit_form'   => $editForm->createView(),
            'delete_form' => $deleteForm->createView(),
        ));
    }

    /**
    * Creates a form to edit a Ccp entity.
    *
    * @param Ccp $entity The entity
    *
    * @return \Symfony\Component\Form\Form The form
    */
    private function createEditForm(Ccp $entity)
    {
        $form = $this->createForm(new CcpType(), $entity, array(
            'action' => $this->generateUrl('ccp_update', array('id' => $entity->getNum_ccp())),
            'method' => 'PUT',
        ));

        $form->add('submit', 'submit', array('label' => 'Update'));

        return $form;
    }
    /**
     * Edits an existing Ccp entity.
     *
     */
    public function updateAction(Request $request, $id)
    {
        $em = $this->getDoctrine()->getManager();

        $entity = $em->getRepository('MyAppUserBundle:Ccp')->find($id);

        if (!$entity) {
            throw $this->createNotFoundException('Unable to find Ccp entity.');
        }

        $deleteForm = $this->createDeleteForm($id);
        $editForm = $this->createEditForm($entity);
        $editForm->handleRequest($request);

        if ($editForm->isValid()) {
            $em->flush();

            return $this->redirect($this->generateUrl('ccp_edit', array('id' => $id)));
        }

        return $this->render('MyAppUserBundle:Ccp:edit.html.twig', array(
            'entity'      => $entity,
            'edit_form'   => $editForm->createView(),
            'delete_form' => $deleteForm->createView(),
        ));
    }
    /**
     * Deletes a Ccp entity.
     *
     */
    public function deleteAction(Request $request, $id)
    {
        $form = $this->createDeleteForm($id);
        $form->handleRequest($request);

        if ($form->isValid()) {
            $em = $this->getDoctrine()->getManager();
            $entity = $em->getRepository('MyAppUserBundle:Ccp')->find($id);

            if (!$entity) {
                throw $this->createNotFoundException('Unable to find Ccp entity.');
            }

            $em->remove($entity);
            $em->flush();
        }

        return $this->redirect($this->generateUrl('ccp'));
    }

    /**
     * Creates a form to delete a Ccp entity by id.
     *
     * @param mixed $id The entity id
     *
     * @return \Symfony\Component\Form\Form The form
     */
    private function createDeleteForm($id)
    {
        return $this->createFormBuilder()
            ->setAction($this->generateUrl('ccp_delete', array('id' => $id)))
            ->setMethod('DELETE')
            ->add('submit', 'submit', array('label' => 'Delete'))
            ->getForm()
        ;
    }
}
