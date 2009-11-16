package fr.cg95.cvq.generator.plugins.model;

/**
 * @author jsb@zenexity.fr
 *
 */
public class Padding {

    private Integer length;

    private Character pad;

    public Padding(String length, String pad) {
        this.length = Integer.valueOf(length);
        this.pad = Character.valueOf(pad.charAt(0));
    }

    public Integer getLength() {
        return length;
    }

    public Character getPad() {
        return pad;
    }
}
