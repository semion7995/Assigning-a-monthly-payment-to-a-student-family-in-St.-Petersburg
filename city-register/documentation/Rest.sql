ReST - representational state transfer передача репрезентативного состояния

Любой сервис который предоставляется на этой технологии может быть представлен как ресурс
CRUD - Create Read Update Delete

HTTP
POST - вставка
GET - получение
PUT - обновление
DELETE - удаление

URI = URL + URN
{Uniform resources identification} = {Uniform Resources Locator} + {Uniform Resources Name}

@Annotation ("URN")
public class Hello{

    @GET
    public String check(){
        return "ANSWER";
    }
}
Спецификация JAX-RS (Java API for RESTful Web Services Sanitiago Pericas-Geertsen and Marek Potocair Version 2.0)

1. В MAVEN подключаем
    - Jersey Container
    - Jersey inject
2. Вы должны прописать правила, которые позволят зарегистрировать ваши классы
реагирующие на те или иные запросы main/webapp/WEB-INF/web.xml
3. Написали сами классы @Path(/"check") class @GET method




