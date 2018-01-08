<?php

namespace MyApp\UserBundle\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * ActesJuridiques
 *
 * @ORM\Table(name="actes_juridiques")
 * @ORM\Entity
 */
class ActesJuridiques
{
    /**
     * @var string
     *
     * @ORM\Column(name="titre_acte", type="string", length=100, nullable=true)
     */
    private $titreActe;

    /**
     * @var \DateTime
     *
     * @ORM\Column(name="date_acte", type="date", nullable=true)
     */
    private $dateActe;

    /**
     * @var string
     *
     * @ORM\Column(name="desc_acte", type="text", length=65535, nullable=true)
     */
    private $descActe;

    /**
     * @var integer
     *
     * @ORM\Column(name="id_acte", type="integer")
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $idActe;



    /**
     * Set titreActe
     *
     * @param string $titreActe
     * @return ActesJuridiques
     */
    public function setTitreActe($titreActe)
    {
        $this->titreActe = $titreActe;

        return $this;
    }

    /**
     * Get titreActe
     *
     * @return string 
     */
    public function getTitreActe()
    {
        return $this->titreActe;
    }

    /**
     * Set dateActe
     *
     * @param \DateTime $dateActe
     * @return ActesJuridiques
     */
    public function setDateActe($dateActe)
    {
        $this->dateActe = $dateActe;

        return $this;
    }

    /**
     * Get dateActe
     *
     * @return \DateTime 
     */
    public function getDateActe()
    {
        return $this->dateActe;
    }

    /**
     * Set descActe
     *
     * @param string $descActe
     * @return ActesJuridiques
     */
    public function setDescActe($descActe)
    {
        $this->descActe = $descActe;

        return $this;
    }

    /**
     * Get descActe
     *
     * @return string 
     */
    public function getDescActe()
    {
        return $this->descActe;
    }

    /**
     * Get idActe
     *
     * @return integer 
     */
    public function getIdActe()
    {
        return $this->idActe;
    }
}
