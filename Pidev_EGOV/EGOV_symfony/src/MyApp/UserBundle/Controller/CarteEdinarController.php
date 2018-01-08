<?php

namespace MyApp\UserBundle\Controller;

use Symfony\Component\HttpFoundation\Request;
use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use MyApp\UserBundle\Entity\CarteEdinar;
use MyApp\UserBundle\Form\CarteEdinarType;

/**
 * CarteEdinar controller.
 *
 */
class CarteEdinarController extends Controller {

    /**
     * Lists all CarteEdinar entities.
     *
     */
    public function reponseAction() {
        $em = $this->getDoctrine()->getManager();
        $result = $em->getRepository('MyAppUserBundle:CarteEdinar')->createQueryBuilder('c')
                ->where('c.validator_creation= :validator_creation')
                ->setParameter('validator_creation', '1')
                ->getQuery()
                ->getResult();
        $result2 = $em->getRepository('MyAppUserBundle:CarteEdinar')->createQueryBuilder('c')
                ->where('c.validator_creation= :validator_creation')
                ->setParameter('validator_creation', '0')
                ->getQuery()
                ->getResult();
        $result4 = $em->getRepository('MyAppUserBundle:CarteEdinar')->createQueryBuilder('c')
                ->where('c.validator_renouvellement= :validator_renouvellement')
                ->setParameter('validator_renouvellement', '0')
                ->getQuery()
                ->getResult();
        $result3 = $em->getRepository('MyAppUserBundle:CarteEdinar')->createQueryBuilder('c')
                ->where('c.validator_renouvellement= :validator_renouvellement')
                ->setParameter('validator_renouvellement', '1')
                ->getQuery()
                ->getResult();
        $result5 = $em->getRepository('MyAppUserBundle:CarteEdinar')->createQueryBuilder('c')
                ->where('c.validator_blockage= :validator_blockage')
                ->setParameter('validator_blockage', '1')
                ->getQuery()
                ->getResult();
        if ($result != null || $result3 != null || $result5 != null) {
            return $this->render('MyAppUserBundle:CarteEdinar:reponse.html.twig', array('result' => $result, 'result3' => $result3,));
        }
        if ($result2 != null || $result4 != null || $result5 != null) {
            return $this->render('MyAppUserBundle:CarteEdinar:encore.html.twig', array('result' => $result2,));
        } else {
            return $this->render('MyAppUserBundle:CarteEdinar:refuser.html.twig');
        }
    }

    public function acceuilAction() {
        return $this->render('MyAppUserBundle:CarteEdinar:Userfontedinar.html.twig');
    }

    public function reponsesAction() {
        return $this->render('MyAppUserBundle:CarteEdinar:reponses.html.twig');
    }
      public function carteedinaradminAction() {
        return $this->render('MyAppUserBundle:Adiministrateur:Carteesdinargestion.html.twig');
    }

    public function formedinarAction() {

        $requete = $this->get('request');
        $reponse1 = $requete->get('reponseq1');
        $reponse2 = $requete->get('reponseq2');
        $reponse3 = $requete->get('reponseq3');
        if ($reponse1 != "" && $reponse2 != "" && $reponse3 != "") {
            $CarteEdinar = new CarteEdinar();
            $CarteEdinar->setreponseq1($reponse1);
            $CarteEdinar->setreponseq2($reponse2);
            $CarteEdinar->setreponseq3($reponse3);
            $CarteEdinar->setValidatorCreation(0);
            $em = $this->getDoctrine()->getManager();
            $em->persist($CarteEdinar);
            $em->flush();
            return $this->redirect($this->generateUrl('carteedinar_succes'));
        }
        return $this->render('MyAppUserBundle:CarteEdinar:Formedinar.html.twig');
    }

    public function listedemandeajoutAction() {

        $em = $this->getDoctrine()->getManager();
        $results = $em->getRepository('MyAppUserBundle:CarteEdinar')->createQueryBuilder('c')
                ->where('c.validator_creation= :validator_creation')
                ->setParameter('validator_creation', '0')
                ->getQuery()
                ->getResult();
        return $this->render('MyAppUserBundle:Adiministrateur:Listedemandeajout.html.twig', array(
                    'results' => $results,
        ));
    }

