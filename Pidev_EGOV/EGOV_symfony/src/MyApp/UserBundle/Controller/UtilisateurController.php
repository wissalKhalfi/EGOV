<?php

namespace MyApp\UserBundle\Controller;

use Symfony\Component\HttpFoundation\Request;
use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use MyApp\UserBundle\Entity\ActesJuridiques;
use MyApp\UserBundle\Entity\Utilisateur;
use MyApp\UserBundle\Form\UtilisateurType;
use MyApp\UserBundle\Entity\ListeActes;
use MyApp\UserBundle\Form\ActesJuridiquesType;
use MyApp\UserBundle\Form\ExtraitNaissanceForm;
use MyApp\UserBundle\Form\RechercheActesForm;
use MyApp\UserBundle\Form\ListeActesType;
use Symfony\Component\HttpFoundation\File\UploadedFile;
use Symfony\Component\HttpFoundation\File\File;
use MyApp\UserBundle\Form\CinForm;
use Symfony\Component\Form\Form;
use Doctrine\ORM\QueryBuilder;
use Doctrine\DBAL\Driver\Statement;
Use Symfony\Component\DependencyInjection\Container;
Use Symfony\Component\Security\Http\RememberMe\TokenBasedRememberMeServices;
Use FOS\UserBundle\DependencyInjection\FOSUserExtension;
use Symfony\Component\Security\Csrf\TokenGenerator\TokenGeneratorInterface;
use FOS\UserBundle\FOSUserBundle;
use MyApp\UserBundle\Entity\User;
use SplFileInfo;
use Ensepar\Html2pdfBundle\EnseparHtml2pdfBundle;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\HttpFoundation\StreamedResponse;
use MyApp\UserBundle\Form\CinValidationForm;
use Ob\HighchartsBundle\Highcharts\Highchart;

/**
 * Utilisateur controller.
 *
 */
class UtilisateurController extends Controller {

    /**
     * Lists all Utilisateur entities.
     *
     */
    public function indexAction() {
        $em = $this->getDoctrine()->getManager();

        $entities = $em->getRepository('MyAppUserBundle:Utilisateur')->findAll();

        return $this->render('MyAppUserBundle:Utilisateur:index.html.twig', array(
                    'entities' => $entities,
        ));
    }

    /**
     * Creates a new Utilisateur entity.
     *
     */
    public function createAction(Request $request) {
        $entity = new Utilisateur();
        $form = $this->createCreateForm($entity);
        $form->handleRequest($request);

        if ($form->isValid()) {
            $em = $this->getDoctrine()->getManager();
            $em->persist($entity);
            $em->flush();

            return $this->redirect($this->generateUrl('utilisateur_show', array('id' => $entity->getId())));
        }

        return $this->render('MyAppUserBundle:Utilisateur:new.html.twig', array(
                    'entity' => $entity,
                    'form' => $form->createView(),
        ));
    }

    /**
     * Creates a form to create a Utilisateur entity.
     *
     * @param Utilisateur $entity The entity
     *
     * @return \Symfony\Component\Form\Form The form
     */
    private function createCreateForm(Utilisateur $entity) {
        $form = $this->createForm(new UtilisateurType(), $entity, array(
            'action' => $this->generateUrl('utilisateur_create'),
            'method' => 'POST',
        ));

        $form->add('submit', 'submit', array('label' => 'Create'));

        return $form;
    }

    /**
     * Displays a form to create a new Utilisateur entity.
     *
     */
    public function newAction() {
        $entity = new Utilisateur();
        $form = $this->createCreateForm($entity);

        return $this->render('MyAppUserBundle:Utilisateur:new.html.twig', array(
                    'entity' => $entity,
                    'form' => $form->createView(),
        ));
    }

    /**
     * Finds and displays a Utilisateur entity.
     *
     */
    public function showAction($id) {
        $em = $this->getDoctrine()->getManager();

        $entity = $em->getRepository('MyAppUserBundle:Utilisateur')->find($id);

        if (!$entity) {
            throw $this->createNotFoundException('Unable to find Utilisateur entity.');
        }

        $deleteForm = $this->createDeleteForm($id);

        return $this->render('MyAppUserBundle:Utilisateur:show.html.twig', array(
                    'entity' => $entity,
                    'delete_form' => $deleteForm->createView(),
        ));
    }

