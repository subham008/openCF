package org.openCF


/*
*This is a Data class to store data about whole circuit design it includes all components and connections
* @param components is the List of all components in the circuit
* @param connections is the List of all connections in the circuit
*/
 class ElectricalCircuit{

    //make private map of pins , components and connections
    private val pins = mutableMapOf<Int, ElectricalPin>()
    private val components = mutableMapOf<Int, ElectricalComponent>()
    private var connectionsList = mutableListOf<ElectricalConnection>()


    /*
    * addComponent to add component to this circuit design
    * @param component is the ElectricalComponent to add to this circuit design
    */
    fun addComponent(component: ElectricalComponent) {
        components[component.componentId] = component

       component.pins.forEach{
           pins[it.pinId] = it
       }

    }


    /*
    * removeComponent to remove component to this circuit design
    * @param component is the ElectricalComponent to remove from this circuit design
    */
    fun removeComponent(component: ElectricalComponent){
        //remove component from components list
        components.remove(component.componentId)
        //remove pins from pins list
        component.pins.forEach{
            pins.remove(it.pinId)
        }
    }


    /*
    * getComponent to get Map<Int, ElectricalComponent> of all component of this circuit design
    * @return Map<Int, ElectricalComponent> of all component of this circuit design
    */
    fun getComponents(): MutableMap<Int, ElectricalComponent> {
        return components
    }

    /*
    * addConnection to add connection to this circuit design
    * @param connection is the ElectricalConnection to add to this circuit design
    */
    fun addConnection(connection: ElectricalConnection){
        connectionsList.add(connection)
    }


    /*
    * removeConnection to remove connection to this circuit design
    * @param connection is the ElectricalConnection to remove from this circuit design
    */
    fun removeConnection(connection: ElectricalConnection){
        connectionsList.remove(connection)
    }


    /*
    * getConnection to get List<ElectricalConnection> of all connection of this circuit design
    * @return List<ElectricalConnection> of all connection of this circuit design
     */
    fun getConnection(): MutableList<ElectricalConnection> {
        return connectionsList
    }


    /*
    * getPin to get Map<Int, ElectricalPin> of all pin of this circuit design
    * @param pinId is the Integer id of the pin to get
    * @return Map<Int, ElectricalPin> of all pin of this circuit design
     */
    fun getPinByID(pinId: Int): ElectricalPin? {
        return pins[pinId]
    }

    /*
    * getComponent to get Map<Int, ElectricalComponent> of all component of this circuit design
    * @param componentId is the Integer id of the component to get
    * @return Map<Int, ElectricalComponent> of all component of this circuit design
    */
    fun getComponentByID(componentId: Int): ElectricalComponent? {
        return components[componentId]
    }
}