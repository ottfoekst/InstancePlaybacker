package com.ottfoekst.instanceplaybacker.model.repository;

import com.ottfoekst.instanceplaybacker.model.data.SoundData;

import java.util.HashMap;
import java.util.Map;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class SoundDataMap implements SoundDataRepository {
    private final Map<Integer, SoundData> map = new HashMap<>();

    @Override
    public void put(SoundData soundData) {
        map.put(soundData.getId(), soundData);
    }

    @Override
    public SoundData getSoundData(int id) {
        return map.get(id);
    }
}
