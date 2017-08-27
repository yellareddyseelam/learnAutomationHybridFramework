package factory;

import dataProvider.ConfigDataProvider;
import dataProvider.ExcelDataProvider;

public class DataProviderFactory {
	public static ConfigDataProvider configDataProvider() {
		ConfigDataProvider configDataProvider=new ConfigDataProvider();
		
		return configDataProvider;
		
	}
	public static ExcelDataProvider excelDataProvider() {
		ExcelDataProvider excelDataProvider=new ExcelDataProvider();
		return excelDataProvider;
	}

}
