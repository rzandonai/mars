package br.com.rzandonai.mars;

import static org.junit.Assert.assertEquals;

import br.com.rzandonai.mars.dtos.PositionDTO;
import br.com.rzandonai.mars.exceptions.MovimentException;
import br.com.rzandonai.mars.services.MarsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MarsTests {

	@Autowired
	private MarsService marsService;

	@Test
	public void contextLoads() {
	}

	@Test
	public void case1() {
		PositionDTO position = marsService.calculatePosition("MMRMMRMM");
		assertEquals(position.toString(), "(2, 0, S)");
	}

	@Test
	public void case2() {
		PositionDTO position = marsService.calculatePosition("MML");
		assertEquals(position.toString(), "(0, 2, W)");
	}

	@Test
	public void case3() {
		PositionDTO position = marsService.calculatePosition("MML");
		assertEquals(position.toString(), "(0, 2, W)");
	}


	@Test
	public void case4() {
		PositionDTO position = marsService.calculatePosition("MMRMMLMLMLML");
		assertEquals(position.toString(), "(1, 2, E)");
	}

	@Test
	public void case5() {
		PositionDTO position = marsService.calculatePosition("MMRMMRMMRMMRMMR");
		assertEquals(position.toString(), "(0, 2, E)");
	}

	@Test
	public void case6() {
		PositionDTO position = marsService.calculatePosition("MMMMRMRMMMMLMLMMMM");
		assertEquals(position.toString(), "(2, 4, N)");
	}

	@Test(expected = MovimentException.class)
	public void case7() {
		PositionDTO position = marsService.calculatePosition("AAA");
	}

	@Test(expected = MovimentException.class)
	public void case8() {
		PositionDTO position = marsService.calculatePosition("MMMMMMMMMMMMMMMMMMMMMMMM");
	}
}
