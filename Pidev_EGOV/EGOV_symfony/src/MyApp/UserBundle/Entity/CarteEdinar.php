<?php

namespace MyApp\UserBundle\Entity;

use Doctrine\ORM\Mapping as ORM;
use Symfony\Component\Validator\Constraint as Assert;

/**
 * CarteEdinar
 *
 * @ORM\Table(name="carte_edinar")
 * @ORM\Entity
 */
class CarteEdinar {

    /**
     * Assert\NotBlank()
     * @var integer
     *
     * @ORM\Column(name="num_carte", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $numCarte;

    /**
     * Assert\NotBlank()
     * @var integer
     * @ORM\Column(name="code_carte", type="integer", nullable=false)
     */
    private $codeCarte;

    /**
     * @var integer
     *
     * @ORM\Column(name="solde_actuel", type="integer", nullable=true)
     */
    private $soldeActuel;

    /**
     * @var \DateTime
     *
     * @ORM\Column(name="date_dernier_retirement", type="date", nullable=true)
     */
    private $dateDernierRetirement;

    /**
     * @var integer
     *
     * @ORM\Column(name="dernier_retirement", type="integer", nullable=true)
     */
    private $dernierRetirement;

    /**
     * @var \DateTime
     *
     * @ORM\Column(name="date_creation", type="date", nullable=true)
     */
    private $dateCreation;

    /**
     * @var \DateTime
     *
     * @ORM\Column(name="date_dernier_versement", type="date", nullable=true)
     */
    private $dateDernierVersement;

    /**
     * @var integer
     *
     * @ORM\Column(name="dernier_versement", type="integer", nullable=true)
     */
    private $dernierVersement;

    /**
     * @var integer
     *
     * @ORM\Column(name="validator_creation", type="integer", nullable=true)
     */
    private $validator_creation;

    /**
     * @var integer
     *
     * @ORM\Column(name="validator_recuperation", type="integer", nullable=true)
     */
    private $validator_recuperation;

    /**
     * @var integer
     *
     * @ORM\Column(name="validator_changement", type="integer", nullable=true)
     */
    private $validator_changement;

    /**
     * @var integer
     *
     * @ORM\Column(name="validator_renouvellement", type="integer", nullable=true)
     */
    private $validator_renouvellement;

    /**
     * @var integer
     *
     * @ORM\Column(name="validator_blockage", type="integer", nullable=true)
     */
    private $validator_blockage;

    /**
     * @var integer
     *
     * @ORM\Column(name="validator_deblockage", type="integer", nullable=true)
     */
    private $validator_deblockage;

    /**
     * @var string
     *
     * @ORM\Column(name="reponseq1", type="string", length=30, nullable=true)
     */
    private $reponseq1;

    /**
     * @var string
     *
     * @ORM\Column(name="reponseq2", type="string", length=30, nullable=true)
     */
    private $reponseq2;

    /**
     * @var string
     *
     * @ORM\Column(name="reponseq3", type="string", length=30, nullable=true)
     */
    private $reponseq3;

    /**
     * Get numCarte
     *
     * @return string 
     */
    public function getNumCarte() {
        return $this->numCarte;
    }

    /**
     * Set codeCarte
     *
     * @param integer $codeCarte
     * @return CarteEdinar
     */
    public function setCodeCarte($codeCarte) {
        $this->codeCarte = $codeCarte;

        return $this;
    }

    /**
     * Get codeCarte
     *
     * @return integer 
     */
    public function getCodeCarte() {
        return $this->codeCarte;
    }

    /**
     * Set soldeActuel
     *
     * @param integer $soldeActuel
     * @return CarteEdinar
     */
    public function setSoldeActuel($soldeActuel) {
        $this->soldeActuel = $soldeActuel;

        return $this;
    }

    /**
     * Get soldeActuel
     *
     * @return integer 
     */
    public function getSoldeActuel() {
        return $this->soldeActuel;
    }

    /**
     * Set dateDernierRetirement
     *
     * @param \DateTime $dateDernierRetirement
     * @return CarteEdinar
     */
    public function setDateDernierRetirement($dateDernierRetirement) {
        $this->dateDernierRetirement = $dateDernierRetirement;

        return $this;
    }

    /**
     * Get dateDernierRetirement
     *
     * @return \DateTime 
     */
    public function getDateDernierRetirement() {
        return $this->dateDernierRetirement;
    }

    /**
     * Set dernierRetirement
     *
     * @param integer $dernierRetirement
     * @return CarteEdinar
     */
    public function setDernierRetirement($dernierRetirement) {
        $this->dernierRetirement = $dernierRetirement;

        return $this;
    }

    /**
     * Get dernierRetirement
     *
     * @return integer 
     */
    public function getDernierRetirement() {
        return $this->dernierRetirement;
    }

