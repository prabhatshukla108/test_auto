import java.awt.AWTException;
import java.awt.Robot;
import java.util.Random;

public class HALL {

	public static void main(String[] args) throws AWTException {
		Robot robot = new Robot();
		Random r = new Random();
		while (true) {
			robot.delay(1000 * 60);
			int x = r.nextInt() % 640;
			int y = r.nextInt() % 320;
			robot.mouseMove(x, y);

		}

	}

}
