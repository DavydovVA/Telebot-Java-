Bot: 
-
- Имя бота: test_dva_pvsm_bot
- Токен бота: 1115004291:AAGlnBaydiN6BAQshXphYXqb_W1R8lIIehM

Конфигурация бота в SimpleBot.java (в коде все прописано, в отедльный файл не выносил).


Что необходимо для запуска:
-
- Персональный компьютер
- Клавиатура
- Интернет-соединение
- запущенная локально MongoDB

Web Service:
-
через консоль (curl): curl localhost:8080/{command}

commands: 
- citis/list - вывести все записи бд.
- cities/{Город} - вывести описание города.
- cities/add/{Город} -d "description={Описание}" - добавить новую запись в таблицу бд.
- cities/update/{Город} -d "description={Новое описание}" - изменить запись в таблице бд.
- cities/remove/{Город} - удалить запись из таблицы бд.
                