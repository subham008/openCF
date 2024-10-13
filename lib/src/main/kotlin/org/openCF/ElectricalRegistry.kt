package org.openCF

//Registry to store all type of components

/*
*This registry  is store type of components
*You can make you custom component
****************FORMAT****************
* There will be two files for each component
* configuration.json -> which will have mata data about component
* logic.class -> This is a compiled kotlin or java file which will have logic of component
* Additionally you can add any file or folder containing necessary resource for component e.g icons in SVG form , or documentation or dependent class files
*/

/*
********Language Configuration Format******
*This is a json file
*
* REQUIRED FIELDS
* name (String)  -> name of the component
* icon (String)  -> icon path of the component , icon should be in SVG format
* logic (String) -> path of the logic class file
*/
