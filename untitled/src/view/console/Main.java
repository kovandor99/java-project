package view.console;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import model.EntryExitRecord;

//вывести приветствие
//авторизация
//предложить на выбор осуществить вход/выход "нажмите 1 для входа или 2 для выхода"
//вывести "отработано за сегодня за нажатие кнопки 3"
//
//утром приходит на работу и осуществляет вход, заканчивает работу и идёт на обед
//возвращается и начинает второй вход и потом заканчивает работу
//
//по желанию сделать оконное приложение

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        boolean loggedIn = false;
        List<EntryExitRecord> entryExitRecords = new ArrayList<>();

        //todo передать из контроллера результат авторизации
        //todo в контроллере сделать метод авторизации
        while (loggedIn)
        {
            Controller.showAction();

            int value = scanner.nextInt();
            scanner.nextLine();

            Controller.showAction(value);

            if (!loggedIn)
            {
                break;
            }
        }
        scanner.close();
    }
}