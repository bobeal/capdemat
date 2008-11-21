import com.zenexity.capdemat.utils.*
import grails.util.*
import groovy.util.*

//eventRunStop = {
//    println "#PREPARE MODULES"
//    ModuleHelper.prepareAll(basedir)
//    println "#PREPARE MODULES"
//}

eventCleanStart = {
    println "#CLEAN MODULES + ALL"
    ModuleHelper.cleanAll(basedir)
}