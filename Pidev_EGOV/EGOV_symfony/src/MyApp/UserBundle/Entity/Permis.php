<?php

namespace MyApp\UserBundle\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Permis
 *
 * @ORM\Table(name="permis")
 * @ORM\Entity
 */
class Permis
{
     /**
     * @var integer
     *
     * @ORM\Column(name="numPermis", type="integer")
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $numPermis;

    /**
     * @var \DateTime
     *
     * @ORM\Column(name="date_creation_permis", type="date", nullable=false)
     */
    private $dateCreationPermis;

    /**
     * @var string
     *
     * @ORM\Column(name="categorie_permis", type="string", length=10, nullable=false)
     */
    private $categoriePermis;

    /**
     * @var \DateTime
     *
     * @ORM\Column(name="date_validite_permis", type="date", nullable=false)
     */
    private $dateValiditePermis;
    
     /**
     * @var string
     *
     * @ORM\Column(name="validation", type="string", length=10, nullable=true)
     */
    private $validation;

   /**
     * @ORM\OneToOne(targetEntity="User" ,inversedBy="permis", cascade={"persist"})
     * @ORM\JoinColumn(name="numCinUtilisateur", referencedColumnName="id")
     */
    private $utilisateur;

    
     
   

    
   

    /**
     * Get numPermis
     *
     * @return integer 
     */
    public function getNumPermis()
    {
        return $this->numPermis;
    }

    /**
     * Set dateCreationPermis
     *
     * @param \DateTime $dateCreationPermis
     * @return Permis
     */
    public function setDateCreationPermis($dateCreationPermis)
    {
        $this->dateCreationPermis = $dateCreationPermis;

        return $this;
    }

    /**
     * Get dateCreationPermis
     *
     * @return \DateTime 
     */
    public function getDateCreationPermis()
    {
        return $this->dateCreationPermis;
    }

    /**
     * Set categoriePermis
     *
     * @param string $categoriePermis
     * @return Permis
     */
    public function setCategoriePermis($categoriePermis)
    {
        $this->categoriePermis = $categoriePermis;

        return $this;
    }

    /**
     * Get categoriePermis
     *
     * @return string 
     */
    public function getCategoriePermis()
    {
        return $this->categoriePermis;
    }

    /**
     * Set dateValiditePermis
     *
     * @param \DateTime $dateValiditePermis
     * @return Permis
     */
    public function setDateValiditePermis($dateValiditePermis)
    {
        $this->dateValiditePermis = $dateValiditePermis;

        return $this;
    }

    /**
     * Get dateValiditePermis
     *
     * @return \DateTime 
     */
    public function getDateValiditePermis()
    {
        return $this->dateValiditePermis;
    }

    /**
     * Set validation
     *
     * @param string $validation
     * @return Permis
     */
    public function setValidation($validation)
    {
        $this->validation = $validation;

        return $this;
    }

    /**
     * Get validation
     *
     * @return string 
     */
    public function getValidation()
    {
        return $this->validation;
    }

    /**
     * Set utilisateur
     *
     * @param \MyApp\UserBundle\Entity\User $utilisateur
     * @return Permis
     */
    public function setUtilisateur(\MyApp\UserBundle\Entity\User $utilisateur = null)
    {
        $this->utilisateur = $utilisateur;

        return $this;
    }

    /**
     * Get utilisateur
     *
     * @return \MyApp\UserBundle\Entity\User 
     */
    public function getUtilisateur()
    {
        return $this->utilisateur;
    }
}
