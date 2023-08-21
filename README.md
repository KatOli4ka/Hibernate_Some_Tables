# Hibernate
### Тренировочная задача
---
### Задача

1. Создать классы Employee и City с полями, аналогично созданным таблицам
2. Создать интерфейс EmployeeDAO
3. Создать в интерфейсе методы:
   * добавление сущности Employee в таблицу
   * получение конкретного объекта Employee по id
   * получение списка всех объектов Employee из базы
   * изменение конкретного объекта Employee в базе по id
   * удаление конкретного объекта Employee из базы по id
4. Реализовать сервис EmployeeDAO и каждый его метод в отдельном классе с помощью Hibernate
5. Связать сущности между собой так, чтобы из одного города могло быть несколько сотрудников, а один сотрудник — только из одного города
6. Включить полную каскадность
7. Сформировать слой DAO для сущности City
8. В методе main вызвать CRUD-операции для связанных сущностей