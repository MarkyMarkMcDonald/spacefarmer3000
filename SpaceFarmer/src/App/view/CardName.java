package App.view;

/**
 * User: marky
 * Date: 10/11/12
 * Time: 3:22 PM
 */
public enum CardName {
    WELCOME_CARD("WelcomeCard"){
        public Screen getScreen(){
            return new WelcomeScreen();
        }
    },
    PLAYER_INFORMATION_CARD("PlayerInformationCard"){
        public Screen getScreen(){
            return new PlayerInformationScreen();

        }
    },
    PLAYER_CREATED_CARD("PlayerCreatedCard"){
        public Screen getScreen(){
            return new PlayerCreatedScreen();
        }
    },
    TEMPORARY_SCREEN_CARD("TemporaryCard"){
        public Screen getScreen(){
            return new TemporaryScreen();
        }
    };

    private final String name;

    private CardName(String name) {
        this.name = name;
    }

    public abstract Screen getScreen();

    public String toString(){
        return name;
    }



}
