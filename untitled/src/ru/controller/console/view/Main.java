package ru.controller.console.view;

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
        // Экземпляр контроллера
        Controller controller = new Controller();
        // Новый сканнер с названием scan
        Scanner scan = new Scanner(System.in);
        // Считываем данные для аутентификации
        System.out.println("Введите имя пользователя:");
        // Чтение имени пользователя
        String username = scan.nextLine();
        System.out.println("Введите пароль:");
        // Чтение пароля
        String password = scan.nextLine();
        // Проверка аутентификации
        boolean authenticated = controller.authenticate(username, password);
        // Цикл, выполняемый при успешной аутентификации
        while (authenticated)
        {
            System.out.println("Выберите действие " + username + ".");
            // Показ возможных действий
            System.out.println(Controller.showActions());
            // Считывание выбора
            int action = scan.nextInt();
            // Очищаем буфер после считывания]\ целого числа
            scan.nextLine();
            // Обработка выбранного действия
            controller.processAction(action); 
            // Проверка статуса аутентификации для продолжения или завершения цикла
            authenticated = controller.authenticated();
        }
            scan.close();
    }
    
}