<?php

use Symfony\Component\Routing\Exception\MethodNotAllowedException;
use Symfony\Component\Routing\Exception\ResourceNotFoundException;
use Symfony\Component\Routing\RequestContext;

/**
 * appDevUrlMatcher
 *
 * This class has been auto-generated
 * by the Symfony Routing Component.
 */
class appDevUrlMatcher extends Symfony\Bundle\FrameworkBundle\Routing\RedirectableUrlMatcher
{
    /**
     * Constructor.
     */
    public function __construct(RequestContext $context)
    {
        $this->context = $context;
    }

    public function match($pathinfo)
    {
        $allow = array();
        $pathinfo = rawurldecode($pathinfo);
        $context = $this->context;
        $request = $this->request;

        if (0 === strpos($pathinfo, '/js/35a8e64')) {
            // _assetic_35a8e64
            if ($pathinfo === '/js/35a8e64.js') {
                return array (  '_controller' => 'assetic.controller:render',  'name' => '35a8e64',  'pos' => NULL,  '_format' => 'js',  '_route' => '_assetic_35a8e64',);
            }

            // _assetic_35a8e64_0
            if ($pathinfo === '/js/35a8e64_comments_1.js') {
                return array (  '_controller' => 'assetic.controller:render',  'name' => '35a8e64',  'pos' => 0,  '_format' => 'js',  '_route' => '_assetic_35a8e64_0',);
            }

        }

        if (0 === strpos($pathinfo, '/_')) {
            // _wdt
            if (0 === strpos($pathinfo, '/_wdt') && preg_match('#^/_wdt/(?P<token>[^/]++)$#s', $pathinfo, $matches)) {
                return $this->mergeDefaults(array_replace($matches, array('_route' => '_wdt')), array (  '_controller' => 'web_profiler.controller.profiler:toolbarAction',));
            }

            if (0 === strpos($pathinfo, '/_profiler')) {
                // _profiler_home
                if (rtrim($pathinfo, '/') === '/_profiler') {
                    if (substr($pathinfo, -1) !== '/') {
                        return $this->redirect($pathinfo.'/', '_profiler_home');
                    }

                    return array (  '_controller' => 'web_profiler.controller.profiler:homeAction',  '_route' => '_profiler_home',);
                }

                if (0 === strpos($pathinfo, '/_profiler/search')) {
                    // _profiler_search
                    if ($pathinfo === '/_profiler/search') {
                        return array (  '_controller' => 'web_profiler.controller.profiler:searchAction',  '_route' => '_profiler_search',);
                    }

                    // _profiler_search_bar
                    if ($pathinfo === '/_profiler/search_bar') {
                        return array (  '_controller' => 'web_profiler.controller.profiler:searchBarAction',  '_route' => '_profiler_search_bar',);
                    }

                }

                // _profiler_purge
                if ($pathinfo === '/_profiler/purge') {
                    return array (  '_controller' => 'web_profiler.controller.profiler:purgeAction',  '_route' => '_profiler_purge',);
                }

                // _profiler_info
                if (0 === strpos($pathinfo, '/_profiler/info') && preg_match('#^/_profiler/info/(?P<about>[^/]++)$#s', $pathinfo, $matches)) {
                    return $this->mergeDefaults(array_replace($matches, array('_route' => '_profiler_info')), array (  '_controller' => 'web_profiler.controller.profiler:infoAction',));
                }

                // _profiler_phpinfo
                if ($pathinfo === '/_profiler/phpinfo') {
                    return array (  '_controller' => 'web_profiler.controller.profiler:phpinfoAction',  '_route' => '_profiler_phpinfo',);
                }

                // _profiler_search_results
                if (preg_match('#^/_profiler/(?P<token>[^/]++)/search/results$#s', $pathinfo, $matches)) {
                    return $this->mergeDefaults(array_replace($matches, array('_route' => '_profiler_search_results')), array (  '_controller' => 'web_profiler.controller.profiler:searchResultsAction',));
                }

                // _profiler
                if (preg_match('#^/_profiler/(?P<token>[^/]++)$#s', $pathinfo, $matches)) {
                    return $this->mergeDefaults(array_replace($matches, array('_route' => '_profiler')), array (  '_controller' => 'web_profiler.controller.profiler:panelAction',));
                }

                // _profiler_router
                if (preg_match('#^/_profiler/(?P<token>[^/]++)/router$#s', $pathinfo, $matches)) {
                    return $this->mergeDefaults(array_replace($matches, array('_route' => '_profiler_router')), array (  '_controller' => 'web_profiler.controller.router:panelAction',));
                }

                // _profiler_exception
                if (preg_match('#^/_profiler/(?P<token>[^/]++)/exception$#s', $pathinfo, $matches)) {
                    return $this->mergeDefaults(array_replace($matches, array('_route' => '_profiler_exception')), array (  '_controller' => 'web_profiler.controller.exception:showAction',));
                }

                // _profiler_exception_css
                if (preg_match('#^/_profiler/(?P<token>[^/]++)/exception\\.css$#s', $pathinfo, $matches)) {
                    return $this->mergeDefaults(array_replace($matches, array('_route' => '_profiler_exception_css')), array (  '_controller' => 'web_profiler.controller.exception:cssAction',));
                }

            }

            if (0 === strpos($pathinfo, '/_configurator')) {
                // _configurator_home
                if (rtrim($pathinfo, '/') === '/_configurator') {
                    if (substr($pathinfo, -1) !== '/') {
                        return $this->redirect($pathinfo.'/', '_configurator_home');
                    }

                    return array (  '_controller' => 'Sensio\\Bundle\\DistributionBundle\\Controller\\ConfiguratorController::checkAction',  '_route' => '_configurator_home',);
                }

                // _configurator_step
                if (0 === strpos($pathinfo, '/_configurator/step') && preg_match('#^/_configurator/step/(?P<index>[^/]++)$#s', $pathinfo, $matches)) {
                    return $this->mergeDefaults(array_replace($matches, array('_route' => '_configurator_step')), array (  '_controller' => 'Sensio\\Bundle\\DistributionBundle\\Controller\\ConfiguratorController::stepAction',));
                }

                // _configurator_final
                if ($pathinfo === '/_configurator/final') {
                    return array (  '_controller' => 'Sensio\\Bundle\\DistributionBundle\\Controller\\ConfiguratorController::finalAction',  '_route' => '_configurator_final',);
                }

            }

        }

        if (0 === strpos($pathinfo, '/utilisateur')) {
            // utilisateur
            if (rtrim($pathinfo, '/') === '/utilisateur') {
                if (substr($pathinfo, -1) !== '/') {
                    return $this->redirect($pathinfo.'/', 'utilisateur');
                }

                return array (  '_controller' => 'MyApp\\UserBundle\\Controller\\UtilisateurController::indexAction',  '_route' => 'utilisateur',);
            }

            // utilisateur_show
            if (preg_match('#^/utilisateur/(?P<id>[^/]++)/show$#s', $pathinfo, $matches)) {
                return $this->mergeDefaults(array_replace($matches, array('_route' => 'utilisateur_show')), array (  '_controller' => 'MyApp\\UserBundle\\Controller\\UtilisateurController::showAction',));
            }

            // utilisateur_new
            if ($pathinfo === '/utilisateur/new') {
                return array (  '_controller' => 'MyApp\\UserBundle\\Controller\\UtilisateurController::newAction',  '_route' => 'utilisateur_new',);
            }

            // utilisateur_create
            if ($pathinfo === '/utilisateur/create') {
                if ($this->context->getMethod() != 'POST') {
                    $allow[] = 'POST';
                    goto not_utilisateur_create;
                }

                return array (  '_controller' => 'MyApp\\UserBundle\\Controller\\UtilisateurController::createAction',  '_route' => 'utilisateur_create',);
            }
            not_utilisateur_create:

            // utilisateur_edit
            if (preg_match('#^/utilisateur/(?P<id>[^/]++)/edit$#s', $pathinfo, $matches)) {
                return $this->mergeDefaults(array_replace($matches, array('_route' => 'utilisateur_edit')), array (  '_controller' => 'MyApp\\UserBundle\\Controller\\UtilisateurController::editAction',));
            }

            // utilisateur_update
            if (preg_match('#^/utilisateur/(?P<id>[^/]++)/update$#s', $pathinfo, $matches)) {
                if (!in_array($this->context->getMethod(), array('POST', 'PUT'))) {
                    $allow = array_merge($allow, array('POST', 'PUT'));
                    goto not_utilisateur_update;
                }

                return $this->mergeDefaults(array_replace($matches, array('_route' => 'utilisateur_update')), array (  '_controller' => 'MyApp\\UserBundle\\Controller\\UtilisateurController::updateAction',));
            }
            not_utilisateur_update:

            // utilisateur_delete
            if (preg_match('#^/utilisateur/(?P<id>[^/]++)/delete$#s', $pathinfo, $matches)) {
                if (!in_array($this->context->getMethod(), array('POST', 'DELETE'))) {
                    $allow = array_merge($allow, array('POST', 'DELETE'));
                    goto not_utilisateur_delete;
                }

                return $this->mergeDefaults(array_replace($matches, array('_route' => 'utilisateur_delete')), array (  '_controller' => 'MyApp\\UserBundle\\Controller\\UtilisateurController::deleteAction',));
            }
            not_utilisateur_delete:

        }

        if (0 === strpos($pathinfo, '/entreprise')) {
            // entreprise
            if (rtrim($pathinfo, '/') === '/entreprise') {
                if (substr($pathinfo, -1) !== '/') {
                    return $this->redirect($pathinfo.'/', 'entreprise');
                }

                return array (  '_controller' => 'MyApp\\UserBundle\\Controller\\EntrepriseController::indexAction',  '_route' => 'entreprise',);
            }

            // entreprise_show
            if (preg_match('#^/entreprise/(?P<id>[^/]++)/show$#s', $pathinfo, $matches)) {
                return $this->mergeDefaults(array_replace($matches, array('_route' => 'entreprise_show')), array (  '_controller' => 'MyApp\\UserBundle\\Controller\\EntrepriseController::showAction',));
            }

            // entreprise_new
            if ($pathinfo === '/entreprise/new') {
                return array (  '_controller' => 'MyApp\\UserBundle\\Controller\\EntrepriseController::newAction',  '_route' => 'entreprise_new',);
            }

            // entreprise_create
            if ($pathinfo === '/entreprise/create') {
                if ($this->context->getMethod() != 'POST') {
                    $allow[] = 'POST';
                    goto not_entreprise_create;
                }

                return array (  '_controller' => 'MyApp\\UserBundle\\Controller\\EntrepriseController::createAction',  '_route' => 'entreprise_create',);
            }
            not_entreprise_create:

            // entreprise_edit
            if (preg_match('#^/entreprise/(?P<id>[^/]++)/edit$#s', $pathinfo, $matches)) {
                return $this->mergeDefaults(array_replace($matches, array('_route' => 'entreprise_edit')), array (  '_controller' => 'MyApp\\UserBundle\\Controller\\EntrepriseController::editAction',));
            }

            // entreprise_update
            if (preg_match('#^/entreprise/(?P<id>[^/]++)/update$#s', $pathinfo, $matches)) {
                if (!in_array($this->context->getMethod(), array('POST', 'PUT'))) {
                    $allow = array_merge($allow, array('POST', 'PUT'));
                    goto not_entreprise_update;
                }

                return $this->mergeDefaults(array_replace($matches, array('_route' => 'entreprise_update')), array (  '_controller' => 'MyApp\\UserBundle\\Controller\\EntrepriseController::updateAction',));
            }
            not_entreprise_update:

            // entreprise_delete
            if (preg_match('#^/entreprise/(?P<id>[^/]++)/delete$#s', $pathinfo, $matches)) {
                if (!in_array($this->context->getMethod(), array('POST', 'DELETE'))) {
                    $allow = array_merge($allow, array('POST', 'DELETE'));
                    goto not_entreprise_delete;
                }

                return $this->mergeDefaults(array_replace($matches, array('_route' => 'entreprise_delete')), array (  '_controller' => 'MyApp\\UserBundle\\Controller\\EntrepriseController::deleteAction',));
            }
            not_entreprise_delete:

        }

        if (0 === strpos($pathinfo, '/candidature')) {
            // candidature
            if (rtrim($pathinfo, '/') === '/candidature') {
                if (substr($pathinfo, -1) !== '/') {
                    return $this->redirect($pathinfo.'/', 'candidature');
                }

                return array (  '_controller' => 'MyApp\\UserBundle\\Controller\\CandidatureController::indexAction',  '_route' => 'candidature',);
            }

            // candidature_show
            if (preg_match('#^/candidature/(?P<id>[^/]++)/show$#s', $pathinfo, $matches)) {
                return $this->mergeDefaults(array_replace($matches, array('_route' => 'candidature_show')), array (  '_controller' => 'MyApp\\UserBundle\\Controller\\CandidatureController::showAction',));
            }

            // candidature_new
            if ($pathinfo === '/candidature/new') {
                return array (  '_controller' => 'MyApp\\UserBundle\\Controller\\CandidatureController::newAction',  '_route' => 'candidature_new',);
            }

            // candidature_create
            if ($pathinfo === '/candidature/create') {
                if ($this->context->getMethod() != 'POST') {
                    $allow[] = 'POST';
                    goto not_candidature_create;
                }

                return array (  '_controller' => 'MyApp\\UserBundle\\Controller\\CandidatureController::createAction',  '_route' => 'candidature_create',);
            }
            not_candidature_create:

            // candidature_edit
            if (preg_match('#^/candidature/(?P<id>[^/]++)/edit$#s', $pathinfo, $matches)) {
                return $this->mergeDefaults(array_replace($matches, array('_route' => 'candidature_edit')), array (  '_controller' => 'MyApp\\UserBundle\\Controller\\CandidatureController::editAction',));
            }

            // candidature_update
            if (preg_match('#^/candidature/(?P<id>[^/]++)/update$#s', $pathinfo, $matches)) {
                if (!in_array($this->context->getMethod(), array('POST', 'PUT'))) {
                    $allow = array_merge($allow, array('POST', 'PUT'));
                    goto not_candidature_update;
                }

                return $this->mergeDefaults(array_replace($matches, array('_route' => 'candidature_update')), array (  '_controller' => 'MyApp\\UserBundle\\Controller\\CandidatureController::updateAction',));
            }
            not_candidature_update:

            // candidature_delete
            if (preg_match('#^/candidature/(?P<id>[^/]++)/delete$#s', $pathinfo, $matches)) {
                if (!in_array($this->context->getMethod(), array('POST', 'DELETE'))) {
                    $allow = array_merge($allow, array('POST', 'DELETE'));
                    goto not_candidature_delete;
                }

                return $this->mergeDefaults(array_replace($matches, array('_route' => 'candidature_delete')), array (  '_controller' => 'MyApp\\UserBundle\\Controller\\CandidatureController::deleteAction',));
            }
            not_candidature_delete:

            // candidature_accepter
            if (0 === strpos($pathinfo, '/candidature/accepter') && preg_match('#^/candidature/accepter/(?P<id>[^/]++)$#s', $pathinfo, $matches)) {
                return $this->mergeDefaults(array_replace($matches, array('_route' => 'candidature_accepter')), array (  '_controller' => 'MyApp\\UserBundle\\Controller\\CandidatureController::accepterAction',));
            }

            if (0 === strpos($pathinfo, '/candidature/re')) {
                // candidature_refuser
                if (0 === strpos($pathinfo, '/candidature/refuser') && preg_match('#^/candidature/refuser/(?P<id>[^/]++)$#s', $pathinfo, $matches)) {
                    return $this->mergeDefaults(array_replace($matches, array('_route' => 'candidature_refuser')), array (  '_controller' => 'MyApp\\UserBundle\\Controller\\CandidatureController::refuserAction',));
                }

                // candidature_rech
                if ($pathinfo === '/candidature/recherche') {
                    return array (  '_controller' => 'MyApp\\UserBundle\\Controller\\CandidatureController::rechercheAction',  '_route' => 'candidature_rech',);
                }

            }

        }

        if (0 === strpos($pathinfo, '/appeloffre')) {
            // appeloffre
            if (rtrim($pathinfo, '/') === '/appeloffre') {
                if (substr($pathinfo, -1) !== '/') {
                    return $this->redirect($pathinfo.'/', 'appeloffre');
                }

                return array (  '_controller' => 'MyApp\\UserBundle\\Controller\\AppelOffreController::indexAction',  '_route' => 'appeloffre',);
            }

            // appeloffre_show
            if (preg_match('#^/appeloffre/(?P<id>[^/]++)/show$#s', $pathinfo, $matches)) {
                return $this->mergeDefaults(array_replace($matches, array('_route' => 'appeloffre_show')), array (  '_controller' => 'MyApp\\UserBundle\\Controller\\AppelOffreController::showAction',));
            }

            // appeloffre_show1
            if (preg_match('#^/appeloffre/(?P<id>[^/]++)/show1$#s', $pathinfo, $matches)) {
                return $this->mergeDefaults(array_replace($matches, array('_route' => 'appeloffre_show1')), array (  '_controller' => 'MyApp\\UserBundle\\Controller\\AppelOffreController::show1Action',));
            }

            // appeloffre_new
            if ($pathinfo === '/appeloffre/new') {
                return array (  '_controller' => 'MyApp\\UserBundle\\Controller\\AppelOffreController::newAction',  '_route' => 'appeloffre_new',);
            }

            // appeloffre_create
            if ($pathinfo === '/appeloffre/create') {
                if ($this->context->getMethod() != 'POST') {
                    $allow[] = 'POST';
                    goto not_appeloffre_create;
                }

                return array (  '_controller' => 'MyApp\\UserBundle\\Controller\\AppelOffreController::createAction',  '_route' => 'appeloffre_create',);
            }
            not_appeloffre_create:

            // appeloffre_edit
            if (preg_match('#^/appeloffre/(?P<id>[^/]++)/edit$#s', $pathinfo, $matches)) {
                return $this->mergeDefaults(array_replace($matches, array('_route' => 'appeloffre_edit')), array (  '_controller' => 'MyApp\\UserBundle\\Controller\\AppelOffreController::editAction',));
            }

            // appeloffre_update
            if (preg_match('#^/appeloffre/(?P<id>[^/]++)/update$#s', $pathinfo, $matches)) {
                if (!in_array($this->context->getMethod(), array('POST', 'PUT'))) {
                    $allow = array_merge($allow, array('POST', 'PUT'));
                    goto not_appeloffre_update;
                }

                return $this->mergeDefaults(array_replace($matches, array('_route' => 'appeloffre_update')), array (  '_controller' => 'MyApp\\UserBundle\\Controller\\AppelOffreController::updateAction',));
            }
            not_appeloffre_update:

            // appeloffre_delete
            if (preg_match('#^/appeloffre/(?P<id>[^/]++)/delete$#s', $pathinfo, $matches)) {
                if (!in_array($this->context->getMethod(), array('POST', 'DELETE'))) {
                    $allow = array_merge($allow, array('POST', 'DELETE'));
                    goto not_appeloffre_delete;
                }

                return $this->mergeDefaults(array_replace($matches, array('_route' => 'appeloffre_delete')), array (  '_controller' => 'MyApp\\UserBundle\\Controller\\AppelOffreController::deleteAction',));
            }
            not_appeloffre_delete:

            // postuler
            if (0 === strpos($pathinfo, '/appeloffre/postuler') && preg_match('#^/appeloffre/postuler/(?P<identreprise>[^/]++)$#s', $pathinfo, $matches)) {
                return $this->mergeDefaults(array_replace($matches, array('_route' => 'postuler')), array (  '_controller' => 'MyApp\\UserBundle\\Controller\\AppelOffreController::postulerAction',));
            }

            // appeloffre_rech
            if ($pathinfo === '/appeloffre/recherche') {
                return array (  '_controller' => 'MyApp\\UserBundle\\Controller\\AppelOffreController::rechercheAction',  '_route' => 'appeloffre_rech',);
            }

            // e-job
            if ($pathinfo === '/appeloffre/e-job') {
                return array (  '_controller' => 'MyApp\\UserBundle\\Controller\\UserController::ejobAction',  '_route' => 'e-job',);
            }

        }

        // citoyen
        if ($pathinfo === '/index') {
            return array (  '_controller' => 'MyApp\\UserBundle\\Controller\\UserController::indexAction',  '_route' => 'citoyen',);
        }

        // citoyen_abouttn
        if ($pathinfo === '/abouttn') {
            return array (  '_controller' => 'MyApp\\UserBundle\\Controller\\UserController::abouttnAction',  '_route' => 'citoyen_abouttn',);
        }

        // citoyen_service
        if ($pathinfo === '/service') {
            return array (  '_controller' => 'MyApp\\UserBundle\\Controller\\UserController::serviceAction',  '_route' => 'citoyen_service',);
        }

        if (0 === strpos($pathinfo, '/e-')) {
            // citoyen_estudent
            if ($pathinfo === '/e-student') {
                return array (  '_controller' => 'MyApp\\UserBundle\\Controller\\UserController::estudentAction',  '_route' => 'citoyen_estudent',);
            }

            // citoyen_eroute
            if ($pathinfo === '/e-route') {
                return array (  '_controller' => 'MyApp\\UserBundle\\Controller\\UserController::erouteAction',  '_route' => 'citoyen_eroute',);
            }

            if (0 === strpos($pathinfo, '/e-citoyennite')) {
                // citoyen_ecitoyennite
                if ($pathinfo === '/e-citoyennite') {
                    return array (  '_controller' => 'MyApp\\UserBundle\\Controller\\UserController::ecitoyenniteAction',  '_route' => 'citoyen_ecitoyennite',);
                }

                // citoyen_ecitoyenniteplus
                if ($pathinfo === '/e-citoyennite+') {
                    return array (  '_controller' => 'MyApp\\UserBundle\\Controller\\UserController::ecitoyenniteplusAction',  '_route' => 'citoyen_ecitoyenniteplus',);
                }

            }

        }

        // citoyen_contact
        if ($pathinfo === '/contact') {
            return array (  '_controller' => 'MyApp\\UserBundle\\Controller\\UserController::contactAction',  '_route' => 'citoyen_contact',);
        }

        // citoyen_news
        if ($pathinfo === '/news') {
            return array (  '_controller' => 'MyApp\\UserBundle\\Controller\\UserController::newsAction',  '_route' => 'citoyen_news',);
        }

        // citoyen_ejob
        if ($pathinfo === '/e-job') {
            return array (  '_controller' => 'MyApp\\UserBundle\\Controller\\UserController::ejobAction',  '_route' => 'citoyen_ejob',);
        }

        // my_app_mail_succ
        if ($pathinfo === '/succ') {
            return array (  '_controller' => 'MyApp\\UserBundle\\Controller\\UserController::indexmailAction',  '_route' => 'my_app_mail_succ',);
        }

        // my_app_mail_form
        if ($pathinfo === '/mail') {
            return array (  '_controller' => 'MyApp\\UserBundle\\Controller\\UserController::newAction',  '_route' => 'my_app_mail_form',);
        }

        // my_app_mail_sendpage
        if ($pathinfo === '/sendmail') {
            return array (  '_controller' => 'MyApp\\UserBundle\\Controller\\UserController::sendMailAction',  '_route' => 'my_app_mail_sendpage',);
        }

        if (0 === strpos($pathinfo, '/e-citoyennite')) {
            if (0 === strpos($pathinfo, '/e-citoyennite/extraitNaiss')) {
                // ExtraitNaiss
                if (rtrim($pathinfo, '/') === '/e-citoyennite/extraitNaiss') {
                    if (substr($pathinfo, -1) !== '/') {
                        return $this->redirect($pathinfo.'/', 'ExtraitNaiss');
                    }

                    return array (  '_controller' => 'MyApp\\UserBundle\\Controller\\UtilisateurController::indexENAction',  '_route' => 'ExtraitNaiss',);
                }

                // ExtraitNaiss_ajout
                if ($pathinfo === '/e-citoyennite/extraitNaiss/ajout') {
                    return array (  '_controller' => 'MyApp\\UserBundle\\Controller\\UtilisateurController::AjoutExtraitNaissanceAction',  '_route' => 'ExtraitNaiss_ajout',);
                }

                // ExtraitNaiss_liste
                if ($pathinfo === '/e-citoyennite/extraitNaiss/listeEN') {
                    return array (  '_controller' => 'MyApp\\UserBundle\\Controller\\UtilisateurController::ListerENAction',  '_route' => 'ExtraitNaiss_liste',);
                }

                if (0 === strpos($pathinfo, '/e-citoyennite/extraitNaiss/a')) {
                    // ExtraitNaiss_show
                    if (0 === strpos($pathinfo, '/e-citoyennite/extraitNaiss/afficher') && preg_match('#^/e\\-citoyennite/extraitNaiss/afficher/(?P<id>[^/]++)$#s', $pathinfo, $matches)) {
                        return $this->mergeDefaults(array_replace($matches, array('_route' => 'ExtraitNaiss_show')), array (  '_controller' => 'MyApp\\UserBundle\\Controller\\UtilisateurController::AfficherEnAction',));
                    }

                    // ExtraitNaiss_admin
                    if ($pathinfo === '/e-citoyennite/extraitNaiss/admin') {
                        return array (  '_controller' => 'MyApp\\UserBundle\\Controller\\UtilisateurController::ENAdminAction',  '_route' => 'ExtraitNaiss_admin',);
                    }

                }

                if (0 === strpos($pathinfo, '/e-citoyennite/extraitNaiss/demandesEN')) {
                    // ExtraitNaiss_demandes
                    if ($pathinfo === '/e-citoyennite/extraitNaiss/demandesEN') {
                        return array (  '_controller' => 'MyApp\\UserBundle\\Controller\\UtilisateurController::ListerDemandesENAction',  '_route' => 'ExtraitNaiss_demandes',);
                    }

                    if (0 === strpos($pathinfo, '/e-citoyennite/extraitNaiss/demandesEN/validation')) {
                        // ExtraitNaiss_validation_demandes
                        if (preg_match('#^/e\\-citoyennite/extraitNaiss/demandesEN/validation/(?P<id>[^/]++)$#s', $pathinfo, $matches)) {
                            return $this->mergeDefaults(array_replace($matches, array('_route' => 'ExtraitNaiss_validation_demandes')), array (  '_controller' => 'MyApp\\UserBundle\\Controller\\UtilisateurController::ValidationDemandesENAction',));
                        }

                        // ExtraitNaiss_validation_demandes_accepted
                        if (preg_match('#^/e\\-citoyennite/extraitNaiss/demandesEN/validation/(?P<id>[^/]++)/accepted$#s', $pathinfo, $matches)) {
                            return $this->mergeDefaults(array_replace($matches, array('_route' => 'ExtraitNaiss_validation_demandes_accepted')), array (  '_controller' => 'MyApp\\UserBundle\\Controller\\UtilisateurController::AccepterDemandesENAction',));
                        }

                        // ExtraitNaiss_validation_demandes_denied
                        if (preg_match('#^/e\\-citoyennite/extraitNaiss/demandesEN/validation/(?P<id>[^/]++)/denied$#s', $pathinfo, $matches)) {
                            return $this->mergeDefaults(array_replace($matches, array('_route' => 'ExtraitNaiss_validation_demandes_denied')), array (  '_controller' => 'MyApp\\UserBundle\\Controller\\UtilisateurController::RefuserDemandesENAction',));
                        }

                    }

                    // ExtraitNaiss_reponse_demande
                    if (preg_match('#^/e\\-citoyennite/extraitNaiss/demandesEN/(?P<id>[^/]++)/reponse$#s', $pathinfo, $matches)) {
                        return $this->mergeDefaults(array_replace($matches, array('_route' => 'ExtraitNaiss_reponse_demande')), array (  '_controller' => 'MyApp\\UserBundle\\Controller\\UtilisateurController::ReponseDemandeENutilisateurAction',));
                    }

                }

                // ExtraitNaiss_impression
                if (0 === strpos($pathinfo, '/e-citoyennite/extraitNaiss/EN') && preg_match('#^/e\\-citoyennite/extraitNaiss/EN/(?P<id>[^/]++)$#s', $pathinfo, $matches)) {
                    return $this->mergeDefaults(array_replace($matches, array('_route' => 'ExtraitNaiss_impression')), array (  '_controller' => 'MyApp\\UserBundle\\Controller\\UtilisateurController::imprimerENAction',));
                }

                // ExtraitNaiss_chart_sexe
                if ($pathinfo === '/e-citoyennite/extraitNaiss/StatSexe') {
                    return array (  '_controller' => 'MyApp\\UserBundle\\Controller\\UtilisateurController::SexePieENAction',  '_route' => 'ExtraitNaiss_chart_sexe',);
                }

            }

            if (0 === strpos($pathinfo, '/e-citoyennite/cin')) {
                // cin
                if (rtrim($pathinfo, '/') === '/e-citoyennite/cin') {
                    if (substr($pathinfo, -1) !== '/') {
                        return $this->redirect($pathinfo.'/', 'cin');
                    }

                    return array (  '_controller' => 'MyApp\\UserBundle\\Controller\\UtilisateurController::indexCinAction',  '_route' => 'cin',);
                }

                if (0 === strpos($pathinfo, '/e-citoyennite/cin/a')) {
                    // cin_ajout
                    if (0 === strpos($pathinfo, '/e-citoyennite/cin/ajout') && preg_match('#^/e\\-citoyennite/cin/ajout/(?P<id>[^/]++)$#s', $pathinfo, $matches)) {
                        return $this->mergeDefaults(array_replace($matches, array('_route' => 'cin_ajout')), array (  '_controller' => 'MyApp\\UserBundle\\Controller\\UtilisateurController::AjouterCinAction',));
                    }

                    // cin_show
                    if (0 === strpos($pathinfo, '/e-citoyennite/cin/afficher') && preg_match('#^/e\\-citoyennite/cin/afficher/(?P<id>[^/]++)$#s', $pathinfo, $matches)) {
                        return $this->mergeDefaults(array_replace($matches, array('_route' => 'cin_show')), array (  '_controller' => 'MyApp\\UserBundle\\Controller\\UtilisateurController::AfficherCinAction',));
                    }

                }

                // cin_recherche
                if (0 === strpos($pathinfo, '/e-citoyennite/cin/recherche') && preg_match('#^/e\\-citoyennite/cin/recherche/(?P<nom>[^/]++)$#s', $pathinfo, $matches)) {
                    return $this->mergeDefaults(array_replace($matches, array('_route' => 'cin_recherche')), array (  '_controller' => 'MyApp\\UserBundle\\Controller\\UtilisateurController::RechCinAction',));
                }

                // cin_admin
                if ($pathinfo === '/e-citoyennite/cin/admin') {
                    return array (  '_controller' => 'MyApp\\UserBundle\\Controller\\UtilisateurController::CinAdminAction',  '_route' => 'cin_admin',);
                }

                // cin_liste
                if ($pathinfo === '/e-citoyennite/cin/listeCin') {
                    return array (  '_controller' => 'MyApp\\UserBundle\\Controller\\UtilisateurController::ListerCinAction',  '_route' => 'cin_liste',);
                }

                if (0 === strpos($pathinfo, '/e-citoyennite/cin/demandesCin')) {
                    // cin_demandes
                    if ($pathinfo === '/e-citoyennite/cin/demandesCin') {
                        return array (  '_controller' => 'MyApp\\UserBundle\\Controller\\UtilisateurController::ListerDemandesCinAction',  '_route' => 'cin_demandes',);
                    }

                    // cin_validation_demandes
                    if (0 === strpos($pathinfo, '/e-citoyennite/cin/demandesCin/validation') && preg_match('#^/e\\-citoyennite/cin/demandesCin/validation/(?P<id>[^/]++)$#s', $pathinfo, $matches)) {
                        return $this->mergeDefaults(array_replace($matches, array('_route' => 'cin_validation_demandes')), array (  '_controller' => 'MyApp\\UserBundle\\Controller\\UtilisateurController::ValidationDemandesCinAction',));
                    }

                }

                // cin_image_route
                if (0 === strpos($pathinfo, '/e-citoyennite/cin/images') && preg_match('#^/e\\-citoyennite/cin/images/(?P<id>[^/]++)$#s', $pathinfo, $matches)) {
                    return $this->mergeDefaults(array_replace($matches, array('_route' => 'cin_image_route')), array (  '_controller' => 'MyApp\\UserBundle\\Controller\\UtilisateurController::photoAction',));
                }

                if (0 === strpos($pathinfo, '/e-citoyennite/cin/demandesCin/validation')) {
                    // Cin_validation_demandes_accepted
                    if (preg_match('#^/e\\-citoyennite/cin/demandesCin/validation/(?P<id>[^/]++)/accepted$#s', $pathinfo, $matches)) {
                        return $this->mergeDefaults(array_replace($matches, array('_route' => 'Cin_validation_demandes_accepted')), array (  '_controller' => 'MyApp\\UserBundle\\Controller\\UtilisateurController::AccepterDemandesCinAction',));
                    }

                    // Cin_validation_demandes_denied
                    if (preg_match('#^/e\\-citoyennite/cin/demandesCin/validation/(?P<id>[^/]++)/denied$#s', $pathinfo, $matches)) {
                        return $this->mergeDefaults(array_replace($matches, array('_route' => 'Cin_validation_demandes_denied')), array (  '_controller' => 'MyApp\\UserBundle\\Controller\\UtilisateurController::RefuserDemandesCinAction',));
                    }

                }

                // cin_map
                if ($pathinfo === '/e-citoyennite/cin/map') {
                    return array (  '_controller' => 'MyApp\\UserBundle\\Controller\\UtilisateurController::MapAction',  '_route' => 'cin_map',);
                }

            }

            if (0 === strpos($pathinfo, '/e-citoyennite/B3')) {
                // b3
                if (rtrim($pathinfo, '/') === '/e-citoyennite/B3') {
                    if (substr($pathinfo, -1) !== '/') {
                        return $this->redirect($pathinfo.'/', 'b3');
                    }

                    return array (  '_controller' => 'MyApp\\UserBundle\\Controller\\UtilisateurController::indexB3Action',  '_route' => 'b3',);
                }

                if (0 === strpos($pathinfo, '/e-citoyennite/B3/a')) {
                    // b3_show
                    if (0 === strpos($pathinfo, '/e-citoyennite/B3/afficher') && preg_match('#^/e\\-citoyennite/B3/afficher/(?P<numCin>[^/]++)$#s', $pathinfo, $matches)) {
                        return $this->mergeDefaults(array_replace($matches, array('_route' => 'b3_show')), array (  '_controller' => 'MyApp\\UserBundle\\Controller\\UtilisateurController::AfficherB3Action',));
                    }

                    // b3_admin
                    if ($pathinfo === '/e-citoyennite/B3/admin') {
                        return array (  '_controller' => 'MyApp\\UserBundle\\Controller\\UtilisateurController::B3AdminAction',  '_route' => 'b3_admin',);
                    }

                    // b3_ajout_actes
                    if ($pathinfo === '/e-citoyennite/B3/ajout_acte') {
                        return array (  '_controller' => 'MyApp\\UserBundle\\Controller\\UtilisateurController::AjouterActeJuridiqueAction',  '_route' => 'b3_ajout_actes',);
                    }

                }

                if (0 === strpos($pathinfo, '/e-citoyennite/B3/liste_acte')) {
                    if (0 === strpos($pathinfo, '/e-citoyennite/B3/liste_actes')) {
                        // b3_liste_actes
                        if ($pathinfo === '/e-citoyennite/B3/liste_actes') {
                            return array (  '_controller' => 'MyApp\\UserBundle\\Controller\\UtilisateurController::ListerActeJuridiqueAction',  '_route' => 'b3_liste_actes',);
                        }

                        // b3_ajouter_liste_actes
                        if (preg_match('#^/e\\-citoyennite/B3/liste_actes/(?P<id>[^/]++)/affecter$#s', $pathinfo, $matches)) {
                            return $this->mergeDefaults(array_replace($matches, array('_route' => 'b3_ajouter_liste_actes')), array (  '_controller' => 'MyApp\\UserBundle\\Controller\\UtilisateurController::AjouterCondamnesAction',));
                        }

                        // b3_condamner
                        if (preg_match('#^/e\\-citoyennite/B3/liste_actes/(?P<id>[^/]++)/affecter/(?P<cin>[^/]++)$#s', $pathinfo, $matches)) {
                            return $this->mergeDefaults(array_replace($matches, array('_route' => 'b3_condamner')), array (  '_controller' => 'MyApp\\UserBundle\\Controller\\UtilisateurController::CondamnerAction',));
                        }

                    }

                    // b3_liste_acte_condamnes
                    if ($pathinfo === '/e-citoyennite/B3/liste_acte_condamnes') {
                        return array (  '_controller' => 'MyApp\\UserBundle\\Controller\\UtilisateurController::ListerActeCondamneAction',  '_route' => 'b3_liste_acte_condamnes',);
                    }

                }

                // b3_recherche_par_cin
                if ($pathinfo === '/e-citoyennite/B3/recherche_cin') {
                    return array (  '_controller' => 'MyApp\\UserBundle\\Controller\\UtilisateurController::ChercherActeParCitoyenAction',  '_route' => 'b3_recherche_par_cin',);
                }

            }

        }

        if (0 === strpos($pathinfo, '/c')) {
            if (0 === strpos($pathinfo, '/carteedinar')) {
                // carteedinar
                if (rtrim($pathinfo, '/') === '/carteedinar') {
                    if (substr($pathinfo, -1) !== '/') {
                        return $this->redirect($pathinfo.'/', 'carteedinar');
                    }

                    return array (  '_controller' => 'MyApp\\UserBundle\\Controller\\CarteEdinarController::indexAction',  '_route' => 'carteedinar',);
                }

                // carteedinar_acceuil
                if ($pathinfo === '/carteedinar/acceuil') {
                    return array (  '_controller' => 'MyApp\\UserBundle\\Controller\\CarteEdinarController::acceuilAction',  '_route' => 'carteedinar_acceuil',);
                }

                // carteedinar_infoedinar
                if ($pathinfo === '/carteedinar/infoedinar') {
                    return array (  '_controller' => 'MyApp\\UserBundle\\Controller\\CarteEdinarController::infoedinarAction',  '_route' => 'carteedinar_infoedinar',);
                }

                if (0 === strpos($pathinfo, '/carteedinar/re')) {
                    // carteedinar_reponses
                    if ($pathinfo === '/carteedinar/reponses') {
                        return array (  '_controller' => 'MyApp\\UserBundle\\Controller\\CarteEdinarController::reponsesAction',  '_route' => 'carteedinar_reponses',);
                    }

                    // carteedinar_recuperation
                    if ($pathinfo === '/carteedinar/recuperation') {
                        return array (  '_controller' => 'MyApp\\UserBundle\\Controller\\CarteEdinarController::recuperationAction',  '_route' => 'carteedinar_recuperation',);
                    }

                    // carteedinar_reponse
                    if ($pathinfo === '/carteedinar/reponse') {
                        return array (  '_controller' => 'MyApp\\UserBundle\\Controller\\CarteEdinarController::reponseAction',  '_route' => 'carteedinar_reponse',);
                    }

                }

                // carteedinar_blockage
                if ($pathinfo === '/carteedinar/blockage') {
                    return array (  '_controller' => 'MyApp\\UserBundle\\Controller\\CarteEdinarController::blockageAction',  '_route' => 'carteedinar_blockage',);
                }

                // carteedinar_formedinar
                if ($pathinfo === '/carteedinar/formedinar') {
                    return array (  '_controller' => 'MyApp\\UserBundle\\Controller\\CarteEdinarController::formedinarAction',  '_route' => 'carteedinar_formedinar',);
                }

                if (0 === strpos($pathinfo, '/carteedinar/authedinar')) {
                    // carteedinar_authedinar
                    if ($pathinfo === '/carteedinar/authedinar') {
                        return array (  '_controller' => 'MyApp\\UserBundle\\Controller\\CarteEdinarController::authedinarAction',  '_route' => 'carteedinar_authedinar',);
                    }

                    // carteedinar_authedinar2
                    if ($pathinfo === '/carteedinar/authedinar2') {
                        return array (  '_controller' => 'MyApp\\UserBundle\\Controller\\CarteEdinarController::authedinar2Action',  '_route' => 'carteedinar_authedinar2',);
                    }

                }

                // carteedinar_admin
                if ($pathinfo === '/carteedinar/carteedinaradmin') {
                    return array (  '_controller' => 'MyApp\\UserBundle\\Controller\\CarteEdinarController::carteedinaradminAction',  '_route' => 'carteedinar_admin',);
                }

                // carteedinar_show
                if (preg_match('#^/carteedinar/(?P<id>[^/]++)/show$#s', $pathinfo, $matches)) {
                    return $this->mergeDefaults(array_replace($matches, array('_route' => 'carteedinar_show')), array (  '_controller' => 'MyApp\\UserBundle\\Controller\\CarteEdinarController::showAction',));
                }

                // carteedinar_succes
                if ($pathinfo === '/carteedinar/succes') {
                    return array (  '_controller' => 'MyApp\\UserBundle\\Controller\\CarteEdinarController::succesAction',  '_route' => 'carteedinar_succes',);
                }

                if (0 === strpos($pathinfo, '/carteedinar/listedemande')) {
                    // carteedinar_listedemandeajout
                    if ($pathinfo === '/carteedinar/listedemandeajout') {
                        return array (  '_controller' => 'MyApp\\UserBundle\\Controller\\CarteEdinarController::listedemandeajoutAction',  '_route' => 'carteedinar_listedemandeajout',);
                    }

                    // carteedinar_listedemanderenouvellement
                    if ($pathinfo === '/carteedinar/listedemanderenouvellement') {
                        return array (  '_controller' => 'MyApp\\UserBundle\\Controller\\CarteEdinarController::listedemanderenouvellementAction',  '_route' => 'carteedinar_listedemanderenouvellement',);
                    }

                    // carteedinar_listedemandeblockage
                    if ($pathinfo === '/carteedinar/listedemandeblockage') {
                        return array (  '_controller' => 'MyApp\\UserBundle\\Controller\\CarteEdinarController::listedemandeblockageAction',  '_route' => 'carteedinar_listedemandeblockage',);
                    }

                }

                // carteedinar_new
                if ($pathinfo === '/carteedinar/new') {
                    return array (  '_controller' => 'MyApp\\UserBundle\\Controller\\CarteEdinarController::newAction',  '_route' => 'carteedinar_new',);
                }

                // carteedinar_renouvellement
                if ($pathinfo === '/carteedinar/renouvellement') {
                    return array (  '_controller' => 'MyApp\\UserBundle\\Controller\\CarteEdinarController::renouvellementAction',  '_route' => 'carteedinar_renouvellement',);
                }

                // carteedinar_create
                if ($pathinfo === '/carteedinar/create') {
                    if ($this->context->getMethod() != 'POST') {
                        $allow[] = 'POST';
                        goto not_carteedinar_create;
                    }

                    return array (  '_controller' => 'MyApp\\UserBundle\\Controller\\CarteEdinarController::createAction',  '_route' => 'carteedinar_create',);
                }
                not_carteedinar_create:

                // carteedinar_edit
                if (preg_match('#^/carteedinar/(?P<id>[^/]++)/edit$#s', $pathinfo, $matches)) {
                    return $this->mergeDefaults(array_replace($matches, array('_route' => 'carteedinar_edit')), array (  '_controller' => 'MyApp\\UserBundle\\Controller\\CarteEdinarController::editAction',));
                }

                // carteedinar_update
                if (preg_match('#^/carteedinar/(?P<id>[^/]++)/update$#s', $pathinfo, $matches)) {
                    if (!in_array($this->context->getMethod(), array('POST', 'PUT'))) {
                        $allow = array_merge($allow, array('POST', 'PUT'));
                        goto not_carteedinar_update;
                    }

                    return $this->mergeDefaults(array_replace($matches, array('_route' => 'carteedinar_update')), array (  '_controller' => 'MyApp\\UserBundle\\Controller\\CarteEdinarController::updateAction',));
                }
                not_carteedinar_update:

                // carteedinar_supprimer
                if (preg_match('#^/carteedinar/(?P<id>[^/]++)/supprimercarte$#s', $pathinfo, $matches)) {
                    return $this->mergeDefaults(array_replace($matches, array('_route' => 'carteedinar_supprimer')), array (  '_controller' => 'MyApp\\UserBundle\\Controller\\CarteEdinarController::supprimercarteAction',));
                }

                // carteedinar_delete
                if (preg_match('#^/carteedinar/(?P<id>[^/]++)/delete$#s', $pathinfo, $matches)) {
                    return $this->mergeDefaults(array_replace($matches, array('_route' => 'carteedinar_delete')), array (  '_controller' => 'MyApp\\UserBundle\\Controller\\CarteEdinarController::deleteAction',));
                }

            }

            if (0 === strpos($pathinfo, '/ccp')) {
                // ccp
                if (rtrim($pathinfo, '/') === '/ccp') {
                    if (substr($pathinfo, -1) !== '/') {
                        return $this->redirect($pathinfo.'/', 'ccp');
                    }

                    return array (  '_controller' => 'MyApp\\UserBundle\\Controller\\CcpController::indexAction',  '_route' => 'ccp',);
                }

                // ccp_acceuil
                if ($pathinfo === '/ccp/acceuil') {
                    return array (  '_controller' => 'MyApp\\UserBundle\\Controller\\CcpController::acceuilAction',  '_route' => 'ccp_acceuil',);
                }

                // ccp_infoccp
                if ($pathinfo === '/ccp/infoccp') {
                    return array (  '_controller' => 'MyApp\\UserBundle\\Controller\\CcpController::infoccpAction',  '_route' => 'ccp_infoccp',);
                }

                // ccp_formccp
                if ($pathinfo === '/ccp/formccp') {
                    return array (  '_controller' => 'MyApp\\UserBundle\\Controller\\CcpController::formccpAction',  '_route' => 'ccp_formccp',);
                }

                // ccp_authccp
                if ($pathinfo === '/ccp/authccp') {
                    return array (  '_controller' => 'MyApp\\UserBundle\\Controller\\CcpController::authccpAction',  '_route' => 'ccp_authccp',);
                }

                // ccp_show
                if (preg_match('#^/ccp/(?P<id>[^/]++)/show$#s', $pathinfo, $matches)) {
                    return $this->mergeDefaults(array_replace($matches, array('_route' => 'ccp_show')), array (  '_controller' => 'MyApp\\UserBundle\\Controller\\CcpController::showAction',));
                }

                // ccp_new
                if ($pathinfo === '/ccp/new') {
                    return array (  '_controller' => 'MyApp\\UserBundle\\Controller\\CcpController::newAction',  '_route' => 'ccp_new',);
                }

                // ccp_create
                if ($pathinfo === '/ccp/create') {
                    if ($this->context->getMethod() != 'POST') {
                        $allow[] = 'POST';
                        goto not_ccp_create;
                    }

                    return array (  '_controller' => 'MyApp\\UserBundle\\Controller\\CcpController::createAction',  '_route' => 'ccp_create',);
                }
                not_ccp_create:

                // ccp_edit
                if (preg_match('#^/ccp/(?P<id>[^/]++)/edit$#s', $pathinfo, $matches)) {
                    return $this->mergeDefaults(array_replace($matches, array('_route' => 'ccp_edit')), array (  '_controller' => 'MyApp\\UserBundle\\Controller\\CcpController::editAction',));
                }

                // ccp_supprimer
                if (preg_match('#^/ccp/(?P<id>[^/]++)/supprimerccp$#s', $pathinfo, $matches)) {
                    return $this->mergeDefaults(array_replace($matches, array('_route' => 'ccp_supprimer')), array (  '_controller' => 'MyApp\\UserBundle\\Controller\\CcpController::supprimerccpAction',));
                }

                // ccp_listedemandeajoutc
                if ($pathinfo === '/ccp/listedemandeajoutc') {
                    return array (  '_controller' => 'MyApp\\UserBundle\\Controller\\CcpController::listedemandeajoutcAction',  '_route' => 'ccp_listedemandeajoutc',);
                }

                // ccp_update
                if (preg_match('#^/ccp/(?P<id>[^/]++)/update$#s', $pathinfo, $matches)) {
                    if (!in_array($this->context->getMethod(), array('POST', 'PUT'))) {
                        $allow = array_merge($allow, array('POST', 'PUT'));
                        goto not_ccp_update;
                    }

                    return $this->mergeDefaults(array_replace($matches, array('_route' => 'ccp_update')), array (  '_controller' => 'MyApp\\UserBundle\\Controller\\CcpController::updateAction',));
                }
                not_ccp_update:

                // ccp_delete
                if (preg_match('#^/ccp/(?P<id>[^/]++)/delete$#s', $pathinfo, $matches)) {
                    if (!in_array($this->context->getMethod(), array('POST', 'DELETE'))) {
                        $allow = array_merge($allow, array('POST', 'DELETE'));
                        goto not_ccp_delete;
                    }

                    return $this->mergeDefaults(array_replace($matches, array('_route' => 'ccp_delete')), array (  '_controller' => 'MyApp\\UserBundle\\Controller\\CcpController::deleteAction',));
                }
                not_ccp_delete:

            }

        }

        if (0 === strpos($pathinfo, '/articles')) {
            if (0 === strpos($pathinfo, '/articles/show')) {
                // articles_showpost
                if ($pathinfo === '/articles/showpost') {
                    return array (  '_controller' => 'MyApp\\UserBundle\\Controller\\ArticlesController::showarticleposteAction',  '_route' => 'articles_showpost',);
                }

                // articles_showtunisie
                if ($pathinfo === '/articles/showtunisie') {
                    return array (  '_controller' => 'MyApp\\UserBundle\\Controller\\ArticlesController::showarticletunisieAction',  '_route' => 'articles_showtunisie',);
                }

                if (0 === strpos($pathinfo, '/articles/showin')) {
                    // articles_showinterieur
                    if ($pathinfo === '/articles/showinterieur') {
                        return array (  '_controller' => 'MyApp\\UserBundle\\Controller\\ArticlesController::showarticleinterieurAction',  '_route' => 'articles_showinterieur',);
                    }

                    // articles_showindustrie
                    if ($pathinfo === '/articles/showindustrie') {
                        return array (  '_controller' => 'MyApp\\UserBundle\\Controller\\ArticlesController::showarticleindustrieAction',  '_route' => 'articles_showindustrie',);
                    }

                }

                // articles_showgouvernement
                if ($pathinfo === '/articles/showgouvernement') {
                    return array (  '_controller' => 'MyApp\\UserBundle\\Controller\\ArticlesController::showarticlegouvernementAction',  '_route' => 'articles_showgouvernement',);
                }

                // articles_showjournaux
                if ($pathinfo === '/articles/showjournaux') {
                    return array (  '_controller' => 'MyApp\\UserBundle\\Controller\\ArticlesController::showarticlejournauxAction',  '_route' => 'articles_showjournaux',);
                }

            }

            // my_image_routeproduit
            if (0 === strpos($pathinfo, '/articles/offre/produit/images') && preg_match('#^/articles/offre/produit/images/(?P<id>[^/]++)$#s', $pathinfo, $matches)) {
                return $this->mergeDefaults(array_replace($matches, array('_route' => 'my_image_routeproduit')), array (  '_controller' => 'MyApp\\UserBundle\\Controller\\ArticlesController::photoAction',));
            }

            // articles_showalladmin
            if ($pathinfo === '/articles/showalladmin') {
                return array (  '_controller' => 'MyApp\\UserBundle\\Controller\\ArticlesController::affichageadminAction',  '_route' => 'articles_showalladmin',);
            }

            // articles_detail
            if (preg_match('#^/articles/(?P<id>[^/]++)/detail$#s', $pathinfo, $matches)) {
                return $this->mergeDefaults(array_replace($matches, array('_route' => 'articles_detail')), array (  '_controller' => 'MyApp\\UserBundle\\Controller\\ArticlesController::detailarticleAction',));
            }

            // articles_show
            if (preg_match('#^/articles/(?P<id>[^/]++)/show$#s', $pathinfo, $matches)) {
                return $this->mergeDefaults(array_replace($matches, array('_route' => 'articles_show')), array (  '_controller' => 'MyApp\\UserBundle\\Controller\\ArticlesController::showAction',));
            }

            // articles_chercher
            if ($pathinfo === '/articles/chercher') {
                return array (  '_controller' => 'MyApp\\UserBundle\\Controller\\ArticlesController::chercherAction',  '_route' => 'articles_chercher',);
            }

            // articles_nouveau
            if ($pathinfo === '/articles/nouveau') {
                return array (  '_controller' => 'MyApp\\UserBundle\\Controller\\ArticlesController::nouveauAction',  '_route' => 'articles_nouveau',);
            }

            // diplome_ajout
            if ($pathinfo === '/articles/ajout') {
                return array (  '_controller' => 'MyApp\\UserBundle\\Controller\\ArticlesController::ajoutdiplomeAction',  '_route' => 'diplome_ajout',);
            }

            // diplome_modifier
            if (preg_match('#^/articles/(?P<id>[^/]++)/modifier$#s', $pathinfo, $matches)) {
                return $this->mergeDefaults(array_replace($matches, array('_route' => 'diplome_modifier')), array (  '_controller' => 'MyApp\\UserBundle\\Controller\\ArticlesController::modifierdiplomeAction',));
            }

            // diplome_affiche
            if ($pathinfo === '/articles/afficher') {
                return array (  '_controller' => 'MyApp\\UserBundle\\Controller\\ArticlesController::afficherdiplomeAction',  '_route' => 'diplome_affiche',);
            }

            // articles_edit
            if (preg_match('#^/articles/(?P<id>[^/]++)/edit$#s', $pathinfo, $matches)) {
                return $this->mergeDefaults(array_replace($matches, array('_route' => 'articles_edit')), array (  '_controller' => 'MyApp\\UserBundle\\Controller\\ArticlesController::ModifierArticleAction',));
            }

            // articles_update
            if (preg_match('#^/articles/(?P<id>[^/]++)/update$#s', $pathinfo, $matches)) {
                if (!in_array($this->context->getMethod(), array('POST', 'PUT'))) {
                    $allow = array_merge($allow, array('POST', 'PUT'));
                    goto not_articles_update;
                }

                return $this->mergeDefaults(array_replace($matches, array('_route' => 'articles_update')), array (  '_controller' => 'MyApp\\UserBundle\\Controller\\ArticlesController::updateAction',));
            }
            not_articles_update:

            // articles_delete
            if (preg_match('#^/articles/(?P<id>[^/]++)/delete$#s', $pathinfo, $matches)) {
                if (!in_array($this->context->getMethod(), array('POST', 'DELETE', 'GET', 'HEAD'))) {
                    $allow = array_merge($allow, array('POST', 'DELETE', 'GET', 'HEAD'));
                    goto not_articles_delete;
                }

                return $this->mergeDefaults(array_replace($matches, array('_route' => 'articles_delete')), array (  '_controller' => 'MyApp\\UserBundle\\Controller\\ArticlesController::deleteAction',));
            }
            not_articles_delete:

        }

        if (0 === strpos($pathinfo, '/GestionEcitoyennitePlus')) {
            if (0 === strpos($pathinfo, '/GestionEcitoyennitePlus/menu')) {
                // visitor_menu_passeport
                if ($pathinfo === '/GestionEcitoyennitePlus/menuPasseport') {
                    return array (  '_controller' => 'MyApp\\UserBundle\\Controller\\VisitorController::menuPasseportAction',  '_route' => 'visitor_menu_passeport',);
                }

                if (0 === strpos($pathinfo, '/GestionEcitoyennitePlus/menuC')) {
                    // visitor_menu_contrat
                    if ($pathinfo === '/GestionEcitoyennitePlus/menuContrat') {
                        return array (  '_controller' => 'MyApp\\UserBundle\\Controller\\VisitorController::menuContratAction',  '_route' => 'visitor_menu_contrat',);
                    }

                    // visitor_menu_carte
                    if ($pathinfo === '/GestionEcitoyennitePlus/menuCarte') {
                        return array (  '_controller' => 'MyApp\\UserBundle\\Controller\\VisitorController::menuCarteAction',  '_route' => 'visitor_menu_carte',);
                    }

                }

            }

            // add_passeport
            if ($pathinfo === '/GestionEcitoyennitePlus/add_passeport') {
                return array (  '_controller' => 'MyApp\\UserBundle\\Controller\\PasseportController::add_passeportAction',  '_route' => 'add_passeport',);
            }

            // liste_passeport
            if ($pathinfo === '/GestionEcitoyennitePlus/liste_passeport') {
                return array (  '_controller' => 'MyApp\\UserBundle\\Controller\\AdminPasseportController::liste_passeportAction',  '_route' => 'liste_passeport',);
            }

            if (0 === strpos($pathinfo, '/GestionEcitoyennitePlus/show_passeport')) {
                // show_passeport
                if ($pathinfo === '/GestionEcitoyennitePlus/show_passeport') {
                    return array (  '_controller' => 'MyApp\\UserBundle\\Controller\\PasseportController::show_passeportAction',  '_route' => 'show_passeport',);
                }

                // show_passeport_admin
                if (preg_match('#^/GestionEcitoyennitePlus/show_passeport/(?P<numPasseport>[^/]++)$#s', $pathinfo, $matches)) {
                    return $this->mergeDefaults(array_replace($matches, array('_route' => 'show_passeport_admin')), array (  '_controller' => 'MyApp\\UserBundle\\Controller\\AdminPasseportController::show_passeportAction',));
                }

            }

            // edit_passeport_user
            if ($pathinfo === '/GestionEcitoyennitePlus/edit_passeport_user') {
                return array (  '_controller' => 'MyApp\\UserBundle\\Controller\\PasseportController::edit_passeport_userAction',  '_route' => 'edit_passeport_user',);
            }

            // valider_passeport
            if (0 === strpos($pathinfo, '/GestionEcitoyennitePlus/valider_passeport') && preg_match('#^/GestionEcitoyennitePlus/valider_passeport/(?P<numPasseport>[^/]++)$#s', $pathinfo, $matches)) {
                return $this->mergeDefaults(array_replace($matches, array('_route' => 'valider_passeport')), array (  '_controller' => 'MyApp\\UserBundle\\Controller\\AdminPasseportController::valider_passeportAction',));
            }

            // supprimer_passeport
            if (0 === strpos($pathinfo, '/GestionEcitoyennitePlus/supprimer_passeportt') && preg_match('#^/GestionEcitoyennitePlus/supprimer_passeportt/(?P<numPasseport>[^/]++)$#s', $pathinfo, $matches)) {
                return $this->mergeDefaults(array_replace($matches, array('_route' => 'supprimer_passeport')), array (  '_controller' => 'MyApp\\UserBundle\\Controller\\AdminPasseportController::supprimer_passeportAction',));
            }

            // add_contratmariage
            if ($pathinfo === '/GestionEcitoyennitePlus/add_contrat') {
                return array (  '_controller' => 'MyApp\\UserBundle\\Controller\\ContratMariageController::add_contratmariageAction',  '_route' => 'add_contratmariage',);
            }

            // show_contratmariage
            if ($pathinfo === '/GestionEcitoyennitePlus/show_contrat') {
                return array (  '_controller' => 'MyApp\\UserBundle\\Controller\\ContratMariageController::show_ContratMariageAction',  '_route' => 'show_contratmariage',);
            }

            // edit_contrat_user
            if ($pathinfo === '/GestionEcitoyennitePlus/edit_contrat') {
                return array (  '_controller' => 'MyApp\\UserBundle\\Controller\\ContratMariageController::edit_contrat_userAction',  '_route' => 'edit_contrat_user',);
            }

            // admin_show_contrat
            if (0 === strpos($pathinfo, '/GestionEcitoyennitePlus/show_contrat') && preg_match('#^/GestionEcitoyennitePlus/show_contrat/(?P<id_contrat>[^/]++)$#s', $pathinfo, $matches)) {
                return $this->mergeDefaults(array_replace($matches, array('_route' => 'admin_show_contrat')), array (  '_controller' => 'MyApp\\UserBundle\\Controller\\AdminContratMariageController::show_contratAction',));
            }

            // liste_contrat
            if ($pathinfo === '/GestionEcitoyennitePlus/liste_contrat') {
                return array (  '_controller' => 'MyApp\\UserBundle\\Controller\\AdminContratMariageController::liste_contratAction',  '_route' => 'liste_contrat',);
            }

            // valider_contrat
            if (0 === strpos($pathinfo, '/GestionEcitoyennitePlus/valider_contrat') && preg_match('#^/GestionEcitoyennitePlus/valider_contrat/(?P<id_contrat>[^/]++)$#s', $pathinfo, $matches)) {
                return $this->mergeDefaults(array_replace($matches, array('_route' => 'valider_contrat')), array (  '_controller' => 'MyApp\\UserBundle\\Controller\\AdminContratMariageController::valider_contratAction',));
            }

            // supprimer_contrat
            if (0 === strpos($pathinfo, '/GestionEcitoyennitePlus/supprimer_contrat') && preg_match('#^/GestionEcitoyennitePlus/supprimer_contrat/(?P<id_contrat>[^/]++)$#s', $pathinfo, $matches)) {
                return $this->mergeDefaults(array_replace($matches, array('_route' => 'supprimer_contrat')), array (  '_controller' => 'MyApp\\UserBundle\\Controller\\AdminContratMariageController::supprimer_contrattAction',));
            }

            // _graphe_pie
            if ($pathinfo === '/GestionEcitoyennitePlus/pie') {
                return array (  '_controller' => 'MyApp\\UserBundle\\Controller\\GrapheController::chartPieAction',  '_route' => '_graphe_pie',);
            }

            // add_carte
            if ($pathinfo === '/GestionEcitoyennitePlus/add_carte') {
                return array (  '_controller' => 'MyApp\\UserBundle\\Controller\\SecuriteSocialeController::add_carteAction',  '_route' => 'add_carte',);
            }

            // show_carte
            if ($pathinfo === '/GestionEcitoyennitePlus/show_carte') {
                return array (  '_controller' => 'MyApp\\UserBundle\\Controller\\SecuriteSocialeController::show_carteAction',  '_route' => 'show_carte',);
            }

            // edit_carte_user
            if ($pathinfo === '/GestionEcitoyennitePlus/edit_carte_user') {
                return array (  '_controller' => 'MyApp\\UserBundle\\Controller\\SecuriteSocialeController::edit_carte_userAction',  '_route' => 'edit_carte_user',);
            }

            // admin_show_carte
            if (0 === strpos($pathinfo, '/GestionEcitoyennitePlus/show_carte') && preg_match('#^/GestionEcitoyennitePlus/show_carte/(?P<idSC>[^/]++)$#s', $pathinfo, $matches)) {
                return $this->mergeDefaults(array_replace($matches, array('_route' => 'admin_show_carte')), array (  '_controller' => 'MyApp\\UserBundle\\Controller\\AdminSecuriteSocialeController::show_carteAction',));
            }

            // liste_carte
            if ($pathinfo === '/GestionEcitoyennitePlus/liste_carte') {
                return array (  '_controller' => 'MyApp\\UserBundle\\Controller\\AdminSecuriteSocialeController::liste_carteAction',  '_route' => 'liste_carte',);
            }

            // supprimer_carte
            if (0 === strpos($pathinfo, '/GestionEcitoyennitePlus/supprimer_carte') && preg_match('#^/GestionEcitoyennitePlus/supprimer_carte/(?P<idSC>[^/]++)$#s', $pathinfo, $matches)) {
                return $this->mergeDefaults(array_replace($matches, array('_route' => 'supprimer_carte')), array (  '_controller' => 'MyApp\\UserBundle\\Controller\\AdminSecuriteSocialeController::supprimer_carteAction',));
            }

        }

        // entreprises
        if ($pathinfo === '/index1') {
            return array (  '_controller' => 'MyApp\\UserBundle\\Controller\\EntreprisesController::indexAction',  '_route' => 'entreprises',);
        }

        // entreprise_abouttn
        if ($pathinfo === '/abouttn') {
            return array (  '_controller' => 'MyApp\\UserBundle\\Controller\\EntreprisesController::abouttnAction',  '_route' => 'entreprise_abouttn',);
        }

        // entreprise_service
        if ($pathinfo === '/service') {
            return array (  '_controller' => 'MyApp\\UserBundle\\Controller\\EntreprisesController::serviceAction',  '_route' => 'entreprise_service',);
        }

        if (0 === strpos($pathinfo, '/e-')) {
            // entreprise_estudent
            if ($pathinfo === '/e-student') {
                return array (  '_controller' => 'MyApp\\UserBundle\\Controller\\EntreprisesController::estudentAction',  '_route' => 'entreprise_estudent',);
            }

            // entreprise_eroute
            if ($pathinfo === '/e-route') {
                return array (  '_controller' => 'MyApp\\UserBundle\\Controller\\EntreprisesController::erouteAction',  '_route' => 'entreprise_eroute',);
            }

            if (0 === strpos($pathinfo, '/e-citoyennite')) {
                // entreprise_ecitoyennite
                if ($pathinfo === '/e-citoyennite') {
                    return array (  '_controller' => 'MyApp\\UserBundle\\Controller\\EntreprisesController::ecitoyenniteAction',  '_route' => 'entreprise_ecitoyennite',);
                }

                // entreprise_ecitoyenniteplus
                if ($pathinfo === '/e-citoyennite+') {
                    return array (  '_controller' => 'MyApp\\UserBundle\\Controller\\EntreprisesController::ecitoyenniteplusAction',  '_route' => 'entreprise_ecitoyenniteplus',);
                }

            }

        }

        // entreprise_contact
        if ($pathinfo === '/contact') {
            return array (  '_controller' => 'MyApp\\UserBundle\\Controller\\EntreprisesController::contactAction',  '_route' => 'entreprise_contact',);
        }

        // entreprise_news
        if ($pathinfo === '/news') {
            return array (  '_controller' => 'MyApp\\UserBundle\\Controller\\EntreprisesController::newsAction',  '_route' => 'entreprise_news',);
        }

        // entreprise_ejob
        if ($pathinfo === '/e_jobe') {
            return array (  '_controller' => 'MyApp\\UserBundle\\Controller\\EntreprisesController::ejobAction',  '_route' => 'entreprise_ejob',);
        }

        if (0 === strpos($pathinfo, '/ad')) {
            if (0 === strpos($pathinfo, '/admin')) {
                // admin
                if ($pathinfo === '/admin') {
                    return array (  '_controller' => 'MyApp\\UserBundle\\Controller\\UtilisateurController::indexAdminAction',  '_route' => 'admin',);
                }

                if (0 === strpos($pathinfo, '/adminVisitor')) {
                    // visitor
                    if ($pathinfo === '/adminVisitor/index') {
                        return array (  '_controller' => 'MyApp\\UserBundle\\Controller\\VisitorController::indexAction',  '_route' => 'visitor',);
                    }

                    // visitor_abouttn
                    if ($pathinfo === '/adminVisitor/abouttn') {
                        return array (  '_controller' => 'MyApp\\UserBundle\\Controller\\VisitorController::abouttnAction',  '_route' => 'visitor_abouttn',);
                    }

                    // visitor_service
                    if ($pathinfo === '/adminVisitor/service') {
                        return array (  '_controller' => 'MyApp\\UserBundle\\Controller\\VisitorController::serviceAction',  '_route' => 'visitor_service',);
                    }

                    if (0 === strpos($pathinfo, '/adminVisitor/e')) {
                        // visitor_estudent
                        if ($pathinfo === '/adminVisitor/e-student') {
                            return array (  '_controller' => 'MyApp\\UserBundle\\Controller\\VisitorController::estudentAction',  '_route' => 'visitor_estudent',);
                        }

                        // visitor_eroute
                        if ($pathinfo === '/adminVisitor/eroute') {
                            return array (  '_controller' => 'MyApp\\UserBundle\\Controller\\VisitorController::erouteAction',  '_route' => 'visitor_eroute',);
                        }

                        if (0 === strpos($pathinfo, '/adminVisitor/e-citoyennite')) {
                            // visitor_ecitoyennite
                            if ($pathinfo === '/adminVisitor/e-citoyennite') {
                                return array (  '_controller' => 'MyApp\\UserBundle\\Controller\\VisitorController::ecitoyenniteAction',  '_route' => 'visitor_ecitoyennite',);
                            }

                            // visitor_ecitoyenniteplus
                            if ($pathinfo === '/adminVisitor/e-citoyennite+') {
                                return array (  '_controller' => 'MyApp\\UserBundle\\Controller\\VisitorController::ecitoyenniteplusAction',  '_route' => 'visitor_ecitoyenniteplus',);
                            }

                        }

                    }

                    // visitor_contact
                    if ($pathinfo === '/adminVisitor/contact') {
                        return array (  '_controller' => 'MyApp\\UserBundle\\Controller\\VisitorController::contactAction',  '_route' => 'visitor_contact',);
                    }

                    // visitor_news
                    if ($pathinfo === '/adminVisitor/news') {
                        return array (  '_controller' => 'MyApp\\UserBundle\\Controller\\VisitorController::newsAction',  '_route' => 'visitor_news',);
                    }

                    // visitor_ejob
                    if ($pathinfo === '/adminVisitor/e-job') {
                        return array (  '_controller' => 'MyApp\\UserBundle\\Controller\\VisitorController::ejobAction',  '_route' => 'visitor_ejob',);
                    }

                    // visitor_signin
                    if ($pathinfo === '/adminVisitor/log') {
                        return array (  '_controller' => 'MyApp\\UserBundle\\Controller\\VisitorController::signinAction',  '_route' => 'visitor_signin',);
                    }

                    // visitor_signup
                    if ($pathinfo === '/adminVisitor/signup') {
                        return array (  '_controller' => 'MyApp\\UserBundle\\Controller\\VisitorController::signupAction',  '_route' => 'visitor_signup',);
                    }

                    if (0 === strpos($pathinfo, '/adminVisitor/menu_')) {
                        // visitor_menu_permis
                        if ($pathinfo === '/adminVisitor/menu_permis') {
                            return array (  '_controller' => 'MyApp\\UserBundle\\Controller\\VisitorController::menu_permisAction',  '_route' => 'visitor_menu_permis',);
                        }

                        // visitor_menu_carte_grise
                        if ($pathinfo === '/adminVisitor/menu_carte_grise') {
                            return array (  '_controller' => 'MyApp\\UserBundle\\Controller\\VisitorController::menu_carte_griseAction',  '_route' => 'visitor_menu_carte_grise',);
                        }

                        // visitor_menu_attestation_residence
                        if ($pathinfo === '/adminVisitor/menu_attestation_residence') {
                            return array (  '_controller' => 'MyApp\\UserBundle\\Controller\\VisitorController::menu_attestation_residenceAction',  '_route' => 'visitor_menu_attestation_residence',);
                        }

                    }

                    if (0 === strpos($pathinfo, '/adminVisitor/ajout_')) {
                        // visitor_ajout_permis
                        if ($pathinfo === '/adminVisitor/ajout_permis') {
                            return array (  '_controller' => 'MyApp\\UserBundle\\Controller\\VisitorController::ajout_permisAction',  '_route' => 'visitor_ajout_permis',);
                        }

                        // visitor_ajout_carte_grise
                        if ($pathinfo === '/adminVisitor/ajout_carte_grise') {
                            return array (  '_controller' => 'MyApp\\UserBundle\\Controller\\VisitorController::ajout_carte_griseAction',  '_route' => 'visitor_ajout_carte_grise',);
                        }

                        // visitor_ajout_attestation_residence
                        if ($pathinfo === '/adminVisitor/ajout_attestation_residence') {
                            return array (  '_controller' => 'MyApp\\UserBundle\\Controller\\VisitorController::ajout_attestation_residenceAction',  '_route' => 'visitor_ajout_attestation_residence',);
                        }

                    }

                    if (0 === strpos($pathinfo, '/adminVisitor/edit_')) {
                        // visitor_edit_permis
                        if ($pathinfo === '/adminVisitor/edit_permis') {
                            return array (  '_controller' => 'MyApp\\UserBundle\\Controller\\VisitorController::edit_permisAction',  '_route' => 'visitor_edit_permis',);
                        }

                        // visitor_edit_carte_grise
                        if ($pathinfo === '/adminVisitor/edit_carte_grise') {
                            return array (  '_controller' => 'MyApp\\UserBundle\\Controller\\VisitorController::edit_carte_griseAction',  '_route' => 'visitor_edit_carte_grise',);
                        }

                        // visitor_edit_attestation_residence
                        if ($pathinfo === '/adminVisitor/edit_attestation_residence') {
                            return array (  '_controller' => 'MyApp\\UserBundle\\Controller\\VisitorController::edit_attestation_residenceAction',  '_route' => 'visitor_edit_attestation_residence',);
                        }

                    }

                    if (0 === strpos($pathinfo, '/adminVisitor/affiche_')) {
                        // visitor_affiche_permis
                        if ($pathinfo === '/adminVisitor/affiche_permis') {
                            return array (  '_controller' => 'MyApp\\UserBundle\\Controller\\VisitorController::affiche_permisAction',  '_route' => 'visitor_affiche_permis',);
                        }

                        // visitor_affiche_carte_grise
                        if ($pathinfo === '/adminVisitor/affiche_carte_grise') {
                            return array (  '_controller' => 'MyApp\\UserBundle\\Controller\\VisitorController::affiche_carte_griseAction',  '_route' => 'visitor_affiche_carte_grise',);
                        }

                        // visitor_affiche_attestation_residence
                        if ($pathinfo === '/adminVisitor/affiche_attestation_residence') {
                            return array (  '_controller' => 'MyApp\\UserBundle\\Controller\\VisitorController::affiche_attestation_residenceAction',  '_route' => 'visitor_affiche_attestation_residence',);
                        }

                    }

                }

            }

            // add_permis
            if ($pathinfo === '/add_permis') {
                return array (  '_controller' => 'MyApp\\UserBundle\\Controller\\PermisController::add_permisAction',  '_route' => 'add_permis',);
            }

        }

        // permispdf
        if ($pathinfo === '/permispdf') {
            return array (  '_controller' => 'MyApp\\UserBundle\\Controller\\PermisController::permisPdfAction',  '_route' => 'permispdf',);
        }

        // add_carte_grise
        if ($pathinfo === '/add_carte_grise') {
            return array (  '_controller' => 'MyApp\\UserBundle\\Controller\\CarteGriseController::add_carte_griseAction',  '_route' => 'add_carte_grise',);
        }

        // show_carte_grise
        if ($pathinfo === '/show_carte_grise') {
            return array (  '_controller' => 'MyApp\\UserBundle\\Controller\\CarteGriseController::show_carte_griseAction',  '_route' => 'show_carte_grise',);
        }

        // edit_carte_grise
        if ($pathinfo === '/edit_carte_grise') {
            return array (  '_controller' => 'MyApp\\UserBundle\\Controller\\CarteGriseController::edit_carte_griseAction',  '_route' => 'edit_carte_grise',);
        }

        // show_permis
        if ($pathinfo === '/show_permis') {
            return array (  '_controller' => 'MyApp\\UserBundle\\Controller\\PermisController::show_permisAction',  '_route' => 'show_permis',);
        }

        // menu_permis1
        if ($pathinfo === '/menu_permis1') {
            return array (  '_controller' => 'MyApp\\UserBundle\\Controller\\PermisController::menuAction',  '_route' => 'menu_permis1',);
        }

        if (0 === strpos($pathinfo, '/liste_')) {
            // liste_permis
            if ($pathinfo === '/liste_permis') {
                return array (  '_controller' => 'MyApp\\UserBundle\\Controller\\AdminPcController::liste_permisAction',  '_route' => 'liste_permis',);
            }

            // liste_carte_grise
            if ($pathinfo === '/liste_carte_grise') {
                return array (  '_controller' => 'MyApp\\UserBundle\\Controller\\AdminCGController::liste_carte_griseAction',  '_route' => 'liste_carte_grise',);
            }

        }

        if (0 === strpos($pathinfo, '/show_')) {
            // show_carte_grise_admin
            if (0 === strpos($pathinfo, '/show_carte_grise_admin') && preg_match('#^/show_carte_grise_admin/(?P<idCarteGrise>[^/]++)$#s', $pathinfo, $matches)) {
                return $this->mergeDefaults(array_replace($matches, array('_route' => 'show_carte_grise_admin')), array (  '_controller' => 'MyApp\\UserBundle\\Controller\\AdminCGController::show_carte_grise_adminAction',));
            }

            // show_permis_admin
            if (0 === strpos($pathinfo, '/show_permis') && preg_match('#^/show_permis/(?P<numPermis>[^/]++)$#s', $pathinfo, $matches)) {
                return $this->mergeDefaults(array_replace($matches, array('_route' => 'show_permis_admin')), array (  '_controller' => 'MyApp\\UserBundle\\Controller\\AdminPcController::show_permisAction',));
            }

        }

        if (0 === strpos($pathinfo, '/valider_')) {
            // valider_permis
            if (0 === strpos($pathinfo, '/valider_permis') && preg_match('#^/valider_permis/(?P<numPermis>[^/]++)$#s', $pathinfo, $matches)) {
                return $this->mergeDefaults(array_replace($matches, array('_route' => 'valider_permis')), array (  '_controller' => 'MyApp\\UserBundle\\Controller\\AdminPcController::valider_permisAction',));
            }

            // valider_carte
            if (0 === strpos($pathinfo, '/valider_carte') && preg_match('#^/valider_carte/(?P<idCarteGrise>[^/]++)$#s', $pathinfo, $matches)) {
                return $this->mergeDefaults(array_replace($matches, array('_route' => 'valider_carte')), array (  '_controller' => 'MyApp\\UserBundle\\Controller\\AdminCGController::valider_carteAction',));
            }

        }

        if (0 === strpos($pathinfo, '/supprimer_')) {
            // supprimer_permis
            if (0 === strpos($pathinfo, '/supprimer_permis') && preg_match('#^/supprimer_permis/(?P<numPermis>[^/]++)$#s', $pathinfo, $matches)) {
                return $this->mergeDefaults(array_replace($matches, array('_route' => 'supprimer_permis')), array (  '_controller' => 'MyApp\\UserBundle\\Controller\\AdminPcController::supprimer_permisAction',));
            }

            // supprimer_carte_grise
            if (0 === strpos($pathinfo, '/supprimer_carte_grise') && preg_match('#^/supprimer_carte_grise/(?P<idCarteGrise>[^/]++)$#s', $pathinfo, $matches)) {
                return $this->mergeDefaults(array_replace($matches, array('_route' => 'supprimer_carte_grise')), array (  '_controller' => 'MyApp\\UserBundle\\Controller\\AdminCGController::supprimer_carte_griseAction',));
            }

        }

        // edit_permis_user
        if ($pathinfo === '/edit_permis_user') {
            return array (  '_controller' => 'MyApp\\UserBundle\\Controller\\PermisController::edit_permis_userAction',  '_route' => 'edit_permis_user',);
        }

        // permis_rech
        if ($pathinfo === '/rech') {
            return array (  '_controller' => 'MyApp\\UserBundle\\Controller\\AdminPcController::rechAction',  '_route' => 'permis_rech',);
        }

        // carte_rech
        if ($pathinfo === '/carte_rech') {
            return array (  '_controller' => 'MyApp\\UserBundle\\Controller\\AdminCGController::rechAction',  '_route' => 'carte_rech',);
        }

        // add_user
        if ($pathinfo === '/add_user') {
            return array (  '_controller' => 'MyApp\\UserBundle\\Controller\\UserController::add_userAction',  '_route' => 'add_user',);
        }

        // show_user
        if ($pathinfo === '/show_user') {
            return array (  '_controller' => 'MyApp\\UserBundle\\Controller\\UserController::show_userAction',  '_route' => 'show_user',);
        }

        if (0 === strpos($pathinfo, '/log')) {
            if (0 === strpos($pathinfo, '/login')) {
                // fos_user_security_login
                if ($pathinfo === '/login') {
                    if (!in_array($this->context->getMethod(), array('GET', 'POST', 'HEAD'))) {
                        $allow = array_merge($allow, array('GET', 'POST', 'HEAD'));
                        goto not_fos_user_security_login;
                    }

                    return array (  '_controller' => 'FOS\\UserBundle\\Controller\\SecurityController::loginAction',  '_route' => 'fos_user_security_login',);
                }
                not_fos_user_security_login:

                // fos_user_security_check
                if ($pathinfo === '/login_check') {
                    if ($this->context->getMethod() != 'POST') {
                        $allow[] = 'POST';
                        goto not_fos_user_security_check;
                    }

                    return array (  '_controller' => 'FOS\\UserBundle\\Controller\\SecurityController::checkAction',  '_route' => 'fos_user_security_check',);
                }
                not_fos_user_security_check:

            }

            // fos_user_security_logout
            if ($pathinfo === '/logout') {
                if (!in_array($this->context->getMethod(), array('GET', 'HEAD'))) {
                    $allow = array_merge($allow, array('GET', 'HEAD'));
                    goto not_fos_user_security_logout;
                }

                return array (  '_controller' => 'FOS\\UserBundle\\Controller\\SecurityController::logoutAction',  '_route' => 'fos_user_security_logout',);
            }
            not_fos_user_security_logout:

        }

        if (0 === strpos($pathinfo, '/profile')) {
            // fos_user_profile_show
            if (rtrim($pathinfo, '/') === '/profile') {
                if (!in_array($this->context->getMethod(), array('GET', 'HEAD'))) {
                    $allow = array_merge($allow, array('GET', 'HEAD'));
                    goto not_fos_user_profile_show;
                }

                if (substr($pathinfo, -1) !== '/') {
                    return $this->redirect($pathinfo.'/', 'fos_user_profile_show');
                }

                return array (  '_controller' => 'FOS\\UserBundle\\Controller\\ProfileController::showAction',  '_route' => 'fos_user_profile_show',);
            }
            not_fos_user_profile_show:

            // fos_user_profile_edit
            if ($pathinfo === '/profile/edit') {
                if (!in_array($this->context->getMethod(), array('GET', 'POST', 'HEAD'))) {
                    $allow = array_merge($allow, array('GET', 'POST', 'HEAD'));
                    goto not_fos_user_profile_edit;
                }

                return array (  '_controller' => 'FOS\\UserBundle\\Controller\\ProfileController::editAction',  '_route' => 'fos_user_profile_edit',);
            }
            not_fos_user_profile_edit:

        }

        if (0 === strpos($pathinfo, '/re')) {
            if (0 === strpos($pathinfo, '/register')) {
                // fos_user_registration_register
                if (rtrim($pathinfo, '/') === '/register') {
                    if (!in_array($this->context->getMethod(), array('GET', 'POST', 'HEAD'))) {
                        $allow = array_merge($allow, array('GET', 'POST', 'HEAD'));
                        goto not_fos_user_registration_register;
                    }

                    if (substr($pathinfo, -1) !== '/') {
                        return $this->redirect($pathinfo.'/', 'fos_user_registration_register');
                    }

                    return array (  '_controller' => 'FOS\\UserBundle\\Controller\\RegistrationController::registerAction',  '_route' => 'fos_user_registration_register',);
                }
                not_fos_user_registration_register:

                if (0 === strpos($pathinfo, '/register/c')) {
                    // fos_user_registration_check_email
                    if ($pathinfo === '/register/check-email') {
                        if (!in_array($this->context->getMethod(), array('GET', 'HEAD'))) {
                            $allow = array_merge($allow, array('GET', 'HEAD'));
                            goto not_fos_user_registration_check_email;
                        }

                        return array (  '_controller' => 'FOS\\UserBundle\\Controller\\RegistrationController::checkEmailAction',  '_route' => 'fos_user_registration_check_email',);
                    }
                    not_fos_user_registration_check_email:

                    if (0 === strpos($pathinfo, '/register/confirm')) {
                        // fos_user_registration_confirm
                        if (preg_match('#^/register/confirm/(?P<token>[^/]++)$#s', $pathinfo, $matches)) {
                            if (!in_array($this->context->getMethod(), array('GET', 'HEAD'))) {
                                $allow = array_merge($allow, array('GET', 'HEAD'));
                                goto not_fos_user_registration_confirm;
                            }

                            return $this->mergeDefaults(array_replace($matches, array('_route' => 'fos_user_registration_confirm')), array (  '_controller' => 'FOS\\UserBundle\\Controller\\RegistrationController::confirmAction',));
                        }
                        not_fos_user_registration_confirm:

                        // fos_user_registration_confirmed
                        if ($pathinfo === '/register/confirmed') {
                            if (!in_array($this->context->getMethod(), array('GET', 'HEAD'))) {
                                $allow = array_merge($allow, array('GET', 'HEAD'));
                                goto not_fos_user_registration_confirmed;
                            }

                            return array (  '_controller' => 'FOS\\UserBundle\\Controller\\RegistrationController::confirmedAction',  '_route' => 'fos_user_registration_confirmed',);
                        }
                        not_fos_user_registration_confirmed:

                    }

                }

            }

            if (0 === strpos($pathinfo, '/resetting')) {
                // fos_user_resetting_request
                if ($pathinfo === '/resetting/request') {
                    if (!in_array($this->context->getMethod(), array('GET', 'HEAD'))) {
                        $allow = array_merge($allow, array('GET', 'HEAD'));
                        goto not_fos_user_resetting_request;
                    }

                    return array (  '_controller' => 'FOS\\UserBundle\\Controller\\ResettingController::requestAction',  '_route' => 'fos_user_resetting_request',);
                }
                not_fos_user_resetting_request:

                // fos_user_resetting_send_email
                if ($pathinfo === '/resetting/send-email') {
                    if ($this->context->getMethod() != 'POST') {
                        $allow[] = 'POST';
                        goto not_fos_user_resetting_send_email;
                    }

                    return array (  '_controller' => 'FOS\\UserBundle\\Controller\\ResettingController::sendEmailAction',  '_route' => 'fos_user_resetting_send_email',);
                }
                not_fos_user_resetting_send_email:

                // fos_user_resetting_check_email
                if ($pathinfo === '/resetting/check-email') {
                    if (!in_array($this->context->getMethod(), array('GET', 'HEAD'))) {
                        $allow = array_merge($allow, array('GET', 'HEAD'));
                        goto not_fos_user_resetting_check_email;
                    }

                    return array (  '_controller' => 'FOS\\UserBundle\\Controller\\ResettingController::checkEmailAction',  '_route' => 'fos_user_resetting_check_email',);
                }
                not_fos_user_resetting_check_email:

                // fos_user_resetting_reset
                if (0 === strpos($pathinfo, '/resetting/reset') && preg_match('#^/resetting/reset/(?P<token>[^/]++)$#s', $pathinfo, $matches)) {
                    if (!in_array($this->context->getMethod(), array('GET', 'POST', 'HEAD'))) {
                        $allow = array_merge($allow, array('GET', 'POST', 'HEAD'));
                        goto not_fos_user_resetting_reset;
                    }

                    return $this->mergeDefaults(array_replace($matches, array('_route' => 'fos_user_resetting_reset')), array (  '_controller' => 'FOS\\UserBundle\\Controller\\ResettingController::resetAction',));
                }
                not_fos_user_resetting_reset:

            }

        }

        // fos_user_change_password
        if ($pathinfo === '/profile/change-password') {
            if (!in_array($this->context->getMethod(), array('GET', 'POST', 'HEAD'))) {
                $allow = array_merge($allow, array('GET', 'POST', 'HEAD'));
                goto not_fos_user_change_password;
            }

            return array (  '_controller' => 'FOS\\UserBundle\\Controller\\ChangePasswordController::changePasswordAction',  '_route' => 'fos_user_change_password',);
        }
        not_fos_user_change_password:

        if (0 === strpos($pathinfo, '/api/threads')) {
            // fos_comment_new_threads
            if (0 === strpos($pathinfo, '/api/threads/new') && preg_match('#^/api/threads/new(?:\\.(?P<_format>json|xml|html))?$#s', $pathinfo, $matches)) {
                if (!in_array($this->context->getMethod(), array('GET', 'HEAD'))) {
                    $allow = array_merge($allow, array('GET', 'HEAD'));
                    goto not_fos_comment_new_threads;
                }

                return $this->mergeDefaults(array_replace($matches, array('_route' => 'fos_comment_new_threads')), array (  '_controller' => 'FOS\\CommentBundle\\Controller\\ThreadController::newThreadsAction',  '_format' => 'html',));
            }
            not_fos_comment_new_threads:

            // fos_comment_edit_thread_commentable
            if (preg_match('#^/api/threads/(?P<id>[^/]++)/commentable/edit(?:\\.(?P<_format>json|xml|html))?$#s', $pathinfo, $matches)) {
                if (!in_array($this->context->getMethod(), array('GET', 'HEAD'))) {
                    $allow = array_merge($allow, array('GET', 'HEAD'));
                    goto not_fos_comment_edit_thread_commentable;
                }

                return $this->mergeDefaults(array_replace($matches, array('_route' => 'fos_comment_edit_thread_commentable')), array (  '_controller' => 'FOS\\CommentBundle\\Controller\\ThreadController::editThreadCommentableAction',  '_format' => 'html',));
            }
            not_fos_comment_edit_thread_commentable:

            // fos_comment_new_thread_comments
            if (preg_match('#^/api/threads/(?P<id>[^/]++)/comments/new(?:\\.(?P<_format>json|xml|html))?$#s', $pathinfo, $matches)) {
                if (!in_array($this->context->getMethod(), array('GET', 'HEAD'))) {
                    $allow = array_merge($allow, array('GET', 'HEAD'));
                    goto not_fos_comment_new_thread_comments;
                }

                return $this->mergeDefaults(array_replace($matches, array('_route' => 'fos_comment_new_thread_comments')), array (  '_controller' => 'FOS\\CommentBundle\\Controller\\ThreadController::newThreadCommentsAction',  '_format' => 'html',));
            }
            not_fos_comment_new_thread_comments:

            // fos_comment_remove_thread_comment
            if (preg_match('#^/api/threads/(?P<id>[^/]++)/comments/(?P<commentId>[^/]++)/remove(?:\\.(?P<_format>json|xml|html))?$#s', $pathinfo, $matches)) {
                if (!in_array($this->context->getMethod(), array('GET', 'HEAD'))) {
                    $allow = array_merge($allow, array('GET', 'HEAD'));
                    goto not_fos_comment_remove_thread_comment;
                }

                return $this->mergeDefaults(array_replace($matches, array('_route' => 'fos_comment_remove_thread_comment')), array (  '_controller' => 'FOS\\CommentBundle\\Controller\\ThreadController::removeThreadCommentAction',  '_format' => 'html',));
            }
            not_fos_comment_remove_thread_comment:

            // fos_comment_edit_thread_comment
            if (preg_match('#^/api/threads/(?P<id>[^/]++)/comments/(?P<commentId>[^/]++)/edit(?:\\.(?P<_format>json|xml|html))?$#s', $pathinfo, $matches)) {
                if (!in_array($this->context->getMethod(), array('GET', 'HEAD'))) {
                    $allow = array_merge($allow, array('GET', 'HEAD'));
                    goto not_fos_comment_edit_thread_comment;
                }

                return $this->mergeDefaults(array_replace($matches, array('_route' => 'fos_comment_edit_thread_comment')), array (  '_controller' => 'FOS\\CommentBundle\\Controller\\ThreadController::editThreadCommentAction',  '_format' => 'html',));
            }
            not_fos_comment_edit_thread_comment:

            // fos_comment_new_thread_comment_votes
            if (preg_match('#^/api/threads/(?P<id>[^/]++)/comments/(?P<commentId>[^/]++)/votes/new(?:\\.(?P<_format>json|xml|html))?$#s', $pathinfo, $matches)) {
                if (!in_array($this->context->getMethod(), array('GET', 'HEAD'))) {
                    $allow = array_merge($allow, array('GET', 'HEAD'));
                    goto not_fos_comment_new_thread_comment_votes;
                }

                return $this->mergeDefaults(array_replace($matches, array('_route' => 'fos_comment_new_thread_comment_votes')), array (  '_controller' => 'FOS\\CommentBundle\\Controller\\ThreadController::newThreadCommentVotesAction',  '_format' => 'html',));
            }
            not_fos_comment_new_thread_comment_votes:

            // fos_comment_get_thread
            if (preg_match('#^/api/threads/(?P<id>[^/\\.]++)(?:\\.(?P<_format>json|xml|html))?$#s', $pathinfo, $matches)) {
                if (!in_array($this->context->getMethod(), array('GET', 'HEAD'))) {
                    $allow = array_merge($allow, array('GET', 'HEAD'));
                    goto not_fos_comment_get_thread;
                }

                return $this->mergeDefaults(array_replace($matches, array('_route' => 'fos_comment_get_thread')), array (  '_controller' => 'FOS\\CommentBundle\\Controller\\ThreadController::getThreadAction',  '_format' => 'html',));
            }
            not_fos_comment_get_thread:

            // fos_comment_get_threads
            if (preg_match('#^/api/threads(?:\\.(?P<_format>json|xml|html))?$#s', $pathinfo, $matches)) {
                if (!in_array($this->context->getMethod(), array('GET', 'HEAD'))) {
                    $allow = array_merge($allow, array('GET', 'HEAD'));
                    goto not_fos_comment_get_threads;
                }

                return $this->mergeDefaults(array_replace($matches, array('_route' => 'fos_comment_get_threads')), array (  '_controller' => 'FOS\\CommentBundle\\Controller\\ThreadController::getThreadsActions',  '_format' => 'html',));
            }
            not_fos_comment_get_threads:

            // fos_comment_post_threads
            if (preg_match('#^/api/threads(?:\\.(?P<_format>json|xml|html))?$#s', $pathinfo, $matches)) {
                if ($this->context->getMethod() != 'POST') {
                    $allow[] = 'POST';
                    goto not_fos_comment_post_threads;
                }

                return $this->mergeDefaults(array_replace($matches, array('_route' => 'fos_comment_post_threads')), array (  '_controller' => 'FOS\\CommentBundle\\Controller\\ThreadController::postThreadsAction',  '_format' => 'html',));
            }
            not_fos_comment_post_threads:

            // fos_comment_patch_thread_commentable
            if (preg_match('#^/api/threads/(?P<id>[^/]++)/commentable(?:\\.(?P<_format>json|xml|html))?$#s', $pathinfo, $matches)) {
                if ($this->context->getMethod() != 'PATCH') {
                    $allow[] = 'PATCH';
                    goto not_fos_comment_patch_thread_commentable;
                }

                return $this->mergeDefaults(array_replace($matches, array('_route' => 'fos_comment_patch_thread_commentable')), array (  '_controller' => 'FOS\\CommentBundle\\Controller\\ThreadController::patchThreadCommentableAction',  '_format' => 'html',));
            }
            not_fos_comment_patch_thread_commentable:

            // fos_comment_get_thread_comment
            if (preg_match('#^/api/threads/(?P<id>[^/]++)/comments/(?P<commentId>[^/\\.]++)(?:\\.(?P<_format>json|xml|html))?$#s', $pathinfo, $matches)) {
                if (!in_array($this->context->getMethod(), array('GET', 'HEAD'))) {
                    $allow = array_merge($allow, array('GET', 'HEAD'));
                    goto not_fos_comment_get_thread_comment;
                }

                return $this->mergeDefaults(array_replace($matches, array('_route' => 'fos_comment_get_thread_comment')), array (  '_controller' => 'FOS\\CommentBundle\\Controller\\ThreadController::getThreadCommentAction',  '_format' => 'html',));
            }
            not_fos_comment_get_thread_comment:

            // fos_comment_patch_thread_comment_state
            if (preg_match('#^/api/threads/(?P<id>[^/]++)/comments/(?P<commentId>[^/]++)/state(?:\\.(?P<_format>json|xml|html))?$#s', $pathinfo, $matches)) {
                if ($this->context->getMethod() != 'PATCH') {
                    $allow[] = 'PATCH';
                    goto not_fos_comment_patch_thread_comment_state;
                }

                return $this->mergeDefaults(array_replace($matches, array('_route' => 'fos_comment_patch_thread_comment_state')), array (  '_controller' => 'FOS\\CommentBundle\\Controller\\ThreadController::patchThreadCommentStateAction',  '_format' => 'html',));
            }
            not_fos_comment_patch_thread_comment_state:

            // fos_comment_put_thread_comments
            if (preg_match('#^/api/threads/(?P<id>[^/]++)/comments/(?P<commentId>[^/\\.]++)(?:\\.(?P<_format>json|xml|html))?$#s', $pathinfo, $matches)) {
                if ($this->context->getMethod() != 'PUT') {
                    $allow[] = 'PUT';
                    goto not_fos_comment_put_thread_comments;
                }

                return $this->mergeDefaults(array_replace($matches, array('_route' => 'fos_comment_put_thread_comments')), array (  '_controller' => 'FOS\\CommentBundle\\Controller\\ThreadController::putThreadCommentsAction',  '_format' => 'html',));
            }
            not_fos_comment_put_thread_comments:

            // fos_comment_get_thread_comments
            if (preg_match('#^/api/threads/(?P<id>[^/]++)/comments(?:\\.(?P<_format>json|xml|html))?$#s', $pathinfo, $matches)) {
                if (!in_array($this->context->getMethod(), array('GET', 'HEAD'))) {
                    $allow = array_merge($allow, array('GET', 'HEAD'));
                    goto not_fos_comment_get_thread_comments;
                }

                return $this->mergeDefaults(array_replace($matches, array('_route' => 'fos_comment_get_thread_comments')), array (  '_controller' => 'FOS\\CommentBundle\\Controller\\ThreadController::getThreadCommentsAction',  '_format' => 'html',));
            }
            not_fos_comment_get_thread_comments:

            // fos_comment_post_thread_comments
            if (preg_match('#^/api/threads/(?P<id>[^/]++)/comments(?:\\.(?P<_format>json|xml|html))?$#s', $pathinfo, $matches)) {
                if ($this->context->getMethod() != 'POST') {
                    $allow[] = 'POST';
                    goto not_fos_comment_post_thread_comments;
                }

                return $this->mergeDefaults(array_replace($matches, array('_route' => 'fos_comment_post_thread_comments')), array (  '_controller' => 'FOS\\CommentBundle\\Controller\\ThreadController::postThreadCommentsAction',  '_format' => 'html',));
            }
            not_fos_comment_post_thread_comments:

            // fos_comment_get_thread_comment_votes
            if (preg_match('#^/api/threads/(?P<id>[^/]++)/comments/(?P<commentId>[^/]++)/votes(?:\\.(?P<_format>json|xml|html))?$#s', $pathinfo, $matches)) {
                if (!in_array($this->context->getMethod(), array('GET', 'HEAD'))) {
                    $allow = array_merge($allow, array('GET', 'HEAD'));
                    goto not_fos_comment_get_thread_comment_votes;
                }

                return $this->mergeDefaults(array_replace($matches, array('_route' => 'fos_comment_get_thread_comment_votes')), array (  '_controller' => 'FOS\\CommentBundle\\Controller\\ThreadController::getThreadCommentVotesAction',  '_format' => 'html',));
            }
            not_fos_comment_get_thread_comment_votes:

            // fos_comment_post_thread_comment_votes
            if (preg_match('#^/api/threads/(?P<id>[^/]++)/comments/(?P<commentId>[^/]++)/votes(?:\\.(?P<_format>json|xml|html))?$#s', $pathinfo, $matches)) {
                if ($this->context->getMethod() != 'POST') {
                    $allow[] = 'POST';
                    goto not_fos_comment_post_thread_comment_votes;
                }

                return $this->mergeDefaults(array_replace($matches, array('_route' => 'fos_comment_post_thread_comment_votes')), array (  '_controller' => 'FOS\\CommentBundle\\Controller\\ThreadController::postThreadCommentVotesAction',  '_format' => 'html',));
            }
            not_fos_comment_post_thread_comment_votes:

        }

        // _welcome
        if (rtrim($pathinfo, '/') === '') {
            if (substr($pathinfo, -1) !== '/') {
                return $this->redirect($pathinfo.'/', '_welcome');
            }

            return array (  '_controller' => 'Acme\\DemoBundle\\Controller\\WelcomeController::indexAction',  '_route' => '_welcome',);
        }

        if (0 === strpos($pathinfo, '/demo')) {
            if (0 === strpos($pathinfo, '/demo/secured')) {
                if (0 === strpos($pathinfo, '/demo/secured/log')) {
                    if (0 === strpos($pathinfo, '/demo/secured/login')) {
                        // _demo_login
                        if ($pathinfo === '/demo/secured/login') {
                            return array (  '_controller' => 'Acme\\DemoBundle\\Controller\\SecuredController::loginAction',  '_route' => '_demo_login',);
                        }

                        // _demo_security_check
                        if ($pathinfo === '/demo/secured/login_check') {
                            return array (  '_controller' => 'Acme\\DemoBundle\\Controller\\SecuredController::securityCheckAction',  '_route' => '_demo_security_check',);
                        }

                    }

                    // _demo_logout
                    if ($pathinfo === '/demo/secured/logout') {
                        return array (  '_controller' => 'Acme\\DemoBundle\\Controller\\SecuredController::logoutAction',  '_route' => '_demo_logout',);
                    }

                }

                if (0 === strpos($pathinfo, '/demo/secured/hello')) {
                    // acme_demo_secured_hello
                    if ($pathinfo === '/demo/secured/hello') {
                        return array (  'name' => 'World',  '_controller' => 'Acme\\DemoBundle\\Controller\\SecuredController::helloAction',  '_route' => 'acme_demo_secured_hello',);
                    }

                    // _demo_secured_hello
                    if (preg_match('#^/demo/secured/hello/(?P<name>[^/]++)$#s', $pathinfo, $matches)) {
                        return $this->mergeDefaults(array_replace($matches, array('_route' => '_demo_secured_hello')), array (  '_controller' => 'Acme\\DemoBundle\\Controller\\SecuredController::helloAction',));
                    }

                    // _demo_secured_hello_admin
                    if (0 === strpos($pathinfo, '/demo/secured/hello/admin') && preg_match('#^/demo/secured/hello/admin/(?P<name>[^/]++)$#s', $pathinfo, $matches)) {
                        return $this->mergeDefaults(array_replace($matches, array('_route' => '_demo_secured_hello_admin')), array (  '_controller' => 'Acme\\DemoBundle\\Controller\\SecuredController::helloadminAction',));
                    }

                }

            }

            // _demo
            if (rtrim($pathinfo, '/') === '/demo') {
                if (substr($pathinfo, -1) !== '/') {
                    return $this->redirect($pathinfo.'/', '_demo');
                }

                return array (  '_controller' => 'Acme\\DemoBundle\\Controller\\DemoController::indexAction',  '_route' => '_demo',);
            }

            // _demo_hello
            if (0 === strpos($pathinfo, '/demo/hello') && preg_match('#^/demo/hello/(?P<name>[^/]++)$#s', $pathinfo, $matches)) {
                return $this->mergeDefaults(array_replace($matches, array('_route' => '_demo_hello')), array (  '_controller' => 'Acme\\DemoBundle\\Controller\\DemoController::helloAction',));
            }

            // _demo_contact
            if ($pathinfo === '/demo/contact') {
                return array (  '_controller' => 'Acme\\DemoBundle\\Controller\\DemoController::contactAction',  '_route' => '_demo_contact',);
            }

        }

        throw 0 < count($allow) ? new MethodNotAllowedException(array_unique($allow)) : new ResourceNotFoundException();
    }
}
