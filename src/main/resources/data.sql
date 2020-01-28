INSERT INTO plany_studiow (id,kierunek, cykl_ksztalcenia, jezyk_studiow, stopien_studiow, tryb_studiow,wydzial)
        VALUE (1,'Informatyka','2017/2018','POLSKI','PIERWSZY','STACJONARNE','W8'),
              (2,'Zarządzanie','2017/2018','POLSKI','PIERWSZY','STACJONARNE','W8'),
              (3,'INŻYNIERIA BIOMEDYCZNA','2018/2019','POLSKI','PIERWSZY','STACJONARNE','W11'),
              (4,'Informatyka','2018/2019','POLSKI','PIERWSZY','STACJONARNE','W8'),
              (5,'Inżynieria Systemów','2018/2019','POLSKI','DRUGI','STACJONARNE','W11');

INSERT INTO przedmioty(id,plan_studiow_id ,nazwa,link_karty )
       VALUE (1,5,'Fizyka Systemów Złożonych','https://storage.googleapis.com/staging.conv3rt3r.appspot.com/Fizyka_syst_z%C5%82o%C5%BConych.pdf'),
             (2,1,'Administrowanie serwerami Linux','https://storage.googleapis.com/staging.conv3rt3r.appspot.com/Administrowanie_serweram.pdf'),
             (3,2,'Podstawy zarządzania','https://storage.googleapis.com/staging.conv3rt3r.appspot.com/ZMZ1116_S1L_ZP_Podstawy_zarzadzania.pdf'),
             (4,1,'Podstawy zarządzania','https://storage.googleapis.com/staging.conv3rt3r.appspot.com/Podst_Zarz.pdf'),
             (5,1,'Systemy operacyjne','https://storage.googleapis.com/staging.conv3rt3r.appspot.com/Systemy_operacyjne.pdf'),
             (6,3,'WPROWADZENIE DO PROGRAMOWANIA','https://storage.googleapis.com/staging.conv3rt3r.appspot.com/wprowadzenie_do_programowania.pdf'),
             (7,4,'Podstawy Programowania','https://storage.googleapis.com/staging.conv3rt3r.appspot.com/Podstawy_programowania.pdf');

INSERT INTO kursy(id,przedmiot_id,kod,ects,czy_grupa,forma_zaliczenia)
        VALUES (1,1,'FZP008008',2,TRUE ,'EGZAMIN'),
               (2,2,'INZ005234',1,FALSE,'EGZAMIN'),
               (3,3,'ZMZ1116',4,FALSE,'EGZAMIN'),
               (4,4,'ZMZ003559',2,FALSE,'ZALICZENIE'),
               (5,5,'INZ001521',2,FALSE,'ZALICZENIE'),
               (6,6,'INP001031L',2,FALSE,'ZALICZENIE'),
               (7,7,'INZ001519Wcl',2,TRUE,'ZALICZENIE');

INSERT INTO kursy_formy_zajec(kurs_id,forma_zajec)
        VALUES (1,'WYKLAD'),
               (1,'SEMINARIUM'),
               (2,'WYKLAD'),
               (3,'WYKLAD'),
               (4,'WYKLAD'),
               (5,'LABORATORIUM'),
               (6,'LABORATORIUM'),
               (7,'WYKLAD'),
               (7,'CWICZENIA'),
               (7,'LABORATORIUM');

INSERT INTO studenci(nr_index, imie,nazwisko)
        VALUES (21211,'Jan', 'Kowalski'),
               (23222,'Michał', 'Nowak'),
               (24242,'Jacek', 'Szary'),
               (25242,'Monika', 'Słomiana');

INSERT INTO podania(id,zamieniany,opiniujacy_id, status,uzasadnienie_podania,uzasadnienie_opinii,student )
        VALUES (1,7,null,'NIEROZPATRZONE','Kurs nie został zaliczony, a nie ma go w następnym cyklu kształcenia',null,23222 ),
         (2,3,null,'NIEROZPATRZONE','Kurs nie został zaliczony, a nie ma go w następnym cyklu kształcenia',null,25242 ),
         (3,2,null,'NIEROZPATRZONE','Kurs nie został zaliczony, a nie ma go w następnym cyklu kształcenia',null,21211 ),
         (4,5,null,'NIEROZPATRZONE','Kurs nie został zaliczony, a nie ma go w następnym cyklu kształcenia',null,21211 ),
         (5,6,null,'NIEROZPATRZONE','Kurs nie został zaliczony, a nie ma go w następnym cyklu kształcenia',null,24242 );

INSERT INTO opiniujacy(id, imie, nazwisko, tytul_naukowy) VALUES (1,'Jan', 'Nowak', 'DR');

INSERT INTO podania_zamienniki(podanie_id, zamiennik_id)
        VALUES (2,2),
               (3,1),
               (4,3),
               (1,6),
               (1,3),
               (5,7);