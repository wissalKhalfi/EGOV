<?php

namespace MyApp\UserBundle\Form;

use Symfony\Component\Form\AbstractType;
use Symfony\Component\Form\FormBuilderInterface;
use Symfony\Component\OptionsResolver\OptionsResolverInterface;

class ExtraitNaissanceForm extends AbstractType
{
    /**
     * @param FormBuilderInterface $builder
     * @param array $options
     */
    public function buildForm(FormBuilderInterface $builder, array $options)
    {
        $builder
            ->add('nom')
            ->add('prenom')
            ->add('dateNaissance', 'date', array( 'years' => range(1900, 2016) ) )
            ->add('lieuNaissance')
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
            ->add('ajouter','submit')
        ;
    }
    
    /**
     * @param OptionsResolverInterface $resolver
     */
    public function setDefaultOptions(OptionsResolverInterface $resolver)
    {
        $resolver->setDefaults(array(
            'data_class' => 'MyApp\UserBundle\Entity\Utilisateur'
        ));
    }

    /**
     * @return string
     */
    public function getName()
    {
        return 'myapp_userbundle_utilisateur';
    }
}