    /**
     * Displays a form to edit an existing Utilisateur entity.
     *
     */
    public function editAction($id) {
        $em = $this->getDoctrine()->getManager();

        $entity = $em->getRepository('MyAppUserBundle:Utilisateur')->find($id);

        if (!$entity) {
            throw $this->createNotFoundException('Unable to find Utilisateur entity.');
        }

        $editForm = $this->createEditForm($entity);
        $deleteForm = $this->createDeleteForm($id);

        return $this->render('MyAppUserBundle:Utilisateur:edit.html.twig', array(
                    'entity' => $entity,
                    'edit_form' => $editForm->createView(),
                    'delete_form' => $deleteForm->createView(),
        ));
    }

    /**
     * Creates a form to edit a Utilisateur entity.
     *
     * @param Utilisateur $entity The entity
     *
     * @return \Symfony\Component\Form\Form The form
     */
    private function createEditForm(Utilisateur $entity) {
        $form = $this->createForm(new UtilisateurType(), $entity, array(
            'action' => $this->generateUrl('utilisateur_update', array('id' => $entity->getId())),
            'method' => 'PUT',
        ));

        $form->add('submit', 'submit', array('label' => 'Update'));

        return $form;
    }

    /**
     * Edits an existing Utilisateur entity.
     *
     */
    public function updateAction(Request $request, $id) {
        $em = $this->getDoctrine()->getManager();

        $entity = $em->getRepository('MyAppUserBundle:Utilisateur')->find($id);

        if (!$entity) {
            throw $this->createNotFoundException('Unable to find Utilisateur entity.');
        }

        $deleteForm = $this->createDeleteForm($id);
        $editForm = $this->createEditForm($entity);
        $editForm->handleRequest($request);

        if ($editForm->isValid()) {
            $em->flush();

            return $this->redirect($this->generateUrl('utilisateur_edit', array('id' => $id)));
        }

        return $this->render('MyAppUserBundle:Utilisateur:edit.html.twig', array(
                    'entity' => $entity,
                    'edit_form' => $editForm->createView(),
                    'delete_form' => $deleteForm->createView(),
        ));
    }

    /**
     * Deletes a Utilisateur entity.
     *
     */
    public function deleteAction(Request $request, $id) {
        $form = $this->createDeleteForm($id);
        $form->handleRequest($request);

        if ($form->isValid()) {
            $em = $this->getDoctrine()->getManager();
            $entity = $em->getRepository('MyAppUserBundle:Utilisateur')->find($id);

            if (!$entity) {
                throw $this->createNotFoundException('Unable to find Utilisateur entity.');
            }

            $em->remove($entity);
            $em->flush();
        }

        return $this->redirect($this->generateUrl('utilisateur'));
    }

    /**
     * Creates a form to delete a Utilisateur entity by id.
     *
     * @param mixed $id The entity id
     *
     * @return \Symfony\Component\Form\Form The form
     */
    private function createDeleteForm($id) {
        return $this->createFormBuilder()
                        ->setAction($this->generateUrl('utilisateur_delete', array('id' => $id)))
                        ->setMethod('DELETE')
                        ->add('submit', 'submit', array('label' => 'Delete'))
                        ->getForm()
        ;
    }

    public function indexENAction() {
        return $this->render('MyAppUserBundle:wissal:menuEN_cit.html.twig');
    }

    public function indexCinAction() {
        return $this->render('MyAppUserBundle:wissal:menuCin_cit.html.twig');
    }

    public function indexB3Action() {
        return $this->render('MyAppUserBundle:wissal:B3_citoyen.html.twig');
    }

    public function indexAdminAction() {

        return $this->render('MyAppUserBundle:Administrateur_Front:dashboard.html.twig');
    }

    public function ENAdminAction() {
        return $this->render('MyAppUserBundle:wissal:menuEN_admin.html.twig');
    }

    public function CinAdminAction() {
        return $this->render('MyAppUserBundle:wissal:menuCin_admin.html.twig');
    }

    public function B3AdminAction() {
        return $this->render('MyAppUserBundle:wissal:menuB3_admin.html.twig');
    }

