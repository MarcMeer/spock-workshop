package com.opsmen.klantensysteem.service;

import com.opsmen.klantensysteem.model.UrenRegel;
import com.opsmen.klantensysteem.model.WeekUrenStaat;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface IUrenService {
    void update(WeekUrenStaat weekUrenStaat, Optional<String> urenRegelId, UrenRegel urenRegel);
    WeekUrenStaat getByWeek(int jaar, int week, String medewerker);
    List<WeekUrenStaat> getMyMaand(int jaar, int maand);
    List<WeekUrenStaat> getBByJaar(int jaar);
    WeekUrenStaat getWeekUrenStaatById(String id);
}
