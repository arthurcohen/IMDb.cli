package com.forcohen.imdb.cli;
import java.sql.SQLException;
import java.util.Date;
import java.util.Scanner;

import com.forcohen.imdb.cli.dao.ClassDao;
import com.forcohen.imdb.cli.dao.ConnectionFactory;
import com.forcohen.imdb.cli.dao.ProjectDao;
import com.forcohen.imdb.cli.dao.ReportsDao;
import com.forcohen.imdb.cli.dao.ReviewDao;
import com.forcohen.imdb.cli.dao.TeacherClassDao;
import com.forcohen.imdb.cli.dao.TeacherDao;
import com.forcohen.imdb.cli.dao.UserDao;
import com.forcohen.imdb.cli.models.Class;
import com.forcohen.imdb.cli.models.Project;
import com.forcohen.imdb.cli.models.Review;
import com.forcohen.imdb.cli.models.Teacher;
import com.forcohen.imdb.cli.models.TeacherClass;
import com.forcohen.imdb.cli.models.User;
import com.forcohen.imdb.cli.screens.Screen;
import com.forcohen.imdb.cli.screens.ScreensFactory;

public class Main {
	private static ScreensFactory screensFactory = new ScreensFactory();
	private static ConnectionFactory connectionFactory = new ConnectionFactory().connect();
	private static Scanner kbd = new Scanner(System.in);
	private static int userId = -1;