    public function AjoutExtraitNaissanceAction() {

        $extrait_naiss = new Utilisateur();
        $extrait_naiss->setValidation(0);
        //$user_connected = new User();
        $user_connected = $this->getUser();
        /* print_r($this->getUser());
          die; */
        // $user = new FosUser();
        //$user->set = $user_connected->getId();
        $form = $this->createForm(new ExtraitNaissanceForm(), $extrait_naiss);
        $requete = $this->get('request');
        if ($requete->getMethod() == 'POST') {
            $form->bind($requete);
            if ($form->isValid()) {
                // $extrait_naiss->setFosUserId($user_connected);
                $em = $this->getDoctrine()->getManager();
                $em->persist($extrait_naiss);
                $em->flush();
                return $this->redirect($this->generateUrl('citoyen_ecitoyennite'));
            }
        }
        return $this->render("MyAppUserBundle:wissal:AddEN_citoyen.html.twig", array('form' => $form->createView()));
    }

    public function ListerDemandesENAction() {
        $em = $this->getDoctrine()->getManager();
        $demandesEN = $em->getRepository('MyAppUserBundle:Utilisateur')->findByValidation(0);
        return $this->render('MyAppUserBundle:wissal:ListeDemandesEN_admin.html.twig', array('demandesEN' => $demandesEN));
    }

    public function ListerENAction() {
        $em = $this->getDoctrine()->getManager();
        $demandesEN = $em->getRepository('MyAppUserBundle:Utilisateur')->findByValidation(1);
        return $this->render('MyAppUserBundle:wissal:ListeEN_admin.html.twig', array('demandesEN' => $demandesEN));
    }

    public function ValidationDemandesENAction($id) {
        $em = $this->getDoctrine()->getManager();

        $demande_ext = $em->getRepository('MyAppUserBundle:Utilisateur')->findOneById_uti($id);



        return $this->render('MyAppUserBundle:wissal:ValiderDemandeEN_admin.html.twig', array(
                    'ext' => $demande_ext));
    }

    public function AccepterDemandesENAction($id) {
        $em = $this->getDoctrine()->getManager();
        $demande_ext = $em->getRepository('MyAppUserBundle:Utilisateur')->findOneById_uti($id);
        $en = new Utilisateur();
        $en = $demande_ext;
        $id_demande = $en->getIduti();


        $em1 = $this->getDoctrine()->getEntityManager();
        $connection = $em1->getConnection();
        $statement = $connection->prepare("Update Utilisateur set validation=1 WHERE id_uti = :id");
        $statement->bindValue('id', $id_demande);
        $statement->execute();
        $em1->flush();

        echo "<script  type=\"text/javascript\">"
        . "alert(\" Demande acceptée \");"
        . "</script>";
        return $this->redirect($this->generateUrl('ExtraitNaiss_demandes'));
    }

    public function RefuserDemandesENAction($id) {
        $em = $this->getDoctrine()->getManager();
        $demande_ext = $em->getRepository('MyAppUserBundle:Utilisateur')->findOneById_uti($id);
        $en = new Utilisateur();
        $en = $demande_ext;
        $id_demande = $en->getIduti();


        $em1 = $this->getDoctrine()->getEntityManager();
        $connection = $em1->getConnection();
        $statement = $connection->prepare("Update Utilisateur set validation=2 WHERE id_uti = :id");
        $statement->bindValue('id', $id_demande);
        $statement->execute();
        $em1->flush();


        echo "<script  type=\"text/javascript\">"
        . "alert(\" Demande refusée \");"
        . "</script>";
        return $this->redirect($this->generateUrl('ExtraitNaiss_demandes'));
    }

    public function ReponseDemandeENutilisateurAction($id) {
        $en = new Utilisateur();
        $em = $this->getDoctrine()->getManager();
        $en = $em->getRepository('MyAppUserBundle:Utilisateur')->findOneById_uti($id);
        $test = $en->getvalidation();
        if ($test == 2) {
            echo "<script  type=\"text/javascript\">"
            . "alert(\" "
            . "Erreur veuillez corriger votre demande "
            . " \");"
            . "</script>";

            $form = $this->createForm(new ExtraitNaissanceForm(), $en);
            $requete = $this->get('request');


            if ($requete->getMethod() == 'POST') {
                $form->bind($requete);
                if ($form->isValid()) {
                    $em = $this->getDoctrine()->getManager();
                    $en->setValidation(0);
                    $em->persist($en);
                    $em->flush();
                    return $this->redirect($this->generateUrl('citoyen_ecitoyennite'));
                }
            }
            return $this->render("MyAppUserBundle:wissal:AddEN_citoyen.html.twig", array('form' => $form->createView()));
        } else if ($test == 1) {
            echo "<script  type=\"text/javascript\">"
            . "alert(\" Demande validée \");"
            . "</script>";
            return $this->redirect($this->generateUrl('citoyen_ecitoyennite'));
        }
    }

