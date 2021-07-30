# java-project
"назначение выплаты студенческой семье в Санкт-Петербурге" суть проекта написать приложение которое будет получать от пользователя student-order сохранять информацию в БД при этом проверять во внешних системах зарегистрирован ли брак, имеется ли свидетельство о рождении детей, является ли семья прописанной в Санкт-Петербурге и по итогам проверки вернуть пользователю информацию подходит семья под назначение выплаты.
В проекте использую следующий стек: ReST с реализацией jersey servlet для интеграции с внешними системами (проверка регистрации брака), JDBC, Hibernate, Criteria API, Spring, в качестве БД использую postgresSQL
