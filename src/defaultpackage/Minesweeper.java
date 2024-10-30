package defaultpackage;
import java.io.IOException;

import org.iu.minesweeper.controller.MinesweeperController;
import org.iu.minesweeper.view.MinesweeperFrame;

public class Minesweeper {
    public static void main(String[] args) throws ClassNotFoundException, IOException {
//        Game game = new Game();
//        game.run();
        
        MinesweeperFrame view = new MinesweeperFrame();
        @SuppressWarnings("unused")
		MinesweeperController controller = new MinesweeperController(null, view);
}
}