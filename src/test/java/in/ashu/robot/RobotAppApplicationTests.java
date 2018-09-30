package in.ashu.robot;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.rule.OutputCapture;
import org.springframework.shell.Shell;
import org.springframework.shell.jline.InteractiveShellApplicationRunner;
import org.springframework.shell.jline.ScriptShellApplicationRunner;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Tests for {@link RobotAppApplication}.
 *
 * @author ashutosh
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(properties = {
		InteractiveShellApplicationRunner.SPRING_SHELL_INTERACTIVE_ENABLED + "=false",
		ScriptShellApplicationRunner.SPRING_SHELL_SCRIPT_ENABLED + "=false"
		})
public class RobotAppApplicationTests {

	@Autowired
	private Shell shell;

	@Rule
	public OutputCapture outputCapture = new OutputCapture();

	@Test
	public void contextLoads() {
		Object help = shell.evaluate(() -> "help");
		assertNotNull(help);
		assertThat(help.toString()).containsSequence("Robot Commands");
	}

	@Test
	public void check_charge_should_return_100() {
		shell.evaluate(() -> "charge");
		assertThat(shell.evaluate(() -> "status")).isEqualTo(100);
	}

	@Test
	public void carry_3_5_km() {
		shell.evaluate(() -> "charge");
		shell.evaluate(() -> "carry 3.5");
		assertThat(outputCapture.toString()).containsSequence("Walking complete.");
		assertThat(shell.evaluate(() -> "status")).isEqualTo(30);
	}

	@Test
	public void carry_2_km_3_kg() {
		shell.evaluate(() -> "charge");
		shell.evaluate(() -> "carry 2 3");
		assertThat(shell.evaluate(() -> "status")).isEqualTo(54);
	}

	@Test
	public void carry_12_kg() {
		shell.evaluate(() -> "carry --weight 12");
		assertThat(outputCapture.toString()).containsSequence("Overweight");
	}

	@Test
	public void carry_0_km_0_kg() {
		shell.evaluate(() -> "charge");
		shell.evaluate(() -> "carry");
		assertThat(shell.evaluate(() -> "status")).isEqualTo(100);
	}

	@Test
	public void scan() {
		shell.evaluate(() -> "scan");
		assertThat(outputCapture.toString()).containsSequence("Scan Failure");
	}

}
