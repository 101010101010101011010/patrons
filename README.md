Patrons / Nicolas / 13 Décembre

![SVG du PUML du projet](/PatronsPUML.svg)

> **_Note:_** Pour rouler le jeu, écris `.\run.ps1` dans le terminale. Ce script applique l'espace de code 65001 (UTF-8) afin que les emoji soit bien présentés puis il roule ensuite le program.

## Fabrique abstraite
#### Catégorie
Patrons de création
#### Utilité
Le patron de conception `fabrique abstraite` est utile dans des cas où plusieurs items spécifiques ont des implémentations qui diffèrent selon un critère globale.

---

Par exemple, il pourrait y avoir des cabinets, aimants, et tapis à souris, toutes utilisés pour des tables. S'il y a plusieurs types de tables, comme anchré, anglé, de verre, à l'envers, chaque item aura besoin d'une implémentation entièrement différente qu'un autre de la même espèce. Le tableau qui suit démontre que, si l'on veut accéder un item, il faut savoir son nom au complet d'avance

> **_Note:_** le HTML n'est pas complètement supporté dans les fichiers de Markdown README sur Github en raison d'exploits possibles. Ainsi, pour voir le README interactif, veuillez voir la version dans un Git pull ou dans le Zip du projet.

<style  type="text/css">

  th, td {
    text-align: center; 
    vertical-align: middle;
    border: 1px solid black;
  }

  td.hide {
    border: 0px solid black;
    visibility: hidden;
  }

  td.hidetext {
    visibility: hidden;
  }

  .nohover {
    background-color: transparent !important;
  }

  table {
    overflow: hidden;
  }

  .table2angle {
    background-color: #4d4d4d;
  }

  .table2cabinet {
    background-color: #4d4d4d;
    
  }

  .table2anglehighlight {
    background-color: #808080;
  }

  .table2cabinet:not(:hover) {
    background-color: transparent;
  }

  .table2cabinet:not(:hover) .table2anglehighlight {
    color: #4d4d4d;
    background-color: #4d4d4d;
  }

</style>

<table>
  <tr>
    <td colspan="2" class="hide"></td>
    <th colspan="4">Critères</th>
  </tr>
  <tr>
    <td colspan="2" class="hide"></td>
    <th>Anchré</th>
    <th>Anglé</th>
    <th>De verre</th>
    <th>À l'envers</th>
  </tr>
  <tr>
    <th rowspan="6">Items</th>
    <th>Cabinet</th>
    <td>Cabinet anchré</td>
    <td>Cabinet anglé</td>
    <td>Cabinet de verre</td>
    <td>Cabinet à l'envers</td>
  </tr>
  <tr>
    <th>Aimant</th>
    <td>Aimant anchré</td>
    <td>Aimant anglé</td>
    <td>Aimant de verre</td>
    <td>Aimant à l'envers</td>
  </tr>
  <tr>
    <th>Tapis à souris</th>
    <td>Tapis à souris anchré</td>
    <td>Tapis à souris anglé</td>
    <td>Tapis à souris de verre</td>
    <td>Tapis à souris à l'envers</td>
  </tr>
</table>

Afin de combattre ce problème, la `fabrique abstraite` utilise une usine abstraite qui fait appèle aux usines individuelles de chaque critère. Ces usines plus spécialisés créent ensuite chaque objet individuel qui est désigné au critère. Ainsi, nous ne devons pas savoir le type exacte d'un item selon le critère, plutôt seulement le nom de l'item est nécéssaire. Le tableau suivant démontre la simplitude de ne qu'avoire à savoir le nom de l'item et d'avoir le critère prédéfini en créant l'objet au travers de l'usine abstraite.

Le critère `Anglé` a été choisi lors de la création de l'objet. Essaye de sélectionner un item et voit le résultat.

<table>
  <tr>
    <td colspan="2" class="hide"></td>
    <th colspan="4">Critères</th>
  </tr>
  <tr>
    <td colspan="2" class="hide"></td>
    <th>Anchré</th>
    <th class="table2angle">Anglé</th>
    <th>De verre</th>
    <th>À l'envers</th>
  </tr>
  <tr>
    <th rowspan="6" class="nohover">Items</th>
    <tr class="table2cabinet">
      <th>Cabinet</th>
      <td></td>
      <td class="table2angle table2anglehighlight">Cabinet anglé</td>
      <td></td>
      <td></td>
    </tr>
  </tr>
  <tr class="table2cabinet">
    <th>Aimant</th>
    <td></td>
    <td class="table2angle table2anglehighlight">Aimant anglé</td>
    <td></td>
    <td></td>
  </tr>
  <tr class="table2cabinet">
    <th>Tapis à souris</th>
    <td></td>
    <td class="table2angle table2anglehighlight">Tapis à souris anglé</td>
    <td></td>
    <td></td>
  </tr>
</table>

Nous pouvons ainsi simplement appeler la méthode `ouvre()` de l'interface `Cabinet` sur l'objet qui implémente `Cabinet` sachant que, même avec des implémentations entièrement différentes la tâche s'accomplira pour le critère choisi.