    public function listedemanderenouvellementAction() {

        $em = $this->getDoctrine()->getManager();
        $results = $em->getRepository('MyAppUserBundle:CarteEdinar')->createQueryBuilder('c')
                ->where('c.validator_renouvellement= :validator_renouvellement')
                ->setParameter('validator_renouvellement', '0')
                ->getQuery()
                ->getResult();
        return $this->render('MyAppUserBundle:Adiministrateur:Listedemanderenouvellement.html.twig', array(
                    'results' => $results,));
    }

    public function listedemandeblockageAction() {

        $em = $this->getDoctrine()->getManager();
        $results = $em->getRepository('MyAppUserBundle:CarteEdinar')->createQueryBuilder('c')
                ->where('c.validator_blockage= :validator_blockage')
                ->setParameter('validator_blockage', '0')
                ->getQuery()
                ->getResult();
        return $this->render('MyAppUserBundle:Adiministrateur:listedemandeblockage.html.twig', array(
                    'results' => $results,));
    }

    public function infoedinarAction() {


        return $this->render('MyAppUserBundle:CarteEdinar:Infoedinar.html.twig');
    }

    public function succesAction() {


        return $this->render('MyAppUserBundle:CarteEdinar:succes.html.twig');
    }

    public function recuperationAction(Request $request) {

        $em = $this->getDoctrine()->getManager();
        $repository = $em->getRepository('MyAppUserBundle:CarteEdinar');
        $reponse1 = $request->get('reponseq1');
        $reponse2 = $request->get('reponseq2');
        $reponse3 = $request->get('reponseq3');
        $carte_edinar = $repository->findOneBy(array('reponseq1' => $reponse1, 'reponseq2' => $reponse2, 'reponseq3' => $reponse3));
        if ($carte_edinar && $carte_edinar->getReponseq1()!=null && $carte_edinar->getReponseq2()!=null && $carte_edinar->getReponseq2()!=null) {
            return $this->render('MyAppUserBundle:CarteEdinar:lecode.html.twig', array('carte_edinar' => $carte_edinar));
        } else {
            return $this->render('MyAppUserBundle:CarteEdinar:recuperation.html.twig');
        }
    }

    public function authedinarAction(Request $request) {

        $em = $this->getDoctrine()->getManager();
        $repository = $em->getRepository('MyAppUserBundle:CarteEdinar');

        if ($request->getMethod() == 'POST') {
            $numCarte = $request->get('numCarte');
            $codeCarte = $request->get('codeCarte');

            $carte_edinar = $repository->findOneBy(array('numCarte' => $numCarte, 'codeCarte' => $codeCarte));
            if ($carte_edinar && $carte_edinar->getValidatorBlockage() != 1) {
                return $this->render('MyAppUserBundle:CarteEdinar:solde.html.twig', array('carte_edinar' => $carte_edinar));
            }
            if ($carte_edinar->getValidatorBlockage() == 1) {
                return $this->render('MyAppUserBundle:CarteEdinar:bloquer.html.twig');
            } else {
                return $this->render('MyAppUserBundle:CarteEdinar:Authedinar.html.twig');
            }
        }
        return $this->render('MyAppUserBundle:CarteEdinar:Authedinar.html.twig');
    }

    public function blockageAction(Request $request) {

        $em = $this->getDoctrine()->getManager();
        $repository = $em->getRepository('MyAppUserBundle:CarteEdinar');
        $numCarte = $request->get('numCarte');
        $codeCarte = $request->get('codeCarte');
        $carte_edinar = $repository->findOneBy(array('numCarte' => $numCarte, 'codeCarte' => $codeCarte));
        if ($carte_edinar) {
            $carte_edinar->setValidatorBlockage('0');
            $em->persist($carte_edinar);
            $em->flush();
            return $this->render('MyAppUserBundle:CarteEdinar:drenvoye.html.twig', array('carte_edinar' => $carte_edinar));
        } else {
            return $this->render('MyAppUserBundle:CarteEdinar:blockage.html.twig');
        }
    }

