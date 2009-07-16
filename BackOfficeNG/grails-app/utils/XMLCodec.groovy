import org.apache.commons.lang.StringEscapeUtils

class XMLCodec {

    static encode = { str ->
        return StringEscapeUtils.escapeXml(str)
    }

    static decode = {
        return StringEscapeUtils.unescapeXml(str)
    }
}