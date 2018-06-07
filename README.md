# spock-workshop

Deze repository bevat de bron bestanden van de Spock workshop van woensdag 6 juni.

Er zijn de volgende projecten in deze repository:

folder                          | omschrijving
---                             | ---
demo2-datatable-met-html-report | demonstratie van een simpele spock test. De test resultaten worden in een html raport geplaatst
opdracht-1en2                   | de eerste twee opdrachten van de workshop
opdracht-3-later                | de laatste opdrachten van de workshop
uitwerkingen                    | de uiterkingen van de verschillende opdrachten

## hoe clone je dit project?
Open een GIT command prompt (in Windows de GIT bash op de mac zou een terminal ook moeten werken)
ga naar de folder waar je de git source wilt plaatsen
geef het volgende commando
>git clone https://github.com/MarcMeer/spock-workshop.git

Je kunt de source ook downloaden of clonen in IntelliJ. In IntelliJ clone je door te kiezen voor Checkout from Version Control en dan de volgende Link op te geven 
>https://github.com/MarcMeer/spock-workshop.git 

Downloaden doe je vanaf de volgende link https://github.com/MarcMeer/spock-workshop/archive/master.zip

Indien je geen github account heb, kies dan niet voor Github maar gewoon voor Git.

## Voer de tests in hallo-spock uit om zeker te weten dat jouw computer goed geinstalleerd is voor de workshop
In deze repository is een hallo-spock project opgenomen. Deze spint een simpele Spring Boot applicatie op welke een REST end point heeft die een boodschap terug geeft. De applicatie is voorzien van Spock test code of dit alles goed werkt. Indien deze test slagen is jouw computer dus goed geinstalleerd om de workshop uit te kunnen voeren. Verder zie je el gelijk een beetje hoe Spock tests werken.

## Tests uitvoeren in maven
ga naar de folder hallo-spock
>cd hallo-spock

draai de tests met maven door onderstaande opdracht
>mvn clean verify

Als het goed is wordt Spring opgestart en de test gedraaid het scherm is ongeveer zoals hieronder is weergegeven
![picture](https://github.com/MarcMeer/spock-workshop/blob/master/img/2018-05-29%2007.41.13%20PM.png?raw=true)
Werkt het niet dan kan het zo zijn dat mvn niet aan je path is toegevoegd. Verder moet maven de juiste java versie kunnen vinden. Je kan ook kijken of het wel met IntelliJ lukt de tests uit te voeren.

## Importeren pom in IntelliJ
Indien je geen projecten heb geopend in IntelliJ, krijg je onderstaand scherm te zien. Kies hier voor import project.
![picture](https://github.com/MarcMeer/spock-workshop/blob/master/img/image.png)
![picture](https://github.com/MarcMeer/spock-workshop/blob/master/img/image-2.png)
![picture](https://github.com/MarcMeer/spock-workshop/blob/master/img/image-3.png)
![picture](https://github.com/MarcMeer/spock-workshop/blob/master/img/image-1.png)
![picture](https://github.com/MarcMeer/spock-workshop/blob/master/img/2018-05-29%2008.13.17%20PM.png)
![picture](https://github.com/MarcMeer/spock-workshop/blob/master/img/image-5.png)

## De tests uitvoeren in IntelliJ
Indien je bovenstaande instructies heb opgevolgd is het project geopend in IntelliJ. Je ziet onderstaande scherm verschijnen
![picture](https://github.com/MarcMeer/spock-workshop/blob/master/img/2018-05-29%2007.52.27%20PM.png)

Klap de src en dan test folder open en markeer groovy als test root source (zie afbeelding hieronder), door met de rechter muis toets op groovy te klikken en te kiezen voor Mark directory as > test sources root
![picture](https://github.com/MarcMeer/spock-workshop/blob/master/img/2018-05-29%2007.55.19%20PM.png)

De groovy folder moet nu groen geworden zijn (zie afbeelding hieronder)
![picture](https://github.com/MarcMeer/spock-workshop/blob/master/img/2018-05-29%2007.55.35%20PM.png)

Voer de test nu uit door met de rechter muis toets op groovy te klikken en te kiezen voor 'Run all tests'
![picture](https://github.com/MarcMeer/spock-workshop/blob/master/img/2018-05-29%2007.59.49%20PM.png)

De test worden uitgevoerd en het resultaat hiervan verschijnt onderin het scherm
![picture](https://github.com/MarcMeer/spock-workshop/blob/master/img/2018-05-29%2008.02.01%20PM.png)

