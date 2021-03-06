# Правила по написанию кода

## Комментарии и переменные
* Старайтесь писать комментарии везде где может возникнуть путаница или непонимание.
* Название переменных, функция и классов должны полностью отображать их суть.
* Старайтесь писать названия переменных, функция и классов так что бы смысл был понятен одним словом.
* Название переменных, функция и классов начинается с большой буквы и пишется верблюдом (SystemInit) если состоит из нескольких слов.
* Снижаем время жизни не глобальных переменных объявляя их непосредственно перед местом их использования.

## Поля
* Поля должны быть вверху файла.
* Ограничивать области видимости локальных полей.
* Если поле должно быть типа private но к нему имеется доступ через get/set то в начале его названия добавляется "_" (_DelayCounter).

## Строки
* По возможности строки не должны превышать 120 символов.
* Для отступов использовать табуляцию а не пробелы.
* Открывающие и закрывающие фигурные скобки находятся в отдельной строке.

## Исключения
* Никогда не перехватывайте и не игнорируйте исключения без объяснения.
* Не используйте обобщенные исключения, кроме кода в библиотеках, в корне стека.

## Пути к файлам
* Пути к файлам должны быть относительными и не выходить за директорию проекта.
