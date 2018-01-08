<?php

namespace MyApp\UserBundle\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * CarteGrise
 *
 * @ORM\Table(name="carte_grise")
 * @ORM\Entity
 */
class CarteGrise
{
     /**
     * @var integer
     *
     * @ORM\Column(name="id_carte_grise", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $idCarteGrise;

    /**
     * @var string
     *
     * @ORM\Column(name="marque_vehicule", type="string", length=20, nullable=false)
     */
    private $marqueVehicule;

    /**
     * @var string
     *
     * @ORM\Column(name="num_serie_vehicule", type="string", length=9, nullable=false)
     */
    private $numSerieVehicule;

    /**
     * @var string
     *
     * @ORM\Column(name="type_vehicule", type="string", length=20, nullable=false)
     */
    private $typeVehicule;

    /**
     * @var \DateTime
     *
     * @ORM\Column(name="date_achat_vehicule", type="date", nullable=false)
     */
    private $dateAchatVehicule;

    /**
     * @var string
     *
     * @ORM\Column(name="couleur_vehicue", type="string", length=20, nullable=false)
     */
    private $couleurVehicue;
    
     /**
     * @var string
     *
     * @ORM\Column(name="validation", type="string", length=10, nullable=true)
     */
    private $validation;
    
    
    
    /**
    * @ORM\ManyToOne(targetEntity="User", inversedBy="carteGrise" )
    * @ORM\JoinColumn(name="num_cinUtilisateur", referencedColumnName="id")
    */
    private $utilisateur;


   

  

    /**
     * Get idCarteGrise
     *
     * @return integer 
     */
    public function getIdCarteGrise()
    {
        return $this->idCarteGrise;
    }

    /**
     * Set marqueVehicule
     *
     * @param string $marqueVehicule
     * @return CarteGrise
     */
    public function setMarqueVehicule($marqueVehicule)
    {
        $this->marqueVehicule = $marqueVehicule;

        return $this;
    }

    /**
     * Get marqueVehicule
     *
     * @return string 
     */
    public function getMarqueVehicule()
    {
        return $this->marqueVehicule;
    }

    /**
     * Set numSerieVehicule
     *
     * @param string $numSerieVehicule
     * @return CarteGrise
     */
    public function setNumSerieVehicule($numSerieVehicule)
    {
        $this->numSerieVehicule = $numSerieVehicule;

        return $this;
    }

    /**
     * Get numSerieVehicule
     *
     * @return string 
     */
    public function getNumSerieVehicule()
    {
        return $this->numSerieVehicule;
    }

    /**
     * Set typeVehicule
     *
     * @param string $typeVehicule
     * @return CarteGrise
     */
    public function setTypeVehicule($typeVehicule)
    {
        $this->typeVehicule = $typeVehicule;

        return $this;
    }

    /**
     * Get typeVehicule
     *
     * @return string 
     */
    public function getTypeVehicule()
    {
        return $this->typeVehicule;
    }

    /**
     * Set dateAchatVehicule
     *
     * @param \DateTime $dateAchatVehicule
     * @return CarteGrise
     */
    public function setDateAchatVehicule($dateAchatVehicule)
    {
        $this->dateAchatVehicule = $dateAchatVehicule;

        return $this;
    }

    /**
     * Get dateAchatVehicule
     *
     * @return \DateTime 
     */
    public function getDateAchatVehicule()
    {
        return $this->dateAchatVehicule;
    }

    /**
     * Set couleurVehicue
     *
     * @param string $couleurVehicue
     * @return CarteGrise
     */
    public function setCouleurVehicue($couleurVehicue)
    {
        $this->couleurVehicue = $couleurVehicue;

        return $this;
    }

    /**
     * Get couleurVehicue
     *
     * @return string 
     */
    public function getCouleurVehicue()
    {
        return $this->couleurVehicue;
    }

    /**
     * Set validation
     *
     * @param string $validation
     * @return CarteGrise
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
     * @return CarteGrise
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
