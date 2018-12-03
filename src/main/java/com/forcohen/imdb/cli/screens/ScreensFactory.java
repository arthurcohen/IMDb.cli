package com.forcohen.imdb.cli.screens;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public final class ScreensFactory {
	private static StringBuilder screenGraphics = new StringBuilder();
	
	public ScreensFactory() {
		this.clear();
	}
	
	public ScreensFactory create(Screen screen) {
		screenGraphics.setLength(0); 
		switch (screen) {
		case DASHBOARD:
			screenGraphics = makeDashboard();
			break;
		case ALL_DATA:
			screenGraphics = makeAllData();
			break;
		case CONFIGURATION:
			screenGraphics = makeConfiguration();
			break;
		case INSERTS:
			screenGraphics = makeInserts();
			break;
		case REPORTS:
			screenGraphics = makeReports();
			break;
		default:
			break;
		}
		
		return this;
	}
	
	public void present() {
		System.out.println(screenGraphics);
	}
	
	public ScreensFactory clear() {
		screenGraphics.setLength(0);
		try {
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return this;
	}
	
	public ScreensFactory message(String message) {
		screenGraphics.setLength(0);
		screenGraphics.append(message);
		
		return this;
	}
	
	public void plotReportFromResultSet(ResultSet resultSet) throws SQLException {
		ResultSetMetaData rsmd = resultSet.getMetaData();
		int columnsNumber = rsmd.getColumnCount();
		while (resultSet.next()) {
		    for (int i = 1; i <= columnsNumber; i++) {
		        if (i > 1) System.out.print(",  ");
		        String columnValue = resultSet.getString(i);
		        System.out.print(rsmd.getColumnName(i) + ": " + columnValue);
		    }
		    System.out.println("");
		}
	}
	
	private static StringBuilder makeDashboard() {
		StringBuilder screenGraphics = new StringBuilder();  
		
		screenGraphics.append(makeTitle());
		screenGraphics.append("menu:\n\n");
		screenGraphics.append("1. Show all data\n");
		screenGraphics.append("2. Show reports\n");
		screenGraphics.append("3. Insert data\n");
		screenGraphics.append("4. Reviews\n");
		screenGraphics.append("5. Projects\n");
		screenGraphics.append("6. Login\n");
		screenGraphics.append("7. Quit\n");
		screenGraphics.append("8. Configuration\n");
		
		return screenGraphics;
	}
	
	private static StringBuilder makeTitle() {
		StringBuilder screenGraphics = new StringBuilder();

		screenGraphics.append("\n");
		
		
		screenGraphics.append("                                           \r\n" + 
				"		    _/_/_/  _/      _/  _/_/_/    _/       \r\n" + 
				"		     _/    _/_/  _/_/  _/    _/  _/_/_/    \r\n" + 
				"		    _/    _/  _/  _/  _/    _/  _/    _/   \r\n" + 
				"		   _/    _/      _/  _/    _/  _/    _/    \r\n" + 
				"		_/_/_/  _/      _/  _/_/_/    _/_/_/   .CLI  \r\n" + 
				"                                           \r\n" + 
				"                                           ");
		
		screenGraphics.append("\n");
		
		return screenGraphics;
	}
	
	private static StringBuilder makeConfiguration() {
		StringBuilder screenGraphics = new StringBuilder();
		
		screenGraphics.append("Configure your screen to fit all the stars bellow\n");
		
		for(int i=1; i<40; i++) {
			for(int j=1; j<100; j++) {
				screenGraphics.append('*');				
			}
			screenGraphics.append("*\n");
		}
		
		return screenGraphics;
	}
	
	private static StringBuilder makeAllData() {
		StringBuilder screenGraphics = new StringBuilder();

		screenGraphics.append("9. Teachers\n");
		screenGraphics.append("10. Classes\n");
		screenGraphics.append("11. Reviews\n");
		screenGraphics.append("12. Projects\n");
		
		return screenGraphics;
	}
	
	private static StringBuilder makeInserts() {
		StringBuilder screenGraphics = new StringBuilder();

		screenGraphics.append("13. Teacher\n");
		screenGraphics.append("14. Class\n");
		screenGraphics.append("15. Teacher-Class\n");
		screenGraphics.append("16. Project\n");
		screenGraphics.append("17. User\n");
		
		return screenGraphics;
	}
	
	private static StringBuilder makeReports() {
		StringBuilder screenGraphics = new StringBuilder();

		screenGraphics.append("18. Teachers Reviews\n");
		screenGraphics.append("19. Teachers Reviews Most Stars\n");
		screenGraphics.append("20. Teachers Reviews Average Stars\n");
		screenGraphics.append("24. Teachers Projects Most Stars\n");
		screenGraphics.append("27. All Teachers and Classes\n");
		screenGraphics.append("28. Users Most Reviews\n");
		screenGraphics.append("29. Classes Areas\n");
		screenGraphics.append("30. Teachers Areas\n");
		
		return screenGraphics;
	}
}
