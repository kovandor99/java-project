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
        System.out.println("Выберите действие:");
        System.out.println("1. Вход");
        System.out.println("2. Выход");
        System.out.println("3. Отработано за сегодня");
    }
    public static void selected(int value)
    {

        Scanner scanner = new Scanner(System.in);
        boolean loggedIn = false;
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
            {
                showAction();
                Controller selected = new Controller();
                selected.selected(value); // Вызов метода callSwitch
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
        }
    }
}