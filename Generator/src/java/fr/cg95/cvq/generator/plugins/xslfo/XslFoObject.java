package fr.cg95.cvq.generator.plugins.xslfo;

import java.util.TreeMap;

import org.apache.log4j.Logger;

/**
 * @author bor@zenexity.fr
 */
public final class XslFoObject {

    private static Logger logger =
        Logger.getLogger(XslFoObject.class);

    private String targetNamespace;
    private String requestName;
    private TreeMap friendlyNamesMap;

    private TreeMap blockDefMap;

    public XslFoObject(String requestName, String targetNamespace) {

        this.requestName = requestName;
        this.targetNamespace = targetNamespace;
        this.friendlyNamesMap = new TreeMap();
        this.blockDefMap = new TreeMap();
    }

    public void addFriendlyName(final String name, final String lang) {
        friendlyNamesMap.put(lang, name);
    }

    public String getFriendlyName(final String lang) {
        return (String) friendlyNamesMap.get(lang);
    }

    public void addBlockDef(BlockDef blockDef) {
        logger.debug("addBlockDef() adding block " + blockDef.getId() + " with label " + blockDef.getLabel());
        blockDefMap.put(blockDef.getId(), blockDef);
    }

    public void addLineToBlock(Integer blockId, Element element) {
        BlockDef blockDef = (BlockDef) blockDefMap.get(blockId);
        if (blockDef == null)
            throw new RuntimeException("addLineToBlock() no block with id " + blockId + " found");
        blockDef.addBlockLine(element);
    }

    public TreeMap getBlockDefMap() {
        return blockDefMap;
    }

    public String getRequestName() {
        return this.requestName;
    }

    public String getTargetNamespace() {
        return this.targetNamespace;
    }

    public String getNamespaceAlias() {
        return targetNamespace.substring(targetNamespace.lastIndexOf('/') + 1);
    }
}
