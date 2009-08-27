package fr.cg95.cvq.generator.plugins.xslfo;

import java.util.TreeMap;

import org.apache.log4j.Logger;

/**
 * @author bor@zenexity.fr
 */
public final class BlockDef {

    private static Logger logger = Logger.getLogger(BlockDef.class);

    private Integer id;
    private String label;
    private Integer columnNb;
    private String displayCondition;
    private boolean breakAfter;

    private TreeMap<Integer, TreeMap<Integer, Element>> blockLineMap =
        new TreeMap<Integer, TreeMap<Integer, Element>>();

    public BlockDef(final Integer id, final String label, final String blockColumnNb,
                    final String displayCondition, final String breakAfter) {
        this.id = id;
        this.label = label;
        if (blockColumnNb != null)
            this.columnNb = new Integer(blockColumnNb);
        else
            this.columnNb = new Integer(1);
        this.displayCondition = displayCondition;
        if (breakAfter != null)
            this.breakAfter = (new Boolean(breakAfter)).booleanValue();
        else
            this.breakAfter = false;
    }

    public void addBlockLine(Element element) {
        logger.debug("addBlockLine() adding line " + element.getLineId()
                     + " and column " + element.getColumnId()
                     + " of type " + element.getClass().getName() + " in block " + id);
        if (blockLineMap.get(element.getLineId()) == null) {
            TreeMap<Integer, Element> lineColumnMap = new TreeMap<Integer, Element>();
            lineColumnMap.put(element.getColumnId(), element);
            blockLineMap.put(element.getLineId(), lineColumnMap);
        } else {
            TreeMap<Integer, Element> lineColumnMap = blockLineMap.get(element.getLineId());

            // check columns filling
            int sumOfColumns = 0;
            for (Element currentElement : lineColumnMap.values()) {
                sumOfColumns += currentElement.getColumnSpan().intValue();
            }
            if (sumOfColumns + element.getColumnSpan().intValue() > columnNb.intValue())
                throw new RuntimeException("addBlockLine() Sum of element columns exceeds block's "
                        + "authorized number of column (block id : " + id + "), got " 
                        + (lineColumnMap.size() + element.getColumnSpan().intValue()) 
                        + ", only accepts " + columnNb + ")");

            // check element is authorized
            Element currentElement = lineColumnMap.values().iterator().next();
            if (currentElement instanceof SignatureElement
                || currentElement instanceof ComplexTemplateElement) {
                throw new RuntimeException("addBlockLine() Cannot add an element in a line "
                        + "containing already a signature or complex template element");
            }

            if (element instanceof SignatureElement
                || element instanceof ComplexTemplateElement) {
                throw new RuntimeException("addBlockLine() Cannot add a signature or complex "
                        + "template element in a line containing already a element");
            }

            lineColumnMap.put(element.getColumnId(), element);
        }
    }

    public TreeMap<Integer, TreeMap<Integer, Element>> getBlockLineMap() {
        return this.blockLineMap;
    }

    public Integer getId() {
        return this.id;
    }

    public String getLabel() {
        return this.label;
    }

    public Integer getColumnNb() {
        return this.columnNb;
    }

    public String getDisplayCondition() {
        return this.displayCondition;
    }

    public boolean getBreakAfter() {
        return this.breakAfter;
    }
}
