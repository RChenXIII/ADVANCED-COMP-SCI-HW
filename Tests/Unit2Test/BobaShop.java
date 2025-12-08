public class BobaShop {
    private String shopName;
    private BobaShopMember[] registeredMembers;

    public BobaShop(String shopName, BobaShopMember[] registeredMembers) {
        this.shopName = shopName;
        this.registeredMembers = registeredMembers;
    }

    public BobaShop(String shopName, int initialCapacity) {
        this.shopName = shopName;
        this.registeredMembers = new BobaShopMember[initialCapacity];
    }

    public String getShopName() {
        return shopName;
    }

    public BobaShopMember[] getRegisteredMembers() {
        return registeredMembers;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public void setRegisteredMembers(BobaShopMember[] registeredMembers) {
        this.registeredMembers = registeredMembers;
    }

    public boolean isFull() {
        // TODO
        for (int i = 0; i < registeredMembers.length; i++) {
            if (registeredMembers[i] == null) {
                return false;
            }
        }
        return true;
    }

    public void increaseCapacity() {
        BobaShopMember[] newArray = new BobaShopMember[registeredMembers.length * 2];

        for (int i = 0; i < registeredMembers.length; i++) {
            newArray[i] = registeredMembers[i];
        }

        registeredMembers = newArray;
    }

    public void registerMember(BobaShopMember member) {
        for (int i = 0; i < registeredMembers.length; i++) {
            if (registeredMembers[i] == null) {
                registeredMembers[i] = member;
                return;
            }
        }
    }

    public String toString() {
        if (registeredMembers == null || registeredMembers.length == 0) {
            return "";
        }
        String result = "== " + shopName + " ==\n";
        for (int i = 0; i < registeredMembers.length; i++) {
            if (registeredMembers[i] != null) {
                result += (i + 1) + ".) " + registeredMembers[i].toString() + "\n";
            }
        }
        return result;
    }

    public boolean deleteMember(BobaShopMember member) {
        // TODO
        for (int i = 0; i < registeredMembers.length; i++) {
            if (registeredMembers[i] != null
                    && registeredMembers[i].getName().equals(member.getName())) {
                registeredMembers[i] = null;
                return true;
            }
        }
        return false;
    }
}
