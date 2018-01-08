<?php

namespace MyApp\UserBundle\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * AppelOffre
 *
 * @ORM\Table(name="appel_offre", uniqueConstraints={@ORM\UniqueConstraint(name="id_appel", columns={"id_appel"})})
 * @ORM\Entity
 */
class AppelOffre
{
    /**
     * @var string
     *
     * @ORM\Column(name="objet", type="text", length=65535, nullable=true)
     */
    private $objet;

    /**
     * @var string
     *
     * @ORM\Column(name="etat", type="string", length=100, nullable=true)
     */
    private $etat;

    /**
     * @var \DateTime
     *
     * @ORM\Column(name="date_deb", type="date", nullable=true)
     */
    private $dateDeb;

    /**
     * @var \DateTime
     *
     * @ORM\Column(name="date_fin", type="date", nullable=true)
     */
    private $dateFin;

    /**
     * @var string
     *
     * @ORM\Column(name="localisation", type="string", length=100, nullable=true)
     */
    private $localisation;

    /**
     * @var string
     *
     * @ORM\Column(name="profil_demande", type="string", length=100, nullable=true)
     */
    private $profilDemande;

    /**
     * @var integer
     *
     * @ORM\Column(name="entreprise", type="integer", nullable=true)
     */
    private $entreprise;

    /**
     * @var integer
     *
     * @ORM\Column(name="id_appel", type="integer")
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $idAppel;



    /**
     * Set objet
     *
     * @param string $objet
     * @return AppelOffre
     */
    public function setObjet($objet)
    {
        $this->objet = $objet;

        return $this;
    }

    /**
     * Get objet
     *
     * @return string 
     */
    public function getObjet()
    {
        return $this->objet;
    }

    /**
     * Set etat
     *
     * @param string $etat
     * @return AppelOffre
     */
    public function setEtat($etat)
    {
        $this->etat = $etat;

        return $this;
    }

    /**
     * Get etat
     *
     * @return string 
     */
    public function getEtat()
    {
        return $this->etat;
    }

    /**
     * Set dateDeb
     *
     * @param \DateTime $dateDeb
     * @return AppelOffre
     */
    public function setDateDeb($dateDeb)
    {
        $this->dateDeb = $dateDeb;

        return $this;
    }

    /**
     * Get dateDeb
     *
     * @return \DateTime 
     */
    public function getDateDeb()
    {
        return $this->dateDeb;
    }

    /**
     * Set dateFin
     *
     * @param \DateTime $dateFin
     * @return AppelOffre
     */
    public function setDateFin($dateFin)
    {
        $this->dateFin = $dateFin;

        return $this;
    }

    /**
     * Get dateFin
     *
     * @return \DateTime 
     */
    public function getDateFin()
    {
        return $this->dateFin;
    }

    /**
     * Set localisation
     *
     * @param string $localisation
     * @return AppelOffre
     */
    public function setLocalisation($localisation)
    {
        $this->localisation = $localisation;

        return $this;
    }

    /**
     * Get localisation
     *
     * @return string 
     */
    public function getLocalisation()
    {
        return $this->localisation;
    }

    /**
     * Set profilDemande
     *
     * @param string $profilDemande
     * @return AppelOffre
     */
    public function setProfilDemande($profilDemande)
    {
        $this->profilDemande = $profilDemande;

        return $this;
    }

    /**
     * Get profilDemande
     *
     * @return string 
     */
    public function getProfilDemande()
    {
        return $this->profilDemande;
    }

    /**
     * Set entreprise
     *
     * @param integer $entreprise
     * @return AppelOffre
     */
    public function setEntreprise($entreprise)
    {
        $this->entreprise = $entreprise;

        return $this;
    }

    /**
     * Get entreprise
     *
     * @return integer 
     */
    public function getEntreprise()
    {
        return $this->entreprise;
    }

    /**
     * Get idAppel
     *
     * @return integer 
     */
    public function getIdAppel()
    {
        return $this->idAppel;
    }
}
