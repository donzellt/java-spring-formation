Box vagrant pour la formation :
https://repos.agora-t.net/artifactory/webapp/#/artifacts/browse/tree/General/boxes/ccl/formation-java

Faire un vagrant up sur le fichier Vagrantfile

Il s'agit d'une box sous ubuntu.

Pour mettre � jour la box :
r�cup�rer jfrogcli (jfrog.exe) : https://jfrog.com/getcli/
D�finir les variables d'environnement http_proxy et https_proxy ==> proxy thales
G�n�rez vous une cl� artifactory : https://repos.agora-t.net/artifactory/webapp/#/profile ==> <APIKEY>
Changer la <X.X.X> et <APIKEY> dans la commande suivante : 
.\jfrog.exe rt upload --url https://repos.agora-t.net/artifactory --apikey <APIKEY> --props "box_name=ccl-formation-java;box_provider=virtualbox;box_version=<X.X.X>" ./formation-java.box boxes/ccl/formation/formation-java-<X.X.X>.box

Documentation pour l'import d'une box : https://confluence.agora-t.net/pages/viewpage.action?pageId=14493169#ManuelD%C3%A9veloppeur-Importd'unebox

Extrait de la documentation :
Vagrant
Configuration de l'import

Pour faciliter l'import il faut configurer jfrog-cli avec la commande "jfrog rt config"
Import d'une box

Pour importer une box utiliser la commande suivante:

Avec jfrog-cli
jfrog-cli
jfrog rt upload --url https://repos.agora-t.net/artifactory --apikey <APIKEY> --props "box_name=<GROUP>-<NAME>;box_provider=<PROVIDER>;box_version=<VERSION>" <PATH_TO_FILE> boxes/<GROUP>/<NAME>/<NAME>-<VERSION>.box

Param�tres:

    APIKEY: cl� api

    PATH_TO_FILE: chemin de la box
    GROUP: groupe/projet de la box
    NAME: nom court de la box
    PROVIDER: provider (ex: virtualbox)
    VERSION: version au format `[0-9]-[0-9]-[0-9]`

En cas de probl�me avec jfrog-cli
import_box  D�velopper la source
Import du vagrantfile

S'assurer de mettre le bon lien dans le Vagrantfile:
Vagrantfile
# Installation
config.vm.box = "<GROUP>-<NAME>"
config.vm.box_url = "https://repos.agora-t.net/artifactory/api/vagrant/boxes/<GROUP>-<NAME>"


Avec jfrgo-cli
jfrog rt upload --url https://repos.agora-t.net/artifactory --apikey <APIKEY> --props "box_name=<GROUP>-<NAME>" Vagrantfile boxes/<GROUP>/<NAME>/Vagrantfile