    public function AfficherEnAction($id) {
        $em = $this->getDoctrine()->getManager();

        $en = $em->getRepository('MyAppUserBundle:Utilisateur')->findOneById_uti($id);



        return $this->render('MyAppUserBundle:wissal:EN_citoyen.html.twig', array(
                    'en' => $en));
    }

    public function SexePieENAction() {

        $ob = new Highchart();
        $ob->chart->renderTo('ExtraitNaiss_chart_sexe');
        $ob->title->text('Browser market shares at a specific website in 2010');

        $ob->plotOptions->pie(array(
            'allowPointSelect' => true,
            'cursor' => 'pointer',
            'dataLabels' => array('enabled' => false),
            'showInLegend' => true
        ));

        $data = array(
            array('Firefox', 45.0),
            array('IE', 26.8),
            array('Chrome', 12.8),
            array('Safari', 8.5),
            array('Opera', 6.2),
            array('Others', 0.7),
        );

        $ob->series(array(array('type' => 'pie', 'name' => 'Browser share', 'data' => $data)));

        return $this->render('MyAppUserBundle:wissal:pie.html.twig', array(
                    'chart' => $ob
        ));
    }

    public function imprimerENAction($id) {
        $em = $this->getDoctrine()->getManager();
        $en = $em->getRepository('MyAppUserBundle:Utilisateur')->findOneById_uti($id);
        $vue = $this->render('MyAppUserBundle:wissal:EN_citoyen.html.twig', array('en' => $en));
        // $html2pdf = new Html2Pdf_Html2Pdf('P', 'A4', 'fr');
        $html2pdf = $this->get('html2pdf_factory')->create();
        $html2pdf->pdf->SetDisplayMode('real');
        $html2pdf->writeHTML($vue);
        //$html2pdf->Output('Extrait_de_naissance.pdf');
        return new Response($html2pdf->Output('Extrait_de_naissance.pdf'), 200, array('Content-Type' => 'application/pdf'));
        /* $response = new Response();
          $response->clearHttpHeaders();
          $response->setContent($content);
          $response->headers->set('Content-Type', 'application/force-download');
          $response->headers->set('Content-disposition', 'filename=Extrait_de_naissance.pdf');
          return $response; */
    }

    public function AjouterCinAction($id) {


        $cin = new Utilisateur();
        // $user_connected  = $this->container->get('security.context')->getToken()->getUser();
        //$id_connected=   $user_connected->getId();        
        $em = $this->getDoctrine()->getManager();
        $cin = $em->getRepository('MyAppUserBundle:Utilisateur')->findOneById_uti($id);

        //
        $form = $this->createForm(new cinForm(), $cin);
        $requete = $this->get('request');

        if ($requete->getMethod() == 'POST') {
            $form->bind($requete);
            if ($form->isValid()) {
                $cin->setValidation(4);

                foreach ($requete->files as $uploadedFile) {
                    $filename = $uploadedFile->getPathname();
                    $strm = fopen($filename, 'rb');
                    $cin->setPhoto(stream_get_contents($strm));
                }

                $em->persist($cin);
                $em->flush();
                return $this->render('MyAppUserBundle:wissal:menuCin_cit.html.twig');
                /*
                  $nom_ut=$form->get('nom')->getData();
                  $pnom_ut=$form->get('prenom')->getData();
                  $lieu_naiss_ut=$form->get('lieuNaissance')->getData();
                  $nompere_ut=$form->get('nomPere')->getData();
                  $pnompere_ut=$form->get('prenomPere')->getData();
                  $nommere_ut=$form->get('nomMere')->getData();
                  $pnommere_ut=$form->get('prenomMere')->getData();
                  $sexe_ut=$form->get('sexe')->getData();

                  $query = $em->createQuery(
                  'Update u.
                  FROM MyAppUserBundle:Utilisateur u
                  WHERE u.fosUser like :id_fos'
                  )->setParameter('id_fos', $id_connected) ;
                  $id_utilisateur_bd = $query->getResult(); */
            }
        }


        return $this->render("MyAppUserBundle:wissal:AddCin_citoyen.html.twig", array('form' => $form->createView()));
    }

