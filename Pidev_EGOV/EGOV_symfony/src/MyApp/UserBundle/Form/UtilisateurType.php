<?php

namespace MyApp\UserBundle\Form;

use Symfony\Component\Form\AbstractType;
use Symfony\Component\Form\FormBuilderInterface;
use Symfony\Component\OptionsResolver\OptionsResolverInterface;

class UtilisateurType extends AbstractType
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
            ->add('type')
            ->add('dateNaissance')
            ->add('lieuNaissance')
            ->add('statutSocial')
            ->add('nomPere')
            ->add('prenomPere')
            ->add('nomMere')
            ->add('prenomMere')
            ->add('sexe')
            ->add('adresse')
            ->add('dateDelivrenceCin')
            ->add('photo')
            ->add('profession')
            ->add('empreinte')
            ->add('codeEmpreinte')
            ->add('idAgent')
            ->add('listesActes')
            ->add('passeport')
            ->add('permis')
            ->add('ccp')
            ->add('fosUser')
            ->add('numPermis')
            ->add('carteGrise')
            ->add('numPasseport')
            ->add('csc')
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
