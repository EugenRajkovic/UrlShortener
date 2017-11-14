<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Upute za koristenje</h2>
	<br>
	<br>
    <p>Ovaj REST API dolazi spreman za koristenje. Testiran je u alatu Postman te ga preporucam za optimalne rezultate.
    	Prilikom pokretanja Postmana, prva adresa koja se unosi treba biti "http://localhost:8080/UrlShortener/webapi/account". 
    	Poziva se POST metoda, a u body-u zahtjeva pravimo JSON objekt s parametrom "AccountId" i unosimo nekakav string kao Id.
    	Nakon toga server odgovara sa JSON objektom, i ako je sve proslo OK moze se kopirati password u clipboard.</p>
    <p>Iduci korak je adresa "http://localhost:8080/UrlShortener/webapi/register" za koju se Authorization treba postaviti na Basic Auth
    	i kao username postaviti AccountId koji smo izabrali prije toga, a za lozinku onu koju smo si kopirali. Nakon toga treba kliknuti
    	na gumb "Update request" kako bi se autorizacija pojavila u head-eru requesta. U tijelo requesta trebamo staviti po specifikaciji 
    	JSON objekt koji sadrzi parametar "url", a to je onaj URL koji zelimo skratiti. Saljemo request sa metodom POST.</p>
    <p>U iducem koraku od servera se dobiva response sa kratkim URL-om na ciji ga klik mozemo posjetiti. Metodu treba odabrati GET. </p>
    <p>Nakon toga odlazimo na adresu "http://localhost:8080/UrlShortener/webapi/statistic/{AccountId}" gdje umjesto AccountId unosimo 
    	Id account-a koji smo otvorili. Treba se ponovno postaviti Authorization polje na Basic Auth i kao username postaviti AccountId 
    	koji smo izabrali u prvom koraku, a za lozinku onu koju smo dobili generiranu. Takodjer treba kliknuti na gumb "Update request". 
    	Kao odgovor dobivamo dugacki URL koji smo inicijalno spremili i broj posjeta na njega. Ponovnim posjetom kratkog URL-a pa dolaskom
    	na link za statistiku moze se primjetiti povecanje broja posjeta.</p>
</body>
</html>