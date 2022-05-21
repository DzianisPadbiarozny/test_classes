import by.gsu.training.final1.Trip;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        //1. Cоздаем массив из 6 объектов
        Trip[] trip = new Trip[6];
        trip[0] = new Trip("Петров Александр", 700, 16);
        trip[1] = new Trip(21);
        trip[2] = null;
        trip[3] = new Trip (trip[0]);
        trip[4] = new Trip();
        trip[5] = new Trip("Курпатов Артем", 800, 5);
        int len = trip.length;

        //2. Вывод на экран всех объектов с помощью метода show()
        System.out.println("******************************");
        System.out.println("Задание №2");
        System.out.println("******************************");
        for (int i = 0; i < len; i++){
            if (trip[i] != null) {
                System.out.printf("Работник №%d: \n", i + 1);
                trip[i].show();
                System.out.println("------------------------------");
            } else {
                System.out.printf("Данные о работнике №%d отсутсвуют\n", i+1);
                System.out.println("------------------------------");
            }
        }

        //3. Изменяем транспортные расходы сотрудника, из последнего объекта массива
        System.out.println("******************************");
        System.out.println("Задание №3");
        System.out.println("******************************");
        System.out.printf("Транспортные расходы сотрудника %s до изменения: %s", trip[5].getFio(), trip[5].toByn(trip[5].getExpenses()));
        Scanner in = new Scanner(System.in);
        System.out.printf("\nВведите новое значения транспортных расходов, у сотрудника %s под номером 5 (в копейках):",trip[5].getFio());
        trip[5].setExpenses(in.nextInt());
       trip[5].show();

        //4. Добавить 1 день к последней командировке каждого сотрудника.
        System.out.println("\n******************************");
        System.out.println("Задание №4");
        System.out.println("******************************");
        for (int i = 0; i < len; i++) {
            if (trip[i] != null) {
                int u = i;
                for (int j = i + 1; j < len; j++) {
                    if (trip[j] != null && trip[i].getFio().equals(trip[j].getFio())) {
                        u = j;
                    }
                }
                int x = 0;
                for (int j = i - 1; j >= 0; j--) {
                    if (trip[j] != null && trip[i].getFio().equals(trip[j].getFio())) {
                        x = 1;
                        break;
                    }
                }
                if (x == 0)
                    trip[u].setDays(trip[u].getDays() + 1);
            }
        }
        System.out.println("Данные, после добавления 1 дня к последней командировке, каждого сотрудника:");
       for (int i = 0; i < len; i++){
            if (trip[i] != null) {
                System.out.printf("Работник №%d: \n", i + 1);
                trip[i].show();
                System.out.println("------------------------------");
            } else {
                System.out.printf("Данные о работнике №%d отсутсвуют\n", i+1);
                System.out.println("------------------------------");
            }
        }

       //5. Вывести содержимое массива на консоль (по одному элементу в строке), неявно используя метод toString().
        System.out.println("******************************");
        System.out.println("Задание №5");
        System.out.println("******************************");
        for (int i = 0; i < len; i++){
            if (trip[i] != null) {
                System.out.printf("Работник №%d: \n", i + 1);
                //Ошибка №5, сделал вывод на консоль, неявно используя метод toString()
                System.out.println(trip[i]);
                System.out.println("------------------------------");
            } else {
                System.out.printf("Данные о работнике №%d отсутсвуют\n", i+1);
                System.out.println("------------------------------");
            }
        }

        //6. Вывести суммарную продолжительность двух первых командировок сотрудника с заданным аккаунтом.
        System.out.println("******************************");
        System.out.println("Задание №6");
        System.out.println("******************************");
        System.out.println("Введите фамилию и имя сотрудника, для которого нужно найти сумму дней, первых 2-х командировок:");
        in.nextLine();
        String name = in.nextLine();
        int count = 0, sum = 0;
        for (int i = 0; i < len; i++){
            if (trip[i] != null && trip[i].getFio().equals(name)){
                count++;
                sum+=trip[i].getDays();
                if (count == 2) { // Исправил форматирование
                    break;
                }
            }
        }
        if ( count == 1 ) {
            System.out.println("Недостаточно данных для подсчёта");
        } else if ( count == 2 ) {
            System.out.printf("Продолжительность первых двух командировок у %s= %d\n", name, sum);
        } else {
            System.out.println("Не удалось найти сотрудника");
        }

        //7. Рассчитать среднее значение командировочных расходов всех сотрудников.
        System.out.println("******************************");
        System.out.println("Задание №7");
        System.out.println("******************************");
        int sr = 0, k = 0;
        for ( int i = 0; i < len; i++) {
            if ( trip[i] != null) {
                sr += trip[i].getExpenses();
                k++;
            }
        }
        //Ошибка №6, использовал переменную для подсчёта среднего значения, а не конкретное число
        System.out.println("Среднее значение командировочных расходов всех сотрудников = " + (Trip.toByn(sr/k)));
    }
}
