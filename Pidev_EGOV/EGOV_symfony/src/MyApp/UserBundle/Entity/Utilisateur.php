<?php

namespace MyApp\UserBundle\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Utilisateur
 *
 * @ORM\Table(name="utilisateur", uniqueConstraints={@ORM\UniqueConstraint(name="id_uti", columns={"id_uti"})}, indexes={@ORM\Index(name="CCP", columns={"CCP"}), @ORM\Index(name="listes_actes", columns={"listes_actes"}), @ORM\Index(name="fos_user", columns={"fos_user"}), @ORM\Index(name="num_permis", columns={"num_permis"}), @ORM\Index(name="carte_grise", columns={"carte_grise"}), @ORM\Index(name="num_passeport", columns={"num_passeport"}), @ORM\Index(name="csc", columns={"csc"}), @ORM\Index(name="csc_2", columns={"csc"})})
 * @ORM\Entity
 */
class Utilisateur
{
    /**
     * @var string
     *
     * @ORM\Column(name="nom", type="string", length=40, nullable=true)
     */
    private $nom;

    /**
     * @var string
     *
     * @ORM\Column(name="prenom", type="string", length=40, nullable=true)
     */
    private $prenom;

    /**
     * @var string
     *
     * @ORM\Column(name="type", type="string", length=10, nullable=false)
     */
    private $type;

    /**
     * @var \DateTime
     *
     * @ORM\Column(name="date_naissance", type="date", nullable=true)
     */
    private $dateNaissance;

    /**
     * @var string
     *
     * @ORM\Column(name="lieu_naissance", type="string", length=100, nullable=true)
     */
    private $lieuNaissance;

    /**
     * @var string
     *
     * @ORM\Column(name="statut_social", type="string", length=50, nullable=true)
     */
    private $statutSocial;

    /**
     * @var string
     *
     * @ORM\Column(name="nom_pere", type="string", length=100, nullable=true)
     */
    private $nomPere;

    /**
     * @var string
     *
     * @ORM\Column(name="prenom_pere", type="string", length=100, nullable=true)
     */
    private $prenomPere;

    /**
     * @var string
     *
     * @ORM\Column(name="nom_mere", type="string", length=100, nullable=true)
     */
    private $nomMere;

    /**
     * @var string
     *
     * @ORM\Column(name="prenom_mere", type="string", length=100, nullable=true)
     */
    private $prenomMere;

    /**
     * @var string
     *
     * @ORM\Column(name="sexe", type="string", length=10, nullable=true)
     */
    private $sexe;

    /**
     * @var string
     *
     * @ORM\Column(name="adresse", type="string", length=200, nullable=true)
     */
    private $adresse;

    /**
     * @var \DateTime
     *
     * @ORM\Column(name="date_delivrence_cin", type="date", nullable=true)
     */
    private $dateDelivrenceCin;

    /**
     * @var string
     *
     * @ORM\Column(name="photo", type="blob", nullable=true)
     */
    private $photo;

    /**
     * @var string
     *
     * @ORM\Column(name="profession", type="string", length=40, nullable=true)
     */
    private $profession;

    /**
     * @var string
     *
     * @ORM\Column(name="empreinte", type="blob", nullable=true)
     */
    private $empreinte;

    /**
     * @var integer
     *
     * @ORM\Column(name="code_empreinte", type="integer", nullable=true)
     */
    private $codeEmpreinte;

    /**
     * @var integer
     *
     * @ORM\Column(name="id_agent", type="integer", nullable=true)
     */
    private $idAgent;

    /**
     * @var integer
     *
     * @ORM\Column(name="listes_actes", type="integer", nullable=true)
     */
    private $listesActes;

    /**
     * @var integer
     *
     * @ORM\Column(name="validation", type="integer", nullable=true)
     */
    private $validation;

    /**
     * @var string
     *
     * @ORM\Column(name="num_cin", type="string", length=8)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="NONE")
     */
    private $numCin;

    /**
     * @var integer
     *
     * @ORM\Column(name="id_uti", type="integer")
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="NONE")
     */
    private $idUti;

