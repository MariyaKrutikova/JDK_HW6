import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import java.util.HashMap;
import java.util.Random;

public class MontyHallParadox {
//    int totalGames = 1000;
//    int switchWins = 0; //счетчик побед при смене двери
//    int stayWins = 0; ////счетчик побед при изменении двери

    public MontyHallParadox() {
    }

    public  void playMontyHallParadoxGame(int countOfGames) {
        HashMap<Integer, Integer> gameNumberSwitchWins = new HashMap<>();
        HashMap<Integer, Integer> gameNumberStayWins = new HashMap<>();
        int switchWins = 0;
        int stayWins = 0;
        for (int i = 1; i < countOfGames+1; i++) {
            // Имитируем игру countOfGames-раз
            Random rand = new Random();
            int carPosition = rand.nextInt(3);
            int initialChoice = rand.nextInt(3);

            // Открытие одной из дверей, за которой нет автомобиля
            int openDoor;
            do {
                openDoor = rand.nextInt(3);
            } while (openDoor == carPosition || openDoor == initialChoice);

            // Переключаемся на другую закрытую дверь
            int finalChoice;
            do {
                finalChoice = rand.nextInt(3);
            } while (finalChoice == initialChoice || finalChoice == openDoor);

            // Подсчитываем результаты
            if (finalChoice == carPosition) {
                switchWins++;
            } else if (initialChoice == carPosition) {
                stayWins++;
            }
            gameNumberSwitchWins.put(i,switchWins);
            gameNumberStayWins.put(i,stayWins);
        }

        System.out.println("При смене выбора выигрывает " + switchWins);
        System.out.println("При сохранении выбора выигрывает " + stayWins);
        System.out.println("При смене выбора выигрывает " + gameNumberSwitchWins);
        System.out.println("При сохранении выбора выигрывает " + gameNumberStayWins);
    }


    public void displayStatistics() {
        DescriptiveStatistics statistics = new DescriptiveStatistics();
    }
}
