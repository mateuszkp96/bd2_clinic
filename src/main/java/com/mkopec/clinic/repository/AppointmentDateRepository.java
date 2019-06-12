package com.mkopec.clinic.repository;

import com.mkopec.clinic.projections.AppointmentDate;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Calendar;
import java.util.List;

public interface AppointmentDateRepository {

    @Query(nativeQuery = true,
            value = "select selectedDate, Dyżury_Sloty.id, DATE_FORMAT(Dyżury_Sloty.Sloty_start, \"%H:%i\") AS partStart , DATE_FORMAT(Dyżury_Sloty.Sloty_koniec, \"%H:%i\") AS partEnd, " +
                    "Lekarze.Pracownicy_imię AS firstname, Lekarze.Pracownicy_nazwisko AS surname " +
                    "from (select adddate('1970-01-01',t4.i*10000 + t3.i*1000 + t2.i*100 + t1.i*10 + t0.i) selectedDate from" +
                    " (select 0 i union select 1 union select 2 union select 3 union select 4 union select 5 union select 6 union select 7 union select 8 union select 9) t0," +
                    "(select 0 i union select 1 union select 2 union select 3 union select 4 union select 5 union select 6 union select 7 union select 8 union select 9) t1," +
                    "(select 0 i union select 1 union select 2 union select 3 union select 4 union select 5 union select 6 union select 7 union select 8 union select 9) t2," +
                    "(select 0 i union select 1 union select 2 union select 3 union select 4 union select 5 union select 6 union select 7 union select 8 union select 9) t3," +
                    "(select 0 i union select 1 union select 2 union select 3 union select 4 union select 5 union select 6 union select 7 union select 8 union select 9) t4) v, Dyżury " +
                    "JOIN Dyżury_Sloty ON Dyżury.id = Dyżury_Sloty.Dyżury_id " +
                    "JOIN Lekarze ON Dyżury.Lekarze_Pracownicy_id = Lekarze.Pracownicy_id " +
                    "LEFT JOIN Wizyty ON Wizyty.Dyżury_Sloty_id = Dyżury_Sloty.id WHERE Wizyty.id IS NULL " +
                    "AND selectedDate between :fromDate and :toDate AND Dyżury.dzień_tygodnia = DAYOFWEEK(selectedDate) AND Dyżury.Lekarze_Pracownicy_id IN :list " +
                    "ORDER BY selectedDate, Dyżury_Sloty.Sloty_start " +
                    "LIMIT 30;")
    List<AppointmentDate> findMyResult(@Param("fromDate") Calendar from, @Param("toDate") Calendar to, @Param("list") List<Long> doctorIDs);
}
