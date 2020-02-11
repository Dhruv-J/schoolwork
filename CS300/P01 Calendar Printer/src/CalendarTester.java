//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           Tester of the "CalendarPrinter" Class 
// Files:           CalendarPrinter.java
// Course:          CS 300, Fall Term, 2019
//
// Author:          Dhruv Jain
// Email:           djain22@wisc.edu
// Lecturer's Name: Gary Dahl
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:    Prafull Sharma
// Partner Email:   psharma49@wisc.edu
// Partner Lecturer's Name: Mouna Ayari Ben Hadj Kacem
// 
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//   X Write-up states that pair programming is allowed for this assignment.
//   X We have both read and understand the course Pair Programming Policy.
//   X We have registered our team prior to the team registration deadline.
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully 
// acknowledge and credit those sources of help here.  Instructors and TAs do 
// not need to be credited here, but tutors, friends, relatives, room mates, 
// strangers, and others do.  If you received no outside help from either type
//  of source, then please explicitly indicate NONE.
//
// Persons:         NONE
// Online Sources:  Zybooks
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////

public class CalendarTester {
	public static boolean testGetCentury() {
		if(CalendarPrinter.getCentury("2") != 0) return true;
		if(CalendarPrinter.getCentury("2019") != 20) return true;
		if(CalendarPrinter.getCentury("44444") != 444) return true;
		if(CalendarPrinter.getCentury("2019") == 21) return true;
		else return false;
	}
	
	public static boolean testGetYearWithinCentury() {
		if(CalendarPrinter.getYearWithinCentury("2019")==19) return true;
		if(CalendarPrinter.getYearWithinCentury("132")==32) return true;
		if(CalendarPrinter.getYearWithinCentury("5555")==55) return true;
		else return false;
	}
	
	public static boolean testGetIsLeapYear() {
		if(CalendarPrinter.getIsLeapYear("2019")) return false;
		if(CalendarPrinter.getIsLeapYear("118")) return false;
		if(CalendarPrinter.getIsLeapYear("20")) return true;
		else return false;
	}
	
	public static boolean testGetMonthIndex() {
		if(CalendarPrinter.getMonthIndex("ferbuary") == -1) return true;
		if(CalendarPrinter.getMonthIndex("FEBURURURURUR")==1) return true;
		if(CalendarPrinter.getMonthIndex("fEbruary")==1) return true;
		else return false;
	}
	
	public static boolean testGetNumberOfDaysInMonth() {
		if(CalendarPrinter.getNumberOfDaysInMonth("notRealMonth", "2001")==-1) return true;
		if(CalendarPrinter.getNumberOfDaysInMonth("January", "2001")==31) return true;
		if(CalendarPrinter.getNumberOfDaysInMonth("February", "2000")==29) return true;
		else return false;
	}
	
	public static boolean testGetFirstDayOfWeekInMonth() {
		if(CalendarPrinter.getFirstDayOfWeekInMonth("nOv", "2019")==4) return true;
		if(CalendarPrinter.getFirstDayOfWeekInMonth("SEP", "2019")==6) return true;
		if(CalendarPrinter.getFirstDayOfWeekInMonth("march", "1973")==3) return true;
		else return false;
	}
	
	public static void testGenerateCalendar(){
		String[][] testArr = CalendarPrinter.generateCalendar("September","2019");
		for(int i=0; i<testArr.length; i++){
			for(int l=0; l<7; l++){
				System.out.print(testArr[i][l]);
			}
			System.out.println();
		}
	}
	
	public static void generateFormattedCalendar(){
		String[][] calArr = CalendarPrinter.generateCalendar("September","2019");
		for(int i=0; i<calArr.length; i++) {
			System.out.printf("%-3s %-3s %-3s %-3s %-3s %-3s %-3s", calArr[i][0], calArr[i][1], calArr[i][2], calArr[i][3], calArr[i][4], calArr[i][5], calArr[i][6]);
			System.out.println();
		}
	}
	
	public static void main(String args[]) {
		//System.out.println(testGetCentury());
		//System.out.println(testGetYearWithinCentury());
		//System.out.println(testGetIsLeapYear());
		//System.out.println(testGetMonthIndex());
		//System.out.println(testGetNumberOfDaysInMonth());
		//System.out.println(testGetFirstDayOfWeekInMonth());
		//testGenerateCalendar();
	}
}
