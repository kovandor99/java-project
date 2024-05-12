package ru.controller.console.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class DailyReport
{
    // Поле для хранения даты отчета
    private final LocalDateTime reportDate;
    // Список для хранения записей о входах
    private final List<EntryExitRecord> entryRecords;
    // Список для хранения записей о выходах
    private final List<EntryExitRecord> exitRecords;

    // Конструктор для создания ежедневного отчета с указанной датой
    public DailyReport(LocalDateTime reportDate) {
        this.reportDate = reportDate; // Устанавливаем дату отчета
        this.entryRecords = new ArrayList<>(); // Инициализация списка записей о входах
        this.exitRecords = new ArrayList<>(); // Инициализация списка записей о выходах
    }

    // Метод для добавления записи о входе
    public void addEntryRecord(EntryExitRecord entryRecord) {
        entryRecords.add(entryRecord); // Добавляет запись о входе в список
    }

    // Метод для добавления записи о выходе
    public void addExitRecord(EntryExitRecord exitRecord) {
        exitRecords.add(exitRecord); // Добавляет запись о выходе в список
    }
    // Метод для проверки, есть ли у входов соответствующие выходы
    public boolean hasUnmatchedEntry() {
        // Для каждой записи о входе проверяем, есть ли соответствующая запись о выходе
        for (EntryExitRecord entryRecord : entryRecords) {
            boolean matched = false; // Флаг, показывающий, найден ли соответствующий выход
            // Ищем запись о выходе, которая произошла после входа
            for (EntryExitRecord exitRecord : exitRecords) {
                if (exitRecord.getTime().isAfter(entryRecord.getTime())) {
                    matched = true; // Если найден, устанавливаем флаг в true
                    break;
                }
            }
            if (!matched) {
                return false; // Если хотя бы один вход без соответствующего выхода, возвращаем false
            }
        }
        return true; // Если все входы имеют соответствующие выходы, возвращаем true
    }

    // Метод для получения даты отчета
    public LocalDateTime getReportDate() {
        return reportDate; // Возвращает дату отчета
    }

    // Метод для получения списка записей о входах
    public List<EntryExitRecord> getEntryRecords() {
        return entryRecords; // Возвращает список записей о входах
    }

    // Метод для получения списка записей о выходах
    public List<EntryExitRecord> getExitRecords() {
        return exitRecords; // Возвращает список записей о выходах
    }
}