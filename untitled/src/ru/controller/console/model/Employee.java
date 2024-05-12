package ru.controller.console.model;

public class Employee
{
    // Поле для хранения идентификатора сотрудника
    private int id;
    // Поле для хранения имени сотрудника
    private String name; // Исправлено на правильный стиль именования переменных

    // Конструктор для создания объекта сотрудника с идентификатором и именем
    public Employee(int id, String name) {
        // Проверка, чтобы ID был положительным числом
        if (id <= 0) {
            throw new IllegalArgumentException("ID должен быть положительным числом.");
        }
        // Проверка, чтобы имя не было пустым или null
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Имя не может быть пустым или null.");
        }
        // Устанавливаем идентификатор и имя сотрудника
        this.id = id;
        this.name = name;
    }

    // Метод для получения идентификатора сотрудника
    public int getId() {
        return id; // Возвращает идентификатор сотрудника
    }

    // Метод для установки идентификатора сотрудника
    public void setId(int id) {
        // Проверка, чтобы новый идентификатор был положительным числом
        if (id <= 0) {
            throw new IllegalArgumentException("ID должен быть положительным числом.");
        }
        // Устанавливаем новый идентификатор
        this.id = id;
    }

    // Метод для получения имени сотрудника
    public String getName() {
        return name; // Возвращает имя сотрудника
    }

    // Метод для установки имени сотрудника
    public void setName(String name) {
        // Проверка, чтобы новое имя не было пустым или null
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Имя не может быть пустым или null.");
        }
        // Устанавливаем новое имя
        this.name = name;
    }

    // Переопределенный метод для преобразования объекта сотрудника в строку
    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id + ", name='" + name + '\'' +
                '}'; // Возвращает строковое представление объекта Employee
    }

    // Переопределенный метод для сравнения объектов
    @Override
    public boolean equals(Object obj) {
        // Проверка, ссылается ли объект на себя
        if (this == obj) {
            return true;
        }
        // Если объект null или классы не совпадают, возвращает false
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        // Приводим obj к Employee и сравниваем по id и имени
        Employee other = (Employee) obj;
        return id == other.id && name.equals(other.name);
    }

    // Переопределенный метод для получения хеш-кода
    @Override
    public int hashCode() {
        return java.util.Objects.hash(id, name); // Возвращает хеш-код объекта Employee
    }
}