package App.model;

import App.view.Screen;

/**
 * User: marky
 * Date: 10/7/12
 * Time: 8:46 PM
 */
public enum SkillType {
    PILOTING("Piloting"),
    TRADING("Trading"),
    FIGHTING("Fighting"),
    ENGINEERING("Engineering");

    private final String name;

    private SkillType(String name) {
        this.name = name;
    }

    public String toString(){
        return name;
    }
}
