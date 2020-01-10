package ua.lviv.lgs;


import java.util.Scanner;


public class Application {
	public static void main(String[] args) {
		Cinema cinema = null;
		Days day;
		Schedule schedule;

		try {
			cinema = new Cinema(new Time(9,0), new Time(22,0));
			System.out.println("������ ������ ���������: " + Cinema.timeOpen.getHour()+":"+Cinema.timeOpen.getMin()+" - "+Cinema.timeClose.getHour()+":"+Cinema.timeClose.getMin());
		} catch (TimeException time_error) {
			System.out.println("Time Error");
			System.exit(0);
		}

		try {
			cinema.init();
		} catch (TimeException time_error) {
			System.out.println("Time Error");
			System.exit(0);
		}
		while (true) {
			System.out.println();
			System.out.println(" - 1: ������ �����");
			System.out.println(" - 2: �������� �����");
			System.out.println(" - 3: ������� ������ ������");
			System.out.println(" - 4: ������ �����");
			System.out.println(" - 5: �������� ����� � ������");
			System.out.println(" - 6: ������� ������ ������");
			System.out.println(" - 0: ����� � ��������");

			Scanner sc = new Scanner(System.in);
			int i = sc.nextInt();

			switch (i) {
			case 1:
				try {
					cinema.addMovie();
				} catch (TimeException time_error) {
					System.out.println("��� �������� ���������");
					
				}
				break;
				
			case 2:
					System.out.println("������ �����  ������ ��� ���������:");
				Movie movie = Movie.chooseMovie();
			
				cinema.removeMovie(movie);
				break;
				
			case 3:
				Movie.getMovieSet().stream().forEach(System.out::println);
				break;
				
			case 4:
				day = Days.getDay();
			
					cinema.addSeance(null, day);
				break;
				
	

				
			case 5:
				day = Days.getDay();
		
					cinema.removeSeance(day);
				break;
	

			case 6:
				for (Days day1 : Days.values()) {
					System.out.println();
					System.out.println(day1.name());
					schedule = cinema.getScheduleMap().get(day1);
					cinema.getSchedule(schedule);
				}
				break;
			
			case 0: System.exit(0); break;
				
			default:
				System.exit(0);
			}
		}

	}

}