    /**
     * @var \MyApp\UserBundle\Entity\Passeport
     *
     * @ORM\ManyToOne(targetEntity="MyApp\UserBundle\Entity\Passeport")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="num_passeport", referencedColumnName="numPasseport")
     * })
     */
    private $numPasseport;

    /**
     * @var \MyApp\UserBundle\Entity\Permis
     *
     * @ORM\ManyToOne(targetEntity="MyApp\UserBundle\Entity\Permis")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="num_permis", referencedColumnName="numPermis")
     * })
     */
    private $numPermis;

    /**
     * @var \MyApp\UserBundle\Entity\CarteGrise
     *
     * @ORM\ManyToOne(targetEntity="MyApp\UserBundle\Entity\CarteGrise")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="carte_grise", referencedColumnName="id_carte_grise")
     * })
     */
    private $carteGrise;

    /**
     * @var \MyApp\UserBundle\Entity\SecuriteSociale
     *
     * @ORM\ManyToOne(targetEntity="MyApp\UserBundle\Entity\SecuriteSociale")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="csc", referencedColumnName="id_sc")
     * })
     */
    private $csc;

    /**
     * @var \MyApp\UserBundle\Entity\FosUser
     *
     * @ORM\ManyToOne(targetEntity="MyApp\UserBundle\Entity\FosUser")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="fos_user", referencedColumnName="id")
     * })
     */
    private $fosUser;

    /**
     * @var \MyApp\UserBundle\Entity\Ccp
     *
     * @ORM\ManyToOne(targetEntity="MyApp\UserBundle\Entity\Ccp")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="CCP", referencedColumnName="num_ccp")
     * })
     */
    private $ccp;



    /**
     * Set nom
     *
     * @param string $nom
     * @return Utilisateur
     */
    public function setNom($nom)
    {
        $this->nom = $nom;

        return $this;
    }

    /**
     * Get nom
     *
     * @return string 
     */
    public function getNom()
    {
        return $this->nom;
    }

    /**
     * Set prenom
     *
     * @param string $prenom
     * @return Utilisateur
     */
    public function setPrenom($prenom)
    {
        $this->prenom = $prenom;

        return $this;
    }

    /**
     * Get prenom
     *
     * @return string 
     */
    public function getPrenom()
    {
        return $this->prenom;
    }

    /**
     * Set type
     *
     * @param string $type
     * @return Utilisateur
     */
    public function setType($type)
    {
        $this->type = $type;

        return $this;
    }

    /**
     * Get type
     *
     * @return string 
     */
    public function getType()
    {
        return $this->type;
    }

    /**
     * Set dateNaissance
     *
     * @param \DateTime $dateNaissance
     * @return Utilisateur
     */
    public function setDateNaissance($dateNaissance)
    {
        $this->dateNaissance = $dateNaissance;

        return $this;
    }

    /**
     * Get dateNaissance
     *
     * @return \DateTime 
     */
    public function getDateNaissance()
    {
        return $this->dateNaissance;
    }

    /**
     * Set lieuNaissance
     *
     * @param string $lieuNaissance
     * @return Utilisateur
     */
    public function setLieuNaissance($lieuNaissance)
    {
        $this->lieuNaissance = $lieuNaissance;

        return $this;
    }

    /**
     * Get lieuNaissance
     *
     * @return string 
     */
    public function getLieuNaissance()
    {
        return $this->lieuNaissance;
    }

    /**
     * Set statutSocial
     *
     * @param string $statutSocial
     * @return Utilisateur
     */
    public function setStatutSocial($statutSocial)
    {
        $this->statutSocial = $statutSocial;

        return $this;
    }

    /**
     * Get statutSocial
     *
     * @return string 
     */
    public function getStatutSocial()
    {
        return $this->statutSocial;
    }

    /**
     * Set nomPere
     *
     * @param string $nomPere
     * @return Utilisateur
     */
    public function setNomPere($nomPere)
    {
        $this->nomPere = $nomPere;

        return $this;
    }

    /**
     * Get nomPere
     *
     * @return string 
     */
    public function getNomPere()
    {
        return $this->nomPere;
    }

