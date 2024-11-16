class Task2 {

    // Complete this method so that it gives the Expected Output
    public static Integer[] discardCards(Integer[] cards, int t) {
        boolean discard = true; // Start by discarding the first occurrence of the target number

        for (int i = 0; i < cards.length; i++) {
            if (cards[i] != null && cards[i] == t) {
                if (discard) {
                    cards[i] = 0; // Set the card to 0 when it needs to be discarded
                }
                discard = !discard; // Toggle the discard flag
            }
        }

        return cards;
    }

    // DO NOT CHANGE ANY DRIVER CODE BELOW THIS LINE
    public static void main(String[] args) {
        Integer[] cards1 = {1, 3, 7, 2, 5, 2, 2, 2, 0};
        System.out.print("Initial Cards: ");
        Arr.print(cards1);
        System.out.println("Expected Output: [ 1 3 7 5 2 2 0 0 0 ]");
        Integer[] returned_val_1 = discardCards(cards1, 2);
        System.out.print("Your Output: ");
        Arr.print(returned_val_1);

        System.out.print("\n======================\n");

        Integer[] cards2 = {5, 5, 5, 0, 0};
        System.out.print("\nInitial Cards: ");
        Arr.print(cards2);
        System.out.println("Expected Output: [ 5 0 0 0 0 ]");
        Integer[] returned_val_2 = discardCards(cards2, 5);
        System.out.print("Your Output: ");
        Arr.print(returned_val_2);
    }
}
