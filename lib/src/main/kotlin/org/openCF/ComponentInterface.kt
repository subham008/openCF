package org.openCF

import java.io.Serializable

interface ComponentInterface : Serializable{
   fun logic()
   fun onStartLogic()
   fun onEndLogic()
   fun getLeftPinCount():Int
   fun getRightPinCount():Int
   fun getTopPinCount():Int
   fun getBottomPinCount():Int
}