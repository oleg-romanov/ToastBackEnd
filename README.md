# Серверная часть для приложения [Toast](https://github.com/oleg-romanov/Toast)
### Для работы данного приложения необходимо использовать базу данных PostgreSQL.
### После установки БД, необходимо произвести некоторые настройки в файле "application.properties", а именно :
<li>Указать URL для подключения к БД в строке: "spring.datasource.url="</li>
<li>Указать Указать имя пользователя БД в строке: "spring.datasource.username="</li>
<li>Указать пароль пользователя БД в строке: "spring.datasource.password="</li>

### Помимо настройки БД, чтобы проект запустился необходимо нажать сверху на "Edit configurations, нажав на плюсик добавить новую конфигурацию выбрав из выпадающего списка "Spring Boot" и указать MainClass: com.ngteam.toastapp.ToastApp"
