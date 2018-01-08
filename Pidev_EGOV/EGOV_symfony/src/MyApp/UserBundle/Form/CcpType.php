<?php

namespace MyApp\UserBundle\Form;

use Symfony\Component\Form\AbstractType;
use Symfony\Component\Form\FormBuilderInterface;
use Symfony\Component\OptionsResolver\OptionsResolverInterface;

class CcpType extends AbstractType {

    /**
     * @param FormBuilderInterface $builder
     * @param array $options
     */
    public function buildForm(FormBuilderInterface $builder, array $options) {
        $builder
                ->add('soldeActuel')
                ->add('dateDernierRetirement')
                ->add('dernierRetirement')
                ->add('dateCreation')
                ->add('dateDernierVersement')
                ->add('dernierVersement')
                ->add('validator_creation')
                ->add('validator_recuperation')
                ->add('validator_changement')
                ->add('validator_renouvellement')
                ->add('validator_blockage')
                ->add('validator_deblockage')
        
        ;
    }

    /**
     * @param OptionsResolverInterface $resolver
     */
    public function setDefaultOptions(OptionsResolverInterface $resolver) {
        $resolver->setDefaults(array(
            'data_class' => 'MyApp\UserBundle\Entity\Ccp'
        ));
    }

    /**
     * @return string
     */
    public function getName() {
        return 'myapp_userbundle_ccp';
    }

}
