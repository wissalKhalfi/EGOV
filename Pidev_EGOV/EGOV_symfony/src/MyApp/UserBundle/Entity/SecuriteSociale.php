<?php

namespace MyApp\UserBundle\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * SecuriteSociale
 *
 * @ORM\Table(name="securite_sociale", uniqueConstraints={@ORM\UniqueConstraint(name="id_sc", columns={"id_sc"}), @ORM\UniqueConstraint(name="proprietaire_2", columns={"proprietaire"}), @ORM\UniqueConstraint(name="conjoint_2", columns={"conjoint"})}, indexes={@ORM\Index(name="proprietaire", columns={"proprietaire"}), @ORM\Index(name="conjoint", columns={"conjoint"})})
 * @ORM\Entity
 */
class SecuriteSociale
{
    /**
     * @var string
     *
     * @ORM\Column(name="proprietaire", type="string", length=8, nullable=false)
     */
    private $proprietaire;

    /**
     * @var string
     *
     * @ORM\Column(name="conjoint", type="string", length=8, nullable=false)
     */
    private $conjoint;

    /**
     * @var integer
     *
     * @ORM\Column(name="nbre_enfants", type="integer", nullable=false)
     */
    private $nbreEnfants;

    /**
     * @var string
     *
     * @ORM\Column(name="enfant1", type="string", length=30, nullable=false)
     */
    private $enfant1;

    /**
     * @var string
     *
     * @ORM\Column(name="enfant2", type="string", length=30, nullable=false)
     */
    private $enfant2;

    /**
     * @var string
     *
     * @ORM\Column(name="enfant3", type="string", length=30, nullable=false)
     */
    private $enfant3;

    /**
     * @var string
     *
     * @ORM\Column(name="enfant4", type="string", length=30, nullable=false)
     */
    private $enfant4;

    /**
     * @var string
     *
     * @ORM\Column(name="Enfant5", type="string", length=30, nullable=false)
     */
    private $enfant5;

    /**
     * @var string
     *
     * @ORM\Column(name="enfant6", type="string", length=30, nullable=false)
     */
    private $enfant6;

    /**
     * @var \DateTime
     *
     * @ORM\Column(name="date_delivrence_csc", type="date", nullable=false)
     */
    private $dateDelivrenceCsc;

    /**
     * @var \DateTime
     *
     * @ORM\Column(name="date_validite_csc", type="date", nullable=false)
     */
    private $dateValiditeCsc;

    /**
     * @var string
     *
     * @ORM\Column(name="regime", type="string", length=20, nullable=false)
     */
    private $regime;

    /**
     * @var integer
     *
     * @ORM\Column(name="id_sc", type="integer")
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $idSc;



    /**
     * Set proprietaire
     *
     * @param string $proprietaire
     * @return SecuriteSociale
     */
    public function setProprietaire($proprietaire)
    {
        $this->proprietaire = $proprietaire;

        return $this;
    }

    /**
     * Get proprietaire
     *
     * @return string 
     */
    public function getProprietaire()
    {
        return $this->proprietaire;
    }

    /**
     * Set conjoint
     *
     * @param string $conjoint
     * @return SecuriteSociale
     */
    public function setConjoint($conjoint)
    {
        $this->conjoint = $conjoint;

        return $this;
    }

    /**
     * Get conjoint
     *
     * @return string 
     */
    public function getConjoint()
    {
        return $this->conjoint;
    }

    /**
     * Set nbreEnfants
     *
     * @param integer $nbreEnfants
     * @return SecuriteSociale
     */
    public function setNbreEnfants($nbreEnfants)
    {
        $this->nbreEnfants = $nbreEnfants;

        return $this;
    }

    /**
     * Get nbreEnfants
     *
     * @return integer 
     */
    public function getNbreEnfants()
    {
        return $this->nbreEnfants;
    }

    /**
     * Set enfant1
     *
     * @param string $enfant1
     * @return SecuriteSociale
     */
    public function setEnfant1($enfant1)
    {
        $this->enfant1 = $enfant1;

        return $this;
    }

    /**
     * Get enfant1
     *
     * @return string 
     */
    public function getEnfant1()
    {
        return $this->enfant1;
    }

    /**
     * Set enfant2
     *
     * @param string $enfant2
     * @return SecuriteSociale
     */
    public function setEnfant2($enfant2)
    {
        $this->enfant2 = $enfant2;

        return $this;
    }

    /**
     * Get enfant2
     *
     * @return string 
     */
    public function getEnfant2()
    {
        return $this->enfant2;
    }

    /**
     * Set enfant3
     *
     * @param string $enfant3
     * @return SecuriteSociale
     */
    public function setEnfant3($enfant3)
    {
        $this->enfant3 = $enfant3;

        return $this;
    }

    /**
     * Get enfant3
     *
     * @return string 
     */
    public function getEnfant3()
    {
        return $this->enfant3;
    }

    /**
     * Set enfant4
     *
     * @param string $enfant4
     * @return SecuriteSociale
     */
    public function setEnfant4($enfant4)
    {
        $this->enfant4 = $enfant4;

        return $this;
    }

    /**
     * Get enfant4
     *
     * @return string 
     */
    public function getEnfant4()
    {
        return $this->enfant4;
    }

    /**
     * Set enfant5
     *
     * @param string $enfant5
     * @return SecuriteSociale
     */
    public function setEnfant5($enfant5)
    {
        $this->enfant5 = $enfant5;

        return $this;
    }

    /**
     * Get enfant5
     *
     * @return string 
     */
    public function getEnfant5()
    {
        return $this->enfant5;
    }

    /**
     * Set enfant6
     *
     * @param string $enfant6
     * @return SecuriteSociale
     */
    public function setEnfant6($enfant6)
    {
        $this->enfant6 = $enfant6;

        return $this;
    }

    /**
     * Get enfant6
     *
     * @return string 
     */
    public function getEnfant6()
    {
        return $this->enfant6;
    }

    /**
     * Set dateDelivrenceCsc
     *
     * @param \DateTime $dateDelivrenceCsc
     * @return SecuriteSociale
     */
    public function setDateDelivrenceCsc($dateDelivrenceCsc)
    {
        $this->dateDelivrenceCsc = $dateDelivrenceCsc;

        return $this;
    }

    /**
     * Get dateDelivrenceCsc
     *
     * @return \DateTime 
     */
    public function getDateDelivrenceCsc()
    {
        return $this->dateDelivrenceCsc;
    }

    /**
     * Set dateValiditeCsc
     *
     * @param \DateTime $dateValiditeCsc
     * @return SecuriteSociale
     */
    public function setDateValiditeCsc($dateValiditeCsc)
    {
        $this->dateValiditeCsc = $dateValiditeCsc;

        return $this;
    }

    /**
     * Get dateValiditeCsc
     *
     * @return \DateTime 
     */
    public function getDateValiditeCsc()
    {
        return $this->dateValiditeCsc;
    }

    /**
     * Set regime
     *
     * @param string $regime
     * @return SecuriteSociale
     */
    public function setRegime($regime)
    {
        $this->regime = $regime;

        return $this;
    }

    /**
     * Get regime
     *
     * @return string 
     */
    public function getRegime()
    {
        return $this->regime;
    }

    /**
     * Get idSc
     *
     * @return integer 
     */
    public function getIdSc()
    {
        return $this->idSc;
    }
}
