package ua.lviv.lgs;

import java.util.Scanner;

public enum Days {
	
    ��������(1),
    ³������(2),
    ������(3),
    ������(4),
    �������(5),
    ������(6),
    �����(7);
    
    
    int number;
	
	Days(int number){ this.number=number; }
		
	
	
	public static Days getDay(){
		System.out.println("������� ���� ����� -- ");
	
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

