<?php

// src/Esprit/CommentBundle /Entity/Comment.php

namespace MyApp\UserBundle\Entity;

use Doctrine\ORM\Mapping as ORM;

use FOS\CommentBundle\Entity\Comment as BaseComment;

/**

* @ORM\Entity

* @ORM\ChangeTrackingPolicy("DEFERRED_EXPLICIT")

*/

class Comment extends BaseComment

{

 /**

 * @ORM\Id

 * @ORM\Column(type="integer")

 * @ORM\GeneratedValue(strategy="AUTO")

 */

 protected $id;

 /**

 * Thread of this comment

 *

 * @var Thread

 * @ORM\ManyToOne(targetEntity="MyApp\UserBundle\Entity\Thread")

 */

 protected $thread;

}