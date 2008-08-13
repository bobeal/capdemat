package fr.cg95.cvq.wizard;

public interface ListListener {
    public void onSelect(Object data, Object stageForm);
    public void onNew(Object data, Object stageForm);
    public void onAdd(Object data, Object stageForm);
    public void onSave(Object data, Object stageForm);
    public void onRemove(Object data, Object stageForm);
}
