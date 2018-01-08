<?php

namespace MyApp\UserBundle\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Entreprise
 *
 * @ORM\Table(name="entreprise")
 * @ORM\Entity
 */
class Entreprise
{
    /**
     * @var string
     *
     * @ORM\Column(name="adresse", type="string", length=200, nullable=true)
     */
    private $adresse;

    /**
     * @var string
     *
     * @ORM\Column(name="nom", type="string", length=200, nullable=true)
     */
    private $nom;

    /**
     * @var string
     *
     * @ORM\Column(name="email", type="string", length=200, nullable=true)
     */
    private $email;

    /**
     * @var string
     *
     * @ORM\Column(name="pwd_entreprise", type="string", length=50, nullable=false)
     */
    private $pwdEntreprise;

    /**
     * @var integer
     *
     * @ORM\Column(name="code_fiscal", type="integer")
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $codeFiscal;



    /**
     * Set adresse
     *
     * @param string $adresse
     * @return Entreprise
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
     * Set nom
     *
     * @param string $nom
     * @return Entreprise
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
     * Set email
     *
     * @param string $email
     * @return Entreprise
     */
    public function setEmail($email)
    {
        $this->email = $email;

        return $this;
    }

    /**
     * Get email
     *
     * @return string 
     */
    public function getEmail()
    {
        return $this->email;
    }

    /**
     * Set pwdEntreprise
     *
     * @param string $pwdEntreprise
     * @return Entreprise
     */
    public function setPwdEntreprise($pwdEntreprise)
    {
        $this->pwdEntreprise = $pwdEntreprise;

        return $this;
    }

    /**
     * Get pwdEntreprise
     *
     * @return string 
     */
    public function getPwdEntreprise()
    {
        return $this->pwdEntreprise;
    }

    /**
     * Get codeFiscal
     *
     * @return integer 
     */
    public function getCodeFiscal()
    {
        return $this->codeFiscal;
    }
}
