package com.ottfoekst.instanceplaybacker.model.repository;

import com.ottfoekst.instanceplaybacker.model.data.SoundData;

public interface SoundDataRepository {
    void put(SoundData soundData);
    SoundData getSoundData(int id);
}
