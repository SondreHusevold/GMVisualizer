GMVisualizer
============

[DEAD PROJECT]
--------------
This was originally a project that later evolved to become another one made in C++ and Qt called the Etrian Dungeon Creator which isn't available on GitHub and is also a dead project. 

It is only here due to originally being uploaded here when I worked on it. Will probably be removed later on.

Introduction
------------

This is a game mastering tool for table-top games to visualize a setting or scene with sprites and backgrounds.

It has an integrated dungeon crawling labyrinth system that allows the GM to show the players where they are inside the dungeon and what might be happening.

Instructions:
-------------

All assets are to be bundled with the program. This means an "Images" folder and "labyrinth" folder needs to be included in the root of the folder where the .jar file is located. In order to make the program more dynamic, the assets are not supposed to be compiled and packed inside the .jar.

The folder structure are as follows:

+ Backgrounds are located inside Images/Backgrounds/

+ Sprites are located inside Images/Sprites/

+ Tiles for the map are located inside Images/MapTiles

In the root folder together with the .jar file are two pure text documents. You add the image file names (without the extension) inside these text documents with a new line for each of them. You are free to add labels to them like == EXAMPLE PERSON == to easier organize these.

All images needs to be in PNG format. Examples are added in the repository.

A labyrinth can be made in pure text and put inside the /labyrinth folder for use.

Unfortunately the labyrinth feature is currently unusable and is being worked on. Thus this is still work in progress.


