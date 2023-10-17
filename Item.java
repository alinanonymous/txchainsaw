public class Item {
    public String name;
    public String desc;
    public String use;

    public void setDesc(String description) {
        desc = description;
    }

    public void setUse(String useString) {
        use = useString;
    }

    public String getDesc() {
        return desc;
    }

    public String getUse() {
        return use;
    }

    public void use(Item item) {
        switch (item.name) {

            case ("health"):
                if (Player.health <= 100) {
                    Main.type(getUse(), 10);
                    Player.health += 15;
                    if (Player.health > 100) {
                        Player.health = 100;
                    }
                } else {
                    Main.type("Health is full.", 10);
                }

            case ("bone"):
                if (Player.position == Leatherface.leatherfacePos) {
                    Leatherface.isStunned = true;
                    Main.type(Content.leatherfaceStun, 10);
                } else {
                    Main.type(getUse(), 10);
                }
        }
    }

    Item(String Name, String Desc, String Use) {
        name = Name;
        desc = Desc;
        use = Use;
    }

}