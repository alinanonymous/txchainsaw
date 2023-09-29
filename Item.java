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
        Main.type("Health is full.", 10);
      }

      case("bone"):
      if (Player.position == Leatherface.leatherfacePos) {
        Leatherface.isStunned = true;
        Main.type("\u001b[38;5;196mWith the sharp stinging noise of pierced flesh, the bone shard plunges into\n" +
        "his neck.\u001b[0m The man shrieks. It is a horrible and inhuman wail, as if an\n" +
        "otherworldly beast is attempting to express an emotion incomprehensible\n" +
        "to the human mind.", 10);
      }
    }
  }

}