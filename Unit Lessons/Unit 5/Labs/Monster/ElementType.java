public enum ElementType {
    FIRE, WATER, EARTH, AIR, Dragon;

    public String getDisplayName() {
        return switch (this) {
            case FIRE -> "Fire";
            case WATER -> "Water";
            case EARTH -> "Earth";
            case AIR -> "Air";
            case Dragon -> "Dragon";
        };
    }

    public static ElementType fromString(String text) {
        if (text == null) return null;
        String t = text.trim().toLowerCase();
        return switch (t) {
            case "fire", "f" -> FIRE;
            case "water", "w" -> WATER;
            case "earth", "e" -> EARTH;
            case "air", "a" -> AIR;
            default -> null;
        };
    }
}
