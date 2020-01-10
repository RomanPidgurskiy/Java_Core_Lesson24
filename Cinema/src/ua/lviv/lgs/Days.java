package ua.lviv.lgs;

import java.util.Scanner;

public enum Days {
	
    Понеділок(1),
    Вівторок(2),
    Середа(3),
    Четвер(4),
    Пятниця(5),
    Субота(6),
    Неділя(7);
    
    
    int number;
	
	Days(int number){ this.number=number; }
		
	
	
	public static Days getDay(){
		System.out.println("Виберіть день тижня -- ");
	
		for (Days day:Days.values()) {
			System.out.println("("+day.number+") - "+day.name());
		}
		Scanner sc = new Scanner(System.in);
		int i=0;
		if (sc.hasNextInt()) i = sc.nextInt();
		for (Days day:Days.values()) {
			if (day.number==i) {
				return day;				
			}
		}
		return null;
	}
}

