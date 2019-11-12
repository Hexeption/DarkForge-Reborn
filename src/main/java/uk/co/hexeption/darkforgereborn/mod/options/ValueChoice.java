package uk.co.hexeption.darkforgereborn.mod.options;

/**
 * ValueChoice
 *
 * @author Hexeption admin@hexeption.co.uk
 * @since 09/11/2019 - 11:35 am
 */
public class ValueChoice extends Value {

    public String[] list;

    public ValueChoice(int value, String[] list) {
        super(list[value]);
        this.list = list;
    }
}