    public function renouvellementAction(Request $request) {

        $em = $this->getDoctrine()->getManager();
        $repository = $em->getRepository('MyAppUserBundle:CarteEdinar');
        $numCarte = $request->get('numCarte');
        $codeCarte = $request->get('codeCarte');
        $carte_edinar = $repository->findOneBy(array('numCarte' => $numCarte, 'codeCarte' => $codeCarte));
        if ($carte_edinar) {
            $carte_edinar->setValidatorRenouvellement('0');
            $em->persist($carte_edinar);
            $em->flush();
            return $this->render('MyAppUserBundle:CarteEdinar:drenvoye.html.twig', array('carte_edinar' => $carte_edinar));
        } else {
            return $this->render('MyAppUserBundle:CarteEdinar:renouvellement.html.twig');
        }
    }

    public function authedinar2Action(Request $request) {

        $em = $this->getDoctrine()->getManager();
        $repository = $em->getRepository('MyAppUserBundle:CarteEdinar');

        if ($request->getMethod() == 'POST') {
            $numCarte = $request->get('numCarte');
            $codeCarte = $request->get('codeCarte');

            $carte_edinar = $repository->findOneBy(array('numCarte' => $numCarte, 'codeCarte' => $codeCarte));
            if ($carte_edinar && $carte_edinar->getValidatorBlockage() != 1) {
                return $this->render('MyAppUserBundle:CarteEdinar:historique.html.twig', array('carte_edinar' => $carte_edinar));
            }
            if ($carte_edinar->getValidatorBlockage() == 1) { {
                    return $this->render('MyAppUserBundle:CarteEdinar:bloquer.html.twig');
                }
            } else {
                return $this->render('MyAppUserBundle:CarteEdinar:Authedinar2.html.twig');
            }
        }
        return $this->render('MyAppUserBundle:CarteEdinar:Authedinar2.html.twig');
    }

    public function indexAction() {
        $em = $this->getDoctrine()->getManager();

        $entities = $em->getRepository('MyAppUserBundle:CarteEdinar')->findAll();

        return $this->render('MyAppUserBundle:CarteEdinar:index.html.twig', array(
                    'entities' => $entities,
        ));
    }

    /**
     * Creates a new CarteEdinar entity.
     *
     */
    public function createAction(Request $request) {
        $entity = new CarteEdinar();
        $form = $this->createCreateForm($entity);
        $form->handleRequest($request);

        if ($form->isValid()) {
            $em = $this->getDoctrine()->getManager();
            $em->persist($entity);
            $em->flush();

            return $this->redirect($this->generateUrl('carteedinar_show', array('id' => $entity->getId())));
        }

        return $this->render('MyAppUserBundle:CarteEdinar:new.html.twig', array(
                    'entity' => $entity,
                    'form' => $form->createView(),
        ));
    }

    /**
     * Creates a form to create a CarteEdinar entity.
     *
     * @param CarteEdinar $entity The entity
     *
     * @return \Symfony\Component\Form\Form The form
     */
    private function createCreateForm(CarteEdinar $entity) {
        $form = $this->createForm(new CarteEdinarType(), $entity, array(
            'action' => $this->generateUrl('carteedinar_create'),
            'method' => 'POST',
        ));

        $form->add('submit', 'submit', array('label' => 'Create'));

        return $form;
    }

    /**
     * Displays a form to create a new CarteEdinar entity.
     *
     */
    public function newAction() {
        $entity = new CarteEdinar();
        $form = $this->createCreateForm($entity);

        return $this->render('MyAppUserBundle:CarteEdinar:new.html.twig', array(
                    'entity' => $entity,
                    'form' => $form->createView(),
        ));
    }

