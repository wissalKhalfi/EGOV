<?php

namespace MyApp\UserBundle\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Contratmariage
 *
 * @ORM\Table(name="contratmariage", uniqueConstraints={@ORM\UniqueConstraint(name="UNIQ_A4262E4D65FBE7C7", columns={"numCinUtilisateur"})})
 * @ORM\Entity
 */
class Contratmariage
{
    /**
     * @var \DateTime
     *
     * @ORM\Column(name="date_mariage", type="date", nullable=false)
     */
    private $dateMariage;

    /**
     * @var string
     *
     * @ORM\Column(name="id_epoux", type="string", length=10, nullable=true)
     */
    private $idEpoux;

    /**
     * @var string
     *
     * @ORM\Column(name="id_epouse", type="string", length=10, nullable=true)
     */
    private $idEpouse;

    /**
     * @var string
     *
     * @ORM\Column(name="validation", type="string", length=10, nullable=true)
     */
    private $validation;

    /**
     * @var integer
     *
     * @ORM\Column(name="id_contrat", type="integer")
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $idContrat;

    /**
     * @var \MyApp\UserBundle\Entity\Utilisateur
     *
     * @ORM\ManyToOne(targetEntity="MyApp\UserBundle\Entity\Utilisateur")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="numCinUtilisateur", referencedColumnName="id_uti")
     * })
     */
    private $numcinutilisateur;



    /**
     * Set dateMariage
     *
     * @param \DateTime $dateMariage
     * @return Contratmariage
     */
    public function setDateMariage($dateMariage)
    {
        $this->dateMariage = $dateMariage;

        return $this;
    }

    /**
     * Get dateMariage
     *
     * @return \DateTime 
     */
    public function getDateMariage()
    {
        return $this->dateMariage;
    }

    /**
     * Set idEpoux
     *
     * @param string $idEpoux
     * @return Contratmariage
     */
    public function setIdEpoux($idEpoux)
    {
        $this->idEpoux = $idEpoux;

        return $this;
    }

    /**
     * Get idEpoux
     *
     * @return string 
     */
    public function getIdEpoux()
    {
        return $this->idEpoux;
    }

    /**
     * Set idEpouse
     *
     * @param string $idEpouse
     * @return Contratmariage
     */
    public function setIdEpouse($idEpouse)
    {
        $this->idEpouse = $idEpouse;

        return $this;
    }

    /**
     * Get idEpouse
     *
     * @return string 
     */
    public function getIdEpouse()
    {
        return $this->idEpouse;
    }

    /**
     * Set validation
     *
     * @param string $validation
     * @return Contratmariage
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
     * Get idContrat
     *
     * @return integer 
     */
    public function getIdContrat()
    {
        return $this->idContrat;
    }

    /**
     * Set numcinutilisateur
     *
     * @param \MyApp\UserBundle\Entity\Utilisateur $numcinutilisateur
     * @return Contratmariage
     */
    public function setNumcinutilisateur(\MyApp\UserBundle\Entity\Utilisateur $numcinutilisateur = null)
    {
        $this->numcinutilisateur = $numcinutilisateur;

        return $this;
    }

    /**
     * Get numcinutilisateur
     *
     * @return \MyApp\UserBundle\Entity\Utilisateur 
     */
    public function getNumcinutilisateur()
    {
        return $this->numcinutilisateur;
    }
}
