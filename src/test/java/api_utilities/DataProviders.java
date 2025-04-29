package api_utilities;

import org.testng.annotations.DataProvider;

import java.io.IOException;

public class DataProviders {

    private final String path = System.getProperty("user.dir")+"/src/test/resources/ApiTestData.xlsx";


    @DataProvider(name="allData")
    public String[][] getAllData() throws IOException {

        ExcelUtility utility = new ExcelUtility(path);

        int rowCount = utility.getNumberOfRow("Sheet1");
        int cellCount = utility.getNumberOfCell("Sheet1",0);

        String[][] data = new String[rowCount][cellCount];

        for(int i=1; i<=rowCount; i++){
            for(int j=0; j<cellCount; j++){

                data[i-1][j] = utility.getCellData("Sheet1",i,j);

            }
        }

        return data;

    }


    @DataProvider(name="allUserNames")
    public String[] getAllUserNames() throws IOException {

        ExcelUtility utility = new ExcelUtility(path);

        int rowCount = utility.getNumberOfRow("Sheet1");

        String[] data = new String[rowCount];

        for(int i=1; i<=rowCount; i++){

            data[i-1] = utility.getCellData("Sheet1",i,1);

        }

        return data;


    }

}
