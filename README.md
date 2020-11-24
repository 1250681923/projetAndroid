# Newsletter
 
Quan ZHANG: 1250681923

Yue ZHAO: yuejanet

Yajuan LUO: luoyajuan



## Fonctionnalités：
Les principales fonctionnalités à implémenter incluent (mais ne se limitent pas seulement à :

### Page d'accueil de l'application
La mise en place de la page d'accueil de l'application dans laquelle les options de consulation sont organisées :

- Par éditeurs (https://newsapi.org/docs/endpoints/sources)
- Par catégories: Politique, Economie, Education, Pandémie,
- Par pays : France, Chine, Etats Unis, Angleterre….

### Liste des articles par catégorie
Quand l'utilisateur selectionne un article sur la page d'accueil, afficher tous les articles correspondant à cette catégorie dans un fragment. 

La vue doit contenir : 
 - Le titre de l'article, 
 - un appercu du contenu du message (3 lignes maximum)
 - L'auteur de l'article
 - La date de publication 
 - L'image liée à l'article
 - un bouton permettant d'ajouter un article en favori (un coeur). Le coeur creux si l'article n'est pas en favori, sinon il est plein.  

### Gestion des favoris 
Quand l'utilisateur clique sur l'icone favori, il faut sauvegarder l'article dans une base de données locales.

Définir une vue permettant à l'utilisateur de voir tous ses articles favoris. Le lien vers cette vue doit être placée dans la barre de navigation en haut à droite dans la page d'accueil et dans la la vue liste d'articles. 

### Détail d'un article
Quand l'utilisateur clique sur un article, créer une vue permettant d'afficher le détail de l'article. Cette vue doit afficher toutes les informations de l'article ainsi qu'un lien vers le site de l'éditeur. 
Le lien doit ouvrir une page web dans un navigateur externe.

> Ajouter une option dans la barre d'action permettant à l'utilisateur d'ajouter en favori l'article qu'il est entrain de visualiser. 

### Vue à propos de nous
Ajouter une vue permettant d'afficher des détails sur l'application. Cette vue doit afficher : 

- Les noms et prénoms des membres du groupe (une photo aussi si vous le voulez)
- Un lien vers le repo du projet (sur Github)
- La liste des librairies externes utilisées dans l'applications
- La liste des fonctionnalités de l'application 

Ajouter une option en haut à droite de la toolbar permettant d'afficher la vue à propos de nous. 