    /**
     * Set dateCreation
     *
     * @param \DateTime $dateCreation
     * @return CarteEdinar
     */
    public function setDateCreation($dateCreation) {
        $this->dateCreation = $dateCreation;

        return $this;
    }

    /**
     * Get dateCreation
     *
     * @return \DateTime 
     */
    public function getDateCreation() {
        return $this->dateCreation;
    }

    /**
     * Set dateDernierVersement
     *
     * @param \DateTime $dateDernierVersement
     * @return CarteEdinar
     */
    public function setDateDernierVersement($dateDernierVersement) {
        $this->dateDernierVersement = $dateDernierVersement;

        return $this;
    }

    /**
     * Get dateDernierVersement
     *
     * @return \DateTime 
     */
    public function getDateDernierVersement() {
        return $this->dateDernierVersement;
    }

    /**
     * Set dernierVersement
     *
     * @param integer $dernierVersement
     * @return CarteEdinar
     */
    public function setDernierVersement($dernierVersement) {
        $this->dernierVersement = $dernierVersement;

        return $this;
    }

    /**
     * Get dernierVersement
     *
     * @return integer 
     */
    public function getDernierVersement() {
        return $this->dernierVersement;
    }

    /**
     * Set validator_creation
     *
     * @param integer $validator_creation
     * @return CarteEdinar
     */
    public function setValidatorCreation($validator_creation) {
        $this->validator_creation = $validator_creation;

        return $this;
    }

    /**
     * Get validator_creation
     *
     * @return integer 
     */
    public function getValidatorCreation() {
        return $this->validator_creation;
    }

    /**
     * Set validator_recuperation
     *
     * @param integer $validator_recuperation
     * @return CarteEdinar
     */
    public function setValidatorRecuperation($validator_recuperation) {
        $this->validator_recuperation = $validator_recuperation;

        return $this;
    }

    /**
     * Get validator_recuperation
     *
     * @return integer 
     */
    public function getValidatorRecuperation() {
        return $this->validator_recuperation;
    }

    /**
     * Set validator_changement
     *
     * @param integer $validator_changement
     * @return CarteEdinar
     */
    public function setValidatorChangement($validator_changement) {
        $this->validator_changement = $validator_changement;

        return $this;
    }

    /**
     * Get validator_changement
     *
     * @return integer 
     */
    public function getValidatorChangement() {
        return $this->validator_changement;
    }

    /**
     * Set validator_renouvellement
     *
     * @param integer $validator_renouvellement
     * @return CarteEdinar
     */
    public function setValidatorRenouvellement($validator_renouvellement) {
        $this->validator_renouvellement = $validator_renouvellement;

        return $this;
    }

    /**
     * Get validator_renouvellement
     *
     * @return integer 
     */
    public function getValidatorRenouvellement() {
        return $this->validator_renouvellement;
    }

    /**
     * Set validator_blockage
     *
     * @param integer $validator_blockage
     * @return CarteEdinar
     */
    public function setValidatorBlockage($validator_blockage) {
        $this->validator_blockage = $validator_blockage;

        return $this;
    }

    /**
     * Get validator_blockage
     *
     * @return integer 
     */
    public function getValidatorBlockage() {
        return $this->validator_blockage;
    }

    /**
     * Set validator_deblockage
     *
     * @param integer $validator_deblockage
     * @return CarteEdinar
     */
    public function setValidatorDeblockage($validator_deblockage) {
        $this->validator_deblockage = $validator_deblockage;

        return $this;
    }

    /**
     * Get validator_deblockage
     *
     * @return integer 
     */
    public function getValidatorDeblockage() {
        return $this->validator_deblockage;
    }

    /**
     * Set reponseq1
     *
     * @param string $reponseq1
     * @return CarteEdinar
     */
    public function setReponseq1($reponseq1) {
        $this->reponseq1 = $reponseq1;

        return $this;
    }

    /**
     * Get reponseq1
     *
     * @return string 
     */
    public function getReponseq1() {
        return $this->reponseq1;
    }
     /**
     * Set reponseq2
     *
     * @param string $reponseq2
     * @return CarteEdinar
     */
    public function setReponseq2($reponseq2) {
        $this->reponseq2 = $reponseq2;

        return $this;
    }

    /**
     * Get reponseq2
     *
     * @return string 
     */
    public function getReponseq2() {
        return $this->reponseq2;
    }
        /**
     * Set reponseq3
     *
     * @param string $reponseq3
     * @return CarteEdinar
     */
    public function setReponseq3($reponseq3) {
        $this->reponseq3 = $reponseq3;

        return $this;
    }

    /**
     * Get reponseq3
     *
     * @return string 
     */
    public function getReponseq3() {
        return $this->reponseq3;
    }
}
