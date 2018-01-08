<?php

namespace MyApp\UserBundle\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Candidature
 *
 * @ORM\Table(name="candidature")
 * @ORM\Entity
 */
class Candidature
{
    /**
     * @var string
     *
     * @ORM\Column(name="etat", type="string", length=200, nullable=false)
     */
    private $etat;

    /**
     * @var string
     *
     * @ORM\Column(name="candidat", type="string", length=8, nullable=false)
     */
    private $candidat;

    /**
     * @var integer
     *
     * @ORM\Column(name="entreprise", type="integer", nullable=false)
     */
    private $entreprise;

    /**
     * @var string
     *
     * @ORM\Column(name="cv", type="string", length=250, nullable=false)
     */
    private $cv;

    /**
     * @var integer
     *
     * @ORM\Column(name="id_candidature", type="integer")
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $idCandidature;



    /**
     * Set etat
     *
     * @param string $etat
     * @return Candidature
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
     * Set candidat
     *
     * @param string $candidat
     * @return Candidature
     */
    public function setCandidat($candidat)
    {
        $this->candidat = $candidat;

        return $this;
    }

    /**
     * Get candidat
     *
     * @return string 
     */
    public function getCandidat()
    {
        return $this->candidat;
    }

    /**
     * Set entreprise
     *
     * @param integer $entreprise
     * @return Candidature
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
     * Set cv
     *
     * @param string $cv
     * @return Candidature
     */
    public function setCv($cv)
    {
        $this->cv = $cv;

        return $this;
    }

    /**
     * Get cv
     *
     * @return string 
     */
    public function getCv()
    {
        return $this->cv;
    }

    /**
     * Get idCandidature
     *
     * @return integer 
     */
    public function getIdCandidature()
    {
        return $this->idCandidature;
    }
}
