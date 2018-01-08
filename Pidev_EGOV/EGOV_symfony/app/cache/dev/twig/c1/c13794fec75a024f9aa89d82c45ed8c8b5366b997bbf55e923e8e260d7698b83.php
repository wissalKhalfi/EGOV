<?php

/* MyAppUserBundle:Default:layout/permisfinalpdf.html.twig */
class __TwigTemplate_8e99a5e370252ec8a96849bcbabeb8274a83caaa551d4211dceec51bacedb468 extends Twig_Template
{
    public function __construct(Twig_Environment $env)
    {
        parent::__construct($env);

        $this->parent = false;

        $this->blocks = array(
        );
    }

    protected function doDisplay(array $context, array $blocks = array())
    {
        // line 1
        echo "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">
<html xmlns=\"http://www.w3.org/1999/xhtml\">
    <head>
        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />
        <title>Facture</title>
        <link href=\"./css/facture.css\" rel=\"stylesheet\" type=\"text/css\" />
    </head>
    <body>
        <h1>Permis</h1>
      
      
        <table id=\"entity\">
            
                <tr> <td width=\"105\">Nom</td><td width=\"280\">";
        // line 14
        echo twig_escape_filter($this->env, $this->getAttribute($this->getAttribute((isset($context["permis"]) ? $context["permis"] : $this->getContext($context, "permis")), "utilisateur", array()), "nom", array()), "html", null, true);
        echo "</td></tr>
                <tr> <td width=\"105\">Prenom</td><td width=\"280\">";
        // line 15
        echo twig_escape_filter($this->env, $this->getAttribute($this->getAttribute((isset($context["permis"]) ? $context["permis"] : $this->getContext($context, "permis")), "utilisateur", array()), "prenom", array()), "html", null, true);
        echo "</td></tr>
                <tr> <td width=\"100\">Email</td><td width=\"280\">";
        // line 16
        echo twig_escape_filter($this->env, $this->getAttribute($this->getAttribute((isset($context["permis"]) ? $context["permis"] : $this->getContext($context, "permis")), "utilisateur", array()), "email", array()), "html", null, true);
        echo "</td></tr>
                <tr> <td width=\"100\">Num Permis</td><td width=\"280\">";
        // line 17
        echo twig_escape_filter($this->env, $this->getAttribute((isset($context["permis"]) ? $context["permis"] : $this->getContext($context, "permis")), "numPermis", array()), "html", null, true);
        echo "</td></tr>
                <tr><td width=\"105\">Date Création</td><td width=\"280\">";
        // line 18
        echo twig_escape_filter($this->env, twig_date_format_filter($this->env, $this->getAttribute((isset($context["permis"]) ? $context["permis"] : $this->getContext($context, "permis")), "dateCreationPermis", array()), "Y-m-d"), "html", null, true);
        echo "</td></tr>
                <tr> <td width=\"105\">Date Validité</td><td width=\"280\">";
        // line 19
        echo twig_escape_filter($this->env, twig_date_format_filter($this->env, $this->getAttribute((isset($context["permis"]) ? $context["permis"] : $this->getContext($context, "permis")), "dateValiditePermis", array()), "Y-m-d"), "html", null, true);
        echo "</td></tr>
                <tr> <td width=\"100\">Catégorie Permis</td><td width=\"280\">";
        // line 20
        echo twig_escape_filter($this->env, $this->getAttribute((isset($context["permis"]) ? $context["permis"] : $this->getContext($context, "permis")), "categoriePermis", array()), "html", null, true);
        echo "</td></tr>
               
        </table>
     
        <div id=\"footer\">
            <span class=\"color strong\">votre permis est creé !</span>
            
        </div>
    </body>
</html>";
    }

    public function getTemplateName()
    {
        return "MyAppUserBundle:Default:layout/permisfinalpdf.html.twig";
    }

    public function isTraitable()
    {
        return false;
    }

    public function getDebugInfo()
    {
        return array (  58 => 20,  54 => 19,  50 => 18,  46 => 17,  42 => 16,  38 => 15,  34 => 14,  19 => 1,);
    }
}
/* <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">*/
/* <html xmlns="http://www.w3.org/1999/xhtml">*/
/*     <head>*/
/*         <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />*/
/*         <title>Facture</title>*/
/*         <link href="./css/facture.css" rel="stylesheet" type="text/css" />*/
/*     </head>*/
/*     <body>*/
/*         <h1>Permis</h1>*/
/*       */
/*       */
/*         <table id="entity">*/
/*             */
/*                 <tr> <td width="105">Nom</td><td width="280">{{permis.utilisateur.nom}}</td></tr>*/
/*                 <tr> <td width="105">Prenom</td><td width="280">{{permis.utilisateur.prenom}}</td></tr>*/
/*                 <tr> <td width="100">Email</td><td width="280">{{permis.utilisateur.email}}</td></tr>*/
/*                 <tr> <td width="100">Num Permis</td><td width="280">{{permis.numPermis}}</td></tr>*/
/*                 <tr><td width="105">Date Création</td><td width="280">{{permis.dateCreationPermis|date('Y-m-d')}}</td></tr>*/
/*                 <tr> <td width="105">Date Validité</td><td width="280">{{permis.dateValiditePermis|date('Y-m-d')}}</td></tr>*/
/*                 <tr> <td width="100">Catégorie Permis</td><td width="280">{{permis.categoriePermis}}</td></tr>*/
/*                */
/*         </table>*/
/*      */
/*         <div id="footer">*/
/*             <span class="color strong">votre permis est creé !</span>*/
/*             */
/*         </div>*/
/*     </body>*/
/* </html>*/
