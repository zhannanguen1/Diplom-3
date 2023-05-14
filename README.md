# Задание 3: веб-приложение
В последнем задании тебе нужно протестировать веб-приложение Stellar Burgers.

### Что нужно сделать
Опиши элементы, которые будешь использовать в тестах, с помощью Page Object.
Протестируй функциональность в Google Chrome и Яндекс.Браузере. Подключи Allure-отчёт.
Регистрация
Проверь:
Успешную регистрацию.
Ошибку для некорректного пароля. Минимальный пароль — шесть символов.
Вход
Проверь:
вход по кнопке «Войти в аккаунт» на главной,
вход через кнопку «Личный кабинет»,
вход через кнопку в форме регистрации,
вход через кнопку в форме восстановления пароля.
Переход в личный кабинет
Проверь переход по клику на «Личный кабинет».
Переход из личного кабинета в конструктор
Проверь переход по клику на «Конструктор» и на логотип Stellar Burgers.
Выход из аккаунта
Проверь выход по кнопке «Выйти» в личном кабинете.
Раздел «Конструктор»
Проверь, что работают переходы к разделам:
«Булки»,
«Соусы»,
«Начинки».

## Как выполнить и сдать работу
Напиши код в IDEA и запушь ветку develop3 на GitHub. Сделай пул-реквест. Подробная инструкция.
Как будут оценивать твою работу
Тесты в test/java.
Для Page Object создан отдельный пакет.
Для каждой страницы создан отдельный класс с Page Object.
Тесты разделены по тематике или функциональности. Для тестов созданы отдельные классы.
В файле pom.xml нет ничего лишнего.
Все элементы страниц, которые ты используешь в тестах, описаны в Page Object.
Название класса Page Object отражает его содержимое.
Названия локаторов понятны.
Тесты запускаются и не падают.
Названия тестов понятные и неизбыточные.
Тест — прежде всего проверка, а не набор действий. Каждый тест что-то проверяет.
Нужные тестовые данные создаются перед тестом и удаляются после того, как он выполнится.
Если для теста нужен тестовый юзер, он создаётся с помощью API.
Есть все тесты, которые описаны в задании.
Сделан Allure-отчёт. Отчёт добавлен в пул-реквест.
В проекте используется Java 11.