	public static void main(String[] args) {	
		boolean running = false;
		
		screensFactory.clear().create(Screen.LOGIN).present();
		while (!running) {
			screensFactory.message("Enter your username: ").present();
			String login = kbd.nextLine();
			
			screensFactory.message("Enter your password").present();
			String password = kbd.nextLine();
			
			User user = new User("", login, password);
			
			userId = new UserDao(connectionFactory.getInstance()).login(user);
			
			if (userId != -1)
				running = true;
			
			screensFactory.clear().message("User and/or password invalid").present();
		}
		
		
		
		while (running) {
			screensFactory.clear().create(Screen.DASHBOARD).present();
			
			int option = readOption(1, 8);
			
			Screen screen = Screen.values()[option];
			
			screensFactory.clear().create(screen).present();
	
			switch (screen) {
			case ALL_DATA:
				option = readOption(9, 12);
				switch (option) {
				case 9:
					try {
						screensFactory.clear().plotReportFromResultSet(new TeacherDao(connectionFactory.getInstance()).findAll().resultSet());
					} catch (NullPointerException e1) {
						e1.printStackTrace();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					break;
				case 10:
					try {
						screensFactory.clear().plotReportFromResultSet(new ClassDao(connectionFactory.getInstance()).findAll().resultSet());
					} catch (NullPointerException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case 11:
					try {
						screensFactory.clear().plotReportFromResultSet(new ReviewDao(connectionFactory.getInstance()).findAll().resultSet());
					} catch (NullPointerException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case 12:
					try {
						screensFactory.clear().plotReportFromResultSet(new ProjectDao(connectionFactory.getInstance()).findAll().resultSet());
					} catch (NullPointerException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				default:
					break;
				}
				break;
				
			case REVIEWS: 
				screensFactory.clear().message("ID Teacher: ").present();
				int idTeacher = Integer.parseInt(kbd.nextLine());
				
				screensFactory.message("ID Class: ").present();
				int idClass = Integer.parseInt(kbd.nextLine());

				screensFactory.message("Your Review: ").present();
				String userReview = kbd.nextLine();

				screensFactory.message("How many stars: (1 to 5)").present();
				int stars = Integer.parseInt(kbd.nextLine());

				screensFactory.message("Which semester: (1 or 2)").present();
				int semester = Integer.parseInt(kbd.nextLine());
				
				screensFactory.message("Which year: ").present();
				int year = Integer.parseInt(kbd.nextLine());
				
				Review review = new Review(idTeacher, idClass, userId, userReview, stars, new Date(), semester, year);
				new ReviewDao(connectionFactory.getInstance()).save(review);
				
				break;
			case INSERTS:
				option = readOption(13, 17);
				switch (option) {
				case 13:

					screensFactory.clear().message("Name: (Fulano)").present();
					String name = kbd.nextLine();

					screensFactory.message("Area: (MAT, TEC or HUM)").present();
					String area = kbd.nextLine();

					screensFactory.message("Birth: (DD/MM/YYYY)").present();
					Date birth = new Date(kbd.nextLine());
					
					Teacher teacher = new Teacher(name, area, birth);
					
					new TeacherDao(connectionFactory.getInstance()).save(teacher);
					
					break;
				case 14:
					
					screensFactory.clear().message("Title: (FMC, VGA, WEB I, DB, etc.)").present();
					String title = kbd.nextLine();

					screensFactory.message("Area: (MAT, TEC or HUM)").present();
					area = kbd.nextLine();

					screensFactory.message("Component: (IMD0001, DIM2323)").present();
					String component = kbd.nextLine();
					
					Class classObj = new Class(title, area, component);
					
					new ClassDao(connectionFactory.getInstance()).save(classObj);
					
					break;	
				case 15:
					screensFactory.clear().message("ID Teacher: ").present();
					idTeacher = Integer.parseInt(kbd.nextLine());
					
					screensFactory.message("ID Class: ").present();
					idClass = Integer.parseInt(kbd.nextLine());
					
					TeacherClass teacherClass = new TeacherClass(idTeacher, idClass);
					
					new TeacherClassDao(connectionFactory.getInstance()).save(teacherClass);
					
					break;	
				case 16:
					screensFactory.clear().message("ID Teacher: ").present();
					idTeacher = Integer.parseInt(kbd.nextLine());

					screensFactory.message("Project title: ").present();
					title = kbd.nextLine();
					
					screensFactory.message("Project area: (MAT, TEC or HUM)").present();
					area = kbd.nextLine();

					screensFactory.message("Which semester: (1 or 2)").present();
					semester = Integer.parseInt(kbd.nextLine());
					
					screensFactory.message("Which year: ").present();
					year = Integer.parseInt(kbd.nextLine());
					
					Project project = new Project(idTeacher, title, area, semester, year);
					new ProjectDao(connectionFactory.getInstance()).save(project);
					
					break;	
				case 17:
					screensFactory.clear().message("Login: ").present();
					String login = kbd.nextLine();
					
					screensFactory.clear().message("password: ").present();
					String password = kbd.nextLine();
					
					User user = new User("", login, password);
					
					new UserDao(connectionFactory.getInstance()).save(user);
					break;
				}
				break;
			case QUIT:
				System.exit(0);
				
			case REPORTS:
				option = readOption(18, 30);
				try {
					switch (option) {
					case 18:
							screensFactory.clear().plotReportFromResultSet(new ReportsDao(connectionFactory.getInstance()).getTeachersReviews().resultSet());
						break;
					case 19:
							screensFactory.clear().plotReportFromResultSet(new ReportsDao(connectionFactory.getInstance()).getTeachersReviewsMostStars().resultSet());
						break;
					case 20:
							screensFactory.clear().plotReportFromResultSet(new ReportsDao(connectionFactory.getInstance()).getTeachersReviewsAverageStars().resultSet());
						break;
					case 24:
							screensFactory.clear().plotReportFromResultSet(new ReportsDao(connectionFactory.getInstance()).getTeachersProjectsMostStars().resultSet());
						break;
					case 27:
							screensFactory.clear().plotReportFromResultSet(new ReportsDao(connectionFactory.getInstance()).getTeachersClasses().resultSet());
						break;
					case 28:
							screensFactory.clear().plotReportFromResultSet(new ReportsDao(connectionFactory.getInstance()).getUsersReviews().resultSet());
						break;
					case 29:
							screensFactory.clear().plotReportFromResultSet(new ReportsDao(connectionFactory.getInstance()).getClassesAreas().resultSet());
						break;
					case 30:
							screensFactory.clear().plotReportFromResultSet(new ReportsDao(connectionFactory.getInstance()).getTeachersAreas().resultSet());
						break;
					default:
						screensFactory.clear().message("This report don't exist (yet)").present();
						break;
					}
				} catch (NullPointerException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			default:
				break;
			}
			
			kbd.nextLine();
		}
	}
	
	
	private static int readOption(int min, int max) {
		String input = kbd.nextLine();
		
		int option = -999;
		try {
			option = Integer.parseInt(input);
		}catch (NumberFormatException e) {}
		
		
		while (option < min || option > max) {
			screensFactory.message("\nInvalid option. Try again:\n").present();
			
			input = kbd.nextLine();
			try {
				option = Integer.parseInt(input);
			}catch (NumberFormatException e) {}
			
		}
		
		return option;
	}
}
