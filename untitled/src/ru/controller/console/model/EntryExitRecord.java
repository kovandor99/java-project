package ru.controller.console.model;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

//todo сделать вложенным классом для класса DailyReport "nested class"

public class EntryExitRecord
{
    // Поле для хранения времени входа
    private LocalDateTime timeEntry;
    // Поле для хранения времени выхода
    private LocalDateTime timeExit;
    // Флаг, показывающий, была ли записана информация о выходе
    private boolean isExitRecorded;

    // Конструктор для создания записи о входе
    public EntryExitRecord(LocalDateTime time) {
        this.timeEntry = time; // Устанавливает время входа
        this.isExitRecorded = false; // Изначально выход не записан
    }

    // Метод для получения времени входа
    public LocalDateTime getTime() {
        return timeEntry; // Возвращает время входа
    }

    // Метод для проверки, была ли это запись о входе
    public boolean isEntry() {
        return timeExit == null; // Возвращает true, если время выхода не установлено
    }

    // Метод для проверки, была ли записана информация о выходе
    public boolean isExitRecorded() {
        return isExitRecorded; // Возвращает true, если информация о выходе записана
    }

    // Метод для записи информации о выходе
    public void recordExit() {
        if (!isExitRecorded()) { // Проверяем, не записан ли уже выход
            timeExit = LocalDateTime.now(); // Устанавливаем текущее время как время выхода
            isExitRecorded = true; // Отмечаем, что выход был записан
        }
    }

    // Статический метод для расчета общего рабочего времени
    public static Duration calculateTotalWorkingTime(List<EntryExitRecord> entryExitRecords) {
        Duration totalWorkingTime = Duration.ZERO; // Начальное значение общего времени
        // Проходим по всем записям о входах
        for (EntryExitRecord entryRecord : entryExitRecords) {
            if (!entryRecord.isEntry()) {
                continue; // Если это не запись о входе, пропускаем
            }
            LocalDateTime entryTime = entryRecord.getTime(); // Получаем время входа
            // Ищем соответствующую запись о выходе, произошедшую после входа
            for (EntryExitRecord exitRecord : entryExitRecords) {
                if (!exitRecord.isEntry() && exitRecord.getTime().isAfter(entryTime)) {
                    LocalDateTime exitTime = exitRecord.getTime(); // Время выхода
                    // Рассчитываем разницу между входом и выходом и добавляем к общему времени
                    totalWorkingTime = totalWorkingTime.plus(Duration.between(entryTime, exitTime));
                    break; // Выходим из внутреннего цикла, так как найден соответствующий выход
                }
            }
        }
        return totalWorkingTime; // Возвращает общее время, проведенное между входами и выходами
    }
}