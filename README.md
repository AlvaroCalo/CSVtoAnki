# JavaFX App to load in a CSV file database content to use with Anki

## Context

I'm using Java 11 openjdk in a Lubuntu environment. The JavaFX libraries are available here:
https://gluonhq.com/products/javafx/ <br>
Also I'm using mysql-connector to connecto to the database. <br>
One example of the database is provided

## How to configure the project
You have to load the 2_working_sound_pair.sql database in your system. <br>
In the package com.web.connection: you have to change the line 19 with the database name and the user:pass info.<br>
In the package com.web.gui: you have to change the CSV file path. <br>
In the MainPairs.java you have to change the paths of the files and directories.
Finally you run the MainPairs.java class.

## What is for this application

I've developed to create a CSV file to import in Anki SRS and study English minimal pairs from it. <br>
The database is loaded with IPA and sounds words. The IPA are from https://en.wiktionary.org and the sounds are recorded by a friend of mine. I'm not providing the audios because they are not necessary to try the app.