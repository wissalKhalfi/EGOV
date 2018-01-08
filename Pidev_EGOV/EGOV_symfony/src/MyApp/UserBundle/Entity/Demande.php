<?php

namespace MyApp\UserBundle\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Demande
 *
 * @ORM\Table(name="demande", indexes={@ORM\Index(name="emetteur", columns={"emetteur"})})
 * @ORM\Entity
 */
class Demande
{
    /**
     * @var string
     *
     * @ORM\Column(name="etat", type="string", length=200, nullable=true)
     */
    private $etat;

    /**
     * @var \DateTime
     *
     * @ORM\Column(name="date_depo", type="date", nullable=true)
     */
    private $dateDepo;

    /**
     * @var string
     *
     * @ORM\Column(name="emetteur", type="string", length=8, nullable=true)
     */
    private $emetteur;

    /**
     * @var string
     *
     * @ORM\Column(name="objet", type="text", length=65535, nullable=false)
     */
    private $objet;

    /**
     * @var integer
     *
     * @ORM\Column(name="id_demande", type="integer")
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $idDemande;



    /**
     * Set etat
     *
     * @param string $etat
     * @return Demande
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
     * Set dateDepo
     *
     * @param \DateTime $dateDepo
     * @return Demande
     */
    public function setDateDepo($dateDepo)
    {
        $this->dateDepo = $dateDepo;

        return $this;
    }

    /**
     * Get dateDepo
     *
     * @return \DateTime 
     */
    public function getDateDepo()
    {
        return $this->dateDepo;
    }

    /**
     * Set emetteur
     *
     * @param string $emetteur
     * @return Demande
     */
    public function setEmetteur($emetteur)
    {
        $this->emetteur = $emetteur;

        return $this;
    }

    /**
     * Get emetteur
     *
     * @return string 
     */
    public function getEmetteur()
    {
        return $this->emetteur;
    }

    /**
     * Set objet
     *
     * @param string $objet
     * @return Demande
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
     * Get idDemande
     *
     * @return integer 
     */
    public function getIdDemande()
    {
        return $this->idDemande;
    }
}
