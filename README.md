# spock-workshop
## clone dit project
Open een GIT command prompt (in Windows de GIT bash op de mac zou een terminal ook moeten werken)
ga naar de folder waar je de git source wilt plaatsen
geef het volgende commando
>git clone https://github.com/MarcMeer/spock-workshop.git

Je kunt de source ook downloaden of clonen in IntelliJ. In IntelliJ clone je door te kiezen voor Checkout from Version Control en dan de volgende Link op te geven 
>https://github.com/MarcMeer/spock-workshop.git 

Downloaden doe je vanaf de volgende link https://github.com/MarcMeer/spock-workshop/archive/master.zip

Indien je geen github account heb, kies dan niet voor Github maar gewoon voor Git.

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

