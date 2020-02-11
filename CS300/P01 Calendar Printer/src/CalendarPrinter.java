//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           Calendar Printer 
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


import java.util.Scanner;

public class CalendarPrinter {
	private final static String[] DAYS_OF_WEEK = {"MON", "TUE", "WED", "THU", "FRI",
			"SAT", "SUN"};
	private final static String[] MONTHS_OF_YEAR = {"JAN", "FEB", "MAR", "APR", "MAY",
			"JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC"};
	/**
	* Calculates the number of centuries (rounded down) that is represented by
	* the specified year (ie. the integer part of year/100).
	* @param year to compute the century of (based on the Gregorian Calendar AD)
	* String must contain the digits of a single non-negative int for year.
	* @return number of centuries in the specified year
	*/
	public static int getCentury(String year) {
		return Integer.parseInt(year)/100;
	}
	/**
	* Calculates the number of years between the specified year, and the first
	* year in the specified year's century. This number is always between 0 - 99.
	* @param year to compute the year within century of (Gregorian Calendar AD)
	* String must contain the digits of a single non-negative int for year.
	* @return number of years since first year in the current century
	*/
	public static int getYearWithinCentury(String year) {
		return Integer.parseInt(year.substring(year.length()-2, year.length()));
	}
	/**
	* This method computes whether the specified year is a leap year or not.
	* @param yearString is the year that is being checked for leap-year-ness
	* String must contain the digits of a single non-negative int for year.
	* @return true when the specified year is a leap year, and false otherwise
	*/
	public static boolean getIsLeapYear(String yearString) {
		int yr = Integer.parseInt(yearString);
		if (yr%4!=0) return false;
		else if (yr%100!=0) return true;
		else if (yr%400!=0) return false;
		else return true;
	}
	// Note implementation tips in Appendix I below.
	/**
	* Converts the name or abbreviation for any month into the index of that
	* month's abbreviation within MONTHS_OF_YEAR. Matches the specified month
	* based only on the first three characters, and is case in-sensitive.
	* @param month which may or may not be abbreviated to 3 or more characters
	* @return the index within MONTHS_OF_YEAR that a match is found at
	* and returns -1, when no match is found
	*/
	public static int getMonthIndex(String month) {
		for(int i=0; i<12; i++) {
			if(month.substring(0, 3).toUpperCase().equals(MONTHS_OF_YEAR[i])) {
				return i;
			}
		}
		return -1;
	}
	/**
	* Calculates the number of days in the specified month, while taking into
	* consideration whether or not the specified year is a leap year.
	* @param month which may or may not be abbreviated to 3 or more characters
	* @param year of month that days are being counted for (Gregorian Calendar AD)
	* String must contain the digits of a single non-negative int for year.
	* @return the number of days in the specified month (between 28-31)
	*/
	public static int getNumberOfDaysInMonth(String month, String year) {
		int mo = getMonthIndex(month);
		if(mo==-1) {
			return -1;
		}
		else if(mo==1) {
			if(getIsLeapYear(year)) {
				return 29;
			}
			return 28;
		}
		else if(mo==0||mo==2||mo==4||mo==6||mo==7||mo==9||mo==11) {
			return 31;
		}
		else {
			return 30;
		}
	}
	/**
	* Calculates the index of the first day of the week in a specified month.
	* The index returned corresponds to position of this first day of the week
	* within the DAYS_OF_WEEK class field.
	* @param month which may or may not be abbreviated to 3 or more characters
	* @param year of month to determine the first day from (Gregorian Calendar AD)
	* String must contain the digits of a single non-negative int for year.
	* @return index within DAYS_OF_WEEK of specified month's first day
	*/
	public static int getFirstDayOfWeekInMonth(String month, String year) {
		int q=1;
		int K=getYearWithinCentury(year);
		int J=getCentury(year);
		int m=getMonthIndex(month);
		if(m==0||m==1) m+=13;
		else m+=1;
		
		int h=(q+(13*(m+1)/5)+K+(K/4)+(J/4)+(5*J))%7;
		if(getMonthIndex(month)==0||getMonthIndex(month)==1) h=h-1;
		if(getIsLeapYear(year)&&getMonthIndex(month)==1) h=h-1;
		
		if(h==0||h==1) return h+5;
		else return h-2;
	}
	/**
	* Creates and initializes a 2D String array to reflect the specified month.
	* The first row of this array [0] should contain labels representing the days
	* of the week, starting with Monday, as abbreviated in DAYS_OF_WEEK. Every
	* later row should contain dates under the corresponding days of week.
	* Entries with no corresponding date in the current month should be filled
	* with a single period. There should not be any extra rows that are either
	* blank, unused, or completely filled with periods.
	* For example, the contents for September of 2019 should look as follows,
	* where each horizontal row is stored in different array within the 2d result:
	*
	* MON TUE WED THU FRI SAT SUN
	* . . . . . . 1
	* 2 3 4 5 6 7 8
	* 9 10 11 12 13 14 15
	* 16 17 18 19 20 21 22
	* 23 24 25 26 27 28 29
	* 30 . . . . . .
	*
	* @param month which may or may not be abbreviated to 3 or more characters
	* @param year of month generate calendar for (Gregorian Calendar AD)
	* String must contain the digits of a single non-negative int for year.
	* @return 2d array of strings depicting the contents of a calendar
	*/
	public static String[][] generateCalendar(String month, String year){
		int arrCol=7;
		int arrRow=1;
		int ctr=1;
		int index=getFirstDayOfWeekInMonth(month, year);
		int temp = getNumberOfDaysInMonth(month, year)-7+index;
		arrRow+=1;
		arrRow+=temp/7;
		if(temp%7 != 0) arrRow+=1;
		
		String[][] calArr = new String[arrRow][arrCol];
		
		for(int i=0; i<arrRow; i++) {
			//FIRST ROW WITH DAYS ONLY
			if(i==0) {
				for(int l=0; l<7; l++) {
					calArr[0][l]=DAYS_OF_WEEK[l];
				}
			}
			//SECOND ROW WITH SOME DOTS AND SOME NUMBERS
			else if(i==1) {
				for(int l=0; l<index; l++) {
					calArr[i][l]=".";
				}
				for(int l=index; l<7; l++) {
					calArr[i][l]=Integer.toString(ctr);
					ctr+=1;
				}
			}
			//MIDDLE ROWS
			else if(i>1&&i<arrRow-1) {
				for(int l=0; l<7; l++) {
					calArr[i][l]=Integer.toString(ctr);
					ctr+=1;
				}
			}
			//LAST ROW
			else{
				for(int l=0; l<(getNumberOfDaysInMonth(month,year)-7+index)%7; l++) {
					calArr[i][l]=Integer.toString(ctr);
					ctr+=1;
				}
				for(int l=(getNumberOfDaysInMonth(month,year)-7+index)%7; l<7; l++){
					calArr[i][l]=".";
				}
			}
		}
		
		return calArr;
	}
	
	public static void main(String args[]) {
		System.out.println("Welcome to the Calendar Printer.");
		System.out.println("================================");
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the Month to Print: ");
		String str1 = sc.nextLine();
		System.out.print("Enter the Year to Print: ");
		String str2 = sc.nextLine();
		
		String[][] calArr = generateCalendar(str1, str2);
		for(int i=0; i<calArr.length; i++) {
			System.out.printf("%-3s %-3s %-3s %-3s %-3s %-3s %-3s", calArr[i][0], calArr[i][1], calArr[i][2], calArr[i][3], calArr[i][4], calArr[i][5], calArr[i][6]);
			System.out.println();
		}
		
		System.out.println("================================");
		System.out.println("Thanks, and have a nice day.");
	}
}