package ua.lviv.lgs;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class Cinema {
	public static Time timeOpen;
	public static Time timeClose;

	private TreeMap<Days, Schedule> scheduleMap;

	public Cinema(Time timeOpen, Time timeClose) {
		super();
		this.scheduleMap = new TreeMap<Days, Schedule>();
		for (Days day : Days.values())
			this.scheduleMap.put(day, new Schedule());
		this.timeOpen = timeOpen;
		this.timeClose = timeClose;
	}

	public TreeMap<Days, Schedule> getScheduleMap() {
		return scheduleMap;
	}

	public static Time getTimeOpen() {
		return timeOpen;
	}



	public static Time getTimeClose() {
		return timeClose;
	}



	public void init() throws TimeException {
		Movie movie1 = new Movie("Aladdin", new Time(2, 8));
		Movie movie2 = new Movie("Dora and the Lost City of Gold", new Time(1, 42));
		Movie movie3 = new Movie("Angry Birds 2", new Time(1, 37));
		Movie movie4 = new Movie("Dumbo", new Time(1, 52));
		Movie movie5 = new Movie("Toy Story 4", new Time(1, 40));
		Movie movie6 = new Movie("Frozen II", new Time(1, 43));


	}

	public void addMovie() throws TimeException {
		try {
			Movie movie = new Movie();
			System.out.println("До списку доданий : ");
			movie.toString();
	System.out.println("Фільм [ " + movie.getTitle() + "  --   " + movie.getDuration() + "]");

		} catch (Exception error) {
			System.out.println("Time entered incorrectly");
			System.out.println(error);
		}
		
	}
	

	public void addSeance(Movie movie, Days day) {
		System.out.println("Сеанси на " + day.name());
		Schedule schedule = scheduleMap.get(day);
		if (schedule.seanceSet.size() == 0) {
			System.out.println("Сеансів на цей день немає");
		} else {
			Iterator<Seance> iterator = schedule.seanceSet.iterator();
			while (iterator.hasNext()) {
				System.out.println(iterator.next().toString());
			}
		}
		if (movie == null)
			System.out.println("Вкажіть номер  фільму щоб додати до сеансу:");
			movie = Movie.chooseMovie();
		try {
			schedule.addSeance(new Seance(movie, new Time("Початок сеансу")));
		} catch (Exception error) {
			System.out.println("Неправильний час");
			System.out.println(error);
		}
	}



	public void removeMovie(Movie movie) {
	
		Iterator<Movie> iterator = Movie.movieSet.iterator();
		while (iterator.hasNext()) {
			if (iterator.next().equals(movie))
				iterator.remove();
		}
		for (Days day : Days.values()) {
			Schedule schedule = scheduleMap.get(day);
			Iterator<Seance> iterator1 = schedule.seanceSet.iterator();
			while (iterator1.hasNext()) {
				Seance next = iterator1.next();
				if (next.getMovie().equals(movie))
					iterator1.remove();
			}
		}
	}

	public void removeSeance(Days day) {
		Schedule schedule = scheduleMap.get(day);
		if (schedule.seanceSet.size() == 0) {
			System.out.println("Ще немає сеансів на цей день");
		} else {
			Iterator<Seance> iterator = schedule.seanceSet.iterator();
			int i = 0;
			System.out.println("Виберіть сеанс для видалення");
			while (iterator.hasNext()) {
				i++;
				System.out.println(i + " - " + iterator.next().toString());
			}
			Scanner sc = new Scanner(System.in);
			Iterator<Seance> iterator1 = schedule.seanceSet.iterator();
			i = 0;
			int number = 0;
			if (sc.hasNextInt())
				number = sc.nextInt();
			while (iterator1.hasNext()) {
				iterator1.next();
				i++;
				if (i == number)
					iterator1.remove();
			}
		}
	}


	

	public void getSchedule(Schedule schedule) {
		if (schedule.seanceSet.size() == 0) {
			System.out.println("Ще немає сеансів на цей день");
		} else {
			Iterator<Seance> iterator = schedule.seanceSet.iterator();
			while (iterator.hasNext()) {
				System.out.println(iterator.next().toString());
			}
		}
	}

}
