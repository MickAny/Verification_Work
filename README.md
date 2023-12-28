# Итоговая контрольная работа  
  
## Информация о проекте  

Необходимо организовать систему учета для питомника в котором живут
домашние и вьючные животные.

## Задание

1. Используя команду cat в терминале операционной системы Linux, создать
два файла Домашние животные (заполнив файл собаками, кошками,
хомяками) и Вьючные животными заполнив файл Лошадьми, верблюдами и
ослы), а затем объединить их. Просмотреть содержимое созданного файла.
Переименовать файл, дав ему новое имя (Друзья человека).
2. Создать директорию, переместить файл туда.
![1-2](https://github.com/MickAny/Verification_Work/assets/125481778/e983a1ed-06cb-45c7-926f-74216437ddf1)

3. Подключить дополнительный репозиторий MySQL. Установить любой пакет
из этого репозитория.
![3](https://github.com/MickAny/Verification_Work/assets/125481778/91da616d-8be2-4b03-a10d-8645651e66a0)


4. Установить и удалить deb-пакет с помощью dpkg.
![4](https://github.com/MickAny/Verification_Work/assets/125481778/1f763047-befa-46d4-9dee-28f8b569e175)

5. Выложить историю команд в терминале ubuntu
![5](https://github.com/MickAny/Verification_Work/assets/125481778/b28a6b3f-586f-4230-b8c7-7ae90e25bf33)

6. Нарисовать диаграмму, в которой есть класс родительский класс, домашние
животные и вьючные животные, в составы которых в случае домашних
животных войдут классы: собаки, кошки, хомяки, а в класс вьючные животные
войдут: Лошади, верблюды и ослы).
![6](https://github.com/MickAny/Verification_Work/assets/125481778/c1c1d0c7-7b0e-4ffd-a0d1-0df712848202)

_____________________________________________

7. В подключенном MySQL репозитории создать базу данных “Друзья
человека”

` CREATE DATABASE Human_friends; `

8. Создать таблицы с иерархией из диаграммы в БД
9. Заполнить низкоуровневые таблицы именами(животных), командами
которые они выполняют и датами рождения
```sql
USE Human_friends; 

CREATE TABLE cats (       
    Id INT AUTO_INCREMENT PRIMARY KEY, 
    Name VARCHAR(30), 
    Birthday DATE,
    Commands VARCHAR(50)
    );

INSERT INTO cats (Name, Birthday, Commands)
VALUES 
('Муха', '2018-12-10', 'Шуршание вискасом'),
('Барсик', '2019-05-30', 'киса-киса!'),  
('Рыжик', '2022-09-18', 'Елочная игрушка'); 


CREATE TABLE dogs (       
    Id INT AUTO_INCREMENT PRIMARY KEY, 
    Name VARCHAR(30), 
    Birthday DATE,
    Commands VARCHAR(50)
    );

INSERT INTO dogs (Name, Birthday, Commands)
VALUES 
('Шарик', '2020-11-11', 'Сидеть'),
('Бобик', '2017-07-20', 'Лежать'),  
('Рекс', '2023-10-01', 'Голос');


CREATE TABLE hamsters (       
    Id INT AUTO_INCREMENT PRIMARY KEY, 
    Name VARCHAR(30), 
    Birthday DATE,
    Commands VARCHAR(50)
    );

INSERT INTO hamsters (Name, Birthday, Commands)
VALUES 
('Буська', '2022-12-01', ''),
('Чип', '2021-03-18', ''),  
('Дейл', '2022-11-17', '');


CREATE TABLE horses (       
    Id INT AUTO_INCREMENT PRIMARY KEY, 
    Name VARCHAR(30), 
    Birthday DATE,
    Commands VARCHAR(50)
    );

INSERT INTO horses (Name, Birthday, Commands)
VALUES 
('Буцефал', '2021-03-18', 'Галоп'),
('Плотва', '2015-04-17', 'Шагом'),  
('Пегас', '2016-11-17', 'Прыжок');


CREATE TABLE camels (       
    Id INT AUTO_INCREMENT PRIMARY KEY, 
    Name VARCHAR(30), 
    Birthday DATE,
    Commands VARCHAR(50)
    );

INSERT INTO camels (Name, Birthday, Commands)
VALUES 
('Стремительный', '2016-02-03', 'Вперед'),
('Легкий', '2016-08-12', 'Остановка'),  
('Осторожный', '2017-04-15', 'Отдых');


CREATE TABLE donkeys (       
    Id INT AUTO_INCREMENT PRIMARY KEY, 
    Name VARCHAR(30), 
    Birthday DATE,
    Commands VARCHAR(50)
    );

INSERT INTO donkeys (Name, Birthday, Commands)
VALUES 
('Осел', '2018-10-19', 'Тяни'),
('Сеня', '2017-05-18', 'Толкай'),  
('Стеша', '2019-12-27', 'Волочи');
```

10. Удалив из таблицы верблюдов, т.к. верблюдов решили перевезти в другой
питомник на зимовку. Объединить таблицы лошади, и ослы в одну таблицу.
```sql
DELETE FROM camel;

CREATE TABLE pack_animals AS
SELECT Name, Birthday, Commands FROM horses 
Union 
Select Name, Birthday, Commands From donkeys; 

```

11.Создать новую таблицу “молодые животные” в которую попадут все
животные старше 1 года, но младше 3 лет и в отдельном столбце с точностью
до месяца подсчитать возраст животных в новой таблице
```sql
CREATE TABLE home_animals AS
SELECT Name, Birthday, Commands FROM cats 
Union 
Select Name, Birthday, Commands From dogs
Union 
Select Name, Birthday, Commands From hamsters;


CREATE TABLE young_animals AS
SELECT *, timestampdiff(Month, Birthday, NOW()) AS 'Age' FROM pack_animals where timestampdiff(Month, Birthday, NOW()) between 12 and 36
Union
SELECT*, timestampdiff(Month, Birthday, NOW()) AS 'Age' FROM home_animals where timestampdiff(Month, Birthday, NOW()) between 12 and 36;
```

12. Объединить все таблицы в одну, при этом сохраняя поля, указывающие на
прошлую принадлежность к старым таблицам.
```sql
CREATE TABLE animals AS
Select Name, Birthday, Commands, Age From pack_animals Left Join young_animals On pack_animals.Name = young_animals.Name_yng
Union
Select Name, Birthday, Commands, Age From home_animals Left Join young_animals On home_animals.Name = young_animals.Name_yng;
```
_____________________________________________

13.Создать класс с Инкапсуляцией методов и наследованием по диаграмме.  
14. Написать программу, имитирующую работу реестра домашних животных.  
В программе должен быть реализован следующий функционал:  
   - 14.1 Завести новое животное
   - 14.2 определять животное в правильный класс
   - 14.3 увидеть список команд, которое выполняет животное
   - 14.4 обучить животное новым командам
   - 14.5 Реализовать навигацию по меню
