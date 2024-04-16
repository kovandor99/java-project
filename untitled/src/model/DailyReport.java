package model;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class DailyReport {
    private final LocalDateTime reportDate;

    public DailyReport(LocalDateTime reportDate)
    {
        this.reportDate = reportDate;
    }
//todo добавить метод вход и метод выход
    //при нормальной работе после каждого входа есть 1 выход
    //при входе создаётся новый обьект классна entryExitRecord на текущий момент времени и он добавляется в конец коллекции
    //при выходе берётся последний эл. из колекции entryExitRecord и в нее заполняется дата выхода
    public void addEntryRecord(EntryExitRecord record)
    {
        entryRecords.add(record);
    }
    public void addExitRecord(EntryExitRecord record)
    {
        exitRecords.add(record);
    }

    public boolean hasUnmatchedEntry() {
        for (EntryExitRecord entryRecord : entryRecords)
        {
            boolean matched = false;
            for (EntryExitRecord exitRecord : exitRecords)
            {
                if (exitRecord.getTime().isAfter(entryRecord.getTime()))
                {
                    matched = true;
                    break;
                }
            }
            if (!matched)
            {
                return false;
            }
        }
        return true;
    }
    /*
    public boolean checkEntryConsistency()
    {
        return entryRecords.size() % 2 == 0;
    }
     */
    public LocalDateTime getReportDate()
    {
        return reportDate;
    }
    public List<EntryExitRecord> getEntryRecords()
    {
        return entryRecords;
    }
    public List<EntryExitRecord> getExitRecords()
    {
        return exitRecords;
    }

    public Duration calculateTotalWorkingTime() {
        Duration totalWorkingTime = Duration.ZERO;
        entryRecords.forEach(entryRecord -> {
            if (!entryRecord.isEntry()) {
                return;
            }
            LocalDateTime entryTime = entryRecord.getTime();
            EntryExitRecord exitRecord = exitRecords.stream()
                    .filter(record -> !record.isEntry() && record.getTime().isAfter(entryTime))
                    .findFirst()
                    .orElse(null);
            if (exitRecord != null) {
                LocalDateTime exitTime = exitRecord.getTime();
                totalWorkingTime = totalWorkingTime.plus(Duration.between(entryTime, exitTime));
            }
        });
        return totalWorkingTime;
    }
}