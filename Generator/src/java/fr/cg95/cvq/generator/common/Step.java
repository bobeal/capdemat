package fr.cg95.cvq.generator.common;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

/**
 * @author rdj@zenexity.fr
 */
public abstract class Step {

    private int index;
    private List<Condition> conditions = new ArrayList<Condition>();
    private List<Widget> widgets = new ArrayList<Widget>();

    protected Step (String index) {
        try {
            this.index = Integer.valueOf(index).intValue();
        } catch (NumberFormatException nfe) {
            throw new RuntimeException("Step() - Step index {"+ index +"} is not an integer");
        }
    }

    public int getIndex() {
        return index;
    }

    public abstract String getName();

    public String getCamelCaseName() {
        return StringUtils.uncapitalize(getName());
    }

    public abstract boolean isRequired();

    public List<Condition> getConditions() {
        return conditions;
    }

    public void addCondition(Condition condition) {
        for (Condition c : conditions)
            if (c.getName().equals(condition.getName()))
                throw new RuntimeException("addCondition() - Condition {"+ condition.getName() +"} " 
                        + "is already associated with Step {"+ getName() +"}");
        conditions.add(condition);
    }

    public List<Widget> getWidgets() {
        return widgets;
    }

    public void addWidget(Widget widget) {
        if (index != 0)
            throw new RuntimeException("addWidget - Widget can only be added in step with index 0");
        for (Widget w : widgets)
            if (w.getName().equals(widget.getName()))
                throw new RuntimeException("addWidget() - Widget {"+ widget.getName() +"} " 
                        + "is already associated with Step {"+ getName() +"}");
        widgets.add(widget);
    }
}
