public class PlayerFactory {
    public PlayerFactory() {
    }

    public Player buildPlayer(String type) {
        /**
         * Builds a player based on the provided type.
         *
         * @param type The type of player to build ("human", "whatever", "clever", or "genius").
         * @return A player instance corresponding to the specified type, or null if the type
         *         is unknown.
         */
        switch (type) {
            case "human":
                return new HumanPlayer();
            case "whatever":
                return new WhateverPlayer();
            case "clever":
                return new CleverPlayer();
            case "genius":
                return new GeniusPlayer();
            default:
                System.out.println(Constants.UNKNOWN_PLAYER_NAME);
                return null;
        }
    }
}
