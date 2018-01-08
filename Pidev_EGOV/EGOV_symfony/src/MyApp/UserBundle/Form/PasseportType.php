<?php

namespace MyApp\UserBundle\Form;

use Symfony\Component\Form\AbstractType;
use Symfony\Component\Form\FormBuilderInterface;
use Symfony\Component\OptionsResolver\OptionsResolverInterface;

class PasseportType extends AbstractType
{
    /**
     * @param FormBuilderInterface $builder
     * @param array $options
     */
    public function buildForm(FormBuilderInterface $builder, array $options)
    {
        $builder
            ->add('dateDelivrance', 'date', array(
                    // 'value'=> "" ,           
                    'widget' => 'single_text',
                    'format' => 'yyyy-MM-dd',
                    
        ))
           
                
             ->add('dateValidite', 'date', array(
                    // 'value'=> "" ,           
                    'widget' => 'single_text',
                    'format' => 'yyyy-MM-dd',
                    
        ))
           
           
                
                
           ->add('couleurYeux', 'choice', array(
    'choices' => array('noire' => 'noire', 'marron' => 'marron', 'vert' => 'vert','bleu' => 'bleu'),
    'preferred_choices' => array('noire')))   
                
                
           // ->add('utilisateur','entity', array('class'=>'EGOVUserBundle:Utilisateur','property'=>'nom', 'empty_value' => 'choisir un utilisateur'));
                
          
        ;
    }
    
    /**
     * @param OptionsResolverInterface $resolver
     */
    public function setDefaultOptions(OptionsResolverInterface $resolver)
    {
        $resolver->setDefaults(array(
            'data_class' => 'MyApp\UserBundle\Entity\Passeport'
        ));
    }

    /**
     * @return string
     */
    public function getName()
    {
        return 'egov_userbundle_passeport';
    }
}

