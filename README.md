# Springboot mit Keycloak nutzen

## Setup
1. Keycloak Setup:
    1. Docker container mit keycloak anlegen `docker run jboss/keycloak`
    2. Realm mit Namen dev anlegen
    3. In dev neuen Client anlegen 
        1. Root Url auf `http://localhost:8081`
        2. Valid Redirect Url auf `http://localhost:8081/*`
    4. Role mit Namen user anlegen
    5. User anlegen und Rolle user zuweisen
    
2. Datenbank Setup
    1. Neue mysql Datenbank anlegen
    2. Neuen mysql-User anlegen und Berechtigung für die Datenbank geben

3. Spring Setup
    1. Alle Daten bzgl. Keycloak und Datasource (mysql) an die vorherigen Einstellungen anpassen
    2. `mvn clean spring-boot:run` um zu builden