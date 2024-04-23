package view.console;
import java.util.Scanner;

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


        //todo передать из контроллера результат авторизации
        //todo в контроллере сделать метод авторизации

        while (validateUser)
        {
            Controller.showAction();

            int value = scanner.nextInt();
            scanner.nextLine();

            Controller.processAction(value);

            if (!validateUser)
            {
                break;
            }
        }
        scanner.close();
    }
}