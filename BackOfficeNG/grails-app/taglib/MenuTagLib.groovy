import groovy.xml.*
import java.io.*
import grails.util.GrailsUtil

class MenuTagLib {
    static namespace = "menu";
    
    def current = {attrs,body ->
        def elem = attrs['elem'];
        def clss = attrs['class'];
        def current = flash?.currentMenu;
        
        if(!elem) elem = 'home';
        if(!clss) clss = 'current';
        if(!current) current = 'home';
        
        if(elem != current) clss = ''
        
        out << clss
    }
}