import org.apache.commons.lang.StringEscapeUtils

class XMLCodec {

    static encode = { str ->
        if (str == null) return null
        return StringEscapeUtils.escapeXml(str.toString())
    }

    static decode = {
        if (str == null) return null
        return StringEscapeUtils.unescapeXml(str.toString())
    }
}