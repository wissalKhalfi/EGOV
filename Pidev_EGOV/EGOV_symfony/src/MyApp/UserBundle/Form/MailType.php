<?php
namespace MyApp\UserBundle\Form;
use Symfony\Component\Form\AbstractType; 
use Symfony\Component\Form\FormBuilderInterface; 
use Symfony\Component\OptionsResolver\OptionsResolverInterface;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Description of MailType
 *
 * @author mouad
 */
class MailType extends AbstractType 
{ 
    public function buildForm(FormBuilderInterface $builder, array $options) 
        { 
        $builder ->add('nom', 'text') 
                ->add('prenom', 'text') 
                ->add('tel', 'integer') 
                ->add('from', 'email') 
                ->add('text', 'textarea') 
                ->add('valider', 'submit') ; 
        
        }
    public function getName() 
            {
        return 'Mail'; 
        
            } 
            
            }