    /**
     * Set prenomPere
     *
     * @param string $prenomPere
     * @return Utilisateur
     */
    public function setPrenomPere($prenomPere)
    {
        $this->prenomPere = $prenomPere;

        return $this;
    }

    /**
     * Get prenomPere
     *
     * @return string 
     */
    public function getPrenomPere()
    {
        return $this->prenomPere;
    }

    /**
     * Set nomMere
     *
     * @param string $nomMere
     * @return Utilisateur
     */
    public function setNomMere($nomMere)
    {
        $this->nomMere = $nomMere;

        return $this;
    }

    /**
     * Get nomMere
     *
     * @return string 
     */
    public function getNomMere()
    {
        return $this->nomMere;
    }

    /**
     * Set prenomMere
     *
     * @param string $prenomMere
     * @return Utilisateur
     */
    public function setPrenomMere($prenomMere)
    {
        $this->prenomMere = $prenomMere;

        return $this;
    }

    /**
     * Get prenomMere
     *
     * @return string 
     */
    public function getPrenomMere()
    {
        return $this->prenomMere;
    }

    /**
     * Set sexe
     *
     * @param string $sexe
     * @return Utilisateur
     */
    public function setSexe($sexe)
    {
        $this->sexe = $sexe;

        return $this;
    }

    /**
     * Get sexe
     *
     * @return string 
     */
    public function getSexe()
    {
        return $this->sexe;
    }

    /**
     * Set adresse
     *
     * @param string $adresse
     * @return Utilisateur
     */
    public function setAdresse($adresse)
    {
        $this->adresse = $adresse;

        return $this;
    }

    /**
     * Get adresse
     *
     * @return string 
     */
    public function getAdresse()
    {
        return $this->adresse;
    }

    /**
     * Set dateDelivrenceCin
     *
     * @param \DateTime $dateDelivrenceCin
     * @return Utilisateur
     */
    public function setDateDelivrenceCin($dateDelivrenceCin)
    {
        $this->dateDelivrenceCin = $dateDelivrenceCin;

        return $this;
    }

    /**
     * Get dateDelivrenceCin
     *
     * @return \DateTime 
     */
    public function getDateDelivrenceCin()
    {
        return $this->dateDelivrenceCin;
    }

    /**
     * Set photo
     *
     * @param string $photo
     * @return Utilisateur
     */
    public function setPhoto($photo)
    {
        $this->photo = $photo;

        return $this;
    }

    /**
     * Get photo
     *
     * @return string 
     */
    public function getPhoto()
    {
        return $this->photo;
    }

    /**
     * Set profession
     *
     * @param string $profession
     * @return Utilisateur
     */
    public function setProfession($profession)
    {
        $this->profession = $profession;

        return $this;
    }

    /**
     * Get profession
     *
     * @return string 
     */
    public function getProfession()
    {
        return $this->profession;
    }

    /**
     * Set empreinte
     *
     * @param string $empreinte
     * @return Utilisateur
     */
    public function setEmpreinte($empreinte)
    {
        $this->empreinte = $empreinte;

        return $this;
    }

    /**
     * Get empreinte
     *
     * @return string 
     */
    public function getEmpreinte()
    {
        return $this->empreinte;
    }

    /**
     * Set codeEmpreinte
     *
     * @param integer $codeEmpreinte
     * @return Utilisateur
     */
    public function setCodeEmpreinte($codeEmpreinte)
    {
        $this->codeEmpreinte = $codeEmpreinte;

        return $this;
    }

    /**
     * Get codeEmpreinte
     *
     * @return integer 
     */
    public function getCodeEmpreinte()
    {
        return $this->codeEmpreinte;
    }

    /**
     * Set idAgent
     *
     * @param integer $idAgent
     * @return Utilisateur
     */
    public function setIdAgent($idAgent)
    {
        $this->idAgent = $idAgent;

        return $this;
    }

    /**
     * Get idAgent
     *
     * @return integer 
     */
    public function getIdAgent()
    {
        return $this->idAgent;
    }

    /**
     * Set listesActes
     *
     * @param integer $listesActes
     * @return Utilisateur
     */
    public function setListesActes($listesActes)
    {
        $this->listesActes = $listesActes;

        return $this;
    }

