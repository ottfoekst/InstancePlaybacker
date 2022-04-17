package com.ottfoekst.instanceplaybacker.model.repository;

import com.ottfoekst.instanceplaybacker.model.data.SoundData;

import java.util.HashMap;
import java.util.Map;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class SoundDataMap implements SoundDataRepository {
    private final Map<String, SoundData> map = new HashMap<>();

    @Override
    public SoundData getSoundData(String name) {
        return map.get(name);
    }
}
