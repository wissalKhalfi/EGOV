<?php
namespace MyApp\UserBundle\Services;

use Symfony\Component\Security\Core\SecurityContextInterface;
use Symfony\Component\DependencyInjection\ContainerInterface;

class GetPermis 
{
    public function __construct(ContainerInterface $container)
    {
        $this->container = $container;
    }
    
    public function permis($permis)
    {
     
        $html = $this->container->get('templating')->render('MyAppUserBundle:Default:layout/permisfinalpdf.html.twig', array('permis' => $permis ));
     
        $html2pdf = new \Html2Pdf_Html2Pdf('P','A4','fr');
        $html2pdf->pdf->SetAuthor('aya');
        $html2pdf->pdf->SetTitle('Permis ');
        $html2pdf->pdf->SetSubject('Permis');
        $html2pdf->pdf->SetKeywords('permis');
        $html2pdf->pdf->SetDisplayMode('real');
        $html2pdf->writeHTML($html);
        
        return $html2pdf;
    }
}