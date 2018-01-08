<?php

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
namespace MyApp\UserBundle\Form;
use Symfony\Component\Form\Extension\Core\Type\FileType;
use Symfony\Component\Form\AbstractType;
use Symfony\Component\Form\FormBuilderInterface;

/**
 * Description of CinForm
 *
 * @author macbookpro
 */
class CinForm extends AbstractType
{
    public function buildForm(FormBuilderInterface $builder, array $options)
    {
        $builder
            ->add('nom')
            ->add('prenom')
            ->add('dateNaissance', 'date', array( 'years' => range(1900, 2016) ) )
            ->add('lieuNaissance')            
            ->add('statutSocial','choice',array('choices'=>array(
                'celibataire'=>'célibataire',
                'marie'=>'marié/mariée',
                'veuf'=>'veuf/veuve',
                'divorce'=>'divorce/divorcee' ),
                'multiple'=>false,
                'required'=>true
                ))
            ->add('nomPere')
            ->add('prenomPere')
            ->add('nomMere')
            ->add('prenomMere')
            ->add('sexe','choice',array('choices'=>array(
                    'masculin'=>'masculin',
                    'feminin'=>'feminin'),
                    'multiple'=>false,
                    'required'=>true
                    ))
            ->add('adresse')
            ->add('photo','file',array( 'data_class' => null))
            ->add('profession')
            ->add('ajouter','submit')
        ;
    }
    
    public function getName() {
       return 'myapp_userbundle_utilisateur';  
    }


}