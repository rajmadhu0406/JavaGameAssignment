package com.raj.natwest;

import com.raj.natwest.CustomExceptions.InvalidMoveException;
import com.raj.natwest.CustomExceptions.NullParameterException;
import com.raj.natwest.enums.Moves;
import com.raj.natwest.service.GameServiceImpl;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

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


	@Test
	void emptyPlayerMoveTest(){
		assertThrows(NullParameterException.class, () -> gameService.getResult("",Moves.rock));
	}

	@Test
	void invalidPlayerMove(){
		assertThrows(InvalidMoveException.class, () -> gameService.getResult("rook",Moves.rock));
		assertThrows(InvalidMoveException.class, () -> gameService.getResult("sicsor",Moves.rock));
	}

	@Test
	void randomComputerMoveTest(){
		assertThat(gameService.getRandomMove()).isIn(Moves.scissors, Moves.paper, Moves.rock);
		assertThat(gameService.getRandomMove()).isIn(Moves.scissors, Moves.paper, Moves.rock);
		assertThat(gameService.getRandomMove()).isIn(Moves.scissors, Moves.paper, Moves.rock);
		assertThat(gameService.getRandomMove()).isIn(Moves.scissors, Moves.paper, Moves.rock);
	}



}
