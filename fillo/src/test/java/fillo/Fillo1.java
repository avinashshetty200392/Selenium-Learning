package fillo;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class Fillo1 {
	String filePath;
	Fillo fillo;
	Connection connection;
	Recordset recordset;

	@BeforeTest
	public void configuration() {
		String Projectdir = System.getProperty("user.dir");
		filePath = Projectdir + "\\testRunner.xlsx";
		fillo = new Fillo();
	}

	@Test
	public void test() throws Exception {
		connection = fillo.getConnection(filePath);
		String strQuery = "Select * from runnerFile where Pack='Regression' and Run='Yes'";
		recordset = connection.executeQuery(strQuery);
		
		while (recordset.next()) {
			String modules = recordset.getField("Module");
			String submodules = recordset.getField("SubModule");
			System.out.println("Module: "+modules);
			System.out.println("Sub module: "+submodules);

		}
	}

	@AfterTest
	public void tearDown() {
		recordset.close();
		connection.close();
	}
}
