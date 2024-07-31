package testClasses;

import utilities.ExcelReadClass;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviderClass {
  

  @DataProvider(name="unsuccesfull")
  public Object[][] dp() throws IOException {
    return new Object[][] {
      new Object[] {ExcelReadClass.getStringData(1, 0), ExcelReadClass.getStringData(0, 1) },
      new Object[] { "admin12", "Admin123" },
      new Object[] { "admin123", "Admin1234" },
    };
  }
}
