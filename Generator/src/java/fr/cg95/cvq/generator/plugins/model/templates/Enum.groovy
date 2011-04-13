package ${baseNS}.request.${lastParticle};

/**
 * Generated class file, do not edit !
 */
public enum ${name} {

    <% for (Iterator iterator = values.entrySet().iterator(); iterator.hasNext();) {
           Map.Entry pairs = (Map.Entry) iterator.next();
           print  pairs.getKey() + "(\"" + pairs.getValue() + "\")"
           if(iterator.hasNext()){print  ",\n    " }else{ println ";" }
       }
    %>

    /**
     * only for backward use ${name}.values() instead
     * @deprecated only for backward
     */
    @Deprecated 
    public static ${name}[] all${name}s = ${name}.values();

    private String legacyLabel;

    private ${name}(String legacyLabel){
        this.legacyLabel = legacyLabel;
    }

    public String getLegacyLabel() {
        return legacyLabel;
    }

    public static ${name} getDefault${name}() {
        return ${defaultValue};
    }

    /**
     * @deprecated use valueOf instead. Watchout! you must provid something of ${name}.something
     * not the value of the name attribut.
     */
    public static ${name} forString(final String enumAsString) {
        for (${name} value : values())
            if (value.toString().equals(enumAsString))
                return value;
        return getDefault${name}();
    }
}