## Concepts POO
#### Utilisation d'héritage
Ce projet n'utilise pas d'héritage puisqu'il n'y a aucune classe parente (signifiée par `extends`).

#### Utilisation d'interfaces
Les interfaces sont le point centrale de la `fabrique abstraite`. Elles sont utilisés afin d'assurer qu'un objet quelquonque contienne les méthodes voulues. Par exemple, l'interface `Display` est utilisé afin d'assurer que les objets `BayDisplay`, `SnowDisplay` et `StadiumDisplay` contiennent les méthodes `renderTop(Game game)` et `renderBottom(Game game)`. 

Les interfaces sont aussi largement utilisées dans ce patron de conception afin de façiliter le sélectionnement d'items (exemples: `BayCar`, `StadiumDisplay`, etcetera) suivant un critère spécifique, comme un environnement. On peut donc appliquer le polymorphisme afin d'appeler une méthode de l'interface sur un objet qui l'implémente. Ceci est couvert en plus de détail dans la section [Utilisation du polymorphisme](#utilisation-du-polymorphisme).

#### Utilisation du polymorphisme
Le polymorphisme est la solution au problème de devoir savoir chaque nom d'objet spécifique voulu. En passant le type de l'usine en créant l'usine abstraite, nous n'avons que besoin d'appeler les méthodes de l'interface sur l'implémenteur. Par exemple,
```
Car car = new BayCar();
car.accelerate();
```
La table suivante (de plus tôt dans le README) démontre comment le type d'item spécifique est simplement assigné au type d'item abstrait.

<table>
  <tr>
    <td colspan="2" class="hide"></td>
    <th colspan="4">Critères</th>
  </tr>
  <tr>
    <td colspan="2" class="hide"></td>
    <th>Anchré</th>
    <th class="table2angle">Anglé</th>
    <th>De verre</th>
    <th>À l'envers</th>
  </tr>
  <tr>
    <th rowspan="6" class="nohover">Items</th>
    <tr class="table2cabinet">
      <th>Cabinet</th>
      <td></td>
      <td class="table2angle table2anglehighlight">Cabinet anglé</td>
      <td></td>
      <td></td>
    </tr>
  </tr>
  <tr class="table2cabinet">
    <th>Aimant</th>
    <td></td>
    <td class="table2angle table2anglehighlight">Aimant anglé</td>
    <td></td>
    <td></td>
  </tr>
  <tr class="table2cabinet">
    <th>Tapis à souris</th>
    <td></td>
    <td class="table2angle table2anglehighlight">Tapis à souris anglé</td>
    <td></td>
    <td></td>
  </tr>
</table>

#### Utilisation de composition
La composition est le concept primaire de la `fabrique abstraite`. Comme mentionné dans la section [Utilisation d'interfaces](#utilisation-dinterfaces), les interfaces façilitent le sélectionnement d'items plus spécifiques en n'ayant pas leur nom complet. Ceci est un des traits de la composition.

La composition consiste d'utiliser des interfaces afin de <i>composer</i> une classe de plus petits charactéristiques, puis de lui appliquer le polymorphisme. Voici un exemple en pseudo-code:
```
interface canWalk {
  walk();
}
```
```
interface canJump {
  jump();
}
```
```
class Teen implements canWalk, canJump {
  ...
}
```
```
class Baby implements canWalk {
  ...
}
```
Dans cet exemple, l'adolescent peut marcher et sauter. Il implémente donc `canWalk` et `canJump`. Le bébé ne peut que marcher, donc il n'implémente que `canWalk`. Ceci devient très utile en appliquant le polymorphisme pusique les interfaces peuvent agir comme contenant du type, qui a des méthodes définies. Ajoutons ensuite le polymorphismse:
```
class App {
  main(...) {
    canWalk teenThatWalks = new Teen();
    canWalk babyThatWalks = new Baby();

    teenThatWalks.walk();
    babyThatWalks.walk();
  }
}
```
Ici-haut, les objets `teenThatWalks` et `babyThatWalks` sont du type canWalk. Nous pouvons donc appliquer la méthode `walk()` dessus sans souçis. Dans mon projet, les classes spécifiques `teenThatWalks` et `babyThatWalks` seraient incertains. Plutot, on n'utilise qu'une interface qui représente le type d'item réel. Avec l'exemple précédent, cela pourrait ressembler à:
```
class App {
  main(...) {
    canWalk unknownThatWalks = unknown;

    unknownThatWalks.walk();
  }
}
```
Nous ne savons rien au sujet de `unknown` à part qu'il peut marcher. Ainsi, nous pouvons déleguer la création de l'objet spécifique à des usines, puis simplement prendre le point en commun.

La composition est donc cruciale au fonctionnement de la `fabrique abstraite`. En conjonction avec le polymorphisme, elle amène une simplitude en ignorant tout à part le type d'item voulu. Les usines peuvent donc choisir le critère voulu (exemple: `de verre` dans les tableau ici-haut), puis l'application peut fonctionner sans s'en faire des variations.

## Sources
``````
