package config;

import static config.BoxType.*;
import static config.BoxType.EXTRA_ROUND;
import static config.BoxType.TEN;

public class GameConfig {

    public static BoxType[] BOXES = {HUNDERT, TWENTY, TWENTY, FIVE, FIVE, FIVE, FIVE, FIVE, EXTRA, GAME_OVER, GAME_OVER, GAME_OVER};

    public static BoxType[] PROMISED_BOXES = {TWENTY, FIVE, TEN, EXTRA_ROUND};
}
