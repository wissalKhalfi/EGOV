<?php

namespace EGOV\UserBundle\Form;

use Symfony\Component\Form\AbstractType;
use Symfony\Component\Form\FormBuilderInterface;
use Symfony\Component\OptionsResolver\OptionsResolverInterface;

class SecuriteSocialeType extends AbstractType {

    /**
     * @param FormBuilderInterface $builder
     * @param array $options
     */
    public function buildForm(FormBuilderInterface $builder, array $options) {
        $builder
                ->add('proprietaire', 'text',array('required' => true))
                ->add('conjoint', 'text',array('required' => true))
                ->add('nbreEnfants', 'integer',array('required' => true))
                ->add('dateDelivrenceCsc', 'date', array(
                    //'value' => "",
                    'widget' => 'single_text',
                    'format' => 'yyyy-MM-dd',
                    'required' => true
                ))
                ->add('dateValiditeCsc', 'date', array(
                  //  'value' => "",
                    'widget' => 'single_text',
                    'format' => 'yyyy-MM-dd',
                    'required' => true
                ))
                ->add('regime', 'choice', array(
                    'choices' => array('filière_publique' => 'filière_publique', 'filière_privée' => 'filière_privée', 'système_de_remboursement_des_frais' => 'système_de_remboursement_des_frais', 'Hospitalisation' => 'Hospitalisation'),
                    'preferred_choices' => array('filière_publique')))
        // ->add('utilisateur','entity', array('class'=>'EGOVUserBundle:Utilisateur','property'=>'nom', 'empty_value' => 'choisir un utilisateur'));


        ;
    }

    /**
     * @param OptionsResolverInterface $resolver
     */
    public function setDefaultOptions(OptionsResolverInterface $resolver) {

        $resolver->setRequired(array(
            'data_class'
        ));

        $resolver->setDefaults(array(
            'data_class' => 'EGOV\UserBundle\Entity\SecuriteSociale'
        ));
    }

    /**
     * @return string
     */
    public function getName() { {
            return 'egov_userbundle_securitesociale';
        }
    }

}
