package org.openCF

import java.util.UUID

/*
* function to generate unique Integer ID , by using ElectricalRegistry to get updated about taken IDs
 */
fun generateNewId(electricalCircuit: ElectricalCircuit):Int{
   var id:Int

  do {
      id = UUID.randomUUID().hashCode()
  }while (electricalCircuit.getPinByID(id) != null || electricalCircuit.getComponentByID(id) != null)

  return id

}