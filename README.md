patrons / Nicolas / 13 Décembre

![SVG du PUML du projet](https://github.com/101010101010101011010/patrons/blob/master/PatronsPUML.svg)

## Fabrique abstraite
#### Catégorie
Patrons de création
#### Utilité
Le patron de conception « fabrique abstraite » est utile dans des cas où plusieurs items spécifiques ont des implémentations qui diffèrent selon un critère globale.

---

Par exemple, il pourrait y avoir des cabinets, aimants, et tapis à souris, toutes utilisés pour des tables. S'il y a plusieurs types de tables, comme anchré, anglé, de verre, à l'envers, chaque item aura besoin d'une implémentation entièrement différente qu'un autre de la même espèce. Le tableau qui suit démontre que, si l'on veut accéder un item, il faut savoir son nom au complet d'avance

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
TODO
#### Utilisation d'interfaces
Les interfaces sont le point centrale de la `fabrique abstraite`. Elles sont utilisés afin d'assurer qu'un objet quelquonque contient les méthodes voulues. Par exemple, l'interface `Display` est utilisé afin d'assurer que les objets `BayDisplay`, `SnowDisplay` et `StadiumDisplay` contiennent les méthodes `renderTop(Game game)` et `renderBottom(Game game)`. 

Les interfaces sont aussi largement utilisées dans ce patron de conception afin de façiliter le sélectionnement d'items (exemples: `BayCar`, `StadiumDisplay`, etcetera) suivant un critère spécifique, comme un environnement. On peut donc appliquer le polymorphisme afin d'appeler une fonction de l'interface sur un objet qui l'implémente. Ceci est couvert en plus de détail dans la section [Utilisation du polymorphisme](#utilisation-du-polymorphisme).

#### Utilisation du polymorphisme
TODO
#### Utilisation de composition
TODO

## Sources