    public function ListerDemandesCINAction() {
        $em = $this->getDoctrine()->getManager();

        $demandesCin = $em->getRepository('MyAppUserBundle:Utilisateur')->findByValidation(4);


        return $this->render('MyAppUserBundle:wissal:ListeDemandesCin_admin.html.twig', array('demandesCin' => $demandesCin));
    }

    public function ListerCINAction() {
        $em = $this->getDoctrine()->getManager();

        $demandesCin = $em->getRepository('MyAppUserBundle:Utilisateur')->findByValidation(5);


        return $this->render('MyAppUserBundle:wissal:ListeCin_admin.html.twig', array('demandesCin' => $demandesCin));
    }

    public function RechCinAction($nom) {
        $em = $this->getDoctrine()->getManager();

        $demandesCin = $em->getRepository('MyAppUserBundle:Utilisateur')->findByNom($nom);

        return $this->render('MyAppUserBundle:wissal:ListeCin_admin.html.twig', array('demandesCin' => $demandesCin));
    }

    public function ValidationDemandesCinAction($id) {
        $em = $this->getDoctrine()->getManager();
        $demande_cin = $em->getRepository('MyAppUserBundle:Utilisateur')->findOneById_uti($id);
        $image_ut = base64_encode(stream_get_contents($demande_cin->getPhoto()));

        return $this->render('MyAppUserBundle:wissal:ValiderDemandeCin_admin.html.twig', array(
                    'DemCin' => $demande_cin, 'image' => $image_ut));
    }

    public function AccepterDemandesCinAction($id) {
        $em = $this->getDoctrine()->getManager();
        $demande_cin = $em->getRepository('MyAppUserBundle:Utilisateur')->findOneById_uti($id);
        $cin = new Utilisateur();
        $cin = $demande_cin;
        $cin->setValidation(5);
        $em->persist($cin);
        $numCin = 'TN' . strval($id);
        $query = $em->createQuery(
                        'Update MyAppUserBundle:Utilisateur u
     SET u.numCin = :numCin
    WHERE u.iduti like :idut'
                )->setParameters(array('idut' => $id, 'numCin' => $numCin));
        $id_utilisateur_bd = $query->getResult();
        $em->flush();

        echo "<script  type=\"text/javascript\">"
        . "alert(\" Demande CIN acceptée \");"
        . "</script>";
        return $this->redirect($this->generateUrl('cin_demandes', array('id' => $id)));
    }

    public function RefuserDemandesCinAction($id) {
        $em = $this->getDoctrine()->getManager();
        $demande_cin = new Utilisateur();
        $demande_cin = $em->getRepository('MyAppUserBundle:Utilisateur')->findOneById_uti($id);
        $cin->setValidation(6);
        $em->persist($cin);
        $em->flush();


        echo "<script  type=\"text/javascript\">"
        . "alert(\" Demande refusée \");"
        . "</script>";
        return $this->redirect($this->generateUrl('cin_demandes'));
    }

    public function photoAction($id) {

        $em = $this->getDoctrine()->getManager();

        $image_obj = $em->getRepository('MyAppUserBundle:Utilisateur')->findOneById_uti($id);

        $photo = $image_obj->getphoto();

        $response = new StreamedResponse(function () use ($photo) {

            echo stream_get_contents($photo);
        });

        $response->headers->set('Content-Type', 'image/jpeg');

        return $response;
    }

    public function AfficherCinAction($id) {
        $em = $this->getDoctrine()->getManager();
        $demande_cin = $em->getRepository('MyAppUserBundle:Utilisateur')->findOneById_uti($id);
        $image_ut = base64_encode(stream_get_contents($demande_cin->getPhoto()));
        return $this->render('MyAppUserBundle:wissal:Cin_citoyen.html.twig', array(
                    'DemCin' => $demande_cin, 'image' => $image_ut));
    }

