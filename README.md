## MockRest
### Java, Spring, REST, Mock
#### Дополнительные библиотеки Jackson и Lombok

### Инструкция
### Клонируем, открываем в Idea и запускаем главный клас

  ### Стандартный запуск в Idea через Run 'MockRestApplication'
  
   ### В постмане или аналоге выбираем метод POST и вставляем url:
    http://localhost:8080/random
    
  ### ... или вставляем url с любым айдишником:
    http://localhost:8080/1
    
  ### ... и в боди вставляем текст из запроса
    {
      "text" : "Text ..."
    }

#### После любого запроса, можно проверить, что в response.json в папке src/main/resources, записывается ответ
