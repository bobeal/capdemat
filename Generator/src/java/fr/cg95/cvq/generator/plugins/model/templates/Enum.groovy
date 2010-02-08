package ${baseNS}.request.${lastParticle};

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;

/**
 * Generated class file, do not edit !
 */
public final class ${name} extends PersistentStringEnum {

    private static final long serialVersionUID = 1L;
  <% values.each { %>
    public static final ${name} ${it.key} = new ${name}("${it.value}");
  <% } %>

    /**
     * Prevent instantiation and subclassing with a private constructor.
     */
    private ${name}(String value) {
        super(value);
    }

    public ${name}() {}

    public static ${name}[] all${name}s = {
        <% print org.apache.commons.lang.StringUtils.join(values.collect{ it.key }.iterator(), ",\n        ") %>
    };

    public static ${name} getDefault${name}() {
        return ${defaultValue};
    }

    public static ${name} forString(final String enumAsString) {
        for (${name} value : all${name}s)
            if (value.toString().equals(enumAsString))
                return value;
        return getDefault${name}();
    }
}
