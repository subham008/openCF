package org.openCF


/*
*This is a Data class to store connection data by storing two pins unique ids
* @param pinAiD is the Integer  id of the first pin
* @param pinBiD is the Integer  id of the second pin
*/
data class ElectricalConnection(
    var pinA:ElectricalPin,
    var pinB:ElectricalPin
)