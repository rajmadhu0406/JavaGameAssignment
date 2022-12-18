package com.raj.natwest;

import com.raj.natwest.Exceptions.NullParameterException;
import com.raj.natwest.enums.Moves;
import com.raj.natwest.service.GameServiceImpl;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import org.testng.annotations.Test;
import org.junit.Ignore;
import static org.junit.Assert.assertEquals;

@SpringBootTest
class NatwestApplicationTests {


	@Autowired
	private GameServiceImpl gameService;

	@BeforeEach
	void startTest(){
		System.out.println("Starting test...\n\n");
	}

	@AfterEach
	void endTest(){
		System.out.println("End test...\n\n");
	}

	@Test
	void testGetResult(){

		//paper
		String actualResult = gameService.getResult("rock", Moves.paper);
		String expectedResult = "Computer wins";
		assertThat(actualResult).isEqualTo(expectedResult);

		actualResult = gameService.getResult("paper", Moves.paper);
		expectedResult = "It is a tie";
		assertThat(actualResult).isEqualTo(expectedResult);

		actualResult = gameService.getResult("scissors", Moves.paper);
		expectedResult = "Player wins";
		assertThat(actualResult).isEqualTo(expectedResult);

		//rock
		actualResult = gameService.getResult("rock", Moves.rock);
		expectedResult = "It is a tie";
		assertThat(actualResult).isEqualTo(expectedResult);

		actualResult = gameService.getResult("paper", Moves.rock);
		expectedResult = "Player wins";
		assertThat(actualResult).isEqualTo(expectedResult);

		actualResult = gameService.getResult("scissors", Moves.rock);
		expectedResult = "Computer wins";
		assertThat(actualResult).isEqualTo(expectedResult);

		//scissors
		actualResult = gameService.getResult("rock", Moves.scissors);
		expectedResult = "Player wins";
		assertThat(actualResult).isEqualTo(expectedResult);

		actualResult = gameService.getResult("paper", Moves.scissors);
		expectedResult = "Computer wins";
		assertThat(actualResult).isEqualTo(expectedResult);

		actualResult = gameService.getResult("scissors", Moves.scissors);
		expectedResult = "It is a tie";
		assertThat(actualResult).isEqualTo(expectedResult);
	}


	@Test(expected = NullParameterException.class)
	void emptyPlayerMoveTest(){
		String actualResult = gameService.getResult("", Moves.paper);
		String expectedResult = "Computer wins";

		System.out.println("\n\n ==>   " + actualResult);
//		assertThat(actualResult).isEqualTo(expectedResult);
	}


}
