<?php

namespace MyApp\UserBundle\Entity;
use Symfony\Component\Validator\Constraints as Assert;
use Doctrine\ORM\Mapping as ORM;
use FOS\CommentBundle\Model\Comment as BaseComment;
/**
 * Articles
 *
 * @ORM\Table(name="articles")
 * @ORM\Entity
 */
class Articles extends BaseComment
{
    /**
     * @var integer
     *
     * @ORM\Column(name="id_article", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $idArticle;

    /**
     * @var string
     *
     * @ORM\Column(name="titre_article", type="string", length=20, nullable=false)
     */
    private $titreArticle;

    /**
     * @var \DateTime
     *
     * @ORM\Column(name="date_article", type="date", nullable=false)
     */
    private $dateArticle;

    /**
     * @var string
     *
     * @ORM\Column(name="image_article", type="blob", length=65535, nullable=true)
     */
    private $imageArticle;

    /**
     * @var string
     *
     * @ORM\Column(name="texte_article", type="text", length=65535, nullable=false)
     */
    private $texteArticle;

    /**
     * @var integer
     *
     * @ORM\Column(name="priorite_pub", type="integer", nullable=false)
     */
    private $prioritePub;
    
    /**
     * @var integer
     *
     * @ORM\Column(name="type", type="string", nullable=false)
     */
    private $type;
    /** 
     * 
     * @Assert\File(maxSize="6000000") 
     * 
     */
     private $file;

 

    /**
     * Get idArticle
     *
     * @return integer 
     */
    public function getIdArticle()
    {
        return $this->idArticle;
    }

    /**
     * Set titreArticle
     *
     * @param string $titreArticle
     * @return Articles
     */
    public function setTitreArticle($titreArticle)
    {
        $this->titreArticle = $titreArticle;

        return $this;
    }

    /**
     * Get titreArticle
     *
     * @return string 
     */
    public function getTitreArticle()
    {
        return $this->titreArticle;
    }

    /**
     * Set dateArticle
     *
     * @param \DateTime $dateArticle
     * @return Articles
     */
    public function setDateArticle($dateArticle)
    {
        $this->dateArticle = $dateArticle;

        return $this;
    }

    /**
     * Get dateArticle
     *
     * @return \DateTime 
     */
    public function getDateArticle()
    {
        return $this->dateArticle;
    }

    /**
     * Set imageArticle
     *
     * @param string $imageArticle
     * @return Articles
     */
    public function setImageArticle($imageArticle)
    {
        $this->imageArticle = $imageArticle;

        return $this;
    }

    /**
     * Get imageArticle
     *
     * @return string 
     */
    public function getImageArticle()
    {
        return $this->imageArticle;
    }

    /**
     * Set texteArticle
     *
     * @param string $texteArticle
     * @return Articles
     */
    public function setTexteArticle($texteArticle)
    {
        $this->texteArticle = $texteArticle;

        return $this;
    }

    /**
     * Get texteArticle
     *
     * @return string 
     */
    public function getTexteArticle()
    {
        return $this->texteArticle;
    }

    /**
     * Set prioritePub
     *
     * @param integer $prioritePub
     * @return Articles
     */
    public function setPrioritePub($prioritePub)
    {
        $this->prioritePub = $prioritePub;

        return $this;
    }

    /**
     * Get prioritePub
     *
     * @return integer 
     */
    public function getPrioritePub()
    {
        return $this->prioritePub;
    }
    
    /**
     * Set type
     *
     * @param string $type
     * @return Articles
     */
    public function setType($type)
    {
        $this->type = $type;

        return $this;
    }

    /**
     * Get type
     *
     * @return string 
     */
    public function getType()
    {
        return $this->type;
    }
     
    public function setFile($file)
    {
        $this->file = $file;
     
        return $this;
    }
 
 
    public function getFile()
    {
        return $this->file;
    }
   
    
}
