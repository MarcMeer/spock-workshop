package com.opsmen.klantensysteem.service;

import com.opsmen.klantensysteem.model.UrenRegel;
import com.opsmen.klantensysteem.model.WeekUrenStaat;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class DummyUrenService implements IUrenService {
    @Override
    public void update(WeekUrenStaat weekUrenStaat, Optional<String> urenRegelId, UrenRegel urenRegel) {

    }

    @Override
    public WeekUrenStaat getByWeek(int jaar, int week, String medewerker) {
        return null;
    }

    @Override
    public List<WeekUrenStaat> getMyMaand(int jaar, int maand) {
        return null;
    }

    @Override
    public List<WeekUrenStaat> getBByJaar(int jaar) {
        return null;
    }

    @Override
    public WeekUrenStaat getWeekUrenStaatById(String id) {
        return null;
    }
}
