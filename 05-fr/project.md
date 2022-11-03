# System aukcyjny

## Wprowadzenie

Specyfikacja wymagań funkcjonalnych w ramach informatyzacji procesu sprzedaży produktów w oparciu o mechanizm aukcyjny. 

## Procesy biznesowe

---
<a id="bc1"></a>
### BC1: Sprzedaż aukcyjna 

**Aktorzy:** [Sprzedający](#ac1), [Kupujący](#ac2)

**Opis:** Proces biznesowy opisujący sprzedaż za pomocą mechanizmu aukcyjnego. |

**Scenariusz główny:**
1. [Sprzedający](#ac1) wystawia produkt na aukcję. ([UC1](#uc1))
2. [Kupujący](#ac2) oferuje kwotę za produkt wyższą od aktualnie najwyższej oferty. ([UC2](#uc2)) ([BR1](#br1))
3. [Kupujący](#ac2) wygrywa aukcję ([BR2](#br2))
4. [Kupujący](#ac2) przekazuje należność Sprzedającemu. ([UC3](#uc3))
5. [Sprzedający](#ac1) przekazuje produkt Kupującemu. ([UC4](#uc4))

**Scenariusze alternatywne:** 

2.A. Oferta Kupującego została przebita, a [Kupujący](#ac2) pragnie przebić aktualnie najwyższą ofertę.
* 2.A.1. Przejdź do kroku 2.

3.A. Czas aukcji upłynął i [Kupujący](#ac2) przegrał aukcję. ([BR2](#br2))
* 3.A.1. Koniec przypadku użycia.

---

## Aktorzy

<a id="ac1"></a>
### AC1: Sprzedający

Osoba oferująca towar na aukcji.

<a id="ac2"></a>
### AC2: Kupujący

Osoba chcąca zakupić produkt na aukcji.


## Przypadki użycia poziomu użytkownika

### Aktorzy i ich cele

[Sprzedający](#ac1):
* [UC1](#uc1): Wystawienie produktu na aukcję

[Kupujący](#ac2)
* [UC2](#uc2): Licytacja produktu na aukcji
* [UC3](#uc3): Przekazanie kwoty za produkt Sprzedającemu
* [UC4](#uc4): Wysyłka produktu

---
<a id="uc1"></a>
### UC1: Wystawienie produktu na aukcję

**Aktorzy:** [Sprzedający](#ac1)

**Scenariusz główny:**
1. [Sprzedający](#ac1) zgłasza do systemu chęć wystawienia produktu na aukcję.
2. System prosi o podanie danych produktu i ceny wywoławczej.
3. [Sprzedający](#ac1) podaje dane produktu oraz cenę wywoławczą.
4. System weryfikuje poprawność danych.
5. System informuje o pomyślnym wystawieniu produktu na aukcję.

**Scenariusze alternatywne:** 

4.A. Podano niepoprawne lub niekompletne dane produktu.
* 4.A.1. System informuje o błędnie podanych danych.
* 4.A.2. Przejdź do kroku 2.

---

<a id="uc2"></a>
### UC2: Licytacja produktu na aukcji

**Aktorzy:** [Sprzedający](#ac1), [Kupujący](#ac2)

**Scenariusz główny:**
1. [Kupujący](#ac2) zgłasza chęć zakupu produktu na aukcji.
2. System przekazuję informację o produkcie i obecnej cenie.
3. [Kupujący](#ac2) oferuję kwotę za wystawiony produkt wyższą od aktualnej oferty.
4. System weryfikuję czy czas aukcji nie upłynął.
5. System weryfikuję czy [Kupujący](#ac2) zgłosił poprawną kwotę.
6. System informuje [Kupującego](#ac2) o przyjęciu zgłoszenia.
7. [Sprzedający](#ac1) dostaję powiadomienie o nowej najwyższej stawce aukcji.

**Scenariusze alternatywne:** 

4.A. Zgłoszenie wysłane po zakończeniu aukcji
* 4.A.1. System informuję [Kupującego](#ac2) o zakończeniu aukcji.
* 4.A.2. Koniec przypadku użycia.

5.A. Podano kwotę niższą od obecnie najwyższej oferty.
* 5.A.1. System informuję [Kupującego](#ac2) o niepowodzeniu transakcji.
* 5.A.2. Przejdź do kroku 2.

---
<a id="uc3"></a>
### UC3: Przekazanie kwoty za produkt

**Aktorzy:** [Sprzedający](#ac1), [Kupujący](#ac2)

**Scenariusz główny:**
1. [Sprzedający](#ac1) przekazuję informację do przelewu [Kupującemu](#ac2), który wygrał aukcję.
2. [Kupujący](#ac2) wykonuję przelew.
3. [Sprzedający](#ac1) potwierdza odebranie poprawnego przelewu [Kupującemu](#ac2).

**Scenariusze alternatywne:**

3.A. Niepowodzenie transakcji
* 3.A.1. Przejdź do kroku 1.

---
<a id="uc4"></a>
### UC4: Wysyłka produktu

**Aktorzy:** [Sprzedający](#ac1), [Kupujący](#ac2)

**Scenariusz główny:**
1. [Kupujący](#ac2) określa w systemie dane do wysyłki.
2. System zamawia kuriera w celu wysłania paczki z produktem z aukcji.
3. System informuję [Sprzedającego](#ac1) i [Kupującego](#ac2) o zatwierdzeniu wysyłki.

**Scenariusze alternatywne:**

3.A. Niepoprawne dane do wysyłki
* 3.A.1. System informuje [Kupującego](#ac2) o błędnym adresie
* 3.A.2. Przejdź do kroku 1.

---

## Obiewkty biznesowe (inaczje obiekty dziedzinowe lub informatycjne)

### BO1: Aukcja

Aukcja jest formą zawierania transakcji kupna-sprzedaży, w której Sprzedający określa cenę wywoławczą produktu, natomiast Kupujący mogą oferować własną ofertę zakupu każdorazowo proponując kwotę wyższą od aktualnie oferowanej kwoty. Aukcja kończy się po upływie określonego czasu. Jeśli złożona została co najmniej jedna oferta zakupy produkt nabywa ten Kupujący, który zaproponował najwyższą kwotę. 

### BO2: Produkt

Fizyczny lub cyfrowy obiekt, który ma zostać sprzedany w ramach aukcji.

### BO3: Transakcja

Przekazanie kwoty odpowiadającej cenie ustalonej w trakcie transakcji Sprzedającemu przez Kupującego.


## Reguły biznesowe

<a id="br1"></a>
### BR1: Złożenie oferty

Złożenie oferty wymaga zaproponowania kwoty wyższej niż aktualnie oferowana o minimum 1,00 PLN.


<a id="br2"></a>
### BR2: Rozstrzygnięcie aukcji

Aukcję wygrywa ten z [Kupujący](#ac2)ch, który w momencie jej zakończenia (upłynięcia czasu) złożył najwyższą ofertę.

## Macierz CRUDL


| Przypadek użycia                    | Aukcja | Produkt |
|-------------------------------------|--------|---------|
| UC1: Wystawienia produktu na aukcję | C      | C       |
| UC2: Licytacja produktu na aukcji   | R,U    | R,U     |
| UC3: Przekazanie kwoty za produkt   | D      |         |
| UC4: Wysyłka produktu               |        | D       |