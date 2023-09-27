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

  public void use(String item) {
    switch(item) {
      case("health"): 
      if (Player.health <= 100) {
        Main.type(getUse(), 10);
        Player.health += 15;
      } else {
        Main.type("Health is full", 10);
      }
    }
  }

}