    public function AjouterActeJuridiqueAction() {


        $acte = new ActesJuridiques();
        $em = $this->getDoctrine()->getManager();
        $form = $this->createForm(new ActesJuridiquesType(), $acte);
        $requete = $this->get('request');

        if ($requete->getMethod() == 'POST') {
            $form->bind($requete);
            if ($form->isValid()) {
                $em->persist($acte);
                $em->flush();
                echo "<script  type=\"text/javascript\">"
                . "alert(\" Nouvel acte inséré \");"
                . "</script>";
                return $this->redirect($this->generateUrl('b3_liste_actes'));
            }
        }


        return $this->render("MyAppUserBundle:wissal:AddActeJuri_admin.html.twig", array('form' => $form->createView()));
    }

    public function ListerActeJuridiqueAction() {
        $em = $this->getDoctrine()->getManager();

        $actes_juri = $em->getRepository('MyAppUserBundle:ActesJuridiques')->findAll();



        return $this->render('MyAppUserBundle:wissal:ListeActesJuri_admin.html.twig', array('actesJuri' => $actes_juri));
    }

    public function AjouterCondamnesAction($id) {


        $em = $this->getDoctrine()->getManager();
        $qb = $em->createQueryBuilder();
        $q = $qb->select(array('p'))
                ->from('MyAppUserBundle:Utilisateur', 'p')
                ->where($qb->expr()->isNotNull('p.numCin') )
                ->getQuery();  
        $citoyens = $q->getArrayResult();
        return $this->render("MyAppUserBundle:wissal:AddCondamneActeJuri_admin.html.twig", array('citoyen' => $citoyens, 'id' => $id));
    }

    public function CondamnerAction($id, $cin) {


        $em = $this->getDoctrine()->getManager();

        $citoyen = new Utilisateur();
        $acte = new ActesJuridiques();
        $citoyen = $em->getRepository('MyAppUserBundle:Utilisateur')->findOneByNumCin($cin);
        $acte = $em->getRepository('MyAppUserBundle:ActesJuridiques')->findOneByIdActe($id);


        $liste_actes = new ListeActes();
        $liste_actes->setActe($acte);
        $liste_actes->setCitoyen($citoyen);


        $em->persist($liste_actes);
        $em->flush();
        echo "<script  type=\"text/javascript\">"
        . "alert(\" Condamné inséré \");"
        . "</script>";
        return $this->redirect($this->generateUrl('b3_ajouter_liste_actes', array('id' => $id)));
    }

    public function ListerActeCondamneAction() {
        $em = $this->getDoctrine()->getManager();
        //$actes = $em->getRepository('MyAppUserBundle:ListeActes')->findAll();
        $qb = $em->createQueryBuilder();
        $q = $qb->select(array('p'))
                ->from('MyAppUserBundle:ListeActes', 'p')
                ->getQuery();
        $actes = new ListeActes();
        $actes = $q->getArrayResult();              
        return $this->render("MyAppUserBundle:wissal:ListeActeCondamnes.html.twig", array('actes' => $actes));
    }

    public function AfficherB3Action($numCin) {


        $em = $this->getDoctrine()->getManager();
        $citoyen = $em->getRepository('MyAppUserBundle:Utilisateur')->findOneByNumCin($numCin);
        $id = $citoyen->getIdUti();
        $qb = $em->createQueryBuilder();
        $q = $qb->select(array('p'))
                ->from('MyAppUserBundle:ListeActes', 'p')
                ->where(
                        $qb->expr()->eq('p.citoyen', ':start')
                )
                ->setParameter('start', $numCin)
                ->getQuery();
        $actes = new ListeActes();
        $actes = $q->getArrayResult();
        $Listes_actes[] = new ActesJuridiques();

        foreach ($actes as $e) {

            $Listes_actes[] = $em->getRepository('MyAppUserBundle:ActesJuridiques')->findOneByIdActe($e);
        }

        return $this->render("MyAppUserBundle:wissal:B3_citoyen.html.twig", array('citoyen' => $citoyen, 'actes' => $Listes_actes));
    }

    public function MapAction() {
        $name = 'name';
        $latitudes = '36.8188';
        $longitudes = '10.166';
        return $this->render("MyAppUserBundle:wissal:map1.html.twig", array('Latitudes' => $latitudes, 'Longitudes' => $longitudes));
    }

}
