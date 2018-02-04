class PrintsMississipiInBlockLetters {
    public static void main(String[] args) {
      printMississipiInBlockLetters();
    }
    public static void printBlockLetterM() {
        System.out.println("M     M");
        System.out.println("MM   MM");
        System.out.println("M M M M");
        System.out.println("M  M  M");
        System.out.println("M     M");
        System.out.println("M     M");
        System.out.println("M     M\n");
    }
    public static void printBlockLetterI() {
        System.out.println(" IIIII");
        System.out.println("   I   ");
        System.out.println("   I   ");
        System.out.println("   I   ");
        System.out.println("   I   ");
        System.out.println("   I   ");
        System.out.println(" IIIII\n");
    }
    public static void printBlockLetterS() {
        System.out.println(" SSSSS");
        System.out.println("S     S");
        System.out.println("S      ");
        System.out.println(" SSSSS ");
        System.out.println("      S");
        System.out.println("S     S");
        System.out.println(" SSSSS\n");
    }
    public static void printBlockLetterP() {
        System.out.println("PPPPPP ");
        System.out.println("P     P");
        System.out.println("P     P");
        System.out.println("PPPPPP ");
        System.out.println("P");
        System.out.println("P");
        System.out.println("P\n");
    }
    public static void printBlockLettersISS() {
        printBlockLetterI();
        printBlockLetterS();
        printBlockLetterS();
    }
    public static void printMississipiInBlockLetters() {
        printBlockLetterM();
        printBlockLettersISS();
        printBlockLettersISS();
        printBlockLetterI();
        printBlockLetterP();
        printBlockLetterI();
    }
}