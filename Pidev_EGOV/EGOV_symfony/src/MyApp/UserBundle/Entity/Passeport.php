<?php

namespace MyApp\UserBundle\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Passeport
 *
 * @ORM\Table(name="passeport", uniqueConstraints={@ORM\UniqueConstraint(name="num_passeport", columns={"numPasseport"})}, indexes={@ORM\Index(name="numCinUtilisateur", columns={"numCinUtilisateur"})})
 * @ORM\Entity
 */
class Passeport
{
    /**
     * @var \DateTime
     *
     * @ORM\Column(name="dateDelivrance", type="date", nullable=false)
     */
    private $datedelivrance;

    /**
     * @var \DateTime
     *
     * @ORM\Column(name="dateValidite", type="date", nullable=false)
     */
    private $datevalidite;

    /**
     * @var string
     *
     * @ORM\Column(name="couleurYeux", type="string", length=10, nullable=true)
     */
    private $couleuryeux;

    /**
     * @var string
     *
     * @ORM\Column(name="validation", type="string", length=10, nullable=true)
     */
    private $validation;

    /**
     * @var integer
     *
     * @ORM\Column(name="numPasseport", type="integer")
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $numpasseport;

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
     * Set datedelivrance
     *
     * @param \DateTime $datedelivrance
     * @return Passeport
     */
    public function setDatedelivrance($datedelivrance)
    {
        $this->datedelivrance = $datedelivrance;

        return $this;
    }

    /**
     * Get datedelivrance
     *
     * @return \DateTime 
     */
    public function getDatedelivrance()
    {
        return $this->datedelivrance;
    }

    /**
     * Set datevalidite
     *
     * @param \DateTime $datevalidite
     * @return Passeport
     */
    public function setDatevalidite($datevalidite)
    {
        $this->datevalidite = $datevalidite;

        return $this;
    }

    /**
     * Get datevalidite
     *
     * @return \DateTime 
     */
    public function getDatevalidite()
    {
        return $this->datevalidite;
    }

    /**
     * Set couleuryeux
     *
     * @param string $couleuryeux
     * @return Passeport
     */
    public function setCouleuryeux($couleuryeux)
    {
        $this->couleuryeux = $couleuryeux;

        return $this;
    }

    /**
     * Get couleuryeux
     *
     * @return string 
     */
    public function getCouleuryeux()
    {
        return $this->couleuryeux;
    }

    /**
     * Set validation
     *
     * @param string $validation
     * @return Passeport
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
     * Get numpasseport
     *
     * @return integer 
     */
    public function getNumpasseport()
    {
        return $this->numpasseport;
    }

    /**
     * Set numcinutilisateur
     *
     * @param \MyApp\UserBundle\Entity\Utilisateur $numcinutilisateur
     * @return Passeport
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
