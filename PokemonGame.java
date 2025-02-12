import java.util.*;

class PokemonGame {
    List<Card> deck = new ArrayList<>();
    List<Card> hand = new ArrayList<>();
    List<Card> discard = new ArrayList<>();
    List<Card> prize = new ArrayList<>();
    List<Card> bench = new ArrayList<>();



    Random random = new Random();

    void setDeck(int pokemonCount, int energyCount) {
        deck.clear();
        for (int i = 0; i < pokemonCount; i++) {
            deck.add(new Pokemon("Charmander", 50, "Scratch", 10, "Water"));
        }
        for (int i = 0; i < energyCount; i++) {
            deck.add(new Energy("Fire"));
        }
        Collections.shuffle(deck);
    }

    void drawHand(int count) {
        for (int i = 0; i < count; i++) {
            if (!deck.isEmpty()) {
                hand.add(deck.remove(0));
            }
        }
    }

    boolean hasPokemonInHand() {
        for (Card card : hand) {
            if (card instanceof Pokemon) {
                return true;
            }
        }
        return false;
    }

    static void calcMulliganPercent(int trials) {

        System.out.println("Pokemon Count, Mulligan %");


        for (int pokemonCount = 1; pokemonCount <= 60; pokemonCount++) {
            int mulligan = 0;

            for (int i = 0; i < trials; i++) {
                PokemonGame game = new PokemonGame();
                game.setDeck(pokemonCount, 60 - pokemonCount);
                game.drawHand(7);
                if (!game.hasPokemonInHand()) {
                    mulligan++;
                }
            }
            double mulliganRate = (mulligan / (double) trials) * 100;
            System.out.println(pokemonCount + " , " + mulliganRate);
        }
    }
}