    /**
     * Finds and displays a CarteEdinar entity.
     *
     */
    public function showAction($id) {
        $em = $this->getDoctrine()->getManager();

        $entity = $em->getRepository('MyAppUserBundle:CarteEdinar')->find($id);

        if (!$entity) {
            throw $this->createNotFoundException('Unable to find CarteEdinar entity.');
        }

        $deleteForm = $this->createDeleteForm($id);

        return $this->render('MyAppUserBundle:CarteEdinar:show.html.twig', array(
                    'entity' => $entity,
                    'delete_form' => $deleteForm->createView(),
        ));
    }

    /**
     * Displays a form to edit an existing CarteEdinar entity.
     *
     */
    public function editAction($id) {
        $em = $this->getDoctrine()->getManager();

        $entity = $em->getRepository('MyAppUserBundle:CarteEdinar')->find($id);

        if (!$entity) {
            throw $this->createNotFoundException('Unable to find CarteEdinar entity.');
        }

        $editForm = $this->createEditForm($entity);
        $deleteForm = $this->createDeleteForm($id);

        return $this->render('MyAppUserBundle:CarteEdinar:edit.html.twig', array(
                    'entity' => $entity,
                    'edit_form' => $editForm->createView(),
                    'delete_form' => $deleteForm->createView(),
        ));
    }

    /**
     * Creates a form to edit a CarteEdinar entity.
     *
     * @param CarteEdinar $entity The entity
     *
     * @return \Symfony\Component\Form\Form The form
     */
    private function createEditForm(CarteEdinar $entity) {
        $form = $this->createForm(new CarteEdinarType(), $entity, array(
            'action' => $this->generateUrl('carteedinar_update', array('id' => $entity->getNumCarte())),
            'method' => 'PUT',
        ));

        $form->add('submit', 'submit', array('label' => 'Update'));

        return $form;
    }

    /**
     * Edits an existing CarteEdinar entity.
     *
     */
    public function updateAction(Request $request, $id) {
        $em = $this->getDoctrine()->getManager();

        $entity = $em->getRepository('MyAppUserBundle:CarteEdinar')->find($id);

        if (!$entity) {
            throw $this->createNotFoundException('Unable to find CarteEdinar entity.');
        }

        $deleteForm = $this->createDeleteForm($id);
        $editForm = $this->createEditForm($entity);
        $editForm->handleRequest($request);

        if ($editForm->isValid()) {
            $em->flush();

            return $this->redirect($this->generateUrl('carteedinar_edit', array('id' => $id)));
        }

        return $this->render('MyAppUserBundle:CarteEdinar:edit.html.twig', array(
                    'entity' => $entity,
                    'edit_form' => $editForm->createView(),
                    'delete_form' => $deleteForm->createView(),
        ));
    }

    /**
     * Deletes a CarteEdinar entity.
     *
     */
    function supprimercarteAction($id) {
        $em = $this->getDoctrine()->getManager();
        $carte = $em->getRepository('MyAppUserBundle:CarteEdinar')->find($id);
        $em->remove($carte);
        $em->flush();
        return $this->redirect($this->generateUrl('carteedinar_listedemandeajout'));
    }

    public function deleteAction(Request $request, $id) {
        $form = $this->createDeleteForm($id);
        $form->handleRequest($request);

        if ($form->isValid()) {
            $em = $this->getDoctrine()->getManager();
            $entity = $em->getRepository('MyAppUserBundle:CarteEdinar')->find($id);


            $em->remove($entity);
            $em->flush();
        }

        return $this->redirect($this->generateUrl('carteedinar_listedemandeajout'));
    }

    /**
     * Creates a form to delete a CarteEdinar entity by id.
     *
     * @param mixed $id The entity id
     *
     * @return \Symfony\Component\Form\Form The form
     */
    private function createDeleteForm($id) {
        return $this->createFormBuilder()
                        ->setAction($this->generateUrl('carteedinar_delete', array('id' => $id)))
                        ->setMethod('DELETE')
                        ->add('submit', 'submit', array('label' => 'Delete'))
                        ->getForm()
        ;
    }

}
