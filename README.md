## WZORZEC KREACYJNY - FACTORY

* W moim kodzie, fabryka służy do tworzenia spokrewnionych obiektów.
Interfejs CarFactory definiuje najważniejsze funkcje, oraz typy zwracanych 
przez nie obiektów.

* CityCarFactory oraz SportCarFactory to klasy, do których przekazuje się implementację
CarFactory.

* Obiekt Factory posiada funkcję getCarType przyjmującą argument carType, typu String.
Obiekt ten zwraca obiekt należący do CarFactory.
Przy przekazaniu stringa "Sport", wywoływana jest Fabryka dla auta sportowego,
oraz zwracany jest ów obiekt.

* W metodzie nain znajduje się krótka demonstracja ów fabryki, wykorzystanej do 
stworzenia auta sportowego.

## WZORZEC STRUKTURALNY - FASADA

* W moim kodzie, fasada służy do opakowania zestawu klas, na których składa się samochód,
w jeden interfejs, za pomocą którego będzie można sterować komponentami w jednolity sposób.
CarFacade przyjmuje argumenty wchodzące w komponenty samochodu, oraz posiada metody
startCar oraz stopCar. W metodach tych, wywoływane są odpowiednie funkcje zdefiniowanych
wcześniej klas - komponentów.

* W metodzie main znajduje się krótka demonstracja ów fasady, w której tworzone są
pojedyncze komponenty. Następnie za ich pomocą tworzona jest fasada samochodu,
dzięki której wywoływane są metody "starujące samochód", oraz "wyłączające samochód".


## WZORZEC BEHAWIORALNY - STRATEGIA

* W moim kodzie, strategia zawiera algorytmy, dzięki których przetwarzany jest plik YAML.
YAML przedstawia przykładowy szkielet, który jest zdefiniowany według schematów:
YamlTestSkeleton oraz TypeSchema.

* Stworzone są strategie, LorryProcessorStrategy, oraz SportCarProcessorStrategy, które
matchują obiekt zdefiniowany w YAMLU, na podstawie określonych reguł. Strategia ta,
dodatkowo zawiera funkcje procesującą obiekt, która zwraca lekko zmodyfikowany typ.

* Funkcja procesująca została wyposażona w blok init, aby ukazać iż obiekt jest procesowany.
Dodatkowo, jeśli przy matchowaniu, okaże się że pasuje on do dwóch strategii, zostanie wywołany
wyjątek ProcessionError.

* Napisane zostały testy dla poszczególnych strategii - matchowania, oraz sprawdzenia poprawności procesowania
elementów (\src\test\kotlin\processor\*ProcessorStrategyTest.kt)

* Strategia jest bardzo przydatnym wzorcem, na przykład przy pracy z api za pomocą strategii,
można pisać generatory kodu, bazujące na określonych endpointach.


### 5 przykładów dobrych praktyk:

* W przypadku unit testów, dobrą praktką jest umieszczanie tylko jednej jednostki kodu
w metodzie testowej (w przeciwnym razie, będzie to już test integracyjny)
* Brak duplikatów, nie należy powtarzać się, trzeba zwracać uwagę na możliwości ponownego wykorzystania kodu
* Kod powinien być jak najprostrzy i zrozumiały, pozwoli to szybciej zrozumieć daną implementacją innym deweloperom, 
nie należy również trzymać kodu, który kiedyś mógłby się przydać - po to mamy gita
* Każda klasa bądź moduł powininy posiadać jedną odpowiedzialność - robić tylko jedną rzecz
* Klasa powinna być rozszerzalna, ale nie modyfikowalna 
(jeśli rozszerzając klasę o jakąś funkcjonalność, wymaga to zmian w jej implementacji, to jest źle :))

### Antywzorzec:

* Przesadne nadużywanie Active Record - łączenie ze sobą danych oraz logiki biznesowej w jednym obiekcie będzie prowadzić
m.in. do złamania zasady pojedynczej odpowiedzialności, braku wsparcia POCO,
prowadzi to do nadmiernego rozszerzania klas, utrudnia czytelność poprzez zbyt skomplikowaną zależność,
utrudnia to pisanie unit testów, które w takiej sytuacji mogą zostać wyparte przez testy integracyjne#   D e s i g n - P a t t e r n s  
 