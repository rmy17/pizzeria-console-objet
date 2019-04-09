package Service;

import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

import java.util.Scanner;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;
import org.mockito.Mockito;

import DAO.IPizzaDao;

public class ListerPizzasServiceTest {

	@Rule
	public TextFromStandardInputStream systemInMock = emptyStandardInputStream();

	@Test
	public void executeUC() {

		IPizzaDao mockedDao = Mockito.mock(IPizzaDao.class);
		ListerPizzasService listerPizzasService = new ListerPizzasService();
		listerPizzasService.executeUC(new Scanner(System.in), mockedDao);
		Mockito.verify(mockedDao).findAllPizzas();
	}
}
