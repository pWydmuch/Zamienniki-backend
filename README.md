# Zamienniki

[![Build Status](https://travis-ci.org/pWydmuch/zamienniki.svg?branch=master)](https://travis-ci.org/pWydmuch/zamienniki)

Projekt realizowany w ramach kursu Programowania Oprogramowania, którego celem było zaprojektowanie aplikacji mającej ułatwiać proces znajdowania i akceptowania zamienników dla danego kursu.
Należało zaimplementować dwa przypadki użycia, w mojej aplikacji zaimplementowałem wyszukiwanie kursów, które mogłyby być zamienikiem według podanych kryteriów, oraz opiniowanie podania.
Polskie nazwy encji były wymagane ze względu zgodności z projektem.

Backend jest wdrożony na platformie Heroku. Korzystam z wersji darmowej, która usypia aplikacjie po 30 minutach nieaktywności, więc prawdopodobnie będzie trzeba trochę poczekać po pierwszym żadaniu, aż aplikacja zacznie działać poprawnie

[Tu można zobaczyć aplikację w akcji](http://zamienniki2.surge.sh/)

Niestety nie działa wyświetlanie kart predmiotów, ponieważ przechowywałem je na Google Storage, a wygasło mi tam konto

[Kodu frontendu](https://github.com/pWydmuch/zamienniki-frontend)

Wykorzystano:
* Backend:
    * Java
    * Spring Boot
    * Spring Data (Query By Example)
    * Hibernate
    * MySql
    * Travis CI
    
* Frontend
    * HTML/CSS
    * Boostrap
    * Typescript
    * Angular    
