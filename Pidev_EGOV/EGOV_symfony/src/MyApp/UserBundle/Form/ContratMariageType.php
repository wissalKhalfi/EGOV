<?php

namespace EGOV\UserBundle\Form;

use Symfony\Component\Form\AbstractType;
use Symfony\Component\Form\FormBuilderInterface;
use Symfony\Component\OptionsResolver\OptionsResolverInterface;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Description of ContratMariageType
 *
 * @author boumaiza
 */
class ContratMariageType extends AbstractType {
    
    /**
     * @param FormBuilderInterface $builder
     * @param array $options
     */
    public function buildForm(FormBuilderInterface $builder, array $options)
    {
        $builder
            ->add('date_mariage', 'date', array(
                    // 'value'=> "" ,           
                    'widget' => 'single_text',
                    'format' => 'yyyy-MM-dd',
                    
        ))
           
                
       ->add('id_epoux')
       ->add('id_epouse')
           
           
                
                
             
                
                
         //  ->add('utilisateur','entity', array('class'=>'EGOVUserBundle:Utilisateur','property'=>'nom', 'empty_value' => 'choisir un utilisateur'));
                
          
        ;
    }
    
    /**
     * @param OptionsResolverInterface $resolver
     */
    public function setDefaultOptions(OptionsResolverInterface $resolver)
    {
        $resolver->setDefaults(array(
            'data_class' => 'EGOV\UserBundle\Entity\ContratMariage'
        ));
    }

    /**
     * @return string
     */
    public function getName()
    {
        return 'egov_userbundle_contratmariage';
    }
    
    
   
}
