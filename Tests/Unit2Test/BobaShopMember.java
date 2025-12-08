public class BobaShopMember {
    private String name;
    private boolean[] loyaltyCredits;

    public BobaShopMember(String name) {
        this.name = name;
        this.loyaltyCredits = new boolean[10];
    }

    public String getName() {
        return name;
    }

    public boolean[] getLoyaltyCredits() {
        return loyaltyCredits;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLoyaltyCredits(boolean[] loyaltyCredits) {
        this.loyaltyCredits = loyaltyCredits;
    }

    public void grantLoyaltyCredit() {
        if (loyaltyCredits == null || loyaltyCredits.length == 0) {
            return;
        }
        boolean isMarked = false;
        while (isMarked) {
            for (int i = 0; i < loyaltyCredits.length; i++) {
                if (loyaltyCredits[i] == false) {
                    loyaltyCredits[i] = true;
                    isMarked = true;
                    return;
                }
            }
        }


    }

    public int countLoyaltyCredits() {
        int count = 0;
        for (int i = 0; i < loyaltyCredits.length; i++) {
            if (loyaltyCredits[i] != false) {
                count++;
            }
        }
        return count;
    }


    public String determineMembershipStatus() {
        if (loyaltyCredits == null || loyaltyCredits.length == 0) {
            return "";
        }
        int count = 0;
        for (int i = 0; i < loyaltyCredits.length; i++) {
            if (loyaltyCredits[i] != false) {
                count++;
            }
        }
        if (count >= 6) {
            return "Gold Member";
        }
        if ((count <= 5) && (count >= 3)) {
            return "Silver Member";
        }
        if (count < 3) {
            return "Plus Member";
        }
        return "";
    }

    public String loyaltyHistory() {
        String result = "Loyalty History: [";
        for (int i = 0; i < loyaltyCredits.length; i++) {
            if (loyaltyCredits[i] != false) {
                result += (i + 1) + " X";
            } else {
                result += (i + 1) + " -";
            }
            result += ",";
        }
        return result + "]";
    }

    public String toString() {
        if (loyaltyCredits == null || loyaltyCredits.length == 0) {
            return "";
        }
        int count = 0;
        String determine = "";
        for (int i = 0; i < loyaltyCredits.length; i++) {
            if (loyaltyCredits[i] != false) {
                count++;
            }
        }
        if (count >= 6) {
            determine = "Gold Member";
        }
        if ((count <= 5) && (count >= 3)) {
            determine = "Silver Member";
        }
        if (count < 3) {
            determine = "Plus Member";
        }


        String result = name + "(" + determine + "), Loyalty History: [";
        for (int i = 0; i < loyaltyCredits.length; i++) {
            if (loyaltyCredits[i] != false) {
                result += " X";
            } else {
                result += " -";
            }
            result += ",";
        }

        return result + "]";
    }

    public boolean equals(BobaShopMember other) {
        if (!this.name.equals(other.name)) {
            return false;
        }

        for (int i = 0; i < this.loyaltyCredits.length; i++) {
            if (this.loyaltyCredits[i] != other.loyaltyCredits[i]) {
                return false;
            }
        }

        return true;
    }



}
