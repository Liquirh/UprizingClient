package uprizing;

import lombok.Getter;

@Getter
public enum Options {

    SCOREBOARD_NUMBERS("Scoreboard Numbers"),
    CHAT_BACKGROUND("Chat Background"),
    CLEAR_GLASS("Clear Glass"),
    WORLD_TIME_MODE("World Time Mode");

    private final String name;

    Options(final String name) {
        this.name = name;
    }
}