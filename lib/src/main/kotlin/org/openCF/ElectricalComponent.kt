package org.openCF


/*
* This is a Data class to store data about each electrical component
* @param componentName is the String name of the component
* @param componentId is the unique Integer  id of the component
* @param xLocation is the Integer value of the x location of the component
* @param yLocation is the Integer value of the y location of the component
* @param pins is the List of all pins of the component
*/
data class  ElectricalComponent(
     var componentName:String,
     var componentId:Int,
     var xLocation:Int,
     var yLocation:Int,
     var pins:List<ElectricalPin>,
)