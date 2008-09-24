
class CapdematUtils {

    /*
     * Generic method to adapt Capdemat 'State' class (Like RequestState / DocumentState / DataState ...)
     */
    public static adaptCapdematState (capdematState, i18nKeyPrefix) {
        return [
            "cssClass": "tag-" + capdematState.toString().toLowerCase(), 
            "i18nKey": i18nKeyPrefix + "." + StringUtils.toCamelCase(capdematState.toString()),
            "enumString": capdematState.toString()
        ]         
    }
    
}
