public abstract class Monster implements ElementalAttacks {
    protected String name;
    protected ElementType element;
    protected int health;
    protected int attack;
    protected int defense;
    protected int speed;
    protected int Megahealth;
    protected int Megaattack;
    protected int Megadefense;
    protected int Megaspeed;
    protected boolean hasUsedDoubleDown = false;

    // Two attacks for each monster, each with a name and an element type
    protected ElementType attackElementOne;
    protected ElementType attackElementTwo;
    protected String attackNameOne;
    protected String attackNameTwo;


    // Constructor (with mega stats)
    public Monster(String name, ElementType element, int health, int attack, int defense, int speed, String attackNameOne, String attackNameTwo, ElementType attackElementOne, ElementType attackElementTwo, int Megaattack, int Megadefense, int Megaspeed, int Megahealth) {
        this.Megaattack = Megaattack;
        this.Megahealth = Megahealth;
        this.Megadefense = Megadefense;
        this.Megaspeed = Megaspeed;
        this.name = name;
        this.element = element;
        this.health = health;
        this.attack = attack;
        this.defense = defense;
        this.speed = speed;
        this.attackNameOne = attackNameOne;
        this.attackNameTwo = attackNameTwo;
        this.attackElementOne = attackElementOne;
        this.attackElementTwo = attackElementTwo;
    }

    // Constructor (without explicit mega stats)
    public Monster(String name, ElementType element, int health, int attack, int defense, int speed, String attackNameOne, String attackNameTwo, ElementType attackElementOne, ElementType attackElementTwo) {
        this(name, element, health, attack, defense, speed, attackNameOne, attackNameTwo, attackElementOne, attackElementTwo, 100, 100, 100, 100);
    }

    /**
     * @return the megahealth
     */
    public int getMegahealth() {
        return Megahealth;
    }

    /**
     * @param megahealth the megahealth to set
     */
    public void setMegahealth(int megahealth) {
        Megahealth = megahealth;
    }

    /**
     * @return the megaattack
     */
    public int getMegaattack() {
        return Megaattack;
    }

    /**
     * @param megaattack the megaattack to set
     */
    public void setMegaattack(int megaattack) {
        Megaattack = megaattack;
    }

    /**
     * @return the megadefense
     */
    public int getMegadefense() {
        return Megadefense;
    }

    /**
     * @param megadefense the megadefense to set
     */
    public void setMegadefense(int megadefense) {
        Megadefense = megadefense;
    }

    /**
     * @return the megaspeed
     */
    public int getMegaspeed() {
        return Megaspeed;
    }

    /**
     * @param megaspeed the megaspeed to set
     */
    public void setMegaspeed(int megaspeed) {
        Megaspeed = megaspeed;
    }

    // Method to get the total sum of the monster's stats
    public int getTotalStatSum() {
        return health + attack + defense + speed;
    }

    // returns the name of the monster
    protected String getName() {
        return name;
    }

    // returns the health of the monster
    public int getHealth() {
        return health;
    }

    // sets the health of the monster
    public void setHealth(int health) {
        this.health = health;
    }

    // returns the attack of the monster
    public int getAttack() {
        return attack;
    }

    // sets the attack of the monster
    public void setAttack(int attack) {
        this.attack = attack;
    }

    // returns the defense of the monster
    public int getDefense() {
        return defense;
    }

    // sets the defense of the monster
    public void setDefense(int defense) {
        this.defense = defense;
    }

    // returns the element of the monster
    public ElementType getElement() {
        return element;
    }

    // sets the element of the monster
    public void setElement(ElementType element) {
        this.element = element;
    }

    // returns the speed of the monster
    public int getSpeed() {
        return speed;
    }

    // sets the speed of the monster
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    // reduces the health of the monster by the damage amount
    public void takeDamage(int damage) {
        health -= damage;
    }

    // flag double down as used
    public void useDoubleDown() {
        hasUsedDoubleDown = true;
    }

    // checks if double down has been used
    public boolean hasUsedDoubleDown() {
        return hasUsedDoubleDown;
    }
    
    // public abstract toString method to be implemented by subclasses
    public abstract String victoryNoise();

}
