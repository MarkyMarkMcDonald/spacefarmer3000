package App.model;

public enum ShipModel
{
    GNAT("Gnat"),
    FIREFLY("Firefly"),
    MOSQUITO("Mosquito"),
	BUMBLEBEE("Bumblebee");


    private final String name;

    private ShipModel(String name) {
        this.name = name;
    }

    public String toString(){
        return name;
    }
}
