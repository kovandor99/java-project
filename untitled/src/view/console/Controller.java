package view.console;
//todo почитать соглашение о наименвоании в java и придумать как сделать правильное имя пакета чтобы не было дубликатов

import model.DailyReport;
import model.EntryExitRecord;
import java.time.LocalDateTime;

public class Controller
{
    // Поле для хранения отчета за день
    private DailyReport dailyReport;
    private boolean authenticated;
    private String validUsername;
    private String validPassword;

    // Конструктор класса Controller
    public Controller() {
        // Создаем новый отчет с текущей датой
        dailyReport = new DailyReport(LocalDateTime.now());
        // По умолчанию, пользователь не аутентифицирован
        this.authenticated = false;
        this.validUsername = "user";
        this.validPassword = "123";
    }
    // Все методы должны возвращать string который выводится пользователю
    // Метод для записи входа
    public String recordEntry() {
        // Получаем текущее время
        LocalDateTime currentTime = LocalDateTime.now();
        // Создаем запись о входе с этим временем
        EntryExitRecord entryRecord = new EntryExitRecord(currentTime);
        // Добавляем запись о входе в отчет
        dailyReport.addEntryRecord(entryRecord);
        // Печатаем сообщение об успешном добавлении записи о входе
        return "Запись о входе" + entryRecord;
    }
    // Метод для записи выхода
    public void recordExit() {
        // Получаем текущее время
        LocalDateTime currentTime = LocalDateTime.now();
        // Создаем запись о выходе с этим временем
        EntryExitRecord exitRecord = new EntryExitRecord(currentTime);
        // Добавляем запись о выходе в отчет
        dailyReport.addExitRecord(exitRecord);
    }
    // Метод для печати отчета
    public void printReport() {
        // Печатаем дату отчета
        System.out.println("Отчет за " + dailyReport.getReportDate());
        // Печатаем все записи о входах
        System.out.println("Записи о входе:");
        for (EntryExitRecord record : dailyReport.getEntryRecords()) {
            System.out.println("Вход в: " + record.getTime());
        }
        // Печатаем все записи о выходах
        System.out.println("Записи о выходе:");
        for (EntryExitRecord record : dailyReport.getExitRecords()) {
            System.out.println("Выход в: " + record.getTime());
        }
    }
    // Метод для проверки наличия несоответствий
    public boolean checkUnmatchedEntries() {
        // Проверка, есть ли записи о входах без соответствующих записей о выходах
        boolean hasUnmatched = dailyReport.hasUnmatchedEntry();
        if (hasUnmatched) {
            System.out.println("Есть несоответствующие записи.");
        } else {
            System.out.println("Все записи соответствуют.");
        }
        return hasUnmatched;
    }
    // Метод для аутентификации пользователя
    public boolean authenticate(String username, String password) {
        // Проверка, соответствуют ли введенные данные правильным учетным данным
        if (username.equals(validUsername) && password.equals(validPassword)) 
        {
            // Запись о входе при успешной аутентификации
            recordEntry();
            // Аутентификация успешна
            return authenticated = true; 
        } else {
            // Аутентификация не удалась
            return authenticated = false; 
        }
    }
    // Метод для обработки выбранного действия
    public void processAction(int action) {
        // В зависимости от выбранного действия, выполняем соответствующую операцию
        switch (action) {
            case 1:
                checkUnmatchedEntries(); // Проверить несоответствия
            break;
            case 2:
                printReport(); // Напечатать отчет
                break;
            case 3:
                recordExit(); // Записать выход
                break;
            default:
                // Если выбрано недопустимое действие, выводим предупреждение
                System.out.println("Недопустимое действие. Пожалуйста, выберите снова.");
                break;
        }
    }
    // Метод для отображения доступных действий
    public static String showActions() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("--------------------------------------");
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("1. Проверить несоответствия");
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("2. Напечатать отчет");
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("3. Выход");
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("-------------------------------------");
        
        return stringBuilder.toString();
    }
    // Метод для проверки, аутентифицирован ли пользователь
    public boolean authenticated() {
        return authenticated; // Возвращает состояние аутентификации
    }
}