    /**
     * Get listesActes
     *
     * @return integer 
     */
    public function getListesActes()
    {
        return $this->listesActes;
    }

    /**
     * Set validation
     *
     * @param integer $validation
     * @return Utilisateur
     */
    public function setValidation($validation)
    {
        $this->validation = $validation;

        return $this;
    }

    /**
     * Get validation
     *
     * @return integer 
     */
    public function getValidation()
    {
        return $this->validation;
    }

    /**
     * Set numCin
     *
     * @param string $numCin
     * @return Utilisateur
     */
    public function setNumCin($numCin)
    {
        $this->numCin = $numCin;

        return $this;
    }

    /**
     * Get numCin
     *
     * @return string 
     */
    public function getNumCin()
    {
        return $this->numCin;
    }

    /**
     * Set idUti
     *
     * @param integer $idUti
     * @return Utilisateur
     */
    public function setIdUti($idUti)
    {
        $this->idUti = $idUti;

        return $this;
    }

    /**
     * Get idUti
     *
     * @return integer 
     */
    public function getIdUti()
    {
        return $this->idUti;
    }

    /**
     * Set numPasseport
     *
     * @param \MyApp\UserBundle\Entity\Passeport $numPasseport
     * @return Utilisateur
     */
    public function setNumPasseport(\MyApp\UserBundle\Entity\Passeport $numPasseport = null)
    {
        $this->numPasseport = $numPasseport;

        return $this;
    }

    /**
     * Get numPasseport
     *
     * @return \MyApp\UserBundle\Entity\Passeport 
     */
    public function getNumPasseport()
    {
        return $this->numPasseport;
    }

    /**
     * Set numPermis
     *
     * @param \MyApp\UserBundle\Entity\Permis $numPermis
     * @return Utilisateur
     */
    public function setNumPermis(\MyApp\UserBundle\Entity\Permis $numPermis = null)
    {
        $this->numPermis = $numPermis;

        return $this;
    }

    /**
     * Get numPermis
     *
     * @return \MyApp\UserBundle\Entity\Permis 
     */
    public function getNumPermis()
    {
        return $this->numPermis;
    }

    /**
     * Set carteGrise
     *
     * @param \MyApp\UserBundle\Entity\CarteGrise $carteGrise
     * @return Utilisateur
     */
    public function setCarteGrise(\MyApp\UserBundle\Entity\CarteGrise $carteGrise = null)
    {
        $this->carteGrise = $carteGrise;

        return $this;
    }

    /**
     * Get carteGrise
     *
     * @return \MyApp\UserBundle\Entity\CarteGrise 
     */
    public function getCarteGrise()
    {
        return $this->carteGrise;
    }

    /**
     * Set csc
     *
     * @param \MyApp\UserBundle\Entity\SecuriteSociale $csc
     * @return Utilisateur
     */
    public function setCsc(\MyApp\UserBundle\Entity\SecuriteSociale $csc = null)
    {
        $this->csc = $csc;

        return $this;
    }

    /**
     * Get csc
     *
     * @return \MyApp\UserBundle\Entity\SecuriteSociale 
     */
    public function getCsc()
    {
        return $this->csc;
    }

    /**
     * Set fosUser
     *
     * @param \MyApp\UserBundle\Entity\FosUser $fosUser
     * @return Utilisateur
     */
    public function setFosUser(\MyApp\UserBundle\Entity\FosUser $fosUser = null)
    {
        $this->fosUser = $fosUser;

        return $this;
    }

    /**
     * Get fosUser
     *
     * @return \MyApp\UserBundle\Entity\FosUser 
     */
    public function getFosUser()
    {
        return $this->fosUser;
    }

    /**
     * Set ccp
     *
     * @param \MyApp\UserBundle\Entity\Ccp $ccp
     * @return Utilisateur
     */
    public function setCcp(\MyApp\UserBundle\Entity\Ccp $ccp = null)
    {
        $this->ccp = $ccp;

        return $this;
    }

    /**
     * Get ccp
     *
     * @return \MyApp\UserBundle\Entity\Ccp 
     */
    public function getCcp()
    {
        return $this->ccp;
    }
}
