package org.openCF

import com.google.gson.Gson
import java.io.File
import java.io.FileInputStream
import java.io.ObjectInputStream
import java.util.zip.ZipInputStream


//Registry to store all type of components

/*
*This registry  is store type of components
*You can make you custom component
****************FORMAT****************
* There will be two files for each component
* configuration.json -> which will have mata data about component
* logic -> This is a serialized file  which will have logic of component
* Additionally you can add any file or folder containing necessary resource for component e.g icons in SVG form , or documentation or dependent class files
*/

/*
********Language Configuration Format******
*This is a json file
*
* REQUIRED FIELDS
* name (String)  -> name of the component
* iconFilePath (String)  -> icon path of the component , icon should be in SVG format
* logicFilePath (String) -> path of the logic serialized  file
*/


data class ComponentConfigutation(
    var name:String,
    var iconFilePath:String,
    var logicFilePath:String
)


data class ComponentType(
    val Info:ComponentConfigutation,
    val logic : ComponentInterface,
)


val componentRegistry = mutableMapOf<String,ComponentType>()



fun addComponent(component:ComponentType){
    // check if component already exist or not
    if(componentRegistry.containsKey(component.Info.name)){
        throw Exception("Component already exist : ${component.Info.name}")
    }

    //check for valid file paths
    val iconFilePath = component.Info.iconFilePath
    val logicFilePath = component.Info.logicFilePath

    if(!File(iconFilePath).exists()){
        throw Exception("Icon file does not exist : $iconFilePath")
    }
    if(!File(logicFilePath).exists()){
        throw Exception("Logic file does not exist : $logicFilePath")
    }

    componentRegistry[component.Info.name] = component
}




fun addComponentDir(componentDir:File){
     // check first This  dir path is valid or not

    if(!componentDir.exists()){
        throw Exception("Component directory does not exist : ${componentDir.path}")
    }

    // now check is this dir is a directory or not
    if(!componentDir.isDirectory){
        throw Exception("Component directory is not a directory : ${componentDir.path}")
    }

    // now check is this dir  contain configuration.json  file or not
    val configurationFilePath = componentDir.resolve("configuration.json")
    if(!configurationFilePath.exists()){
        throw Exception("Component directory does not contain configuration.json file : ${componentDir.path}")
    }

    // use gson to extract data from configuration.json file
    val configurationFile = File(configurationFilePath.toString())
    val configurationJson = configurationFile.readText()
    val configuration = Gson().fromJson(configurationJson,ComponentConfigutation::class.java)

    // now check is logic path is valid or not
    val logicFilePath = componentDir.resolve(configuration.logicFilePath)
    if(!logicFilePath.exists()){
        throw Exception("Component directory does not contain logic file : ${componentDir.path}")
    }

    // now check is logic path is a file or not
    if(!logicFilePath.isFile){
        throw Exception("Component logic file is not a file : ${componentDir.path}")
    }

    // now  deserialized the Logic file into ComponentInterface type
     var componentInterface =  ObjectInputStream(FileInputStream(configuration.logicFilePath)).use { inputStream -> inputStream.readObject() as ComponentInterface }

     val componentType = ComponentType(configuration,componentInterface)

    // now add this component to registry
    addComponent(componentType)

}






