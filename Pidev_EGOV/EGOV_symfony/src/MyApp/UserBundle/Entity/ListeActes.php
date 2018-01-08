<?php

namespace MyApp\UserBundle\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * ListeActes
 *
 * @ORM\Table(name="liste_actes", indexes={@ORM\Index(name="citoyen", columns={"citoyen"}), @ORM\Index(name="acte", columns={"acte"})})
 * @ORM\Entity
 */
class ListeActes
{
    /**
     * @var integer
     *
     * @ORM\Column(name="id", type="integer")
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $id;

    /**
     * @var \MyApp\UserBundle\Entity\Utilisateur
     *
     * @ORM\ManyToOne(targetEntity="MyApp\UserBundle\Entity\Utilisateur")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="citoyen", referencedColumnName="num_cin")
     * })
     */
    private $citoyen;

    /**
     * @var \MyApp\UserBundle\Entity\ActesJuridiques
     *
     * @ORM\ManyToOne(targetEntity="MyApp\UserBundle\Entity\ActesJuridiques")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="acte", referencedColumnName="id_acte")
     * })
     */
    private $acte;



    /**
     * Get id
     *
     * @return integer 
     */
    public function getId()
    {
        return $this->id;
    }

    /**
     * Set citoyen
     *
     * @param \MyApp\UserBundle\Entity\Utilisateur $citoyen
     * @return ListeActes
     */
    public function setCitoyen(\MyApp\UserBundle\Entity\Utilisateur $citoyen = null)
    {
        $this->citoyen = $citoyen;

        return $this;
    }

    /**
     * Get citoyen
     *
     * @return \MyApp\UserBundle\Entity\Utilisateur 
     */
    public function getCitoyen()
    {
        return $this->citoyen;
    }

    /**
     * Set acte
     *
     * @param \MyApp\UserBundle\Entity\ActesJuridiques $acte
     * @return ListeActes
     */
    public function setActe(\MyApp\UserBundle\Entity\ActesJuridiques $acte = null)
    {
        $this->acte = $acte;

        return $this;
    }

    /**
     * Get acte
     *
     * @return \MyApp\UserBundle\Entity\ActesJuridiques 
     */
    public function getActe()
    {
        return $this->acte;
    }
}
