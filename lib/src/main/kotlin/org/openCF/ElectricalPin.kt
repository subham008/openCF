package org.openCF

import java.util.UUID

/*
*This is a Data class to store data about each pin on an electrical component
* @param parentId is the Integer  id of the parent component
* @param pinOrient is the Integer value of the orientation of the pin ,  use ElectricalPin.TOP,ElectricalPin.BOTTOM,ElectricalPin.LEFT,ElectricalPin.RIGHT
* @param pinIndex is the Integer value of the index of the pin, index start form 0 for each orientation
* @param pinId is the unique Integer id of pin
* @param pinName is the String name of the pin
*/
data class ElectricalPin(
    var parentId:Int,
    var pinOrient:Int,
    var pinIndex:Int,
    var pinId:Int,
    var pinName:String
)

val TOP =0
val BOTTOM = 1
val LEFT = 2
val RIGHT = 3


