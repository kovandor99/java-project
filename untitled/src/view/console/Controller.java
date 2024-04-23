package view.console;

import model.EntryExitRecord;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Controller
{
    public static void showAction()
    {
        Scanner userScanner = new Scanner(System.in);
        Scanner passwordScanner = new Scanner(System.in);

        System.out.println("--------------------------");
        System.out.println("-Введите имя пользователя-");
        System.out.println("--------------------------");

        String username = userScanner.nextLine();

        System.out.println("--------------------------");
        System.out.println("------Введите пароль------");
        System.out.println("--------------------------");

        String password = passwordScanner.nextLine();
    }
    public boolean validateUser(String username, String password)
    {
        // Проверка правильности введенных учетных данных
        if (username.equals("correctUsername") && password.equals("correctPassword"))
        {
            System.out.println("Успешный вход.");
            System.out.println("Здравствуйте " + username + "!");
            return true;
        } else {
            System.out.println("Неправильный логин или пароль.");
            System.out.println("Пожалуйста, проверьте свой пароль и имя аккаунта и попробуйте снова.");
            return false;
        }
    }
    public static void processAction(int value)
    {





       /* Scanner scanner = new Scanner(System.in);
        List<EntryExitRecord> entryExitRecords = new ArrayList<>();

        switch (value)
        {
            case 1:
                loggedIn = true;
                entryExitRecords.add(new EntryExitRecord(LocalDateTime.now()));
                System.out.println("Вы вошли в систему.");
                break;
            case 2:
                System.out.println("Выход из программы.");
                return;
            case 3:
                Duration totalWorkingTime = EntryExitRecord.calculateTotalWorkingTime(entryExitRecords);
                System.out.println("Отработано за сегодня: " + totalWorkingTime.toMinutes() + " минут.");
                break;
            default:
                System.out.println("Неверный выбор.");
        }
        while (true)
        {

            if (!loggedIn)
            {1
                Controller selected = new Controller();
                selected.processAction(value); // Вызов метода callSwitch
            }
            else {
                System.out.println("Выберите действие:");
                System.out.println("1. Закончить работу и пойти на обед");
                System.out.println("2. Выйти из системы");

                int choice = scanner.nextInt();

                switch (choice)
                {
                    case 1:
                        for (EntryExitRecord record : entryExitRecords)
                        {
                            if (record.isEntry() && !record.isExitRecorded())
                            {
                                record.recordExit();
                                System.out.println("Работа отмечена.");
                                break;
                            }
                        }
                        break;
                    case 2:
                        loggedIn = false;
                        System.out.println("Выход из системы.");
                        break;
                    default:
                        System.out.println("Неверный выбор.");
                }
            }
        }*/
    }
}