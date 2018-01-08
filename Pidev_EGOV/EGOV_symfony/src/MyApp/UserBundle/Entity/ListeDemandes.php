<?php

namespace MyApp\UserBundle\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * ListeDemandes
 *
 * @ORM\Table(name="liste_demandes", indexes={@ORM\Index(name="demande", columns={"demande"})})
 * @ORM\Entity
 */
class ListeDemandes
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
     * @var \MyApp\UserBundle\Entity\Demande
     *
     * @ORM\ManyToOne(targetEntity="MyApp\UserBundle\Entity\Demande")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="demande", referencedColumnName="id_demande")
     * })
     */
    private $demande;



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
     * Set demande
     *
     * @param \MyApp\UserBundle\Entity\Demande $demande
     * @return ListeDemandes
     */
    public function setDemande(\MyApp\UserBundle\Entity\Demande $demande = null)
    {
        $this->demande = $demande;

        return $this;
    }

    /**
     * Get demande
     *
     * @return \MyApp\UserBundle\Entity\Demande 
     */
    public function getDemande()
    {
        return $this->demande;
    }
}
