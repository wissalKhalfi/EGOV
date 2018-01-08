<?php

namespace MyApp\UserBundle\Entity;

use FOS\UserBundle\Model\User as BaseUser;

use Doctrine\ORM\Mapping as ORM;

/**

* @ORM\Entity

* @ORM\Table(name="fos_user")

*/

class User extends BaseUser

{

 /**

 * @ORM\Id

 * @ORM\Column(type="integer")

 * @ORM\GeneratedValue(strategy="AUTO")

 */

 protected $id;
 /**

 * @ORM\Column(type="string",length=255)

 */
 protected $nom;
 /**

 * @ORM\Column(type="string",length=255)

 */
 protected $prenom;
 
 /**
     * @ORM\OneToOne(targetEntity="Permis" ,mappedBy="utilisateur", cascade={"persist","remove"})
     */
    private $permis;
    
    /**
     * @var \Doctrine\Common\Collections\ArrayCollection $carteGrise
     * 
     * @ORM\OneToMany(targetEntity="CarteGrise",mappedBy="utilisateur",cascade={"persist","remove"})
 
     */
    private $carteGrise;
 public function __construct()

 {

 parent::__construct();

 // your own logic

 }
 function getId() {
     return $this->id;
 }

 function getNom() {
     return $this->nom;
 }

 function getPrenom() {
     return $this->prenom;
 }

 function setId($id) {
     $this->id = $id;
 }

 function setNom($nom) {
     $this->nom = $nom;
 }

 function setPrenom($prenom) {
     $this->prenom = $prenom;
 }



    /**
     * Set permis
     *
     * @param \MyApp\UserBundle\Entity\Permis $permis
     * @return User
     */
    public function setPermis(\MyApp\UserBundle\Entity\Permis $permis = null)
    {
        $this->permis = $permis;

        return $this;
    }

    /**
     * Get permis
     *
     * @return \MyApp\UserBundle\Entity\Permis 
     */
    public function getPermis()
    {
        return $this->permis;
    }

    /**
     * Add carteGrise
     *
     * @param \MyApp\UserBundle\Entity\CarteGrise $carteGrise
     * @return User
     */
    public function addCarteGrise(\MyApp\UserBundle\Entity\CarteGrise $carteGrise)
    {
        $this->carteGrise[] = $carteGrise;

        return $this;
    }

    /**
     * Remove carteGrise
     *
     * @param \MyApp\UserBundle\Entity\CarteGrise $carteGrise
     */
    public function removeCarteGrise(\MyApp\UserBundle\Entity\CarteGrise $carteGrise)
    {
        $this->carteGrise->removeElement($carteGrise);
    }

    /**
     * Get carteGrise
     *
     * @return \Doctrine\Common\Collections\Collection 
     */
    public function getCarteGrise()
    {
        return $this->carteGrise;
    }
}
