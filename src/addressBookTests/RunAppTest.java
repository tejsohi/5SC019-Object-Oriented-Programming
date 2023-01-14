package addressBookTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import addressBookSrc.RunApp;

class RunAppTest {

	RunApp runApp = new RunApp();			//initialising the class runApp
	
	//Unit test that test the method main in runApp
	@Test
	void test() {
		assertDoesNotThrow(() -> RunApp.main(null));
	}

}
