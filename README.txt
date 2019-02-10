=================================================================
Exemplu de sincronizare a unei liste de tipul Producer - Consumer

Principiul de functionare al programului:
	-> se creeaza threaduri care acceseaza aceeasi zona de memorie si efectueaza 2 tipuri de operatii asupra ei:
				->adaugare de date
				->extragere de date
	-> zona de memorie este sincronizata astfel incat sa nu se provoace intreruperi
	-> programul ruleaza continuu 
Acest program este un model de sincronizare a datelor pentru procesele multithread.
===================================================================


_______________Structura programului_______________________

	================================
		Clasa Producer
	================================

		-> contine o lista peste care se va face operatie de adaugare a unei entitati de tip int
		-> aceasta clasa implementeaza interfata Runnable pentru realizarea unui thread nou
		-> constructorul acesteia primeste ca parametru o lista care este trimisa ca parametru din programul initial peste care se va realiza sincronizarea.
		   Tot constructorul initializeaza un thread ce apeleaza instanta de Producer creeata si apeleaza metoda de pornire a threadului
		-> metoda run() provenita din interfata Runnable este suprascrisa cu modul in care o sa functioneze clasa Producer.
			aceasta ruleaza continuu si sincronizeaza lista pe care o initializeaza in constructor. Daca lista contine mai mult de 100 de elemente, aceasta asteapta
			pana cand thredurile de Consumer mai elibereaza lista. Acest lucru se realizeaza punand thredul de Producer in asteptare prin sintaxa arrayList.wait().
			Daca lista are mai putin de 100 de elemente, thredurile de Producer pot pune in continuare entitati in lista si notifica celelalte threaduri prin operatia
			arrayList.notifyAll().
		-> Adaugarea de elemente in lista se face cu ajutorul clasei Random ce furnizeaza un Integer la intamplare, iar adaugarea elementelor in lista se face apeland metoda
		   arrayList.add(var).


	=================================
		Clasa Consumer
	=================================

		-> este similara cu clasa Producer, singura diferenta o face metoda suprascrisa run(), care la fel ca la Producer ruleaza permanent si sincronizeaza lista data
		   ca parametru in constructor. In metoda run() se verifica daca lista este vida. In acest caz thredurile de Consumer vor astepta pana ce thredurile de Producer vor
		   popula arrayListul, iar daca lista nu este vida, ele vor face remove de fiecare data la primul element al listei si il vor afisa.


	==================================
		Clasa Main
	==================================
		-> realizeaza instantierea de threduri si porneste executia programului principal


